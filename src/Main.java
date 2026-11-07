public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println("   RESPONSI AKHIR PBO - PLANTS VS ZOMBIES (TURN-BASED TERMINAL)   ");
        System.out.println("   Nama : Akmal Adhi Nugroho | NIM : H1D025021 | Tema : Game      ");
        System.out.println("==================================================================\n");

        System.out.println("--- [TAHAP 1: INISIALISASI OBJEK & OVERLOADING KONSTRUKTOR] ---");
        System.out.println("Konstanta Global Plant.MAX_HP = " + Plant.MAX_HP);

        int sunModal = 250;
        System.out.println("Modal Sun Awal Pemain: " + sunModal + " Sun\n");

        Sunflower sunflower = new Sunflower("Twin Sunflower");
        Peashooter peashooter = new Peashooter("Repeater Pea", 120, 100, 30, 1);
        WallNut wallNut = new WallNut("Giant Wall-Nut");
        Zombie zombie = new Zombie("Buckethead Zombie", 90, 80);

        sunModal -= (sunflower.getHargaSun() + peashooter.getHargaSun() + wallNut.getHargaSun());
        System.out.println("Sisa Sun setelah menanam 3 tanaman: " + sunModal + " Sun\n");

        System.out.println("--- [TAHAP 2: STATUS AWAL (INHERITANCE, OVERRIDING & SUPER CHAINING)] ---");
        sunflower.info();
        peashooter.info();
        wallNut.info();
        zombie.info();
        System.out.println();

        System.out.println("--- [TAHAP 3: POLIMORFISME INTERFACE & MULTIPLE INTERFACE] ---");
        Upgradeable tanamanUpgrade = new Peashooter("Snow Pea");
        tanamanUpgrade.upgrade();

        Shooter penembakUtama = peashooter;
        Upgradeable pengupgradeUtama = peashooter;
        pengupgradeUtama.upgrade();
        System.out.println();

        System.out.println("--- [TAHAP 4: SIMULASI TURN-BASED & LOGIKA STATE IF/ELSE] ---");

        System.out.println(">>> GILIRAN 1 <<<");
        sunflower.aksi();
        wallNut.aksi();
        penembakUtama.tembak(zombie);
        zombie.serang(wallNut);
        System.out.println();

        System.out.println(">>> GILIRAN 2 <<<");
        sunflower.aksi();
        sunModal += 25;
        System.out.println("[Sistem] Modal Sun pemain bertambah menjadi: " + sunModal + " Sun");

        penembakUtama.tembak(zombie);
        peashooter.aksi();

        zombie.setDamage(100);
        zombie.serang(wallNut);
        wallNut.aksi();
        System.out.println();

        System.out.println(">>> GILIRAN 3 <<<");
        penembakUtama.tembak(zombie);

        if (zombie.isMati()) {
            System.out.println("\n[HASIL AKHIR] " + zombie.getTipe() + " telah dikalahkan! Pemain MENANG!");
        } else {
            System.out.println("\n[HASIL AKHIR] Zombie masih hidup. Pertahanan gagal!");
        }

        System.out.println("\n--- [STATUS AKHIR OBJEK] ---");
        sunflower.info();
        peashooter.info();
        wallNut.info();
        zombie.info();
    }
}
