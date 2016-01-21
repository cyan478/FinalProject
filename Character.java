public class Character{
    
    private int _hp;
    private int _atk;
    private int _def;
    //private int _speed;
    private int _exp;
    private int _level;

    public Character(){
	_hp = 10;
	_atk = 5;
	_def = 5;
	_exp = 0;
	_level = 1;
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
    
    //calculates if player gets a crit (gives more power in method attack(n))
    public int crit(){
    	int critical = _level;
    	int r = (int)(Math.random() * 21); //0.05% chance
    	if (r == 16) return 2*critical; //16 is a random number
    	return critical;
    }
    
    //algorithm inspired by https://www.math.miami.edu/~jam/azure/compendium/battdam.htm (pokemon)
    public int attack(int oppDef){
    	int A = crit(); //attacker's level / whether critical hit is considered
    	int B = _atk; //attacker's atk power
    	int C = oppDef; //opponent's def power
    	int Y = 40; //constant
    	int Z = ((int)(Math.random() * 39)) + 200; //random roll
    	return ((((((((2*A/5+2)*B*B)/C)/50)+2))*Y/10)*Z)/255;
	}

    public void lowerHP(int n){
	_hp -=n;
    }
    
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
