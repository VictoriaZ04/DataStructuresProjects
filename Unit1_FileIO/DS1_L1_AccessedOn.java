package Unit1_FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class DS1_L1_AccessedOn {
    public static void main(String[] args){
        File file = new File("AccessedOn.txt");

        try{
            if(!file.exists())
                file.createNewFile();
            FileWriter writer = new FileWriter(file,true);
            PrintWriter pwriter = new PrintWriter(writer);
            pwriter.println(new Date());
            pwriter.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
        
        
    }
}
