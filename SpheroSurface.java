import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import javax.imageio.ImageIO;
import java.io.*;

public class SpheroSurface extends JPanel{
  
  double x, y, vel, xdestin, ydestin, v;
  int angle, distance;
  boolean show;
  public Timer tm = new Timer(5, new timerListener());
  Image image;
  Object lock = new Object();

  public SpheroSurface(){
    this(0, 0);
  }

  public SpheroSurface(double x, double y){
  	setSize(750,750);
 	this.x = x;
 	this.y = y;
 	vel = 1.25;
 	show = true;
  }

  public SpheroSurface(double x, double y, int angle, boolean show){
  	setSize(750,750);
 	this.x = x;
 	this.y = y;
 	this.angle = angle;
 	this.show = show;
 	vel = 1.25;
 	show = true;
  }
/*
  @Override
  public void paint(Graphics g){
    super.paint(g);
    g.showOval(x, y, 40,40);
  }
*/
  public void paintComponent(Graphics g){
  	
	super.paintComponent(g);
  	if(show){

  		try{
      		image = ImageIO.read(new File("img/sphero1.png"));
    	} catch (IOException io){
    	    io.printStackTrace();
    	}

	  	int ix = (int) x;
	  	int iy = (int) y;

	  	int idx = (int) xdestin;
	  	int idy = (int) ydestin;

	  	g.setColor(Color.RED);
	  	boolean what = g.drawImage(image, ix, iy, null);
	  	g.setColor(Color.BLUE);
	  	g.fillOval(idx, idy, 40, 40);
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

  public void forward(int angle, int distance){
    synchronized(lock){
    	this.angle = angle;
    	this.distance = distance;
    	v = vel;
    	xdestin = x + (distance*Math.cos(Math.toRadians(angle)));
    	ydestin = y + (distance*Math.sin(Math.toRadians(angle)));
    	this.start();
    }
  }

  public void backward(int angle, int distance){
    synchronized(lock){
    	this.angle = angle;
    	this.distance = distance;
    	v = -vel;
    	xdestin = x - (distance*Math.cos(Math.toRadians(angle)));
    	ydestin = y - (distance*Math.sin(Math.toRadians(angle)));
    	this.start();
    }
  }

  public void moveTo(double dx, double dy){
    synchronized(lock){
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
  }

  public void hideSphero(){
    synchronized(lock){
    	show = !show;
    	repaint();
    }
  }
}