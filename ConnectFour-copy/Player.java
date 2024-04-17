import java.util.Scanner;
public class Player
{
    Scanner input = new Scanner(System.in);
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
        int col = input.nextInt(); 
        return col;
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
