import java.util.Random;
import java.util.Scanner;

public class Start {
    String name1, name2;
    static PlayerInfo player1, player2;
    Scanner input = new Scanner(System.in);
    static GamePlay gamePlay = new GamePlay();

    void inputUserInfo(){
        System.out.print("Enter the nickname of player 1: ");
        name1 = input.next();
        System.out.print("Enter the nickname of player 2: ");
        name2 = input.next();

        player1 = new PlayerInfo(name1);
        player2 = new PlayerInfo(name2);
    }


    void startingGame(){
        Random random = new Random();
        int rand = random.nextInt(1,3);
        int turn = 0;

        if (rand == 1){
            playerTurn(turn, player1, player2);

        }else {
            playerTurn(turn, player2, player1);

        }
    }

    public void playerTurn(int turn, PlayerInfo player1, PlayerInfo player2) {
        do{
            if (turn%2 == 0){
                if (attackOrSplit(player1, player2)) break;
            }else{
                if (attackOrSplit(player2, player1)) break;
            }
            turn++;
        }while(gamePlay.declareWinner(player1, player2));
    }

    public boolean attackOrSplit(PlayerInfo player1, PlayerInfo player2) {
        if (gamePlay.canAttack(player1, player2)){
            gamePlay.mainGame(player1, player2);
        }else if(!gamePlay.canAttack(player1, player2)){
            System.out.println("Ooops, " + player1.name + "! You can't attack right now. Do you wanna split(1)?");
            int splittingChoice = input.nextInt();
            if (splittingChoice == 1){
                System.out.print("\nHow do you want to split?\n\tEnter left: ");
                int choiceLeft = input.nextInt();
                System.out.print("\tEnter Right: ");
                int choiceRight = input.nextInt();
                if(gamePlay.canSplit(player1, choiceLeft, choiceRight)){
                    gamePlay.split(player1, choiceLeft, choiceRight);
                }else {
                    System.out.println("Looks like, you can't split either :)");
                    System.out.println("So, " + player2.name + " Wins...");
                    return true;
                }
            }

        } else {
            System.out.println(player2.name + " Wins...");
            return true;
        }
        return false;
    }
}
