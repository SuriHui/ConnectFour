import java.util.Scanner;
public class ConnectFour
{
    static Scanner scr = new Scanner(System.in);
    private Player p1;
    private Player p2;
    static char[][] board = new char[Constants.BOARD_HEIGHT][Constants.BOARD_LENGTH];
    
    public ConnectFour() {
        makeBoard();
        printBoard();
        
    }
    
    public static void main(String arg[]) {
        System.out.println("Who is PLayer 1?");
        String p1 = scr.next();
        Player player1 = new Player(p1, Constants.P1_COLOR);
        System.out.println("Player 1: " + player1.toString());
        System.out.println("\nPlayer 2?");
        String p2 = scr.next();
        Player player2 = new Player(p2, Constants.P2_COLOR);
        System.out.println("Player 2: " + player2.toString());
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
}
