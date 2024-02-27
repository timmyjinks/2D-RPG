package edu.sandwichproductions;

import edu.sandwichproductions.GUI.GameOverGUI;
import edu.sandwichproductions.GUI.StartingMenuGUI;
import edu.sandwichproductions.controller.PlayerStatus;

public class DesktopLauncher extends StartingMenuGUI {
	public static void main (String[] arg) {
		boolean count = false;
		do {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				System.out.println("Andrew is the ");
			}
			if (PlayerStatus.getStatus()) {
				PlayerStatus.setStatus(false);
				new GameOverGUI();
				System.out.println("is dead"); // TODO erase
			}
			if (!count) {
				new StartingMenuGUI();
				count = true;
			}
		} while (count);
	}
}
