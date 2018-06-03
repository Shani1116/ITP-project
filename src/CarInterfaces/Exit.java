
package CarInterfaces;

import CarClasses.*;

import java.awt.Color;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.ImageIcon;

public class Exit extends javax.swing.JInternalFrame {

    Connection conn = dbconnct.connect();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    parkingVehicles pv = new parkingVehicles();
    Paymentsc p = new Paymentsc();
    Ticket t = new Ticket();
    park_slot ps = new park_slot();
    Conver_Vali v = new Conver_Vali();
    
    
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat tf = new SimpleDateFormat("HH:mm:ss");
    
    Date dt = new Date();
    
    
    DecimalFormat DF = new DecimalFormat("#####.00");
    
    public Exit() {
        initComponents();
        
        tableLord();
    }
    
    public String convertVehiNo(String vno)
     {
        String cnv = null;
         
        boolean zero = Character.isLetter(vno.charAt(0));
        boolean one = Character.isLetter(vno.charAt(1));
        boolean two = Character.isLetter(vno.charAt(2));
        
        if(one==true && two==false)
        {
            String l = vno.substring(0, 2).toUpperCase();
            vno = vno.substring(2);
            
            cnv = l+"-"+vno;
        }
        
        else if(one==true && two==true)
        {
            String l = vno.substring(0, 3).toUpperCase();
            vno = vno.substring(3);
            
            cnv = l+"-"+vno;
        }    
            
                    
        else if(zero==true && one==false)
        {
            char zer = vno.charAt(0);
            
            vno = vno.substring(1);
            
            switch(zer)
            {
                case 'r': cnv="Army "+vno; break;
                case 'n': cnv="Navy "+vno; break;
                case 'a': cnv="Air "+vno; break;
                case 'g': cnv="Garage "+vno; break;
                case 's': cnv="Sri "+vno; break;
                case 'd': cnv="- "+vno; break;
            }
        }
        
                            return cnv;
     }  
    
    public void settextArea(String vnoo,String cat,String slot,String du)
    {
        String vno = this.convertVehiNo(vnoo);
        
        String mem =pv.isMember(vnoo);
        boolean rej = pv.isReject(vno);
        String msg;
        if(rej==true) {  msg="Rejected Vehicle!!!!";}
        else msg="";
        
        
        if(mem.equals("rej") || mem.equals("no"))
        {
            infobox.setForeground(Color.BLACK);
            infobox.setText("\n         "+msg+"\n             Unregistered Vehicle \n             "+vno+"\n             \n            duration = "+du+"min         ");
        }
        
        else 
        {
            infobox.setForeground(Color.BLACK);
            infobox.setText("\n         "+msg+"\n          Registered Vehicle\n \n        Paid.\n           "+vno+"\n         \n         duration = "+du+"min\n         ");
        }
        
        
        
        
    }
    
     public void tableLord()
    {
        
        
        Thread tab= new Thread ()
        {
            public void run()
            {
                for(;;)
                {
                    try 
                    {
                        String sql = "SELECT plateno AS To_Pay FROM parkingvehicle WHERE status = '"+"toexit"+"'";
                        pst = conn.prepareStatement(sql); 
                        rs = pst.executeQuery();

                        topaybox.setModel(DbUtils.resultSetToTableModel(rs));
                        
                        String sq = "SELECT plateno AS To_Pay FROM parkingvehicle WHERE status = '"+"rej"+"'";
                        
                        pst = conn.prepareStatement(sq); 
                        rs = pst.executeQuery();

                        rejectbox.setModel(DbUtils.resultSetToTableModel(rs));
                    } 

                    catch (SQLException e) 
                    {
                            System.out.println(e);
                    }
                    
                    try 
                    {
                                                
                        String sq = "SELECT plateno AS Rejected FROM parkingvehicle WHERE status = '"+"rej"+"'";
                        
                        pst = conn.prepareStatement(sq); 
                        rs = pst.executeQuery();

                        rejectbox.setModel(DbUtils.resultSetToTableModel(rs));
                    } 

                    catch (SQLException e) 
                    {
                            System.out.println(e);
                    }
                    
                
                    try 
                    {
                        sleep(1000);
                    }
                
                    catch (InterruptedException e)
                    {
                        
                    }
                }
            }
        };
        tab.start();
        
    }

    
    public void clear()
    {
        vehinobox.setText("");
        catbox.setText("");
        durbox.setText("");
        chgbox.setText("");
        pabox.setText("");
        balbox.setText("");
        infobox.setText("");
    }
    
    public void setQRcode(int tickno)
    {
        String sq = "SELECT datetime FROM parkingvehicle WHERE ticketno='"+tickno+"'";
        
        try {
            pst = conn.prepareStatement(sq);
            rs = pst.executeQuery();
            rs.next();
            
            String dat=rs.getString("datetime");
            String QRnum = dat.substring(0,4)+"_"+dat.substring(5,7)+"_"+dat.substring(8,10)+"_"+dat.substring(11,13)+"_"+dat.substring(14,16)+"_"+dat.substring(17,19);
            //JOptionPane.showMessageDialog(null,QRnum);
            
            try{
            qrbox.setIcon(new ImageIcon("D:\\ITP\\Yasith_BRo\\QRcodes\\"+QRnum+".png"));
            }
            catch(Exception e)
            {
            //JOptionPane.showMessageDialog(null,e);
            }
            
            
        } catch (SQLException e) {
            
            //JOptionPane.showMessageDialog(null,e);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel13 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        vehinobox = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        catbox = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        pabox = new javax.swing.JTextField();
        chgbox = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        balbox = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        durbox = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        qrbox = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        infobox = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        topaybox = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        tickbox = new javax.swing.JTextField();
        RjectBox = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        rejectbox = new javax.swing.JTable();

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vehicle Info.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 20), new java.awt.Color(5, 51, 102))); // NOI18N
        jPanel13.setForeground(new java.awt.Color(0, 0, 153));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setText("Vehicle NO  :");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Category :");

        vehinobox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        vehinobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehinoboxActionPerformed(evt);
            }
        });
        vehinobox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vehinoboxKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                vehinoboxKeyTyped(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarIcon/icons8_Enter_Key_30px.png"))); // NOI18N
        jButton8.setText("Enter");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        catbox.setEditable(false);
        catbox.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vehinobox)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(catbox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 149, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton8)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(vehinobox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(catbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jButton8)
                .addContainerGap())
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 20), new java.awt.Color(5, 51, 102))); // NOI18N

        pabox.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        pabox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paboxActionPerformed(evt);
            }
        });
        pabox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paboxKeyReleased(evt);
            }
        });

        chgbox.setEditable(false);
        chgbox.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel37.setText("Payment    :  Rs.");

        balbox.setEditable(false);
        balbox.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel38.setText("Charge        :  Rs.");

        jLabel39.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        jLabel39.setText("Balance         :  Rs.");

        jButton4.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarIcon/icons8_Enter_Key_30px.png"))); // NOI18N
        jButton4.setText("Enter");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarIcon/icons8_Clear_Symbol_30px_1.png"))); // NOI18N
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        durbox.setEditable(false);
        durbox.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        jLabel40.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel40.setText("Duration           :  min");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(balbox))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pabox, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chgbox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4)
                            .addComponent(jButton5)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(durbox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(durbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(chgbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(pabox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(balbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "QR code", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 20), new java.awt.Color(0, 102, 102))); // NOI18N

        qrbox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(qrbox, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(qrbox, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "information\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 1, 20), new java.awt.Color(198, 20, 20))); // NOI18N

        infobox.setEditable(false);
        infobox.setColumns(20);
        infobox.setFont(new java.awt.Font("Adobe Garamond Pro Bold", 0, 24)); // NOI18N
        infobox.setForeground(new java.awt.Color(255, 0, 0));
        infobox.setRows(5);
        infobox.setText("\n");
        jScrollPane6.setViewportView(infobox);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel28.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Exit");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "To Pay", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Garamond Pro Bold", 1, 24), new java.awt.Color(102, 0, 0))); // NOI18N

        topaybox.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        topaybox.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"  WILLING TO"},
                {"  WILLING TO"},
                {"  WILLING TO"},
                {"  WILLING TO"},
                {"  WILLING TO"},
                {"  WILLING TO"},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Vehicles to pay"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(topaybox);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel15.setText("Ticket NO  :");

        tickbox.setEditable(false);
        tickbox.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N

        RjectBox.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reject", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Garamond Pro Bold", 1, 24), new java.awt.Color(102, 0, 0))); // NOI18N

        rejectbox.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        rejectbox.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"  WILLING TO"},
                {"  WILLING TO"},
                {"  WILLING TO"},
                {"  WILLING TO"},
                {"  WILLING TO"}
            },
            new String [] {
                "Rejected vehicles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(rejectbox);

        javax.swing.GroupLayout RjectBoxLayout = new javax.swing.GroupLayout(RjectBox);
        RjectBox.setLayout(RjectBoxLayout);
        RjectBoxLayout.setHorizontalGroup(
            RjectBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RjectBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );
        RjectBoxLayout.setVerticalGroup(
            RjectBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RjectBoxLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RjectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tickbox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(RjectBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(tickbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 34, Short.MAX_VALUE))
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vehinoboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehinoboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehinoboxActionPerformed

    private void paboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paboxActionPerformed

    private void vehinoboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vehinoboxKeyTyped
        // TO load vehi cat
        
       
    }//GEN-LAST:event_vehinoboxKeyTyped

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       // TO set charge and tick no
       String mem = pv.isMember(vehinobox.getText());
       boolean ch = v.isValidVehiNum(vehinobox.getText());
       
        String vno = vehinobox.getText();

        try {
            int du = p.getParkedDu(vno, "toexit","rej");
             
       settextArea(vno,null,null, String.valueOf(du));
        } catch (ParseException ex) {
            Logger.getLogger(Exit.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       
       if(ch==true && mem.equals("rej") || mem.equals("no"))    
       { 
       
            try {
                      vno = vehinobox.getText();

                   int du = p.getParkedDu(vno, "toexit","rej");

                   Double chg = p.findCharge(catbox.getText(), du);

                   chgbox.setText(chg.toString());


                   durbox.setText(Integer.toString(du));

                  int tno = t.gettickNo(vehinobox.getText(),"toexit","rej");
                  setQRcode(tno);
                  tickbox.setText(Integer.toString(tno));
                  
                  




                  String sn = ps.findSlotNo(vno,"toexit","rej");


            if(sn.equalsIgnoreCase("no"))
                JOptionPane.showMessageDialog(null, " cant find slot no ");

            else
            {   
                ps.setSlotNo(sn);
                ps.releaseSlot();

            }


             } catch (ParseException ex) {
                 Logger.getLogger(Exit.class.getName()).log(Level.SEVERE, null, ex);
             }
       
       }
    
        else
            JOptionPane.showMessageDialog(null,"Invalid vehicle no");
       
       
       
       
         
    }//GEN-LAST:event_jButton8ActionPerformed

    private void vehinoboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vehinoboxKeyReleased
        // TODO add your handling code here:
            
         String vli = vehinobox.getText();
         String cat = pv.getVehicat(vli,"toexit","rej");
         
                    

         catbox.setText(cat);
    }//GEN-LAST:event_vehinoboxKeyReleased

    private void paboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paboxKeyReleased
        // TODO add your handling code here:
        
        Double bal = p.findBalance(Double.parseDouble(pabox.getText()), Double.parseDouble(chgbox.getText()));
        balbox.setText(bal.toString());
    }//GEN-LAST:event_paboxKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        boolean ch = v.isMinus(Double.parseDouble(balbox.getText()));
        
        if(ch==false)
        {
            p.addUnPayments(vehinobox.getText(), Double.parseDouble(chgbox.getText()), Integer.parseInt(durbox.getText()), "CPManager",tickbox.getText());
            p.updatePID(vehinobox.getText(),Integer.parseInt(tickbox.getText()));
            pv.updateParkedVehi(tickbox.getText());

            clear();
        
        }
        
        else
            JOptionPane.showMessageDialog(null,"Balance cannot be negative ");
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TO clear
        clear();
        
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel RjectBox;
    private javax.swing.JTextField balbox;
    private javax.swing.JTextField catbox;
    private javax.swing.JTextField chgbox;
    private javax.swing.JTextField durbox;
    private javax.swing.JTextArea infobox;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField pabox;
    private javax.swing.JLabel qrbox;
    private javax.swing.JTable rejectbox;
    private javax.swing.JTextField tickbox;
    private javax.swing.JTable topaybox;
    private javax.swing.JTextField vehinobox;
    // End of variables declaration//GEN-END:variables
}
