package edu.sandwichproductions;

import edu.sandwichproductions.GUI.GameOverGUI;
import edu.sandwichproductions.GUI.Musix;
import edu.sandwichproductions.GUI.StartingMenuGUI;
import edu.sandwichproductions.util.GameStatus;

public class DesktopLauncher extends StartingMenuGUI {
	public static void main (String[] arg) {
		Thread applicationThread = new Thread(() -> {
			try {
				Musix musix = new Musix();
				musix.playAudio();
			} catch (Exception e) {
				System.out.println("Oh no");
			}
		});


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
