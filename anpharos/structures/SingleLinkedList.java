package anpharos.structures;

public class SingleLinkedList <T>{
    protected Nodo<T> head;
    protected Nodo<T> tail;
    protected long size;

    public SingleLinkedList()
    {
        head = new Nodo<T>();
        tail = new Nodo<T>();
        size = 0;
    }

    public void addFirst(T newElement)
    {
        if(size == 0)
        {
            head.setElement(newElement);
            tail.setElement(newElement);
        }
        else
        {
            Nodo<T> temporal = new Nodo<T>(head.getElement(),head.getNext());
            if(size == 1)
                temporal=tail;
            head.setElement(newElement);
            head.setNext(temporal);
        }
        size++;
    }

    public void addLast(T newElement)
    {
        if(size == 0)
        {
            addFirst(newElement);
        }
        else if(size == 1)
        {
            tail.setElement(newElement);
            head.setNext(tail);
            size++;
        }
        else
        {
            Nodo<T> temporal = new Nodo<T>(newElement,null);
            Nodo<T> actual = new Nodo<T>(head.getElement(),head.getNext());
            while(actual.getNext() !=null)
            {
                actual = actual.getNext();
            }
            tail = temporal;
            actual.setNext(tail);
            size++;
        }

    }

    public void addAfter(int lugar, T newElement)
    {
        System.out.println("lugar == 0" + (lugar == 0));
        System.out.println("lugar == size" + (lugar == size));
        if(lugar <= size && lugar>=0)
        {
            Nodo<T> temporal = new Nodo<T>(head.getElement(),head.getNext());
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
                Nodo<T> nuevo = new Nodo<T>(newElement,temporal.getNext());
                temporal.setNext(nuevo);
                if(lugar ==1)
                    head = temporal;
                size++;
            }
        }
        else
            System.out.println("El lugar no existe");
    }

    public Nodo<T> removeFirst()
    {
        if(size<1)
            return head;
        if(size == 1)
            head = new Nodo<T>(null, null);
        else
        {
            Nodo<T> temporal = head.getNext();
            head= temporal;
        }
        size--;
        return head;
    }
    public Nodo<T> removeLast()
    {
        if(size <= 1)
        {
            return removeFirst();
        }
        else
        {
            Nodo<T> actual = new Nodo<T>(head.getElement(), head.getNext());
            while(actual.getNext().getNext() != null)
            {
                actual = actual.getNext();
            }
            tail = actual;
        }
        size--;
        return tail;
    }
    public boolean remove(int quitar)
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
                Nodo<T> temporal = head;
                for(int i=0; i<(quitar-1); i++)
                {
                    temporal = temporal.getNext();
                    System.out.println("temporal "+temporal.getElement());
                }
                temporal.setNext(temporal.getNext().getNext());
                size--;
            }
            return true;
        }
    }

    public Nodo<T> getLast()
    {
        return tail;
    }
    public Nodo<T> getFirst()
    {
        return head;
    }
    public long getSize()
    {
        return size;
    }


}

