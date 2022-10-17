import java.util.*;

public class Player
{
  String name;
  int health;
  double gold;
  int robotsDefeated;

  public Player(String playerName, int startingHealth, double startingGold)
  {
    name = playerName; health = startingHealth; gold = startingGold; robotsDefeated = 0;
  }

  public String getName()
  {
    return name;
  }

  public void changeName(String newName)
  {
    name = newName;
  }

  public int getHealth()
  {
    return health;
  }

  public void setHealth(int newHealth)
  {
    health = newHealth;
  }

  public double getGold()
  {
    return gold;
  }

  public void setGold(double newAmount)
  {
    gold = newAmount;
  }

  public int getRobotsDefeated()
  {
    return robotsDefeated;
  }

  public void defeatRobots(int robots)
  {
    robotsDefeated += robots;
  }
}