
package CarPark_Interfaces;

import Carpark_class.Arduino;
import static Carpark_class.Arduino.updateSlotStatusExit;
import Carpark_class.parkingVehicles;
import Carpark_class.Ticket;
import Carpark_class.Conver_Vali;
import Carpark_class.dbconnct;
import Carpark_class.park_slot;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Image;
import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
//import com.sun.javafx.iio.ImageStorage.ImageType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import net.glxn.qrgen.QRCode;
import net.proteanit.sql.DbUtils;
import net.glxn.qrgen.image.ImageType;
import javax.swing.ImageIcon;


public class Entrance extends javax.swing.JInternalFrame {

    Connection conn = dbconnct.connect();
    PreparedStatement pst = null;
    ResultSet rs = null; 
    
    parkingVehicles pv = new parkingVehicles();
    Ticket t =new Ticket();
    park_slot ps = new park_slot();
    Arduino a = new Arduino();
    Conver_Vali v =new Conver_Vali();
    
    DateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    DateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
    DateFormat onlyDate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat onlyTime = new SimpleDateFormat("HH:mm:ss");
    Date dt = new Date();
    
    
    
    public Entrance() {
        initComponents();
        Date d = new Date();
        String amPm = new SimpleDateFormat("aa").format(d);
        
        if(amPm.equals("PM")){
        getContentPane().setBackground(Color.lightGray);
        }
        else
          getContentPane().setBackground(Color.decode("#F5F5F5"));
        
        setprog();
        
        tableLord();
        
        
    
        
        
        
        
    }
    
    public void settextArea(String vnoo,String cat,String slot)
    {
        String vno = Conver_Vali.convertVehiNo(vnoo);
        
        String mem =pv.isMember(slot);
        boolean sus = pv.isSuspend(vno);
        
        if(mem.equals("rej") || mem.equals("no"))
        {
            jTextArea1.setForeground(Color.BLACK);
            jTextArea1.setText("\n\n             Unregistered Vehicle \n             "+vno+"\n             "+slot);
        }
        
        else 
        {
            jTextArea1.setForeground(Color.BLACK);
            jTextArea1.setText("\n\n\n\n  Registered Vehicle \n         "+vno+"\n         "+cat+"\n         "+slot);
        }
        
        if(sus==true) { jTextArea1.setForeground(Color.RED); jTextArea1.setText("\n\n SUSPENDED Vehicle!!! \n\n   Have to pay FINE   ");}
        
        
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
                        String sql = "SELECT slotNo FROM carparkslot WHERE status = '"+"available"+"'";
                        pst = conn.prepareStatement(sql); 
                        rs = pst.executeQuery();

                        slottable.setModel(DbUtils.resultSetToTableModel(rs));


                    } 

                    catch (Exception e) 
                    {

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
    
    public void waitPark(String slot,String vehi)
    {
        
        
        Thread wp = new Thread()
        {
            public void run()
            {
                   
                
                   for(int x=1; x<=13; x++)
                   {
                       System.out.println(x);
                       try {
                           sleep(1000);
                       } catch (InterruptedException ex) {
                           Logger.getLogger(Entrance.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }
                   JOptionPane.showMessageDialog(null," Thread finished");
                   parkingVehicles.rejectVehiAuto(slot, vehi);
                   updateSlotStatusExit("available",slot,"topark","&&&&&&");
            }
        };
        wp.start();
        
    }
    
    
    public void clear()
    {
        lipno.setText("");
        cat.setText("");
        slotno.setText("");
        
    }
    
    
    
    
    public void setprog()
    {
        int vehitot = pv.getTotalvehicle();
         firstFloor.setValue(vehitot);
         firlabel.setText(Integer.toString(vehitot));
    }
    
    public void QRcodee(String vno,String vehicat,String slotno) throws FileNotFoundException, IOException
    {
        String dat = dft.format(dt);
        String QRnum = df.format(dt);
        
        String vehilic = Conver_Vali.convertVehiNo(vno);
        
        
        
        
        String details =vehilic+":"+vehicat+":"+slotno+":"+dat;
            
            ByteArrayOutputStream out = QRCode.from(details).to(ImageType.PNG).stream();
            
            File f = new File("C:\\Users\\Anu\\Desktop\\ITP project\\ITP-New\\itp-project\\ITP\\QRcodes_Carpark\\"+QRnum+".png");
            
            FileOutputStream fos = new FileOutputStream(f);
            
            fos.write(out.toByteArray());
            fos.flush();
            
                       
            
            jLabel1.setIcon(new ImageIcon("C:\\Users\\Anu\\Desktop\\ITP project\\ITP-New\\itp-project\\ITP\\QRcodes_Carpark\\"+QRnum+".png"));
            
            this.printTicket("2",onlyDate.format(dt),vehilic,vehicat,onlyTime.format(dt),slotno,QRnum );
            
    }

    public void printTicket(String Cashier,String date,String vehi,String cat,String  timeIn,String slot,String QRaddress )
    {
        try{
            Document doc = new Document();
                try{
                PdfWriter.getInstance(doc,new FileOutputStream(("C:\\Users\\Anu\\Desktop\\ITP project\\ITP-New\\itp-project\\ITP\\folder\\"+QRaddress+".pdf")));
                }
                catch(FileNotFoundException ex){
                    System.out.println(ex);
                    //Logger.getLogger(GenerateSheetForm.class.getName()).log(Level.SEVERE,null,ex);
                }
            doc.open();   
            
            BufferedImage image;
            Image wall1;
            
            wall1= Image.getInstance("C:\\Users\\Anu\\Desktop\\ITP project\\ITP-New\\itp-project\\ITP\\QRcodes_Carpark\\"+QRaddress+".png");
       // wall2= ImageIO.read(new File("C:\\Users\\Yasith\\Desktop\\PicsArt_11-17-11.24.20.jpg"));
        int d=100;
        int w=90;
        wall1.setAlignment(Element.ALIGN_CENTER);              
            
            Paragraph p1 = new Paragraph("SHOPPING MALL MANAGEMENT SYSTEM");
            Paragraph p2 = new Paragraph("ITP Project/2017(K16SLIIT5)\n\n");
            Paragraph p3 = new Paragraph("Date:"+date+"          CashierID:"+Cashier);
            Paragraph p4 = new Paragraph("---------------------------------------------------------------");
            Paragraph p5 = new Paragraph("      Vehicle  : "+vehi);
            Paragraph p6 = new Paragraph("      Category : "+cat);
            Paragraph p7 = new Paragraph("      Time in  : "+timeIn);
            Paragraph p8 = new Paragraph("      Slot No  : "+slot);
            Paragraph p9 = new Paragraph("---------------------------------------------------------------");
           Paragraph p10 = new Paragraph("     Floor 1 Block A Slot 1 ");
           Paragraph p11 = new Paragraph("---------------------------------------------------------------");
           Paragraph p12 = new Paragraph("---------------------------------------------------------------");
           Paragraph p13 = new Paragraph("you must park at the correct slot");
           Paragraph p14 = new Paragraph("or else you will be fined");
           
           p1.setAlignment(Element.ALIGN_CENTER);
           p2.setAlignment(Element.ALIGN_CENTER);
           p3.setAlignment(Element.ALIGN_CENTER);
           p4.setAlignment(Element.ALIGN_CENTER);
           p5.setAlignment(Element.ALIGN_CENTER);
           p6.setAlignment(Element.ALIGN_CENTER);
           p7.setAlignment(Element.ALIGN_CENTER);
           p8.setAlignment(Element.ALIGN_CENTER);
           p9.setAlignment(Element.ALIGN_CENTER);
           p10.setAlignment(Element.ALIGN_CENTER);
           p11.setAlignment(Element.ALIGN_CENTER);
           p12.setAlignment(Element.ALIGN_CENTER);
           p13.setAlignment(Element.ALIGN_CENTER);
           p14.setAlignment(Element.ALIGN_CENTER);
           
            doc.add(p1);
            doc.add(p2);
            doc.add(p3);
            doc.add(p4);
            doc.add(p5);
            doc.add(p6);
            doc.add(p7);
            doc.add(p8);
            doc.add(p9);
            doc.add(p10);
            doc.add(p11);
            doc.add(wall1);
            doc.add(p12);
            doc.add(p13);
            doc.add(p14);
            doc.close();
            
            
           
        
        }
        catch(Exception e){
        
            System.out.println(e);
        }
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lipno = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        cat = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        slotno = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        firstFloor = new javax.swing.JProgressBar();
        firlabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jProgressBar4 = new javax.swing.JProgressBar();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jProgressBar5 = new javax.swing.JProgressBar();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        slottable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Entrance");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Category", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Georgia", 0, 20), new java.awt.Color(5, 51, 102))); // NOI18N
        jPanel5.setToolTipText("");
        jPanel5.setName("Category"); // NOI18N

        jTable2.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"       Bisycle ", "          1"},
                {"  Three wheel", "          2"},
                {"          Car  ", "          3"},
                {"          Van ", "          4"},
                {"         Jeep ", "          5"},
                {"         Lorry ", "          6"},
                {"", null}
            },
            new String [] {
                "     Category", "     Code "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 20), new java.awt.Color(5, 51, 102))); // NOI18N

        jLabel29.setText(" Slot NO     :");

        jLabel31.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 153, 153));
        jLabel31.setText("Vehicle NO  :");

        lipno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lipno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lipnoActionPerformed(evt);
            }
        });
        lipno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lipnoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lipnoKeyTyped(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Category :");

        cat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catActionPerformed(evt);
            }
        });
        cat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                catKeyReleased(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarIcon/icons8_Weighbridge_30px.png"))); // NOI18N
        jButton2.setText("Add Vehicle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CarIcon/icons8_Clear_Symbol_30px_1.png"))); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(lipno, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(83, 83, 83)
                            .addComponent(jLabel29)
                            .addGap(18, 18, 18)
                            .addComponent(slotno, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addComponent(jLabel32)
                            .addGap(18, 18, 18)
                            .addComponent(cat, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(lipno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(slotno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(26, 26, 26))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Limitation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 20), new java.awt.Color(5, 51, 102))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel9.setText("Floor 1 :");

        firstFloor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        firlabel.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        firlabel.setText("0");

        jLabel16.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel16.setText("/100");

        jLabel18.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel18.setText("Floor 2 :");

        jProgressBar3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel20.setText("/100");

        jLabel21.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel21.setText("0");

        jLabel22.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel22.setText("Floor 3 :");

        jProgressBar4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel23.setText("/100");

        jLabel24.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel24.setText("0");

        jLabel25.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel25.setText("Floor 4 :");

        jProgressBar5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel26.setText("/100");

        jLabel27.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel27.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(firlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(firlabel)
                        .addComponent(jLabel16))
                    .addComponent(jLabel9)
                    .addComponent(firstFloor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(jLabel20))
                    .addComponent(jLabel18)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(jLabel23))
                    .addComponent(jLabel22)
                    .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(jLabel26))
                    .addComponent(jLabel25)
                    .addComponent(jProgressBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 1, 20), new java.awt.Color(198, 20, 20))); // NOI18N

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Adobe Garamond Pro Bold", 0, 24)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 0, 0));
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel28.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Entrance");

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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SLOTS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Garamond Pro Bold", 1, 24), new java.awt.Color(102, 0, 0))); // NOI18N

        slottable.setModel(new javax.swing.table.DefaultTableModel(
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
                "    Available Slots"
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
        jScrollPane4.setViewportView(slottable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Special NO.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 20), new java.awt.Color(5, 51, 102))); // NOI18N

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jTextField4.setText("Navy         :");

        jTextField12.setEditable(false);
        jTextField12.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jTextField12.setText("R");
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        jTextField11.setEditable(false);
        jTextField11.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jTextField11.setText("N");

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jTextField5.setText("Air Force   :");

        jTextField10.setEditable(false);
        jTextField10.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jTextField10.setText("A");

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jTextField3.setText("Army         :");

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jTextField6.setText("Garage No :");

        jTextField9.setEditable(false);
        jTextField9.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jTextField9.setText("G");

        jTextField7.setEditable(false);
        jTextField7.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jTextField7.setText("SRI               :");

        jTextField13.setEditable(false);
        jTextField13.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jTextField13.setText("S");
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jTextField14.setEditable(false);
        jTextField14.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jTextField14.setText("D");

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jTextField8.setText("Dash(-)       :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "QR code", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 20), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(240, 240, 240)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(48, 48, 48)
                                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lipnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lipnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lipnoActionPerformed

    private void catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          // TODO add a vehicle
         
        boolean ch1 = v.isValidVehiNum(lipno.getText());
        boolean ch2 = slotno.getText().isEmpty();
        boolean ch3 = v.isValidCat(cat.getText());
        boolean ch4 = pv.isSuspend(lipno.getText());
        
         if(ch1==true && ch2==false && ch3==true && ch4==false)
        {
            try {
                QRcodee(lipno.getText(),cat.getText(),slotno.getText());
                
            } catch (IOException ex) {
                Logger.getLogger(Entrance.class.getName()).log(Level.SEVERE, null, ex);
            }
         pv.addParkVehi(cat.getText(),lipno.getText(), slotno.getText() , "CPManager");
         String vehi = lipno.getText();
         //JOptionPane.showMessageDialog(null,vehi);
         //a.toParkMsg(vehi);
         ps.setVehiNo(lipno.getText());
         ps.setSlotNo(slotno.getText());
         ps.takeSlot();
         
         
         
         setprog();
         clear();
         
         
        
            
         waitPark(ps.getSlotNo(),vehi);
         
        }
         
         else if(ch1==true && ch2==false && ch3==true && ch4==true)
             JOptionPane.showMessageDialog(null," SUSPENDED !!!\n  must pay !!");
         
        else
            JOptionPane.showMessageDialog(null," invalid vehicle no or category , slotno cannot be empty");
         
         
          
    }//GEN-LAST:event_jButton2ActionPerformed

    private void catKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_catKeyReleased
         // TOfill slot no
         String slot = slottable.getValueAt(0, 0).toString();
         slotno.setText(slot);
         settextArea(lipno.getText(),null,slot);
         
         
    }//GEN-LAST:event_catKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void lipnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lipnoKeyReleased
         // TODO add your handling code here:
           
         
    }//GEN-LAST:event_lipnoKeyReleased

    private void lipnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lipnoKeyTyped
         // TODO add your handling code here:
      
    }//GEN-LAST:event_lipnoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cat;
    private javax.swing.JLabel firlabel;
    private javax.swing.JProgressBar firstFloor;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JProgressBar jProgressBar5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField lipno;
    private javax.swing.JTextField slotno;
    private javax.swing.JTable slottable;
    // End of variables declaration//GEN-END:variables
}
