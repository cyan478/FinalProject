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
    public getHP{
	if (_hp <= 0) return 0;
	return _hp;
    }

    public getAtk{
	return _atk;
    }
    
    public getDef{
	return _def;
    }

    public getEXP{
	return _exp;
    }
    
    public getLvl{
	return _level;
    }
    //================================================
    
    public int attack(int n){
	...
    }

    public int lowerHP(int n){
	_hp -=n;
    }


} //end
