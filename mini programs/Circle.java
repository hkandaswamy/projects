public class Circle
{
   //instance variables
   private double radius;
   
   //constructor
   public Circle(double radius)
   {
      setRadius(radius);
   }
   //setter methods
   public void setRadius(double newRadius)
   {
      if(newRadius > 0);
         radius = newRadius;
   }
   //getter methods
   public double getRadius()
   {
      return radius;
   }
   public String toString()
   {
      String s = "";
      s = "The radius is: " + radius;
      return s;
   }
   //equals
   public boolean equals(Circle other)
   {
      return this.radius == other.radius;
   }
   //area
   public double getArea(double r)
   {
      return Math.PI * r * r;
   }
   //diameter
   public double getDiameter(double r)
   {
      return r * 2;
   }
   //circumference
   public double getCircumference(double r)
   {
      return 2 * Math.PI * r ;
   } 
}