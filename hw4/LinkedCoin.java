import java.util.NoSuchElementException;
public class LinkedCoin<T extends Number> {
    
    private Node<T> head;
    
    //constructor
    public LinkedCoin(){
        this.head = null;
    }
    
    //Returns true if the list is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    //Returns size of the list
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
    
    //add up data
    public int getSum() {
        int sum = 0;
        if(head !=null) {
            sum = head.data.intValue();
            Node<T> current = head;
            while(current.next!=null){
                sum += current.next.data.intValue();
                current=current.next;
            }
        }
        return sum;
    }
    
    //enqueue(add to last)
    public void enqueue(T data){
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
    
    //dequeue(remove first)
    public T dequeue(){
        T temp = head.data;
        head = head.next;
        return temp;
    }
    
    //push(add to first)
    public void push(T data) {
        this.head = new Node<T>(data, head);
    }
    
    //pop(remove first)
    public T pop(){
        T temp = head.data;
        head = head.next;
        return temp;
    }
    
    //Node class
    private static class Node<T> {
        private T data;
        private Node<T> next;
        
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}

