package DeckListBuddy;

import java.util.ArrayList;

public class CardFaces{
    private String artist;
    private String artist_id;
    private double mana_value;
    private ArrayList<String> color_indicator = new ArrayList<String>();
    private ArrayList<String> colors = new ArrayList<String>();
    protected String defense;
    private String flavor_text;
    private String illustration_id;
    protected ImageUris img_uris = new ImageUris(); //URI object
    private String layout;
    private String loyalty;
    private String mana_cost;
    private String name;
    private String object;
    private String oracle_id;
    private String oracle_text;
    private String power;
    private String printed_name;
    private String printed_text;
    private String printed_type_line;
    private String toughness;
    private String type_line;
    private String watermark;


    public String getArtist() {
        return artist;
    }
    @Override
    public String toString() {
        return "CardFaces [artist=" + artist + "\nmana_value=" + mana_value + "\ndefense=" + defense + "\nflavor_text="
                + flavor_text + "\nloyalty=" + loyalty + "\nmana_cost=" + mana_cost + "\nname=" + name
                + "\noracle_text=" + oracle_text + "\npower=" + power + "\ntoughness=" + toughness + "\ntype_line="
                + type_line + "]";
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getArtist_id() {
        return artist_id;
    }
    public void setArtist_id(String artist_id) {
        this.artist_id = artist_id;
    }
    public double getMana_value() {
        return mana_value;
    }
    public void setMana_value(double mana_value) {
        this.mana_value = mana_value;
    }
    public ArrayList<String> getColor_indicator() {
        return color_indicator;
    }
    public void setColor_indicator(String color_indicator) {
        this.color_indicator.add(color_indicator);
    }
    public ArrayList<String> getColors() {
        return colors;
    }
    public void setColors(String colors) {
        this.colors.add(colors);
    }
    public String getDefense() {
        return defense;
    }
    public void setDefense(String defense) {
        this.defense = defense;
    }
    public String getFlavor_text() {
        return flavor_text;
    }
    public void setFlavor_text(String flavor_text) {
        this.flavor_text = flavor_text;
    }
    public String getIllustration_id() {
        return illustration_id;
    }
    public void setIllustration_id(String illustration_id) {
        this.illustration_id = illustration_id;
    }
    public ImageUris getImg_uris() {
        return img_uris;
    }
    public void setImg_uris(ImageUris img_uris) {
        this.img_uris = img_uris;
    }
    public String getLayout() {
        return layout;
    }
    public void setLayout(String layout) {
        this.layout = layout;
    }
    public String getLoyalty() {
        return loyalty;
    }
    public void setLoyalty(String loyalty) {
        this.loyalty = loyalty;
    }
    public String getMana_cost() {
        return mana_cost;
    }
    public void setMana_cost(String mana_cost) {
        this.mana_cost = mana_cost;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getObject() {
        return object;
    }
    public void setObject(String object) {
        this.object = object;
    }
    public String getOracle_id() {
        return oracle_id;
    }
    public void setOracle_id(String oracle_id) {
        this.oracle_id = oracle_id;
    }
    public String getOracle_text() {
        return oracle_text;
    }
    public void setOracle_text(String oracle_text) {
        this.oracle_text = oracle_text;
    }
    public String getPower() {
        return power;
    }
    public void setPower(String power) {
        this.power = power;
    }
    public String getPrinted_name() {
        return printed_name;
    }
    public void setPrinted_name(String printed_name) {
        this.printed_name = printed_name;
    }
    public String getPrinted_text() {
        return printed_text;
    }
    public void setPrinted_text(String printed_text) {
        this.printed_text = printed_text;
    }
    public String getPrinted_type_line() {
        return printed_type_line;
    }
    public void setPrinted_type_line(String printed_type_line) {
        this.printed_type_line = printed_type_line;
    }
    public String getToughness() {
        return toughness;
    }
    public void setToughness(String toughness) {
        this.toughness = toughness;
    }
    public String getType_line() {
        return type_line;
    }
    public void setType_line(String type_line) {
        this.type_line = type_line;
    }
    public String getWatermark() {
        return watermark;
    }
    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }
}
