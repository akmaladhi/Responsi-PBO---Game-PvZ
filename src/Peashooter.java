public class Peashooter extends Plant implements Shooter, Upgradeable {
    private int damage;
    private int level;
    private int amunisi;

    public Peashooter(String nama, int hp, int hargaSun, int damage, int amunisi) {
        super(nama, hp, hargaSun);
        this.damage = damage;
        this.level = 1;
        this.amunisi = amunisi;
    }

    public Peashooter(String nama) {
        super(nama, 100, 100);
        this.damage = 25;
        this.level = 1;
        this.amunisi = 2;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("   -> Detail Peashooter | Level: " + this.level + " | Damage: " + this.damage + " | Amunisi: " + this.amunisi);
    }

    @Override
    public void aksi() {
        if (this.amunisi > 0) {
            this.amunisi--;
            System.out.println("[Aksi] " + this.getNama() + " bersiap menembakkan kacang! (Sisa amunisi: " + this.amunisi + ")");
        } else {
            this.amunisi = 2;
            System.out.println("[Aksi] Amunisi " + this.getNama() + " habis! Melakukan reload... (Amunisi sekarang: " + this.amunisi + ")");
        }
    }

    @Override
    public void tembak(Zombie target) {
        if (this.amunisi > 0) {
            this.amunisi--;
            System.out.println("[Shooter] " + this.getNama() + " menembak " + target.getTipe() + " (Damage: " + this.damage + ", Sisa amunisi: " + this.amunisi + ")");
            target.terimaDamage(this.damage);
        } else {
            System.out.println("[Shooter] Gagal menembak! Amunisi " + this.getNama() + " kosong, panggil aksi() untuk reload.");
        }
    }

    @Override
    public void upgrade() {
        this.level++;
        this.damage += 15;
        System.out.println("[Upgrade] " + this.getNama() + " naik ke Level " + this.level + "! Damage meningkat menjadi " + this.damage + ".");
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = Math.max(0, damage);
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = Math.max(1, level);
    }

    public int getAmunisi() {
        return this.amunisi;
    }

    public void setAmunisi(int amunisi) {
        this.amunisi = Math.max(0, amunisi);
    }
}
