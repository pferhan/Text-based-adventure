import java.util.Scanner;
import java.util.Random;

public class TextBasedAdventure {
    boolean hasGiantTranslotor;
    boolean hasSword = false;
    boolean hasShovel = false;
    boolean hasPotion = false;
    boolean hasCheese = false;
    boolean hasBook = false;
    Scanner keyboardInput = new Scanner(System.in);

    Random rand = new Random();
    int choice = rand.nextInt(2)+1;

    public void execute() {
        System.out.println("Welcome to Escape from the Cave! You will be given a series of choices to decide your fate. When promted type 1 or 2 to make your selection then press enter. Have fun escaping the cave...hopefully you make it out! Press enter when you are ready to start...");
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
        System.out.println("Oh no! You run into a giant! Fight or flight?\n1. Fight \n2. Flight \n3. Talk to it \n4. Dig out");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            fight();
        }
        else if (input == 2) {
            start();
        }  
        else if (input == 3) {
            talk();
        } 
        else if(input == 4) {
            dig();
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
        if (!hasSword && !hasShovel) {
            System.out.println("You find a sword on the ground!");
            System.out.println("Next to the sword you also find a giant translator!");
            hasGiantTranslotor = true;
            hasSword = true;
            System.out.println("You find a Shovel on the ground!");
            hasShovel = true;
        }else if(hasSword && !hasPotion){
            System.out.println("You have found a wizard, he has given you a magic potion!");
            hasPotion = true;
        }else if(hasSword && hasGiantTranslotor){
            System.out.println("You found a book lying on the ground.");
            hasBook = true;
        }
        else{
            System.out.println("There's nothing here...");
        }
        start();
    }

    public void fight() {

        if(hasSword && hasPotion && hasCheese){
            System.out.println("you shape shift into an oger");
           
        }else if(!hasPotion && hasSword && !hasCheese){
            System.out.println("You defeat the giant with your sword and run out of the cave!");
        } else if(hasPotion && !hasSword && !hasCheese){
            System.out.println("You give the giant the potion, he falls asleep, and you run out of the cave!");
        } else if (!hasPotion && !hasSword && hasCheese){
            System.out.println("You give the giant the cheese, he is from Wisconsin so he is grateful. You bond over this and take 20 minutes to say goodbye but he lets you go and invites you over for the next Packer game.");
        } else if (hasPotion && hasSword && !hasCheese){
            System.out.println("Would you like to use your potion or sword?\n1. Sword \n2. Potion");
            int selection = keyboardInput.nextInt();
            if (selection == 1){
                System.out.println("You defeat the giant with your sword and run out of the cave!");
            } else {
                System.out.println("You give the giant the potion, he falls asleep, and you run out of the cave!");
            }
        } else if (hasPotion && !hasSword && hasCheese){
            System.out.println("Would you like to use your potion or sword?\n1. Potion \n2. Cheese");
            int selection = keyboardInput.nextInt();
            if (selection == 1){
                System.out.println("You give the giant the potion, he falls asleep, and you run out of the cave!");
            } else {
                System.out.println("You give the giant the cheese, he is from Wisconsin so he is grateful. You bond over this and take 20 minutes to say goodbye but he lets you go and invites you over for the next Packer game.");
            }
        } else if (!hasPotion && hasSword && hasCheese){
            System.out.println("Would you like to use your potion or sword?\n1. Sword \n2. Cheese");
            int selection = keyboardInput.nextInt();
            if (selection == 1){
                System.out.println("You defeat the giant with your sword and run out of the cave!");
            } else {
                System.out.println("You give the giant the cheese, he is from Wisconsin so he is grateful. You bond over this and take 20 minutes to say goodbye but he lets you go and invites you over for the next Packer game.");
            }
        }  
        else {
            System.out.println("You get stomped by the giant and red stuff goes everywhere.");
        }
    }
    

    public void dig() {
        if(!hasShovel) {
            System.out.println("you get crushed by the giant you did not have the shovel");
        }
        else if(hasShovel) {
            System.out.println("you dig out of the cave");
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