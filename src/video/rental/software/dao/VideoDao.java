/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video.rental.software.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import video.rental.software.config.SqlConnection;
import video.rental.software.model.Grid;
import video.rental.software.model.Video;
import video.rental.software.model.VideoTranaction;

/**
 *
 * @author vimal
 */
public class VideoDao {

    static final Logger logger = Logger.getLogger(CustomerDao.class.getName());

    private Connection connection;
    private PreparedStatement statement;
    ResultSet resultSet = null;

    public VideoDao() {
        try {
            this.connection = SqlConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Video findVideoById(Long videoId) throws SQLException {
        logger.log(Level.INFO, "Inside findVideoById {0}", videoId);
        Video video = new Video();
        String query = "select * from video vd where vd.video_id=?";
        try {
            statement = connection.prepareStatement(query);
            statement.setLong(1, videoId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                video.setVideoId(resultSet.getLong("video_id"));
                video.setAuthorName(resultSet.getString("author_name"));
                video.setQuantity(resultSet.getInt("quantity"));
                video.setLanguage(resultSet.getString("language"));
                video.setVideoType(resultSet.getLong("type"));
                video.setPrice(resultSet.getFloat("price"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VideoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }

        return video;
    }

    public List<Video> findAllVideoByName(String videoName) throws SQLException {
        logger.log(Level.INFO, "Inside findVideoByName {0}", videoName);
        List<Video> videoList = new ArrayList<>();
        Video video;
        StringBuilder queryParam = new StringBuilder();
        queryParam.append("%").append(videoName).append("%");
        //queryParam.append(videoName);
        String query = "select * from video vd where vd.video_name COLLATE UTF8_GENERAL_CI LIKE ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, queryParam.toString());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                video = new Video();
                video.setVideoId(resultSet.getLong("video_id"));
                video.setVideoName(resultSet.getString("video_name"));
                video.setAuthorName(resultSet.getString("author_name"));
                video.setQuantity(resultSet.getInt("quantity"));
                video.setPublishedYear(resultSet.getInt("published_year"));
                video.setLanguage(resultSet.getString("language"));
                video.setVideoType(resultSet.getLong("type"));
                video.setPrice(resultSet.getFloat("price"));
                videoList.add(video);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VideoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
        logger.log(Level.INFO, "Video List count {0}", videoList);
        return videoList;
    }

    public Video createVideo(Video video) throws SQLException {
        logger.log(Level.INFO, "Inside createCustomer {0}", video);
        String query = "INSERT INTO video(author_name,quantity,published_year,language,type,price) VALUES (?,?,?,?,?,?)";
        int numRowsAffected = 0;
        try {
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, video.getAuthorName());
            statement.setInt(2, video.getQuantity());
            statement.setInt(3, video.getPublishedYear());
            statement.setLong(4, video.getVideoType());
            statement.setFloat(5, video.getPrice());

            numRowsAffected = statement.executeUpdate();
            logger.log(Level.INFO, "No records created {0}", numRowsAffected);
            try (ResultSet rs = statement.getGeneratedKeys()) {
                if (rs.next()) {
                    video.setVideoId(rs.getLong(1));
                }
            } catch (SQLException s) {
                logger.log(Level.SEVERE, null, s);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }

        return video;
    }

    public boolean rentVideo(List<Video> videoList, Long userId) throws SQLException {
        logger.log(Level.INFO, "Inside the rentVideo batch update for user ID {0}", userId);
        String sqlQuery = "insert into video_transaction(video_id,user_id,rent_date,return_status) values (?,?,?,?)";
        Boolean status = false;
        try {
            statement = connection.prepareStatement(sqlQuery);

            for (Video video : videoList) {
                statement.setLong(1, video.getVideoId());
                statement.setLong(2, userId);
                statement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                statement.setBoolean(4, false);
                statement.addBatch();
            }
            int[] result = statement.executeBatch();
            logger.log(Level.INFO, "The number of rows inserted:{0}", result.length);
            status = true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);

        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return status;
    }
    
    
    public List<Grid> findAllVideoTakenByUser(String userId) throws SQLException {
        logger.log(Level.INFO, "Inside findAllVideoTakenByUser {0}", userId);
        List<Grid> gridList = new ArrayList<>();
        Grid grid;
        String query = "select vd.video_id,vd.video_name,vd.author_name from video vd,video_transaction tx where vd.video_id=tx.video_id and tx.user_id=?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, userId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                grid = new Grid();
                Long videoId = resultSet.getLong("video_id");
                grid.setVideoId(String.valueOf(videoId));
                grid.setVideoName(resultSet.getString("video_name"));
                grid.setAuthorName(resultSet.getString("author_name"));
                gridList.add(grid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VideoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
        logger.log(Level.INFO, "findAllVideoTakenByUser transaction List ", gridList);
        return gridList;
    }
    
}