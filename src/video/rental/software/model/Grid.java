/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video.rental.software.model;

import java.util.Date;

/**
 *
 * @author anjana
 */
public class Grid {
    
    private boolean select;
    private String tranactionId;
    private String videoId;
    private String videoName;
    private String authorName;
    private String mobileNumber;
    private String userName;
    private String price;
    private Date rentedDate;

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String getTranactionId() {
        return tranactionId;
    }

    public void setTranactionId(String tranactionId) {
        this.tranactionId = tranactionId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getRentedDate() {
        return rentedDate;
    }

    public void setRentedDate(Date rentedDate) {
        this.rentedDate = rentedDate;
    }

    @Override
    public String toString() {
        return "Grid{" + "select=" + select + ", tranactionId=" + tranactionId + ", videoId=" + videoId + ", videoName=" + videoName + ", authorName=" + authorName + ", mobileNumber=" + mobileNumber + ", userName=" + userName + ", price=" + price + ", rentedDate=" + rentedDate + '}';
    }

   

  
    
}
