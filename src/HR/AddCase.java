/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HR;

import Classes.HRmanager;
import Classes.Validation;
import Classes.discase;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Shanika
 */
public class AddCase extends javax.swing.JInternalFrame {

    //Creates a discase object
    discase c1 = new discase();
    
    //Creates a HRmanager object
    HRmanager h = new HRmanager();
    
    //Creates a validation class object
    Validation v= new Validation();
    
    public AddCase() {
        initComponents();
        
         //changes the form background color according to time
        Date d = new Date();
        String amPm = new SimpleDateFormat("aa").format(d);
        
        if(amPm.equals("PM")){
        getContentPane().setBackground(Color.lightGray);
        }
        else
          getContentPane().setBackground(Color.decode("#F5F5F5"));  
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        eid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ename = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ecasename = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        edes = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        ecreatedby = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        estat = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        ecreatedon = new com.toedter.calendar.JDateChooser();
        edep = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Add Case");

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLabel1.setText("Employee ID :");

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLabel2.setText("Name :");

        ename.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                enameKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLabel4.setText("Case name :");

        ecasename.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ecasenameKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLabel5.setText("Description :");

        edes.setColumns(20);
        edes.setRows(5);
        jScrollPane1.setViewportView(edes);

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLabel6.setText("Created by :");

        ecreatedby.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ecreatedbyKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLabel7.setText("Created on :");

        estat.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        estat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Checked", "Pending", " " }));

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLabel3.setText("Status :");

        jButton2.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anu\\AppData\\Local\\Temp\\icons8_Add_New_26px.png")); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jLabel8.setText("Department : ");

        jButton3.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ecreatedon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ecreatedonKeyTyped(evt);
            }
        });

        edep.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        edep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select Department--", "Human Resource", "Finance", "Floor", "Customer", "Inventory", "Event", "Entertainment", "Car Park" }));

        jButton4.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jButton4.setText("Demo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ecasename, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(eid, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(ename)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ecreatedon, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(ecreatedby))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edep, 0, 161, Short.MAX_VALUE)
                            .addComponent(estat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(eid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(edep, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(estat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ecasename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ecreatedby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(ecreatedon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
        
        if(eid.getText().isEmpty() || ecasename.getText().isEmpty() || ename.getText().isEmpty() || edes.getText().isEmpty() || ecreatedby.getText().isEmpty() || edep.getSelectedItem().toString().isEmpty() || ecreatedon.getDate().toString().isEmpty() || estat.getSelectedItem().toString().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please fill all the fields");
        }
        else{
        
        c1.empID = eid.getText();
        c1.casename = ecasename.getText();
        c1.name = ename.getText();
        c1.desc = edes.getText();
        c1.createdby = ecreatedby.getText();
       
        c1.createdon = d.format(ecreatedon.getDate());       
        c1.dep = edep.getSelectedItem().toString();
        c1.status = estat.getSelectedItem().toString();
        
        System.out.println(v.IsDateToday(ecreatedon.getDate().toString()));
                
       // if(v.IsDateToday(ecreatedon.getDate().toString()))
         //   JOptionPane.showMessageDialog(null,"Check entered date!");
            
            
            h.addcase(c1.empID,c1.casename,c1.name,c1.desc,c1.createdby,c1.createdon,c1.dep,c1.status);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        eid.setText("");
        ecasename.setText("");
        ename.setText("");
        edes.setText("");
        ecreatedby.setText("");
        ecreatedon.setDate(null);
        edep.setSelectedIndex(0);
        estat.setSelectedIndex(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void enameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enameKeyTyped
        
        char c=evt.getKeyChar();

        if(!(Character.isAlphabetic(c) ||  c==KeyEvent.VK_DELETE )){
        evt.consume();
        JOptionPane.showMessageDialog(null,"Numbers are not allowed in this field!");
        }
    }//GEN-LAST:event_enameKeyTyped

    private void ecasenameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ecasenameKeyTyped
       
        char c=evt.getKeyChar();

       if(!(Character.isAlphabetic(c) ||  c==KeyEvent.VK_DELETE )){
        evt.consume();
        JOptionPane.showMessageDialog(null,"Numbers are not allowed in this field!");
        }
    }//GEN-LAST:event_ecasenameKeyTyped

    private void ecreatedbyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ecreatedbyKeyTyped
        
        char c=evt.getKeyChar();

        if(!(Character.isAlphabetic(c) ||  c==KeyEvent.VK_DELETE )){
        evt.consume();
        JOptionPane.showMessageDialog(null,"Numbers are not allowed in this field!");
        }
    }//GEN-LAST:event_ecreatedbyKeyTyped

    private void ecreatedonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ecreatedonKeyTyped
        
        
       
    }//GEN-LAST:event_ecreatedonKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        eid.setText("E024");
        ecasename.setText("Stolen Property");
        ename.setText("Dulika");
        edes.setText("Clerk");
        ecreatedby.setText("Admin");
        ecreatedon.setDate(null);
        edep.setSelectedIndex(2);
        estat.setSelectedIndex(1);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ecasename;
    private javax.swing.JTextField ecreatedby;
    private com.toedter.calendar.JDateChooser ecreatedon;
    private javax.swing.JComboBox edep;
    private javax.swing.JTextArea edes;
    private javax.swing.JTextField eid;
    private javax.swing.JTextField ename;
    private javax.swing.JComboBox estat;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
