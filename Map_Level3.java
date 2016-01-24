public class Map_Level3 extends Map {
    
    public Map_Level3() {
	super();
	setMap(new Tile [5][8]);
	String [][] a = {
	    {"O","O","O","O","^","@","@","O"},
	    {"@","@","O","@","@","O","O","O"},
	    {"@","@","O","O","@","O","O","O"},
	    {"@","O","O","O","O","O","@","O"},
	    {"@","@","O","O","O","@","@","@"},
	};
	setStringMap(a);
	for (int i = 0; i < 5; i++) {
	    for (int j = 0; j < 8; j++) 
		setTile(i, j);
	}
    }
  
    public static void main(String[] args) {
	Map_Level1 a = new Map_Level1();
	System.out.println(a);
    }    
}
