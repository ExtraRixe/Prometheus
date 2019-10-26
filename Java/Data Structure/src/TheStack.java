
import java.util.*;
import java.lang.Character;

public class TheStack {
 private String[] StackArray;
 private int stackSize;
 private int topofStack = -1;
 
     TheStack(int size){     //Constructor
         stackSize = size;
         StackArray = new String[size];
         Arrays.fill(StackArray,"-1");
     }
     
    //Methods or Actions
     
     public void displayStack() {     //shows elements of the stack
                 
          for(int i = 0; i <10; i++){
           System.out.print("| "+StackArray[i]);
     }
          System.out.println();
     }
     public void push(String input){ //add element to a stack
         if (topofStack< stackSize){
             topofStack++;
             StackArray[topofStack]= input;
         }
         else {
             System.out.println("Sorry but the stack is full.");
             displayStack();
             System.out.println("Push " + input + "was added to the stack");
          }
     }
     public String pop(){   //remove element in a stack
         if (topofStack >= 0){
             displayStack();
             System.out.println("Pop " + StackArray[topofStack] + " was remove from the stack.\n");
             StackArray[topofStack] = "-1";
             return StackArray[topofStack--];
        } else
         {
             displayStack();
             System.out.println("Sorry but the stack  is empty");
             return "-1";
            }
     }
     public String peek(){   //top element of a stack
         displayStack();
         System.out.println("Peek " + StackArray[topofStack] + " is at the top of the stack");
         return StackArray[topofStack];
     }

     public void pushMany(String MultipleValues){  //add many elements
         String[] tempString = MultipleValues.split(" ");
         for(int i = 0; i<tempString.length; i++){
             push(tempString[i]);
         }
}
     public void popAll(){  //remove many elements
         for(int i = topofStack; i>=0; i--){
             pop();
         }

     }
     
    public static void main(String[] args) {
       TheStack theStack = new TheStack(5);
      
         theStack.push("1");
         theStack.push("2");
         theStack.push("3");
         theStack.displayStack();
         theStack.peek();
         theStack.pop();
         theStack.displayStack();
         theStack.pushMany("4 5 6 7 8 9 10");
         
         theStack.displayStack();
         theStack.popAll();
         theStack.displayStack();

        }
  }

