import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Notification extends JFrame 
{

    enum Placement
    {
        BOTTOMRIGHT,
        BOTTOMLEFT,
        BOTTOMCENTER,
        TOPCENTER,
        TOPRIGHT,
        TOPLEFT,
    }

    Placement placement; 
    String title;
    String message;
    String pathToPic;

    Font titleFont = new Font("Consolas",Font.PLAIN,20);
    Font messageFont = new Font("Consolas",Font.PLAIN,14);

    final int HEIGHT = 150;
    final int WIDTH = 500;
    int X= 50;
    int Y= 20;
    Color colour = new Color(153, 153, 153, 225);
    

    public Notification(String title, String message, Placement placement)
    {
        this.title = title;
        this.message = message;
        this.placement = placement;
        this.getRootPane().setBorder(BorderFactory.createLineBorder((new Color(26, 26, 26, 250)), 2));

        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setBackground(new Color(25,25,25,225));
        this.setLocation(this.X,this.Y);
        this.setSize(this.WIDTH, this.HEIGHT);
        

        JLabel titleArea = new JLabel("<html><b>"+ this.title +"</b></html>");
        titleArea.setBorder(BorderFactory.createLineBorder(this.colour, 1));
        titleArea.setBorder(BorderFactory.createLineBorder((new Color(26, 26, 26, 250)), 4));
        titleArea.setFont(this.titleFont);
        titleArea.setForeground(new Color(255,255,255, 250));
        this.add(titleArea);


        JLabel messageArea = new JLabel("<html>"+ this.message +"</html>");
        messageArea.setFont(this.messageFont);
        messageArea.setBackground(new Color(255,255,255, 0));
        messageArea.setForeground(new Color(255,255,255, 250));
        messageArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        messageArea.setBorder(BorderFactory.createLineBorder(this.colour, 1));
        this.add(messageArea);

        
        this.addComponentListener
        (
            new ComponentAdapter() 
            {
                @Override
                public void componentResized(ComponentEvent e) 
                {
                    setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 5, 5));                      
                }
            }
        );

        this.setOpacity(0);
    }

    public void display(int seconds)
    {
        try 
        {
            this.setVisible(true);

            for (double d = 0.0; d <= 1; d += 0.1) 
            {
                Thread.sleep(15);
                this.setOpacity((float)d);
            }
            Thread.sleep(seconds*1000);
   
            //hide the toast message in slow motion
            for (double d = 1.0; d >= 0.0; d -= 0.1) {
               Thread.sleep(15);
               this.setOpacity((float)d);
            }
   
            // set the visibility to false
            this.setVisible(false);
        }
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }

    protected void setPosition(int X, int Y)
    {
        this.setLocation(this.X,this.Y);
    }
    
    protected void setColor(int red, int green, int blue, int alpha)
    {
        this.setBackground(new Color(red, green, blue, alpha));
    }
    
    public void setNotifTitle(String title)
    {
        this.title = title;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
 