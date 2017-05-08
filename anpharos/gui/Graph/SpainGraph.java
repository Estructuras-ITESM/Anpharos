package anpharos.gui.Graph;

import processing.core.PApplet;
import processing.core.PImage;

import javax.crypto.Cipher;

/**
 * Created on 5/7/17.
 */
public class SpainGraph {
    PApplet parent;
    int multiplier;
    PImage img;

    SpainGraph(PApplet parent, int multiplier) {
        this.parent = parent;
        this.multiplier = multiplier;
        img = parent.loadImage("grafo.JPG");
    }

    public void draw() {
        parent.image(img, 2 * 20 * multiplier, 2 * 20 * multiplier, parent.width - 20 * multiplier, parent.height - 20 * multiplier);
        parent.ellipse(352 * multiplier, 409 * multiplier, multiplier * 20, multiplier * 20);//Albacete
        parent.ellipse(160 * multiplier, 419 * multiplier, multiplier * 20, multiplier * 20);//Badajoz
        parent.ellipse(484 * multiplier, 233 * multiplier, multiplier * 20, multiplier * 20);//Barcelona
        parent.ellipse(127 * multiplier, 86 * multiplier, multiplier * 20, multiplier * 20);//Bilbao
        parent.ellipse(173 * multiplier, 584 * multiplier, multiplier * 20, multiplier * 20);//Cadiz
        parent.ellipse(218 * multiplier, 85 * multiplier, multiplier * 20, multiplier * 20);//Coruña
        parent.ellipse(524 * multiplier, 172 * multiplier, multiplier * 20, multiplier * 20);//Gerona
        parent.ellipse(288 * multiplier, 555 * multiplier, multiplier * 20, multiplier * 20);//Granada
        parent.ellipse(266 * multiplier, 463 * multiplier, multiplier * 20, multiplier * 20);//Jaen
        parent.ellipse(287 * multiplier, 308 * multiplier, multiplier * 20, multiplier * 20);//Madrid
        parent.ellipse(381 * multiplier, 495 * multiplier, multiplier * 20, multiplier * 20);//Murcia
        parent.ellipse(320 * multiplier, 90 * multiplier, multiplier * 20, multiplier * 20);//Oviedo
        parent.ellipse(199 * multiplier, 528 * multiplier, multiplier * 20, multiplier * 20);//Sevilla
        parent.ellipse(239 * multiplier, 224 * multiplier, multiplier * 20, multiplier * 20);//Valladolid
        parent.ellipse(413 * multiplier, 372 * multiplier, multiplier * 20, multiplier * 20);//Valencia
        parent.ellipse(110 * multiplier, 167 * multiplier, multiplier * 20, multiplier * 20);//Vigo
        parent.ellipse(381 * multiplier, 216 * multiplier, multiplier * 20, multiplier * 20);//Zaragoza
    }

}
