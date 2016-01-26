public class Map {
  
    
    private String[][] _stringMap;
    private Tile[][] _map;
    private int _x;
    private int _y;
  
    //O(1)
    public Map() {
	_x = 0;
	_y = 0;
    }
  
    //O(N)
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
  
    //O(1)
    // setters 
    public void setX(int x) {
	_x = x;
    }
    //O(1)
    public void setY(int y) {
	_y = y;
    }
    //O(1)
    public void setMap(Tile[][] a) {
	_map = a;
    }
  //O(1)
    public void setStringMap(String[][] a) {
	_stringMap = a;
    }
  //O(1)
    public void setTile(int x, int y) {
	_map[x][y] = new Tile(x, y, _stringMap[x][y]);
    }
    
  //O(1)
    public void setTileFace(int x, int y) {
	_map[x][y].turnFace();
    }
    //O(1)
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
  //O(1)
    public String[][] getStringMap() {
	return _stringMap;
    }
  //O(1)
    public Tile[][] getMap() {
	return _map;
    }
  //O(1)
    public String getTileFace(int x, int y) {
	return _map[x][y].getFace();
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
    public int getColumnL() {
	return _map.length;
    }
//O(1)
    public int getRowL() {
	return _map[0].length;
    }
    //O(1)
    public int getDungeonNum() {
        if ((_map[0].length) == 3) return 1;
        else if ((_map[0].length) == 5) return 2;
        else return 3;
    }
    
}
