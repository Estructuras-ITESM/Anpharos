import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Anpharos extends JFrame{

  private SpheroSurface drawing = new SpheroSurface();
  private JButton forward, backward, rotate, move, draw, dontdraw, hidesphero, resetsphero, run, save, load;
  private GridBagConstraints c = new GridBagConstraints();
  private JTextArea code = new JTextArea(10,10);
  Sphero sphero = new Sphero(0, 100, 100, "");
  Queue<Command> qCommands = new Queue<Command>();

  public Anpharos(){
    setTitle("Anpharos");
    setSize(1500,1500);
    setLayout(new GridBagLayout());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    initComponents();
    setVisible(true);
  }

  private void initComponents(){

    c.fill = GridBagConstraints.BOTH;
    c.weighty = 1.0;
    c.weightx = 1.0;
    c.gridwidth = 2;
    c.gridx = 0;
    c.gridy = 0;
    forward = new JButton("Forward");
    forward.setActionCommand("Forward");
    forward.addActionListener(new QueueListener());
    add(forward,c);

    c.gridy = 1;
    backward = new JButton("Backward");
    backward.setActionCommand("Backward");
    backward.addActionListener(new QueueListener());
    add(backward,c);

    c.gridy = 2;
    rotate = new JButton("Rotate");
    rotate.setActionCommand("Rotate");
    rotate.addActionListener(new QueueListener());
    add(rotate,c);

    c.gridy = 3;
    move = new JButton("Move To");
    move.setActionCommand("MoveTo");
    move.addActionListener(new QueueListener());
    add(move,c);

    c.gridy = 4;
    draw = new JButton("Draw");
    draw.setActionCommand("Draw");
    draw.addActionListener(new QueueListener());
    add(draw,c);

    c.gridy = 5;
    dontdraw = new JButton("DontDraw");
    dontdraw.setActionCommand("DontDraw");
    dontdraw.addActionListener(new QueueListener());
    add(dontdraw,c);

    c.gridy = 6;
    hidesphero = new JButton("HideSphero");
    hidesphero.setActionCommand("HideSphero");
    hidesphero.addActionListener(new QueueListener());
    add(hidesphero,c);

    c.gridy = 7;
    resetsphero = new JButton("ResetSphero");
    resetsphero.setActionCommand("ResetSphero");
    resetsphero.addActionListener(new QueueListener());
    add(resetsphero,c);

    c.gridx = 2;
    c.gridy = 0;
    c.gridwidth = 5;
    c.gridheight = 10;
    drawing.setPreferredSize(new Dimension(750,750));
    add(drawing,c);

    c.gridwidth = 3;
    c.gridheight = 7;
    c.gridx = 7;
    c.gridy = 0;
    add(code,c);

    c.gridwidth = 1;
    c.gridheight = 1;
    c.gridy = 7;
    run = new JButton("Run");
    run.setActionCommand("Run");
    add(run,c);

    c.gridx = 8;
    save = new JButton("Save");
    save.setActionCommand("Save");
    add(save,c);

    c.gridx = 9;
    load = new JButton("Load");
    load.setActionCommand("Load");
    add(load,c);

  }

  private class QueueListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      String command = e.getActionCommand();
      switch(command){
        case "Forward":
        System.out.println("hey");
        sphero.forward(100);
        System.out.println("ho");
          break;
        case "Backward":
          break;
        case "Rotate":
          break;
        case "Move":
          break;
        case "Draw":
          break;
        case "DontDraw":
          break;
        case "HideSphero":
          break;
        case "ResetSphero":
          break;
        case "Run":
          break;
        case "Save":
          break;
        case "Load":
          break;
      }
    }
  }


}