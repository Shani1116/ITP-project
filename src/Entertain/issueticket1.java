/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entertain;

import Classes.CounterUser;
import Classes.Games;
import Classes.Package;
import Classes.Ticket;
//import Classes.dbConnect;
import db.dbconnct;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author User
 */
public class issueticket1 extends javax.swing.JInternalFrame {

    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
     CounterUser c= new CounterUser();
     Ticket t=new Ticket();
     Games g= new Games();
     Package p1=new Package();
      DateFormat tf=new SimpleDateFormat("HH:mm:ss");
    
    Date dt=new Date();
    
    public issueticket1() {
        initComponents();
      
        
        con=dbconnct.connect();
         tableload5();
         tableload6();
         
         Date d = new Date();
        String amPm = new SimpleDateFormat("aa").format(d);
        
        if(amPm.equals("PM")){
        getContentPane().setBackground(Color.lightGray);
        }
        else
          getContentPane().setBackground(Color.decode("#F5F5F5"));  
    }
public PageFormat getPageFormat(PrinterJob pj)
{

    PageFormat pf = pj.defaultPage();
    Paper paper = pf.getPaper();    

    double middleHeight =8.0;  //dynamic----->change with the row count of jtable
    double headerHeight = 2.0;                  //fixed----->but can be mod
    double footerHeight = 2.0;                  //fixed----->but can be mod

    double width = convert_CM_To_PPI(8)  ;   //printer know only point per inch.default value is 72ppi
    double height = convert_CM_To_PPI(headerHeight+middleHeight+footerHeight) ;//13
    paper.setSize(width, height);
    paper.setImageableArea(                    
        0,
        10,
        width,            
        height - convert_CM_To_PPI(1)
    );   //define boarder size    after that print area width is about 180 points

    pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
    pf.setPaper(paper);    

    return pf;
}

   protected static double convert_CM_To_PPI(double cm)
   {
       return toPPI(cm*0.393600787);
   }   
   
   protected static double toPPI(double inch)
   {
       return inch*72d;
   }
   
   public class BillPrintable implements Printable{
   
       public int print(Graphics graphics, PageFormat pageFormat,int pageIndex)
       throws PrinterException
       {
           int result = NO_SUCH_PAGE;
           
           if(pageIndex==0)
           {
               Graphics2D g2d = (Graphics2D) graphics;
               
               double width = pageFormat.getImageableWidth();
               
               g2d.translate((int)pageFormat.getImageableX(),(int)pageFormat.getImageableY());
               
               
               FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
               
               int idLength=metrics.stringWidth("000");
               int amtLength=metrics.stringWidth("000000");
               int qtyLength=metrics.stringWidth("00000");
               int priceLength=metrics.stringWidth("000000");
               int prodLength=(int)width - idLength - amtLength - qtyLength - priceLength - 17;
               
               int productPosition = 0;
               int discountPosition = prodLength+5;
               int pricePosition = discountPosition+idLength+10;
               int qtyPosition = pricePosition+priceLength+4;
               int amtPosition = qtyPosition+qtyLength;
               
               try {
                   int y=20;
                   int yShift = 10;
                   int headRectHeightr=15;
                   int headRectHeighta=40;
                   
                   String pn1a="mmmmmmmmmm";//pn1.gettext()
                   String pn2a="nnnnnnnnnn";
                   String pn3a="bbbbbbbbbb";
                   String pn4a="wwwwwwwwww";
                   
                   int pp1a=10;//Integer.valueOf(pp1.gettext())
                   int pp2a=20;
                   int pp3a=30;
                   int pp4a=40;
                   int sum=pp1a+pp2a+pp3a+pp4a;
                   
                   g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
                      g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
                   g2d.drawString("---SQUARE GARDEN GAME-ZONE-----------------",40,y);y+=yShift;
                   g2d.drawString("  _SQUARE GARDEN SHOPPING MALL_               ",40,y);y+=yShift;
                   g2d.drawString("    NO.5,Dalada Veediya,Kandy.                ",40,y);y+=yShift;
                   g2d.drawString("        TEL-081-2222222                        ",40,y);y+=yShift;
                   g2d.drawString("______________________________________________________________",40,y);y+=yShift;
                   g2d.drawString("                                                        ",40,y);y+=yShift;
                   g2d.drawString(" Game Name             "+gamebox.getText()+"           ",40,y);y+=yShift;
                   g2d.drawString(" Package Name          "+packagebox.getText()+"        ",40,y);y+=yShift;
                   g2d.drawString(" Game Total            "+totalbox.getText()+"         ",40,y);y+=yShift;
                   g2d.drawString(" Package Total         "+total1box.getText()+"        ",40,y);y+=yShift;
                   g2d.drawString("                                                        ",40,y);y+=yShift;
                   g2d.drawString("Sub Total             "+subtotalbox.getText()+"         ",40,y);y+=yShift;
                    g2d.drawString(" -----THANK YOU.COME AGAIN----  ",40,y);y+=yShift;
                  /* g2d.drawString("1 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("2 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("3 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("4 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("5 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("6 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("7 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("8 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("9 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("10 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("11 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("12 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("13 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("14 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("15 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("16 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("17 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("18 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("19 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("20 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   //g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
                   g2d.drawString("1 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("2 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("3 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("4 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("5 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("6 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("7 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("8 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("9 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("10 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("11 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("12 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("13 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("14 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("15 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("16 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("17 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("18 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("19 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;
                   g2d.drawString("20 123456789a123456789b123456789c123456789d123456789e123456789f",40,y);y+=yShift;*/
                   
                   //g2d.drawString("            CHEck MY BILL         ",12,y);y+=yShift;
                   //g2d.drawString("123456789a123456789b123456789c123456789d123456789e123456789f123456789g",12,y);y+=headRectHeightr;
                   //g2d.drawOval(20,20, 20, 20);
                   
                   BufferedImage image;
                //   g2d.drawImage(image, null, y, y);
                   
                   Image wall1,wall2;

    /*try 
        {wall1= ImageIO.read(new File("C:\\Users\\Yasith\\Desktop\\PicsArt_11-17-11.24.20.jpg"));
        wall2= ImageIO.read(new File("C:\\Users\\Yasith\\Desktop\\PicsArt_11-17-11.24.20.jpg"));
        int d=100;
        int w=50;
        g2d.drawImage(wall1, d, d, 10, d, null);
        g2d.drawImage(wall1, 20, 50, w, w, null);
        
        
        //g2d.drawImage(wall, getX(), getY(), getWidth(), getHeight(), null);
        }
    catch (IOException e)
        {e.printStackTrace();}*/

    
  
                   
               } catch (Exception r) {
                   r.printStackTrace();
               }
               
               result = PAGE_EXISTS;
           }
           return result;
           
       }
   }
     public void tableload5(){
        
        try{
        String sq1="SELECT Name,Fee FROM game";
        pst=con.prepareStatement(sq1);
        rs=pst.executeQuery();
       
       gametable.setModel(DbUtils.resultSetToTableModel((rs)));
        }
        catch(Exception e)
        {
        
        }
    }
     
      public void tableload6(){
        
        try{
        String sq1="SELECT p_name,Fee FROM package";
        pst=con.prepareStatement(sq1);
        rs=pst.executeQuery();
       
       packagetable.setModel(DbUtils.resultSetToTableModel((rs)));
        }
        catch(Exception e)
        {
        
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        packagebox = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        packagetable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        gametable = new javax.swing.JTable();
        gamebox = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        amountbox = new javax.swing.JTextField();
        total1box = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        abox = new javax.swing.JTextField();
        totalbox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        subtotalbox = new javax.swing.JTextField();
        subb = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setAutoscrolls(true);

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel5.setText("Package                            :");

        jButton1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anu\\AppData\\Local\\Temp\\icons8_Print_26px.png")); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("GAMEZONE AND THEATRE MANAGEMENT ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(29, 29, 29))
        );

        jLabel8.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel8.setText("Game                                   :");

        packagebox.setEditable(false);
        packagebox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                packageboxKeyTyped(evt);
            }
        });

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        packagetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Package", "Fee"
            }
        ));
        packagetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                packagetableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(packagetable);

        gametable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Game Name", "Fee"
            }
        ));
        gametable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gametableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gametable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(271, 271, 271))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        gamebox.setEditable(false);
        gamebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameboxActionPerformed(evt);
            }
        });
        gamebox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gameboxKeyTyped(evt);
            }
        });

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        jLabel11.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel11.setText("Amount                             :");

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel7.setText("Package Total                         :");

        amountbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountboxActionPerformed(evt);
            }
        });
        amountbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amountboxKeyReleased(evt);
            }
        });

        total1box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                total1boxKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                total1boxKeyTyped(evt);
            }
        });

        jLabel2.setText("For Packages");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total1box)
                    .addComponent(amountbox))
                .addGap(36, 36, 36))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amountbox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total1box, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        jPanel5.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel5ComponentShown(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel12.setText("Amount                             :");

        jLabel13.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel13.setText("Gamezone Total           :");

        abox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboxActionPerformed(evt);
            }
        });
        abox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aboxKeyReleased(evt);
            }
        });

        totalbox.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                totalboxComponentAdded(evt);
            }
        });
        totalbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                totalboxKeyReleased(evt);
            }
        });

        jLabel3.setText("For Games");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalbox)
                    .addComponent(abox))
                .addGap(36, 36, 36))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(abox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalbox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        jLabel16.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel16.setText("Sub Total                         :");

        subb.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        subb.setText("Sub Total");
        subb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subtotalbox)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(subb, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subtotalbox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(subb, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jButton2.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gamebox))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(packagebox, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jButton2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(packagebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(gamebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(613, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amountboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountboxActionPerformed

    private void aboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aboxActionPerformed

    private void packagetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_packagetableMouseClicked
        int r=packagetable.getSelectedRow();
        
        p1.Name=packagetable.getValueAt(r,0).toString();
        p1.Fee=Float.parseFloat(packagetable.getValueAt(r,1).toString());
        
        packagebox.setText(p1.Name);
        
        String g =total1box.getText();
        String p=totalbox.getText();
        
       Double sb =  c.calSubtot(g,p );
        
    }//GEN-LAST:event_packagetableMouseClicked

    private void gameboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gameboxKeyTyped
       String gname=gamebox.getText();
        int amnt = Integer.parseInt(abox.getText());
        
        Double total =  c.calGameTotal(gname,amnt );
         
         totalbox.setText(total.toString());
    }//GEN-LAST:event_gameboxKeyTyped

    private void totalboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalboxKeyReleased
        
        String g =total1box.getText();
        String p=totalbox.getText();
        
       Double sb =  c.calSubtot(g,p );
        
    }//GEN-LAST:event_totalboxKeyReleased

    private void aboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aboxKeyReleased
         String gname = gamebox.getText();
         int amnt = Integer.parseInt(abox.getText());
         
         Double total =  c.calGameTotal(gname,amnt );
         
         totalbox.setText(total.toString());
    }//GEN-LAST:event_aboxKeyReleased

    private void packageboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_packageboxKeyTyped
        String pname = packagebox.getText();
         int amnt = Integer.parseInt(abox.getText());
         
         Double total1 =  c.calPackageTotal(pname,amnt );
         
         total1box.setText(total1.toString());
    }//GEN-LAST:event_packageboxKeyTyped

    private void amountboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountboxKeyReleased
        String pname = packagebox.getText();
         int amnt = Integer.parseInt(amountbox.getText());
         
         Double total1 =  c.calPackageTotal(pname,amnt );
         
         total1box.setText(total1.toString());
    }//GEN-LAST:event_amountboxKeyReleased

    private void total1boxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_total1boxKeyReleased
        // TODO add your handling code here:
        
        String g =total1box.getText();
        String p=totalbox.getText();
        
       Double sb =  c.calSubtot(g,p );
       
       subtotalbox.setText(sb.toString());
    }//GEN-LAST:event_total1boxKeyReleased

    private void jPanel5ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel5ComponentShown
        // TODO add your handling code here:
        
        String g =total1box.getText();
        String p=totalbox.getText();
        
       Double sb =  c.calSubtot(g,p );
    }//GEN-LAST:event_jPanel5ComponentShown

    private void totalboxComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_totalboxComponentAdded
        // TODO add your handling code here:
        
        String g =total1box.getText();
        String p=totalbox.getText();
        
       Double sb =  c.calSubtot(g,p );
    }//GEN-LAST:event_totalboxComponentAdded

    private void total1boxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_total1boxKeyTyped
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_total1boxKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // t.ticketId=jTextField1.getText();
        t.type="g";
        
        t.total=Float.parseFloat(subtotalbox.getText());
       g.Name=gamebox.getText();
        t.time=tf.format(dt);
        int a=Integer.parseInt(abox.getText());
         int b=Integer.parseInt(amountbox.getText());
         t.amount=(a+b);
        
        c.issuegameticket(t.amount,t.total);
        
        System.out.println(t.total);
        
          PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(new BillPrintable(),getPageFormat(pj));
        
        try {
            pj.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void gametableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gametableMouseClicked
       int r=gametable.getSelectedRow();

        g.Name=gametable.getValueAt(r, 0).toString();
        g.Fee=Float.parseFloat(gametable.getValueAt(r, 1).toString());

        gamebox.setText(g.Name);

        String g =total1box.getText();
        String p=totalbox.getText();

        Double sb =  c.calSubtot(g,p );
    }//GEN-LAST:event_gametableMouseClicked

    private void subbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subbActionPerformed
         // TODO add your handling code here:
         Double stot = Double.parseDouble(total1box.getText())+Double.parseDouble(totalbox.getText());
         subtotalbox.setText(stot.toString());
         
    }//GEN-LAST:event_subbActionPerformed

    private void gameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gameboxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        packagebox.setText("");
        gamebox.setText("");
        amountbox.setText("");
        abox.setText("");
        totalbox.setText("");
        total1box.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField abox;
    private javax.swing.JTextField amountbox;
    private javax.swing.JTextField gamebox;
    private javax.swing.JTable gametable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField packagebox;
    private javax.swing.JTable packagetable;
    private javax.swing.JButton subb;
    private javax.swing.JTextField subtotalbox;
    private javax.swing.JTextField total1box;
    private javax.swing.JTextField totalbox;
    // End of variables declaration//GEN-END:variables
}
