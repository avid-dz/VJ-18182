package ba.unsa.etf.rma.VJ_18182;

import java.util.ArrayList;

public class Muzicar {

    private String imeIPrezime;
    private String zanr;
    private String webStranica;
    private String biografija;
    private String slikaZanra;
    private ArrayList<String> listaTop5Pjesama;

    public Muzicar() {
        imeIPrezime = "";
        zanr = "";
        webStranica = "";
        biografija = "";
        slikaZanra = "";
        listaTop5Pjesama = new ArrayList<>();
    }

    public Muzicar(String imeIPrezime, String zanr, String webStranica, String biografija,
                   String slikaZanra, ArrayList<String> listaTop5Pjesama) {
        this.imeIPrezime = imeIPrezime;
        this.zanr = zanr;
        this.webStranica = webStranica;
        this.biografija = biografija;
        this.slikaZanra = slikaZanra;
        this.listaTop5Pjesama = listaTop5Pjesama;
    }

    public String getImeIPrezime() {
        return imeIPrezime;
    }

    public void setImeIPrezime(String imeIPrezime) {
        this.imeIPrezime = imeIPrezime;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public String getWebStranica() {
        return webStranica;
    }

    public void setWebStranica(String webStranica) {
        this.webStranica = webStranica;
    }

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }

    public String getSlikaZanra() {
        return slikaZanra;
    }

    public void setSlikaZanra(String slikaZanra) {
        this.slikaZanra = slikaZanra;
    }

    public ArrayList<String> getListaTop5Pjesama() {
        return listaTop5Pjesama;
    }

    public void setListaTop5Pjesama(ArrayList<String> listaTop5Pjesama) {
        this.listaTop5Pjesama = listaTop5Pjesama;
    }
}
