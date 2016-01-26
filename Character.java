public abstract class Character{
    
    private int _totalhp; //hp limit
    private int _hp; //current hp
    private int _atk;
    private int _def;
    //private int _speed;
    private int _exp;
    private int _currentexp;
    private int _level;
    private String _name;

    //O(1)
    //Constructor
    //===========
    //used for creating player
    public Character(String name){
	_name = name;
	_totalhp = 50;
	_hp = _totalhp; //full health
	_atk = 13;
	_def = 13;
	_exp = 50;
	_currentexp = 0;
	_level = 5;
    }
    
    //O(1)
    //mainly used for opponents 
    public Character(String name, int totalhp, int atk, int def, int lvl, int exp){
	_name = name;
	_totalhp = totalhp;
	_hp = _totalhp;
	_atk = atk;
	_def = def;
	_exp = exp;
	_level = lvl;
    }
    
    //O(1)
    //accessors========================================
    public int getTotalHP(){
	return _totalhp;
    }
    
    //O(1)
    public int getHP(){
	if (_hp <= 0) return 0;
	return _hp;
    }

    //O(1)
    public int getAtk(){
	return _atk;
    }
    
    //O(1)
    public int getDef(){
	return _def;
    }

    //O(1)
    public int getEXP(){
	return _exp;
    }

    //O(1)
    public int getCurrentEXP(){
	return _currentexp;
    }
    
    //O(1)
    public int getLvl(){
	return _level;
    }

    //O(1)
    public String getName(){
	return _name;
    }
    //================================================

    //mutators========================================
    //O(1)
    public void setTotalHP(int x){
	_totalhp = x;
    }
    
    //O(1)
    public void setHP(int x){
	if (_hp <= 0) _hp = 0;
        _hp = x;
    }

    //O(1)
    public void setAtk(int x){
        _atk = x;
    }
    
    //O(1)
    public void setDef(int x){
        _def = x;
    }

    //O(1)
    public void setEXP(int x){
        _exp = x;
    }

    //O(1)
    public void setCurrentEXP(int x){
        _currentexp = x;
    }
    
    //O(1)
    public void setLvl(int x){
        _level = x;
    }
    //================================================

    //O(1)
    public boolean isAlive(){
	if (_hp <= 0)
	    return false;
	return true;
    }
    
    //O(1)
    //Crit
    //=====
    //aka random roll
    //calculates if player gets a crit (gives more power in method attack(n))
    public int crit(){
    	int critical = _level;
    	int r = (int)(Math.random() * 21); //0.05% chance
    	if (r == 16) return 2*critical; //16 is a random number
    	return critical;
    }

    //O(1)
    //Attacking Algortihm
    //====================
    //(pokemon) algorithm inspired by 
    //https://www.math.miami.edu/~jam/azure/compendium/battdam.htm 
    public int attack(int oppDef){
    	int A = crit(); //attacker's level / whether critical hit is considered
    	int B = getAtk(); //attacker's atk power
    	int C = oppDef; //opponent's def power
    	int Y = 40; //constant
    	int Z = ((int)(Math.random() * 39)) + 200; //random roll
    	return ((((((((2*A/5+2)*B*B)/C)/50)+2))*Y/10)*Z)/255;
	}

    //O(1)
    //Taking damage
    //=============
    public void lowerHP(int n){
	_hp -=n;
    }

    ////O(1)
    //ABSTRACT METHOD
    public abstract boolean RunAway(int x);


} //end
