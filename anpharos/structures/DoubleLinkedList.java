package anpharos.structures;

public class DoubleLinkedList<V>
{
	protected NodoDoble<V> head;
	protected NodoDoble<V> tail;
	protected long size; 
	
	public DoubleLinkedList() //constructor vacio
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
		else //si hay head ese se cambia a la 2da posición  y el nuevo elemento es el nuevo head
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
			//el before de head siempre es null 
		}	
		size++; //se aumenta el tamaño de la lista
	}
	
	public void addAfter(int lugar, V newElement)//funciona de 0 a size-1
	{
		if(lugar <= size && lugar>=0) //esta dentro de los Nodo<T>s
		{
			NodoDoble<V> temporal = new NodoDoble<V>(head.getElement(),head.getNext(),null); //Nodo<T> que cambia hasta llegar a el Nodo<T> antes del que queremos agregar
			if(lugar == 0) //en caso de que quieran agregar después de 0 
				addFirst(newElement);
			else if(lugar==size)
				addLast(newElement); 
			else
			{
				for(int i = 1; i<lugar; i++)
				{
					temporal = temporal.getNext(); 
				}
					
				NodoDoble<V> nuevo = new NodoDoble<V>(newElement,temporal.getNext(),temporal);//el Nodo<T> que se agrega se define como el elemento y se le asigna de siguiente de temporal
				temporal.getNext().setBefore(nuevo);
				temporal.setNext(nuevo);//se cambia la referencia de temporal para que quede dentro de la lista 
				if(lugar ==1)
					head = temporal;
				size++; //Se aumenta el tamaño de la lista
			}
		}
		else 
				System.out.println("El lugar donde quieres agregar el elemento no existe");
	}
	
	public void addLast(V newElement)
	{
		if(size == 0) //En caso de que no haya head
		{
			addFirst(newElement); //Entra a addFirst 
		}
		else if(size == 1)
		{
			tail.setElement(newElement);
			size++;
		}
		else //si hay otros Nodo<T>s aparte de head 
		{
			 NodoDoble<V> temporal = new NodoDoble<V>(newElement,null,null); //es el nodo que queremos agregar al final 
			 NodoDoble<V> actual = new NodoDoble<V>(head.getElement(),head.getNext(),null); //es el nodo que vamos a modificar hasta llegar al ultimo de la lista 
			while(actual.getNext() !=null)//para llegar al último 
			{
				actual = actual.getNext(); 
			}
			tail = temporal; //tail ahora es temporal 
			tail.setBefore(actual);
			actual.setNext(tail); //tail se liga a la lista 
			size++; //se aumenta uno al tamaño de la lista 
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
	
	public boolean remove( int quitar) //rev //funciona de 0 a size-1
	{
		if(quitar<0 || quitar > size)//index out of range
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
				NodoDoble<V> temporal = new NodoDoble<V>(head.getElement(),head.getNext(),null);; //debe ser uno antes del que queremos quitar 
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
