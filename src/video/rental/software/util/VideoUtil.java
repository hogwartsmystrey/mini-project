/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video.rental.software.util;

import java.util.ArrayList;
import java.util.List;
import video.rental.software.model.DashBoard;
import video.rental.software.model.Grid;
import video.rental.software.model.Video;

/**
 *
 * @author vimal
 */
public class VideoUtil {

    public static List<Grid> transformDashBoradToGrid(DashBoard dashboard) {

        List<Grid> gridList = new ArrayList<>();
        Grid grid;
        if (null != dashboard && null != dashboard.getVideoList() && !dashboard.getVideoList().isEmpty()) {
            for (Video video : dashboard.getVideoList()) {
                grid = new Grid();
                grid.setVideoName(video.getVideoName());
                grid.setVideoId(video.getVideoId().toString());
                grid.setAuthorName(video.getAuthorName());
                gridList.add(grid);
            }
        }
        return gridList;
    }

    public static boolean checkNumericString(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
