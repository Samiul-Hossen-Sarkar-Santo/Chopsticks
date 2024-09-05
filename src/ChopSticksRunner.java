import java.util.Scanner;

public class ChopSticksRunner {
    public static void main(String[] args) {
        boolean mainMenuChoiceLoop = true;
        Start start = new Start();
        GamePlay gamePlay = new GamePlay();
        RulesReader rulesReader = new RulesReader();
        while (mainMenuChoiceLoop){
            System.out.println("""
                \nWelcome to ChopSticks...
                
                  1. Start
                  2. Rules
                  3. Exit
                """);

            Scanner input = new Scanner(System.in);

            int mainMenuChoice = input.nextInt();

            if(mainMenuChoice == 1){
                start.inputUserInfo();
                gamePlay.currentState();
                start.startingGame();
                System.out.println("""
                Do you want to play again?
                  Type: 1, for "YES" or Type: 2, for "NO"
                """);
                if (input.nextInt()==2){
                    mainMenuChoiceLoop = false;
                    System.out.println("Thank you for playing ChopSticks. See you next time ^.^");
                }
            } else if (mainMenuChoice == 2) {
                rulesReader.readRules();
            } else if (mainMenuChoice == 3) {
                mainMenuChoiceLoop = false;
                System.out.println("\nThank you for playing ChopSticks. See you next time ^.^");
            }else{
                System.out.println("Invalid choice. Try again...\n");
            }
        }
    }
}
