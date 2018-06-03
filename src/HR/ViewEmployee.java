
package HR;

import Classes.Employee;
import db.dbconnct;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Shanika
 */
public class ViewEmployee extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewEmployee
     */
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs = null;
    
    Employee e = new Employee();
    
    public ViewEmployee() {
        initComponents();
        
        conn=dbconnct.connect();
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        emptable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        sbox = new javax.swing.JTextField();
        schoose = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("View Employee");

        emptable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Birthday", "Status", "Email", "Designation", "Type", "Joined date", "NIC", "Department", "Address", "Phone No"
            }
        ));
        emptable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emptableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(emptable);

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel2.setText("View by : ");

        sbox.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        sbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sboxActionPerformed(evt);
            }
        });

        schoose.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        schoose.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EmpID", "Fname", "Lname", "NIC", "Designation" }));

        jButton1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anu\\AppData\\Local\\Temp\\icons8_Search_26px_2.png")); // NOI18N
        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1108, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(sbox, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(schoose, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(schoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emptableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emptableMouseClicked


    }//GEN-LAST:event_emptableMouseClicked

    private void sboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(sbox.getText().isEmpty())
        JOptionPane.showMessageDialog(null,"This field cannot be empty!");
        else{
            String v = sbox.getText();
            String ch = schoose.getSelectedItem().toString();

            switch(ch){
                case "EmpID":
                String sq4 = "SELECT `First_name`, `Last_name`, `Birthday`, `Civil_status`, `Email`, `Designation`, `Emp_type`, `Joined_date`, `NIC`, `Department`, `Address`, `Phone_no` FROM employee WHERE Employee_ID LIKE '%"+ v +"%'";

                try {
                    pst = conn.prepareStatement(sq4);
                    pst.execute();
                    rs=pst.executeQuery();

                    emptable.setModel(DbUtils.resultSetToTableModel(rs));

                }
                catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Incorrect Value"+ex);
                }
                break;
                case "Fname":
                String sq3 = "SELECT `First_name`, `Last_name`, `Birthday`, `Civil_status`, `Email`, `Designation`, `Emp_type`, `Joined_date`, `NIC`, `Department`, `Address`, `Phone_no` FROM employee WHERE First_name LIKE '%"+ v +"%'";

                try {
                    pst = conn.prepareStatement(sq3);
                    pst.execute();
                    rs=pst.executeQuery();

                    emptable.setModel(DbUtils.resultSetToTableModel(rs));

                }
                catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Incorrect Value"+ex);
                }
                break;
                case "Lname":
                String sq2 = "SELECT `First_name`, `Last_name`, `Birthday`, `Civil_status`, `Email`, `Designation`, `Emp_type`, `Joined_date`, `NIC`, `Department`, `Address`, `Phone_no` FROM employee WHERE Last_name LIKE '%"+ v +"%'";

                try {
                    pst = conn.prepareStatement(sq2);
                    pst.execute();
                    rs=pst.executeQuery();

                    emptable.setModel(DbUtils.resultSetToTableModel(rs));

                }
                catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Incorrect Value"+ex);
                }
                break;
                case "Designation":
                String sq1 = "SELECT `First_name`, `Last_name`, `Birthday`, `Civil_status`, `Email`, `Designation`, `Emp_type`, `Joined_date`, `NIC`, `Department`, `Address`, `Phone_no` FROM employee WHERE Designation LIKE '%"+ v +"%'";

                try {
                    pst = conn.prepareStatement(sq1);
                    pst.execute();
                    rs=pst.executeQuery();

                    emptable.setModel(DbUtils.resultSetToTableModel(rs));

                }
                catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Incorrect Value"+ex);
                }
                break;
                case "NIC":
                String sq = "SELECT `First_name`, `Last_name`, `Birthday`, `Civil_status`, `Email`, `Designation`, `Emp_type`, `Joined_date`, `NIC`, `Department`, `Address`, `Phone_no` FROM employee WHERE NIC LIKE '%"+ v +"%'";

                try {
                    pst = conn.prepareStatement(sq);
                    pst.execute();
                    rs=pst.executeQuery();

                    emptable.setModel(DbUtils.resultSetToTableModel(rs));

                }
                catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Incorrect Value"+ex);
                }
                break;
            }
    }//GEN-LAST:event_jButton1ActionPerformed
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable emptable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField sbox;
    private javax.swing.JComboBox schoose;
    // End of variables declaration//GEN-END:variables
}