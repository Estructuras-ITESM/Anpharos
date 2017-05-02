package anpharos.sphero;



import javax.imageio.ImageIO;
import javax.swing.*;

import anpharos.structures.Nodo;
import anpharos.structures.SingleLinkedList;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

public class Sphero {


    private double x;
    private double y;
    private double xinicial;
    private double yinicial;
    private Image image;
    private double grados;
    private double xPanel;
    private double yPanel;
    private String id;
    private boolean mostrar;
    private SingleLinkedList lineas;
    private Linea linea;
    SingleLinkedList<Linea> nuevo;

    public void reset(double width, double height)
    {
       nuevo= new SingleLinkedList<Linea>();
        x = (width/2)-35;
        y = (height/2)-40;
        grados = 0;
        xinicial = x;
        yinicial = y;
       lineas = nuevo;

    }

    public boolean isMostrar() {
        return mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }



    public double getxPanel() {
        return xPanel;
    }

    public void setxPanel(double xPanel) {
        this.xPanel = xPanel;
    }

    public double getyPanel() {
        return yPanel;
    }

    public void setyPanel(double yPanel) {
        this.yPanel = yPanel;
    }


    public double getYinicial() {
        return yinicial;
    }

    public void setYinicial(double yinicial) {
        this.yinicial = yinicial;
    }


    public SingleLinkedList getLineas() {
        return lineas;
    }


    public double getXinicial() {
        return xinicial;
    }

    public void setXinicial(double xinicial) {
        this.xinicial = xinicial;
    }

    public double getGrados() {
        return grados;
    }
    
    public Sphero(String id, double x, double y, String spheroImage) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.xinicial = x;
        this.yinicial = y;
        lineas = new SingleLinkedList();
        grados = 0;
        mostrar = true;
        xPanel = 500;
        yPanel = 800;

        try {
            image = ImageIO.read(new File(spheroImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintSphero(Graphics graphics) {
        if(mostrar) {
            graphics.drawString(id, (int)x,(int)y);
            graphics.drawImage(image, (int) x, (int) y, 50, 50, null);
            marcarLinea(graphics);


        }
    }

    public void paintLine(Graphics graphics) {

        linea = new Linea();
        linea.setX1(xinicial + 25);
        linea.setX2(x + 25);
        linea.setY1(yinicial + 25);
        linea.setY2(y + 25);
        lineas.addFirst(linea);



    }

    public void marcarLinea(Graphics graphics)
    {

        Nodo<Linea> lineaTemp = lineas.getFirst();
        for(int i = 0; i<lineas.getSize();i++)
        {
            graphics.drawLine((int)lineaTemp.getElement().getX1(),(int)lineaTemp.getElement().getY1(),(int)lineaTemp.getElement().getX2(),(int)lineaTemp.getElement().getY2());
            lineaTemp = lineaTemp.getNext();

        }
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        if(x<(xPanel-35) && x>=0)
          this.x = x;
        else
            JOptionPane.showMessageDialog(null,"El valor de x al que quiere llegar se pasa del límite");
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        if(y<(yPanel-40) && y>=0)
            this.y = y;
        else
            JOptionPane.showMessageDialog(null,"El valor y al que quieres llegar se pasa del límite");

    }
    
    public void setGrados(double grados) {
        this.grados = grados;
        verificarGrados(grados);
    }

    public void verificarGrados(double grados)
    {
        if(grados>360) {
            grados = grados - 360;

        }    
    }
}