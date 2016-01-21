public class Player extends Character{
    
    private ArrayList<String> bag;
    
    public Player(String name){
	super(name);
	
	bag = new ArrayList<string>();
	bag.add("Oran berry");
	
    }
    
    //Update Character
    //===============
    //gainEXP(x) -> if _exp+=exp > _exp limit, levelUp()
    public void Update(int exp){
	gainEXP(exp);
	if (this._currentexp >= this._exp){
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
    	int h,a,d;
    	h = (int)(Math.random() * 10);
    	a = (int)(Math.random() *5);
    	d = (int)(Math.random() *5);
    	
    	_hp += h;
    	_atk += a;
    	_def += d;
    	_level += 1;
    }
    
    




} //end
