public class ComputerDriver
{
   public static void main(String[] args)
   {
      Computer c1 = new Computer(5, 5, true, 4, "Windows"); 
      Computer c2 = new Computer(10, 10, false, 7, "Mac");
      Computer c3 = new Computer(-10, -12, true, -5, "Windows");
      boolean b = c1.equals(c2);
      System.out.println(b);
      System.out.println(c1);
      System.out.println(c2.toString());
   }
}