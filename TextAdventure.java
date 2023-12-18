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
        correctInput = false;
        enterZone1();
      } else if (input.equals("home")) {
        correctInput = false;
        enterZone3();
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
        correctInput = false;
        enterZone2();
      } else if (input.equals("fight")) {
        System.out.println("\nYou fought the robots. ");

        ourHero.setHealth(ourHero.getHealth() - ((int) (20 * Math.random() + 1)));
        ourHero.setGold(ourHero.getGold() + ((int) (20 * Math.random() + 1)));
        ourHero.defeatRobots(6);

        System.out.println("You now have " + ourHero.getHealth() + " health, and " + ourHero.getGold() + " gold.");

        if (ourHero.getHealth() <=0) {
          correctInput = false;
          inScanner.close();
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
        correctInput = false;
        enterZone4();
      } else if (input.equals("fight")) {
        correctInput = false;
        enterZone1();
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
          // gameEnd();
          correctInput = false;
          inScanner.close();
          gameEnd();
        }

        System.out.println(ourHero.getName() + ": ");

      } else {
        System.out.println("Input not understood, try again: ");
      }


    }
    gameEnd();
    
  }

  private void enterZone4() // shop
  {
    String input;
    console.setImage("shop.jpg");

    System.out.println("\n\nAlas, once entering the shop you find your only fellow human, the shopkeeper. He tells you he will sell you a sword for 150 gold.");
    System.out.println("From here, you also either go back to the sewer or leave the city entirely. What will you do?");
    System.out.println("sword: buy sword (150 gold)\nsewer: go back to the sewer\nleave: leave city");
    System.out.println(ourHero.getName() + ": ");

    boolean correctInput = true;
    while (correctInput) {
      input = inScanner.nextLine();
      
      if (input.equals("sewer")) {
        correctInput = false;
        enterZone2();
      } else if (input.equals("leave")) {
        correctInput = false;
        enterZone5();
      } else if (input.equals("sword")) {
        if (ourHero.returnSword() == false) {
          if (ourHero.getGold() > 150) {
            ourHero.setGold(ourHero.getGold() - 150);
            ourHero.getSword();
            System.out.println("You now have the sword! What now?\n" + ourHero.getName() + ": ");
          } else {
            System.out.println("You need more gold! What now?\n" + ourHero.getName() + ": ");
          }
        } else {
          System.out.println("You already have a sword! What now?\n" + ourHero.getName() + ": ");
        }
      } else {
        System.out.println("Input not understood, try again: ");
      }

    }
    
  }

  private void enterZone5() // between house and city
  {
    String input;
    console.setImage("road.jpg");

    ourHero.setHealth(ourHero.getHealth() + 15);
    System.out.println("\n\nYou regained 15 health. You now have " + ourHero.getHealth() + " health.");
    System.out.println("Halfway from the city and your house you travel down this road, not knowing where you are going. You notice a beacon in the distance. What will you do?");
    System.out.println("city: go to the city\nhome: go home\nbeacon: investigate the beacon (bossfight)");
    System.out.println(ourHero.getName() + ": ");

    boolean correctInput = true;
    while (correctInput) {
      input = inScanner.nextLine();
      
      if (input.equals("city")) {
        correctInput = false;
        enterZone1();
      } else if (input.equals("home")) {
        correctInput = false;
        enterZone3();
      } else if (input.equals("beacon")) {
        correctInput = false;
        enterZone6();
      } else {
        System.out.println("Input not understood, try again: ");
      }

    }
  }

  private void enterZone6() // bossfight
  {
    String input;
    console.setImage("desolation.jpg");

    System.out.println("\n\nYou are at the end. This is the mega robot responsible for the disappearances of the human race. You have nothing left to do but attack him. What will you do?");
    System.out.println("punch: punch the boss (very ineffective)\nsword: you stab the boss (very effective, sword required)");
    System.out.println(ourHero.getName() + ": ");

    boolean correctInput = true;
    while (correctInput) {
      input = inScanner.nextLine();
      
      if (input.equals("punch")) {
        System.out.println("\nYou punch the mega robot... And he punches back.");
        ourHero.setHealth(-20);
        System.out.println("You have lost all your health and died.");
        inScanner.close();
        gameEnd();
        correctInput = false;
        gameEnd();
      } else if (input.equals("sword")) {
        if (ourHero.returnSword() == true) {
          System.out.println("\nYou stab the robot in its vital point! ... The robot has died!");
          correctInput = false;
          gameEnd();
        } else {
          System.out.println("You should have brought a sword to do this. GG\n" + ourHero.getName() + ": ");
        }
      } else {
        System.out.println("Input not understood, try again: ");
      }

    }

  }

  private void gameEnd() // display final stats and end game
  {
    console.setImage("gameover.jpg");


    if (ourHero.getHealth() <= 0) {
      System.out.print("\n\nGame over. You died. At the end of your journey you defeated " + ourHero.getRobotsDefeated() + " robots, and earned " + ourHero.getGold() + " gold.");
      if (ourHero.returnSword() == true) {
        System.out.print(" You also had a sword.");
      }
      System.out.println("\nThank you for playing, " + ourHero.getName() + ". Good Night.");
    } else {
      System.out.println("\n\nYou won! Thank you for playing, " + ourHero.getName() + "! You defeated " + ourHero.getRobotsDefeated() + " robots, and earned " + ourHero.getGold() + " gold. GG");
    }
    inScanner.close();
  }
}