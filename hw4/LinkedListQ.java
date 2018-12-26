import java.util.NoSuchElementException;
public class LinkedListQ{
    private Node head, tail;
    private int size;
    
    public LinkedListQ(){
        size=0;
        head=null;
        tail=null;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public int getSize(){
        return size;
    }
    
    public void addToLast(int[] element){
        if(head == null){
            Node tmp = new Node(element);
            head = tmp;
            tail = tmp;
        }else{
            tail.next = new Node(element,tail);
            tail = tail.next;
        }
    }

    //enqueue
    public void enqueue(int[] element) {
        size++;
        Node current = tail;
        while(current!=null){
            if(current.element[0]==element[0]){
                if(current.next == null) {
                    break;
                }
                Node tmp = new Node(element, current.next, current);
                current.next = tmp;
                tmp.next.prev = tmp;
                return;
            }
            current = current.prev;
        }
        addToLast(element);
    }
    
    //dequeue
    public String dequeue() {
        if (size == 0) return null;
        Node tmp = head;
        if (head.next.prev!=null) head.next.prev=null;
        head = head.next;
        size--;
        return tmp.element[0]+" "+tmp.element[1];
    }
	
    // double direction linkedList Node
    private class Node {
        int[] element;
        Node next;
        Node prev;
        
        public Node(int[] element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
        public Node(int[] element){
            this.element = element;
        }
        public Node(int[] element, Node prev){
            this.element = element;
            this.prev = prev;
        }

    }
	
}
