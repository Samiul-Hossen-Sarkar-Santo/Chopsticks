import java.util.Scanner;

public class GamePlay{
    Scanner input = new Scanner(System.in);

    void currentState() {
        String[][] view = {
                {"\t\t\t ", "\tL", "\tR"},
                {"\t" + "\t" + Start.player1.name, "\t" + String.valueOf(Start.player1.left), "\t" + String.valueOf(Start.player1.right)},
                {"\t" + "\t" + Start.player2.name, "\t" + String.valueOf(Start.player2.left), "\t" + String.valueOf(Start.player2.right)}
        };

        System.out.println("\nCurrent State: \n");
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                System.out.print(view[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    void mainGame(PlayerInfo giver, PlayerInfo receiver){
        int choice = 0;
        System.out.println("\n" + giver.name + "'s turn...");
        System.out.println(giver.name + ", Do you want to Attack(1) or Split(2): ");
        String userInput = input.nextLine();

        choice = input.hasNextInt() ? input.nextInt() : -1;

        if (choice == -1) {
            System.out.println("Input a number!");
        }else if (choice==1){
            attack(giver, receiver);
        }else if (choice==2){
            System.out.print("\nHow do you want to split?\n\tEnter left: ");
            int choiceLeft = input.nextInt();
            System.out.print("\tEnter Right: ");
            int choiceRight = input.nextInt();

            if(canSplit(giver, choiceLeft, choiceRight)){
                split(giver, choiceLeft, choiceRight);
            }else {
                System.out.println("Sorry! You can't split right now. Attacking is the only option");
                attack(giver, receiver);
            }
        }else {
            System.out.println("Invalid input...");
        }
    }

    private void attack(PlayerInfo giver, PlayerInfo receiver) {
        System.out.println("Do you want to attack with Left(1) hand or right(2) hand: ");
        switch (input.nextInt()) {
            case 1 -> {
                attackToFromLeft(giver, receiver);
            }
            case 2 -> {
                attackToFromRight(giver, receiver);
            }
            default -> System.out.println("Invalid input...");
        }
        currentState();
    }

    void attackToFromRight(PlayerInfo giver, PlayerInfo receiver){
        System.out.print("Do you want to attack to Left(1) hand or right(2) hand: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1 ->{
                int temp = receiver.left;
                receiver.left = receiver.left + giver.right;
                if (receiver.left > 5){
                    receiver.left = temp;
                    System.out.println("\nYou can't attack on this hand");
                    attackToFromRight(giver, receiver);
                }
            }
            case 2 -> {
                int temp = receiver.right;
                receiver.right = receiver.right + giver.right;
                if (receiver.right > 5){
                    receiver.right = temp;
                    System.out.println("\nYou can't attack on this hand");
                    attackToFromRight(giver, receiver);
                }
            }
            default -> System.out.println("Invalid input...");
        }
        if (receiver.left == 5){
            receiver.left = 0;
        }
        if (receiver.right == 5){
            receiver.right = 0;
        }
    }
    void attackToFromLeft(PlayerInfo giver, PlayerInfo receiver){
        System.out.println("Do you want to attack to Left(1) hand or right(2) hand: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1 -> {
                int temp = receiver.left;
                receiver.left = receiver.left + giver.left;
                if (receiver.left > 5){
                    receiver.left = temp;
                    System.out.println("\nYou can't attack on this hand, Try Again...\n");
                    attackToFromLeft(giver, receiver);
                }
            }
            case 2 -> {
                int temp = receiver.right;
                receiver.right = receiver.right + giver.left;
                if (receiver.right > 5){
                    receiver.right = temp;
                    System.out.println("\nYou can't attack on this hand");
                    attackToFromLeft(giver, receiver);
                }
            }
            default -> System.out.println("Invalid input...");
        }
        if (receiver.left == 5){
            receiver.left = 0;
        }
        if (receiver.right == 5){
            receiver.right = 0;
        }
    }

    boolean canAttack(PlayerInfo giver, PlayerInfo receiver){

        if (giver.left == 0){
            if((giver.right+ receiver.left>5 && giver.right+receiver.right>5)){
                return false;
            }
        } else if (giver.right == 0) {
            if((giver.left+receiver.left>5 && giver.left+ receiver.right>5)){
                return false;
            }
        } else if ((giver.left+receiver.left>5 && giver.left+ receiver.right>5) && (giver.right+ receiver.left>5 && giver.right+receiver.right>5)){
            return false;
        }
        return true;
    }

    boolean canSplit(PlayerInfo giver, int choiceLeft, int choiceRight){
        if (((choiceLeft== giver.right) && (choiceRight== giver.left)) && (choiceLeft+choiceRight)==(giver.left+giver.right)){
            return false;
        }
        return true;
    }

    void split(PlayerInfo giver, int choiceLeft, int choiceRight){
        if ((choiceLeft + choiceRight) == (giver.left + giver.right)){
            if (choiceLeft == 5){
                giver.left = 0;
            }else {
                giver.left = choiceLeft;
            }
            if (choiceRight == 5){
                giver.right = 0;
            }else {
                giver.right = choiceRight;
            }
            currentState();
        }else{
            System.out.println("\nInvalid input, Try Again");
            System.out.print("\nHow do you want to split?\n\tEnter left: ");
            int choiceLeftT = input.nextInt();
            System.out.print("\tEnter Right: ");
            int choiceRightR = input.nextInt();
            split(giver, choiceLeftT, choiceRightR);
        }
    }

    boolean declareWinner(PlayerInfo giver, PlayerInfo receiver){
        if (giver.left==0 && giver.right==0 ){
            System.out.println("\n" + receiver.name + " Wins...\n");
            return false;
        }else if (receiver.left==0 && receiver.right==0){
            System.out.println("\n" + giver.name + " Wins...\n");
            return false;
        }else {
            return true;
        }
    }



}
