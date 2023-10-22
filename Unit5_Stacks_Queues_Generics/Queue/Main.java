import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue queue = new Queue<Integer>();
        int choice = -1;
        while(choice != 8){
            System.out.print(
                "\n-Menu-\n1. Print – Prints all the data in the queue\n2. Offer – Adds an item to the back of the queue\n3. Element – Prints the value of the front item in the queue\n4. Poll – Removes the front item from the queue and prints its value\n5. Size – prints the number of items in the queue\n6. Get – Prints the item in spot X. (X will come from the user)\n7. Empty – Prints true when the queue is empty and false when it is not\n8. Exit – Closes the program\nEnter your selection: ");
            choice = sc.nextInt();
            
            if(choice == 1){

                String print = "";
                for(int i = queue.size() - 1; i >= 0; i--){
                    if(i == queue.size() - 1)
                        print += (Integer)queue.get(i);
                    else
                        print += ", " + queue.get(i);
                }
                System.out.println(print);
            }
            else if(choice == 2){
                System.out.print("\nEnter the number to offer: ");
                queue.offer(sc.nextInt());
            }
            else if(choice == 3){
                System.out.println(queue.element());
            }
            else if(choice == 4){
                System.out.println(queue.poll());
            }
            else if(choice == 5){
                System.out.println(queue.size());
            }
            else if(choice == 6){
                System.out.print("\nEnter the index you would like to get: ");
                int index = sc.nextInt();
                if(queue.get(index) != null)
                    System.out.println(queue.get(index));
                else{
                    System.out.println("\nThat location doesn't exist!");
                }
            }
            else if(choice == 7){
                System.out.println(queue.empty());
            }

        }

    }
}
