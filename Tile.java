public class Tile {
  private int _x;
  private int _y;
  private String _face;
  private boolean _shown;
  
  public Tile(int x, int y, String face) {
    _x = x;
    _y = y;
    _face = face;
    _shown = true;
    if (_x == 0 && _y == 0) _shown = true;
  }
  
  public int getX() {
    return _x;
  }
  
  public int getY() {
    return _y;
  }
  
  public boolean isShown() {
    return _shown;
  }
  
  public String getFace() {
    return _face;
  }
  
  public void turnFace() {
    _shown = true;
  }
    
}