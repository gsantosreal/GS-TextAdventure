import java.util.*;

public class TextAdventure 
{
  FancyConsole console;
  Scanner inScanner;
  Player ourHero;

  public TextAdventure()
  {
    console = new FancyConsole("Great Text Adventure!", 600, 600);
    inScanner = new Scanner(System.in);

    // feel free to change the player's starting values
    ourHero = new Player("Bob", 100, 0.0);
  }

  public void play() // starter area
  {
    String input;
    // start of adventure. You can change this if you like
    console.setImage("distantcity.jpg");

    // ask the user for their name.
    System.out.println("What is your name?\n");
    input = inScanner.nextLine();

    // Change ourHero's name
    ourHero.changeName(input);
    
    // describe the starting situation. Feel free to change this
    System.out.println("Here it is. The city you've longed to travel to for so long. \nYou ponder if this is truly the route you want to take. \nWhat would you like to do? \ncity: go towards the city\nhome: go back home\n" + ourHero.getName() + ": ");

    // get user input and go to the appropriate zone based on their input
    boolean correctInput = true;
    while (correctInput) {
      input = inScanner.nextLine();
      
      if (input.equals("city")) {
        enterZone1();
        correctInput = false;
      } else if (input.equals("home")) {
        enterZone3();
        correctInput = false;
      } else {
        System.out.println("Input not understood, try again: ");
      }
    }

  }

  private void enterZone1() // city
  {
    String input;
    console.setImage("city.jpg");
    
    System.out.println("\n\nYou have arrived in the city. However, there is no sign of life in sight.\nSuddenly, a group of 6 robots comes up from behind you! What will you do!?\nhide: hide in the sewers\nfight: fight off the monsters\n" + ourHero.getName() + ": ");
    
    boolean correctInput = true;
    while (correctInput) {
      input = inScanner.nextLine();
      
      if (input.equals("hide")) {
        enterZone2();
        correctInput = false;
      } else if (input.equals("fight")) {
        System.out.println("\nYou fought the robots. ");

        ourHero.setHealth(ourHero.getHealth() - ((int) (20 * Math.random() + 1)));
        ourHero.setGold(ourHero.getGold() + ((int) (20 * Math.random() + 1)));
        ourHero.defeatRobots(6);

        System.out.println("You now have " + ourHero.getHealth() + " health, and " + ourHero.getGold() + " gold.");

        if (ourHero.getHealth() <=0) {
          gameEnd();
        }
        System.out.println(ourHero.getName() + ": ");

      } else {
        System.out.println("Input not understood, try again: ");
      }
    }
  }

  private void enterZone2() // sewer
  {
    String input;
    console.setImage("sewer.jpg");

    ourHero.setHealth(ourHero.getHealth() + 15);
    System.out.println("\n\nYou decided to hide in the sewers. You regained 15 health. You now have " + ourHero.getHealth() + " health.");
    System.out.println("You can now either go to the shop or go back to the city and fight. What will you do?\nshop: go to the shop\nfight: go back to the city to fight.");
    System.out.println(ourHero.getName() + ": ");

    boolean correctInput = true;
    while (correctInput) {
      input = inScanner.nextLine();
      
      if (input.equals("shop")) {
        enterZone4();
        correctInput = false;
      } else if (input.equals("fight")) {
        enterZone1();
        correctInput = false;
      } else {
        System.out.println("Input not understood, try again: ");
      }
    }
  }

  private void enterZone3() // house
  {
    String input;
    console.setImage("house.jpg");

    System.out.println("\n\nYou are at your house. Just when you think you can get some rest, 12 robots appear around you! What will you do?\nfight: fight the robots\nrun: run away and head for the city");
    System.out.println(ourHero.getName() + ": ");

    boolean correctInput = true;
    while (correctInput) {
      input = inScanner.nextLine();
      
      if (input.equals("run")) {
        enterZone5();
        correctInput = false;
      } else if (input.equals("fight")) {
        System.out.println("\nYou fought the robots. ");

        ourHero.setHealth(ourHero.getHealth() - ((int) (30 * Math.random() + 10)));
        ourHero.setGold(ourHero.getGold() + ((int) (30 * Math.random() + 10)));
        ourHero.defeatRobots(12);

        System.out.println("You now have " + ourHero.getHealth() + " health, and " + ourHero.getGold() + " gold.");

        if (ourHero.getHealth() <=0) {
          gameEnd();
        }

        System.out.println(ourHero.getName() + ": ");

      } else {
        System.out.println("Input not understood, try again: ");
      }

    }
    
  }

  private void enterZone4() // shop
  {
    String input;
    console.setImage("shop.jpg");

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone5() // between house and city
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone6() // bossfight
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void gameEnd() // display final stats and end game
  {
    // ADD CODE HERE

    inScanner.close();
  }
}