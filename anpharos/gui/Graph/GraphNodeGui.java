package anpharos.gui.Graph;

import processing.core.PApplet;

/**
 * Created on 5/8/17.
 */

public class GraphNodeGui {
    int xPos, yPos;
    PApplet parent;
    final int SIZE = 20;
    int multiplier;

    public GraphNodeGui(PApplet parent, int multiplier) {
        this.parent = parent;
        this.multiplier = multiplier;
    }

    public GraphNodeGui(PApplet parent, int xPos, int yPos, int multiplier) {
        this(parent, multiplier);
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void draw() {
        parent.ellipse(xPos * multiplier, yPos * multiplier, SIZE * multiplier, SIZE * multiplier);
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }
}
