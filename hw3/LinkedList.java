

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T>{
	private Node<T> head;
	
	 /**
	   *  Constructs an empty list
	   */
	public LinkedList() {
		this.head = null;
	}
	
	 /**
	   *  Returns size of the list
	   */
	public int size() {
		int size = 0;
		if(head != null) {
			size ++;
			Node<T> current = head;
			while(current.next!= null) {
				size ++;
				current = current.next;
			}
		}
		
		return size;
	}
	
	 /**
	   *  Returns true if the list is empty
	   *
	   */
	public boolean isEmpty() {
		return head == null;
	}
	
	 /**
	   *  Removes all nodes from the list.
	   *
	   */
	public void clear() {
		this.head = null;
	}
	
	 /**
	   *  Returns the data at the specified position in the list.
	   */
	public T get(int pos) {
		if(head == null) throw new IndexOutOfBoundsException();
		int currentIndex = 0;
		Node<T> current = head;
		while(currentIndex < pos && current!= null) {
			currentIndex ++;
			current = current.next;
		}
		
		if(current != null) {
			return current.data;
		} else{
			throw new IndexOutOfBoundsException();
		}
		
	}
	
	/**
	   *  Returns true if this list contains the specified element.
	   *
	   */
	public boolean contains(T x) {
		for(T temp: this) {
			if(temp.equals(x)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	  *  Returns the first element in the list.
	  *
	  */
	public T getFirst() {
		if(head == null) throw new NoSuchElementException();
		return head.data;
	}
	
	 /**
	   *  Inserts a new node at the beginning of this list.
	   *
	   */
	public void push(T data) {
		this.head = new Node<T>(data, head);
	}
	
	/**
	  *  Removes the first element in the list.
	  *
	  */
	public T pop() {
		T temp = getFirst();
		head = head.next;
		return temp;
	}
	
	/**
	   *  Returns the last element in the list.
	   *
	   */
	public T getLast() {
		if(head == null)  throw new NoSuchElementException();
		Node<T> current = head;
		while(current.next != null) {
			current = current.next;
		}
		return current.data;
	}
	
	/**
	   *  Inserts a new node to the end of this list.
	   *
	   */
    
    public void addToLast(T data) {
        if(head == null) {
            head = new Node<T>(data, head);
        } else{
            Node<T> current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new Node<T>(data, null);
        }
    }
    
    public Node<T> getHead(){
        return head;
    }
    
    public void printData(Node node){
        if(node == null) return;
        printData(node.next);
        System.out.print(node.data);
        }
	
    
	/**
	 * Removes the first occurrence of the specified element in this list.
	 * 
	 */
	
	public void remove(T key) {
		if(head == null) throw new NoSuchElementException();
		if(head.data.equals(key)) {
			head = head.next;
			return;
		}
		
		Node<T> prev = null;
		Node<T> current = head;
		while(current != null && !current.data.equals(key)) {
			prev = current;
			current = current.next;
		}
		if(current != null) {
			prev.next = current.next;
		} else{
			throw new NoSuchElementException();
		}
	}
	
	
	
	/**
	 * The Node class
	 */
	private static class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	/**
	 * 
	 * The Iterator class
	 */
	
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<T> {
		private Node<T> nextNode;
		
		public LinkedListIterator() {
			this.nextNode = head;
		}
		
		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		@Override
		public T next() {
			if(!hasNext()) throw new NoSuchElementException();
			T d = nextNode.data;
			nextNode = nextNode.next;
			return d;
		}
		
	}
	
	 /**
	   *  Returns a string representation
	   *
	   */
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
	      for(Object x : this)
	      	result.append(x + " ");

	      return result.toString();
	}
	
	/*
	 * *************************
	 * Homework Problems
	 * 
	 * *************************
	 */
	
	/**
	 *  Inserts a new node at pos.
	 */
	public void insertAt(int pos, T toInsert) {
        if(pos<0) throw new IllegalArgumentException();
        if(head == null) throw new IndexOutOfBoundsException();
        int currentIndex = 1;
        Node<T> current = head;
        while(currentIndex < pos && current!= null) {
            currentIndex ++;
            current = current.next;
        }
        if(current != null) {
            Node<T> insertNode=new Node<T>(toInsert,current.next);
            current.next=insertNode;
        } else{
            throw new IndexOutOfBoundsException();
        }
        
	}
	
	/**
	 * Removes the item at position pos in this list.
	 * 
	 */
	public void removeAt(int pos) {
        if(pos<0) throw new IllegalArgumentException();
        if(head == null) throw new IndexOutOfBoundsException();
        int currentIndex = 1;
        Node<T> current = head;
        while(currentIndex < pos && current!= null) {
            currentIndex ++;
            current = current.next;
        }
        if(current != null) {
            Node<T> removeNode=current.next;
            current.next=removeNode.next;
        } else{
            throw new IndexOutOfBoundsException();
        }
	}
	
	/**
	 *  Inserts a new node after a node containing the key.
	 *
	 */
	public void insertAfter(T key, T toInsert) {
        if(head == null) throw new IndexOutOfBoundsException();
        if(!contains(key)) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        while(key!=current.data && current!= null) {
            current = current.next;
        }
        if(current != null && key==current.data) {
            Node<T> insertNode = new Node<T>(toInsert,current.next);
            current.next=insertNode;
        } else{
            throw new IndexOutOfBoundsException();
        }
	}
	
	 /**
	   *  Inserts a new node before a node containing the key.
	   */
	public void insertBefore(T key, T toInsert) {
        if(head == null) throw new IndexOutOfBoundsException();
        if(!contains(key)) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        while(key!=current.data && current!= null) {
            if(current.next.data==key){
                Node<T> insertNode=current.next;
                current.next=new Node<T>(toInsert,insertNode);
                break;
            }
            current=current.next;
        }
        if(current != null) {
            if(key==current.data){
                head=new Node<T>(toInsert,head);
            }
        } else{
            throw new IndexOutOfBoundsException();
        }

	}
	
	/**
	  *  sort the list
	  */
	public void sortList() {
        int nsize=size();
        for(int i=0;i<nsize;i++){
           for(int j=i+1;j<nsize;j++){
               if((Integer)get(i)>(Integer)get(j)){
                   T tempData1=get(i);
                   T tempData2=get(j);
                   insertAt(i,tempData2);
                   insertAt(j+1,tempData1);
                   removeAt(i+1);   //224624345
                                    //22624345
                   removeAt(j+1);
                   
               }
           }
        }
	}
	
	/**
	 * removes duplicate elements from the list
	 */
	public void removeDuplicates() {
        Node<T> current = head;
        int nsize=size();
        for(int i=0;i<nsize;i++){
            T tempData=current.data;
            remove(current.data);
            current=current.next;
            if(!contains(tempData)){
                push(tempData);
            }
        }
	}

	
}
