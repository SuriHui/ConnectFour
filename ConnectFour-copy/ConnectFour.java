import java.util.Scanner;
import java.util.InputMismatchException;

public class ConnectFour
{
    static Scanner scr = new Scanner(System.in);
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    static char[][] board = new char[Constants.BOARD_HEIGHT][Constants.BOARD_LENGTH];
    
    public static void main(String[] args) {
        System.out.println("Welcome to Connect Four!");
        System.out.println("Please enter your names: ");

        String p1 = scr.next();
        String p2 = scr.next();

        Player player1 = new Player(p1, Constants.P1_COLOR);
        Player player2 = new Player(p2, Constants.P2_COLOR);

        ConnectFour eventLoop = new ConnectFour(player1, player2);
        eventLoop.run();
    }
    
    public ConnectFour(Player player1, Player player2) {
        makeBoard();
        this.player2 = player2;
        this.player1 = player1;
        this.currentPlayer = player1;
    }

    public void run() {
        boolean shouldContinue = true;
        this.currentPlayer = player1;
        while (shouldContinue == true) {
            printBoard();
            System.out.println("\nSelect 0-6 to choose what column you want");
            if (printMove(currentPlayer.getMove())) {
                if (isWin()) {
                    printBoard();
                    System.out.println("Player " + currentPlayer.toString() + " wins!");
                    shouldContinue = false;
                } else if (isTie()) {
                    printBoard();
                    System.out.println("It's a tie!");
                    shouldContinue = false;
                } else {
                    switchPlayer();   
                }
            }
        }
        System.out.println("Thank you for playing Connect Four!");
    }

    public static void makeBoard() {
        for (int row = 0; row < Constants.BOARD_HEIGHT; row++) {
            for (int col = 0; col < Constants.BOARD_LENGTH; col++) {
                board[row][col] = Constants.EMPTY;
            }
        }
    }

    public void printBoard() {
        for (int row = 0; row < Constants.BOARD_HEIGHT; row++) {
            for (int col = 0; col < Constants.BOARD_LENGTH; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    //https://stackoverflow.com/questions/32770321/connect-4-check-for-a-win-algorithm 
    public boolean isWin() {
        int count = 0;
        //horizontal check
        for (int row = 0; row < Constants.BOARD_HEIGHT-1; row++) {
            for (int col=0;col<Constants.BOARD_LENGTH-1;col++) {
                if (board[row][col] == currentPlayer.getMove()) {
                    count++;
                } else {
                    count = 0;
                }
                if (count >= 4) {
                    return true;
                }
            }
        }

        //vertical check
        for (int row = 0; row < Constants.BOARD_HEIGHT-1; row++) {
            for (int col =0; col < Constants.BOARD_LENGTH-1; col++) {
                if (board[row][col] == currentPlayer.getMove()) {
                    count++;
                } else {
                    count = 0; 
                }
                if (count >= 4) { 
                    return true;
                }
            }
        }
        
        // diagonal check
        for (int row = Constants.BOARD_HEIGHT - 1; row >= 3; row--) {
            for (int col = 0; col <= Constants.BOARD_LENGTH - 4; col++) {
                if (board[row][col] == currentPlayer.getColor() &&
                board[row - 1][col + 1] == currentPlayer.getColor() &&
                board[row - 2][col + 2] == currentPlayer.getColor() &&
                board[row - 3][col + 3] == currentPlayer.getColor()) {
                    return true;
                }
            }
        }

        // Check diagonal from top left to bottom right
        for (int row = 0; row <= Constants.BOARD_HEIGHT - 4; row++) {
            for (int col = 0; col <= Constants.BOARD_LENGTH- 4; col++) {
                if (board[row][col] == currentPlayer.getColor() &&
                board[row + 1][col + 1] == currentPlayer.getColor() &&
                board[row + 2][col + 2] == currentPlayer.getColor() &&
                board[row + 3][col + 3] == currentPlayer.getColor()) {
                    return true;
                }
            }
        }
        if (count >= 4) 
            return true;   
        return false;
    }

    //My teacher's base code
    public boolean isTie() {
        for (int row=0; row<Constants.BOARD_HEIGHT; row++) {
            for (int col=0; col<Constants.BOARD_LENGTH; col++) {
                if (board[row][col] == Constants.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    } 

    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public void getTurn() {
        if (currentPlayer == player1) {
            System.out.println(player1.toString()+ "'s turn");
        } else if (currentPlayer == player2) {
            System.out.println(player2.toString() + "'s turn");
        }
        System.out.println();
    }

    public boolean printMove(int col) {
        //if legalmove
        if (col < 0 || col >= Constants.BOARD_LENGTH || board[0][col] != Constants.EMPTY) {
                System.out.println("Please choose a valid move");
                return false;
        }
        for (int row = Constants.BOARD_HEIGHT-1; row >= 0; row--) {
            if (board[row][col] == Constants.EMPTY) {
                board[row][col] = currentPlayer.getColor();
                printBoard();
                return true;
            }
        }
        return false;
    }
}