package edu.sandwichproductions;

import GUI.StartingMenuGUI;


import javax.swing.*;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new StartingMenuGUI();
			}
		});

	}
}
