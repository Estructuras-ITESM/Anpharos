package anpharos.gui.Graph;

import processing.core.PApplet;

import javax.crypto.Cipher;

/**
 * Created on 5/7/17.
 */
public class SpainGraph {
    PApplet parent;
    int multiplier;

    SpainGraph(PApplet parent, int multiplier) {
        this.parent = parent;
        this.multiplier = multiplier;
    }

    public void draw() {
        parent.ellipse(parent.width/3, parent.height/3, multiplier*20, multiplier*20);//Albacete
//        parent.ellipse(50,50, 50, 0);//Badajoz
//        parent.ellipse(50,50, 100, 0);//Barcelona
//        parent.ellipse(50,50, 150, 0);//Bilbao
//        parent.ellipse(50,50, 200, 0);//Cadiz
//        parent.ellipse(50,50, 250, 0);//Coruña
//        parent.ellipse(50,50, 350, 0);//Gerona
//        parent.ellipse(50,50, 400, 0);//Granada
//        parent.ellipse(50,50, 450, 0);//Jaen
//        parent.ellipse(50,50, 500, 0);//Madrid
//        parent.ellipse(50,50, 0, 0);//Murcia
//        parent.ellipse(50,50, 0, 0);//Oviedo
//        parent.ellipse(50,50, 0, 0);//Sevilla
//        parent.ellipse(50,50, 0, 0);//Valladolid
//        parent.ellipse(50,50, 0, 0);//Valencia
//        parent.ellipse(50,50, 0, 0);//Vigo
//        parent.ellipse(50,50, 0, 0);//Zaragoza

    }
}
