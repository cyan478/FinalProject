public class Map_Level1 extends Map {
  
  public Map_Level1() {
    
    super();
    
    for (int i = 0; i < _stringMap.length; i++) {
      for (int j = 0; j < _stringMap[i].length; j++) {
        this._map[i][j] = new Tile(i, j, _stringMap[i][j]);
      }
    }
  }
  
  public static void main(String[] args) {
    Map_Level1 a = new Map_Level1();
    System.out.println(a);
  }
}
