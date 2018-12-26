import java.lang.Comparable;
public class LinkedBST<T extends Comparable<T>> {

    private Node<T> root;
    
    private static class Node<T>{
        private T data;
        private Node<T> left;
        private Node<T> right;
        
        public Node(T data){
            this.left=null;
            this.right=null;
            this.data=data;
        }
    }
    
        
    private int compare(T x, T y){
        return x.compareTo(y);
    }
    
        
    public void insert(T data){
        root = insert(root,data);
    }
    private Node<T> insert(Node<T> p, T toInsert){
        if(p==null) return new Node<T>(toInsert);
        if(compare(toInsert, p.data)==0) return p;
        if(compare(toInsert, p.data)<0) p.left = insert(p.left, toInsert);
        else p.right = insert(p.right, toInsert);
        return p;
    }
    
    public void searchLast(){
        root = searchLast(root);
    }
    private Node<T> searchLast(Node<T> p){
        if(p==null) return p;
        System.out.print(p.data);
        if(p.left==null && p.right==null) return p;
        System.out.print("-");
        if(p.right!=null) p.right=searchLast(p.right);
        else if(p.left!=null) p.left=searchLast(p.left);
        return p;
    }
}
