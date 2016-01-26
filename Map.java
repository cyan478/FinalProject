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
	    printedMap += "* ";
	    for (int x = 0; x < _map[y].length; x++) {
		if ((x == _y) && (y == _x))
		    printedMap += " X ";
		else if (_map[y][x].isShown())
		    printedMap += " " + _map[y][x].getFace() + " ";
		else 
		    printedMap += "   ";
	    }
	    printedMap += " * \n";
	}
    
	return printedMap;
    }
  
    // setters 
    public void setX(int x) {
	_x = x;
    }
  
    public void setY(int y) {
	_y = y;
    }
  
    public void setMap(Tile[][] a) {
	_map = a;
    }
  
    public void setStringMap(String[][] a) {
	_stringMap = a;
    }
  
    public void setTile(int x, int y) {
	_map[x][y] = new Tile(x, y, _stringMap[x][y]);
    }
  
    public void setTileFace(int x, int y) {
	_map[x][y].turnFace();
    }

    public void setStairs() {
	int randomX = randomX = (int)(Math.random()*_stringMap.length);
	int randomY = (int)(Math.random()*_stringMap[0].length);
	while ((_stringMap[randomX][randomY].equals("@") ||
	       (randomX == 0 && randomY == 0)) ||
	       ((randomY == 0) || (randomY == 1))) {
	    randomX = randomX = (int)(Math.random()*_stringMap.length);
	    randomY = (int)(Math.random()*_stringMap[0].length);
	}
	_stringMap[randomX][randomY] = "^";
    }
  
    // accessors
  
    public String[][] getStringMap() {
	return _stringMap;
    }
  
    public Tile[][] getMap() {
	return _map;
    }
  
    public String getTileFace(int x, int y) {
	return _map[x][y].getFace();
    }
  
    public int getX() {
	return _x;
    }
  
    public int getY() {
	return _y;
    }
    public int getColumnL() {
	return _map.length;
    }

    public int getRowL() {
	return _map[0].length;
    }
}
