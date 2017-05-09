package anpharos.gui.Graph;

import processing.core.PApplet;

/**
 * Created on 5/8/17.
 */
public class GraphEdgeGui {
    int xPosBegin, yPosBegin, xPosEnd, yPosEnd;
    PApplet parent;
    int multiplier;

    public GraphEdgeGui(PApplet parent, int multiplier) {
        this.parent = parent;
        this.multiplier = multiplier;
    }

    public GraphEdgeGui(PApplet parent, GraphNodeGui n1, GraphNodeGui n2, int multiplier) {
        this(parent, multiplier);
        connect(n1,n2);
    }

    public void connect(GraphNodeGui n1, GraphNodeGui n2) {
        xPosBegin = n1.getXPos();
        yPosBegin = n1.getYPos();

        xPosEnd = n2.getXPos();
        yPosEnd = n2.getYPos();
    }

    public void draw() {
        parent.line(xPosBegin * multiplier, yPosBegin * multiplier, xPosEnd * multiplier, yPosEnd * multiplier);
    }
}
