package anpharos.gui;

import anpharos.app.Usuario;
import anpharos.app.Program;
import anpharos.sphero.Command;
import anpharos.sphero.Instruction;
import anpharos.sphero.Sphero;
import anpharos.gui.Graph.GraphParent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import anpharos.structures.Queue;

public class Anpharos extends JFrame{

  private JButton forward, backward, rotate, move, draw, dontdraw, hidesphero, resetsphero, run, save, load, create, clear, graph;
  private LinkedList<SpheroSurface> drawing = new LinkedList<SpheroSurface>();
  private GridBagConstraints c = new GridBagConstraints();
  private JTextArea code = new JTextArea(10,10);
  private Sphero sphero;
  private anpharos.structures.Queue<Command> qCommands = new Queue<Command>();
  private Usuario usuario;
  private JComboBox select;
  private String [] sph;
  private int currentSphero;
  private int cenx = 50;
  private int ceny = 50;
  private Hashtable<Integer,Usuario> usuarios;
  private JFileChooser chooser = new JFileChooser();
  private FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "Programs", "prg");

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
    chooser.setFileFilter(filter);
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
    draw.setEnabled(false);
    add(draw,c);

    c.gridx = 1;
    dontdraw = new JButton("DontDraw");
    dontdraw.setActionCommand("DontDraw");
    dontdraw.addActionListener(new QueueListener());
    dontdraw.setEnabled(false);
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
    create.setEnabled(false);
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
    run.addActionListener(new QueueListener());
    add(run,c);

    c.gridx = 8;
    clear = new JButton("Clear");
    clear.setActionCommand("Clear");
    clear.addActionListener(new QueueListener());
    add(clear,c);

    c.gridx = 9;
    JPanel p = new JPanel(new GridBagLayout());
    save = new JButton("Save");
    save.setActionCommand("Save");
    save.addActionListener(new QueueListener());
    p.add(save,g);
    g.gridy = 0;
    load = new JButton("Load");
    load.setActionCommand("Load");
    load.addActionListener(new QueueListener());
    p.add(load,g);
    add(p,c);

  }

  private class QueueListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      currentSphero = select.getSelectedIndex();
      sphero = usuario.getSphero(currentSphero);
      String command = e.getActionCommand();
      switch(command){
        case "Forward":
          int f = Integer.parseInt(JOptionPane.showInputDialog("Distancia a avanzar:"));
          usuario.enqueueInstruction(new Instruction(currentSphero, Command.FORWARD, f));
          code.append("S"+(currentSphero+1)+" <- Forward("+f+"); \n");
/*          if(!drawing.get(currentSphero).tm.isRunning()){
//            drawing.get(currentSphero).forward(sphero.getAngle(), f);
//            sphero.forward(100);
          }
          usuario.getSphero(currentSphero).forward(f);
*/          break;
        case "Backward":
          int b = Integer.parseInt(JOptionPane.showInputDialog("Distancia a retroceder: "));
          usuario.enqueueInstruction(new Instruction(currentSphero, Command.BACKWARD, b));
          code.append("S"+(currentSphero+1)+" <- Backward("+b+"); \n");
/*          if(!drawing.get(currentSphero).tm.isRunning()){
            drawing.get(currentSphero).backward(sphero.getAngle(), b);
//            sphero.backward(100);
          }
          usuario.getSphero(currentSphero).backward(b);
*/          break;
        case "Rotate":
          int r = Integer.parseInt(JOptionPane.showInputDialog("Grados a rotar:"));
          usuario.enqueueInstruction(new Instruction(currentSphero, Command.ROTATE, r));
          code.append("S"+(currentSphero+1)+" <- Rotate("+r+"); \n");
//          sphero.rotate(r);
//          usuario.getSphero(currentSphero).rotate(r);
          break;
        case "MoveTo":
          int x = Integer.parseInt(JOptionPane.showInputDialog("Coordenada X a moverse"));
          int y = Integer.parseInt(JOptionPane.showInputDialog("Coordenada Y a moverse"));
          usuario.enqueueInstruction(new Instruction(currentSphero, Command.MOVETO, x, y));
          code.append("S"+(currentSphero+1)+" <- MoveTo("+x+","+y+"); \n");
/*          if(!drawing.get(currentSphero).tm.isRunning()){
            drawing.get(currentSphero).moveTo(x, y);
//            sphero.moveTo(200,200);
          }
          usuario.getSphero(currentSphero).moveTo(x,y);
*/          break;
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
/*          if(!drawing.get(currentSphero).tm.isRunning()){
            drawing.get(currentSphero).hideSphero();
          }
*/          break;
        case "ResetSphero":
          usuario.enqueueInstruction(new Instruction(currentSphero, Command.RESETSPHERO));
          code.append("S"+(currentSphero+1)+" <- ResetSphero(); \n");
          break;
        case "Graph":
          GraphParent tmp = new GraphParent();
          tmp.init();
          break;
        case "Create":
          System.out.println("entro create");
          if(usuario.getList().size() < 5){
            System.out.println("size < 5");
            usuario.addSphero();
            SpheroSurface ss = new SpheroSurface(cenx, ceny, 0, true);
            System.out.println("image error");
            ss.setPreferredSize(new Dimension(750,750));
            add(ss,c);
            setVisible(true);
            drawing.add(ss);
          } else {
            JOptionPane.showMessageDialog(null, "No se puede tener mas de 5 spheros.");
          }
          break;
        case "Run":
          Queue<Instruction> tempQueue = new Queue<Instruction>();
          drawing.get(currentSphero).resetSphero(cenx,ceny);
          usuario.getSphero(currentSphero).moveTo(cenx, ceny);
          usuario.getSphero(currentSphero).setShow(true);
          Instruction ins = new Instruction(0, Command.FORWARD);
          while(!usuario.getInstructionQueue().isEmpty()){
            ins = usuario.dequeueInstruction();
            String com = ins.toString();
            System.out.println(com);
            switch(com){
              case "FORWARD":
                drawing.get(ins.getId()).forward(sphero.getAngle(), ins.getInput1());
                usuario.getSphero(currentSphero).forward(ins.getInput1());
                System.out.println("Success FORWARD");
                break;
              case "BACKWARD":
                drawing.get(ins.getId()).backward(sphero.getAngle(), ins.getInput1());
                usuario.getSphero(currentSphero).backward(ins.getInput1());
                System.out.println("Success BACKWARD");
                break;
              case "ROTATE":
                usuario.getSphero(currentSphero).rotate(ins.getInput1());
                break;
              case "MOVETO":
                drawing.get(ins.getId()).moveTo(ins.getInput1(), ins.getInput2());
                usuario.getSphero(currentSphero).moveTo(ins.getInput1(), ins.getInput2());
                break;
              case "HIDESPHERO":
                drawing.get(ins.getId()).hideSphero();
                usuario.getSphero(currentSphero).hideSphero();
                break;
              case "RESETSPHERO":
                drawing.get(currentSphero).resetSphero(cenx,ceny);
                usuario.getSphero(currentSphero).moveTo(cenx, ceny);
                break;
            }
            tempQueue.enqueue(ins);
          }
          usuario.renewQueue(tempQueue);
          break;
        case "Save":
          int s = chooser.showSaveDialog(null);
          if (s == JFileChooser.APPROVE_OPTION) {
            String doc = chooser.getSelectedFile().getName();
            serialize(usuario.getProgram(),doc);
          }
          break;
        case "Load":
          int l = chooser.showOpenDialog(null);
          if (l == JFileChooser.APPROVE_OPTION) {
            String doc = chooser.getSelectedFile().getName();
            loadFile(doc);
            drawSpheros();
          }
          break;
        case "Clear":
          usuario.clearQueue();
          code.setText("");
          drawing.get(currentSphero).resetSphero(cenx,ceny);
          usuario.getSphero(currentSphero).moveTo(cenx, ceny);
          usuario.getSphero(currentSphero).setShow(true);
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
      }catch(IOException i) {
          i.printStackTrace();
      }
  }

  public void serialize(Program p, String file){
      try {
          FileOutputStream fileOut =   new FileOutputStream(file+".prg");
          ObjectOutputStream out = new ObjectOutputStream(fileOut);
          out.writeObject(p);
          out.close();
          fileOut.close();
      }catch(IOException i) {
          i.printStackTrace();
          JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo");
      }
  }

  public void loadFile(String file){
    try{
          FileInputStream fis = new FileInputStream(file);
          ObjectInputStream ois = new ObjectInputStream(fis);
          Program p = (Program) ois.readObject();
          ois.close();
          fis.close();
          usuario.setProgram(p);
          JOptionPane.showMessageDialog(null, "Archivo cargado");
        }catch(IOException i){
          JOptionPane.showMessageDialog(null, "ERROR: No existe el archivo");
        }catch(ClassNotFoundException c){
          c.printStackTrace();
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
