package src;

public class MatchGame {
    public final int LIMBO = 0;
    public final int PLAYER_ONE = 1;
    public final int PLAYER_TWO = 2;
    public final int ROWS = 9;
    public final int COLS = 6;

    public MySet<Integer> player1 = new MySet<Integer>();
    public MySet<Integer> player2 = new MySet<Integer>();
    public Card[][] board = new Card[ROWS][COLS];
    public int status;
    public int flipped = 0;

    public MatchGame() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = new Card(-1);
            }
        }
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 13; i++) {
                int row = (int) (Math.random() * ROWS);
                int col = (int) (Math.random() * COLS);

                if (board[row][col].getCard() == -1 && !(col == 0 && (row == 0 || row == 8))) {
                    board[row][col].setCard(i);
                } else {
                    i--;

                }
            }
        }
        status = PLAYER_ONE;
        for(int i = 0; i < COLS; i++){
            for(int j = 0; j < ROWS; j++){
                if(board[j][i].getCard() == -1){
                    System.out.print("  ");
                }else{
                    System.out.print(board[j][i].getCard() + 1 + " ");
                }

            }
            System.out.println();

        }
    }

    public Card getItem(int row, int col) {
        return board[row][col];
    }

    public void playerTurn(int row, int col) {
        if (status != LIMBO && row < 9 && row > -1 && col < 6 && col > -1) {
            if (board[row][col].exists() && !board[row][col].getFlipped()) {
                board[row][col].setFlipped(true);
                flipped++;
            }
        }
    }

    public void unflip() {
        int row = -1;
        int col = -1;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c].getFlipped()) {
                    if (row == -1) {
                        row = r;
                        col = c;
                    } else {
                        if ((r != row || c != col) && board[r][c].getCard() == board[row][col].getCard()) {
                            if (status == PLAYER_ONE && player1.add(board[r][c].getCard())) {
                                player1.add(board[r][c].getCard());

                                board[r][c].setExists(false);
                                board[row][col].setExists(false);

                                status = PLAYER_TWO;
                            } else if (status == PLAYER_TWO && player2.add(board[r][c].getCard())) {
                                player2.add(board[r][c].getCard());

                                board[r][c].setExists(false);
                                board[row][col].setExists(false);

                                
                                    status = PLAYER_ONE;

                            }

                            
                        }
                    }
                    board[r][c].setFlipped(false);

                }

                
            }
        }
        if (status == PLAYER_ONE) {
            status = PLAYER_TWO;
        } else if (status == PLAYER_TWO) {
            status = PLAYER_ONE;
        }
        flipped = 0;
    }

    public int getStatus() {
        return status;
    }

    public MySet getPlayer1() {
        return player1;
    }

    public MySet getPlayer2() {
        return player2;
    }

    public Card[][] getBoard() {
        return board;
    }

    public int checkWin() {
        if (player1.size() == 13) {
            status = LIMBO;
            return 1;
        } else if (player2.size() == 13) {
            status = LIMBO;
            return 2;
        }
        return 0;
    }

}
