import java.util.Scanner;
import java.util.InputMismatchException;
public class Player
{
    Scanner move = new Scanner(System.in);
    private String name;
    private char color;
    
    public Player(String name, char color) {
        this.name = name;
        this.color = color;
    }

    public char getColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public int getMove() {
        while (true){
            try {
                int col = move.nextInt() - 1;
                return col;
            } catch (InputMismatchException error) {
                System.out.println("Please choose a column");
                move.next();
            } 
        }
    }

    public String toString() {
        if (this.color == Constants.P1_COLOR) {
            return this.getName() + " (Yellow)";
        } else if (this.color == Constants.P2_COLOR) {
            return this.getName() + " (Red)";
        }
        return this.getName() + " (???)";
    }
}