public class Tile {
  private int _x;
  private int _y;
  private String _face;
  private boolean _shown;
  
  //O(1)
  public Tile(int x, int y, String face) {
    _x = x;
    _y = y;
    _face = face;
    _shown = false;
    if (_x == 0 && _y == 0) _shown = true;
  }
  
  //O(1)
  public int getX() {
    return _x;
  }
  
  //O(1)
  public int getY() {
    return _y;
  }
  
  //O(1)
  public boolean isShown() {
    return _shown;
  }
  
  //O(1)
  public String getFace() {
    return _face;
  }
  
  //O(1)
  public void turnFace() {
    _shown = true;
  }
    
}