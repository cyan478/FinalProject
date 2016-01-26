import java.util.ArrayList;
import java.util.List;

public class Player extends Character implements PlayerInt{
    
    private ArrayList<String> _bag;
    
    public Player(String name){
	super(name);
	
	_bag = new ArrayList<String>();
	_bag.add("Oran berry");
	
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
	ret += "You are now level "+ (l+1) + "! \n";
	ret += "The following stats have increased: \n";
	ret += "- - - - - - - - - - - - - - - - - - \n";
	ret += "Health: +" +h+ "\n";
	ret += "Attack Value: +" +a+ "\n";
	ret += "Defense Value: +" +d+ "\n";
	ret += "- - - - - - - - - - - - - - - - - - \n";
	ret += "You need " + getEXP() +" to level up to level " + (getLvl()+1) +"! \n";
        return ret;
    }

    //RUNNING AWAY (Overriding Abstract Method in Character.java)
    public boolean RunAway(int opplvl){
    	return (getLvl() >= opplvl+3);
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
		removeFromBag("Gummy");
	    }
	}

	if (item == "Oran Berry"){
	    if (ghp == gthp)
		System.out.println(fullHealth);
	    else{
		setHP(ghp+20);
		System.out.println(itemResponse("Oran Berry",20));
		removeFromBag("Oran Berry");
	    }
	}

	if (item == "Golden Apple"){
	    if (ghp == gthp)
			System.out.println(fullHealth);
	    else{
			setHP(gthp);
	        System.out.println(itemResponse("Gummy",gthp-ghp));
	        removeFromBag("Golden Apple");
	    }
	}

	if (item == "Rare Candy"){
	    int lvlup = glvl + 1;
	    setLvl(lvlup);
	    String ret =  "After eating the Rare Candy, ";
	    System.out.print(ret);
	    update(gexp);
	    removeFromBag("Rare Candy");
	}

	if (item == "Protein"){
	    setAtk(gatk + 2);
	    System.out.println("After consuming the Protein, you gained 2 Attack Points! \n");
	    removeFromBag("Protein");
	}

	if (item == "Zinc"){
	    setDef(gdef + 2);
	    System.out.println("After consuming the Zinc, you gained 2 Defense Points! \n");
	    removeFromBag("Zinc");
	}

	if (item == "Reviver Seed"){
	    System.out.println("You cannot use this item -- this item only activates when you have fainted in a battle. \n");
	}
    }

    public String itemResponse(String item,int num){
        return "After eating the " + item + ", you gained back " + num + " HP! \n";
    }
    //===============================================================================================

	//REVIVER SEED IN BAG?
	public boolean searchBag(String item){
		return _bag.contains(item);
	}
	
	public void removeFromBag(String item){
		_bag.remove(item);
	}
	
	
	//Putting item in bag.
	public void addItem(String n){
		_bag.add(n);
	}
    

    //Viewing your own info
    //=======================

    public String bag(){
		String ret = "";
		ret += "------------------------------------------\n";
		ret += "Items in your bag: \n";
		for (String x : _bag){
	    	ret += x + "\n";
		}
	ret += "------------------------------------------\n";
	return ret;
    }
 

    public String info(){
	String ret = "";
	ret += "------------------------------------------\n";
	ret += "Info: \n";
	ret += "Name: " + getName() +"\n";
	ret += "Level: " + getLvl() +"\n";
	ret += "------------------------------------------\n";
	return ret;
    }
    
    public String viewStats(){
	String ret = "";
	ret += "------------------------------------------\n";
	ret += "Stats: \n";
	ret += "Total Health: " + getTotalHP() +"\n";
        ret += "Health Right Now: " + getHP() +"\n"; 
	ret += "Attack: " + getAtk() +"\n";
	ret += "Defense: " + getDef() +"\n";
	ret += "Total EXP: " + getEXP() +"\n";
	ret += "EXP Needed to Level Up: " + (getEXP()-getCurrentEXP()) +"\n";
	ret += "------------------------------------------\n";
	return ret;
    }





} //end
