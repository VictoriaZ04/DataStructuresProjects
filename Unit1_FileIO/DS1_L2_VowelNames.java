package Unit1_FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DS1_L2_VowelNames {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the File Name: ");
        File file = new File(sc.nextLine());
        try{
            if(!file.exists())
                System.out.println("The file does not exist, bye bye.");
            else{
                sc = new Scanner(file);
                while(sc.hasNextLine()){
                    String temp = sc.nextLine();
                    char c = temp.toLowerCase().charAt(0);
                    if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                        System.out.println(temp);
                    }
                }

            }
            
        }
        catch(IOException e){
            System.out.println(e);
        }
        sc.close();

        
    }
}
