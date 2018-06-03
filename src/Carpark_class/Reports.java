
package Carpark_class;

import java.awt.Container;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;


public class Reports extends JFrame{
    
    Connection conn = dbconnct.connect();
    
    public Reports(String fileName)
    {
        this(fileName,null);
    }
    
    public Reports(String fileName,HashMap para)
    {
        super("Dingara Dingaareeeee  ");
        
        try {
            
            JasperPrint print = JasperFillManager.fillReport(fileName, para, conn);
            JRViewer viewer = new JRViewer(print);
            Container c = getContentPane();
            c.add(viewer);
                    
            
        } catch (Exception e) {
        }
        
        setBounds(10,10, 900,700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 
    }
    
}
