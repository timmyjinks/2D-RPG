package org.example.view;


public class UserChoice {
    MyIO io = new MyIO();
    public String prompt(String prompt, String path1, String path2, String path3){
        return prompt + "\n 1: " + path1 +"\n 2: "+ path2 + "\n 3: "+ path3;
    }


    public String start(){
        return io.stringInput(prompt("You're leaving a bustling town, eager to explore the forest beyond. " +
                        "As you set out on your journey, you come across your first decision point.",
                "Follow the well-worn path deeper into the forest.",
                "Ascend the winding mountain path.",
                "Descend into the valley where the mountain town awaits."));
    }
    public String Forest(){
        return io.stringInput(prompt("While walking inside the lush forest",
                "You hear rustling in the bushes. Investigate the source of the noise.",
                "Notice strange markings on the trees. Investigate further.",
                "Take a moment to admire the beauty of the forest."));
    }
    public String Forest1(){
        return io.stringInput(prompt("When getting closer",
                "Encounter a wounded animal. Choose to help it.",
                " Discover a hidden cache of supplies.",
                " Ignore the noise and continue on your path."));
    }
    public String Forest2(){
        return io.stringInput(prompt("When looking at the marks on the tree",
                " Find a secret passage leading deeper into the forest.",
                " Encounter a group of bandits hiding in ambush.",
                "Decide to mark the trees yourself and continue on your path."));
    }
    public String Forest3(){
        return io.stringInput(prompt("Feeling intune with nature.",
                "Discover a hidden grove with a serene atmosphere.",
                "Encounter a friendly woodland creature willing to guide you.",
                "Meditate to attune yourself to the natural energies of the forest."));
    }
    public String Mountain(){
        return io.stringInput(prompt("While scaling the rigged path",
                "Encounter a treacherous cliff. Decide whether to climb or find an alternate route.",
                "Hear a distant roar echoing from higher up the mountain. Investigate.",
                "Notice peculiar rock formations along the way. Examine them closely."));
    }
    public String Mountain1(){
        return io.stringInput(prompt("While trying to scale the cliff",
                "Successfully navigate the cliff and reach the summit.",
                "Discover a hidden cave system while searching for a safer route.",
                "Choose to turn back and find a different path up the mountain."));
    }
    public String Mountain2(){
        return io.stringInput(prompt("Moving up the mountain",
                "Encounter a fearsome dragon guarding its territory.",
                "Find a group of adventurers in need of assistance.",
                "Decide to avoid the potential danger and continue on your path."));
    }
    public String Mountain3(){
        return io.stringInput(prompt("While studying the rock form",
                "Discover ancient cave paintings depicting forgotten legends.",
                "Stumble upon a hidden shrine dedicated to a long-forgotten deity.",
                "Choose to bypass the rock formations and focus on reaching the summit."));
    }


    public String Town(){
        return io.stringInput(prompt("You arrive to the town then",
                "Arrive at the town gates and seek entry.",
                "Explore the outskirts of the town, searching for information or resources.",
                "Follow the main road directly into the heart of the town."));
    }
    public String Town1(){
        return io.stringInput(prompt("While entering the town you decide",
                "Encounter a guard who challenges you to prove your worth before granting entry.",
                "Find a hidden passage that bypasses the town gates.",
                "Choose to wait until nightfall to sneak into the town unnoticed."));
    }
    public String Town2(){
        return io.stringInput(prompt("When you looking around the outskirt",
                "Encounter a group of townsfolk in need of assistance.",
                "Find a local tavern where rumors and secrets are exchanged.",
                "Decide to observe the town from a distance before making your next move"));
    }
    public String Town3(){
        return io.stringInput(prompt("The town is thriving with life.",
                "Witness a festival or celebration taking place in the town square.",
                "Encounter a powerful figure who holds sway over the town's inhabitants.",
                "Choose to approach the town's leadership and offer your services."));
    }


    public String pressAhead(){
        return io.stringInput("Press e to continue");
    }










    //<><><><><><><><><><><><><><><><><<><><><><><><><><><><><>><><><


    public void Barbarian(){
        classSout("Barbarian", "A fierce warrior of primitive background who can enter a battle rage");
    }
    public void Bard(){
        classSout("Bard","An inspiring magician whose power echoes the music of creation");
    }
    public void Cleric(){
        classSout("Cleric","A priestly champion who wields divine magic in service of a higher power");
    }
    public void Druid(){
        classSout("Druid","A priest of the Old Faith, wielding the powers of nature — moonlight and plant growth, fire and lightning — and adopting animal forms");
    }
    public void Wizard(){
        classSout("Wizard","A scholarly magic-user capable of manipulating the structures of reality");
    }
    public void Monk(){
        classSout("Monk","A master of martial arts, harnessing the power of the body in pursuit of physical and spiritual perfection");
    }
    public void Paladin(){
        classSout("Paladin","A holy warrior bound to a sacred oath");
    }
    public void Warlock(){
        classSout("Warlock","A wielder of magic that is derived from a bargain with an extraplanar entity");
    }
    public void Rogue(){
        classSout("Rouge","A scoundrel who uses stealth and trickery to overcome obstacles and enemies");
    }
    public void classSout(String className, String prompt){
        System.out.println("Based on your path... Class " + className + " : \n" + prompt);
    }
}

