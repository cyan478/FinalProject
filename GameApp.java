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
	boolean win = false; 

	String start ="*   =================================================" 
	    + "\n*====== Pokemon Mystery Dungeon : Explorers of Java  ======" 
	    + "\n*======                   v. 1.0                     ======" 
	    + "\n*======       Project by: Nancy Cao & Celine Yan     ======"
	    +"\n*    =================================================";
	start += "\n(Press enter to continue)";
	System.out.println(start);
	String p = "*....\n";
	/*
	  p += "*........\n";
	  p += "*A slight hazy feeling washes over you.\n ";
	  p += "*....\n ";
	  p += "*........\n ";
	  p += "*You hear soft splashes of the waves against the sand.\n ";
	  p += "*Somehow, you've ended up on a beach.\n ";
	  p += "*Weird.\n ";
	  p += "*Weren't you struggling to resist falling asleep at your desk just a second ago while studying for that APCS final you have on Thursday?\n ";
	  
	  p += ".... \n";
	  p += "Do you remember your name? \n (Type in your name below)"
	  
	  */
	  
	 try {
	    name = in.readLine();
	}
	catch ( IOException e ) { 
		System.out.println("Please enter a name.");
	}
	/*
     
	  p += "*....\n ";
	  p += "*.........\n ";
	  p += "*Cries of birds are heard above you.\n ";
	  p += "*Well. The fact that you still have a test to study for doesn't change, and you've procrastinated an awful lot so let's try to get you back home to finish studying, shall we?\n ";
     
	  p += "*....\n ";
	  p += "*........\n ";
	  p += "*You try to move your body, but your strength seems somewhat depleted. As you hoist yourself up, you realize one thing:\n ";
	  p += "*You're not human.\n ";
	  p += "\n"
     
     p += "============================ \n";
     p += "It seems like you've already established your goal. \n";
	  p += "Time is running out, and you feel that you only have a little bit of time left before you can revert back to a human. \n"
	  p += "\n";
	  p += "*You look up ahead and see a glimpse of sunlight behind an opening of a cave.\n ";
	  p += "*Maybe if you travel to the other side, you'll be able to get some help.\n ";
	  p += "*Well " + name + ", shall we advance?\n ";
	  p += "\n";
	  p += "...";"
	  
	*/
    
	// Prints out p (story text)
	while (p.indexOf("*") != -1) {
	    System.out.println(p.substring(0, p.indexOf("*")));
	    nextLine();
	    p = p.substring(p.indexOf("*")+1, p.length());
	}
    
    
	System.out.println(p);
    
	p = "Welcome to the world of Pokemon Mystery Dungeon, " + name + "!";
	p += name + ", this is your first dungeon. Here is a quick tutorial on how to play this game: \n";
	//INSERT TUTORIAL
	/*
	"Dungeons vary in difficulty - from easy to hard."
	"Each dungeon has a "maze" for you to solve by moving in different rooms."
	"X is you!"
	"O are the rooms you already passed by."
	"@ are walls. You cannot pass through them."
	"Each room has either an item or a Pokemon."
	"Items: You can either pick it up or leave it. Different items have different effects on you."
	"Pokemon: They are all your enemies. Fight them to gain EXP and level up! If you die, you lose the game."
	"That's about it!"
	*/
	
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
      
	    if (input.equals("1")) System.out.println("<insert stats here>");
	    else if (input.equals("2")) System.out.println("<insert bag items here>");
	    else if (input.equals("3")) {
		Map_Level1 a = new Map_Level1();
		win = launchDungeon(a);
		if (win) 
		    System.out.println("Congrats. You earned ___ gold and ___ items!"); //Congrats! You've made it out of the dungeon. Onward to the next!
		else
		    System.out.println( "Unfortunately you have lost ___ gold and half your items");
	    }
	    else if (input.equals("4")) {
		Map_Level2 a = new Map_Level2();
		win = launchDungeon(a);
		if (win) 
		    System.out.println("Congrats. You earned ___ gold and ___ items!");
		else
		    System.out.println( "Unfortunately you have lost ___ gold and half your items");
	    }
	    else if (input.equals("5")) {
		Map_Level3 a = new Map_Level3();
		win = launchDungeon(a);
		if (win) 
		    System.out.println("Congrats. You earned ___ gold and ___ items!");
		else
		    System.out.println( "Unfortunately you have lost ___ gold and half your items");
	    }
	    else if (input.equals("6")) cont = false;
	    else System.out.println("That command is unavailable. Please enter a valid number.");
      
	}
    
    }

    // Creates map 
    // Returns if the user completed the dungeon
    // Takes the int level of the dungeon selected
    // true: user has reached the stairs
    // false: user has quit 
    public boolean launchDungeon(Map a) {
      	boolean cont = true;
	String t = "";
	String input = "";
	String border = "* * * * * * * \n";
    
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
	    t += "'h' - HELP \n";
	    t += "'quit' - QUIT [WARNING: You will lose half your money & items randomly] \n \n";
	    t += "Dungeon Map: \n";
	    if (a.getRowL() == 5) border = "* * * * * * * * * *\n";
	    if (a.getRowL() == 8) border = " * * * * * * * * * * * * * *\n";
	    t += border;
	    t += a;
	    t += border;
	    System.out.println(t);
      
	    try {
		input = in.readLine();
	    }
	    catch ( IOException e ) { }
	    // UP
	    if (input.equals("w") || input.equals("W")) {
		if (a.getX() - 1 >= 0) {
		    if (a.getTileFace(a.getX()-1, a.getY()).equals("@")) {
			t += "\n\n This path is blocked by an obstacle.";
			a.setTileFace(a.getX()-1, a.getY());
		    }
		    else {
			a.setX(a.getX() -1);
			a.setTileFace(a.getX(), a.getY());
		    }
		}
		else 
		    t += "\n\nERROR: INVALID MOVEMENT\n"; 
	    }
	    // LEFT
	    else if (input.equals("a") || input.equals("A")) {
		if (a.getY() - 1 >= 0) {
		    if (a.getTileFace(a.getX(), a.getY()-1).equals("@")) {
			t += "\n\n This path is blocked by an obstacle.";
			a.setTileFace(a.getX(), a.getY()-1);
		    }
		    else {
			a.setY(a.getY()-1);
			a.setTileFace(a.getX(), a.getY());
		    }
		}
		else 
		    t += "\n \nERROR: INVALID MOVEMENT\n"; 
	    }
	    //DOWN
	    else if (input.equals("s") || input.equals("S")) {
		if (a.getX() + 1 < a.getColumnL()) {
		    if (a.getTileFace(a.getX()+1, a.getY()).equals("@")) {
			t += "\n\nThis path is blocked by an obstacle.\n";
			a.setTileFace(a.getX()+1, a.getY());
		    }
		    else {
			a.setX(a.getX()+1);
			a.setTileFace(a.getX(), a.getY());
		    }
		}
		else 
		    t += "\n \nERROR: INVALID MOVEMENT\n"; 
	    }

	    // RIGHT
	    else if (input.equals("d") || input.equals("D")) {
		if (a.getY() + 1 < a.getColumnL()) {
		    if (a.getTileFace(a.getX(), a.getY()+1).equals("@")) {
			t += "\n\nThis path is blocked by an obstacle.\n";
			a.setTileFace(a.getX(), a.getY()+1);
		    }
		    else {
			a.setY(a.getY() + 1);
			a.setTileFace(a.getX(), a.getY());
		    }
		}
		else 
		    t += "\n \nERROR: INVALID MOVEMENT\n"; 
	    }
	    
	    else if (input.equals("h") || input.equals("H")) {
		t += "\n\nHELP: \n";
		t += "The 'X' represents YOUR position. \n";
		t += "The '*' represents the dungeon's borders. \n";
		t += "The 'O' represents areas already explored. \n";
		t += "The '@' represents impassable obstacles. \n\n";
	    }
      
	    else if (input.equals("quit") || input.equals("QUIT")) {
		cont = false;
	    }
	    
	    if ((a.getTileFace(a.getX(), a.getY())).equals("^")) {
		cont = false;
		return true;
	    }
	    
	}
	return false;
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
