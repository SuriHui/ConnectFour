import java.util.Scanner;
public class ConnectFour
{
    static Scanner scr = new Scanner(System.in);
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    static char[][] board = new char[Constants.BOARD_HEIGHT][Constants.BOARD_LENGTH];

    //https://codereview.stackexchange.com/questions/100917/connect-four-game-in-java (use as reference)
    public void main(String arg[]) {
        ConnectFour eventLoop = new ConnectFour();
        eventLoop.run();
    }

    public void run() {
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
            if (shouldContinue) {
                
            }
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
    
    //https://stackoverflow.com/questions/46854093/switch-players-in-a-java-game
    public String turns() {
        
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
}
