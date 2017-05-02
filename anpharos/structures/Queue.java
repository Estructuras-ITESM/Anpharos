package anpharos.structures;

import java.util.LinkedList;

public class Queue<T> extends LinkedList<T>{

    public Queue(){
        super();
    }

    public void enqueue(T t){
        this.addLast(t);
    }

    public T dequeue(){
        return this.removeFirst();
    }

}

