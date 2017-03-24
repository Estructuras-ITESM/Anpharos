import java.awt.*;
import javax.swing.*;


public class SpheroSurface extends JPanel{
  public SpheroSurface(){
    setSize(750,750);
  }

  @Override
  public void paint(Graphics g){
    super.paint(g);
    g.drawOval(100,100,400,400);
  }
}