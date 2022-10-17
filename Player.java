public class Player
{
  String name;
  int health;
  double gold;
  int robotsDefeated;
  boolean sword;

  public Player(String playerName, int startingHealth, double startingGold)
  {
    name = playerName; health = startingHealth; gold = startingGold; robotsDefeated = 0; sword = false;
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

  public void getSword() {
    sword = true;
  }

  public boolean returnSword() {
    return sword;
  }
}