public abstract class Plant {
    public static final int MAX_HP = 300;
    private final String nama;
    private int hp;
    private int hargaSun;

    public Plant(String nama, int hp, int hargaSun) {
        this.nama = nama;
        this.setHp(hp);
        this.setHargaSun(hargaSun);
    }

    public Plant(String nama, int hargaSun) {
        this(nama, MAX_HP, hargaSun);
    }

    public void terimaDamage(int dmg) {
        this.setHp(this.hp - dmg);
        System.out.println("[Plant] " + this.nama + " menerima " + dmg + " damage! (Sisa HP: " + this.hp + ")");
    }

    public boolean isMati() {
        return this.hp <= 0;
    }

    public void info() {
        System.out.println("Tanaman: " + this.nama + " | HP: " + this.hp + "/" + MAX_HP + " | Harga: " + this.hargaSun + " Sun");
    }

    public abstract void aksi();

    public String getNama() {
        return this.nama;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        if (hp < 0) {
            this.hp = 0;
        } else if (hp > MAX_HP) {
            this.hp = MAX_HP;
        } else {
            this.hp = hp;
        }
    }

    public int getHargaSun() {
        return this.hargaSun;
    }

    public void setHargaSun(int hargaSun) {
        this.hargaSun = Math.max(0, hargaSun);
    }
}
