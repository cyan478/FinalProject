import java.util.ArrayList;
import java.util.List;

public class Player extends Character{
    
    private ArrayList<String> _bag;
    
    public Player(String name){
	super(name);
	
	_bag = new ArrayList<string>();
	_bag.add("Oran berry");
	
    }
    
    //Update Character
    //===============
    //gainEXP(x) -> if _exp+=exp > _exp limit, levelUp()
    public void Update(int exp){
	gainEXP(exp);
	if (getCurrentEXP() >= getEXP()){
	    levelUp();
	    _currentexp = 0;
	}
	}

    //Gaining EXP (Experience Points used to level up)
    //===================================================
    public void gainEXP(int exp){
	this._currentexp += exp;
    }

    //Leveling up 
    //===========
    public void levelUp(){
    	int h,a,d,l;
    	h = getHP() + (int)(Math.random() * 10);
    	a = (int)(Math.random() *5);
    	d = (int)(Math.random() *5);
	l = getLvl();
    	
        setHP(h);
        setAtk;
    	_def += d;
        setLvl(l++);
    }
    
    




} //end
