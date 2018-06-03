
package Carpark_class;

import CarPark_Interfaces.Entrance;
import CarPark_Interfaces.Payments;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;  

public class Arduino implements SerialPortEventListener{

    SerialPort serialPort;
    
    static Connection conn = dbconnct.connect();
   
    static PreparedStatement pst = null;
    static ResultSet rs = null;
    
   Paymentsc p = new Paymentsc();
   
   public static int minute=0;
   
   
   
    
    private static final String PORT_NAMES[] = {"COM7"};
    
    int count = 0;//
    int cnt = 0;//
    int pdepth = 12;//
    int ndepth = 12;//
    int time = 5;//
    int defDepth = 12;//default Depth
    String display="F1A1";
    
     String slot = null;
     String ava=null;
    
    
    private BufferedReader input;  
    private OutputStream output;
    
    private static final int TIME_OUT = 2000; /** Milliseconds to block while waiting for port open */
    private static final int DATA_RATE = 9600;
    
    
    
    public void initialize() 
    {
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
        
        while (portEnum.hasMoreElements()) 
        {   //First, Find an instance of serial port as set in PORT_NAMES.
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
        
            for (String portName : PORT_NAMES)
            {
                if (currPortId.getName().equals(portName))
                {
                    portId = currPortId;
                    break;
                }
            }
        }
    
        
        if (portId == null) 
        {
            System.out.println("Could not find COM port.");
            return;
        }
        
        try 
        {          // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);
            serialPort.setSerialPortParams(DATA_RATE,  // set port parameters
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));   // open the streams
            output = serialPort.getOutputStream();
            serialPort.addEventListener(this);   // add event listeners
            serialPort.notifyOnDataAvailable(true);
            
        }
        catch (Exception e)
        {
            System.err.println(e.toString());
        }
    }
    
    
    public synchronized void close() 
    {                      
        if (serialPort != null)
        {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }
    
    
    
    public synchronized void serialEvent(SerialPortEvent oEvent)
    {
         this.setLCD(display);
        
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) 
        {
            this.setLCD(display);
            
            try 
            {
                
                
                String inputLine=input.readLine();
                this.slotReject();
                this.setLCD(display);                
                this.slotReject();
                
              
                System.out.println(inputLine);
                
               
                
                if(inputLine.length()==2)
                {
                    slot = inputLine.substring(0, 1);
                    ava =  inputLine.substring(1,2);
                }
                
                
                if(ava.equals("1"))
                {
                    if(slot.equals("1"))
                    {
                        updatesenAva("F1A1",1,"parked");
                        //setLCD("F1A2");  
                        setLCD(display);
                    }
                            
                    if(slot.equals("2"))
                    {
                        updatesenAva("F1A2",1,"parked");
                        //setLCD("F1A2");
                    }
                            
                   if(slot.equals("3"))
                   {
                        updatesenAva("F1A3",1,"parked");
                      
                    }
                }
                
                
                else if(ava.equals("0"))
                {
                    if(slot.equals("1"))
                    {
                        updatesenAva("F1A1",0,"toexit");
                        this.updateSlotStatusExit("available","F1A1", "&&&&&&&", "reject");
                        this.updateSlotStatusExit("toexit","F1A1", "parked", "&&&&&&");
                        //setLCD("F1A2");
                        setLCD(display);
                                
                    }
                                                      
                            
                    if(slot.equals("2"))
                    {
                        updatesenAva("F1A2",0,"toexit");
                        this.updateSlotStatusExit("available","F1A2", "&&&&&&", "reject");
                        this.updateSlotStatusExit("toexit","F1A2", "parked", "&&&&&&");
                        //setLCD("F1A2");
                    }
                                
                                                        
                    if(slot.equals("3"))
                    {
                        updatesenAva("F1A3",0,"toexit");
                        this.updateSlotStatusExit("available","F1A3", "&&&&&&", "reject");
                        this.updateSlotStatusExit("toexit","F1A3", "parked", "&&&&&&");
                        //setLCD(display);
                    }                
                }
                
            } 
            catch (IOException | NumberFormatException e) 
            {
                System.err.println(e.toString());
            }
        }
        
    }
    
    public void updatesenAva(String slotNO,int senAva,String stat)
    {
        
        String sql = " UPDATE carparkslot SET senAva = '"+senAva+"' WHERE slotNo='"+slotNO+"' ";
        
        try {
            
            pst = conn.prepareStatement(sql);
            pst.execute();
            
            parkingVehicles.updateParkingVehi(slotNO,stat);
            
        } catch (SQLException e) {
            
            System.out.println(e);
        }
    }
    
   
    
    
    
    public void updateSlotStatus(String slot)
    {
        String sql = "UPDATE carparkslot SET status='"+"available"+"' , vehilic='"+"-"+"' WHERE slotNo='"+slot+"' AND status='"+"parked"+"' AND senAva='"+0+"'";
        
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
          
                   
        } catch (SQLException e) {
            
            System.out.println(e);
        }
    }
    
    public static void updateSlotStatusExit(String newStatus,String slot,String stat1,String stat2)
    {
        String sql=null;
        
        if(newStatus.equalsIgnoreCase("toexit")||newStatus.equalsIgnoreCase("parked"))
        {
             sql = "UPDATE carparkslot SET status='"+newStatus+"' WHERE slotNo='"+slot+"' AND (status='"+stat1+"' OR status='"+stat2+"') " ;
        
        }
        
        else
        {
              sql = "UPDATE carparkslot SET status='"+newStatus+"' , vehilic='"+"-"+"' WHERE slotNo='"+slot+"' AND (status='"+stat1+"' OR status='"+stat2+"') " ;
        }
        
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
          
                   
        } catch (SQLException e) {
            
            System.out.println(e);
        }
    }  
    
    public void slotReject()
    {
        String sq = "SELECT slotNo FROM carparkslot WHERE status= '"+"available"+"' AND senAva='"+1+"' ";
        
        try {
            pst = conn.prepareStatement(sq);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                String rejSlot = rs.getString("slotNo");
                System.out.println(rejSlot);
                String upq = "UPDATE carparkslot SET status='"+"reject"+"' WHERE slotNo='"+rejSlot+"' ";
                
                try {
                    pst = conn.prepareStatement(upq);
                    pst.execute();
                } catch (SQLException e) {
                    System.out.println("Arduino/slotRej/upq "+e);
                }
            }
        } catch (SQLException e) {
            System.out.println("Arduino/slotRej/sq "+e);
        }
        
        
        
    }
    
    
    
    public void setLCD(String slotNo)
    {
        String sq = "SELECT status,vehilic FROM carparkslot WHERE slotNo='"+slotNo+"'";
        
        try {
            pst = conn.prepareStatement(sq);
            rs = pst.executeQuery();
            rs.next();
            
            String status = rs.getString("status");
            String vehilic = rs.getString("vehilic");
            String f,s,c,d;
            f = null;
            s = null;
            int l;
            //JOptionPane.showMessageDialog(null,status+"       "+vehilic);
            if(status.equalsIgnoreCase("available"))
            {
                f = ":F1A1           ";
                s = "    Available   ";
                this.displayLCD(f, s);
            }
            
            
            
            else if(status.equalsIgnoreCase("parked"))
            {
                c = Conver_Vali.convertVehiNo(vehilic);
                
                
                String n=null;
                
                d = parkingVehicles.getVehicat(vehilic,"in","toexit");
                l = d.length();
                
                
                if(d.equalsIgnoreCase("Bicycle"))     n="(B)";
                else if(d.equalsIgnoreCase("Three Wheel"))     n="(3W)";
                else if(d.equalsIgnoreCase("Car"))    n="(C)";
                else if(d.equalsIgnoreCase("Van"))    n="(V)";
                else if(d.equalsIgnoreCase("Jeep"))   n="(J)";
                else if(d.equalsIgnoreCase("Lorry"))  n="(L)";
                           
                l = c.length();
                
                if(l==6) f="    "+c+n+"   ";
                else if(l==7) f="   "+c+n+"   ";
                else if(l==8) f="   "+c+n+"  ";
                else if(l==9) f="  "+c+n+"  ";
                else if(l==10) f="  "+c+n+" ";
                else if(l==11) f="  "+c+n;
                
                
                
                int du = p.getParkedDu(vehilic,"in","null&&&&")+minute ;
                
                int hr = du/60;
                int min = du%60;
                //JOptionPane.showMessageDialog(null,du+"          "+hr+"        "+min);
                s = "   "+Integer.toString(hr)+"hr "+Integer.toString(min)+"min       ";
                System.out.println("       miujj                     mmmmmmmmmmmm"+du+"mmmmmmmmmmmmmmmm"+minute);
                
                              
                this.displayLCD(f, s);
            }
            
            else if(status.equalsIgnoreCase("reject"))
            {
                f = "    REJECTED    ";
                s = " -wrong  place- ";
                this.displayLCD(f, s);
            }
            
            else if(status.equals("topark"))
            {
               this.toParkMsg(vehilic);
            }
            
            else if(status.equalsIgnoreCase("toexit"))
            {
                
                c = Conver_Vali.convertVehiNo(vehilic);
                l = c.length();
                
                switch(l)
                {
                    case 6: f="     "+c+"     ";break;
                    case 7: f="    "+c+"     ";break;
                    case 8: f="    "+c+"    ";break;
                    case 9: f="   "+c+"    ";break;
                    case 10: f="   "+c+"   ";break;
                    case 11: f="  "+c+"   ";break;
                }
                
                s=" See you again! ";
                
                displayLCD(f, s);
                waitExit(vehilic,slotNo);
            }
            
        } catch (Exception e) {
        }
        
    }
    
//-----------Messages LCD
public void toParkMsg(String vehilic)
{
    String c,d,f,s;
    f = "----"; s = "-----";
    int l;
            
                c = Conver_Vali.convertVehiNo(vehilic);
                l = c.length();
                
                switch(l)
                {
                    case 6: f="     "+c+"     ";break;
                    case 7: f="    "+c+"     ";break;
                    case 8: f="    "+c+"    ";break;
                    case 9: f="   "+c+"    ";break;
                    case 10: f="   "+c+"   ";break;
                    case 11: f="  "+c+"   ";break;
                }
                
                d = parkingVehicles.getVehicat(vehilic, "in", null);
                l = d.length();
                
                switch(l)
                {
                    case 3: s="             "+d;break;
                    case 4: s="            "+d;break;
                    case 5: s="           "+d;break;
                    case 7: s="         "+d;break;
                    case 11: s="     "+d;break;
                }
                //JOptionPane.showMessageDialog(null,f+s);
                this.displayLCD(f, s);
                
            
}    
    
public void displayLCD(String f,String s)
{
    String iop = f+s;
    byte[] dat = iop.getBytes();
    //JOptionPane.showMessageDialog(null, dat);
    for(int i=0;i<dat.length;i++)
    {   
        try {
                output.write(dat[i]);
                output.flush();
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
        }
    }
}

    public void waitExit(String vehilic,String slot)
    {
                            
        
        Thread wp = new Thread()
        {
            public void run()
            {
                   for(int x=1; x<=15; x++)
                   {
                      // System.out.println(x);
                       try {
                           sleep(1000);
                       } catch (InterruptedException ex) {
                           Logger.getLogger(Entrance.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }
                   
                   String sq = "SELECT senAva FROM carparkslot WHERE slotNo='"+slot+"'";
                   
                   try {
                    pst = conn.prepareStatement(sq);
                    rs = pst.executeQuery();
                    rs.next();
                    
                    String sen = rs.getString("senAva");
                    
                    if(sen.equals("0"))
                    {
                        Arduino.updateSlotStatusExit("available",slot, "toexit", "&&&&&&");
                        minute=0;
                    }
                    
                    if(sen.equals("1"))
                    {
                        Arduino.updateSlotStatusExit("parked",slot, "toexit", "&&&&&");
                    }
                } catch (Exception e) {
                }
                  
                  // JOptionPane.showMessageDialog(null," Thread finished");
                   
            }
        };
        wp.start();
        
    
    }
        

    
    public void calTime()
    {
        
        
        Thread ct = new Thread()
        {
            public void run()
            {
                   
                int i=0;
                   for(;;)
                   {
                       i++;
                       
                       if(i==60)
                       {
                           minute=minute+1;
                           i=0;
                       }
                       
                       try {
                           sleep(1000);
                       } catch (InterruptedException ex) {
                           Logger.getLogger(Entrance.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }
                   
                   
                   
            }
        };
        ct.start();
    }
    
    
    
    
    
    public void run()
    {
        Arduino main = new Arduino();
         main.initialize();
        
        
        
        
        /*Thread t = new Thread() {
            public void run() { //the following line will keep this app alive for 1000 seconds,
                //waiting for events to occur and responding to them (printing incoming messages to console).
                try {
                        
                    Thread.sleep(1000000);} catch (InterruptedException ie) {}
            }
        };
        t.start();*/
        System.out.println("Started");
    }
    
    
    
    
}
