// TODO comments
public class DieTest
{
  public static void main(String[] args)
  {
      Die die = new Die();
      die.roll();
      System.out.println(die.getNumDots());
      die.roll();
  }
}
