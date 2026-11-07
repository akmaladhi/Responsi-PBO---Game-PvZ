public class Sunflower extends Plant {
    private int giliranMenunggu;
    private int totalSunDihasilkan;

    public Sunflower(String nama, int hp, int hargaSun) {
        super(nama, hp, hargaSun);
        this.giliranMenunggu = 0;
        this.totalSunDihasilkan = 0;
    }

    public Sunflower(String nama) {
        super(nama, 80, 50);
        this.giliranMenunggu = 0;
        this.totalSunDihasilkan = 0;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("   -> Detail Sunflower  | Cooldown Giliran: " + this.giliranMenunggu + "/1 | Total Produksi: " + this.totalSunDihasilkan + " Sun");
    }

    @Override
    public void aksi() {
        if (this.giliranMenunggu < 1) {
            this.giliranMenunggu++;
            System.out.println("[Aksi] " + this.getNama() + " sedang menyerap cahaya matahari... (" + this.giliranMenunggu + "/1)");
        } else {
            this.totalSunDihasilkan += 25;
            this.giliranMenunggu = 0;
            System.out.println("[Aksi] " + this.getNama() + " menghasilkan +25 Sun! (Total dihasilkan: " + this.totalSunDihasilkan + " Sun)");
        }
    }

    public int getGiliranMenunggu() {
        return this.giliranMenunggu;
    }

    public void setGiliranMenunggu(int giliranMenunggu) {
        this.giliranMenunggu = Math.max(0, giliranMenunggu);
    }

    public int getTotalSunDihasilkan() {
        return this.totalSunDihasilkan;
    }

    public void setTotalSunDihasilkan(int totalSunDihasilkan) {
        this.totalSunDihasilkan = Math.max(0, totalSunDihasilkan);
    }
}
