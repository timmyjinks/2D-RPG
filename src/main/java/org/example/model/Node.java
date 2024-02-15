package org.example.model;

public class Node {
    public Node left;
    public Node center;
    public Node right;
    public String prompt;
    public Player data;

    public Node(String prompt, Player data) {
        this.left = null;
        this.center = null;
        this.right = null;
        this.prompt = prompt;
        this.data = data;
    }
}
