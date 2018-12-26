import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchMatrix{
    public static void main(String[] arg)throws IOException{
        String currentLine;
        BufferedReader br = new BufferedReader(new FileReader("in1.txt"));
        
        //read case number
        currentLine = readNextLine(br);
        int caseNum = Integer.parseInt(currentLine);
        
        for(int i=1;i<=caseNum; i++){
            //read rowsize and columnsize
            currentLine = readNextLine(br);
            String[] line = currentLine.split(" ");
            int rowSize =Integer.parseInt(line[1]);
            int columnSize =Integer.parseInt(line[0]);
            Matrix matrix = new Matrix(columnSize, rowSize);
        
            // read data and lode into matrix
            for(int j=0; j<rowSize;j++){
            
                currentLine = readNextLine(br);
                line = currentLine.split(" ");
                
                for(int k=0;k<columnSize;k++){
                    matrix.columnAppend(Integer.parseInt(line[k]));
                }
                matrix.nextRow();
            }
            
            // read searching element number
            currentLine = readNextLine(br);
            int eleNum = Integer.parseInt(currentLine);
            
            //matrix.printMatrix();
            
            // search and print position
            for(int k=0; k<eleNum; k++){
                currentLine = readNextLine(br);
                int element = Integer.parseInt(currentLine);
                System.out.println(element+":"+matrix.search(element));
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
