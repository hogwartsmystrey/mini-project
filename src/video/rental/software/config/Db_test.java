/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video.rental.software.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import video.rental.software.dao.CustomerDao;
import video.rental.software.dao.VideoDao;
import video.rental.software.model.Customer;
import video.rental.software.model.Video;

/**
 *
 * @author vimal
 */
public class Db_test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        // for (int i = 0; i < 100; i++) {
        Connection connection = SqlConnection.getConnection();
        String query = "SELECT * FROM customer";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        CustomerDao customerDao = new CustomerDao();
        VideoDao videodao = new VideoDao();
        Customer customer= new Customer();
        
        List<Video> videoList = videodao.findAllVideoByName("he");
        System.out.println("Video List"+videoList.size());
        
//        customer.setMobileNumber("9551122222");
//        customer.setEmailId("test@gmail.com");
//        customer.setCustomerName("kalpana");
//        //customer = customerDao.createCustomer(customer);
//        System.out.println("Customer created "+customer.getCustomerId());
        SqlConnection.closeConnection(connection);
//        try {
//            statement = connection.prepareStatement(query);
//            resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                Long customerId = resultSet.getLong("customer_id");
//                String mobileNumber = resultSet.getString("mobile_number");
//                System.out.println("Customer ID " + customerId + " AND Mobile Number is " + mobileNumber);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Db_test.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (statement != null) {
//                statement.close();
//            }
//            if (resultSet != null) {
//                resultSet.close();
//            }
//            SqlConnection.closeConnection();
//        }
    }
    //}

}