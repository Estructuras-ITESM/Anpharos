
package anpharos.gui;
import java.awt.Graphics;

import javax.swing.JPanel;
import java.util.*;

import anpharos.sphero.Sphero;

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