package anpharos.structures;

public class Queue<T>{

	protected Node<T> head;
	protected Node<T> tail;
	protected int size;

	public Queue(){
		head = null;
		tail = null;
		size = 0;
	}

	public void enqueue(Node<T> node){
		if(size>0){
			tail.setNext(node);
			node.setNext(null);
			tail = node;
		} else {
			node.setNext(null);
			head = node;
			tail = node;
		}
		size++;
	}
	
	public Node<T> dequeue(){
		Node<T> toBeDequeued = head;
		head = head.getNext();
		toBeDequeued.setNext(null);
		size--;
		return toBeDequeued;
	}


	public Node<T> get(int index){
//		System.out.println("index "+index);
//		System.out.println("size "+size);
		if(index<size && index>=0){
			int i = 0;
			Node<T> current = head;
			while(i<index){
				current = current.getNext();
				i++;
			}
			return current;
		} else {
			System.out.println("ERROR get int");
			return new Node<T>();
		}
	}

	public Node<T> get(long index){
		if(index<size && index>=0){
			int i = 0;
			Node<T> current = head;
			while(i<index){
				current = current.getNext();
				i++;
			}
			return current;
		} else {
			System.out.println("ERROR get long");
			return new Node<T>();
		}
	}

	public Node<T> getFirst(){
		return head;
	}

	public Node<T> getLast(){
		return tail;
	}

	public long getSize(){
		return size;
	}

	public boolean isEmpty(){
		if(size>0){
			return false;
		} else {
			return true;
		}
	}

}