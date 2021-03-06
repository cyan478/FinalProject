import java.io.*;
import java.util.*;

public class GameApp {
  
    private InputStreamReader isr;
    private BufferedReader in;
    private Player _you;
    private static final String [] pkmn1 = {"Zubat", "Geodude", "Onix", "Golbat", "Zubat", "Zubat", "Geodude"}; //len: 7 //more chances to get zubat and geodude
    private static final String [] pkmn2 = {"Vulpix", "Eevee", "Skitty", "Miltank", "Vulpix", "Zubat", "Furret"}; //len: 7
    private static final String [] pkmn3 = {"Lapras", "Charizard", "Salamance", "Dragonite", "Salamance", "Dragonite", "Flygon"}; //len: 7
    private Map_Level1 d1;
    private Map_Level2 d2;
    private Map_Level3 d3;
    private Opponent _opp;
  
    public GameApp() {
		isr = new InputStreamReader(System.in);
		in = new BufferedReader(isr);
		newGame(); 
    }
    
    //PRINTING STORY ALGORITHM ==========================
    // O(N)
    public void printStory(String p){
	while (p.indexOf("*") != -1) {
	    System.out.println(p.substring(0, p.indexOf("*")));
	    nextLine();
	    p = p.substring(p.indexOf("*")+1, p.length());
		}
    }

	//O(N)
        // RECURSIVE FUNCTION
 public static String addStar(String p) {
	if (p.indexOf("\n") == -1) return "";
	return "*" + p.substring(0, p.indexOf("\n")+1) +
	    addStar(p.substring(p.indexOf("\n")+1, p.length()));
    }
    // O(1)
    public void nextLine() {
		try {
	    	in.readLine();
		}
		catch ( IOException e ) { }
    }
   //=======================================================
  //O(1)
	//TUTORIAL METHOD ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void tutorial(){
		String p = "";
		p += "--------------- TUTORIAL--------------\n";
	    p += "Dungeons vary in difficulty - from easy to hard.\n";
	    p += "Each dungeon has a 'maze' for you to solve by moving across different rooms to reach a staircase.\n";
	    p += "X is YOU!\n";
	    p += "O are the rooms you already passed by. \n";
	    p += "@ are walls. You cannot pass through them. \n";
	    p += "Each room has either an item, a Pokemon, or nothing. \n";
	    p += "Items: You can either pick it up or leave it. Different items have different effects on you.\n";
	    p += "Pokemon: They are all your enemies. Fight them to gain EXP, get stronger, and level up! If you die, it's game over for you, "+ _you.getName()+".\n";
	    p += "That's about it!\n";
	    p += "I wish the best of luck for you in the dungeons.\n";
	    p += "----------------------------------------\n";
	    p = addStar(p);
	    printStory(p);
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// All O(1)
	//DUNGEON 1,2,3 OPPONENT METHOD ============================
	//when u encounter an opponent IN DUNGEON 1,2,3:
   	public void meetOpponent1(){
   		int randomName = (int)(Math.random() * 7);
   		String name = pkmn1[randomName];
   		int lvl = ((int)(Math.random() * 5)) + 3;
   		_opp = new Opponent(name, lvl*10, lvl*5/2+1, lvl*5/2+1, lvl, lvl*5/2); 
   	}
   	
   	public void meetOpponent2(){
   		int randomName = (int)(Math.random() * 7);
   		String name = pkmn1[randomName];
   		int lvl = ((int)(Math.random() * 4)) + 9;
   		_opp = new Opponent(name, lvl*10, lvl*5/2+1, lvl*5/2+1, lvl, lvl*5/2);
   	}
   	
   	public void meetOpponent3(){
   		int randomName = (int)(Math.random() * 7);
   		String name = pkmn1[randomName];
   		int lvl = ((int)(Math.random() * 4)) + 14;
   		_opp = new Opponent(name, lvl*10, lvl*5/2+1, lvl*5/2+1, lvl, lvl*5/2); 
   	}
  //=======================================================
  // Min: O(1); Max: O(N)
  	// battle with opponent
  	// returns if player has *survived*
  	// T : Win
  	// F : Loss
  	public void battle(Player _you, Map a) {
  		String t = "";
  		String battleMsg = "";
  		String input = "";
  		
  		if (a.getDungeonNum() == 1) meetOpponent1();
  		if (a.getDungeonNum() == 2) meetOpponent2();
  		if (a.getDungeonNum() == 3) meetOpponent3();
  		
  		t = "------------------------------------------------------- \n";
		t += "You ran into " + _opp.getName() + "! \n";
		t += "------------------------------------------------------- \n";
	  	System.out.println(t);
		
  		while (_you.isAlive() && _opp.isAlive()) {
  			t = "";
  			t += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
  			t += "Enter in your action: \n";
  			t += "1 - Attack opponent \n";
  			t += "2 - Attempt to run away \n";
  			t += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
  			//t += "quit - QUIT GAME [WARNING: You will exit and die] \n \n";
  			System.out.println(battleMsg + "\n");
  			System.out.println(t);
  			
  			
  			try {
				input = (in.readLine());
		    }
		    catch ( IOException e ) { }
		    
  			if(_opp.RunAway(_you.getLvl())) {
  				System.out.println(_opp.getName() + " ran away from the battle!");
  				break; 
  			}

      		if (input.equals("1")) {
      			//player's turn to attack ---------------------------------
      			int playeratk = _you.attack(_opp.getDef());
      			battleMsg = "You attacked!\n"; 
      			
      			_opp.lowerHP(playeratk);
      			battleMsg += _opp.getName() + " lost " + playeratk + " HP! \n";
      			
      			//opponent's turn to attack ---------------------------------
      			if (_opp.isAlive()){
	      			int oppatk = _opp.attack(_you.getDef());
	      			battleMsg += _opp.getName() + " attacked! \n"; 
	      			
	      			_you.lowerHP(oppatk);
	      			battleMsg += "You lost " + oppatk + " HP! \n";
      			}
      		}
      		
      		if (input.equals("2")) {
      			if (_you.RunAway(_opp.getLvl())) {
      				System.out.println("You have successfully ran away from the battle!");
      				break;
      			}
      			else {
      				battleMsg = "You cannot escape the battle! The opponent's level is too high!";
      				int oppatk = _opp.attack(_you.getDef());
	      			battleMsg = "Instead, " + _opp.getName() + " attacked! \n"; 
	      			
	      			_you.lowerHP(oppatk);
	      			battleMsg = "You lost " + oppatk + " HP! \n";
      			}
      		}
      		
      		if(!_opp.isAlive()) {
      			_you.update(_opp.getEXP());
      			System.out.println(_opp.getName() + " fainted!");
      			System.out.println("You gained " + _opp.getEXP() +" EXP points!");
      			break;
      		}
      		
	      	if (!_you.isAlive()) { 
	      		
	      		//if bag contains reviver seed, activate it
				// update HP to 100
      			//remove from bag.
      			if (_you.searchBag("Reviver Seed")){
      				System.out.println("You've been revived by the Reviver Seed in your bag! That really saved your life there, didn't it?");
      				_you.setHP(_you.getTotalHP());
      				_you.removeFromBag("Reviver Seed");
      		}
      		
        	else {
      			System.out.println("***ERROR: INVALID ACTION***");
			}
  		}
  		}
  	}

      		
	
	//ITEM CHANCES =========================================
	//returns an item randomly.
	/*
	  Oran Berry: 27%
      Gummy: 28%
      Golden Apple: 15%
      Rare Candy: 5%
      Protein: 10%
      Zinc: 10%
      Reviver Seed: 5%
      */
      // O(1)
      public String randomItem(){ 
      		int r = ((int)(Math.random() * 100)) + 1; //1-100 
      		if (r <= 5) return "Reviver Seed";
      		else if (r <= 10) return "Rare Candy";
      		else if (r <= 20) return "Protein";
      		else if (r <= 30) return "Zinc";
      		else if (r <= 45) return "Golden Apple";
      		else if (r <= 73) return "Gummy";
      		else return "Oran Berry";
      }
      
     //=======================================================
     
    //Player picks up random item ========================================= 
    public void getItem(Player _you) {
    	String randItem = randomItem();
    	_you.addItem(randItem);
    	System.out.println("------------------------------------------------------- \n" + 
    						"You picked up a " + randItem + "!");
    }
    //==============================================================
    // O(1)
    //33-33-33 % CHANCE! ==========================================
    public void chanceOfRoom(Player _you, Map a){
    	int r = ((int)(Math.random() * 100)) + 1; //1-100
    	if (r <= 33) battle(_you, a); //BATTLE!!!!
    	else if (r <= 66) getItem(_you); //ITEM!!!
    	else System.out.println("------------------------------------------------------- \n" + 
    							"There appears to be nothing in this room.\n"); //NOTHING!!!
    }
 // min: O(1); max:O(N)
    public void newGame() {
		String name = "";
		String input = "";
		boolean winGame;
		
		String start ="   =================================================" 
		    + "\n====== Pokemon Mystery Dungeon : Explorers of Java  ======" 
		    + "\n======                   v. 1.0                     ======" 
		    + "\n======       Project by: Nancy Cao & Celine Yan     ======"
		    +"\n    =================================================";
		start += "\n(Press enter to continue)";
		System.out.println(start);
		
		String p = "*....\n";
		
		  p += "*........\n";
		  p += "*A slight hazy feeling washes over you.\n ";
		  p += "*....\n ";
		  p += "*........\n ";
		  p += "*You hear soft splashes of the waves against the sand.\n ";
		  p += "*Somehow, you've ended up on a beach.\n ";
		  p += "*Weird.\n ";
		  p += "*Weren't you struggling to resist falling asleep at your desk just a second ago while studying for that APCS final you have on Thursday?\n ";
		  
		  p += "*.... \n";
		  p += "*Do you remember your name? (Please enter below)*";
		 
		  printStory(p);
		  
		  // if user doesn't enter a name
		  while (name.equals("")) {
		  	System.out.println("Please type in your name:");
		      	try {
			  		name = in.readLine();
		      	}
		      	catch (IOException e) {
		      }
		  }
		  
		  //creates new player
		  _you = new Player(name);
		   
		  //resets p
		  
		  p = "*....\n ";
		  p += "*.........\n ";
		  p += "*Cries of birds are heard above you.\n ";
		  p += "*Well. The fact that you still have a test to study for doesn't change, and you've procrastinated an awful lot so let's try to get you back home to finish studying, shall we?\n ";
	     
		  p += "*....\n ";
		  p += "*........\n ";
		  p += "*You try to move your body, but your strength seems somewhat depleted. As you hoist yourself up, you realize one thing:\n ";
		  p += "*You're not human.\n ";
	     
		  p += "*============================ \n";
		  p += "*It seems like you've already established your goal. \n";
		  p += "*Time is running out, and you feel that you only have a little bit of time left before you can revert back to a human. \n";
		  p += "*\n";
		  p += "*You look up ahead and see a glimpse of sunlight behind an opening of a cave.\n ";
		  p += "*Maybe if you travel to the other side, you'll be able to get some help.\n ";
		  p += "*Well " + name + ", shall we advance? \n";
		  p += "*...\n*";
		  
		  printStory(p);
		  
		  p = "*Welcome to the world of Pokemon Mystery Dungeon, " + name + "! \n";
		  p += "*" + name + ", this is your first dungeon. Here is a quick tutorial on how to play this game: \n*";
		  printStory(p);
		  tutorial(); //this prints out the tutorial
		 
		  
		  //GAME STARTS================================== 
		  winGame = play(_you, name); // play the dungeons
		  
		  // GAME ENDS===================================
		  if (winGame){
		  	String win = "";
		  	win += "*Well, would you look at that, " + _you.getName() + ". \n";
		  	win += "*You successfully cleared all three dungeons and managed to make it out alive! \n";
		  	win += "*...\n";
		  	win += "*Birds chirp happily behind you. \n";
		  	win += "*...\n";
		  	win += "*Up ahead is the portal for you to turn back into a human. \n";
		  	win += "*You jump into the portal, and soon find yourself laying on your bed with your APCS notes by your side. \n";
		  	win += "*Congratulations for winning the game!\n*";
		  	printStory(win);
		  }
		  else System.out.println("Unfortunately, you've fainted midway. Time passes by. I'm sorry, but you cannot become a human once again.\nGAME OVER\n");
		  

    }




    // Play the 3 dungeons
    public boolean play(Player _you, String name) {
    	while (_you.isAlive()) {
		  	boolean win = false;
		  	d1 = new Map_Level1();
		  	System.out.println("\nYou are in Dungeon #1! [EASY-PEASY]");
		  	win = launchDungeon(d1, name);
		  	if (win) {
		  		d2 = new Map_Level2();
		  		System.out.println("\nYou are in Dungeon #2! [A LIL HARDER]");
		  		win = launchDungeon(d2, name);
		  		if (win) {
		  			d3 = new Map_Level3();
		  			System.out.println("\nYou are in Dungeon #3! [DIFFICULT]");
		  			win = launchDungeon(d3, name);
		  				if (win) {
		  					return win;
		  				}
		  			}
		  		}
		  	break;
		  }
		  return false;
    }
    
    // Creates map 
    // Returns if the user completed the dungeon
    // Takes the int level of the dungeon selected
    // true: user has reached the stairs
    // false: user has quit 
    public boolean launchDungeon(Map a, String name) {
      	boolean cont = true;
		String t = "";
		String input = "";
		String border = "* * * * * * * \n";
    	String sep = "-------------------------------------------------------\n";
		System.out.println("Your objective: Find the flight of stairs and escape. \n");
    
		while (cont) {
			/*
			t = "********************************************************\n";
			t += "********************************************************\n";
			t += "********************************************************\n";
			*/
			t = sep + t.substring(t.indexOf("&")+1, t.length());
		    t += name + "(LVL. " + _you.getLvl() + ") | " + "HP: " + _you.getHP() + "/" + _you.getTotalHP() +"\n"; // CELINE
		    t += "Enter a letter/word: \n";
		    t += "w - UP \n";
		    t += "a - LEFT \n";
		    t += "s - DOWN \n";
		    t += "d - RIGHT \n\n";
		    
		    t += "1 - View Info \n";
		    t += "2 - View Stats \n";
		    t += "3 - View Bag \n"; 
		    t += "4 - HELP \n";
		    t += "5 - QUIT GAME\n"; 
		    
	
		    t += "Dungeon Map: \n";
		    if (a.getRowL() == 5) border = "* * * * * * * * * *\n";
		    if (a.getRowL() == 8) border = " * * * * * * * * * * * * * *\n";
		    t += border;
		    t += a;
		    t += border;
		    System.out.println(t);
	        t += "&";
	        
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
						chanceOfRoom(_you, a);
						if (!_you.isAlive()) cont = false;
				    }
				}
					else 
				    	t += "ERROR: INVALID MOVEMENT\n" + sep; 
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
						chanceOfRoom(_you, a);
						if (!_you.isAlive()) cont = false;
				    }
				}
					else 
				    	t += "ERROR: INVALID MOVEMENT\n" + sep;  
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
						chanceOfRoom(_you, a);
						if (!_you.isAlive()) cont = false;
				    }
				}
					else 
						t += "ERROR: INVALID MOVEMENT\n" + sep; 
		    }
	
		    // RIGHT
		    else if (input.equals("d") || input.equals("D")) {
				if (a.getY() + 1 < a.getRowL()) {
				    if (a.getTileFace(a.getX(), a.getY()+1).equals("@")) {
						t += "\n\nThis path is blocked by an obstacle.\n";
						a.setTileFace(a.getX(), a.getY()+1);
				    }
				    else {
						a.setY(a.getY() + 1);
						a.setTileFace(a.getX(), a.getY());
						chanceOfRoom(_you, a);
						if (!_you.isAlive()) cont = false;
				    }
				}
					else 
				    	t += "ERROR: INVALID MOVEMENT\n" + sep; 
		    }
		    
		    //1 : VIEW INFO
		    else if (input.equals("1")) {
		    	String n = _you.info();
		    	t += n;
		    }
		    
		  	//2 : VIEW STATS
		    else if (input.equals("2")) {
		    	String n = _you.viewStats();
		    	t += n;
		    }
		    
		    //3 : VIEW BAG
		    else if (input.equals ("3")) {
		    	String n = _you.bag();
		    	t += "Bag: \n";
		    	t += n;
		    }
		    else if (input.equals("4")) {
				t = "\n\nHELP: \n";
				t += "The 'X' represents YOUR position. \n";
				t +="The '*' represents the dungeon's borders. \n";
				t += "The 'O' represents areas already explored. \n";
				t += "The '@' represents impassable obstacles. \n\n";
		    }
	      
		    else if (input.equals("5")) {
		    	String ans = "";
		    	/*
		    	ans += "What's this? Tired already? \n*";
		    	ans += "*We're almost there, but I suppose... \n";
		    	ans += "*If you want to rest now, time may run out and you will not be able to transform back to human.\n";
		    	ans += "*---";
		    	ans += "*Are you sure you want to quit? All game data will be lost if you quit.*";
		    	*/
		    	printStory(ans);
		    	System.out.println("Enter 'y' or 'n' \n"); 
		    	try {
	    			ans = in.readLine();
				}
				catch ( IOException e ) { }
				if (ans.equals("Y") || ans.equals("y")) 
					cont = false;
				else if (ans.equals("N") || ans.equals("n")) 
					System.out.println(""); // HERE TOO
				else
					System.out.println("***ERROR: INVALID ACTION***");
		    }
		    
		    if ((a.getTileFace(a.getX(), a.getY())).equals("^")) {
				cont = false;
				return true;
		    }
		    
		}
		return false;
    }

	
    public static void main(String[] args) {
		GameApp myGame = new GameApp();
    }
}
