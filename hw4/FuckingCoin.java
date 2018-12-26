import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FuckingCoin{
    
    public static void main(String[] args) throws IOException{
        
        String currentLine;
        BufferedReader br = new BufferedReader(new FileReader("in2.txt"));
        int caseNum=0;
        
        //read case number
        currentLine = readNextLine(br);
        caseNum = Integer.parseInt(currentLine);
        
        //start
        for(int i=1;i<=caseNum;i++){
            int operationNum=0, coinNum=0, xValue=0, output=-1;
            
            //read coin number and start case
            currentLine = readNextLine(br);
            coinNum = Integer.parseInt(currentLine);
            
            //girlsBag is queue, takasBag is stack
            LinkedCoin<Integer> girlsBag = new LinkedCoin<Integer>();
            LinkedCoin<Integer> takasBag = new LinkedCoin<Integer>();
            
            //read next line: coin values
            currentLine = readNextLine(br);
            String[] coins =currentLine.split(" ");
            
            //load coin values into girlsBag
            for(int j=0; j<coinNum; j++){
                girlsBag.enqueue(Integer.parseInt(coins[j]));
            }
            
            //read next line: operation number & X value
            currentLine = readNextLine(br);
            String[] opnx = currentLine.split(" ");
            if(opnx.length>2) System.out.println("extra data found(opnx)");
            operationNum=Integer.parseInt(opnx[0]);
            xValue=Integer.parseInt(opnx[1]);
            
            //start operations
            for(int k=0;k<operationNum;k++){
                
                //read operation
                currentLine = readNextLine(br);
                
                if(currentLine.equals("Take")){
                    int nextCoinValue = girlsBag.dequeue();
                    takasBag.push(nextCoinValue);
                }else if(currentLine.equals("Remove")){
                    takasBag.pop();
                }
                
                //check if taka's coins amount reaches x
                if(takasBag.getSum()==xValue) {
                    output = takasBag.size();
                    break;
                }
            }
            System.out.println(output);
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
