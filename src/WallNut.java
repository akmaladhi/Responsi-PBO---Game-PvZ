public class WallNut extends Plant {
    private String kondisiKulit;

    public WallNut(String nama) {
        super(nama, 50);
        this.kondisiKulit = "Utuh";
    }

    public WallNut(String nama, int hp, int hargaSun) {
        super(nama, hp, hargaSun);
        this.kondisiKulit = "Utuh";
    }

    @Override
    public void info() {
        super.info();
        System.out.println("   -> Detail WallNut    | Kondisi Kulit: " + this.kondisiKulit);
    }

    @Override
    public void aksi() {
        if (this.getHp() > 150) {
            this.kondisiKulit = "Utuh dan Kuat";
        } else if (this.getHp() > 0) {
            this.kondisiKulit = "Retak Parah";
        } else {
            this.kondisiKulit = "Hancur";
        }
        System.out.println("[Aksi] " + this.getNama() + " bertahan menahan jalur! (Kondisi Kulit berubah menjadi: " + this.kondisiKulit + ")");
    }

    public String getKondisiKulit() {
        return this.kondisiKulit;
    }

    public void setKondisiKulit(String kondisiKulit) {
        this.kondisiKulit = kondisiKulit;
    }
}