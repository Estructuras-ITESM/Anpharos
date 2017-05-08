import java.io.Serializable;

public class Usuario implements Serializable{
  private String nombre, contrasena;
  private Program program;

  public Usuario(String nombre, String contrasena){
    this.nombre = nombre;
    this.contrasena = contrasena;
    program = new Program();
  }

  public String getNombre(){
    return nombre;
  }

  public String getContrasena(){
    return contrasena;
  }

  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  public void setConstrasena(String contrasena){
    this.contrasena = contrasena;
  }

  public Sphero getSphero(int i){
    return program.getSpheroList().get(i);
  }

  public void enqueueInstruction(Instruction instruction){
    program.getInstructionQueue().enqueue(instruction);
  }

} 
