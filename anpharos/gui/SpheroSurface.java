package anpharos.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;

public class SpheroSurface extends JPanel{
  
  double x, y, vel, xdestin, ydestin, v;
  int angle, distance;
  boolean show;
  public Timer tm = new Timer(5, new timerListener());

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

	  	int ix = (int) x;
	  	int iy = (int) y;

	  	int idx = (int) xdestin;
	  	int idy = (int) ydestin;

	  	g.setColor(Color.RED);
	  	g.fillOval(ix, iy, 40, 40);
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
  	this.angle = angle;
  	this.distance = distance;
  	v = vel;
  	xdestin = x + (distance*Math.cos(Math.toRadians(angle)));
  	ydestin = y + (distance*Math.sin(Math.toRadians(angle)));
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