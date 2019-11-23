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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import video.rental.software.config.SqlConnection;
import static video.rental.software.dao.CustomerDao.logger;
import video.rental.software.model.Customer;
import video.rental.software.model.Video;

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
                video.setVideoType(resultSet.getLong("video_type"));
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
        String query = "select * from video vd where vd.video_name like ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, queryParam.toString());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                video = new Video();
                video.setVideoId(resultSet.getLong("video_id"));
                video.setAuthorName(resultSet.getString("author_name"));
                video.setQuantity(resultSet.getInt("quantity"));
                video.setPublishedYear(resultSet.getInt("published_year"));
                video.setLanguage(resultSet.getString("language"));
                video.setVideoType(resultSet.getLong("video_type"));
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

        return videoList;
    }
    
        
}
