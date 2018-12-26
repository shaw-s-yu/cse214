import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TeamSelection2{
    
    public static void main(String[] args) throws IOException{
        
        String currentLine;
        BufferedReader br = new BufferedReader(new FileReader("in1.txt"));
        int operationNum=0, caseNum=0;
        
        //read case number
        currentLine = readNextLine(br);
        caseNum = Integer.parseInt(currentLine);
        
        //start
        //read operation number and start case
        for(int i=1; i<=caseNum; i++){
            currentLine = readNextLine(br);
            operationNum = Integer.parseInt(currentLine);
            
            System.out.println(i);
            LinkedListQ q = new LinkedListQ();
                
            //start operation in one case
            for(int j=0; j<operationNum; j++){
                
                //check operation
                currentLine = readNextLine(br);
                if(currentLine.length()>5) System.out.println("Wrong entry of operation");
                else if(currentLine.charAt(0)=='E'){
                    
                    //check enqueue operation
                    if(currentLine.length()!=5) System.out.println("Wrong entry of enqueue line");
                    
                    //enqueue
                    else{
                        int[] studentData = new int[2];
                        studentData[0]=Character.getNumericValue(currentLine.charAt(2));
                        studentData[1]=Character.getNumericValue(currentLine.charAt(4));
                        q.enqueue(studentData);
                    }
                        
                //dequeue
                }else if(currentLine.charAt(0)=='D'){
                    System.out.println(q.dequeue());
                }
                else System.out.println("Wrong entry of queue operation(D or E)");
            }
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
                
                
