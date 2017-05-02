package anpharos.gui;

import javax.swing.*;

import anpharos.sphero.Linea;
import anpharos.sphero.Sphero;
import anpharos.structures.DoubleLinkedList;
import anpharos.structures.NodoDoble;

import javax.swing.*;
import java.awt.*;


public class SpheroSurface extends JPanel {


    private boolean draw;
    private boolean drawGrafo;
    private boolean girar;
    private Linea linea;
    private Sphero sphero1,sphero2,sphero3,sphero4,sphero5;
    private DoubleLinkedList<Sphero> lista;


    public boolean isGirar() {
        return girar;
    }
    public void setGirar(boolean girar) {
        this.girar = girar;
    }
    public boolean getDraw() {
        return draw;
    }
    public void setDraw(boolean draw) {
        this.draw = draw;
    }
    public boolean getDrawGrafo() {
        return drawGrafo;
    }
    public void setDrawGrafo(boolean drawGrafo) {
        this.drawGrafo = drawGrafo;
    }

    public SpheroSurface(DoubleLinkedList<Sphero> lista){
        this.lista = lista;
        setBackground(Color.white);

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(draw){
            NodoDoble<Sphero> temporal = lista.getFirst();
            for(int i = 0; i<lista.getSize(); i++) {
                temporal.getElement().paintLine(g);
                temporal = temporal.getNext();
                g.drawOval(100,100,20,20);
                g.drawString("hola",100,100);
            }
        }

        if(drawGrafo)
        {

        }

        NodoDoble<Sphero> temporal = lista.getFirst();
        for(int i = 0; i<lista.getSize(); i++) {
            temporal.getElement().paintSphero(g);
            temporal = temporal.getNext();
        }
    }

    public void addSphero(Sphero sphero)
    {
        lista.addLast(sphero);

    }
}
