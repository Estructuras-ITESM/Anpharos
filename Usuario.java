import java.util.*;

public class Usuario{
  private String nombre, contrasena;
  private LinkedList<Sphero> spheros;


  public Usuario(String nombre, String contrasena){
    this.nombre = nombre;
    this.contrasena = contrasena;
    spheros = new LinkedList<Sphero>();
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
    return spheros.get(i);
  }

  public void setSphero(Sphero sphero){
    spheros.add(sphero);
  }
} 