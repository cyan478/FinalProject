public class Opponent extends Character{

    private static final String[] pokemon = {"Zubat","Geodude", "Meowth","Poochyena","Marill","Lapras"};
    
    //O(1)
    public Opponent(String name, int totalhp, int atk, int def, int lvl, int exp) {
        super(name,totalhp,atk,def,lvl,exp);
    }
    
    //O(1)
    //Calculates chances of running away: only 15% chance that it will only if opponent's level is lower than player's level-5
    public boolean RunAway(int playerLvl){
	if (getLvl() < playerLvl - 5){
	    int r = (int)(Math.random() * 100);
	    return (r <= 15);
	}
	return false;
    }

    
} //end
