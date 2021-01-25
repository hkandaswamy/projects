public class Computer
{
   //instance variables
   private int ram;
   private int hd;
   private boolean gc;
   private int cpu;
   private String os;
   
   //constructor
   public Computer(int ram, int hd, boolean gc, int cpu, String os)
   {
      setRam(ram);
      setHd(hd);
      setGc(gc);
      setCpu(cpu);
      setOs(os);
   }
   public Computer()
   {
      ram = 1;
      hd = 1;
      gc = false;
      cpu = 1;
      os = "Windows";
   }
   //setter methods
   public void setRam(int newRam)
   {
      if(newRam > 0)
         ram = newRam;
   }
   public void setHd(int newHd)
   {
      if(newHd > 0)
         hd = newHd;
   }
   public void setCpu(int newCpu)
   {
      if(newCpu > 0)
         cpu = newCpu;
   }
   public void setGc(boolean newGc)
   {
      gc = newGc;
   }
   public void setOs(String newOs)
   {
      os = newOs;
   }
   //getter methods
   public int getRam()
   {
      return ram;
   }
   public int getHd()
   {
      return hd;
   }
   public boolean getGc()
   {
      return gc;
   }
   public int getCpu()
   {
      return cpu;
   }
   public String getOs()
   {
      return os;
   }
   //equals
   public boolean equals(Computer other)
   {
      return this.hd == other.hd && this.ram == other.ram && this.gc == other.gc && this.cpu == other.cpu && this.os.equals(other.os);
   }
   //toString
   public String toString()
   {
      String s = "";
      s = "Ram = " + ram;
      s = s + "\nHard Drive = " + hd;
      s = s + "\nCPU = " + cpu;
      if(gc == true)
         s = s + "\nGraphic Card = Yes";
      else
         s = s + "\nGraphic Card = No";
      s = s + "\nOperating System = " + os;
      return s;
   }
}