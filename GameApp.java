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
    String input = "";
    boolean cont = true;
    String start ="*   =================================================" 
      + "\n*====== Pokemon Mystery Dungeon : Explorers of Java  ======" 
      + "\n*======                   v. 1.0                     ======" 
      + "\n*======       Project by: Nancy Cao & Celine Yan     ======"
      +"\n*    =================================================";
    start += "\n(Press enter to start the game)";
    System.out.println(start);
    String p = "*....\n(Keep pressing enter to continue)";
    /*
     p += "*........\n";
     p += "*A slight hazy feeling washes over you.\n ";
     p += "*....\n ";
     p += "*........\n ";
     p += "*You hear soft splashes of the waves against the sand.\n ";
     p += "*Somehow, you've ended up on a beach.\n ";
     p += "*Weird.\n ";
     p += "*Weren't you struggling to resist falling asleep at your desk just a second ago while studying for that APCS final you have on Thursday?\n ";
     
     p += "*....\n ";
     p += "*.........\n ";
     p += "*Cries of birds are heard above you.\n ";
     p += "*Well. The fact that you still have a test to study for doesn't change, and you've procrastinated an awful lot so let's try to get you back home to finish studying, shall we?\n ";
     
     p += "*....\n ";
     p += "*........\n ";
     p += "*You try to move your body, but your strength seems somewhat depleted. As you hoist yourself up, you realize one thing:\n ";
     p += "*You're not human.\n ";
     
     p += "*You look up ahead and see a glimpse of sunlight behind an opening of a cave.\n ";
     p += "*Maybe if you travel to the other side, you'll be able to get some help.\n ";
     p += "*Well, shall we advance?\n ";
     */
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
      p = "\nEnter in an action number:";
      p += "\n1. Check stats";
      p += "\n2. View bag";
      p += "\n3. Go to Dungeon #1 [EASY]";
      p += "\n4. Go to Dungeon #2 [MEDIUM]";
      p += "\n5. Go to Dungeon #3 [HARD]";
      p += "\n6. Exit :(";
      System.out.println(p);
      
      try {
        input = (String)(in.readLine());
      }
      catch ( IOException e ) { }
      
      if (input.equals("1")) System.out.print("<insert stats here>");
      else if (input.equals("2")) System.out.println("<insert bag items here>");
      else if (input.equals("3")) easyDungeon();
      else if (input.equals("4")) System.out.println("<go to med dungeon>");
      else if (input.equals("5")) System.out.println("<go to hard dungeon>");
      else if (input.equals("6")) cont = false;
      else System.out.println("That command is unavailable. Please enter a valid number.");
      
    }
    
  }
  
  public void easyDungeon() {
    Map_Level1 a = new Map_Level1();
    boolean cont = true;
    String t = "";
    String input = "";
    
    System.out.println("You are in Dungeon #1.");
    System.out.println("Your objective: Find the flight of stairs and escape. \n");
    
    while (cont) {
      t += "HP: " + "\n";
      t += "Enter a letter/word: \n";
      t += "'w' - UP \n";
      t += "'a' - LEFT \n";
      t += "'s' - DOWN \n";
      t += "'d' - RIGHT \n";
      t += "'bag' - CHECK BAG \n";
      t += "'help' - HELP \n";
      t += "'quit' - QUIT [WARNING: You will lose half your money & items randomly] \n \n";
      t += "Dungeon Map: \n";
      t += "* * * * * * * \n";
      t += a;
      t += "* * * * * * *";
      System.out.println(t);
      
      try {
        input = in.readLine();
      }
      catch ( IOException e ) { }
      
      if (input.equals("w") || input.equals("W")) {
        if (a.getX() - 1 >= 0) {
          a.setX(a.getX() -1);
          a.setTileFace(a.getX(), a.getY());
        }
        else 
          t += "\n \nERROR: INVALID MOVEMENT\n"; 
      }
      
      if (input.equals("a") || input.equals("A")) {
        if (a.getY() - 1 >= 0) {
          a.setY(a.getY()-1);
          a.setTileFace(a.getX(), a.getY());
        }
        else 
          t += "\n \nERROR: INVALID MOVEMENT\n"; 
      }
      
      if (input.equals("s") || input.equals("S")) {
        if (a.getX() + 1 < 3) {
          a.setX(a.getX()+1);
          a.setTileFace(a.getX(), a.getY());
        }
        else 
          t += "\n \nERROR: INVALID MOVEMENT\n"; 
      }
      
      if (input.equals("d") || input.equals("D")) {
        if (a.getY() + 1 < 3) {
          a.setY(a.getY() + 1);
          a.setTileFace(a.getX(), a.getY());
        }
        else 
          t += "\n \nERROR: INVALID MOVEMENT\n"; 
      }
      
      if (input.equals("help") || input.equals("HELP")) {
        t += "\n\nHELP: \n";
        t += "The 'X' represents your position. \n";
        t += "The '*' represents the dungeon's borders. \n";
        t += "The 'O' represents areas already explored. \n";
      }
      
      if ((input.equals("quit") || input.equals("QUIT")) 
            || a.getTileFace(a.getX(), a.getY()).equals("^"))
        cont = false;
    }
    
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
