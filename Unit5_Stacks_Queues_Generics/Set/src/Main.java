import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MySet set = new MySet<Integer>();
        int choice = -1;
        while(choice != 8){
            System.out.print(
                "\n-Menu-\n1.Add – Adds a number to the set (Tells the user if the add was successful or not)\n2.Contains – Allows the user to see if the set contains a number\n3.Remove – Removes a number from the set (Tells the user if the remove was successful or not)\n4.Print – Prints all the numbers contained in the set\n5.Is Empty – Tells the user if the set was empty or not\n6.Clear – Empties the set\n7.Size – Tells the user the number of items in the set\n8.Exit\nEnter your selection: ");
            choice = sc.nextInt();
            
            if(choice == 1){

                System.out.print("\nEnter the number you would like to add: ");
                if(!set.add(sc.nextInt()))
                    System.out.println("The set already has that value!");
            }
            else if(choice == 2){
                System.out.print("\nEnter the number you would like to check: ");
                if(set.contains(sc.nextInt())){
                    System.out.println("Yes! The Set contains this value!");
                }
                else{
                    System.out.println("No! The Set does not contain this value!");
                }
            }
            else if(choice == 3){
                System.out.print("Enter the number you would like to remove!");
                if(set.remove(sc.nextInt()))
                    System.out.println("Done!");
                else{
                    System.out.println("The number doesn't exist in the set!");
                }
            }
            else if(choice == 4){
                for(Object i: set.toArray())
                System.out.print(i + " ");

            }
            else if(choice == 5){
                System.out.println(set.isEmpty());
            }
            else if(choice == 6){
                set.clear();
            }
            else if(choice == 7){
                System.out.println(set.size());
            }

        }

    }
}
