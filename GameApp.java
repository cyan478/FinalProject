import java.io.*;
import java.util.*;

public class GameApp {

    public GameApp {
	ISR = new InputStreamReader(System.in);
	textIn = new BufferedReader(isr);
	newGame(); 
    }

    public void newGame() {
	name = in.readLine();
	print(name);
    }

    public static void main(String[] args) {
	GameApp myGame = new GameApp();
    }
}
