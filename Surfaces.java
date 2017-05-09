/*
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class Surfaces extends JPanel{
  
  double v, vel, xdestin, ydestin;
  int angle;
  LinkedList<Sphero> spheros;
  public Timer tm = new Timer(5, new timerListener());

  public Surfaces(LinkedList<Sphero> spheros){
    setSize(750,750);
    this.spheros = spheros;
    vel = 1.25;
  }

  public void paintComponent(Graphics g){
  	
	super.paintComponent(g);
  	if(show){
	  	int ix = (int) x;
	  	int iy = (int) y;

	  	int idx = (int) xdestin;
	  	int idy = (int) ydestin;

	  	g.setColor(Color.RED);
	  	boolean what = g.drawImage(ImageIO.read(new File("img/sphero1.png")), idx, idy, null);
	  	g.setColor(Color.BLUE);
	  	g.fillOval(idx, idy, 50, 50);
  	}


  }
  private class timerListener implements ActionListener{
	  public void actionPerformed(ActionEvent e){
  		x = x + (v*Math.cos(Math.toRadians(angle)));
	    y = y + (v*Math.sin(Math.toRadians(angle)));
	    repaint();
	    if((Math.abs(x - xdestin) < 3) && (Math.abs(y - ydestin) < 3)) {
	    	tm.stop();
	    } 
	  }

  }

  private void start(){
  	if(show){
  		tm.start();
  	}
  }

  public void forward(int currentSphero, int distance){
  	angle = spheros.get(currentSphero).getAngle();
  	this.distance = distance;
  	v = vel;
  	xdestin = spheros.get(currentSphero).getX() + (distance*Math.cos(Math.toRadians(angle)));
  	ydestin = spheros.get(currentSphero).getY() + (distance*Math.sin(Math.toRadians(angle)));
  	this.start();
  }

  public void backward(int angle, int distance){
  	this.angle = angle;
  	this.distance = distance;
  	v = -vel;
  	xdestin = x - (distance*Math.cos(Math.toRadians(angle)));
  	ydestin = y - (distance*Math.sin(Math.toRadians(angle)));
  	this.start();
  }

  public void moveTo(double dx, double dy){
  	double co = dy - y;
  	double ca = dx - x;
  	System.out.println(co);
  	System.out.println(ca);
  	angle = (int) Math.toDegrees(Math.atan(co/ca));
  	System.out.println(angle);
  	if(dx < x){
  		angle = angle + 180;
  	}
  	v = vel;
  	xdestin = dx;
  	ydestin = dy;
  	this.start();
  }

  public void hideSphero(){
  	show = !show;
  	repaint();
  }
}
*/