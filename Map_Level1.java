public class Map_Level1 extends Map {
  
  public Map_Level1() {
    
    super();
    setMap(new Tile [3][3]);
    String [][] a = {
      {"O","O","O"},
      {"O","O","O"},
      {"O","O","O"}
    };
    setStringMap(a);
    setStairs();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) 
        setTile(i, j);
    }
  }
  
  public static void main(String[] args) {
    Map_Level1 a = new Map_Level1();
    System.out.println(a);
  }
}