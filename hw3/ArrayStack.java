public class ArrayStack{
    private String[] s;
    private int top = 0;
    
    public ArrayStack(int capacity){
        s = new String[capacity];
    }
    
    public boolean isEmpty(){
        return top == 0;
    }
    
    public void push(String item){
        if(top < s.length){
            s[top++] = item;
        }else{
            for(int i=1;i<s.length;i++){
                s[i-1] = s[i];
            }
            s[s.length-1] = item;
        }
    }
    
    public String pop() {
        String item = s[--top];
        s[top]=null;
        return item;
    }
}
