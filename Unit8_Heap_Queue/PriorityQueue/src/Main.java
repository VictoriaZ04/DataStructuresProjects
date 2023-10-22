import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<Integer>();
        int selection;
        do{
            System.out.print("\n1.Print - Prints all the items in the priority queue\n2.Size - Prints the number of items in the priority queue\n3.Empty - Prints true when the priority queue is empty and false when it is not\n4.Add -Adds an item to the priority queue\n5.Remove - Removes an item from the priority queue and prints its value\n6.Clear - Empties the priority queue\n7.Exit - Closes the program\nEnter Selection: ");
            selection = sc.nextInt();

            if(selection == 1){
                System.out.println(pq.toString());
            } else if(selection == 2){
                System.out.println(pq.size());
            } else if(selection == 3){
                System.out.println(pq.isEmpty());
            } else if(selection == 4){
                System.out.print("Enter the item you would like to add: ");
                int item = sc.nextInt();

                pq.add(item);
            } else if(selection == 5){
                System.out.println(pq.poll());
            }
            else if(selection == 6){
                pq.clear();
            }
        
        }while(selection != 7);
    }
}
