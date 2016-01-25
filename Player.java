import java.util.ArrayList;
import java.util.List;

public class Player extends Character{
    
    private ArrayList<String> _bag;
    
    public Player(String name){
	super(name);
	
	_bag = new ArrayList<String>();
	_bag.add("Oran berry");
	
    }
    
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

    //Update Character
    //===============
    //gainEXP(x) -> if _exp+=exp > _exp limit, levelUp()
    public void update(int exp){
	gainEXP(exp);
	if (getCurrentEXP() >= getEXP()){
	    setCurrentEXP(0);
	    System.out.println(levelUp());
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
    public String levelUp(){
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
	ret += "You are now level "+ getLvl() + "! \n";
	ret += "The following stats have increased: \n";
	ret += "- - - - - - - - - - - - - - - - - -";
	ret += "Health: +" +h+ "\n";
	ret += "Attack Value: +" +a+ "\n";
	ret += "Defense Value: +" +d+ "\n";
	ret += "- - - - - - - - - - - - - - - - - -";
	ret += "You need " + getEXP() +" to level up to level " + getLvl()+1 +"! \n";
        return ret;
    }

    //ITEM USAGE ======================================================================================
    public void CheckUseItem(String item){
	if (_bag.isEmpty())
	    System.out.println("Your bag is empty.\n");
	else if (!_bag.contains(item))
	    System.out.println("The requested item cannot be found. (Reminder: items are case-sensitive)\n");
       else{
	   useItem(item);
       }
    }

    public void useItem(String item){
	int ghp = getHP();
	int gthp = getTotalHP();
	int glvl = getLvl();
	int gexp = getEXP();
	int gatk = getAtk();
	int gdef = getDef();
	String fullHealth = "You have full health. Better off saving this item when you've lost some HP first. \n";
	
	if (item == "Gummy"){
	    if (ghp == gthp)
		System.out.println(fullHealth);
	    else{
		setHP(ghp+5);
		System.out.println(itemResponse("Gummy",5));
	    }
	}

	if (item == "Oran Berry"){
	    if (ghp == gthp)
		System.out.println(fullHealth);
	    else{
		setHP(ghp+20);
		System.out.println(itemResponse("Oran Berry",20));
	    }
	}

	if (item == "Golden Apple"){
	    if (ghp == gthp)
		System.out.println(fullHealth);
	    else{
		setHP(gthp);
	        System.out.println(itemResponse("Gummy",gthp-ghp));
	    }
	}

	if (item == "Rare Candy"){
	    int lvlup = glvl + 1;
	    setLvl(lvlup);
	    String ret =  "After eating the Rare Candy, ";
	    System.out.print(ret);
	    update(gexp);
	}

	if (item == "Protein"){
	    setAtk(gatk + 2);
	    System.out.println("After consuming the Protein, you gained 2 Attack Points! \n");
	}

	if (item == "Zinc"){
	    setDef(gdef + 2);
	    System.out.println("After consuming the Zinc, you gained 2 Defense Points! \n");
	}
    }

    public String itemResponse(String item,int num){
        return "After eating the " + item + ", you gained back " + num + " HP! \n";
    }
    //===============================================================================================

    
    //Viewing your own info
    //=======================
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
