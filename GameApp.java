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
    int act = 0;
    boolean cont = true;
    String p = "   =================================================" 
      + "\n====== Pokemon Mystery Dungeon : Explorers of Java  ======" 
      + "\n======                   v. 1.0                     ======" 
      + "\n======       Project by: Nancy Cao & Celine Yan     ======"
      +"\n    =================================================";
    p += "\n……";
    p += "\n………………";
    p += "\nA slight hazy feeling washes over you.";
    p += "\n……";
    p += "\n…………";
    p += "\nYou hear soft splashes of the waves against the sand.";
    p += "\nSomehow, you’ve ended up on a beach.";
    p += "\nWeird.";
    p += "\nWeren’t you struggling to resist falling asleep at your desk just a second ago while studying for that APCS final you have on Thursday?";
    
    p += "\n……";
    p += "\n…………….";
    p += "\nCries of birds are heard above you.";
    p += "\nWell. The fact that you still have a test to study for doesn’t change, and you’ve procrastinated an awful lot so let’s try to get you back home to finish studying, shall we?";
    
    p += "\n……";
    p += "\n……………";
    p += "\nYou try to move your body, but your strength seems somewhat depleted. As you hoist yourself up, you realize one thing:";
    p += "\nYou’re not human.";
    
    p += "\nYou look up ahead and see a glimpse of sunlight behind an opening of a cave.";
    p += "\nMaybe if you travel to the other side, you’ll be able to get some help.";
    p += "\nWell, shall we advance?";
    
    p += "\nHello! What is your name?"; 
    System.out.println(p);
    
    try {
      name = in.readLine();
    }
    catch ( IOException e ) { }
    
    p = "Welcome to the world of Pokémon Mystery Dungeon, " + name + "!";
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
        act = Integer.parseInt(in.readLine());
      }
      catch ( IOException e ) { }
      
      if (act == 1) System.out.print("<insert stats here>");
      else if (act == 2) System.out.println("<insert bag items here>");
      else if (act == 3) System.out.println("<go to easy dungeon>");
      else if (act == 4) System.out.println("<go to med dungeon>");
      else if (act == 5) System.out.println("<go to hard dungeon>");
      else if (act == 6) cont = false;
      else System.out.println("That command is unavailable. Please enter a valid number.");
      
    }
    
  }
  
  public void actions() {
    
  }
  public static void main(String[] args) {
    GameApp myGame = new GameApp();
  }
}
