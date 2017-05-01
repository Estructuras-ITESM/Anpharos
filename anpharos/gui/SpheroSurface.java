package anpharos.gui;
import java.awt.Graphics;

import javax.swing.JPanel;
import java.util.*;

import anpharos.sphero.Linea;
import anpharos.sphero.Sphero;
import anpharos.structures.DoubleLinkedList;
import anpharos.structures.NodoDoble;

public class SpheroSurface extends JPanel{
 
	  private boolean draw;
	  private Linea linea;
	  private Sphero sphero1;
	  private DoubleLinkedList<Sphero> lista;
	
	  public boolean getDraw(){
		  return draw;
	  }
	  
	  public void setDraw(boolean draw){
		  this.draw = draw;
	  }
	  
	  public SpehroSurface(DoubleLinkedList<Sphero> lista){
	  	this.lista=lista;
	  	setBackground(Color.white);
	  } 

  @Override
  public void paint(Graphics g){
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