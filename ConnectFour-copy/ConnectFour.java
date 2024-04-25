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
        System.out.println(player1.toString() + " and " + player2.toString() + " are playing together!");
        while (shouldContinue) {
            printBoard();
            System.out.println(currentPlayer.toString() + " Please select a column through 1-7");
            if (printMove(currentPlayer.getMove())) {
                if (checkHorizontalVertical() || checkDiagonal()) {
                    printBoard();
                    System.out.println("Player " + currentPlayer.toString() + " wins! Yippe!");
                    shouldContinue = false;
                } else if (isTie(board)) {
                    printBoard();
                    System.out.println("Oh...It's a tie!");
                    shouldContinue = false;
                } else {
                    player1Turn();   
                }
            }
        }
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
    
    public void player1Turn() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean printMove(int col) {
        //if legalmove
        if (col < 0 || col >= Constants.BOARD_LENGTH || board[0][col] != Constants.EMPTY) {
            System.out.println("Please choose a valid column");
            return false;
        }

        for (int row = Constants.BOARD_HEIGHT-1; row >= 0; row--) {
            if (board[row][col] == Constants.EMPTY) {
                board[row][col] = currentPlayer.getColor();
                return true;
            }
        }
        return false;
    }
    
    //friend's code base
    public boolean checkHorizontalVertical(){
        int hCounter = 0;
        int vCounter = 0;
        //goes through board vertically
        for (int col = 0; col < Constants.BOARD_LENGTH - 1; col++) {
            for (int row = 0; row <= Constants.BOARD_HEIGHT - 1; row++) {
                if (board[row][col] == currentPlayer.getColor()){
                    vCounter++;
                } else {
                    vCounter = 0;
                }
                
                if (vCounter == 4) {
                    return true;
                }
            }
        }

        for(int row = Constants.BOARD_HEIGHT-1; row >= 0; row --){
            for(int col = 0; col < Constants.BOARD_LENGTH-1; col ++){
                if(board[row][col] == currentPlayer.getColor()){ 
                    hCounter++;
                }else{
                    hCounter = 0;
                }

                if(hCounter == 4){
                    return true;
                }
            }
        }
        return false;
    }
    
    //friend's code base
    public boolean checkDiagonal() {
        //Checks diagonal from bottom left to Top Right
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
            for (int col = 0; col <= Constants.BOARD_LENGTH - 4; col++) {
                if (board[row][col] == currentPlayer.getColor() &&
                board[row + 1][col + 1] == currentPlayer.getColor() &&
                board[row + 2][col + 2] == currentPlayer.getColor() &&
                board[row + 3][col + 3] == currentPlayer.getColor()) {
                    return true;
                }
            }
        }

        return false;
    }

    //My teacher's base code
    public boolean isTie(char[][] board) {
        for (int row=0; row<Constants.BOARD_HEIGHT; row++) {
            for (int col=0; col<Constants.BOARD_LENGTH; col++) {
                if (board[row][col] == Constants.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    } 
}
