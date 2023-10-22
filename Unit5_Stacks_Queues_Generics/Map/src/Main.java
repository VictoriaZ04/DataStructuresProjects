import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MyMap map = new MyMap<Integer,String>();
        int choice = -1;
        while(choice != 10){
            System.out.print(
                "\n-Menu-\n1. Clear\n2. Contains Key\n3. Contains Value\n4. Get\n5. Put\n6. Remove\n7. Size\n8. Print\n9. Is Empty\n10. Exit\nEnter your selection: ");
            choice = sc.nextInt();
            
            if(choice == 1){
                map.clear();
            }
            else if(choice == 2){
                System.out.print("Enter Key: ");
                
                System.out.println("The map does " + ((map.containsKey(sc.nextInt()))?"":"not ") + "contain that key");
            }
            else if(choice == 3){
                System.out.print("Enter Value: ");
                String value = sc.nextLine();
                while(value.equals(""))
                    value = sc.nextLine();
                System.out.println("The map does " + ((map.containsValue(value))?"":"not ") + "contain that value");
            }
            else if(choice == 4){
                System.out.print("Enter the Key: ");
                int key = sc.nextInt();
                if(map.get(key) == null)
                    System.out.println("Key not found");
                else
                    System.out.println("The Value is: " + map.get(key));
                
            }
            else if(choice == 5){
                System.out.print("Enter the Key: ");
                int key = sc.nextInt();
                System.out.print("\nEnter the Value: ");
                String value = sc.nextLine();
                while(value.equals("")){
                    value = sc.nextLine();
                }

                String x = (String) map.put(key, value);
                if(x != null){
                    System.out.println(x + " was replaced by " + value);
                }
            }
            else if(choice == 6){
                System.out.print("Enter the Key: ");
                int key = sc.nextInt();

                System.out.println("Removed " + map.remove(key));
            }
            else if(choice == 7){
                System.out.println("The Size is: " + map.size());
                
            }
            else if(choice == 8){
                SetInterface set = map.keySet();
                for(int i = 0; i < map.size(); i++){
                    System.out.println(set.toArray()[i] + " : " + map.get(set.toArray()[i]));
                }
                
            }
            else if(choice == 9){
                System.out.println(map.isEmpty());
            }
            
            
        }

    }
}
