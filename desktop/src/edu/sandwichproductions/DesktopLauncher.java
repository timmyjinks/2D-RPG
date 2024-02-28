package edu.sandwichproductions;

import edu.sandwichproductions.GUI.GameOverGUI;
import edu.sandwichproductions.GUI.StartingMenuGUI;
import edu.sandwichproductions.controller.PlayerStatus;

public class DesktopLauncher extends StartingMenuGUI {
	public static void main (String[] arg) {
		boolean count = true;
		new StartingMenuGUI();
		while (count) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				System.out.println("Error thread sleep");
			}
			if (PlayerStatus.getStatus()) {
				PlayerStatus.setStatus(false);
				new GameOverGUI();
			}
		}
	}
}
