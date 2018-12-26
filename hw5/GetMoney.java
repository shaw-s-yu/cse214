import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetMoney{
    
    public static void main(String[] args) throws IOException{
        String currentLine;
        BufferedReader br = new BufferedReader(new FileReader("in2.txt"));
        int caseNum=0;
        
        //read case number
        currentLine = readNextLine(br);
        caseNum = Integer.parseInt(currentLine);
        
        //start
        for(int i=1;i<=caseNum;i++){
            
            //read M and N
            currentLine = readNextLine(br);
            String[] line=currentLine.split("\t");
            int nRow = Integer.parseInt(line[0]);
            int nPeople = Integer.parseInt(line[1]);
            
            //read rows and insert
            currentLine = readNextLine(br);
            line=currentLine.split("\t");
            MaxHeap heap = new MaxHeap(1000000);
            for(int j=0; j<nRow; j++){
                heap.insert(Integer.parseInt(line[j]));
            }
            //heap.printHeap();
            
            //load people to seat and get money
            int total = 0;
            int difference = heap.getDifference();
            int nextPay = heap.getMax();
            while(nPeople>0){
                //System.out.println("nextPay:"+nextPay);
                total+=nextPay;
                nPeople--;
                if(difference>0){
                    difference--;
                    nextPay--;
                }
                else{
                    heap.delete();
                    nextPay=heap.getMax();
                    difference = heap.getDifference();
                }
            }
            System.out.println(total);
        }
    }
    
    public static String readNextLine(BufferedReader br){
        String currentLine=null;
        try{
            currentLine = br.readLine();
        }catch (IOException e){
            System.out.println("no input");
            System.exit(0);
        }
        return currentLine;
    }
}
