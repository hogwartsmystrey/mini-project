/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video.rental.software.dao;

import com.mysql.cj.util.StringUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import video.rental.software.config.SqlConnection;
import video.rental.software.model.Customer;

/**
 *
 * @author pvr2
 */
public class CustomerDao {

    static final Logger logger = Logger.getLogger(CustomerDao.class.getName());

    private Connection connection;
    private PreparedStatement statement;
    ResultSet resultSet = null;

    public CustomerDao() {
        try {
            this.connection = SqlConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Customer findCustomerByMobileNumber(String mobileNumber) throws SQLException {
        logger.log(Level.INFO, "Inside findCustomerByMobileNumber {0}", mobileNumber);

        Customer customer = null;
        String query = "select * from customer cus where cus.mobile_number=?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, mobileNumber);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerId(resultSet.getLong("customer_id"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setMobileNumber(resultSet.getString("mobile_number"));
                customer.setEmailId(resultSet.getString("email_id"));
                customer.setIdType(resultSet.getLong("id_type"));
                customer.setIdNumber(resultSet.getString("id_number"));

            }
        } catch (SQLException ex) {
            logger.log(Level.INFO, "Inside findCustomerByMobileNumber {0}", mobileNumber);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
      logger.log(Level.INFO, "Got customer {0}", customer);
        return customer;
    }

    public List<Customer> searchCustomerByMobileNumber(String mobileNumber) throws SQLException {
        logger.log(Level.INFO, "Inside findCustomerByMobileNumber {0}", mobileNumber);
        List<Customer> customerList = new ArrayList<>();
        Customer customer;
        String query = "select * from customer cus where cus.mobile_number like ?";
        try {
            statement = connection.prepareStatement(query);
            StringBuilder queryParam = new StringBuilder();
            queryParam.append("%").append(mobileNumber).append("%");
            statement.setString(1, queryParam.toString());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerId(resultSet.getLong("customer_id"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setMobileNumber(resultSet.getString("mobile_number"));
                customer.setEmailId(resultSet.getString("email_id"));
                customer.setIdType(resultSet.getLong("id_type"));
                customer.setIdNumber(resultSet.getString("id_number"));
                customerList.add(customer);
            }
        } catch (SQLException ex) {
            logger.log(Level.INFO, "Inside findCustomerByMobileNumber {0}", mobileNumber);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }

        return customerList;
    }

    public Customer createCustomer(Customer customer) throws SQLException {
        logger.log(Level.INFO, "Inside createCustomer {0}", customer);
        String query = "INSERT INTO customer(customer_name,mobile_number,email_id,id_type,id_number,address) VALUES (?,?,?,?,?,?)";
        int numRowsAffected = 0;
        try {
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getCustomerName());
            statement.setString(2, customer.getMobileNumber());
            statement.setString(3, customer.getEmailId());
            statement.setLong(4, customer.getIdType() == null ? 0 : customer.getIdType());
            statement.setString(5, StringUtils.isNullOrEmpty(customer.getIdNumber()) ? "" : customer.getIdNumber().trim());
            statement.setString(6, StringUtils.isNullOrEmpty(customer.getAddress()) ? "" : customer.getAddress().trim());
            numRowsAffected = statement.executeUpdate();
            logger.log(Level.INFO, "No records created {0}", numRowsAffected);
            try (ResultSet rs = statement.getGeneratedKeys()) {
                if (rs.next()) {
                    customer.setCustomerId(rs.getLong(1));
                }
            } catch (SQLException s) {
                Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }

        return customer;
    }
    

}