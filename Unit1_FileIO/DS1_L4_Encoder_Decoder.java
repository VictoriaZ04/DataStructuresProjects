package Unit1_FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DS1_L4_Encoder_Decoder {
    public static void main(String[] args) throws IOException{
        File keyfolder = new File("Keys");
        if(!keyfolder.exists()){
            keyfolder.mkdir();
        }
        File[] keys = keyfolder.listFiles();
        File encodedfolder = new File("EncodedFiles");
        if(!encodedfolder.exists()){
            encodedfolder.mkdir();
        }
        File[] encoded = encodedfolder.listFiles();
        Scanner sc = new Scanner(System.in);

        int input = -1;
        while(input != 4){
            System.out.println("\n1. Create Key");
            if(keys.length > 0){
                System.out.println("2. Create Encoded File"); 
            }
            if(encoded.length > 0){
                System.out.println("3. Decode File");
            }
            System.out.println("4. Quit");
            System.out.print("Enter Selection: ");

            input = sc.nextInt();

            if(input == 1){
                createKey();
                keys = keyfolder.listFiles();
            }
            else if(input == 2 && keys.length > 0){
                encode(keys);
                encoded = encodedfolder.listFiles();
            }
            else if(input == 3 && encoded.length > 0){
                decode(keys, encoded);
            }
        }

    }

    public static void createKey() throws IOException{
        System.out.print("\nEnter a name for your key file: ");
        File newKey = new File("Keys\\" + new Scanner(System.in).nextLine());
        if(!newKey.exists()){
            newKey.createNewFile();
        }
        FileWriter writer = new FileWriter(newKey,false);
        PrintWriter pwriter = new PrintWriter(writer);
        String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArrayList<Character> bet = new ArrayList<Character>();
        for(char i: alpha.toCharArray()){
            bet.add(i);

        }
        while(bet.size() > 0){
            int x = (int)(Math.random() * (bet.size() - 1));
            pwriter.print(bet.get(x));
            bet.remove(x);
        }
        pwriter.close();
    }

    public static void encode(File[] keys) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("\nSelect a file to encode with:");
        int i = 1;
        for(File file: keys){
            System.out.println(i + ". " + file.getName());
            i++;
        }

        System.out.println("0. Cancel");
        int key = -1;
        do{
            System.out.print("Enter key: ");
            key = sc.nextInt();
        }while(key < 0 || key > keys.length);

        if(key != 0){
            sc.nextLine();
            System.out.print("\nEnter the text you would like to encode: ");
            String message = sc.nextLine();

            System.out.print("\nEnter the name of the file you would like to store this text in: ");
            File saveFile = new File("EncodedFiles\\" + sc.nextLine());
            if(!saveFile.exists()){
                saveFile.createNewFile();
            }        

            FileWriter writer = new FileWriter(saveFile,false);
            PrintWriter pwriter = new PrintWriter(writer);

            String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String code = new Scanner(keys[key - 1]).nextLine();
            for(int j = 0; j < message.length(); j++){
                pwriter.print((alpha.indexOf(message.charAt(j)) == -1)?message.charAt(j):(code.charAt(alpha.indexOf(message.charAt(j)))));
            }
            pwriter.close();
        }

    }

    public static void decode(File[] keys, File[] encoded) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("\nSelect a file to decode:");
        int i = 1;
        for(File file: encoded){
            System.out.println(i + ". " + file.getName());
            i++;
        }
        System.out.println("0. Cancel");
        int enc = -1;
        do{
            System.out.print("Enter file: ");
            enc = sc.nextInt();
        }while(enc < 0 || enc > encoded.length);

        if(enc != 0){

            System.out.println("\nSelect a key to decode with:");
            i = 1;
            for(File file: keys){
                System.out.println(i + ". " + file.getName());
                i++;
            }

            System.out.println("0. Cancel");
            int key = -1;
            do{
                System.out.print("Enter key: ");
                key = sc.nextInt();
            }while(key < 0 || key > keys.length);

            if(key != 0){
                String alpha = new Scanner(keys[key - 1]).nextLine();
                String code = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                String message = new Scanner(encoded[enc - 1]).nextLine();
                for(int j = 0; j < message.length(); j++){
                    System.out.print((alpha.indexOf(message.charAt(j)) == -1)?message.charAt(j):(code.charAt(alpha.indexOf(message.charAt(j)))));
                }
                System.out.println();
            }
        }
}
}
