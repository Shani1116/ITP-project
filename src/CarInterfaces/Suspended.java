
package CarInterfaces;

import CarClasses.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class Suspended extends javax.swing.JInternalFrame {

    Connection conn = dbconnct.connect();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    parkingVehicles pv = new parkingVehicles();
    Ticket t = new Ticket();
    Paymentsc p = new Paymentsc();
    Conver_Vali v =new Conver_Vali();
    
    DecimalFormat DF = new DecimalFormat("#####.00");
    
   
    public Suspended() {
        initComponents();
        
        tableLoad();
    }
    
    public void tableLoad()
    {
            try 
            {
                String sql = "SELECT plateno,category,datetime,ticketno,slotno FROM parkingvehicle WHERE status='"+"suspended"+"'";
                pst = conn.prepareStatement(sql); 
                rs = pst.executeQuery();
            
                tableb.setModel(DbUtils.resultSetToTableModel(rs));
            
            
            } 
        
            catch (Exception e) 
            {
            
            }
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableb = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        catb = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        vnob = new javax.swing.JTextField();
        ticb = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton24 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        payb = new javax.swing.JTextField();
        chgb = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        balb = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        fineb = new javax.swing.JTextField();
        jButton29 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pfvnob = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pfcatb = new javax.swing.JTextField();

        setTitle("Suspended");

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel28.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Suspended");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Display details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 20), new java.awt.Color(5, 51, 102))); // NOI18N

        tableb.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        tableb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Vehicle NO.", "Category", "Date Time", "Ticket No.", "Parked Slot No."
            }
        ));
        tableb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablebMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableb);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Suspends", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 20), new java.awt.Color(5, 51, 102))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel1.setText("Vehicle No.    :");

        catb.setEditable(false);
        catb.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel2.setText("Category         :");

        vnob.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        vnob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vnobKeyReleased(evt);
            }
        });

        ticb.setEditable(false);
        ticb.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel3.setText("Ticket No.     :");

        jButton24.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarIcon/icons8_Clear_Symbol_30px_1.png"))); // NOI18N
        jButton24.setText("Clear");

        jButton27.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarIcon/icons8_Plus_Math_30px.png"))); // NOI18N
        jButton27.setText("Add");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(catb, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vnob, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ticb, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(vnob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addComponent(jButton24, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(catb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ticb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pay Fine", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 20), new java.awt.Color(5, 51, 102))); // NOI18N

        payb.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        payb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paybActionPerformed(evt);
            }
        });
        payb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paybKeyReleased(evt);
            }
        });

        chgb.setEditable(false);
        chgb.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N

        jLabel81.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel81.setText("Payment    :");

        balb.setEditable(false);
        balb.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        balb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balbActionPerformed(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel82.setText("Charge        :");

        jLabel83.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        jLabel83.setText("Balance         :");

        jLabel84.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        jLabel84.setText("Fine               :");

        fineb.setEditable(false);
        fineb.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        fineb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finebActionPerformed(evt);
            }
        });
        fineb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                finebKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                finebKeyTyped(evt);
            }
        });

        jButton29.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarIcon/icons8_Enter_Key_30px.png"))); // NOI18N
        jButton29.setText("Enter");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel4.setText("Vehicle No.    :");

        pfvnob.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        pfvnob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pfvnobKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel5.setText("Category         :");

        pfcatb.setEditable(false);
        pfcatb.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(jLabel83)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(balb, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(jLabel81)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(payb)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pfvnob))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pfcatb)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(jLabel84)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fineb, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(jLabel82)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chgb))))))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(fineb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(pfvnob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel82)
                        .addComponent(chgb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(pfcatb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel81)
                            .addComponent(payb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel83)
                            .addComponent(balb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(184, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vnobKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vnobKeyReleased
        // TO fill category and tick no
        
        String vno = vnob.getText();
        
        String cat = pv.getVehicat(vno,"suspended","");
        catb.setText(cat);
        
        String tic = Integer.toString(t.gettickNo(vno,"in","rej"));
        ticb.setText(tic);
    }//GEN-LAST:event_vnobKeyReleased

    private void paybActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paybActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paybActionPerformed

    private void finebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finebActionPerformed

    }//GEN-LAST:event_finebActionPerformed

    private void finebKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_finebKeyReleased
        // TO find Total

    }//GEN-LAST:event_finebKeyReleased

    private void finebKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_finebKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_finebKeyTyped

    private void balbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balbActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        try {
            //To pay fine
            String vno = pfvnob.getText();
            double amnt = Double.parseDouble(chgb.getText());
            
            int du = p.getParkedDu(vno, "suspended","");
            
            boolean ch = v.isValidVehiNum(vno);
            boolean ch1 = v.isMinus(Double.parseDouble(balb.getText()));
            
            if(ch==true && ch1==false)
            {
            
                p.payFine(vno, amnt, "susFine",du, "CPManager");

                tableLoad();
            }
            else
                JOptionPane.showMessageDialog(null,"Inavlid vehicle No or negative balance");
        
            
        } catch (ParseException ex) {
            Logger.getLogger(Suspended.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_jButton29ActionPerformed

    private void pfvnobKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfvnobKeyReleased
        // TO fill cat and fine and chargr
        
        String vno = pfvnob.getText();
        
        String cat = pv.getVehicat(vno,"suspended","");
        pfcatb.setText(cat);
        
        try {
            int du = p.getParkedDu(vno,"suspended","");
            
            double f = p.calFine(du);
                        
            fineb.setText(DF.format(f));
            
            double chg = f+300.0;
            chgb.setText(DF.format(chg));
        } catch (ParseException ex) {
            Logger.getLogger(Suspended.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_pfvnobKeyReleased

    private void paybKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paybKeyReleased
         // TO set balance
         
         Double pay = Double.parseDouble(payb.getText());
         Double chg = Double.parseDouble(chgb.getText());
         
         Double bal = p.findBalance(pay, chg);
         balb.setText(DF.format(bal));
         
    }//GEN-LAST:event_paybKeyReleased

    private void tablebMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebMouseClicked
         // TODO add your handling code here:
         
         
    }//GEN-LAST:event_tablebMouseClicked

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
         // TODO add your handling code here:
         
        boolean ch = v.isValidVehiNum(vnob.getText());
        
        if(ch==true)
        {
        pv.suspends(vnob.getText());
        }
        
        else
            JOptionPane.showMessageDialog(null," Invalid vehicle No.");
    }//GEN-LAST:event_jButton27ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField balb;
    private javax.swing.JTextField catb;
    private javax.swing.JTextField chgb;
    private javax.swing.JTextField fineb;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton29;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField payb;
    private javax.swing.JTextField pfcatb;
    private javax.swing.JTextField pfvnob;
    private javax.swing.JTable tableb;
    private javax.swing.JTextField ticb;
    private javax.swing.JTextField vnob;
    // End of variables declaration//GEN-END:variables
}
