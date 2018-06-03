/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;


import CarPark_Interfaces.*;
import Entertain.administratorinterface;
import Event_Interfaces.Main;
import HR.*;
import TandIn.Transportation;
import cmanager.cmanagermain;
import financemanagement.*;
import itp.FloorManagement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 *
 * @author Shanika
 */
public class AdminInterface extends javax.swing.JFrame {

    /**
     * Creates new form AdminInterface
     */
    public AdminInterface() {
        initComponents();
        
        //Show current date
        showdate();
        
        //show current time
        showtime();
    }
    
    void showdate(){
        
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        datelabel.setText(s.format(d));
    }
    
    void showtime(){
        
        Date d = new Date();
        
        final DateFormat timeF = new SimpleDateFormat("HH:mm:ss");
        ActionListener timel = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Date d = new Date();
                String time = timeF.format(d);
                timelabel.setText(time);
            }
        };
        
        Timer timer = new Timer(1000, timel);
        timer.setInitialDelay(0);
        timer.start();
        
        
        
    }                
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parent = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        dashboard = new javax.swing.JPanel();
        dsidepane = new javax.swing.JPanel();
        finance = new javax.swing.JButton();
        maint = new javax.swing.JButton();
        HR = new javax.swing.JButton();
        customer = new javax.swing.JButton();
        event = new javax.swing.JButton();
        trans = new javax.swing.JButton();
        gameZ = new javax.swing.JButton();
        carP = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        userM = new javax.swing.JPanel();
        usidepane = new javax.swing.JPanel();
        addu = new javax.swing.JButton();
        delu = new javax.swing.JButton();
        viewu = new javax.swing.JButton();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        logoutb = new javax.swing.JButton();
        datelabel = new javax.swing.JLabel();
        timelabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        parent.setBackground(new java.awt.Color(0, 153, 153));

        jTabbedPane1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        finance.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        finance.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anu\\AppData\\Local\\Temp\\icons8_Money_Bag_26px.png")); // NOI18N
        finance.setText("Finance ");
        finance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                financeActionPerformed(evt);
            }
        });

        maint.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        maint.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anu\\AppData\\Local\\Temp\\icons8_Maintenance_26px.png")); // NOI18N
        maint.setText("Maintenance");
        maint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maintActionPerformed(evt);
            }
        });

        HR.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        HR.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anu\\AppData\\Local\\Temp\\icons8_Conference_26px.png")); // NOI18N
        HR.setText("HR Management");
        HR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HRActionPerformed(evt);
            }
        });

        customer.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        customer.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anu\\AppData\\Local\\Temp\\icons8_Meeting_26px.png")); // NOI18N
        customer.setText("Customer");
        customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerActionPerformed(evt);
            }
        });

        event.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        event.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anu\\AppData\\Local\\Temp\\icons8_Schedule_26px.png")); // NOI18N
        event.setText("Event/ Ad");
        event.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventActionPerformed(evt);
            }
        });

        trans.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        trans.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anu\\AppData\\Local\\Temp\\icons8_In_Transit_26px.png")); // NOI18N
        trans.setText("Trans/ Inventory");
        trans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transActionPerformed(evt);
            }
        });

        gameZ.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        gameZ.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anu\\AppData\\Local\\Temp\\icons8_Game_Controller_26px.png")); // NOI18N
        gameZ.setText("Entertainment");
        gameZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameZActionPerformed(evt);
            }
        });

        carP.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        carP.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anu\\AppData\\Local\\Temp\\icons8_Car_26px.png")); // NOI18N
        carP.setText("Car Park");
        carP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dsidepaneLayout = new javax.swing.GroupLayout(dsidepane);
        dsidepane.setLayout(dsidepaneLayout);
        dsidepaneLayout.setHorizontalGroup(
            dsidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(trans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(customer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(maint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(finance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(HR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(event, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(carP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(gameZ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dsidepaneLayout.setVerticalGroup(
            dsidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dsidepaneLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(HR, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(finance, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(maint, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(customer, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(trans, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(event, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gameZ, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(carP, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1182, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addComponent(dsidepane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dsidepane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        jTabbedPane1.addTab("DashBoard", dashboard);

        addu.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        addu.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anu\\AppData\\Local\\Temp\\icons8_Add_User_Male_26px_1.png")); // NOI18N
        addu.setText("Add User");
        addu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adduActionPerformed(evt);
            }
        });

        delu.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        delu.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anu\\AppData\\Local\\Temp\\icons8_Denied_26px.png")); // NOI18N
        delu.setText("Delete User");
        delu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deluActionPerformed(evt);
            }
        });

        viewu.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        viewu.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anu\\AppData\\Local\\Temp\\icons8_Find_User_Male_26px_1.png")); // NOI18N
        viewu.setText("View Users");
        viewu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout usidepaneLayout = new javax.swing.GroupLayout(usidepane);
        usidepane.setLayout(usidepaneLayout);
        usidepaneLayout.setHorizontalGroup(
            usidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(delu, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
            .addComponent(viewu, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
        );
        usidepaneLayout.setVerticalGroup(
            usidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usidepaneLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(addu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(delu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(viewu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1166, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout userMLayout = new javax.swing.GroupLayout(userM);
        userM.setLayout(userMLayout);
        userMLayout.setHorizontalGroup(
            userMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userMLayout.createSequentialGroup()
                .addComponent(usidepane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        userMLayout.setVerticalGroup(
            userMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(usidepane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(userMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("User Management", userM);

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("SQUARE GARDEN MALL (PVT) LTD");

        logoutb.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        logoutb.setText("Logout");
        logoutb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbActionPerformed(evt);
            }
        });

        datelabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        datelabel.setName("datel"); // NOI18N

        timelabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        timelabel.setName("datel"); // NOI18N

        javax.swing.GroupLayout parentLayout = new javax.swing.GroupLayout(parent);
        parent.setLayout(parentLayout);
        parentLayout.setHorizontalGroup(
            parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(332, 332, 332)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutb, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addComponent(jTabbedPane1)
        );
        parentLayout.setVerticalGroup(
            parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, parentLayout.createSequentialGroup()
                .addGroup(parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(parentLayout.createSequentialGroup()
                        .addContainerGap(17, Short.MAX_VALUE)
                        .addGroup(parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logoutb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18))
                    .addGroup(parentLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(timelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gameZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameZActionPerformed
        // TODO add your handling code here:
        
        administratorinterface ad = new administratorinterface();
        ad.setVisible(true);
    }//GEN-LAST:event_gameZActionPerformed

    private void adduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adduActionPerformed
        // TODO add your handling code here:
        AddUser au = new AddUser();
        jDesktopPane2.add(au).setVisible(true);
    }//GEN-LAST:event_adduActionPerformed

    private void deluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deluActionPerformed
        // TODO add your handling code here:
        DeleteUser du = new DeleteUser();
        jDesktopPane2.add(du).setVisible(true);
    }//GEN-LAST:event_deluActionPerformed

    private void viewuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewuActionPerformed
        // TODO add your handling code here:
        ViewUser vu = new ViewUser();
        jDesktopPane2.add(vu).setVisible(true);
    }//GEN-LAST:event_viewuActionPerformed

    private void HRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HRActionPerformed
      
       MainInterface hr = new MainInterface();
       hr.setVisible(true);
    }//GEN-LAST:event_HRActionPerformed

    private void eventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventActionPerformed
      Main eve = new Main();

     eve.setVisible(true);

      // eve.setVisible(true);

    }//GEN-LAST:event_eventActionPerformed

    private void logoutbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbActionPerformed
        this.dispose();
        MainLogin ml = new MainLogin();
        ml.setVisible(true);
    }//GEN-LAST:event_logoutbActionPerformed

    private void financeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_financeActionPerformed
        
        Mainframe fin = new Mainframe();
        fin.setVisible(true);
    }//GEN-LAST:event_financeActionPerformed

    private void maintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maintActionPerformed
       FloorManagement fl = new FloorManagement();
       fl.setVisible(true);
    }//GEN-LAST:event_maintActionPerformed

    private void customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerActionPerformed
                    cmanagermain cus = new cmanagermain();
                    cus.setVisible(true);
    }//GEN-LAST:event_customerActionPerformed

    private void transActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transActionPerformed
       Transportation trans = new Transportation();
       trans.setVisible(true);
    }//GEN-LAST:event_transActionPerformed

    private void carPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carPActionPerformed
        V_Pasrk_Managenent car = new V_Pasrk_Managenent();
                    car.setVisible(true);
    }//GEN-LAST:event_carPActionPerformed

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
            java.util.logging.Logger.getLogger(AdminInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try{
             UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
         }
         catch(Exception e){
             e.printStackTrace();
         }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HR;
    private javax.swing.JButton addu;
    private javax.swing.JButton carP;
    private javax.swing.JButton customer;
    private javax.swing.JPanel dashboard;
    private javax.swing.JLabel datelabel;
    private javax.swing.JButton delu;
    private javax.swing.JPanel dsidepane;
    private javax.swing.JButton event;
    private javax.swing.JButton finance;
    private javax.swing.JButton gameZ;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logoutb;
    private javax.swing.JButton maint;
    private javax.swing.JPanel parent;
    private javax.swing.JLabel timelabel;
    private javax.swing.JButton trans;
    private javax.swing.JPanel userM;
    private javax.swing.JPanel usidepane;
    private javax.swing.JButton viewu;
    // End of variables declaration//GEN-END:variables
}
