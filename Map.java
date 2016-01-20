import java.util.Arrays;

public class Map {
  private String[][] _stringMap;
  private Tile[][] _map;
  private int _x;
  private int _y;
  
  public Map() {
    _x = 0;
    _y = 0;
  }
  
  public String toString() {
    String printedMap = "";
    for (int y = 0; y < _map.length; y++) {
      for (int x = 0; x < _map[y].length; x++) {
        if ((x == _x) && (y == _y))
          printedMap += " X ";
        else if (_map[y][x].isShown())
          printedMap += _map[y][x].getFace();
        else 
          printedMap += " ";
      }
      printedMap += "\n";
    }
    return printedMap;
  }
  
  public void setMap(Tile[][] a) {
    _map = a;
  }
  
  public void setStringMap(String[][] a) {
    _stringMap = a;
  }
}