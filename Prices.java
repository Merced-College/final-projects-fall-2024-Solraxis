/* 
 * Title: DeckList Buddy a.k.a. Kevin's Super Awesome Magic: the Gathering Tool
 * Date: 12.6.2024
 * Class: CPSC-039, Kathy Kanemoto
 * Ver: 1.0
 * A class that lists prices as doubles.  Setters check for null, then parse the string for doubles and sets those to the price
 */

package DeckListBuddy;

public class Prices {
    public double usd;
    public double usd_foil;
    public double usd_etched;
    public double eur;
    public double eur_foil;
    public double eur_etched;
    public double tix;

    @Override
    public String toString() {
        return "usd=" + usd + "    usd_foil=" + usd_foil + "    usd_etched=" + usd_etched + "\neur=" + eur
                + "    eur_foil=" + eur_foil + "    eur_etched=" + eur_etched + "\ntix=" + tix;
    }
    public double getUsd() {
        return usd;
    }
    public void setUsd(String usd) {
        if(usd == null){
            this.usd = 0.0;
        }else{
            this.usd = Double.parseDouble(usd);
        }
    }
    public double getUsd_foil() {
        return usd_foil;
    }
    public void setUsd_foil(String usd_foil) {
        if(usd_foil == null){
            this.usd_foil = 0.0;
        }else{
            this.usd_foil = Double.parseDouble(usd_foil);
        }
    }
    public double getUsd_etched() {
        return usd_etched;
    }
    public void setUsd_etched(String usd_etched) {
        if(usd_etched == null){
            this.usd_etched = 0.0;
        }else{
            this.usd_etched = Double.parseDouble(usd_etched);
        }
    }
    public double getEur() {
        return eur;
    }
    public void setEur(String eur) {
        if(eur == null){
            this.eur = 0.0;
        }else{
            this.eur = Double.parseDouble(eur);
        }
    }
    public double getEur_foil() {
        return eur_foil;
    }
    public void setEur_foil(String eur_foil) {
        if(eur_foil == null){
            this.eur_foil = 0.0;
        }else{
            this.eur_foil = Double.parseDouble(eur_foil);
        }
    }
    public double getEur_etched() {
        return eur_etched;
    }
    public void setEur_etched(String eur_etched) {
        if(eur_etched == null){
            this.eur_etched = 0.0;
        }else{
            this.eur_etched = Double.parseDouble(eur_etched);
        }
    }
    public double getTix() {
        return tix;
    }
    public void setTix(String tix) {
        if(tix == null){
            this.tix = 0.0;
        }else{
            this.tix = Double.parseDouble(tix);
        }
    }
}
