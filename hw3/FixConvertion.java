import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FixConvertion{
    
    public static void main(String[] args) throws IOException{
        String currentLine;
        BufferedReader br = new BufferedReader(new FileReader("in1.txt"));

        while ((currentLine = br.readLine()) != null){
            convertToPrefix(currentLine);
        }
    }

            
    private static void convertToPrefix(String input){
            // start process
            LinkedList<Character> infix= new LinkedList<Character>();
            LinkedList<Character> prefix=new LinkedList<Character>();
        
            for(int i=0;i<input.length();i++){
                //System.out.println(input.charAt(i));
                if(input.charAt(i)!=')') {
                    infix.push(input.charAt(i));
                }
                else{
                    char temp=infix.pop();
                    if(temp!='+' && temp!='-' && temp!='*'
                       && temp!='/' && temp!='^'){
                        char second=temp;
                        char operator=infix.pop();
                        char first=infix.pop();
                        if(first=='('){
                            prefix.push(second);
                            prefix.addToLast(operator);
                        }else{
                            prefix.push(operator);
                            prefix.push(first);
                            prefix.push(second);
                            infix.pop();
                        }
                    }
                    else{
                        prefix.addToLast(temp);
                    }
                }
            }
            prefix.printData(prefix.getHead());
            System.out.println();
    }
}
