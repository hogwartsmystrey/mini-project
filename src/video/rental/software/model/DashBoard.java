/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video.rental.software.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anjana
 */
public class DashBoard {

    private int type;
    private String mobileNumber;
    private List<VideoTranaction> transactionList;
    private List<Video> videoList;
    private List<Grid> gridList;

    public DashBoard() {
        this.transactionList = new ArrayList<>();
        this.videoList = new ArrayList<>();
        this.gridList = new ArrayList<>();
    }

    public List<VideoTranaction> getTransactionList() {
        return transactionList;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
