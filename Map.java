public class Map {
    private Object[][] _map;
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
		else printedMap += " " + _map[x][y] + " ";
	    }
	    printedMap += "\n";
	}
	return printedMap;
    }
}
