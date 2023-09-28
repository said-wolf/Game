// Abstract class for Entity
abstract class Entity {
    private int attack;
    private int defense;
    private int health;
    private int damageMin;
    private int damageMax;
    private int maxHealth;
    private int healsLeft;

    public Entity(int attack, int defense, int health, int damageMin, int damageMax) {
        this.attack = validateParameter(attack, 1, 30);
        this.defense = validateParameter(defense, 1, 30);
        this.maxHealth = validateParameter(health, 0, Integer.MAX_VALUE);
        this.health = this.maxHealth;
        this.damageMin = validateParameter(damageMin, 0, damageMax);
        this.damageMax = validateParameter(damageMax, damageMin, Integer.MAX_VALUE);
        this.healsLeft = 4;
    }

    private int validateParameter(int value, int min, int max) {
            if (value < min || value > max) {
                throw new IllegalArgumentException("Parameter out of range");
            }
        return value;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getDamageMin() {
        return damageMin;
    }

    public int getDamageMax() {
        return damageMax;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be negative");
        }
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public void heal() {
        if (healsLeft > 0 && health < maxHealth * 0.3) {
            System.out.println("Player Health " + health);
            int maxHealAmount = maxHealth;
            int healAmount = (int) (maxHealAmount * 0.3); // 30% of max health
            health += healAmount;
            System.out.println("The player is cured for " + healAmount + " health");
            if (health > maxHealth) {
                health = maxHealth;
            }
            healsLeft--;
        }
    }

    public abstract boolean attack(Entity target);
}
