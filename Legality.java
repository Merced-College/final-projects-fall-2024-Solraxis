package DeckListBuddy;

public class Legality {
    private boolean standard;
    private boolean future;
    private boolean historic;
    private boolean timeless;
    private boolean gladiator;
    private boolean pioneer;
    private boolean explorer;
    private boolean modern;
    private boolean legacy;
    private boolean pauper;
    private boolean vintage;
    private boolean penny;
    private boolean commander;
    private boolean oathbreaker;
    private boolean standardbrawl;
    private boolean brawl;
    private boolean alchemy;
    private boolean paupercommander;
    private boolean duel;
    private boolean oldschool;
    private boolean premodern;
    private boolean predh;

    public boolean isLegal(String l){
        boolean isLegal = false;
        if(l.equals("legal")){
            isLegal = true;
        }
        return isLegal;
    }

    public boolean isStandard() {
        return standard;
    }
    public void setStandard(boolean standard) {
        this.standard = standard;
    }
    public boolean isFuture() {
        return future;
    }
    public void setFuture(boolean future) {
        this.future = future;
    }
    public boolean isHistoric() {
        return historic;
    }
    public void setHistoric(boolean historic) {
        this.historic = historic;
    }
    public boolean isTimeless() {
        return timeless;
    }
    public void setTimeless(boolean timeless) {
        this.timeless = timeless;
    }
    public boolean isGladiator() {
        return gladiator;
    }
    public void setGladiator(boolean gladiator) {
        this.gladiator = gladiator;
    }
    public boolean isPioneer() {
        return pioneer;
    }
    public void setPioneer(boolean pioneer) {
        this.pioneer = pioneer;
    }
    public boolean isExplorer() {
        return explorer;
    }
    public void setExplorer(boolean explorer) {
        this.explorer = explorer;
    }
    public boolean isModern() {
        return modern;
    }
    public void setModern(boolean modern) {
        this.modern = modern;
    }
    public boolean isLegacy() {
        return legacy;
    }
    public void setLegacy(boolean legacy) {
        this.legacy = legacy;
    }
    public boolean isPauper() {
        return pauper;
    }
    public void setPauper(boolean pauper) {
        this.pauper = pauper;
    }
    public boolean isVintage() {
        return vintage;
    }
    public void setVintage(boolean vintage) {
        this.vintage = vintage;
    }
    public boolean isPenny() {
        return penny;
    }
    public void setPenny(boolean penny) {
        this.penny = penny;
    }
    public boolean isCommander() {
        return commander;
    }
    public void setCommander(boolean commander) {
        this.commander = commander;
    }
    public boolean isOathbreaker() {
        return oathbreaker;
    }
    public void setOathbreaker(boolean oathbreaker) {
        this.oathbreaker = oathbreaker;
    }
    public boolean isStandardbrawl() {
        return standardbrawl;
    }
    public void setStandardbrawl(boolean standardbrawl) {
        this.standardbrawl = standardbrawl;
    }
    public boolean isBrawl() {
        return brawl;
    }
    public void setBrawl(boolean brawl) {
        this.brawl = brawl;
    }
    public boolean isAlchemy() {
        return alchemy;
    }
    public void setAlchemy(boolean alchemy) {
        this.alchemy = alchemy;
    }
    public boolean isPaupercommander() {
        return paupercommander;
    }
    public void setPaupercommander(boolean paupercommander) {
        this.paupercommander = paupercommander;
    }
    public boolean isDuel() {
        return duel;
    }
    public void setDuel(boolean duel) {
        this.duel = duel;
    }
    public boolean isOldschool() {
        return oldschool;
    }
    public void setOldschool(boolean oldschool) {
        this.oldschool = oldschool;
    }
    public boolean isPremodern() {
        return premodern;
    }
    public void setPremodern(boolean premodern) {
        this.premodern = premodern;
    }
    public boolean isPredh() {
        return predh;
    }
    public void setPredh(boolean predh) {
        this.predh = predh;
    }

    @Override
    public String toString() {
        return "standard=" + standard + "    future=" + future + "\nhistoric=" + historic + "    timeless="
                + timeless + "\ngladiator=" + gladiator + "    pioneer=" + pioneer + "\nexplorer=" + explorer
                + "    modern=" + modern + "\nlegacy=" + legacy + "    pauper=" + pauper + "\nvintage=" + vintage
                + "    penny=" + penny + "\ncommander=" + commander + "    oathbreaker=" + oathbreaker + "\nstandardbrawl="
                + standardbrawl + "    brawl=" + brawl + "\nalchemy=" + alchemy + "    paupercommander=" + paupercommander
                + "\nduel=" + duel + "    oldschool=" + oldschool + "\npremodern=" + premodern + "    predh=" + predh;
    }

}
