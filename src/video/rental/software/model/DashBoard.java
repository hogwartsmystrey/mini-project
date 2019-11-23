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
 * @author vimal
 */
public class DashBoard {
    
    private int type;
    private List<Customer> customerList;
    private List<Video> videoList;

    public DashBoard() {
        this.customerList = new ArrayList<>();
        this.videoList = new ArrayList<>();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public List<Video> getVideoList() {
        return videoList;
    } 

}
