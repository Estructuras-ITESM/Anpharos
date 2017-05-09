package anpharos.sphero;

import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.lang.Math;

public class Sphero implements Serializable{
  private int angle;
  private double x, y;
  private Image image;
  boolean show;

  public Sphero(double x, double y, String spheroImage){
    this.x = x;
    this.y = y;
    this.angle = 0;
    show = true;
    try{
      image = ImageIO.read(new File("img/sphero1.png"));
    } catch (IOException io){
      io.printStackTrace();
    }
  }

  public enum Action{
    FORWARD, BACKWARD, ROTATE, MOVETO, DRAW,
    DONTDRAW, HIDESPHERO, RESETSPHERO
  }

  public void forward(int distance){
    int d = 0;
    while(d < distance){
      x = x + Math.cos(angle);
      y = y + Math.sin(angle);
      d++;       
    }
  }

  public void backward(int distance){
    int d = 0;
    while(d < distance){
      x = x - Math.cos(angle);
      y = y - Math.sin(angle);
      d++;    
    }
  }

  public void rotate(int angle){
    int a = 0;
    while(a < angle){
      this.angle++;
      a++;
    }
    if(this.angle >= 360){
      this.angle -= 360;
    }
  }

  public void moveTo(int x, int y){
    this.x = x;
    this.y = y;
  }

  public void hideSphero(){
    show = !show;
  }

  public int getAngle(){
    return angle;
  }

  public double getX(){
    return x;
  }

  public double getY(){
    return y;
  }

  public boolean isShown(){
    return show;
  }

  public void setAngle(int angle){
    this.angle = angle;
  }

  public void setX(int x){
    this.x = x;
  }

  public void setY(int y){
    this.y = y;
  }

  public void setShow(boolean show){
    this.show = show;
  }
}