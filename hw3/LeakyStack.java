import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeakyStack{
    
    public static void main(String[] args) throws IOException{
        String currentLine;
        BufferedReader br = new BufferedReader(new FileReader("in2.txt"));
        
        int currentIndex=0;
        int caseNum=0, capacity=0;
        String[] input;
        while((currentLine = br.readLine()) != null){
            if(currentIndex==0)
                caseNum = Integer.parseInt(currentLine);
            else if(currentIndex % 2 == 1)
                capacity = Integer.parseInt(currentLine);
            else{
                input = currentLine.split(" ");
                System.out.println("case " + Integer.toString(caseNum));
                printOutput(input, capacity);
            }
            currentIndex++;
        }
    }
    
    private static void printOutput(String[] input, int capacity){
        ArrayStack output = new ArrayStack(capacity);
        for(int i = 0; i < input.length; i++){
            output.push(input[i]);
        }
        while(!output.isEmpty()){
            System.out.print(output.pop()+" ");
        }
        System.out.println();
    }
}
