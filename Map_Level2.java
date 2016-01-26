public class Map_Level2 extends Map {
    
    public Map_Level2() {
	super();
	setMap(new Tile [5][5]);
	String [][] a = {
	    {"O","@","O","O", "O"},
	    {"O","O","@","O", "O"},
	    {"O","O","@","@", "O"},
	    {"O","O","@","@", "O"},
	    {"@","O","O","O", "O"},
	};
	setStringMap(a);
	setStairs();
	for (int i = 0; i < 5; i++) {
	    for (int j = 0; j < 5; j++) 
		setTile(i, j);
	}
    }
  
    public static void main(String[] args) {
	Map_Level1 a = new Map_Level1();
	System.out.println(a);
    }    
}
