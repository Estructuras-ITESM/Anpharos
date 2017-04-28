package anpharos.structures;

public class SingleLinkedList <T>{
    protected Node<T> head;
    protected Node<T> tail;
    protected long size;

    public SingleLinkedList()
    {
        head = new Node<T>();
        tail = new Node<T>();
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
            Node<T> temporal = new Node<T>(head.getElement(),head.getNext());
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
            Node<T> temporal = new Node<T>(newElement,null);
            Node<T> actual = new Node<T>(head.getElement(),head.getNext());
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
            Node<T> temporal = new Node<T>(head.getElement(),head.getNext());
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
                Node<T> nuevo = new Node<T>(newElement,temporal.getNext());
                temporal.setNext(nuevo);
                if(lugar ==1)
                    head = temporal;
                size++;
            }
        }
        else
            System.out.println("El lugar no existe");
    }

    public Node<T> removeFirst()
    {
        if(size<1)
            return head;
        if(size == 1)
            head = new Node<T>(null, null);
        else
        {
            Node<T> temporal = head.getNext();
            head= temporal;
        }
        size--;
        return head;
    }
    public Node<T> removeLast()
    {
        if(size <= 1)
        {
            return removeFirst();
        }
        else
        {
            Node<T> actual = new Node<T>(head.getElement(), head.getNext());
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
                Node<T> temporal = head;
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

    public Node<T> getLast()
    {
        return tail;
    }
    public Node<T> getFirst()
    {
        return head;
    }
    public long getSize()
    {
        return size;
    }


}
