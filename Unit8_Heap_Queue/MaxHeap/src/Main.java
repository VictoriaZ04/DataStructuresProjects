import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        MaxHeap<Integer> heap = new MaxHeap<Integer>();

        int selection;

        do{
            System.out.print("\n1. Print - Prints all the items in the heap\n2. Size - Prints the number of items in the heap\n3. Empty - Prints true when the heap is empty and false when it is not\n4. Add -Adds an item to the heap\n5. Remove - Removes an item from the heap and prints its value\n6. Clear - Empties the heap\n7. Exit - Closes the program\nEnter Selection: ");
            selection = sc.nextInt();
            if(selection == 1){
                System.out.println(heap.toString());
            }else if(selection == 2){
                System.out.println("The size is " + heap.size());
            }else if(selection == 3){
                System.out.println(heap.isEmpty());
            }else if(selection == 4){
                System.out.print("Enter the Value: ");
                heap.add(sc.nextInt());
            }else if(selection == 5){
                System.out.println(heap.remove());
            }else if(selection == 6){
                heap.clear();
            }
        }while(selection != 7);
    }
    
}
