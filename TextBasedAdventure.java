import java.util.Scanner;

public class TextBasedAdventure {
    boolean hasSword = false;
    boolean hasPotion = false;
    Scanner keyboardInput = new Scanner(System.in);

    public void execute() {
        System.out.println("Welcome to Escape from the Cave! Press enter when you are ready to start...");
        keyboardInput.nextLine();
        System.out.println("You are trapped in a cave!");
        start();
    }

    public void start() {
        System.out.println("You find yourself in a large room. What would you like to do?\n1. Go left \n2. Go right");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            goLeft();
        }
        else if (input == 2) {
            goRight();
        }
    }

    public void goLeft() {
        System.out.println("Oh no! You run into a giant! Fight or flight?\n1. Fight \n2. Flight");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            fight();
        }
        else if (input == 2) {
            start();
        }  
    }

    public void goRight() {
        if (!hasSword) {
            System.out.println("You find a sword on the ground!");
            hasSword = true;
        }else if(hasSword && !hasPotion){
            System.out.println("You have found a wizard, he has given you a magic potion!");
            hasPotion = true;
        }
        else {
            System.out.println("There's nothing here...");
        }
        start();
    }



    public void fight() {

        if(hasSword && hasPotion){
            System.out.println("Would you like to use your potion or sword?\n1. Sword \n2. Potion");
            int selection = keyboardInput.nextInt();

            if(selection == 1){
                System.out.println("You defeat the giant with your sword and run out of the cave!");
            }else{
                System.out.println("You give the giant the potion, he falls asleep, and you run out of the cave!");
            }

        }else if(hasSword && !hasPotion){
            System.out.println("You defeat the giant with your sword and run out of the cave!");
        } else if(hasPotion && !hasSword){
            System.out.println("You give the giant the potion, he falls asleep, and you run out of the cave!");
        }else {
            System.out.println("You get stomped by the giant and red stuff goes everywhere.");
        }
    }

    public static void main(String[] args) {
        new TextBasedAdventure().execute();
    }
}