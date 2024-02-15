package org.example.Controller;

import org.example.Model.*;
import org.example.View.Menu;
import org.example.View.MyIO;
import org.example.View.UserChoice;

public class BinaryTreeController {
    private MyIO io = new MyIO();
    private int selection;
    private String characterName;
    private Node root = new Node("You're leaving a bustling town, eager to explore the forest beyond. " +
            "As you set out on your journey, you come across your first decision point." +
            "Follow the well-worn path deeper into the forest." +
            "Ascend the winding mountain path." +
            "Descend into the valley where the mountain town awaits.", null);
    private Node forestStart = new Node("While walking inside the lush forest" +
            "You hear rustling in the bushes. Investigate the source of the noise." +
            "Notice strange markings on the trees. Investigate further." +
            "Take a moment to admire the beauty of the forest.", null);
    private Node forest1 = new Node("When getting closer" +
            "Encounter a wounded animal. Choose to help it." +
            " Discover a hidden cache of supplies." +
            " Ignore the noise and continue on your path.", null);
    private Node forestEnd;
    private Node mountainStart = new Node("While scaling the rigged path" +
            "Encounter a treacherous cliff. Decide whether to climb or find an alternate route." +
            "Hear a distant roar echoing from higher up the mountain. Investigate." +
            "Notice peculiar rock formations along the way. Examine them closely.", null);
    private Node mountian1 = new Node("While trying to scale the cliff" +
            "Successfully navigate the cliff and reach the summit." +
            "Discover a hidden cave system while searching for a safer route." +
            "Choose to turn back and find a different path up the mountain.", null);
    private Node mountainEnd;
    private Node townStart = new Node("You arrive to the town then" +
            "Arrive at the town gates and seek entry." +
            "Explore the outskirts of the town, searching for information or resources." +
            "Follow the main road directly into the heart of the town.", null);
    private Node town1 = new Node("While entering the town you decide" +
            "Encounter a guard who challenges you to prove your worth before granting entry." +
            "Find a hidden passage that bypasses the town gates." +
            "Choose to wait until nightfall to sneak into the town unnoticed.", null);
    private Node townEnd;

    public BinaryTreeController() {
        createPath();
    }

    public Player startPath() {
        choices();
        return root.data;
    }

    public void choices() {
        while (root != forestEnd && root != mountainEnd && root != townEnd) {
            selection = io.intInput(root.prompt);
            switch (selection) {
                case 1 -> root = root.left;
                case 2 -> root = root.center;
                case 3 -> root = root.right;
            }
            endOfPath();
        }
    }

    public void endOfPath() {
        if (root == forestEnd || root == mountainEnd || root == townEnd) {
            characterName = io.stringInput("Enter name");
            if (root == forestEnd) {
                root = forestEnd = new Node("you are a mage", new Mage(characterName));
            } else if (root == mountainEnd) {
                root = mountainEnd = new Node(null, new Paladin(characterName));
            } else if (root == townEnd) {
                root = townEnd = new Node(null, new Barbarian(characterName));
            }

        }
    }

    public void createPath() {
        root.left = forestStart;
        root.center = mountainStart;
        root.right = townStart;
        forestStart.left = forestEnd;
        forestStart.center = forestEnd;
        forestStart.right = forestEnd;
        mountainStart.left = mountainEnd;
        mountainStart.center = mountainEnd;
        mountainStart.right = mountainEnd;
        townStart.left = townEnd;
        townStart.center = townEnd;
        townStart.right = townEnd;
    }
}
