import java.util.*;
import java.io.*;

public class Usuario implements Serializable{
  private String nombre, contrasena;
  private LinkedList<Sphero> spheros;


  public Usuario(String nombre, String contrasena){
    this.nombre = nombre;
    this.contrasena = contrasena;
    spheros = new LinkedList<Sphero>();
    spheros.add(new Sphero(100,100,""));
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

  public LinkedList<Sphero> getList(){
    return spheros;
  }
} 
