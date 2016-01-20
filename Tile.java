public class Tile {
  private int _x;
  private int _y;
  private String _face;
  private boolean _shown;
  
  public Tile(int x, int y, String face) {
    _x = x;
    _y = y;
    _face = face;
    _shown = false;
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
    
}