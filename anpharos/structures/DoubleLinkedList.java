package anpharos.structures;

public class DoubleLinkedList<V> {
	protected NodoDoble<V> head;
	protected NodoDoble<V> tail;
	protected long size; 
	
	public DoubleLinkedList() 
	{
		head = new NodoDoble<V>(); 
		tail = new NodoDoble<V>(); 
		size = 0; 
	} 
	
	public void addFirst(V newElement) 
	{
		if(size == 0)
		{
			addVeryFirst(newElement);
		}
		else 
		{
			NodoDoble<V> temporal = new NodoDoble<V>(head.getElement(),head.getNext(),null);
			if(size == 1)
			{
				tail.setElement(head.getElement());
				tail.setNext(null);
				tail.setBefore(head);
				head.setElement(newElement); 
				head.setNext(tail);
			}
			else
			{
				head.setElement(newElement); 
				head.getNext().setBefore(temporal);
				temporal.setNext(head.getNext());
				head.setNext(temporal);
				temporal.setBefore(head);
				
				
			}
	
		}	
		size++; 
	}
	
	public void addAfter(int lugar, V newElement)
	{
		if(lugar <= size && lugar>=0)
		{
			NodoDoble<V> temporal = new NodoDoble<V>(head.getElement(),head.getNext(),null); 
			if(lugar == 0) 
				addFirst(newElement);
			else if(lugar==size)
				addLast(newElement); 
			else
			{
				for(int i = 1; i<lugar; i++)
				{
					temporal = temporal.getNext(); 
				}
					
				NodoDoble<V> nuevo = new NodoDoble<V>(newElement,temporal.getNext(),temporal);
				temporal.getNext().setBefore(nuevo);
				temporal.setNext(nuevo);
				if(lugar ==1)
					head = temporal;
				size++; 
			}
		}
		else 
				System.out.println("El lugar donde quieres agregar el elemento no existe");
	}
	
	public void addLast(V newElement)
	{
		if(size == 0)
		{
			addFirst(newElement); 		}
		else if(size == 1)
		{
			tail.setElement(newElement);
			size++;
		}
		else 
		{
			 NodoDoble<V> temporal = new NodoDoble<V>(newElement,null,null); 
			 NodoDoble<V> actual = new NodoDoble<V>(head.getElement(),head.getNext(),null); 
			 while(actual.getNext() !=null)
			{
				actual = actual.getNext(); 
			}
			tail = temporal; 
			tail.setBefore(actual);
			actual.setNext(tail);
			size++; 
		}
		
	}
	public void addVeryFirst(V newElement)
	{
		head.setElement(newElement); 
		head.setNext(tail);
		tail.setBefore(head);
	}
	
	public NodoDoble<V> removeFirst()
	{
		if(size<1)
			return head; 
		else
		{
			head = head.getNext();
			head.setBefore(null);
		}
		size--;
		return head; 
	}
	
	public NodoDoble<V> removeLast()
	{
		if(size <= 1)
		{
			return removeFirst(); 
		}
		else
		{
			tail = tail.getBefore(); 
			tail.setNext(null);
		}
		size--; 
		return tail; 
	}
	
	public boolean remove( int quitar) 
	{
		if(quitar<0 || quitar > size)
		{
			System.out.println("El elemento que quieres quitar no existe");
			return false; 
		}
		else
		{
			if(quitar == 0)
				removeFirst(); 
			else if(quitar == (size-1))
				removeLast(); 
			else
			{
				NodoDoble<V> temporal = new NodoDoble<V>(head.getElement(),head.getNext(),null);;
				for(int i=0; i<(quitar-1); i++)
				{
					temporal = temporal.getNext();
				}
				temporal.getNext().getNext().setBefore(temporal);
				temporal.setNext(temporal.getNext().getNext()); 
				size--;
			}
			return true; 
		}
	}
	
	public  NodoDoble<V> getFirst()
	{
		return head; 
	}
	
	public  NodoDoble<V> getLast()
	{
		return tail; 
	}
	
	public  long getSize()
	{
		return size;
	}
	
	public String inicioFin()
	{
		String lista =""; 
		NodoDoble<V> hola = head;
		
		for(int i = 0; i<size; i++)
		{
			lista+= i+""+ hola.getElement() +"\n";
			hola = hola.getNext();
		}
		return lista;
	}
	
	
	public String finInicio()
	{
		String lista =""; 
		NodoDoble<V> hola = tail;
		if(size == 1)
			hola = head; 
		for(int i = 0; i<size; i++)
		{
			lista+= i+" "+ hola.getElement() +"\n";
			hola = hola.getBefore();
		}
		return lista;
	}
}
