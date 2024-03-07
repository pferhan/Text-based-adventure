import java.util.Scanner;
import java.util.Random;

public class TextBasedAdventure {
    boolean hasGiantTranslotor;
    boolean hasSword = false;
    boolean hasCheese = false;
    Scanner keyboardInput = new Scanner(System.in);

    Random rand = new Random();
    int choice = rand.nextInt(2)+1;

    public void execute() {
        System.out.println("Welcome to Escape from the Cave! Press enter when you are ready to start...");
        keyboardInput.nextLine();
        System.out.println("You are trapped in a cave!");
        start();
    }

    public void start() {
        System.out.println("You find yourself in a large room. What would you like to do?\n1. Go left \n2. Go right \n3. Go straight");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            goLeft();
        }
        else if (input == 2) {
            goRight();
        } else if (input == 3) {
            goStraight();
        }
    }

    public void goLeft() {
        System.out.println("Oh no! You run into a giant! Fight or flight?\n1. Fight \n2. Flight \n3. Talk to it");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            fight();
        }
        else if (input == 2) {
            start();
        } 
        else if(input == 3) {
            talk();
        }
    }

    public void goStraight() {
        if (!hasCheese) {
            System.out.println("You found cheese on the ground!");
            hasCheese = true;
        } else {
            System.out.println("There's nothing here...");
        }  
        start();
    }

    public void goRight() {
        if (!hasSword) {
            System.out.println("You find a sword on the ground!");
            System.out.println("Next to the sword you also find a giant translator!");
            hasGiantTranslotor = true;
            hasSword = true;
        }
        else {
            System.out.println("There's nothing here...");
        }
        start();
    }

    public void fight() {
        if (hasSword) {
            if(choice == 1){
                System.out.println("You defeat the giant with your sword and run out of the cave!");
                finalRoom();
            }else{
                System.out.println("You get stomped by the giant and red stuff goes everywhere.");
            }
        } else {
            System.out.println("You get stomped by the giant and red stuff goes everywhere.");
        }
    }

    public void talk() {
        if(hasGiantTranslotor) {
            System.out.println("You successfully comunicate with the giant. It agrees to let you pass.");
            finalRoom();
        } else {
            System.out.println("The giant can't understand you it crushes you with one punch.");
        }
    }

    public void finalRoom() {
        System.out.println("A old man blocks your way");
        if(hasCheese && hasGiantTranslotor && hasSword) {
            System.out.println("The old man takes the cheese, sword, and giant translator from you and moves out of the way");
        } else {
            System.out.println("The old man stops you from exiting, you are now trapped in the cave for eternity");
        }
    }

    public static void main(String[] args) {
        new TextBasedAdventure().execute();
    }
}