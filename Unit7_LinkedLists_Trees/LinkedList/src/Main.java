import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<String>();
        int selection;
        do{
            System.out.print("\n1.Size\n2.Print\n3.Print First\n4.Print Last\n5.Get Location\n6.Remove Frist\n7.Remove last\n8.Remove X\n9.Add to first\n10.Add to last\n11.Insert\n12.Set X\n13.Is Empty\n14.Clear\n15.Exit\nEnter Selection: ");
            selection = sc.nextInt();

            if(selection == 1){
                System.out.println(list.size());
            }
            else if(selection == 2){
                System.out.println(list.toString());
            }
            else if(selection == 3){
                System.out.println(list.getFirst());
            }
            else if(selection == 4){
                System.out.println(list.getLast());
            }
            else if(selection == 5){
                System.out.print("\nEnter the Location: ");
                System.out.println(list.get(sc.nextInt()));
            }
            else if(selection == 6){
                System.out.println(list.removeFirst());
            }
            else if(selection == 7){
                System.out.println(list.removeLast());
            }
            else if(selection == 8){
                System.out.print("\nEnter the Location: ");
                System.out.println(list.remove(sc.nextInt()));
            }
            else if(selection == 9){
                System.out.print("\nEnter Value: ");
                String temp = sc.nextLine();
                while(temp.equals("")){
                    temp = sc.nextLine();
                }
                list.addFirst(temp);
            }
            else if(selection == 10){
                System.out.print("\nEnter Value: ");
                String temp = sc.nextLine();
                while(temp.equals("")){
                    temp = sc.nextLine();
                }
                list.addLast(temp);
            }
            else if(selection == 11){
                System.out.print("\nEnter the location: ");
                int loc = sc.nextInt();
                System.out.print("\nEnter Value: ");
                String temp = sc.nextLine();
                while(temp.equals("")){
                    temp = sc.nextLine();
                }
                list.add(loc, temp);                
            }
            else if(selection == 12){
                System.out.print("\nEnter the location: ");
                int loc = sc.nextInt();
                System.out.print("\nEnter Value: ");
                String temp = sc.nextLine();
                while(temp.equals("")){
                    temp = sc.nextLine();
                }
                list.set(loc, temp);
            }
            else if(selection == 13){
                System.out.println(list.isEmpty());
            }
            else if(selection == 14){
                list.clear();
            }
            else if(selection == 16){
                System.out.println(list.getFirstNode() + " " + list.getFirstNode().getData());
            }
            else if(selection == 17){
                System.out.println(list.getLastNode() + " " + list.getLastNode().getData());
            }

        }while(selection != 15);
    }
}
