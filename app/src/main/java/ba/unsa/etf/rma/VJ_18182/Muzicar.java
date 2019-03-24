package ba.unsa.etf.rma.VJ_18182;

public class Muzicar {

    private String imeIPrezime;
    private String zanr;
    private String webStranica;
    private String biografija;

    public Muzicar() {
        imeIPrezime = "";
        zanr = "";
        webStranica = "";
        biografija = "";
    }

    public Muzicar(String imeIPrezime, String zanr, String webStranica, String biografija) {
        this.imeIPrezime = imeIPrezime;
        this.zanr = zanr;
        this.webStranica = webStranica;
        this.biografija = biografija;
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
}
