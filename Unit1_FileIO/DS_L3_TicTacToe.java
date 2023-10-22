package Unit1_FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class DS_L3_TicTacToe {
    public static void main(String[] args){
        File file = new File("tic_tac_toe_save.txt");
        String [] board = {" | | ", " | | ", " | | "};
        int player = 1;
        Scanner sc;

        if(file.exists()){
            try{
                sc = new Scanner(file);
                board[0] = sc.nextLine();
                board[1] = sc.nextLine();
                board[2] = sc.nextLine();
                player = sc.nextInt();
                System.out.println("\n" + board[0] + "\n======\n" + board[1] + "\n======\n" + board[2] + "\n");
                sc.close();;
                

            }
            catch(FileNotFoundException e){
                System.out.println(e);
            }

            System.out.println("Saved Game Loaded");
        }

        boolean exit = false;
        while(won(board) == 0 && !exit){
            int row, column;

            if(player > 0){
                sc = new Scanner(System.in);

                String input;
                do{
                    System.out.print("Would you like to Save Game (s) or Keep Playing (p) : ");
                    input = sc.next();
                }while(!input.equals("s") && !input.equals("p"));
                exit = (input.equals("s"))?true:false;
                if(exit){
                    try{
                        if(!file.exists())
                            file.createNewFile();
                        FileWriter writer = new FileWriter(file);
                        PrintWriter pwriter = new PrintWriter(writer);
                        pwriter.println(board[0]);
                        pwriter.println(board[1]);
                        pwriter.println(board[2]);
                        pwriter.println(player);
                        
                        pwriter.close();
                    }
                    catch(IOException e){
                        System.out.println(e);
                    }
                    break;
                }
                
                boolean error = false;
                do{
                    if(error)
                        System.out.println("\nInvalid Input. Please Try Again\n");
                    System.out.print("Enter the Row # (0 - 2): ");
                    row = sc.nextInt();
                    System.out.print("Enter the Column # (0 - 2): ");
                    column = sc.nextInt();
                    error = true;
                }while(!isEmpty(row, column, board));
                board = newTurn(board, player, row, column);
            }
            else{
                do{
                    row = (int)(Math.random() * 3);
                    column = (int)(Math.random() * 3);
                }while(!isEmpty(row, column,board));
                board = newTurn(board, player, row, column);
                System.out.println("\nThe Computer Went In Row " + row + ", Column " + column + ".");
            }

            System.out.println("\n" + board[0] + "\n======\n" + board[1] + "\n======\n" + board[2] + "\n");
            player *= -1;
        }

        if(exit)
            System.out.println("Saved! Bye Bye.");
        else{
            System.out.println("The " + ((won(board) == 1)?"Player":"Computer") + " Won!");
            if(file.exists()){
                file.delete();
            }
        }

    }
    public static boolean spacesLeft(String[] board)
    {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j += 2){
                if(board[i].charAt(j) == ' '){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isEmpty(int row, int column, String[] board){
        return board[row].charAt(column * 2) == ' ';
    }

    public static String[] newTurn(String[] board, int player, int row, int column){
        board[row] = board[row].substring(0, column * 2) + ((player > 0)?"X":"O") + board[row].substring(column * 2 + 1);
        return board;
    }

    public static int won(String[] board){
        char [][] b = {board[0].toCharArray(), board[1].toCharArray(), board[2].toCharArray()};
        for(int i = 0; i < 3; i++){
            if(b[i][0] == b[i][2] && b[i][0] == b[i][4] && b[i][0] != ' '){
                return ((b[i][0] == 'X')?1:-1);
            }
            if(b[0][i] == b[1][i * 2] && b[1][i * 2] == b[2][i * 2] && b[2][i * 2] != ' '){
                return ((b[i][0] == 'X')?1:-1);
            }
        }
        if(b[0][0] == b[1][2] && b[1][2] == b[2][4] && b[2][4] != ' '){
            return ((b[0][0] == 'X')?1:-1);
        }
        if(b[0][4] == b[1][2] && b[1][2] == b[2][0] && b[2][0] != ' '){
            return ((b[0][4] == 'X')?1:-1);
        }
        return 0;
    }
    
}
