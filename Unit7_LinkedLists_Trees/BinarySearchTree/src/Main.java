import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int selection;
        BST<Integer> tree = new BST<Integer>();
        do {
            System.out.print(
                    "\n1.Print\n2.Size - Returns the number of items in the tree\n3.Clear - Empties the tree\n4.Empty - Tell you if the tree is empty of not\n5.Insert - Attempts to add a value, and lets you know if the add was successful or not\n6.Contains - Lets you know if the item is in the tree or not.\n7.Remove - Removes an item from the tree\n8.Minimum Value - Prints the smallest value in the tree\n9.Maximum Value - Prints the largest vale in the tree\n10.Maximum Depth - Prints the depth of the deepest item in the tree.\n11.Exit - Closes the program\nEnter your selection: ");

            selection = sc.nextInt();
            
            if(selection == 1){
                System.out.print("\n1.Pre-Order\n2.In-Order\n3.Post-Order\nEnter the print type: ");
                int secondSelection = sc.nextInt();
                if(secondSelection == 1)
                    System.out.println(tree.preOrder());
                else if(secondSelection == 2)
                    System.out.println(tree.inOrder());
                else if(secondSelection == 3)
                    System.out.println(tree.postOrder());
            } else if(selection == 2){
                System.out.println(tree.size());
            } else if(selection == 3){
                tree.clear();
            } else if(selection == 4){
                System.out.println(tree.isEmpty());
            } else if(selection == 5){
                System.out.print("Enter the value: ");

                System.out.println(tree.add(sc.nextInt()));
            } else if(selection == 6){
                System.out.print("Enter the value: ");
                System.out.println(tree.contains(sc.nextInt()));
            } else if(selection == 7){
                System.out.print("Enter the value: ");
                tree.remove(sc.nextInt());
            } else if(selection == 8){
                System.out.println(tree.minValue());
            } else if(selection == 9){
                System.out.println(tree.maxValue());
            } else if(selection == 10){
                System.out.println(tree.maxDepth());
            } 
        } while (selection != 11);

    }

}
