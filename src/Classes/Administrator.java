package Classes;

//import .*;



   

import Classes.Bands;
import Classes.Movies;
import Classes.Request;
import db.dbconnct;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Administrator {
    Connection con = dbconnct.connect();;
    PreparedStatement pst=null;
    ResultSet rs = null;
    
    public String Name;
    public String NIC;
    public String AID;
    String emp="e123";
    
    Bands b1 = new Bands();
    
    Package P1=new Package();
    
    Games g=new Games();
    
    Movies m=new Movies();
    
    entincome e=new entincome();
    
    Request r=new Request();
    
    
     DateFormat tf=new SimpleDateFormat("HH:mm:ss");
    DateFormat dft=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    
    Date dt=new Date();
    
    
     
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getAID() {
        return AID;
    }

    public void setAID(String AID) {
        this.AID = AID;
    }
   
    
      public void addbanddetails (String n,Integer nu,float f){
        b1.Name = n;
        b1.fee = f;
        b1.number = nu;
       // b1.BID = i;
        
        String q ="INSERT INTO music_bands(Name,Members_number,Payment)  VALUES ('"+ b1.Name +"' , '"+ b1.number +"' , '" + b1.fee +"')";
        try{
        
        pst =con.prepareStatement(q);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One music band is added to the database");
        }catch(Exception e){
         System.out.println(e);
         System.out.print(b1.Name);

    }
    }
  /*  public void addbanddetails (String n,Integer nu,float f){
        b1.Name = n;
        b1.fee = f;
        b1.number = nu;
       // b1.BID = i;
        
        String q ="INSERT INTO music_bands  VALUES ('"+ b1.Name +"' , '"+ b1.number +"' , '" + b1.fee +"')";
        try{
        
        pst =con.prepareStatement(q);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One music band is added to the database");
        }catch(Exception e){
         System.out.println(e);
    }
    }*/
    public void addpackagedetails(String n1,String g1,String g2,String g3,float p){
    
         P1.Name= n1;
   // P1.PackageId= i1;
     P1.game1 = g1;
     P1.game2= g2;
     P1.game3 = g3;
     P1.Fee = p;
     System.out.println(P1.Name);
       System.out.println(P1.game1);
     
     String w ="INSERT INTO package (p_name,Game1,Game2,Game3,Fee) VALUES ('"+ P1.Name +"' , '"+ P1.game1 +"' , '" + P1.game2 +"','"+ P1.game3 +"','"+P1.Fee +"')";
    try{
        
        pst =con.prepareStatement(w);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One package is added to the database");
        }catch(Exception e){
         System.out.println(e);
    }
        
        /* P1.Name= n1;
    P1.PackageId= i1;
     P1.game1 = g1;
     P1.game2= g2;
     P1.game3 = g3;
     P1.Fee = p;
     String w ="INSERT INTO package VALUES ('"+ P1.Name +"','"+ P1.PackageId +"' , '"+ P1.game1 +"' , '" + P1.game2 +"','"+ P1.game3 +"','"+P1.Fee +"')";
    try{
        
        pst =con.prepareStatement(w);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One package is added to the database");
        }catch(Exception e){
         System.out.println(e);
    }*/
    
    
    
    }
    public void addgamesdetails(String n1,Float f1){
        
      g.Name=n1;
      //g.GID=i1;
      g.Fee=f1;
      
       System.out.println(g.Name);
       System.out.println(g.Fee);
       String q ="INSERT INTO game (Name,Fee) VALUES ('"+ g.Name +"', '"+ g.Fee +"' )";
      try{
        
        pst =con.prepareStatement(q);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One game is added to the database");
        }
        catch(SQLException e){
        System.out.println(e);
        
        }
        
    
    }
     public void addmoviedetails(String s1,String s2,String n1,String g1,Double f1){
        
      //  m.MID=m1;
        m.Time=s1;
        m.Time2=s2;
        m.Name=n1;
        m.genre=g1;
        m.Fee=f1;
        
        
        System.out.println(m.Name);
       System.out.println(m.Fee);
        System.out.println(m.Time);
         System.out.println(m.Time2);
          System.out.println(m.genre);
         String n="INSERT INTO movie (Time,Time1,Name,Genre,Fee) VALUES ('"+m.Time+"','"+m.Time2+"','"+m.Name+"','"+m.genre+"','"+m.Fee+"')";
        try{
       
        pst =con.prepareStatement(n);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One movie is added to the database");
        }catch(SQLException e){
        System.out.println(e);
        
        }
        
    }
  /*  public void addmoviedetails(String s1,String s2,String n1,String g1,Double f1){
        
      //  m.MID=m1;
        m.Time=s1;
        m.Time2=s2;
        m.Name=n1;
        m.genre=g1;
        m.Fee=f1;
        
        System.out.println(m.Name);
       System.out.println(m.Fee);
         String n="INSERT INTO movie (Screen,Screen2,Name,Genre,Fee) VALUES ('"+ m.Time  +"' , '"+m.Time2+"',"+ m.Name +"' , '"+ m.genre +"' , '"+ m.Fee +"')";
        try{
       
        pst =con.prepareStatement(n);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One movie is added to the database");
        }catch(SQLException e){
        System.out.println(e);
        
        }
        
    }*/
      public void editpackage(String pid,String g1,String g2,String g3,float f1){ //float 
    
      P1.PackageId=pid;
       P1.game1=g1;
       P1.game2=g2;
       P1.game3=g3;
       P1.Fee=f1;
       
        
        String pq="UPDATE package SET Package_ID='"+P1.PackageId+"', Game1= '"+ P1.game1 +"' , Game2= '"+ P1.game2 +"', Game3 = '"+ P1.game3 +"', Fee = '"+P1.Fee+"'  WHERE Package_ID='"+P1.PackageId+"'";
        
        try{
        
        pst =con.prepareStatement(pq);
        
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"One package detail is changed");
        
        }catch(SQLException e){
        System.out.println("error in loading to database");
        System.out.println(e); 
        }
        
        
    }
   /* public void editpackage(String pid,String g1,String g2,String g3,float f1){ //float 
    
       P1.PackageId=pid;
       P1.game1=g1;
       P1.game2=g2;
       P1.game3=g3;
       P1.Fee=f1;
       
        
        String pq="UPDATE package SET p_id='"+P1.PackageId+"',game1= '"+ P1.game1 +"' , game2= '"+ P1.game2 +"', game3 = '"+ P1.game3 +"', fee = '"+P1.Fee+"'  WHERE p_id='"+P1.PackageId+"'";
        
        try{
        
        pst =con.prepareStatement(pq);
        
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"One package detaile is changed");
        
        }catch(SQLException e){
        System.out.println("error in loading to database");
        System.out.println(e); 
        }
        
        
    }*/
    
        public void editmovie(String m1,String s1,String s2,String n1,Double f1){ //float 
    
        m.MID=m1;
        m.Time=s1;
        m.Time2=s2;
        m.Name=n1;
        m.Fee=f1;
        System.out.println(m.Time);
         System.out.println(m.Time2);
          System.out.println(m.Name);
           System.out.println(m.Fee);
        String pq="UPDATE movie SET Movie_ID='"+m.MID+"', Time= '"+m.Time+"',Time1='"+m.Time2+"', Name='"+ m.Name +"',Fee='"+m.Fee+"' WHERE Movie_ID='"+m.MID+"'";
        
        try{
        
        pst =con.prepareStatement(pq);
        
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"One movie details are changed");
        System.out.println(m.Time);
         System.out.println(m.Time2);
          System.out.println(m.Name);
           System.out.println(m.Fee);
        }catch(SQLException e){
        System.out.println("error in loading to database");
        
        }
        
        
    }
      
 /*   public void editmovie(String m1,String s1,String n1,float f1){ //float 
    
        m.MID=m1;
        m.Time=s1;
        m.Name=n1;
        m.Fee=f1;
        
        String pq="UPDATE movie SET mid= '"+ m.MID +"' , screen= '"+ m.Time +"', name='"+ m.Name +"',Fee='"+m.Fee+"' WHERE mid='"+m.MID+"'";
        
        try{
        
        pst =con.prepareStatement(pq);
        
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"One movie details are changed");
        
        }catch(SQLException e){
        System.out.println("error in loading to database");
        
        }
        
        
    }*/
    
          public void editgame(String g1,String n,float f ){ //float 
    
     g.GID=g1;
       g.Name=n;
       g.Fee=f;
        
        String pq="UPDATE game SET GameId='"+g.GID+"', Name= '"+ g.Name +"', Fee='"+ g.Fee +"' WHERE GameId= '"+g.GID+"' ";
        
        try{
        
        pst =con.prepareStatement(pq);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One game details are changed");
        
        }catch(SQLException e){
        System.out.println("error in loading to database"+e);
        
        }
        
        
    }
        
   /*  public void editgame(String g1,String n,float f ){ //float 
    
       g.GID=g1;
       g.Name=n;
       g.Fee=f;
        
        String pq="UPDATE game SET gid= '"+ g.GID +"' , name= '"+ g.Name +"', fee='"+ g.Fee +"' WHERE gid= '"+g.GID+"' ";
        
        try{
        
        pst =con.prepareStatement(pq);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One game details are changed");
        
        }catch(SQLException e){
        System.out.println("error in loading to database"+e);
        
        }
        
        
    }*/

public void editband(Integer b,String n,float f){ 
        
       b1.BID = b;
        b1.Name = n;
        b1.fee = f;
        System.out.println(b1.Name);
    System.out.println(b1.fee);
        String pq="UPDATE music_bands SET Band_ID='"+b1.BID+"', Name= '"+ b1.Name +"',Payment='"+b1.fee+"' WHERE Band_ID='"+b1.BID+"'";
        
        try{
        
        pst =con.prepareStatement(pq);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One band details are changed");
        
        }catch(SQLException e){
        System.out.println("error in loading to database");
        
        }
        
        
    }
/*public void editband(String b,String n,float f){ 
        
        b1.BID = b;
        b1.Name = n;
        b1.fee = f;
        
        String pq="UPDATE music_bands SET mu_id= '"+ b1.BID +"' , name= '"+ b1.Name +"',payment='"+b1.fee+"' WHERE mu_id='"+b1.BID+"'";
        
        try{
        
        pst =con.prepareStatement(pq);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One band details are changed");
        
        }catch(SQLException e){
        System.out.println("error in loading to database");
        
        }
        
        
    }*/
    
     public void deletepackage (String p1 ){
         
       P1.PackageId=p1;
       
       
        
        String pq="DELETE FROM package WHERE p_id= '"+ P1.PackageId +"'";
         System.out.println(pq);
        try{
        
        pst =con.prepareStatement(pq);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One package is deleted");
        
        }catch(SQLException e){
        System.out.println("error in loading to database");
        
        }
      
         
    
    }
    
 public void deletegames (String g1,String n,float f ){
         
       g.GID=g1;
       g.Name=n;
       g.Fee=f;
        
        String pq="DELETE FROM game WHERE GameId= '"+ g.GID +"'";
         System.out.println(pq);
        try{
        
        pst =con.prepareStatement(pq);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One game is deleted");
        
        }catch(SQLException e){
        System.out.println("error in loading to database");
        
        }
      
         
    
    }

   /*  public void deletegames (String g1,String n,float f ){
         
       g.GID=g1;
       g.Name=n;
       g.Fee=f;
        
        String pq="DELETE FROM game WHERE gid= '"+ g.GID +"'";
         System.out.println(pq);
        try{
        
        pst =con.prepareStatement(pq);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One game is deleted");
        
        }catch(SQLException e){
        System.out.println("error in loading to database");
        
        }
      
         
    
    }*/
       public void deletemovie(String m1){ //float 
           //,String s1,String n1,String g1,float f1
        m.MID=m1;
//        m.Time=s1;
//        m.Name=n1;
//        m.Fee=f1;
//        m.genre=g1;
        
        String pq="DELETE FROM movie WHERE Movie_ID= '"+ m.MID +"' ";
           System.out.println(pq);
        try{
        
        pst =con.prepareStatement(pq);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One movie is deleted");
        
        }catch(SQLException e){
        System.out.println("error in loading to database");
        
        }
        
        
    }
   /*    public void deletemovie(String m1){ //float 
           //,String s1,String n1,String g1,float f1
        m.MID=m1;
//        m.Time=s1;
//        m.Name=n1;
//        m.Fee=f1;
//        m.genre=g1;
        
        String pq="DELETE FROM movie WHERE mid= '"+ m.MID +"' ";
           System.out.println(pq);
        try{
        
        pst =con.prepareStatement(pq);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One movie is deleted");
        
        }catch(SQLException e){
        System.out.println("error in loading to database");
        
        }
        
        
    }*/
   public void deleteband(Integer b){ 
    
        // b1.Name = n;
       // b1.fee = f;
        //b1.number=nu;
        b1.BID = b;
        
        String pq="DELETE FROM music_bands WHERE Band_ID='"+b1.BID+"'";
        
        try{
        
        pst =con.prepareStatement(pq);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One band is deleted");
        
        }catch(SQLException e){
        System.out.println("error in loading to database");
        
        }
        
        
    }
    /* public void deleteband(String b){ 
    
        // b1.Name = n;
       // b1.fee = f;
        //b1.number=nu;
        b1.BID = b;
        
        String pq="DELETE FROM music_bands WHERE mu_id='"+b1.BID+"'";
        
        try{
        
        pst =con.prepareStatement(pq);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One band is deleted");
        
        }catch(SQLException e){
        System.out.println("error in loading to database");
        
        }
        
        
    }*/

     public Double calMovieTotal(String mtype,String da)
    {
          
        
         try {
             String q = "SELECT SUM(Total) FROM ticket1 WHERE type = '"+mtype+"' AND Date = '"+da+"'";
             
                pst = con.prepareStatement(q);
                rs = pst.executeQuery();
                rs.next();
                
                double tot = Double.parseDouble(rs.getString("SUM(Total)"));
                
               // JOptionPane.showMessageDialog(null, "hjk");
                return tot;
                
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Problem with calMovieTotal method "+ex);
        
             
             return -1.1;
         }
        
    }
     
      public Double calGameTotal(String gtype,String da)
    {
          
        
         try {
             
             String q = "SELECT SUM(Total) FROM ticket1 WHERE type = '"+gtype+"' AND Date = '"+da+"'";
             
                pst = con.prepareStatement(q);
                rs = pst.executeQuery();
                rs.next();
                
                String t = rs.getString("SUM(Total)");
                
                double tot = Double.parseDouble(t);
                
                
                return tot;
                
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Problem with calGameTotal method "+ex);
        
             
             return -1.1;
         }
         
         
         
         
        
    }
    
      
      public void addmovieincome(double a){
      
      e.amount=a;
      String type="m";
      String dep="Moviezone";
     // e.date=da;
      //t.time=(dft.format(dt));
     
      String q= "INSERT INTO ent_income(amount,type,dep,date,emp_id) VALUES ('"+e.amount +"','"+ type +"','"+ dep +"','"+dft.format(dt)+"','"+ emp +"')";
      
      
      try{
        
        pst =con.prepareStatement(q);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One income is added");
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null,e);
    }
      
      
      }
      
      
      
      public void addgameincome(double a){
      
      e.amount=a;
      String type="g";
      String dep="Gamezone";
     // e.date=da;
      
      String q= "INSERT INTO ent_income(amount,type,dep,date,emp_id) VALUES ('"+e.amount +"','"+ type +"','"+ dep +"','"+dft.format(dt)+"','"+ emp +"')";
      
      
      try{
        
        pst =con.prepareStatement(q);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One income is added");
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null,e);
    }
      
      
      }
      
      
     public void sendrequest(String r1,double a)
      {
      r.Request=r1;    
      r.amount=a;
      String department="Entertainment";
      String status="Requested";
      
      String q="INSERT INTO request (req,amount,department,status) VALUES ('"+ r.Request +"','"+ r.amount +"','"+ department +"','"+ status +"')";
      
       try{
        
        pst =con.prepareStatement(q);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One request is sent");
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null,e);
    }
      
      
      
      
      }
      public void removeetails (){
    
    }
       public void getreport (){
    
    }
 }
