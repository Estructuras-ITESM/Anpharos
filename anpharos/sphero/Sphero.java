package anpharos.sphero;

import java.awt.*;
import javax.imageio.*;

import anpharos.structures.Node;
import anpharos.structures.SingleLinkedList;

import java.io.*;
import java.lang.Math;

public class Sphero{
  private int id, angle;
  private double x, y, xInicial,yInicial;
  private boolean hide;
  private Image image;
  private SingleLinkedList lineas;
  private Linea linea;
  SingleLinkedList<Linea> nuevo;

  public Sphero(int id, double x, double y, String spheroImage){
    this.id = id;
    this.x = x;
    this.y = y;
    this.xInicial;
    this.yInicial;
    this.hide = hide;
    this.angle = 0;
    try{
      image = ImageIO.read(new File(spheroImage));
    } catch (IOException io){
      io.printStackTrace();
    }
  }

  public enum Action{
    FORWARD, BACKWARD, ROTATE, MOVETO, DRAW,
    DONTDRAW, HIDESPHERO, RESETSPHERO
  }

  public void forward(int distance){
    System.out.println("forward");
    int d = 0;
    while(d < distance){
      x = x + Math.cos(angle);
      y = y + Math.sin(angle);
      d++;
      try {
        Thread.sleep(1000);                 //1000 milliseconds is one second.
      } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
    }
  }

  public void backward(int distance){
    int d = 0;
    while(d < distance){
      x = x - Math.cos(angle);
      y = y - Math.sin(angle);
      d++;
      try {
        Thread.sleep(1000);                 //1000 milliseconds is one second.
      } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
    }
  }

  public void rotate(int angle){
    int a = 0;
    while(a < angle){
      this.angle++;
      a++;
      try {
        Thread.sleep(1000);                 //1000 milliseconds is one second.
      } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
    }
    if(this.angle >= 360){
      this.angle -= 360;
    }
  }

  public void moveTo(int x, int y){
    double dy = y - this.y;
    double dx = x - this.x;
    double h = Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
    while(dx!=x || dy!=y){
      this.x += (dx/h);
      this.y += (dy/h);
      try {
        Thread.sleep(1000);                 //1000 milliseconds is one second.
      } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
    }
  }

  public void reset(double width, double height){
	  nuevo = new SingleLinkedList<Linea>();
	  xInicial=0;
	  yInicial=0;
	  x = 0;
	  y = 0;
	  angle = 0;
	  lineas = nuevo;
  }
  
  public boolean getHide(){
	  return hide;
  }
  
  public void setHide(boolean hide){
	  this.hide=hide;
  }
  
  public void paintSphero(Graphics graphics){
	  if(hide){
          graphics.drawString(id, (int)x,(int)y);
          graphics.drawImage(image, (int) x, (int) y, 50, 50, null);
          marcarLinea(graphics);
	  }
  }
  
  public void paintLine(Graphics graphics) {

      linea = new Linea();
      linea.setX1(xInicial + 25);
      linea.setX2(x + 25);
      linea.setY1(yInicial + 25);
      linea.setY2(y + 25);
      lineas.addFirst(linea);
  }
  
  public void marcarLinea(Graphics graphics)
  {

      Node<Linea> lineaTemp = lineas.getFirst();
      for(int i = 0; i<lineas.getSize();i++)
      {
          graphics.drawLine((int)lineaTemp.getElement().getX1(),(int)lineaTemp.getElement().getY1(),(int)lineaTemp.getElement().getX2(),(int)lineaTemp.getElement().getY2());
          lineaTemp = lineaTemp.getNext();

      }
  }
  public int getId() {
      return id;
  }

  public void setId(int id) {

      this.id = id;
  }

  public double getX() {
      return x;
  }



  public double getY() {
      return y;
  }


  
  public double getXinicial() {
      return xInicial;
  }

  public void setXinicial(double xinicial) {
      this.xInicial = xInicial;
  }
  
  public double getYinicial() {
      return yInicial;
  }

  public void setYinicial(double yInicial) {
      this.yInicial = yInicial;
  }
  
  
}