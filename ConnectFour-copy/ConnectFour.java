import java.util.Scanner;
import java.util.InputMismatchException;
public class ConnectFour
{
    static Scanner scr = new Scanner(System.in);
    private Player p1;
    private Player p2;
    static char[][] board = new char[Constants.BOARD_HEIGHT][Constants.BOARD_LENGTH];

    //https://codereview.stackexchange.com/questions/100917/connect-four-game-in-java (use as reference)
    public void main(String arg[]) {
        ConnectFour eventLoop = new ConnectFour();
        eventLoop.run();
    }

    public void run() {
        makeBoard();
        System.out.println("Welcome to Connect Four!");
        boolean shouldContinue = true;
        while (shouldContinue == true) {
            System.out.println("Who is PLayer 1?");
            String p1 = scr.next();
            Player player1 = new Player(p1, Constants.P1_COLOR);
            System.out.println("Player 1: " + player1.toString());
            System.out.println("\nPlayer 2?");
            String p2 = scr.next();
            Player player2 = new Player(p2, Constants.P2_COLOR);
            System.out.println("Player 2: " + player2.toString());
            System.out.println("Select 1-6 to choose what column you want");
            printBoard();
        }
        System.out.println("\nThank you for playing Connect Four!");
    }

    public static void makeBoard() {
        for (int row = 0; row < Constants.BOARD_HEIGHT; row++) {
            for (int col = 0; col < Constants.BOARD_LENGTH; col++) {
                board[row][col] = Constants.EMPTY;
            }
        }
    }
    
    public int getBoard(int row, int col) {
        return this.board[row][col];
    }

    public void printBoard() {
        for (int row = 0; row < Constants.BOARD_HEIGHT; row++) {
            for (int col = 0; col < Constants.BOARD_LENGTH; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }
    
    //https://stackoverflow.com/questions/32770321/connect-4-check-for-a-win-algorithm 
    public boolean isWin() {
        
    }
    
    //My teacher's base code
     public boolean isTie() {
        for (int row=0; row<Constants.BOARD_HEIGHT; row++) {
            for (int col=0; col<Constants.BOARD_LENGTH; col++) {
                if (getBoard(row,col) == Constants.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    } 
    
    //teacher's code base
    public boolean isLegalMove(int row, int col) {
        if (1 <= col && col <= Constants.BOARD_LENGTH &&
            getBoard(row-1, col- 1) == Constants.EMPTY) {
            return true;
        } else {
            System.out.println("Invalid column");
            return false;
        } 
    }
    
    //teachers base code
    public String getROrY(int whoseMove) {
        if (whoseMove == -1) {
            return "R";
        } else if (whoseMove == 1) {
            return "Y";
        } else {
            return " ";
        }
    }
    
    //teachers base code
    public int getMoveCol (int whoseMove) {
        int col = 0;
        while (true) {
            System.out.printf(getROrY(whoseMove));
            try {
                col= scr.nextInt();
                if (col < 1 || col > Constants.BOARD_LENGTH) {
                    System.out.println("Invalid Column");
                    System.out.println();
                    scr.nextLine();
                }
                else {
                    return col;
                }
            } catch (InputMismatchException error) {
                System.out.println("Invalid Column");
                System.out.println();
                scr.next();
            }
        }   
    }
    
}
