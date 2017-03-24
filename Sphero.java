import java.awt.*;
import javax.imageio.*;
import java.io.*;

public class Sphero{
  private int id, x, y;
  private Image image;

  public Sphero(int id, int x, int y, String spheroImage){
    this.id = id;
    this.x = x;
    this.y = y;
    try{
      image = ImageIO.read(new File(spheroImage));
    } catch (IOException io){
      io.printStackTrace();
    }
  }



}