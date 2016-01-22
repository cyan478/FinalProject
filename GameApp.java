import java.io.*;
import java.util.*;

public class GameApp {
  
  private InputStreamReader isr;
  private BufferedReader in;
  
  public GameApp() {
    isr = new InputStreamReader(System.in);
    in = new BufferedReader(isr);
    newGame(); 
  }
  
  public void newGame() {
    String name = "";
    String act = "";
    boolean cont = true;
    String start ="*   =================================================" 
      + "\n*====== Pokemon Mystery Dungeon : Explorers of Java  ======" 
      + "\n*======                   v. 1.0                     ======" 
      + "\n*======       Project by: Nancy Cao & Celine Yan     ======"
      +"\n*    =================================================";
    start += "\n(Press enter to start the game)";
    System.out.println(start);
    String p = "*....\n(Press enter)";
    p += "*........\n(Press enter)";
    p += "*A slight hazy feeling washes over you.\n(Press enter)";
    p += "*....\n(Press enter)";
    p += "*........\n(Press enter)";
    p += "*You hear soft splashes of the waves against the sand.\n(Press enter)";
    p += "*Somehow, you've ended up on a beach.\n(Press enter)";
    p += "*Weird.\n(Press enter)";
    p += "*Weren't you struggling to resist falling asleep at your desk just a second ago while studying for that APCS final you have on Thursday?\n(Press enter)";
    
    p += "*....\n(Press enter)";
    p += "*.........\n(Press enter)";
    p += "*Cries of birds are heard above you.\n(Press enter)";
    p += "*Well. The fact that you still have a test to study for doesn't change, and you've procrastinated an awful lot so let's try to get you back home to finish studying, shall we?\n(Press enter)";
    
    p += "*....\n(Press enter)";
    p += "*........\n(Press enter)";
    p += "*You try to move your body, but your strength seems somewhat depleted. As you hoist yourself up, you realize one thing:\n(Press enter)";
    p += "*You're not human.\n(Press enter)";
    
    p += "*You look up ahead and see a glimpse of sunlight behind an opening of a cave.\n(Press enter)";
    p += "*Maybe if you travel to the other side, you'll be able to get some help.\n(Press enter)";
    p += "*Well, shall we advance?\n(Press enter)";
    
    p += "*Hello! What is your name? \n(Enter your name)";
    
    
    while (p.indexOf("*") != -1) {
      System.out.println(p.substring(0, p.indexOf("*")));
      nextLine();
      p = p.substring(p.indexOf("*")+1, p.length());
    }
      
      
    System.out.println(p);
    
    try {
      name = in.readLine();
    }
    catch ( IOException e ) { }
    
    p = "Welcome to the world of Pokemon Mystery Dungeon, " + name + "!";
    p += "\n" + name + ", you may now do whatever you wish.";
    System.out.println(p);
    
    while (cont) {
      p = "\nEnter in the action number:";
      p += "\n1. Check stats";
      p += "\n2. View bag";
      p += "\n3. Go to Dungeon #1 [EASY]";
      p += "\n4. Go to Dungeon #2 [MEDIUM]";
      p += "\n5. Go to Dungeon #3 [HARD]";
      p += "\n6. Exit :(";
      System.out.println(p);
      
      try {
        act = (String)(in.readLine());
      }
      catch ( IOException e ) { }
      
      if (act.equals("1")) System.out.print("<insert stats here>");
      else if (act.equals("2")) System.out.println("<insert bag items here>");
      else if (act.equals("3")) easyDungeon();
      else if (act.equals("4")) System.out.println("<go to med dungeon>");
      else if (act.equals("5")) System.out.println("<go to hard dungeon>");
      else if (act.equals("6")) cont = false;
      else System.out.println("That command is unavailable. Please enter a valid number.");
      
    }
    
  }
  
  public void easyDungeon() {
    Map_Level1 a = new Map_Level1();
  }
  
  public void nextLine() {
    try {
      in.readLine();
    }
    catch ( IOException e ) { }
  }
  
  public static void main(String[] args) {
    GameApp myGame = new GameApp();
  }
}
