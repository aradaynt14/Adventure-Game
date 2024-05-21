import java.util.Scanner;
import java.util.Random;

public class AdventureGame {
    static Scanner input = new Scanner(System.in);

    public static void fight(String enemyName, int enemyHP, int enemyDg, String enemyWp, Character player) {
        int choice;
        int attack;
        int choiceroll;
        Random dice = new Random();
        printLine();
        System.out.println("Health: " + player.getHealth());
        System.out.println("Potions: " + player.getPotions());
        System.out.println("Enemy Health: " + enemyHP);
        printLine();
        while (enemyHP > 0 && player.getHealth() > 0) {
            System.out.println("What will you do? (1-roll for attack, 2-heal)");
            choice = input.nextInt();
            if (choice == 1) {
                attack = dice.nextInt(20) + player.getdamage();
                System.out.println("You rolled a " + attack);
                if (attack >= 16 && attack <= 19) {
                    System.out.println("You hit the " + enemyName + " for 8 damage (+2 damage) Total: 10 damage");
                    enemyHP = enemyHP - 10;
                    if (enemyHP >= 0) {
                        System.out.println("Enemies Health: " + enemyHP);
                    } else if (enemyHP < 0) {
                        System.out.println("Enemies Health: 0");
                    }
                    printLine();
                } else if (attack >= 11 && attack <= 15) {
                    System.out.println("You hit the " + enemyName + " for 7 damage (+2 damage) Total: 9 damage");
                    enemyHP = enemyHP - 9;
                    if (enemyHP >= 0) {
                        System.out.println("Enemies Health: " + enemyHP);
                    } else if (enemyHP < 0) {
                        System.out.println("Enemies Health: 0");
                    }
                    printLine();
                } else if (attack >= 6 && attack <= 10) {
                    System.out.println("You hit the " + enemyName + " for 6 damage (+2 damage) Total: 8 damage");
                    enemyHP = enemyHP - 8;
                    if (enemyHP >= 0) {
                        System.out.println("Enemies Health: " + enemyHP);
                    } else if (enemyHP < 0) {
                        System.out.println("Enemies Health: 0");
                    }
                    printLine();
                } else if (attack >= 0 && attack <= 5) {
                    System.out.println("You missed the " + enemyName);
                    System.out.println("Enemies Health: " + enemyHP);
                    printLine();
                } else if (attack >= 20) {
                    System.out.println("You hit the " + enemyName + " for 13 damage (+2 damage) Total: 15 damage");
                    enemyHP = enemyHP - 15;
                    if (enemyHP >= 0) {
                        System.out.println("Enemies Health: " + enemyHP);
                    } else if (enemyHP < 0) {
                        System.out.println("Enemies Health: 0");
                    }
                    printLine();
                }
            } else if (choice == 2) {
                if (player.getHealth() == 100) {
                    System.out.println("You are at full Health");
                    printLine();
                } else if (player.getHealth() > 0 && player.getHealth() < 75) {
                    System.out.println("You heal for 25 Health");
                    player.setHealth(player.getHealth() + 25);
                    player.setPotions(player.getPotions() - 1);
                    System.out.println("Health: " + player.getHealth());
                    System.out.println("Potions: " + player.getPotions());
                    printLine();
                } else if (player.getHealth() >= 76) {
                    System.out.println("You Healed to full health");
                    player.setHealth(100);
                    player.setPotions(player.getPotions() - 1);
                    System.out.println("Health: " + player.getHealth());
                    System.out.println("Potions: " + player.getPotions());
                    printLine();
                }
            }
            if (enemyHP > 0 && player.getHealth() > 0) {
                System.out.println(
                        "The " + enemyName
                                + " moves to attack you, do you dodge? (1-roll for dodge, 2-don't dodge) ");
                choice = input.nextInt();
                if (choice == 1 && player.getHealth() > 0) {
                    choiceroll = dice.nextInt(2) + 1;
                    System.out.println("You rolled a " + choiceroll);
                    if (choiceroll == 2) {
                        System.out
                                .println("You succesfully dodged the attack \nHealth: " + player.getHealth());
                        printLine();
                    } else if (choiceroll == 1) {
                        System.out.println(
                                "You fail to dodge and as a result you take more damage (-" + (enemyDg + 5)
                                        + " Health)");
                        player.setHealth(player.getHealth() - (enemyDg + 5));
                        System.out.println("Health: " + player.getHealth());
                        printLine();
                    }
                } else if (choice == 2 && player.getHealth() > 0) {
                    player.setHealth(player.getHealth() - enemyDg);
                    System.out.println(
                            "The " + enemyWp + " hits you and you take some damage (-" + enemyDg + " Health) \nHealth:"
                                    + player.getHealth());
                    printLine();
                }
            }
        }

        if (enemyHP <= 0 && player.getHealth() > 0) {
            System.out.println(
                    "You defeated the " + enemyName + "!");
            printLine();
        } else if (player.getHealth() <= 0) {
            printLine();
            System.out.println("Game over");
            System.exit(0);
        }
    }

    public static void printLine() {
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        String name;
        int weapon;
        int choice;
        System.out.println(
                "Good morning adventurer, do you know where you are?" +
                        "\nWhen you got here yesterday all of us were really confused " +
                        "\nbecause a stranger from a far off land had come and slept in our inn." +
                        "\nI'm Marc, the mayor of this town, pleased to be of your acquaintance, and you are? ");
        name = input.nextLine();
        printLine();
        System.out.println(
                "Nice to meet you " + name + " welcome to the land of Brebeufia." +
                        "\nThis land holds many secrets and tresures. " +
                        "\nI see that since you are an adventurer you came here for a reason. " +
                        "\nWhat kind of weapon is that? " +
                        "\n(Type 1 for Sword (+2 damage +1 speed) Type 2 for axe (+2 speed +1 attack) Type 3 for mace (+4 attack -1 speed) ");
        weapon = input.nextInt();
        printLine();
        Character Player = new Character(name, weapon);

        System.out.println(
                "I used to use one of those when I was a young adventurer, then I took an arrow to the knee. " +
                        "\nNow, back to the matter at hand. Our village is struggling, we have a very potent goblin infestation. "
                        +
                        "\nIt would mean a great deal for myself and the people of Brebeufia if you could go to their dungeon and remove them from the picture. "
                        +
                        "\nIf you kill the goblin king, the goblins wont know what to do and they will just disperse into the faroff lands. "
                        +
                        "\n..........\nYou'll do it? Wonderful! " +
                        "\nBut I must warn you, this will not be an easy task. " +
                        "\nHere's 5 potions \nGood luck adventurer");
        printLine();
        System.out.println(
                "You set off due north hoping to defeat the Goblin King and save Brebeufia. " +
                        "\nOn your way there you see a goblin hitting a tree with it's club. " +
                        "\nThe goblin sees you and it comes towards you " +
                        "\n(You are now in combat) ");
        fight("Goblin", 20, 10, "Club", Player);
        System.out.println(
                "After walking for a little while longer, \nyou approach the entrance of the dungeon. " +
                        "\nYou find an unlit torch by the entrance, you pick it up and light it as you enter the dark dungeon."
                        +
                        "\nYou find yourself in a narrow hallway, and at the end of the hallway is a wide room with two doors. "
                        +
                        "\nOne on the left and one on the right." +
                        "\nWhich do you choose (1-left,2-right)");
        choice = input.nextInt();
        printLine();
        if (choice == 2 && Player.getHealth() > 0) {
            System.out.println(
                    "You chose to go right. " +
                            "\nYou reached a dead end but you see a chest and when you open it you find 1 potion. " +
                            "\nYou turn back and head to the room to the left.");
            printLine();
            Player.setPotions(Player.getPotions() + 1);
        } else {
            System.out.println("You choose to to go left.");
        }
        System.out.println(
                "You reach another room very similar to the last. " +
                        "\nA Goblin waddles out of the corner and approaches you. " +
                        "\n(You are now in combat)");
        fight("Goblin", 30, 15, "Spear", Player);
        System.out.println(
                "Now that you have killed the Goblin you decide to move on through the dungeon. " +
                        "\nYou still have to choose which way you'll go." +
                        "\nLeft or Right(1-left,2-right)");
        choice = input.nextInt();
        printLine();
        if (choice == 1 && Player.getHealth() > 0) {
            System.out.println(
                    "You reach another \"room\" if you could call it that. " +
                            "\nIt's more the size of a closet." +
                            "\nYou think to yourself \"Why would the goblins need a closet\"" +
                            "\nYou turn around and go throught the right path.");
        } else {
            System.out.println("You go through the right door");
        }
        System.out.println(
                "You end up in an empty room with a massive mural on the wall." +
                        "\nYou walk up to the mural and hold the torch against it." +
                        "\nIt's beautiful but you understand what its depicting and cant help but be scared." +
                        "\nIts shows the world if goblins ruled." +
                        "\nAll the men in the village have been killed and the goblins are having their way with the women and children."
                        +
                        "\nYou cant look at it anymore. " +
                        "\nYou walk towards the door at the end of the room thinking \n\"How was it so detailed, there's no way a goblin made that\" "
                        +
                        "\nYou stop before the door because you feel the emmense pressure leaking from the next room. "
                        +
                        "\nWould you like to heal? (1-heal,2-don't heal)");
        choice = input.nextInt();
        if (choice == 1) {
            if (Player.getHealth() == 100) {
                System.out.println("You are at full Health");
                printLine();
            } else if (Player.getHealth() > 0 && Player.getHealth() < 75) {
                System.out.println("You heal for 25 Health");
                Player.setHealth(Player.getHealth() + 25);
                Player.setPotions(Player.getPotions() - 1);
                System.out.println("Health: " + Player.getHealth());
                System.out.println("Potions: " + Player.getPotions());
                printLine();
            } else if (Player.getHealth() >= 76) {
                System.out.println("You Healed to full health");
                Player.setHealth(100);
                Player.setPotions(Player.getPotions() - 1);
                System.out.println("Health: " + Player.getHealth());
                System.out.println("Potions: " + Player.getPotions());
                printLine();
            }
        }
        System.out.println(
                "You enter a large room with 6 podiums, \nyou see a Goblin Shaman sitting in the middle. \nIt gets up, sees you and starts to laugh. "
                        +
                        "\nIt raises its staff and the tip lights up. \nThe podiums start lighting on fire one by one. "
                        +
                        "\nIt then aimed the staff towards you and shot a fireball but before it hit you, you dodged out of the way. "
                        +
                        "\nThe only way you could get to the Goblin king is by defeating the Sorcerer. " +
                        "\n(You are now in combat)");
        fight("Goblin Shaman", 40, 20, "Fire-ball", Player);
        System.out.println(
                "The Shaman drops a potion so you pick it up. (+1 potion)" +
                        "\nYou continue through the dungeon, you end up in a large room with a huge wooden double door on the left wall."
                        +
                        "\nThere's a hobgoblin standing guard he notices you and starts chanting." +
                        "\nHe starts running towards you and pulls out his sword." +
                        "\n(You are now in combat)");
        fight("Hobgoblin", 35, 20, "Ebony Sword", Player);
        System.out.println(
                "You look through the hobgoblins inventory, and you find a vile of unicorn blood." +
                        "\nYou walk up to the door and it seemingly doubled in size. " +
                        "\nIt takes all of your strength to open the door, but you get it open in the end." +
                        "\nThe room you walk into could not be more of a boss room." +
                        "\nMassive pillars reaching the arched roof." +
                        "\nTribal patterns carved into the stone walls." +
                        "\nIn one corner you see a massive pile of gold things, \nit's mostly coins but there are goblets, crowns and more things you cant make out."
                        +
                        "\nAt the top of the pile there is a large green creature -bigger than all the other goblins you've fought- sleeping. "
                        +
                        "\"That has to be the king, I'll sneak up to him and kill him in his sleep\"" +
                        "\nYou make your way towards the Goblin king, walking with your eyes focused on the king." +
                        "\nAbout halfway there you accidentally kick a trophy and its clangs around making so much noise."
                        +
                        "\nThe Goblin king immediately wakes up and tumble down." +
                        "\nHe stands up and picks up his club, and he approaches you." +
                        "\nYou know a huge fight is coming so you chug the unicorn blood and heal to full health. " +
                        "\n(You are now in combat)");
        Player.setHealth(100);
        fight("Goblin King", 50, 25, "Giant Club", Player);
        System.out.println("You return to the town with the goblin kings head and everyone rejoices.");
    }
}