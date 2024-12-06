package DeckListBuddy;

public class Prices {
    public String usd;
    public String usd_foil;
    public String usd_etched;
    public String eur;
    public String eur_foil;
    public String eur_etched;
    public String tix;

    //

    public String getUsd() {
        return usd;
    }
    @Override
    public String toString() {
        return "usd=" + usd + "    usd_foil=" + usd_foil + "    usd_etched=" + usd_etched + "\neur=" + eur
                + "    eur_foil=" + eur_foil + "    eur_etched=" + eur_etched + "\ntix=" + tix;
    }
    public void setUsd(String usd) {
        this.usd = usd;
    }
    public String getUsd_foil() {
        return usd_foil;
    }
    public void setUsd_foil(String usd_foil) {
        this.usd_foil = usd_foil;
    }
    public String getUsd_etched() {
        return usd_etched;
    }
    public void setUsd_etched(String usd_etched) {
        this.usd_etched = usd_etched;
    }
    public String getEur() {
        return eur;
    }
    public void setEur(String eur) {
        this.eur = eur;
    }
    public String getEur_foil() {
        return eur_foil;
    }
    public void setEur_foil(String eur_foil) {
        this.eur_foil = eur_foil;
    }
    public String getEur_etched() {
        return eur_etched;
    }
    public void setEur_etched(String eur_etched) {
        this.eur_etched = eur_etched;
    }
    public String getTix() {
        return tix;
    }
    public void setTix(String tix) {
        this.tix = tix;
    }
}
