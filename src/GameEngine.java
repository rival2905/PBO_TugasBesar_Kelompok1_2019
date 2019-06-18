import java.util.Scanner;

public class GameEngine extends Thread {
    private Player oPlayer;
    private Barang kotakSuara = new Barang(100, "Kotak Suara", "barang bernilai", "kotak berisikan surat suara", false, false, false, 0, 0);
//    private Adegan daftarAdegan;

    GameEngine(){
        this.oPlayer = new Player(1, "Abdi Mukti", this.kotakSuara.cloning());
        Adegan.oPlayer = this.oPlayer;
    }

    @Override
    public void run() {
        System.out.println("Hello World");
    }

    private void mulaiGame(){
        System.out.println("Pada suatu hari saat pemilihan Presiden dilakukan, terjadi sebuah kerusuhan sehingga kotak suara hilang\n");
        System.out.printf("%-10s\n\n", "[Tekan Huruf Apapun kemudian Enter untuk melanjutkan]");
        Scanner oScan = new Scanner(System.in);
        oScan.nextLine();
        System.out.println();
        System.out.println("Maka dari itu " + this.oPlayer.nama + "harus melakukan sebuah misi untuk menemukan kotak suara tersebut untuk dikembalikan\n");
        System.out.printf("%-10s\n\n", "[Tekan Huruf Apapun kemudian Enter untuk melanjutkan]");
        oScan.nextLine();
        System.out.println();
        System.out.println("Selamat bermain");
        CobaSwing test = new CobaSwing();
//        test.start();
        while (!this.oPlayer.isSelesai){
//            System.out.println(test.isAlive());
            this.oPlayer.adeganAktif.mainkan();
        }
        if(this.oPlayer.getKesehatan() <= 0){
            System.out.println();
            System.out.println("[ Game Over ]");
        }else{
            System.out.println();

            System.out.println("[ The End ]");
        }
        if(this.oPlayer.isKotakSuaraTertemukan()){
            System.out.println();
            System.out.println("[ Selamat Kotak Suara Sudah Tertemukan ]");
            System.out.println("[ Created By: ]");
            System.out.println("[ ............. ]");
            System.out.println("[ ............. ]");
            System.out.println("[ ............. ]");
        }
    }

    public static void main(String[] args){
        /* Create Object GameEngine */
        GameEngine oGameEgnine = new GameEngine();

        /* Create Object Semua Barang */
        Barang jewelBox = new Barang(24, "Jewel Box", "barang bernilai", "kotak berisikan permata", false, true, false, 50000, 0);
        Barang oldKey = new Barang(29, "Old Key", "kunci", "Kunci usang",true, false, false, 0, 0);
        Barang metalParts = new Barang(2, "Metal Parts", "komponen crafting", "Bisa digunakan untuk memperbaiki senjata", false, false, true, 0, 1000);
        BarangPenggunaanPadaDiri medikit = new BarangPenggunaanPadaDiri(1, "Medikit", "penggunaan pada diri", "Untuk menyembuhkan luka", false, false, true, 0, 10000, 100);
        BarangPenggunaanPadaDiri resistanceBooster = new BarangPenggunaanPadaDiri(20, "Resistancce Booster", "penggunaan pada diri", "untuk membuat fisik menjadi lebih tahan terhadap serangan", false, false, false, 0, 0, 0);
        resistanceBooster.tambahEfek(new Efek(1, "Ketahanan Fisik", 0, 0, 0, 0, 0, 0, 0, 50, 10));
        BarangSenjata granade = new BarangSenjata(32, "Granade", "senjata", "saat dilemparkan akan meledak", false, true, true, true, 250000, 500000, 10);
        granade.tambahEfek(new Efek(2, "Ledakan", 0, 0,0, 0, 3, 100, 1, 0, 0));
        BarangSenjata regularArrow = new BarangSenjata(11, "Regular Arrow", "amunisi", "anak panah biasa yang tidak memiliki efek apapun", false, false, false, true, 0, 50000, 30);
        BarangSenjata increniaryArrow = new BarangSenjata(10, "Incendiary Arrow", "amunisi", "anak panah yang memiliki efek api", false, false, false, true, 0, 60000, 30);
        increniaryArrow.tambahEfek(new Efek(3, "Api", 5, 10, 100, 0, 0, 0, 0, 0, 0));
        //yola
        BarangSenjata pistol = new BarangSenjata(13, "Pistol", "Senjata", "Ditembakan dengan kekuatan kecil", false, false, false, true, 0, 60000, 30);
        BarangSenjata SniperRifle = new BarangSenjata(14, "Sniper Rifle", "Senjata", "Ditembakan dengan peluru yang lemah", false, false, false, true, 0, 60000, 30);
        BarangSenjata SubmachineGun = new BarangSenjata(15, "Submachine Gun", "Senjata", "Ditembakan agar membuat lawan kabur", false, false, false, true, 0, 60000, 30);
        BarangSenjata LightMachineGun = new BarangSenjata(16, "Light Machine Gun", "Senjata", "Ditembakan agar membuat lawan sangat kesakitan", false, false, false, true, 0, 60000, 30);

        BarangSenjataTembak bow = new BarangSenjataTembak(12, "Bow", "senjata", "busur yang memanah dengan kekuatan tinggi", false, true, true, 500000, 1500000, 220, 1, increniaryArrow);
        bow.tambahAmunisiYangDiperlukan(increniaryArrow);
        BarangSenjataJarakDekat pipaTua = new BarangSenjataJarakDekat(4, "pipa tua", "senjata", "pipa tua berkarat berukurang sedang",
                false, true, false, 5000, 15000, 35, 20, 5, 3, 0, 1);
        BarangSenjataJarakDekat pisau = new BarangSenjataJarakDekat(5, "pisau", "senjata", "pipa tua berkarat berukurang sedang",
                false, true, false, 5000, 15000, 35, 20, 5, 3, 0, 1);

        /* Create object semua adegan */
        AdeganNormal adeganId1 = new AdeganNormal(1, 0, "Tangga Lantai 1", "Lantai 01", "","Gedung Tua Asing", "Sampai pada tangga lantai 1");
        AdeganBertarung adeganId2 = new AdeganBertarung(2, "Tangga Lantai 1", "Lantai 01", "","Gedung Tua Asing", "Berjalan menuju tangga lantai 1.. Tiba-tiba sekumpulan zombie bermunculan dari arah atas !", adeganId1);
        AdeganNormal adeganId3 = new AdeganPintu(3, 29, "Depan Pintu Keluar Ruangan", "Kamar 03", "", "Gedung Tua Asing", "Pintu menuju tangga lantai 1", new PilihanGantiAdegan("Menuju tangga di lantai 1", adeganId1));
        adeganId1.tambahAdeganBertarung(adeganId2);

        AdeganBertarung adeganId4 = new AdeganBertarung(4, "Tangga Lantai 2", "Lantai 02", "","Gedung Tua Asing", "Berjalan menuju tangga lantai 2.. Tiba-tiba sekumpulan zombie bermunculan dari arah atas !", adeganId1);
        AdeganNormal adeganId5 = new AdeganNormal(5, 0, "Tangga Lantai 2", "Lantai 02", "","Gedung Tua Asing", "Sampai pada tangga lantai 2");
        adeganId5.tambahAdeganBertarung(adeganId4);
        adeganId1.tambahPilihan(new PilihanGantiAdegan("Naik Tangga Lantai 2", adeganId5));

        AdeganBertarung adeganId6 = new AdeganBertarung(6, "Tangga Lantai 3", "Lantai 03", "","Gedung Tua Asing", "Berjalan menuju tangga lantai 3.. Tiba-tiba sekumpulan zombie bermunculan dari arah atas !", adeganId5);
        AdeganNormal adeganId7 = new AdeganNormal(7, 0, "Tangga Lantai 3", "Lantai 03", "","Gedung Tua Asing", "Sampai pada tangga lantai 3");
        adeganId7.tambahAdeganBertarung(adeganId6);
        adeganId5.tambahPilihan(new PilihanGantiAdegan("Naik Tangga Lantai 3", adeganId7));

        AdeganBertarung adeganId8 = new AdeganBertarung(8, "Tangga Lantai 4", "Lantai 04", "","Gedung Tua Asing", "Berjalan menuju tangga lantai 4.. Tiba-tiba sekumpulan zombie bermunculan dari arah atas !", adeganId7);
        AdeganNormal adeganId9 = new AdeganNormal(9, 0, "Tangga Lantai 4", "Lantai 04", "","Gedung Tua Asing", "Sampai pada tangga lantai 4");
        adeganId9.tambahAdeganBertarung(adeganId8);
        adeganId7.tambahPilihan(new PilihanGantiAdegan("Naik Tangga Lantai 4", adeganId9));

        BarangSenjataJarakDekat.setKomponenUntukPerbaikan(metalParts);

        adeganId3.tambahBarang(oldKey, 1);

        adeganId1.tambahBarang(jewelBox, 2);
        adeganId1.tambahBarang(metalParts, 2);
        adeganId1.tambahBarang(medikit, 1);
        adeganId1.tambahBarang(resistanceBooster, 1);
        adeganId1.tambahBarang(granade, 5);
        adeganId1.tambahBarang(regularArrow, 50);
        adeganId1.tambahBarang(increniaryArrow, 1);
        adeganId1.tambahBarang(regularArrow, 5);
        adeganId1.tambahBarang(bow, 1);
        adeganId1.tambahBarang(pipaTua, 2);
        adeganId1.tambahBarang(regularArrow, 2);
        adeganId1.tambahBarang(pistol, 5 );
        adeganId1.tambahBarang(SniperRifle, 5 );
        adeganId1.tambahBarang(SubmachineGun, 5 );
        adeganId1.tambahBarang(LightMachineGun, 5 );
        adeganId1.tambahBarang(new Barang(100, "Kotak Suara", "barang bernilai", "kotak berisikan surat suara", false, false, false, 0, 0), 1);

        /* contoh lawan */
        Lawan lawanId1 = new Lawan(1, "Zombie biasa", 100, 10);
        lawanId1.getoPengelolaanBarangSederhana().tambahBarang(medikit, 5);
        adeganId2.tambahLawan(lawanId1);
        //adeganId2.tambahLawan(new Lawan(lawanId1, pipaTua, 1));

        //lawan lantai2
        Lawan lawanId2 = new Lawan(2, "Zombie Virus Kuat", 100, 50);
        lawanId2.getoPengelolaanBarangSederhana().tambahBarang(medikit, 5);
        adeganId4.tambahLawan(lawanId2);
        //adeganId4.tambahLawan(new Lawan(lawanId2, pistol, 1));

        //lawan lantai3
        Lawan lawanId3 = new Lawan(3, "Zombie Mematikan", 100, 100);
        lawanId3.getoPengelolaanBarangSederhana().tambahBarang(medikit, 5);
        adeganId6.tambahLawan(lawanId2);
        //adeganId4.tambahLawan(new Lawan(lawanId2, pistol, 1));

        //lawan lantai4
        Lawan lawanId4 = new Lawan(4, "BOSS", 100, 150);
        lawanId4.getoPengelolaanBarangSederhana().tambahBarang(medikit, 5);
        adeganId6.tambahLawan(lawanId2);
        //adeganId4.tambahLawan(new Lawan(lawanId2, pistol, 1));



        oGameEgnine.oPlayer.getPengelolaanBarang().setBatasMaxClassBarangSenjataIdTertentu(10, 5);
        oGameEgnine.oPlayer.getPengelolaanBarang().setBatasMaxClassBarangSenjataIdTertentu(11, 10);
        oGameEgnine.oPlayer.getPengelolaanBarang().setBatasMaxClassBarangSenjataIdTertentu(32, 5);
        oGameEgnine.oPlayer.getPengelolaanBarang().setBatasMaxClassBarangPenggunaanPadaDiriIdTertentu(1, 5);
        oGameEgnine.oPlayer.getPengelolaanBarang().tambahBarang(granade, 5);
        oGameEgnine.oPlayer.getPengelolaanBarang().tambahBarang(increniaryArrow, 20);
        oGameEgnine.oPlayer.getPengelolaanBarang().tambahBarang(bow, 1);
        oGameEgnine.oPlayer.adeganAktif = adeganId3;
        oGameEgnine.mulaiGame();
    }
}