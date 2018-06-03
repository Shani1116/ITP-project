/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entertain;

import Classes.CounterUser;
import Classes.Movies;
import Classes.Ticket;
import Classes.Validation;
import com.mysql.jdbc.Connection;
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
//import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author User
 */
public class issuemovietickt1 extends javax.swing.JInternalFrame {

   Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
     Movies m= new Movies();
     CounterUser c= new CounterUser();
     Ticket t=new Ticket();
      Validation v=new Validation();
      DateFormat tf=new SimpleDateFormat("yyyy-MM-dd");
    
    Date dt=new Date();
    public issuemovietickt1() {
        System.out.println("2");
        initComponents();
        
        con=dbconnct.connect();
        tableload4();
        //color change     
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

     public boolean CheckmyEmail(String input){
        
     String epattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}$)";
     
     Pattern p = Pattern.compile(epattern);
       
       Matcher m = p.matcher(input);
       
       if(m.matches())
           return true;
       else
           return false;
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
                   System.out.println(totalbox.getText());
                   
                   String pn1a="mmmmmmmmmm";//pn1.gettext()
                   String pn2a="nnnnnnnnnn";
                   String pn3a="bbbbbbbbbb";
                   String pn4a="wwwwwwwwww";
                   
                  // int pp1a=Integer.valueOf(totalbox.getText());
                  int pp1a=10;//Integer.valueOf(pp1.gettext())
                   int pp2a=20;
                   int pp3a=30;
                   int pp4a=40;
                   int sum=pp1a+pp2a+pp3a+pp4a;
                   
                   g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
                   g2d.drawString("---SQUARE GARDEN MOVIE THEATRE-----------------",40,y);y+=yShift;
                   g2d.drawString("  _SQUARE GARDEN SHOPPING MALL_               ",40,y);y+=yShift;
                   g2d.drawString("    NO.5,Dalada Veediya,Kandy.                ",40,y);y+=yShift;
                   g2d.drawString("        TEL-081-2222222                        ",40,y);y+=yShift;
                   g2d.drawString("______________________________________________________________",40,y);y+=yShift;
                   g2d.drawString("                                                        ",40,y);y+=yShift;
                   g2d.drawString(" Number of tickets     "+abox.getText()+"                                      ",40,y);y+=yShift;
                   g2d.drawString(" Movie Name            "+movie.getText()+"      ",40,y);y+=yShift;
                   g2d.drawString("                                                        ",40,y);y+=yShift;
                   g2d.drawString(" Sub Total             "+totalbox.getText()+"      ",40,y);y+=yShift;
                   g2d.drawString("                                                        ",40,y);y+=yShift;
                   g2d.drawString("                                                        ",40,y);y+=yShift;
                   g2d.drawString(" -----THANK YOU.COME AGAIN----  ",40,y);y+=yShift;
                
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
    
  
   
        
        
        
        
        
    

      public void tableload4(){
        
        try{
        String sq1="SELECT Movie_ID,Time,Time1,Name,Fee FROM movie  ";// WHERE current_date>Time"; //AND current_date<Time1 ";
        pst=con.prepareStatement(sq1);
        rs=pst.executeQuery();
       
        movietable.setModel(DbUtils.resultSetToTableModel((rs)));
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
        jLabel6 = new javax.swing.JLabel();
        abox = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        movietable = new javax.swing.JTable();
        movie = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        totalbox = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        emailbox = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setAutoscrolls(true);

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel5.setText("Movie Name                            :");

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel6.setText("Amount                             :");

        abox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboxActionPerformed(evt);
            }
        });
        abox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aboxKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aboxKeyTyped(evt);
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
                .addGap(184, 184, 184)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(38, 38, 38))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        movietable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Movie ID", "Movie Name", "Type", "Fee"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        movietable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                movietableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(movietable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        movie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movieActionPerformed(evt);
            }
        });
        movie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                movieKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                movieKeyTyped(evt);
            }
        });

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        jLabel16.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel16.setText("Sub Total                         :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalbox, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalbox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setText("E-mail                  :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(emailbox, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailbox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anu\\AppData\\Local\\Temp\\icons8_Print_26px_1.png")); // NOI18N
        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(movie, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(abox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(jButton1)
                .addGap(149, 149, 149))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(movie, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(abox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboxActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_aboxActionPerformed

    private void movieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movieActionPerformed

    private void movietableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movietableMouseClicked
        System.out.println("3"); 
        int r = movietable.getSelectedRow();

       m.MID = movietable.getValueAt(r, 0).toString();   
       m.Name = movietable.getValueAt(r, 3).toString();
        m.Time = movietable.getValueAt(r, 1).toString();
         m.Time2 = movietable.getValueAt(r, 2).toString();
      // m.genre = movietable.getValueAt(r, 4).toString();
       m.Fee = Double.parseDouble(movietable.getValueAt(r, 4).toString());
       
      
      movie.setText(m.Name);
//Calculate and set sub total 
        
    }//GEN-LAST:event_movietableMouseClicked

    private void movieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_movieKeyTyped
         // TODO add your handling code here:
        
         String mname = movie.getText();
         int amnt = Integer.parseInt(abox.getText());
         
         Double total =  c.calMovieTotal(mname,amnt );
         
         totalbox.setText(total.toString());
         System.out.println("5");
    }//GEN-LAST:event_movieKeyTyped

    private void movieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_movieKeyReleased
        // TODO add your handling code here:
     
        
    }//GEN-LAST:event_movieKeyReleased

    private void aboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aboxKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_aboxKeyTyped

    private void aboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aboxKeyReleased
        // TODO add your handling code here:
        
         String mname = movie.getText();
         int amnt = Integer.parseInt(abox.getText());
         
         Double total =  c.calMovieTotal(mname,amnt );
         
         totalbox.setText(total.toString());
    }//GEN-LAST:event_aboxKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        t.amount=Integer.parseInt(abox.getText());
        t.total=Float.parseFloat(totalbox.getText());
        m.Name=movie.getText();
        t.time=tf.format(dt);
       t.email=emailbox.getText();
        
        System.out.println(t.total);
        
        c.issuemovieticket(t.amount,t.total,t.email);
        
        
         PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(new BillPrintable(),getPageFormat(pj));
        
        try {
         //   System.out.println("1");
            pj.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   // movie.setText(" ");
    emailbox.setText(" ");
   // totalbox.setText(" ");
   // abox.setText(" ");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField abox;
    private javax.swing.JTextField emailbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField movie;
    private javax.swing.JTable movietable;
    private javax.swing.JTextField totalbox;
    // End of variables declaration//GEN-END:variables
}
