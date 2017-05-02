package anpharos.structures;

public class Nodo<T>
{
	private T element; //es el contennido del nodo
	private Nodo<T> next; //es la referencia al siguiente nodo
	
	public Nodo()
	{
		 this(null,null);
	}
		
	public Nodo(T element, Nodo<T> next)
	{
		this.element = element; 
		this.next = next;
	}
		
	public T getElement()//regresa el contenido del nodo
	{
		
		return element;
	}
		
	public Nodo<T> getNext()//regresa la referencia del siguiente nodo
	{
		return next; 
	}
		
	public void setElement(T element)
	{	
		this.element = element; 
	}
		
	public void setNext(Nodo<T> next)
	{
		this.next = next; 
	}
}