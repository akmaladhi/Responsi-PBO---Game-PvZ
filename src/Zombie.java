public class Zombie {
    private String tipe;
    private int hp;
    private int damage;

    public Zombie(String tipe, int hp, int damage) {
        this.tipe = tipe;
        this.setHp(hp);
        this.damage = damage;
    }

    public Zombie(String tipe) {
        this(tipe, 100, 20);
    }

    public void terimaDamage(int dmg) {
        this.setHp(this.hp - dmg);
        System.out.println("[Zombie] " + this.tipe + " terkena " + dmg + " damage! (Sisa HP: " + this.hp + ")");
    }

    public void serang(Plant target) {
        if (!this.isMati()) {
            System.out.println("[Zombie] " + this.tipe + " menggigit " + target.getNama() + " sebesar " + this.damage + " damage!");
            target.terimaDamage(this.damage);
        }
    }

    public boolean isMati() {
        return this.hp <= 0;
    }

    public void info() {
        System.out.println("Zombie [" + this.tipe + "] | HP: " + this.hp + " | Damage: " + this.damage);
    }

    public String getTipe() {
        return this.tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        if (hp < 0) {
            this.hp = 0;
        } else {
            this.hp = hp;
        }
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = Math.max(0, damage);
    }
}