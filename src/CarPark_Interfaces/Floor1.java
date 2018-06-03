
package CarPark_Interfaces;

import static Carpark_class.Arduino.updateSlotStatusExit;
import Carpark_class.dbconnct;
import Carpark_class.parkingVehicles;
import java.awt.Color;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JLabel;


public class Floor1 extends javax.swing.JInternalFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    Parkings p = new Parkings();
    
    
   
    public Floor1() {
        initComponents();
        
        Date d = new Date();
        String amPm = new SimpleDateFormat("aa").format(d);
        
        if(amPm.equals("PM")){
        getContentPane().setBackground(Color.lightGray);
        }
        else
          getContentPane().setBackground(Color.decode("#F5F5F5"));
        
        conn = dbconnct.connect();
        
        autoSetSlot();
        
        
        
        
    }
    
    
    public void autoSetSlot()
    {
        
        
        Thread as = new Thread()
        {
            public void run()
            {
                   
                
                   for(;;)
                   {
                        giveSlotNo();
                       try {
                           sleep(1000);
                       } catch (InterruptedException ex) {
                           Logger.getLogger(Entrance.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }
                   
            }
        };
        as.start();
        
    }
    
    public String giveSlotNo()
    {
        String slot = null;
        String bl = null;
        String x = null;
        
        for(char block='A';block<='B';block++)//Chane A to L
        {
            bl = Character.toString(block);
            
            for(int i=1; i<=6; i++) 
            {
                x = String.valueOf(i);
                
                slot = "F1"+bl+x;
                
                String sql = " SELECT status,vehilic FROM carparkslot WHERE slotNo='"+slot+"' ";
                
                try {
                    pst = conn.prepareStatement(sql);            
                    rs = pst.executeQuery();
                    rs.next();
                    
                    setLabel(slot,rs.getString("status"),rs.getString("vehilic"),x);
                    
                    
                    
                } catch (Exception e) {
                }
            }
        }
        
        
        return slot;
    }

    
    
    
    public void setClr(String status,JLabel jl,String vehilic,String num)
    {
        Color clr = null; 
              
        if(status.equals("available"))   { clr = new Color (0,204,0);  jl.setText(num+"."+"Available");  jl.setBackground(clr);}
        else if(status.equals("topark")) { clr = new Color (204,204,0);  jl.setText(vehilic);  jl.setBackground(clr);}
        else if(status.equals("parked")) { clr =  Color.RED;  jl.setText(vehilic);  jl.setBackground(clr);}
        else if(status.equals("toexit")) { clr = new Color (0,153,204); jl.setText(vehilic);  jl.setBackground(clr);}
        else if(status.equals("reject")) { clr = Color.BLACK;; jl.setText("Reject");  jl.setBackground(clr);}
        
        
    }        
    
    public void setLabel(String slot,String status,String vehilic,String num)
    {
        if(slot.equals("F1A1")) { setClr(status,o1,vehilic,num);}
        else if(slot.equals("F1A2")) {{ setClr(status,o2,vehilic,num);}}
        else if(slot.equals("F1A3")) {{ setClr(status,o3,vehilic,num);}}
        else if(slot.equals("F1A4")) {{ setClr(status,o4,vehilic,num);}}
        else if(slot.equals("F1A5")) {{ setClr(status,o5,vehilic,num);}}
        else if(slot.equals("F1A6")) {{ setClr(status,o6,vehilic,num);}}
        else if(slot.equals("F1B1")) {{ setClr(status,o7,vehilic,num);}}
        else if(slot.equals("F1B2")) {{ setClr(status,o8,vehilic,num);}}
        else if(slot.equals("F1B3")) {{ setClr(status,o9,vehilic,num);}}
        else if(slot.equals("F1B4")) {{ setClr(status,o10,vehilic,num);}}
        else if(slot.equals("F1B5")) {{ setClr(status,o11,vehilic,num);}}
        else if(slot.equals("F1B6")) {{ setClr(status,o12,vehilic,num);}}
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        o1 = new javax.swing.JLabel();
        o2 = new javax.swing.JLabel();
        o3 = new javax.swing.JLabel();
        o6 = new javax.swing.JLabel();
        o5 = new javax.swing.JLabel();
        o4 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        o13 = new javax.swing.JLabel();
        o14 = new javax.swing.JLabel();
        o15 = new javax.swing.JLabel();
        o18 = new javax.swing.JLabel();
        o17 = new javax.swing.JLabel();
        o16 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        o31 = new javax.swing.JLabel();
        o32 = new javax.swing.JLabel();
        o33 = new javax.swing.JLabel();
        o36 = new javax.swing.JLabel();
        o35 = new javax.swing.JLabel();
        o34 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        o7 = new javax.swing.JLabel();
        o8 = new javax.swing.JLabel();
        o9 = new javax.swing.JLabel();
        o12 = new javax.swing.JLabel();
        o11 = new javax.swing.JLabel();
        o10 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        o25 = new javax.swing.JLabel();
        o26 = new javax.swing.JLabel();
        o27 = new javax.swing.JLabel();
        o30 = new javax.swing.JLabel();
        o29 = new javax.swing.JLabel();
        o28 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        o19 = new javax.swing.JLabel();
        o20 = new javax.swing.JLabel();
        o21 = new javax.swing.JLabel();
        o24 = new javax.swing.JLabel();
        o23 = new javax.swing.JLabel();
        o22 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        o43 = new javax.swing.JLabel();
        o44 = new javax.swing.JLabel();
        o45 = new javax.swing.JLabel();
        o48 = new javax.swing.JLabel();
        o47 = new javax.swing.JLabel();
        o46 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        o49 = new javax.swing.JLabel();
        o50 = new javax.swing.JLabel();
        o51 = new javax.swing.JLabel();
        o54 = new javax.swing.JLabel();
        o53 = new javax.swing.JLabel();
        o52 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        o37 = new javax.swing.JLabel();
        o38 = new javax.swing.JLabel();
        o39 = new javax.swing.JLabel();
        o42 = new javax.swing.JLabel();
        o41 = new javax.swing.JLabel();
        o40 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        o58 = new javax.swing.JLabel();
        o59 = new javax.swing.JLabel();
        o60 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        o61 = new javax.swing.JLabel();
        o62 = new javax.swing.JLabel();
        o63 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        o55 = new javax.swing.JLabel();
        o56 = new javax.swing.JLabel();
        o57 = new javax.swing.JLabel();

        setBorder(null);
        setTitle("Floor 1");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Block A", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 14), new java.awt.Color(0, 153, 153))); // NOI18N

        o1.setBackground(new java.awt.Color(0, 204, 0));
        o1.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o1.setForeground(new java.awt.Color(255, 255, 255));
        o1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o1.setText("1.Available");
        o1.setOpaque(true);
        o1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o1MouseMoved(evt);
            }
        });
        o1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o1MouseReleased(evt);
            }
        });

        o2.setBackground(new java.awt.Color(0, 204, 0));
        o2.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o2.setForeground(new java.awt.Color(255, 255, 255));
        o2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o2.setText("2.Available");
        o2.setOpaque(true);
        o2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o2MouseMoved(evt);
            }
        });
        o2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o2MouseReleased(evt);
            }
        });

        o3.setBackground(new java.awt.Color(0, 204, 0));
        o3.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o3.setForeground(new java.awt.Color(255, 255, 255));
        o3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o3.setText("3.Available");
        o3.setOpaque(true);
        o3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o3MouseMoved(evt);
            }
        });
        o3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o3MouseReleased(evt);
            }
        });

        o6.setBackground(new java.awt.Color(0, 204, 0));
        o6.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o6.setForeground(new java.awt.Color(255, 255, 255));
        o6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o6.setText("6.Available");
        o6.setOpaque(true);
        o6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o6MouseMoved(evt);
            }
        });
        o6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o6MouseReleased(evt);
            }
        });

        o5.setBackground(new java.awt.Color(0, 204, 0));
        o5.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o5.setForeground(new java.awt.Color(255, 255, 255));
        o5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o5.setText("5.Available");
        o5.setOpaque(true);
        o5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o5MouseMoved(evt);
            }
        });
        o5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o5MouseReleased(evt);
            }
        });

        o4.setBackground(new java.awt.Color(0, 204, 0));
        o4.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o4.setForeground(new java.awt.Color(255, 255, 255));
        o4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o4.setText("4.Available");
        o4.setOpaque(true);
        o4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o4MouseMoved(evt);
            }
        });
        o4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o4MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(o1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(o6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Block C", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 14), new java.awt.Color(0, 153, 153))); // NOI18N

        o13.setBackground(new java.awt.Color(0, 204, 0));
        o13.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o13.setForeground(new java.awt.Color(255, 255, 255));
        o13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o13.setText("1.Available");
        o13.setOpaque(true);
        o13.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o13MouseMoved(evt);
            }
        });
        o13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o13MouseReleased(evt);
            }
        });

        o14.setBackground(new java.awt.Color(0, 204, 0));
        o14.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o14.setForeground(new java.awt.Color(255, 255, 255));
        o14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o14.setText("2.Available");
        o14.setOpaque(true);
        o14.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o14MouseMoved(evt);
            }
        });
        o14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o14MouseReleased(evt);
            }
        });

        o15.setBackground(new java.awt.Color(0, 204, 0));
        o15.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o15.setForeground(new java.awt.Color(255, 255, 255));
        o15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o15.setText("3.Available");
        o15.setOpaque(true);
        o15.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o15MouseMoved(evt);
            }
        });
        o15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o15MouseReleased(evt);
            }
        });

        o18.setBackground(new java.awt.Color(0, 204, 0));
        o18.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o18.setForeground(new java.awt.Color(255, 255, 255));
        o18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o18.setText("6.Available");
        o18.setOpaque(true);
        o18.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o18MouseMoved(evt);
            }
        });
        o18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o18MouseReleased(evt);
            }
        });

        o17.setBackground(new java.awt.Color(0, 204, 0));
        o17.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o17.setForeground(new java.awt.Color(255, 255, 255));
        o17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o17.setText("5.Available");
        o17.setOpaque(true);
        o17.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o17MouseMoved(evt);
            }
        });
        o17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o17MouseReleased(evt);
            }
        });

        o16.setBackground(new java.awt.Color(0, 204, 0));
        o16.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o16.setForeground(new java.awt.Color(255, 255, 255));
        o16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o16.setText("4.Available");
        o16.setOpaque(true);
        o16.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o16MouseMoved(evt);
            }
        });
        o16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o16MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(o13, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o14, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o15, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(o18, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o17, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o16, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Block F", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 14), new java.awt.Color(0, 153, 153))); // NOI18N

        o31.setBackground(new java.awt.Color(0, 204, 0));
        o31.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o31.setForeground(new java.awt.Color(255, 255, 255));
        o31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o31.setText("1.Available");
        o31.setOpaque(true);
        o31.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o31MouseMoved(evt);
            }
        });
        o31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o31MouseReleased(evt);
            }
        });

        o32.setBackground(new java.awt.Color(0, 204, 0));
        o32.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o32.setForeground(new java.awt.Color(255, 255, 255));
        o32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o32.setText("2.Available");
        o32.setOpaque(true);
        o32.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o32MouseMoved(evt);
            }
        });
        o32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o32MouseReleased(evt);
            }
        });

        o33.setBackground(new java.awt.Color(0, 204, 0));
        o33.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o33.setForeground(new java.awt.Color(255, 255, 255));
        o33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o33.setText("3.Available");
        o33.setOpaque(true);
        o33.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o33MouseMoved(evt);
            }
        });
        o33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o33MouseReleased(evt);
            }
        });

        o36.setBackground(new java.awt.Color(0, 204, 0));
        o36.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o36.setForeground(new java.awt.Color(255, 255, 255));
        o36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o36.setText("6.Available");
        o36.setOpaque(true);
        o36.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o36MouseMoved(evt);
            }
        });
        o36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o36MouseReleased(evt);
            }
        });

        o35.setBackground(new java.awt.Color(0, 204, 0));
        o35.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o35.setForeground(new java.awt.Color(255, 255, 255));
        o35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o35.setText("5.Available");
        o35.setOpaque(true);
        o35.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o35MouseMoved(evt);
            }
        });
        o35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o35MouseReleased(evt);
            }
        });

        o34.setBackground(new java.awt.Color(0, 204, 0));
        o34.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o34.setForeground(new java.awt.Color(255, 255, 255));
        o34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o34.setText("4.Available");
        o34.setOpaque(true);
        o34.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o34MouseMoved(evt);
            }
        });
        o34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o34MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(o31, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o32, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o33, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(o36, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o35, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o34, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o31, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o32, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o33, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o36, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o35, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o34, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Block B", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 14), new java.awt.Color(0, 153, 153))); // NOI18N

        o7.setBackground(new java.awt.Color(0, 204, 0));
        o7.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o7.setForeground(new java.awt.Color(255, 255, 255));
        o7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o7.setText("1.Available");
        o7.setOpaque(true);
        o7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o7MouseMoved(evt);
            }
        });
        o7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o7MouseReleased(evt);
            }
        });

        o8.setBackground(new java.awt.Color(0, 204, 0));
        o8.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o8.setForeground(new java.awt.Color(255, 255, 255));
        o8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o8.setText("2.Available");
        o8.setOpaque(true);
        o8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o8MouseMoved(evt);
            }
        });
        o8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o8MouseReleased(evt);
            }
        });

        o9.setBackground(new java.awt.Color(0, 204, 0));
        o9.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o9.setForeground(new java.awt.Color(255, 255, 255));
        o9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o9.setText("3.Available");
        o9.setOpaque(true);
        o9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o9MouseMoved(evt);
            }
        });
        o9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o9MouseReleased(evt);
            }
        });

        o12.setBackground(new java.awt.Color(0, 204, 0));
        o12.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o12.setForeground(new java.awt.Color(255, 255, 255));
        o12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o12.setText("6.Available");
        o12.setOpaque(true);
        o12.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o12MouseMoved(evt);
            }
        });
        o12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o12MouseReleased(evt);
            }
        });

        o11.setBackground(new java.awt.Color(0, 204, 0));
        o11.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o11.setForeground(new java.awt.Color(255, 255, 255));
        o11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o11.setText("5.Available");
        o11.setOpaque(true);
        o11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o11MouseMoved(evt);
            }
        });
        o11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o11MouseReleased(evt);
            }
        });

        o10.setBackground(new java.awt.Color(0, 204, 0));
        o10.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o10.setForeground(new java.awt.Color(255, 255, 255));
        o10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o10.setText("4.Available");
        o10.setOpaque(true);
        o10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o10MouseMoved(evt);
            }
        });
        o10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o10MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(o7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(o12, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Block E", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 14), new java.awt.Color(0, 153, 153))); // NOI18N

        o25.setBackground(new java.awt.Color(0, 204, 0));
        o25.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o25.setForeground(new java.awt.Color(255, 255, 255));
        o25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o25.setText("1.Available");
        o25.setOpaque(true);
        o25.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o25MouseMoved(evt);
            }
        });
        o25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o25MouseReleased(evt);
            }
        });

        o26.setBackground(new java.awt.Color(0, 204, 0));
        o26.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o26.setForeground(new java.awt.Color(255, 255, 255));
        o26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o26.setText("2.Available");
        o26.setOpaque(true);
        o26.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o26MouseMoved(evt);
            }
        });
        o26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o26MouseReleased(evt);
            }
        });

        o27.setBackground(new java.awt.Color(0, 204, 0));
        o27.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o27.setForeground(new java.awt.Color(255, 255, 255));
        o27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o27.setText("3.Available");
        o27.setOpaque(true);
        o27.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o27MouseMoved(evt);
            }
        });
        o27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o27MouseReleased(evt);
            }
        });

        o30.setBackground(new java.awt.Color(0, 204, 0));
        o30.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o30.setForeground(new java.awt.Color(255, 255, 255));
        o30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o30.setText("6.Available");
        o30.setOpaque(true);
        o30.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o30MouseMoved(evt);
            }
        });
        o30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o30MouseReleased(evt);
            }
        });

        o29.setBackground(new java.awt.Color(0, 204, 0));
        o29.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o29.setForeground(new java.awt.Color(255, 255, 255));
        o29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o29.setText("5.Available");
        o29.setOpaque(true);
        o29.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o29MouseMoved(evt);
            }
        });
        o29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o29MouseReleased(evt);
            }
        });

        o28.setBackground(new java.awt.Color(0, 204, 0));
        o28.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o28.setForeground(new java.awt.Color(255, 255, 255));
        o28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o28.setText("4.Available");
        o28.setOpaque(true);
        o28.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o28MouseMoved(evt);
            }
        });
        o28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o28MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(o25, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o26, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o27, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(o30, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o29, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o28, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o25, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o26, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o27, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o30, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o29, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o28, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel50.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Block D", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 14), new java.awt.Color(0, 153, 153))); // NOI18N

        o19.setBackground(new java.awt.Color(0, 204, 0));
        o19.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o19.setForeground(new java.awt.Color(255, 255, 255));
        o19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o19.setText("1.Available");
        o19.setOpaque(true);
        o19.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o19MouseMoved(evt);
            }
        });
        o19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o19MouseReleased(evt);
            }
        });

        o20.setBackground(new java.awt.Color(0, 204, 0));
        o20.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o20.setForeground(new java.awt.Color(255, 255, 255));
        o20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o20.setText("2.Available");
        o20.setOpaque(true);
        o20.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o20MouseMoved(evt);
            }
        });
        o20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o20MouseReleased(evt);
            }
        });

        o21.setBackground(new java.awt.Color(0, 204, 0));
        o21.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o21.setForeground(new java.awt.Color(255, 255, 255));
        o21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o21.setText("3.Available");
        o21.setOpaque(true);
        o21.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o21MouseMoved(evt);
            }
        });
        o21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o21MouseReleased(evt);
            }
        });

        o24.setBackground(new java.awt.Color(0, 204, 0));
        o24.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o24.setForeground(new java.awt.Color(255, 255, 255));
        o24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o24.setText("6.Available");
        o24.setOpaque(true);
        o24.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o24MouseMoved(evt);
            }
        });
        o24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o24MouseReleased(evt);
            }
        });

        o23.setBackground(new java.awt.Color(0, 204, 0));
        o23.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o23.setForeground(new java.awt.Color(255, 255, 255));
        o23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o23.setText("5.Available");
        o23.setOpaque(true);
        o23.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o23MouseMoved(evt);
            }
        });
        o23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o23MouseReleased(evt);
            }
        });

        o22.setBackground(new java.awt.Color(0, 204, 0));
        o22.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o22.setForeground(new java.awt.Color(255, 255, 255));
        o22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o22.setText("4.Available");
        o22.setOpaque(true);
        o22.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o22MouseMoved(evt);
            }
        });
        o22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o22MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(o19, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o20, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o21, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(o24, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o23, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o22, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o24, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel51.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Block H", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 14), new java.awt.Color(0, 153, 153))); // NOI18N

        o43.setBackground(new java.awt.Color(0, 204, 0));
        o43.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o43.setForeground(new java.awt.Color(255, 255, 255));
        o43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o43.setText("1.Available");
        o43.setOpaque(true);
        o43.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o43MouseMoved(evt);
            }
        });
        o43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o43MouseReleased(evt);
            }
        });

        o44.setBackground(new java.awt.Color(0, 204, 0));
        o44.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o44.setForeground(new java.awt.Color(255, 255, 255));
        o44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o44.setText("2.Available");
        o44.setOpaque(true);
        o44.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o44MouseMoved(evt);
            }
        });
        o44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o44MouseReleased(evt);
            }
        });

        o45.setBackground(new java.awt.Color(0, 204, 0));
        o45.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o45.setForeground(new java.awt.Color(255, 255, 255));
        o45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o45.setText("3.Available");
        o45.setOpaque(true);
        o45.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o45MouseMoved(evt);
            }
        });
        o45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o45MouseReleased(evt);
            }
        });

        o48.setBackground(new java.awt.Color(0, 204, 0));
        o48.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o48.setForeground(new java.awt.Color(255, 255, 255));
        o48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o48.setText("6.Available");
        o48.setOpaque(true);
        o48.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o48MouseMoved(evt);
            }
        });
        o48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o48MouseReleased(evt);
            }
        });

        o47.setBackground(new java.awt.Color(0, 204, 0));
        o47.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o47.setForeground(new java.awt.Color(255, 255, 255));
        o47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o47.setText("5.Available");
        o47.setOpaque(true);
        o47.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o47MouseMoved(evt);
            }
        });
        o47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o47MouseReleased(evt);
            }
        });

        o46.setBackground(new java.awt.Color(0, 204, 0));
        o46.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o46.setForeground(new java.awt.Color(255, 255, 255));
        o46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o46.setText("4.Available");
        o46.setOpaque(true);
        o46.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o46MouseMoved(evt);
            }
        });
        o46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o46MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(o43, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o44, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o45, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(o48, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o47, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o46, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o43, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o44, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o45, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o48, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o47, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o46, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Block I", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 14), new java.awt.Color(0, 153, 153))); // NOI18N

        o49.setBackground(new java.awt.Color(0, 204, 0));
        o49.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o49.setForeground(new java.awt.Color(255, 255, 255));
        o49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o49.setText("1.Available");
        o49.setOpaque(true);
        o49.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o49MouseMoved(evt);
            }
        });
        o49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o49MouseReleased(evt);
            }
        });

        o50.setBackground(new java.awt.Color(0, 204, 0));
        o50.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o50.setForeground(new java.awt.Color(255, 255, 255));
        o50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o50.setText("2.Available");
        o50.setOpaque(true);
        o50.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o50MouseMoved(evt);
            }
        });
        o50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o50MouseReleased(evt);
            }
        });

        o51.setBackground(new java.awt.Color(0, 204, 0));
        o51.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o51.setForeground(new java.awt.Color(255, 255, 255));
        o51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o51.setText("3.Available");
        o51.setOpaque(true);
        o51.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o51MouseMoved(evt);
            }
        });
        o51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o51MouseReleased(evt);
            }
        });

        o54.setBackground(new java.awt.Color(0, 204, 0));
        o54.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o54.setForeground(new java.awt.Color(255, 255, 255));
        o54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o54.setText("6.Available");
        o54.setOpaque(true);
        o54.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o54MouseMoved(evt);
            }
        });
        o54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o54MouseReleased(evt);
            }
        });

        o53.setBackground(new java.awt.Color(0, 204, 0));
        o53.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o53.setForeground(new java.awt.Color(255, 255, 255));
        o53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o53.setText("5.Available");
        o53.setOpaque(true);
        o53.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o53MouseMoved(evt);
            }
        });
        o53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o53MouseReleased(evt);
            }
        });

        o52.setBackground(new java.awt.Color(0, 204, 0));
        o52.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o52.setForeground(new java.awt.Color(255, 255, 255));
        o52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o52.setText("4.Available");
        o52.setOpaque(true);
        o52.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o52MouseMoved(evt);
            }
        });
        o52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o52MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addComponent(o49, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o50, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o51, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addComponent(o54, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o53, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o52, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o49, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o50, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o51, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o54, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o53, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o52, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Block G", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 14), new java.awt.Color(0, 153, 153))); // NOI18N

        o37.setBackground(new java.awt.Color(0, 204, 0));
        o37.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o37.setForeground(new java.awt.Color(255, 255, 255));
        o37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o37.setText("1.Available");
        o37.setOpaque(true);
        o37.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o37MouseMoved(evt);
            }
        });
        o37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o37MouseReleased(evt);
            }
        });

        o38.setBackground(new java.awt.Color(0, 204, 0));
        o38.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o38.setForeground(new java.awt.Color(255, 255, 255));
        o38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o38.setText("2.Available");
        o38.setOpaque(true);
        o38.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o38MouseMoved(evt);
            }
        });
        o38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o38MouseReleased(evt);
            }
        });

        o39.setBackground(new java.awt.Color(0, 204, 0));
        o39.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o39.setForeground(new java.awt.Color(255, 255, 255));
        o39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o39.setText("3.Available");
        o39.setOpaque(true);
        o39.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o39MouseMoved(evt);
            }
        });
        o39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o39MouseReleased(evt);
            }
        });

        o42.setBackground(new java.awt.Color(0, 204, 0));
        o42.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o42.setForeground(new java.awt.Color(255, 255, 255));
        o42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o42.setText("6.Available");
        o42.setOpaque(true);
        o42.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o42MouseMoved(evt);
            }
        });
        o42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o42MouseReleased(evt);
            }
        });

        o41.setBackground(new java.awt.Color(0, 204, 0));
        o41.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o41.setForeground(new java.awt.Color(255, 255, 255));
        o41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o41.setText("5.Available");
        o41.setOpaque(true);
        o41.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o41MouseMoved(evt);
            }
        });
        o41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o41MouseReleased(evt);
            }
        });

        o40.setBackground(new java.awt.Color(0, 204, 0));
        o40.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o40.setForeground(new java.awt.Color(255, 255, 255));
        o40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o40.setText("4.Available");
        o40.setOpaque(true);
        o40.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o40MouseMoved(evt);
            }
        });
        o40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o40MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(o37, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o38, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o39, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(o42, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o41, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(o40, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o37, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o38, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o39, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o42, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o41, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o40, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Block K", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 14), new java.awt.Color(0, 153, 153))); // NOI18N

        o58.setBackground(new java.awt.Color(0, 204, 0));
        o58.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o58.setForeground(new java.awt.Color(255, 255, 255));
        o58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o58.setText("1.Available");
        o58.setOpaque(true);
        o58.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o58MouseMoved(evt);
            }
        });
        o58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o58MouseReleased(evt);
            }
        });

        o59.setBackground(new java.awt.Color(0, 204, 0));
        o59.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o59.setForeground(new java.awt.Color(255, 255, 255));
        o59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o59.setText("2.Available");
        o59.setOpaque(true);
        o59.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o59MouseMoved(evt);
            }
        });
        o59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o59MouseReleased(evt);
            }
        });

        o60.setBackground(new java.awt.Color(0, 204, 0));
        o60.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o60.setForeground(new java.awt.Color(255, 255, 255));
        o60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o60.setText("3.Available");
        o60.setOpaque(true);
        o60.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o60MouseMoved(evt);
            }
        });
        o60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o60MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(o58, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(o59, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(o60, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o58, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o59, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o60, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Block L", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 14), new java.awt.Color(0, 153, 153))); // NOI18N

        o61.setBackground(new java.awt.Color(0, 204, 0));
        o61.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o61.setForeground(new java.awt.Color(255, 255, 255));
        o61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o61.setText("1.Available");
        o61.setOpaque(true);
        o61.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o61MouseMoved(evt);
            }
        });
        o61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o61MouseReleased(evt);
            }
        });

        o62.setBackground(new java.awt.Color(0, 204, 0));
        o62.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o62.setForeground(new java.awt.Color(255, 255, 255));
        o62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o62.setText("2.Available");
        o62.setOpaque(true);
        o62.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o62MouseMoved(evt);
            }
        });
        o62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o62MouseReleased(evt);
            }
        });

        o63.setBackground(new java.awt.Color(0, 204, 0));
        o63.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o63.setForeground(new java.awt.Color(255, 255, 255));
        o63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o63.setText("3.Available");
        o63.setOpaque(true);
        o63.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o63MouseMoved(evt);
            }
        });
        o63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o63MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(o61, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(o62, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(o63, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o61, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o62, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o63, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Block J", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 14), new java.awt.Color(0, 153, 153))); // NOI18N

        o55.setBackground(new java.awt.Color(0, 204, 0));
        o55.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o55.setForeground(new java.awt.Color(255, 255, 255));
        o55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o55.setText("1.Available");
        o55.setOpaque(true);
        o55.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o55MouseMoved(evt);
            }
        });
        o55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o55MouseReleased(evt);
            }
        });

        o56.setBackground(new java.awt.Color(0, 204, 0));
        o56.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o56.setForeground(new java.awt.Color(255, 255, 255));
        o56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o56.setText("2.Available");
        o56.setOpaque(true);
        o56.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o56MouseMoved(evt);
            }
        });
        o56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o56MouseReleased(evt);
            }
        });

        o57.setBackground(new java.awt.Color(0, 204, 0));
        o57.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        o57.setForeground(new java.awt.Color(255, 255, 255));
        o57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o57.setText("3.Available");
        o57.setOpaque(true);
        o57.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                o57MouseMoved(evt);
            }
        });
        o57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                o57MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(o55, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(o56, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(o57, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o55, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o56, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o57, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(13, 13, 13))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(335, 335, 335)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(310, 310, 310)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(407, 407, 407)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void o1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o1MouseMoved
        // TODO add your handling code here:
        //JOptionPane.showInternalMessageDialog(rootPane, "bandssssssssssssss");
        //JOptionPane.showInternalInputDialog(rootPane, "bnmmbmnbjhbjbj");
    }//GEN-LAST:event_o1MouseMoved

    private void o1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o1MouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_o1MouseReleased

    private void o2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o2MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o2MouseMoved

    private void o2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o2MouseReleased

    private void o3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o3MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o3MouseMoved

    private void o3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o3MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o3MouseReleased

    private void o6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o6MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o6MouseMoved

    private void o6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o6MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o6MouseReleased

    private void o5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o5MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o5MouseMoved

    private void o5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o5MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o5MouseReleased

    private void o4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o4MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o4MouseMoved

    private void o4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o4MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o4MouseReleased

    private void o13MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o13MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o13MouseMoved

    private void o13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o13MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o13MouseReleased

    private void o14MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o14MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o14MouseMoved

    private void o14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o14MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o14MouseReleased

    private void o15MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o15MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o15MouseMoved

    private void o15MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o15MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o15MouseReleased

    private void o18MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o18MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o18MouseMoved

    private void o18MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o18MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o18MouseReleased

    private void o17MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o17MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o17MouseMoved

    private void o17MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o17MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o17MouseReleased

    private void o16MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o16MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o16MouseMoved

    private void o16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o16MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o16MouseReleased

    private void o31MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o31MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o31MouseMoved

    private void o31MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o31MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o31MouseReleased

    private void o32MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o32MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o32MouseMoved

    private void o32MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o32MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o32MouseReleased

    private void o33MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o33MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o33MouseMoved

    private void o33MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o33MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o33MouseReleased

    private void o36MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o36MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o36MouseMoved

    private void o36MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o36MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o36MouseReleased

    private void o35MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o35MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o35MouseMoved

    private void o35MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o35MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o35MouseReleased

    private void o34MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o34MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o34MouseMoved

    private void o34MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o34MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o34MouseReleased

    private void o7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o7MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o7MouseMoved

    private void o7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o7MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o7MouseReleased

    private void o8MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o8MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o8MouseMoved

    private void o8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o8MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o8MouseReleased

    private void o9MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o9MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o9MouseMoved

    private void o9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o9MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o9MouseReleased

    private void o12MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o12MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o12MouseMoved

    private void o12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o12MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o12MouseReleased

    private void o11MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o11MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o11MouseMoved

    private void o11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o11MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o11MouseReleased

    private void o10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o10MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o10MouseMoved

    private void o10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o10MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o10MouseReleased

    private void o25MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o25MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o25MouseMoved

    private void o25MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o25MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o25MouseReleased

    private void o26MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o26MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o26MouseMoved

    private void o26MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o26MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o26MouseReleased

    private void o27MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o27MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o27MouseMoved

    private void o27MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o27MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o27MouseReleased

    private void o30MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o30MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o30MouseMoved

    private void o30MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o30MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o30MouseReleased

    private void o29MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o29MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o29MouseMoved

    private void o29MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o29MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o29MouseReleased

    private void o28MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o28MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o28MouseMoved

    private void o28MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o28MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o28MouseReleased

    private void o19MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o19MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o19MouseMoved

    private void o19MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o19MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o19MouseReleased

    private void o20MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o20MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o20MouseMoved

    private void o20MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o20MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o20MouseReleased

    private void o21MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o21MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o21MouseMoved

    private void o21MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o21MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o21MouseReleased

    private void o24MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o24MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o24MouseMoved

    private void o24MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o24MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o24MouseReleased

    private void o23MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o23MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o23MouseMoved

    private void o23MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o23MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o23MouseReleased

    private void o22MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o22MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o22MouseMoved

    private void o22MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o22MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o22MouseReleased

    private void o43MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o43MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o43MouseMoved

    private void o43MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o43MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o43MouseReleased

    private void o44MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o44MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o44MouseMoved

    private void o44MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o44MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o44MouseReleased

    private void o45MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o45MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o45MouseMoved

    private void o45MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o45MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o45MouseReleased

    private void o48MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o48MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o48MouseMoved

    private void o48MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o48MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o48MouseReleased

    private void o47MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o47MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o47MouseMoved

    private void o47MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o47MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o47MouseReleased

    private void o46MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o46MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o46MouseMoved

    private void o46MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o46MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o46MouseReleased

    private void o49MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o49MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o49MouseMoved

    private void o49MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o49MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o49MouseReleased

    private void o50MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o50MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o50MouseMoved

    private void o50MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o50MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o50MouseReleased

    private void o51MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o51MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o51MouseMoved

    private void o51MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o51MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o51MouseReleased

    private void o54MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o54MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o54MouseMoved

    private void o54MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o54MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o54MouseReleased

    private void o53MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o53MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o53MouseMoved

    private void o53MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o53MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o53MouseReleased

    private void o52MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o52MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o52MouseMoved

    private void o52MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o52MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o52MouseReleased

    private void o37MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o37MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o37MouseMoved

    private void o37MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o37MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o37MouseReleased

    private void o38MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o38MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o38MouseMoved

    private void o38MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o38MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o38MouseReleased

    private void o39MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o39MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o39MouseMoved

    private void o39MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o39MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o39MouseReleased

    private void o42MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o42MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o42MouseMoved

    private void o42MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o42MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o42MouseReleased

    private void o41MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o41MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o41MouseMoved

    private void o41MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o41MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o41MouseReleased

    private void o40MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o40MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o40MouseMoved

    private void o40MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o40MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o40MouseReleased

    private void o58MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o58MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o58MouseMoved

    private void o58MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o58MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o58MouseReleased

    private void o59MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o59MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o59MouseMoved

    private void o59MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o59MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o59MouseReleased

    private void o60MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o60MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o60MouseMoved

    private void o60MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o60MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o60MouseReleased

    private void o61MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o61MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o61MouseMoved

    private void o61MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o61MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o61MouseReleased

    private void o62MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o62MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o62MouseMoved

    private void o62MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o62MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o62MouseReleased

    private void o63MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o63MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o63MouseMoved

    private void o63MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o63MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o63MouseReleased

    private void o55MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o55MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o55MouseMoved

    private void o55MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o55MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o55MouseReleased

    private void o56MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o56MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o56MouseMoved

    private void o56MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o56MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o56MouseReleased

    private void o57MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o57MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_o57MouseMoved

    private void o57MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_o57MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_o57MouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel o1;
    private javax.swing.JLabel o10;
    private javax.swing.JLabel o11;
    private javax.swing.JLabel o12;
    private javax.swing.JLabel o13;
    private javax.swing.JLabel o14;
    private javax.swing.JLabel o15;
    private javax.swing.JLabel o16;
    private javax.swing.JLabel o17;
    private javax.swing.JLabel o18;
    private javax.swing.JLabel o19;
    private javax.swing.JLabel o2;
    private javax.swing.JLabel o20;
    private javax.swing.JLabel o21;
    private javax.swing.JLabel o22;
    private javax.swing.JLabel o23;
    private javax.swing.JLabel o24;
    private javax.swing.JLabel o25;
    private javax.swing.JLabel o26;
    private javax.swing.JLabel o27;
    private javax.swing.JLabel o28;
    private javax.swing.JLabel o29;
    private javax.swing.JLabel o3;
    private javax.swing.JLabel o30;
    private javax.swing.JLabel o31;
    private javax.swing.JLabel o32;
    private javax.swing.JLabel o33;
    private javax.swing.JLabel o34;
    private javax.swing.JLabel o35;
    private javax.swing.JLabel o36;
    private javax.swing.JLabel o37;
    private javax.swing.JLabel o38;
    private javax.swing.JLabel o39;
    private javax.swing.JLabel o4;
    private javax.swing.JLabel o40;
    private javax.swing.JLabel o41;
    private javax.swing.JLabel o42;
    private javax.swing.JLabel o43;
    private javax.swing.JLabel o44;
    private javax.swing.JLabel o45;
    private javax.swing.JLabel o46;
    private javax.swing.JLabel o47;
    private javax.swing.JLabel o48;
    private javax.swing.JLabel o49;
    private javax.swing.JLabel o5;
    private javax.swing.JLabel o50;
    private javax.swing.JLabel o51;
    private javax.swing.JLabel o52;
    private javax.swing.JLabel o53;
    private javax.swing.JLabel o54;
    private javax.swing.JLabel o55;
    private javax.swing.JLabel o56;
    private javax.swing.JLabel o57;
    private javax.swing.JLabel o58;
    private javax.swing.JLabel o59;
    private javax.swing.JLabel o6;
    private javax.swing.JLabel o60;
    private javax.swing.JLabel o61;
    private javax.swing.JLabel o62;
    private javax.swing.JLabel o63;
    private javax.swing.JLabel o7;
    private javax.swing.JLabel o8;
    private javax.swing.JLabel o9;
    // End of variables declaration//GEN-END:variables
}
