import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DigTreasure{
    public static void main(String[] arg)throws IOException{
        String currentLine;
        BufferedReader br = new BufferedReader(new FileReader("in2.txt"));
        
        //read case number
        currentLine = readNextLine(br);
        int caseNum = Integer.parseInt(currentLine);
        
        for(int i=1; i<=caseNum; i++){
            
            //read M and N
            currentLine = readNextLine(br);
            String[] line = currentLine.split(" ");
            int eleNum = Integer.parseInt(line[0]);
            int sum = Integer.parseInt(line[1]);
            
            //read next line and load elements into HashTable
            currentLine = readNextLine(br);
            line = currentLine.split(" ");
            HashTable hash = new HashTable(23);
            for(int j=0; j<eleNum; j++){
                hash.insert(Integer.parseInt(line[j]));
            }
            //hash.printHash();
            int total=0;
            
            for(int j=0; j<=sum;j++){
                //System.out.println("   initial searching"+j);
                if(hash.search(j,j)>=0){
                    for(int k=0; k<=sum-j; k++){
                        //System.out.println("searching "+j+" "+k+" "+(sum-k-j));
                        int second = hash.search(k,j+1);
                        int third = hash.search(sum-k-j,second);
                        while(second>=0 && third >=0 && second!=third){
                            //System.out.println("--------number:"+j+" "+k+" "+(sum-k-j));
                            //System.out.println("------position:"+j+" "+second+" "+third);
                            total++;
                            third = hash.search(sum-k-j,third+1);
                            
                        }
                    }
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
