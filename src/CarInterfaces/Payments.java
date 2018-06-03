
package CarInterfaces;

import CarClasses.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class Payments extends javax.swing.JInternalFrame {

             Connection conn = null;
             PreparedStatement pst = null;
             ResultSet rs = null;
             
       
        //creates paymentsc object 
             Paymentsc p = new Paymentsc();
             
             Memberc m = new Memberc();
             
             Conver_Vali v = new Conver_Vali();
             
             
             DecimalFormat DF = new DecimalFormat("#####.00");
            
    
    
    public Payments() {
        initComponents();
        
        conn = dbconnct.connect(); 
        
         tableLoad();
        
    }
    
    
     public void tableLoad()
     {
            try 
            {
                String sql = "SELECT mid as MID,name as Name,NIC,vehilicense as Plate_No,vehicat as Category,package as Package FROM member where paystatus=0";
                pst = conn.prepareStatement(sql); 
                rs = pst.executeQuery();
            
                paymentsTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            
            } 
        
            catch (SQLException e) 
            {
            System.out.println(e);
            }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        iname = new javax.swing.JTextField();
        inic = new javax.swing.JTextField();
        ivlicense = new javax.swing.JTextField();
        ivcat = new javax.swing.JTextField();
        ipack = new javax.swing.JTextField();
        imid = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ikey = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        itype = new javax.swing.JComboBox<String>();
        jScrollPane2 = new javax.swing.JScrollPane();
        iinfobox = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        ipay = new javax.swing.JTextField();
        ichrg = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        ibalance = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        ifine = new javax.swing.JTextField();
        jButton27 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymentsTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setTitle("Payments");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Member details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 20), new java.awt.Color(5, 51, 102))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel10.setText("Name                         :");

        jLabel11.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel11.setText(" NIC                            :");

        jLabel14.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel14.setText("Vehi. License NO  :");

        jLabel15.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel15.setText("Category             :");

        jLabel17.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel17.setText("Package                     :");

        iname.setEditable(false);
        iname.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        inic.setEditable(false);
        inic.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        ivlicense.setEditable(false);
        ivlicense.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        ivcat.setEditable(false);
        ivcat.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        ipack.setEditable(false);
        ipack.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        imid.setEditable(false);
        imid.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel12.setText("Member ID             :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imid, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 410, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ivlicense))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inic))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iname, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ivcat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ipack)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(imid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(ipack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(iname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(inic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(ivcat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(ivlicense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 20), new java.awt.Color(5, 52, 103))); // NOI18N

        ikey.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        ikey.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ikeyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ikeyKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel9.setText("By : ");

        jButton1.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarIcon/icons8_Search_30px.png"))); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        itype.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        itype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vehicle License", "NIC" }));
        itype.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                itypeItemStateChanged(evt);
            }
        });

        iinfobox.setEditable(false);
        iinfobox.setColumns(20);
        iinfobox.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        iinfobox.setRows(5);
        iinfobox.setText("\n\n                                                      Searched information will display\n");
        iinfobox.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(iinfobox);

        jButton2.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarIcon/icons8_Enter_Key_30px.png"))); // NOI18N
        jButton2.setText("Enter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ikey, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(ikey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(itype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 20), new java.awt.Color(5, 51, 102))); // NOI18N

        ipay.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        ipay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipayActionPerformed(evt);
            }
        });
        ipay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ipayKeyReleased(evt);
            }
        });

        ichrg.setEditable(false);
        ichrg.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel37.setText("Payment    :");

        ibalance.setEditable(false);
        ibalance.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel38.setText("Charge        :");

        jLabel39.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        jLabel39.setText("Balance         :");

        jLabel40.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        jLabel40.setText("Fine               :");

        ifine.setEditable(false);
        ifine.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        ifine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ifineActionPerformed(evt);
            }
        });
        ifine.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ifineKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ifineKeyTyped(evt);
            }
        });

        jButton27.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarIcon/icons8_Enter_Key_30px.png"))); // NOI18N
        jButton27.setText("Enter");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ichrg, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ibalance))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ipay))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ifine, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(ifine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(ichrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(ipay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(ibalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Members to Pay", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 20), new java.awt.Color(5, 51, 102))); // NOI18N

        paymentsTable.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        paymentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Membe rID", "Name", "NIC", "License NO", "Category", "Package"
            }
        ));
        paymentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(paymentsTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Member`s Payments");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ipayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipayActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed

        String mid = imid.getText();
        String mpack = ipack.getText();
        String mvcat = ivcat.getText();
        String empid = "CPManager";
        Double paid = Double.parseDouble(ipay.getText());
        Double chrg = Double.parseDouble(ichrg.getText());
        
        
        boolean ch = v.isMinus(Double.parseDouble(ibalance.getText()));
        
        if(ch == false)
        {
        
                        try {
                             p.addMemPayment(mid, mpack, mvcat, empid);
                         }
                         catch (ParseException ex) {
                             //JOptionPane.showMessageDialog(null, "Prolem with Button Call..\n"+ex);
                         } catch (SQLException ex) {
                             //JOptionPane.showMessageDialog(null, "Problem with Button ex\n"+ex);
                         }

                                            
                        tableLoad();
                        
        }
        
        else
            JOptionPane.showMessageDialog(null," Balance cannot be negative ");
                   
                 
                
        
        
        
    }//GEN-LAST:event_jButton27ActionPerformed

    private void paymentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentsTableMouseClicked
        // TO fill the table after clicking the row
        
        int r = paymentsTable.getSelectedRow();
        
         String mid  = paymentsTable.getValueAt(r, 0).toString();
         String name = paymentsTable.getValueAt(r, 1).toString();
         String nic  = paymentsTable.getValueAt(r, 2).toString();
         String lno  = paymentsTable.getValueAt(r, 3).toString();
         String vcat = paymentsTable.getValueAt(r, 4).toString();
         String pack = paymentsTable.getValueAt(r, 5).toString();
         //String amnt  = paymentsTable.getValueAt(r, 6).toString();
         
         
         
         imid.setText(mid);
         iname.setText(name);
         inic.setText(nic);
         ivlicense.setText(lno);
         ivcat.setText(vcat);
         ipack.setText(pack);
         ichrg.setText(p.packageAmount(pack,vcat).toString());
         
         
          try {
                   Boolean isr = m.isReject(mid);
                   
                   if(isr == true)
                   {
                       //set fine
                        Double fine = m.calFine(mid);
                        ifine.setText(DF.format(fine).toString());
                        
                        Double tot = p.findTotal(mid, ipack.getText(),ivcat.getText());
                        ichrg.setText(tot.toString());
                   }
        
                    
                 
                 
             } catch (SQLException ex) {
                   //JOptionPane.showMessageDialog(null, "Prolem with Button Call..\n"+ex);
             } catch (ParseException ex) {
                   //JOptionPane.showMessageDialog(null, "Prolem with Button Call..\n"+ex);
             }         
        
         
         
         
         
        
        
    }//GEN-LAST:event_paymentsTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
             // TO Search a member
                     
                     String ky  = ikey.getText();
                     String typ = itype.getSelectedItem().toString();
                     
                     String out = m.searchMember(ky, typ);
                     
                     iinfobox.setText(out);
                     
                     
                     
                     
     
                     
                 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ikeyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ikeyKeyTyped
        // TODO add your handling code here:
        
     
    }//GEN-LAST:event_ikeyKeyTyped

    private void ikeyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ikeyKeyReleased
        // TODO add your handling code here:
         String ky  = ikey.getText();
                     String typ = itype.getSelectedItem().toString();
                     
                      String out = m.searchMember(ky, typ);
                     
                      iinfobox.setText(out);
        
    }//GEN-LAST:event_ikeyKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        String typ = itype.getSelectedItem().toString();
            String ky = ikey.getText();
            
        if(typ.equalsIgnoreCase("Vehicle License") == true)
        {
        
            String sq = "SELECT * FROM member WHERE vehilicense ='"+ky+"' ";
        
            try {
            
                    pst = conn.prepareStatement(sq);
                    rs = pst.executeQuery();
                    rs.next();
                    
                    imid.setText(rs.getString("mid"));
                    iname.setText(rs.getString("name"));
                    inic.setText(rs.getString("NIC"));
                    ivlicense.setText(rs.getString("vehilicense"));
                    ivcat.setText(rs.getString("vehicat"));
                    ipack.setText(rs.getString("package"));
                    ichrg.setText(p.packageAmount(rs.getString("package"),rs.getString("vehicat")).toString());
                                     
                }
        
            catch (SQLException e) {
        
                    //JOptionPane.showMessageDialog(null,"Can`t fill text fields"+ e);
            }
                       
        }
        
        else 
        {
            String sq1 = "SELECT * FROM member WHERE NIC='"+ky+"'";
        
            try {
            
                    pst = conn.prepareStatement(sq1);
                    rs = pst.executeQuery();
                    rs.next();
    
                        imid.setText(rs.getString("mid"));
                        iname.setText(rs.getString("name"));
                        inic.setText(rs.getString("NIC"));
                        ivlicense.setText(rs.getString("vehilicense"));
                        ivcat.setText(rs.getString("vehicat"));
                        ipack.setText(rs.getString("package"));
                        ichrg.setText(p.packageAmount(rs.getString("package"),rs.getString("vehicat")).toString());
                        
                                       
                }
        
            catch (SQLException e) {
        
                    //JOptionPane.showMessageDialog(null,"Can`t fill text feilds"+ e);
            } 
        }  
        
        try {
                   Boolean isr = m.isReject(imid.getText());
                   
                   if(isr == true)
                   {
                       //set fine
                        Double fine = m.calFine(imid.getText());
                        ifine.setText(DF.format(fine).toString());
                        
                        Double tot = p.findTotal(imid.getText(), ipack.getText(),ivcat.getText());
                        ichrg.setText(tot.toString());
                        
                        
                   }
        
                    
                 
                 
             } catch (SQLException ex) {
                   //JOptionPane.showMessageDialog(null, "Prolem with Button Call..\n"+ex);
             } catch (ParseException ex) {
                   //JOptionPane.showMessageDialog(null, "Prolem with Button Call..\n"+ex);
             }         
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void itypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_itypeItemStateChanged
        // TO search member 
        
        String ky  = ikey.getText();
                     String typ = itype.getSelectedItem().toString();
                     
                      String out = m.searchMember(ky, typ);
                     
                      iinfobox.setText(out);
    }//GEN-LAST:event_itypeItemStateChanged

    private void ifineKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ifineKeyReleased
        // TO find Total
        
          
    }//GEN-LAST:event_ifineKeyReleased

    private void ifineKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ifineKeyTyped
        // TODO add your handling code here:
         
        
        
    }//GEN-LAST:event_ifineKeyTyped

    private void ifineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ifineActionPerformed
     
        
    }//GEN-LAST:event_ifineActionPerformed

    private void ipayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ipayKeyReleased
         // TODO set balance
         
             double chrg = Double.parseDouble(ichrg.getText());
             double paid = Double.parseDouble(ipay.getText());
             
             Double bal = p.findBalance(paid,chrg);
             ibalance.setText(DF.format(bal).toString());
         
         
    }//GEN-LAST:event_ipayKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ibalance;
    private javax.swing.JTextField ichrg;
    private javax.swing.JTextField ifine;
    private javax.swing.JTextArea iinfobox;
    private javax.swing.JTextField ikey;
    private javax.swing.JTextField imid;
    private javax.swing.JTextField iname;
    private javax.swing.JTextField inic;
    private javax.swing.JTextField ipack;
    private javax.swing.JTextField ipay;
    private javax.swing.JComboBox<String> itype;
    private javax.swing.JTextField ivcat;
    private javax.swing.JTextField ivlicense;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton27;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable paymentsTable;
    // End of variables declaration//GEN-END:variables
}
