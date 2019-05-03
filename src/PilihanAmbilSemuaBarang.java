import java.util.ArrayList;
import java.util.HashMap;

public class PilihanAmbilSemuaBarang extends Pilihan {
    private Adegan oAdegan;

    PilihanAmbilSemuaBarang(String dekripsi, Adegan oAdegan) {
        super(dekripsi);
        this.oAdegan = oAdegan;
    }

    @Override
    public void aksi() {
        /* Mengambil semua barang dengan proses seleksi yang melibatkan parameter/inputan jumlahSlotSenjataKosong milik Player */
        HashMap<String, ArrayList<ArrayList<Barang>>> oKategoriBarang = this.oAdegan.ambilSemuaBarang(this.oAdegan.oPlayer.getJumlahSlotSenjataKosong());

        /* Jika hasil ambil semua barang tidak kosong maka.. */
        if(oKategoriBarang != null){

            /* tambahkan barang tersebut ke Player */
            this.oAdegan.oPlayer.tambahBarang(oKategoriBarang);
        }
    }
}
