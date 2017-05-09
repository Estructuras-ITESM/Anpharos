import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Anpharos extends JFrame{

  private JButton forward, backward, rotate, move, draw, dontdraw, hidesphero, resetsphero, run, save, load, create, clear, graph;
  private LinkedList<SpheroSurface> drawing = new LinkedList<SpheroSurface>();
  private GridBagConstraints c = new GridBagConstraints();
  private JTextArea code = new JTextArea(10,10);
  private Sphero sphero;
  private Queue<Command> qCommands = new Queue<Command>();
  private Usuario usuario;
  private JComboBox select;
  private String [] sph;
  private int currentSphero;
  private int cenx = 100;
  private int ceny = 100;
  private Hashtable<Integer,Usuario> usuarios;

  public Anpharos(Usuario usuario, Hashtable<Integer,Usuario> usuarios){
    this.usuario = usuario;
    this.usuarios = usuarios;
    sphero = usuario.getSphero(0);
    currentSphero = 0;
    setTitle("Anpharos");
    setSize(1200,1000);
    setLayout(new GridBagLayout());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent windowEvent) {
          usuarios.remove(usuario.getNombre().hashCode());
          usuarios.put(usuario.getNombre().hashCode(),usuario);
          serialize(usuarios);
        }
    });
    sph = new String[usuario.getList().size()];
    fillArray();
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

    c.gridwidth = 1;
    c.gridy = 4;
    draw = new JButton("Draw");
    draw.setActionCommand("Draw");
    draw.addActionListener(new QueueListener());
    add(draw,c);

    c.gridx = 1;
    dontdraw = new JButton("DontDraw");
    dontdraw.setActionCommand("DontDraw");
    dontdraw.addActionListener(new QueueListener());
    add(dontdraw,c);

    c.gridwidth = 2;
    c.gridy = 5;
    c.gridx = 0;
    GridBagConstraints g = new GridBagConstraints();
    g.fill = GridBagConstraints.BOTH;
    g.weighty = 1.0;
    g.weightx = 1.0;
    g.gridx = 0;
    g.gridy = 0;
    JPanel j = new JPanel(new GridBagLayout());
    hidesphero = new JButton("HideSphero");
    hidesphero.setActionCommand("HideSphero");
    hidesphero.addActionListener(new QueueListener());
    j.add(hidesphero,g);
    g.gridy = 1;
    resetsphero = new JButton("ResetSphero");
    resetsphero.setActionCommand("ResetSphero");
    resetsphero.addActionListener(new QueueListener());
    j.add(resetsphero,g);
    add(j,c);

    c.gridy = 6;
    graph = new JButton("Graph");
    graph.setActionCommand("Graph");
    graph.addActionListener(new QueueListener());
    add(graph,c);

    c.gridwidth = 1;
    c.gridy = 7;
    create = new JButton("Create");
    create.setActionCommand("Create");
    create.addActionListener(new QueueListener());
    add(create,c);

    c.gridx = 1;
    JPanel pane = new JPanel(new GridBagLayout());
    select =  new JComboBox(sph);
    JLabel lbl = new JLabel("   Current Sphero: ");
    
    g.gridy = 0;
    pane.add(lbl,g);
    g.gridy = 1;
    pane.add(select,g);
    add(pane,c);

    c.gridx = 2;
    c.gridy = 0;
    c.gridwidth = 5;
    c.gridheight = 10;
    drawSpheros();

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
    clear = new JButton("Clear");
    clear.setActionCommand("Clear");
    add(clear,c);

    c.gridx = 9;
    JPanel p = new JPanel(new GridBagLayout());
    save = new JButton("Save");
    save.setActionCommand("Save");
    p.add(save,g);
    g.gridy = 0;
    load = new JButton("Load");
    load.setActionCommand("Load");
    p.add(load,g);
    add(p,c);

  }

  private class QueueListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      String command = e.getActionCommand();
      switch(command){
        case "Forward":
          int f = Integer.parseInt(JOptionPane.showInputDialog("Distancia a avanzar:"));
          usuario.enqueueInstruction(new Instruction(currentSphero, Command.FORWARD, f));
          code.append("S"+(currentSphero+1)+" <- Forward("+f+"); \n");
          if(!drawing.get(currentSphero).tm.isRunning()){
            drawing.get(currentSphero).forward(sphero.getAngle(), f);
//            sphero.forward(100);
          }
          break;
        case "Backward":
          int b = Integer.parseInt(JOptionPane.showInputDialog("Distancia a retroceder: "));
          usuario.enqueueInstruction(new Instruction(currentSphero, Command.BACKWARD, b));
          code.append("S"+(currentSphero+1)+" <- Backward("+b+"); \n");
          if(!drawing.get(currentSphero).tm.isRunning()){
            drawing.get(currentSphero).backward(sphero.getAngle(), b);
//            sphero.backward(100);
          }
          break;
        case "Rotate":
          int r = Integer.parseInt(JOptionPane.showInputDialog("Grados a rotar:"));
          usuario.enqueueInstruction(new Instruction(currentSphero, Command.ROTATE, r));
          code.append("S"+(currentSphero+1)+" <- Rotate("+r+"); \n");
//          sphero.rotate(r);
          break;
        case "MoveTo":
          int x = Integer.parseInt(JOptionPane.showInputDialog("Coordenada X a moverse"));
          int y = Integer.parseInt(JOptionPane.showInputDialog("Coordenada Y a moverse"));
          usuario.enqueueInstruction(new Instruction(currentSphero, Command.MOVETO, x, y));
          code.append("S"+(currentSphero+1)+" <- Rotate("+x+","+y+"); \n");
          if(!drawing.get(currentSphero).tm.isRunning()){
            drawing.get(currentSphero).moveTo(x, y);
//            sphero.moveTo(200,200);
          }
          break;
        case "Draw":
          usuario.enqueueInstruction(new Instruction(currentSphero, Command.DRAW));
          code.append("S"+(currentSphero+1)+" <- Draw(); \n");
          break;
        case "DontDraw":
          usuario.enqueueInstruction(new Instruction(currentSphero, Command.DONTDRAW));
          code.append("S"+(currentSphero+1)+" <- DontDraw(); \n");
          break;
        case "HideSphero":
          usuario.enqueueInstruction(new Instruction(currentSphero, Command.HIDESPHERO));
          code.append("S"+(currentSphero+1)+" <- HideSphero(); \n");
          if(!drawing.get(currentSphero).tm.isRunning()){
            drawing.get(currentSphero).hideSphero();
          }
          break;
        case "ResetSphero":
          usuario.enqueueInstruction(new Instruction(currentSphero, Command.RESETSPHERO));
          code.append("S"+(currentSphero+1)+" <- ResetSphero(); \n");
          break;
        case "Create":
          if(usuario.getList().size() < 5){
            usuario.addSphero();
            SpheroSurface ss = new SpheroSurface(cenx, ceny, 0, true);
            ss.setPreferredSize(new Dimension(750,750));
            add(ss,c);
            drawing.add(ss);
          } else {
            JOptionPane.showMessageDialog(null, "No se puede tener mas de 5 spheros.");
          }
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

/*
  private class InstantListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      String command = e.getActionCommand();
      switch(command){
        case "Forward":
          if(!drawing.tm.isRunning()){
            drawing.forward(sphero.getAngle(), 100);
            sphero.forward(100);
          }
          break;
        case "Backward":
          if(!drawing.tm.isRunning()){
            drawing.backward(sphero.getAngle(), 100);
            sphero.backward(100);
          }
          break;
        case "Rotate":
          sphero.rotate(45);
          break;
        case "MoveTo":
          if(!drawing.tm.isRunning()){
            drawing.moveTo(200, 200);
            //    sphero.moveTo(200,200);
          }
          break;
        case "Draw":
          break;
        case "DontDraw":
          break;
        case "HideSphero":
          if(!drawing.tm.isRunning()){
            drawing.hideSphero();
          }
          break;
        case "ResetSphero":
          drawing.get(currentSphero) = new SpheroSurface(cenx, ceny, 0, true);
          break;
        case "Graph":
          break;
        case "Create":
          if(usuario.getList().size() < 5){
            usuario.addSphero();
            SpheroSurface ss = new SpheroSurface(cenx, ceny, 0, true);
            ss.setPreferredSize(new Dimension(750,750));
            add(ss,c);
            drawing.add(ss);
          } else {
            JOptionPane.showMessageDialog("No se puede tener mas de 5 spheros.");
          }
          break;
        case "Run":
          break;
        case "Clear":
          break;
        case "Save":
          break;
        case "Load":
          break;
      }
    }
  }
*/

  public void fillArray(){
    int l = 0;
    for ( Sphero s : usuario.getList()) {
      sph[l] = "Sphero - "+(l+1);
      l++;
    }
  }

  public void serialize(Hashtable<Integer,Usuario> usuarios){
      try {
          FileOutputStream fileOut =   new FileOutputStream("UsuarioBD.sph");
          ObjectOutputStream out = new ObjectOutputStream(fileOut);
          out.writeObject(usuarios);
          out.close();
          fileOut.close();
          System.out.println("PUTA MADRE");
      }catch(IOException i) {
          i.printStackTrace();
          System.out.println("SEAS MAMON");
      }
  }

  public void drawSpheros(){
    for(Sphero s : usuario.getList()){
      SpheroSurface ss = new SpheroSurface(s.getX(), s.getY(), s.getAngle(), s.isShown());
      ss.setPreferredSize(new Dimension(750,750));
      add(ss,c);
      drawing.add(ss);
    }
  }

}