public class Map_Level1 extends Map {
  
    public Map_Level1() {
    
	super();
	setMap(new Tile [2][2]);
	String [][] a = {
	    {"O","O"},
	    {"O","^"}
	};
	setStringMap(a);
    
	for (int i = 0; i < 2; i++) {
	    for (int j = 0; j < 2; j++) 
		setTile(i, j);
	}
    }
  
    public static void main(String[] args) {
	Map_Level1 a = new Map_Level1();
	System.out.println(a);
    }
}
