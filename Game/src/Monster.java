import java.util.Random;

class Monster extends Entity {
    public Monster(int attack, int defense, int health, int damageMin, int damageMax) {
        super(attack, defense, health, damageMin, damageMax);
    }

    @Override
    public boolean attack(Entity target) {
        int attackModifier = getAttack() - target.getDefense() + 1;
        attackModifier = Math.max(attackModifier, 1); // Ensure attack modifier is at least 1
        int diceRolls = attackModifier;
        boolean successfulHit = false;
        Random random = new Random();

        for (int i = 0; i < diceRolls; i++) {
            int diceResult = random.nextInt(6) + 1;
            if (diceResult == 5 || diceResult == 6) {
                successfulHit = true;
                break;
            }
        }

        if (successfulHit) {
            int damage = random.nextInt(getDamageMax() - getDamageMin() + 1) + getDamageMin();
            target.takeDamage(damage);
        }

        return successfulHit;
    }
}