import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack<Integer>();
        int choice = -1;
        while(choice != 8){
            System.out.print(
            "\nPick a choice:\n1. Print – Prints all the items on the stack\n2. Size – Prints the number of items on the stack\n3. Empty – Prints true when the stack is empty and false when it is not\n4. Get – Prints the item in spot X of the stack. (X is provided by the user)\n5. Push – Adds an item to the top of the stack\n6. Peek – Prints the value of the top item in the stack\n7. Pop – Removes the top item from the stack and prints its value\n8. Exit – Closes the program\nEnter Selection: ");
            choice = sc.nextInt();
            
            if(choice == 1){
                String print = "";
                for(int i = 0; i < stack.size(); i++){
                    if(i == 0)
                        print += (Integer)stack.get(i);
                    else
                        print += ", " + stack.get(i);
                }
                System.out.println(print);
            }
            else if(choice == 2){
                System.out.println(stack.size());
            }
            else if(choice == 3){
                System.out.println(stack.empty());
            }
            else if(choice == 4){
                System.out.print("\nWhich location to you want to get: ");
                int x = sc.nextInt();

                if(stack.get(x) != null)
                    System.out.println(stack.get(x));
                else{
                    System.out.println("That location doesn't exist!");
                }
            }
            else if(choice == 5){
                System.out.print("\nWhat would you like to push?: ");
                int var;
                var = sc.nextInt();
                stack.push(var);
            }
            else if(choice == 6){

                if(stack.peek() != null)
                    System.out.println(stack.peek());
                else{
                    System.out.println("That location doesn't exist!");
                }
            }
            else if(choice == 7){
                
                if(stack.peek() != null)
                    System.out.println(stack.pop());
                else{
                    System.out.println("That location doesn't exist!");
                }
            }

        }

    }
}
