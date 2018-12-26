public class HashTable{
    private int[] hash;
    private boolean[] key;
    private boolean[] first;
    private boolean[] second;
    private boolean[] third;
    private int size=0;
    
    public HashTable(int size){
        this.size = size;
        hash =new int[this.size];
        for(int i=0; i<this.size;i++){
            hash[i]=-1;
        }

    }
    
    public void insert(int element){
        int k = element % size;
        while(hash[k]!=-1){
            k++;
        }
        hash[k]=element;
        
    }

    public void printHash(){
        for(int i=0;i<size;i++){
            System.out.print(hash[i]+" ");
        }
        System.out.println();
    }

    public int search(int element, int first){
        int k = element % size;
        if(k<first) k=first;
        while(hash[k]!=element && hash[k]>0){
            k++;
        }
        if(hash[k]==element){
            return k;
        }
        else return -1;
    }

}
