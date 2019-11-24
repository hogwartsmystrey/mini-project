/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video.rental.software.ui;


import com.mysql.cj.util.StringUtils;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import video.rental.software.dao.CustomerDao;
import video.rental.software.dao.VideoDao;
import video.rental.software.model.Customer;
import video.rental.software.model.DashBoard;
import video.rental.software.model.Grid;
import video.rental.software.util.VideoUtil;

/**
 *
 * @author anjana sree
 */
public class Home extends javax.swing.JFrame {
    private static JFrame jFrameHome;
    private String searchType;
    private DashBoard dashboard= new DashBoard();
    private CustomerDao customerDao=new CustomerDao();
    private VideoDao videoDao= new VideoDao();
    List<Grid> gridList=new ArrayList<>();

    /**
     * Creates new form HOMEPAGE
     */
    public Home() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGrid = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        JButtonUser = new javax.swing.JButton();
        jButtonVideo = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jButtonRent = new javax.swing.JButton();
        jButtonReturn = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1700, 700));

        jTableGrid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableGrid.setRowHeight(50);
        jScrollPane1.setViewportView(jTableGrid);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        JButtonUser.setBackground(new java.awt.Color(255, 255, 255));
        JButtonUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JButtonUser.setForeground(new java.awt.Color(51, 153, 255));
        JButtonUser.setText("User");
        JButtonUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JButtonUser.setPreferredSize(new java.awt.Dimension(67, 51));
        JButtonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonUserActionPerformed(evt);
            }
        });

        jButtonVideo.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVideo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonVideo.setForeground(new java.awt.Color(51, 153, 255));
        jButtonVideo.setText("Video");
        jButtonVideo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonVideo.setPreferredSize(new java.awt.Dimension(67, 51));
        jButtonVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVideoActionPerformed(evt);
            }
        });

        jTextFieldSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSearch.setNextFocusableComponent(jButtonSearch);
        jTextFieldSearch.setPreferredSize(new java.awt.Dimension(61, 51));
        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });

        jButtonSearch.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonSearch.setForeground(new java.awt.Color(51, 153, 255));
        jButtonSearch.setText("Search");
        jButtonSearch.setNextFocusableComponent(jTableGrid);
        jButtonSearch.setPreferredSize(new java.awt.Dimension(61, 51));
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jButtonRent.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRent.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonRent.setForeground(new java.awt.Color(51, 153, 255));
        jButtonRent.setText("Rent");
        jButtonRent.setPreferredSize(new java.awt.Dimension(61, 51));
        jButtonRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRentActionPerformed(evt);
            }
        });

        jButtonReturn.setBackground(new java.awt.Color(255, 255, 255));
        jButtonReturn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonReturn.setForeground(new java.awt.Color(51, 153, 255));
        jButtonReturn.setText("Return");
        jButtonReturn.setPreferredSize(new java.awt.Dimension(67, 51));
        jButtonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRent, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButtonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(JButtonUser, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButtonVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JButtonUser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButtonVideo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonRent, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchActionPerformed

    private void jButtonVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVideoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVideoActionPerformed

    private void JButtonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonUserActionPerformed
        // TODO add your handling code here:
        JFrame frm2 = new User();
        frm2.dispatchEvent(new WindowEvent(frm2, WindowEvent.COMPONENT_SHOWN));
        frm2.setSize(1800, 800);
        frm2.setVisible(true);
        jFrameHome.setVisible(false); 
        jFrameHome.dispose();
    }//GEN-LAST:event_JButtonUserActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        try {
            String searchText = jTextFieldSearch.getText();
            List<video.rental.software.model.Video> videoList = null;
            gridList.clear();
            dashboard.getVideoList().clear();

            if (!StringUtils.isEmptyOrWhitespaceOnly(searchText)) {
                if (VideoUtil.checkMobileNumber(searchText)) {
                    Logger.getLogger(Home.class.getName()).log(Level.INFO, "Inside the Tranasaction search");
                    searchType="Return";
                    Customer customer = customerDao.findCustomerByMobileNumber(searchText);
                    if (customer != null) {
                        gridList = videoDao.findAllVideoTakenByUser(customer.getCustomerId().toString());
                    }
                } else {
                    Logger.getLogger(Home.class.getName()).log(Level.INFO, "Inside the Video search");
                    searchType="Rent";
                    videoList = videoDao.findAllVideoByName(searchText);
                    if (null != videoList && !videoList.isEmpty()) {
                        dashboard.getVideoList().addAll(videoList);
                    }
                    gridList = VideoUtil.transformDashBoradToGrid(dashboard);
                }
            }
            if (null == gridList || gridList.isEmpty()) {
                gridList = new ArrayList<>();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = (DefaultTableModel) jTableGrid.getModel();
        model.setRowCount(gridList.size());
        int row = 0;
        for (Grid data : gridList) {
            model.setValueAt(data.getVideoId(), row, 0);
            model.setValueAt(data.getVideoName(), row, 1);
            row++;
        }
        jTableGrid.setModel(model);
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRentActionPerformed
        // TODO add your handling code here:
        if (null == gridList || gridList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Search any videos to rent");
        } else if(!"Rent".equalsIgnoreCase(searchType)) {
            JOptionPane.showMessageDialog(null, "User is not allowed to Rent only Return is possible");
        }else{
            JFrame frm2 = new RentOut(gridList);
            frm2.dispatchEvent(new WindowEvent(frm2, WindowEvent.COMPONENT_SHOWN));
            frm2.setSize(1700, 700);
            frm2.setVisible(true);
            jFrameHome.setVisible(false);
            jFrameHome.dispose();
        }
    }//GEN-LAST:event_jButtonRentActionPerformed

    private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReturnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReturnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                javax.swing.JPanel panel = new javax.swing.JPanel();
                panel.setPreferredSize(new Dimension(1700, 700));
                jFrameHome = new Home();
                jFrameHome.add(panel);
                jFrameHome.pack();
                jFrameHome.setMaximumSize(new Dimension(1700, 700));                         
                jFrameHome.setResizable(false);
                jFrameHome.setVisible(true);                           
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonUser;
    private javax.swing.JButton jButtonRent;
    private javax.swing.JButton jButtonReturn;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonVideo;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGrid;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}

