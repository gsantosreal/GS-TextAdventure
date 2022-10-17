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
    ourHero = new Player("Bob", 100, 0);
  }

  public void play()
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

  private void enterZone1()
  {
    String input;
    console.setImage("bigcity.jpg");
    
    System.out.println("\n\nYou have arrived in the city. However, there is no sign of life in sight.\nSuddenly, a group of 6 robots comes up from behind you! What will you do!?\nhide: hide in the sewers\nfight: fight off the monsters\n" + ourHero.getName() + ": ");
    
    boolean correctInput = true;
    while (correctInput) {
      input = inScanner.nextLine();
      
      if (input.equals("hide")) {

        correctInput = false;
      } else if (input.equals("fight")) {

        correctInput = false;
      } else {
        System.out.println("Input not understood, try again: ");
      }
    }
  }

  private void enterZone2()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone3()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone4()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone5()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone6()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void gameEnd()
  {
    // ADD CODE HERE

    inScanner.close();
  }
}