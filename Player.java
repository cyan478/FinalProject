import java.util.ArrayList;
import java.util.List;

public class Player extends Character{
    
    private ArrayList<String> _bag;
    
    public Player(String name){
	super(name);
	
	_bag = new ArrayList<String>();
	_bag.add("Oran berry");
	
    }
    
    //Update Character
    //===============
    //gainEXP(x) -> if _exp+=exp > _exp limit, levelUp()
    public void Update(int exp){
	gainEXP(exp);
	if (getCurrentEXP() >= getEXP()){
	    levelUp();
	    setCurrentEXP(0);
	}
	}

    //Gaining EXP (Experience Points used to level up)
    //===================================================
    public void gainEXP(int exp){
	int curr = getCurrentEXP();
        setCurrentEXP(curr+exp);
    }

    //Leveling up 
    //===========
    public void levelUp(){
    	int h,a,d,ga,gd,l;
	String ret = "";
    	h = getHP() + (int)(Math.random() * 10);
    	a = (int)(Math.random() *5);
    	d = (int)(Math.random() *5);

	ga = getAtk();
	gd = getDef();
	l = getLvl();
    	
        setHP(h);
        setAtk(ga+a);
        setDef(gd+d);
        setLvl(l++);

	ret += "You leveled up! \n";
	ret += "You are now "+ getLvl() + "! \n";
	ret += "The following stats have increased: \n";
	ret += "- - - - - - - - - - - - - - - - - -";
	ret += "Health: +" +h+ "\n";
	ret += "Attack Value: +" +a+ "\n";
	ret += "Defense Value: +" +d+ "\n";
	ret += "- - - - - - - - - - - - - - - - - -";
	ret += "You need " + getEXP() +" to level up to level " + getLvl()+1 +"! \n";
        System.out.println(ret);
    }

    public String bag(){
	String ret = "";
	ret += "Items in your bag: \n";
	for (String x : _bag)
	    ret += x + "\n";
	return ret;
    }

    public String info(){
	String ret = "";
	ret += "Info: \n";
	ret += "Name: " + getName() +"\n";
	ret += "Level: " + getLvl() +"\n";
	return ret;
    }
    
    public String viewStats(){
	String ret = "";
	ret += "Stats: \n";
	ret += "Total Health: " + getTotalHP() +"\n";
        ret += "Health Right Now: " + getHP() +"\n"; 
	ret += "Attack: " + getAtk() +"\n";
	ret += "Defense: " + getDef() +"\n";
	ret += "Total EXP: " + getEXP() +"\n";
	ret += "EXP Needed to Level Up: " + (getEXP()-getCurrentEXP()) +"\n";
	return ret;
    }
    
    




} //end
