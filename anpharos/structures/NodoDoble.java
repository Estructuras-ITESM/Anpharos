package anpharos.structures;

public class NodoDoble<V> {
	private V element; 
	private NodoDoble<V> next; 
	private NodoDoble<V> before; 
	
	public NodoDoble()
	{
		this(null,null,null);
	}
	
	public NodoDoble(V element, NodoDoble<V> next, NodoDoble<V> before)
	{
		this.element =element; 
		this.next = next; 
		this.before = before; 
	}
	
	public V getElement()
	{
		return element; 
	}
	
	public NodoDoble<V> getBefore()
	{
		return before; 
	}
	
	public NodoDoble<V> getNext()
	{
		return next; 
	}
	
	public void setElement(V element)
	{
		this.element = element; 
	}
	
	public void setBefore(NodoDoble<V> before)
	{
		this.before = before; 
	}
	
	public void setNext(NodoDoble<V> next)
	{
		this.next = next; 
	}
}
