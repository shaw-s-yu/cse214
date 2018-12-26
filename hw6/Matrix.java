public class Matrix{
    private int[][] matrix;
    private int rowSize=1000;
    private int columnSize=1000;
    private int rowPosition;
    private int columnPosition;
    
    public Matrix(int rowSize, int columnSize){
        rowPosition = 0;
        columnPosition = 0;
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        matrix = new int[this.columnSize][this.rowSize];
    }
    
    public void columnAppend(int element){
        matrix[columnPosition][rowPosition] = element;
        columnPosition++;
    }
    
    public void nextRow(){
        if(rowPosition>=0 && rowPosition < rowSize){
            columnPosition=0;
            rowPosition++;
        }
        else{
            System.out.println("invalid rowPosition");
            System.exit(0);
        }
    }
    
    public void printMatrix(){
        for(int i=0; i< columnSize; i++){
            for(int j=0; j<rowSize; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public String search(int target){
        String result="-1 -1";
        for(int i=0; i<columnSize; i++){
            if(target>=matrix[i][0] && target<=matrix[i][columnSize-1])
                result = binarySearch(matrix[i],0,rowSize,target)+" "+i;
        }
        return result;
        
    }
    
    private String binarySearch(int[] a, int first, int size, int target){
        int mid;
        if(size<=0) return "-1";
        else{
            mid = first+(size/2);
            if(target==a[mid]) return Integer.toString(mid);
            else if(target<a[mid]) return binarySearch(a, first, size/2, target);
            else return binarySearch(a, mid+1, (size-1)/2, target);
        }
    }
}
