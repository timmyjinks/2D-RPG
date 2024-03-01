package edu.sandwichproductions;

import edu.sandwichproductions.GUI.GameOverGUI;
import edu.sandwichproductions.GUI.StartingMenuGUI;
import edu.sandwichproductions.controller.GameStatus;

public class DesktopLauncher extends StartingMenuGUI {
	public static void main (String[] arg) {
		new StartingMenuGUI();
		while (GameStatus.getGameStatus()) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				System.out.println("Error thread sleep");
			}
			if (!GameStatus.getPlayerStatus()) {
				GameStatus.setPlayerStatus(true);
				new GameOverGUI();
			}
		}
	}
}
