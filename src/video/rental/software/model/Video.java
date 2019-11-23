/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video.rental.software.model;

/**
 *
 * @author vimal
 */
public class Video {

    private Long videoId;
    private String videoName;
    private String authorName;
    private Integer quantity;
    private Integer publishedYear;
    private String language;
    private Long videoType;
    private Float price;

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getVideoType() {
        return videoType;
    }

    public void setVideoType(Long videoType) {
        this.videoType = videoType;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Video{" + "videoId=" + videoId + ", videoName=" + videoName + ", authorName=" + authorName + ", quantity=" + quantity + ", publishedYear=" + publishedYear + ", language=" + language + ", videoType=" + videoType + ", price=" + price + '}';
    }

}
