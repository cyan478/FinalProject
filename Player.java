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
    }
    
    




} //end
