import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VisibleBST{
    
    public static void main(String[] args) throws IOException{
        String currentLine;
        BufferedReader br = new BufferedReader(new FileReader("in1.txt"));
        int caseNum=0;
        
        //read case number
        currentLine = readNextLine(br);
        caseNum = Integer.parseInt(currentLine);
        
        //start
        for(int i=1;i<=caseNum;i++){
            
            //read number of node
            int numNode=0;
            currentLine = readNextLine(br);
            numNode = Integer.parseInt(currentLine);
        
            LinkedBST<Integer> visibleTree = new LinkedBST<Integer>();
            
            //read node and insert to tree
            currentLine = readNextLine(br);
            String[] nodes = currentLine.split("\t");
            
            for(int j=0;j<numNode;j++){
                visibleTree.insert(Integer.parseInt(nodes[j]));
            }
            visibleTree.searchLast();
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
