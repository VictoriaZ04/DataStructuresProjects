import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        NSPQ<String> nspq = new NSPQ<String>();
        int selection;
        do{
            System.out.print("\n1.Print - Prints all the items in the NSPQ\n2.Size - Prints the number of items in the NSPQ\n3.Empty - Prints true when the NSPQ is empty and false when it is not\n4.Add -Adds an item to the NSPQ\n5.Remove - Removes an item from the NSPQ and prints its value\n6.Clear - Empties the NSPQ\n7.Exit - Closes the program\nEnter Your Selection: ");
            selection = sc.nextInt();

            if(selection == 1){
                System.out.println(nspq.toString());
            }else if(selection == 2){
                System.out.println("The size is" + nspq.size());
            }else if(selection == 3){
                System.out.println(nspq.empty());
            }else if(selection == 4){
                System.out.print("Enter the item you would like to add: ");
                String item = sc.next();
                System.out.print("Enter the priority: ");
                int priority = sc.nextInt();

                nspq.add(new NSPQ_Node<String>(item, priority));
            }else if(selection == 5){
                System.out.println(nspq.remove().toString());
            }else if(selection == 6){
                nspq.clear();
            }

        }while(selection != 7 );
    }
}
