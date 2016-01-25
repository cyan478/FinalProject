public class Opponent extends Character{

    private static final String[] pokemon = {"Zubat","Geodude", "Meowth","Poochyena","Marill","Lapras"};
    
    public Opponent(String name) {
        super(name);
    }

    //Calculates chances of running away: only 15% chance that it will only if opponent's level is lower than player's level-5
    public boolean  RunAway(int playerLvl){
	if (getLvl() < playerLvl - 5){
	    int r = (int)(Math.random() * 100);
	    return (r <= 15);
	}
    }

    
    /*
    Stats:
                   lvl*10   lvl*5/2  atk   
    Pokemon level totalhp   atk      def    exp
    -----------------------------------------------
    Zubat    3-8    30-80   8-20    8-20
    Geodude  4-9    40-90   10-23  
    Meowth   7-12   70-120  18-30 
    Poochyena 8-13  80-130  20-38
    Marill   12-17  120-170 30-43 
    Lapras   13-18  130-180 33-45

//BATTLING SCHEME

    private Player _you = new Player(name);


    String name = ;
    int lvl = (int)(Math.random() * 6) + 3; //lvl 3-8
    private Opponent _opp = new Opponent(name, lvl*10, lvl*5/2+1, lvl*5/2+1, lvl, lvl*5/2);

    while (_you.isAlive() && _opp.isAlive()){
    -if(_opp.RunAway()) 
    System.out.println(_opp.getName() + " ran away from the battle!");
    break//
    -player attacks
    -opponent loses hp
    -opponent attacks
    -player loses hp
    
    if(!_opp.isAlive()){
    _you.update(_opp.getEXP());
    System.out.println(_opp.getName() + " fainted!");
    
    else if (!_you.isAlive()){
    //if bag contains reviver seed, activate it.
    remove from bag.
    System.out.println("You've been revived by the Reviver Seed in your bag! That really saved your life there, didn't it?")

    else{
    String ret = "";
    ret += "You have fainted! \n";
    ret += "... \n";
    ret += "......... \n";
    ret += "Sorry, " + _you.getName() +". It seems like you cannot progress through the game anymore. \n";
    ret += "As a result, your time to convert back to a human ran out. \n";
    ret += "Your human friends will miss you dearly. \n";
    ret += "As for the APCS final on Thursday, at least you won't have to worry about it anymore, right? \n";
    ret += "... Well, I guess this is the end. \n";
    ret += "--- \n";
    ret += "GAME OVER \n";
    System.out.println(ret);
}

//CHECK YO INFO

1. View Info -- there should be a cancel for each of these options too (?)
2. View Stats
3. View Bag
4. Cancel
    
1)
System.out.println(_you.info());

2) 
System.out.println(_you.viewStats());

3)
System.out.println(_you.bag());

4)
go back?

//ITEMS IN BAG
--there's an item in the room
-- ... , ... , stick, iron barb (useless items i guess)

Chances of encountering each item:
Oran Berry: 15%
Gummy: 15%
Golden Apple: 15%
Rare Candy: 5%
Protein: 10%
Zinc: 10%
Reviver Seed: 5%
Stick: 12%
Iron Barb: 13% 


1. Pick Up --> System.out.println("You picked up the " + item + ".");
2. Leave it --> System.out.println("You left the " + item + "  on the ground.");

//USING AN ITEM
What item would you like to use? Please type it below. *Reminder: Items are case sensitive*
_you.CheckUseItem("blahblah") <- user input

--> if bag is empty
--> if bag doesn't contain item
--> if it does contain, it'll change ur stats and sop info.




    */
    
} //end
