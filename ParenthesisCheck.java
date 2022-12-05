
import java.util.Stack;
import java.util.Scanner;
//class Stack
//{
  //  private int maxSize; // size of stack array
//   private Character[] stackArray;
//     private int top; // top of stack
//     public Stack(int s) // constructor
//  {
//      maxSize = s; // set array size
//      stackArray = new Character[maxSize]; // create array
//      top = -1; // no items yet
//  }
//     public void push(Character j) // put item on top of stack
//  {
//      stackArray[++top] = j; // increment top, insert item
//  }
//     public Character pop() // take item from top of stack
//     {
//         return stackArray[top--]; // access item, decrement top
//     }
//     public Character peek() // peek at top of stack
//     {
//         return stackArray[top];
//     }
//     public boolean isEmpty() // true if stack is empty
//     {
//         return (top == -1);
//     }
//     public boolean isFull() // true if stack is full
//     {
//         return (top == maxSize-1);
//     }
// }
// end class Stack, this is how we implement stack for this task but for convenience we will use the import


public class ParenthesisCheck {

    public static boolean hasDuplicateParenthesis (String expression) //function to check if the string contains duplicate parenthesis
    {
        Stack<Character> stack = new Stack<>();   //we create an empty stack in which we store characters from the string
        /*
        In the for loop we check each character of the string. If it is not a
        closing ')' parenthesis, the character will be pushed into the stack.
        If it is a closing parenthesis
        we, using a while loop, pop all the characters that have been in the stack so far and check if they are an
        opening parenthesis '('.
        While popping the elements we count all the characters in between,
        if it is 0, there are duplicate parenthesis in an expression.
        */
        int i;
        for (i = 0; i< expression.length(); i++)  // check every character of the expression
        {
            char ch = expression.charAt(i);
            int counter = 0;
            if (ch != ')')  // if it is not a closing ')' parenthesis, the character will be pushed into the stack
            {
                stack.push(ch);
            }
            else
            {
                while(stack.pop() != '(')
                {
                    counter++;               // count all the characters that are not an opening '('
                }
                if(counter == 0)            //if there are duplicate parenthesis the inside parenthesis will be checked first and yield a false
                {                           //all the characters will be removed from the stack, hence, while checking the next
                    return true;            //pair of parenthesis the counter is 0 for a true return. One character inside a parenthesis is considered ok.
                }
            }
        }
        return false;
    }
    public static void clear (String expression) {
        Stack<Character> stack = new Stack<>();
        while( !stack.isEmpty() ) // until it’s empty,
        { // delete item from stack
            System.out.print(stack.pop()); // display it
        } // end while
    }
    public static void lastElement (String expression){
        Stack<Character> stack = new Stack<>();
        char ch = expression.charAt(0); // sets character at stack index 0, hence it returns its bottom element
        System.out.println(ch);
    }




    public static void main (String [] args)
    {
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();



        if (hasDuplicateParenthesis(expression))
        {
            System.out.println("This expression has duplicate parenthesis");
        }
        else
        {
            System.out.println("This expression doesn't have duplicate parenthesis");
        }
        ParenthesisCheck.clear(expression);
        ParenthesisCheck.lastElement(expression);

    }
    }



