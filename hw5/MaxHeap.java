                                                                                                                                                                                                                                                                      public class MaxHeap{
    private int[] data;
    private int heapSize;
    private int maxSize;
    
    public MaxHeap(int maximumSize) {
        if (maximumSize < 1) maxSize = 100;
        else maxSize = maximumSize;
        data = new int[maxSize];
        heapSize = 0;
    }
    
    public boolean isEmpty(){
        if(heapSize == 0) return true;
        else return false;
    }
    
    public boolean isFull(){
        if(heapSize == maxSize) return true;
        else return false;
    }
    
    public void insert(int item) {
        int position;
        if(isFull()) {
            System.out.println("insert: heap is full");
            System.exit(0);
        }
        heapSize++;
        data[heapSize-1] = item;
        position = heapSize - 1;
        while (position > 0 && data[position] > data[(position-1)/2]){
            swap(position, (position-1)/2);
            position = (position-1) / 2;
        }
    }

    public int delete(){
		int answer;
        if(isEmpty()){
            System.out.println("delete: heap is empty");
            System.exit(0);
        }
		answer = data[0];
		data[0] = data[heapSize-1];
		heapSize--;
		heapify();
		return answer;
	}

	private void heapify() {
		int position = 0; int childPos;
		while (position*2+1 < heapSize) {
            childPos = position*2 + 1;
            if (childPos < heapSize-1
                && data[childPos+1] > data[childPos])
                childPos++;
            if (data[position]>= data[childPos])
                return;
            swap(position, childPos);
            position = childPos;
		}
	}
    
    public int getDifference (){
        if(data[1]>data[2]) return data[0]-data[1];
        else if(data[1]<data[2]) return data[0]-data[2];
        return data[0]-data[1]+1;
    }
    
    public int getMax(){
        return data[0];
    }
    
    public void swap(int a, int b){
        int temp=data[a];
        data[a] = data[b];
        data[b] = temp;
    }
    
    public void printHeap(){
        for(int i=0; i<heapSize; i++){
            System.out.print(data[i]+" ");
        }
    }
}
