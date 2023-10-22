import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int selection;
        DoublyCircularLinkedList<String> list = new DoublyCircularLinkedList<String>();
        do {
            System.out.print(
                    "\n1.Print X Forward\n2.Print X Backward\n3.Print First\n4.Print Last\n5.Get X\n6.Remove First\n7.Remove Last\n8.Remove X\n9.Add to First\n10.Add to Last\n11.Insert\n12.Set X\n13.Size\n14.Is Empty\n15.Clear\n16.Exit\nEnter Selection: ");

            selection = sc.nextInt();
            
            if (selection == 1) {
                System.out.print("Enter the amount of numbers you want to see: ");
                int temp = sc.nextInt();
                for (int i = 0; i < temp; i++) {
                    System.out.print(list.get(i) + " ");
                }
            } else if (selection == 2) {
                System.out.print("Enter the amount of numbers you want to see: ");
                int temp = sc.nextInt();

                for (int i = temp + (list.size() - (temp % list.size())); i > (list.size() - (temp % list.size())) ; i--) {
                    System.out.print(list.get(i - 1) + " ");
                }
            } else if (selection == 3) {
                System.out.println(list.getFirst());
            } else if (selection == 4) {
                System.out.println(list.getLast());
            } else if (selection == 5) {
                System.out.print("Enter the index: ");
                System.out.println(list.get(sc.nextInt()));
            } else if (selection == 6) {
                System.out.println(list.removeFirst());
            } else if (selection == 7) {
                System.out.println(list.removeLast());
            } else if (selection == 8) {
                System.out.print("Ender the index: ");
                System.out.println(list.remove(sc.nextInt()));
            } else if (selection == 9) {
                System.out.print("Enter the item: ");
                String temp = sc.nextLine();
                while(temp.equals("")){
                    temp = sc.nextLine();
                }
                list.addFirst(temp);
            } else if (selection == 10) {
                System.out.print("Enter the item: ");
                String temp = sc.nextLine();
                while(temp.equals("")){
                    temp = sc.nextLine();
                }
                list.addLast(temp);
            } else if (selection == 11) {
                System.out.print("Enter the index: ");
                int index = sc.nextInt();
                System.out.print("Enter the item: ");
                String temp = sc.nextLine();
                while(temp.equals("")){
                    temp = sc.nextLine();
                }
                list.add(index, temp);
            } else if (selection == 12) {
                System.out.print("Enter the index: ");
                int index = sc.nextInt();
                System.out.print("Enter the item: ");
                String temp = sc.nextLine();
                while(temp.equals("")){
                    temp = sc.nextLine();
                }
                list.set(index, temp);
            } else if (selection == 13) {
                System.out.println(list.size());
            } else if (selection == 14) {
                System.out.println(list.isEmpty());
            } else if (selection == 15) {
                list.clear();
            }
        } while (selection != 16);

    }

}
