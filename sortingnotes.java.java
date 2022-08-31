class Öğrenci {

    String puan;
    String öğrencino;

    Öğrenci bağ;

    public String toString() {
        return öğrencino + ": " + puan;
    }
}

class ÖğrenciListesi {

    Öğrenci ilk;

    public ÖğrenciListesi() {
        this.ilk = null;
    }

    public void ekle(String öğrencino, String puan) {
        {
            Öğrenci yeni = new Öğrenci();
            yeni.öğrencino = öğrencino;
            yeni.puan = puan;

            if (this.ilk == null) {
                this.ilk = yeni;
            } else {
                Öğrenci geçici = this.ilk;
                Öğrenci önceki = null;

                do {
                    if (ÖğrenciListesi.sayısalPuanDönüştür(yeni.puan) > ÖğrenciListesi.sayısalPuanDönüştür(geçici.puan)) {
                        yeni.bağ = geçici;
                        if (geçici == this.ilk) {
                            this.ilk = yeni;
                        } else {
                            if (önceki != null) {
                                önceki.bağ = yeni;
                            }
                        }
                        break;
                    } else {
                        if (geçici.bağ == null) {
                            geçici.bağ = yeni;
                        } else {
                            önceki = geçici;
                            geçici = geçici.bağ;
                        }
                    }
                } while (geçici.bağ != null);
            }
        }
    }

    public void yazdır() {
        Öğrenci geçici = this.ilk;

        do {
            System.out.println(geçici);
            geçici = geçici.bağ;
        } while (geçici != null);
    }

    public static int sayısalPuanDönüştür(String puan) {
        if (puan == "AA") {
            return 8;
        } else if (puan == "BA") {
            return 7;
        } else if (puan == "BB") {
            return 6;
        } else if (puan == "CB") {
            return 5;

        } else if (puan == "CC") {
            return 4;
        } else if (puan == "DC") {
            return 3;
        } else if (puan == "DD") {
            return 2;
        } else if (puan == "FD") {
            return 1;
        } else {
            return 0;
        }
    }
}

public class deneme {

    public static void main(String args[]) {
        ÖğrenciListesi lx = new ÖğrenciListesi();
        lx.ekle("1", "FF");
        lx.ekle("2", "FD");
        lx.ekle("3", "DD");
        lx.ekle("4", "DC");
        lx.ekle("5", "CC");
        lx.ekle("6", "CB");
        lx.ekle("7", "BB");
        lx.ekle("8", "BA");
        lx.ekle("9", "AA");

        lx.yazdır();
    }
}
