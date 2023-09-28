import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int e = random.nextInt(29) + 1;
        int e1 = random.nextInt(29) + 1;
        int e2 = random.nextInt(29) + 1;
        int e3 = random.nextInt(29) + 1;
        Player player = new Player(e, e1, 100, 5, 15);
        Monster monster = new Monster(e2, e3, 100, 4, 12);
        System.out.println("Player attack: " + e + "\nPlayer defence: " + e1
                            + "\nMonster attack: " + e2 + "\nMonster defence: " + e3);
        while (player.isAlive() && monster.isAlive()) {
            boolean playerAttackSuccess = player.attack(monster);
            boolean monsterAttackSuccess = monster.attack(player);
            System.out.println("Player attacks: " + (playerAttackSuccess ? "Hit!"  : "Miss"));
            System.out.println("Monster attacks: " + (monsterAttackSuccess ? "Hit!" : "Miss"));
            player.heal();
            System.out.println("Player Health: " + player.getHealth());
            System.out.println("Monster Health: " + monster.getHealth());
        }

        if (player.isAlive()) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Monster wins!");
        }
    }
}
