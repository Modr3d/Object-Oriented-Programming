import java.util.*;

public class Problem_2_2 {
    public static void main(String[] args) {
        Scanner userIn = new Scanner(System.in);
        Random rand = new Random();
        String[] type = { "scissor", "rock", "paper" };
        int com = rand.nextInt(3);
        System.out.print("scissor (0), rock (1), paper (2): ");
        int srp = userIn.nextInt();

        if (srp < 0 || srp > 2) {
            System.out.println("Error. Please Enter the correct number ( 0 - 2 )");
            userIn.close();
            return;
        }

        //if (srp >= 0 && srp <= 2) {
            System.out.print("The computer is " + type[com] + ". ");
            System.out.print("You are " + type[srp]);
            if (com == srp)
                System.out.print(" too. It is a draw");
            else if ((com == 0 && srp == 1) || (com == 1 && srp == 2) || (com == 2 && srp == 0))
                System.out.print(". You won");
            else
                System.out.print(". You lost");
        /*} else
            System.out.print("Your input is wrong.");*/
        userIn.close();
    }
}
