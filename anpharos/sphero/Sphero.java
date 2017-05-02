package anpharos.sphero;

import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.lang.Math;

public class Sphero{
    private int id, angle;
    private double x, y;
    private Image image;

    public Sphero(int id, double x, double y, String spheroImage){
        this.id = id;
        this.x = x;
        this.y = y;
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
        System.out.println("ha");
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

    public int getAngle(){
        return angle;
    }
}

