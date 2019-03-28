class Two 
 {
  byte x;
 }

 class One 
 {
  public static void main(String [] args) 
  {
   One p = new One();
   p.start();
  }

  void start() 
  {
   Two t = new Two();
   System.out.print(t.x + " ");
   Two t2 = fix(t);
   System.out.println(t.x + " " + t2.x);
  }

  Two fix(Two tt) 
  {
   tt.x = 42;
   return tt;
  }
 }