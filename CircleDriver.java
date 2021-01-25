public class CircleDriver
{
   public static void main(String[] args)
   {
      Circle c1 = new Circle(3.5);
      Circle c2 = new Circle(3.5);
      boolean b = c1.equals(c2);
      System.out.println(b);
      System.out.println(c1);
   }
}