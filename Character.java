public class Character{
    
    private int _totalhp; //hp limit
    private int _hp; //current hp
    private int _atk;
    private int _def;
    //private int _speed;
    private int _exp;
    private int _currentexp;
    private int _level;
    private String _name;

    //Constructor
    //===========
    //used for creating player
    public Character(){
	_totalhp = 10;
	_hp = _totalhp; //full health
	_atk = 5;
	_def = 5;
	_exp = 0;
	_currentexp = 0;
	_level = 1;
    }

    //Overloaded Constructor
    //======================
    //mainly used for opponents 
    public Character(String name, totalhp, atk, def, lvl){
	_name = name;
	_totalhp = totalhp;
	_hp = _totalhp;
	_atk = atk;
	_def = def;
	_exp = -1;
	_level = lvl;
    }

    //accessors========================================
    public int getHP(){
	if (_hp <= 0) return 0;
	return _hp;
    }

    public int getAtk(){
	return _atk;
    }
    
    public int getDef(){
	return _def;
    }

    public int getEXP(){
	return _exp;
    }
    
    public int getLvl(){
	return _level;
    }
    //================================================
    
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

    //Attacking Algortihm
    //====================
    //(pokemon) algorithm inspired by 
    //https://www.math.miami.edu/~jam/azure/compendium/battdam.htm 
    public int attack(int oppDef){
    	int A = crit(); //attacker's level / whether critical hit is considered
    	int B = _atk; //attacker's atk power
    	int C = oppDef; //opponent's def power
    	int Y = 40; //constant
    	int Z = ((int)(Math.random() * 39)) + 200; //random roll
    	return ((((((((2*A/5+2)*B*B)/C)/50)+2))*Y/10)*Z)/255;
	}

    //Taking damage
    //=============
    public void lowerHP(int n){
	_hp -=n;
    }


} //end
