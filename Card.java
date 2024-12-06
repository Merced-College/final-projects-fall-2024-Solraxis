package DeckListBuddy;
import java.util.ArrayList;

public class Card {
    private int arena_id;
    protected String id;
    private String lang;
    private int mtgo_id;
    private int mtgo_foil_id;
    private ArrayList<Integer> multiverse_ids = new ArrayList<Integer>();
    private int tcgplayer_id;
    private int tcgplayer_etched_id;
    private int cardmarket_id;
    protected String object; //always "card"
    private String layout;
    private String oracle_id;
    private String prints_search_uri;
    private String rulings_uri;
    private String scryfall_uri;
    protected String uri;
    private RelatedCard all_parts; //related card object
    protected CardFaces card_faces = new CardFaces(); //card face object
    protected double mana_value;
    protected ArrayList<String> color_identity = new ArrayList<String>();
    protected ArrayList<String> color_indicator = new ArrayList<String>();
    protected ArrayList<String> colors = new ArrayList<String>();
    protected String defense;
    protected int edhrec_rank;
    protected String hand_modifier;
    protected ArrayList<String> keywords = new ArrayList<String>();
    protected Legality legalities = new Legality();
    protected String life_modifier;
    protected String loyalty; //Can be X, otherwise numbers
    protected String mana_cost; //Missing mana value != {0}
    protected String name;
    protected String oracle_text;
    protected int penny_rank;
    protected String power;
    protected ArrayList<String> produced_mana = new ArrayList<String>();
    protected boolean reserved;
    protected String toughness;
    protected String type_line;
    protected String artist;
    protected ArrayList<String> artist_ids = new ArrayList<String>();
    private ArrayList<Integer> attraction_lights = new ArrayList<Integer>();
    private boolean booster;
    private String card_back_id;
    private String collector_number;
    private boolean content_warning;
    private boolean digital;
    private ArrayList<String> finishes = new ArrayList<String>();
    private String flavor_name;
    private String flavor_text;
    private ArrayList<String> frame_effects = new ArrayList<String>();
    private String frame;
    private boolean full_art;
    private ArrayList<String> games = new ArrayList<String>();
    private boolean highres_image;
    private String illustration_id;
    private String image_status;
    protected ImageUris img_uris = new ImageUris(); //URI object
    private boolean oversized;
    protected Prices prices = new Prices(); //Prices object
    private String printed_name;
    private String printed_text;
    private String printed_type_line;
    private boolean promo;
    private ArrayList<String> promo_types = new ArrayList<String>();
    protected RelatedUris purchase_uris = new RelatedUris(); //Purchase URI object
    private String rarity;
    private String released_at;
    private boolean reprint;
    private String scryfall_set_uri;
    private String set_name;
    private String set_uri;
    private String set;
    private String set_id;
    private boolean story_spotlight;
    private boolean textless;
    private boolean variation;
    private String variation_of;
    private String watermark;
    private String security_stamp;
    protected String[] nameId = new String[2];

    

    public void setNameId(String name, String id) {
        nameId[0] = name;
        nameId[1] = id;
    }
    public String[] getNameId(){
        return nameId;
    }

    public int getArena_id() {
        return arena_id;
    }
    public void setArena_id(int arena_id) {
        this.arena_id = arena_id;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getLang() {
        return lang;
    }
    public void setLang(String lang) {
        this.lang = lang;
    }
    public int getMtgo_id() {
        return mtgo_id;
    }
    public void setMtgo_id(int mtgo_id) {
        this.mtgo_id = mtgo_id;
    }
    public int getMtgo_foil_id() {
        return mtgo_foil_id;
    }
    public void setMtgo_foil_id(int mtgo_foil_id) {
        this.mtgo_foil_id = mtgo_foil_id;
    }
    public ArrayList<Integer> getMultiverse_ids() {
        return multiverse_ids;
    }
    public void setMultiverse_ids(int multiverse_ids) {
        this.multiverse_ids.add(multiverse_ids);
    }
    public int getTcgplayer_id() {
        return tcgplayer_id;
    }
    public void setTcgplayer_id(int tcgplayer_id) {
        this.tcgplayer_id = tcgplayer_id;
    }
    public int getTcgplayer_etched_id() {
        return tcgplayer_etched_id;
    }
    public void setTcgplayer_etched_id(int tcgplayer_etched_id) {
        this.tcgplayer_etched_id = tcgplayer_etched_id;
    }
    public int getCardmarket_id() {
        return cardmarket_id;
    }
    public void setCardmarket_id(int cardmarket_id) {
        this.cardmarket_id = cardmarket_id;
    }
    public String getObject() {
        return object;
    }
    public void setObject(String object) {
        this.object = object;
    }
    public String getLayout() {
        return layout;
    }
    public void setLayout(String layout) {
        this.layout = layout;
    }
    public String getOracle_id() {
        return oracle_id;
    }
    public void setOracle_id(String oracle_id) {
        this.oracle_id = oracle_id;
    }
    public String getPrints_search_uri() {
        return prints_search_uri;
    }
    public void setPrints_search_uri(String prints_search_uri) {
        this.prints_search_uri = prints_search_uri;
    }
    public String getRulings_uri() {
        return rulings_uri;
    }
    public void setRulings_uri(String rulings_uri) {
        this.rulings_uri = rulings_uri;
    }
    public String getScryfall_uri() {
        return scryfall_uri;
    }
    public void setScryfall_uri(String scryfall_uri) {
        this.scryfall_uri = scryfall_uri;
    }
    public String getUri() {
        return uri;
    }
    public void setUri(String uri) {
        this.uri = uri;
    }
    public RelatedCard getAll_parts() {
        return all_parts;
    }
    public void setAll_parts(RelatedCard all_parts) {
        this.all_parts = all_parts;
    }
    public CardFaces getCard_faces() {
        return card_faces;
    }
    public double getMana_value() {
        return mana_value;
    }
    public void setMana_value(double mana_value) {
        this.mana_value = mana_value;
    }
    public ArrayList<String> getColor_identity() {
        return color_identity;
    }
    public void setColor_identity(String color_identity) {
        this.color_identity.add(color_identity);
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
    public int getEdhrec_rank() {
        return edhrec_rank;
    }
    public void setEdhrec_rank(int edhrec_rank) {
        this.edhrec_rank = edhrec_rank;
    }
    public String getHand_modifier() {
        return hand_modifier;
    }
    public void setHand_modifier(String hand_modifier) {
        this.hand_modifier = hand_modifier;
    }
    public ArrayList<String> getKeywords() {
        return keywords;
    }
    public void setKeywords(String keywords) {
        this.keywords.add(keywords);
    }
    //public Legality getLegalities() {
        //return legalities;
    //}
    //public void setLegalities(Legality legalities) {
    //    this.legalities = legalities;
    //}
    public String getLife_modifier() {
        return life_modifier;
    }
    public void setLife_modifier(String life_modifier) {
        this.life_modifier = life_modifier;
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
    public String getOracle_text() {
        return oracle_text;
    }
    public void setOracle_text(String oracle_text) {
        this.oracle_text = oracle_text;
    }
    public int getPenny_rank() {
        return penny_rank;
    }
    public void setPenny_rank(int penny_rank) {
        this.penny_rank = penny_rank;
    }
    public String getPower() {
        return power;
    }
    public void setPower(String power) {
        this.power = power;
    }
    public ArrayList<String> getProduced_mana() {
        return produced_mana;
    }
    public void setProduced_mana(String produced_mana) {
        this.produced_mana.add(produced_mana);
    }
    public boolean isReserved() {
        return reserved;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
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
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public ArrayList<String> getArtist_ids() {
        return artist_ids;
    }
    public void setArtist_ids(String artist_ids) {
        this.artist_ids.add(artist_ids);
    }
    public ArrayList<Integer> getAttraction_lights() {
        return attraction_lights;
    }
    public void setAttraction_lights(int attraction_lights) {
        this.attraction_lights.add(attraction_lights);
    }
    public boolean isBooster() {
        return booster;
    }
    public void setBooster(boolean booster) {
        this.booster = booster;
    }
    public String getCard_back_id() {
        return card_back_id;
    }
    public void setCard_back_id(String card_back_id) {
        this.card_back_id = card_back_id;
    }
    public String getCollector_number() {
        return collector_number;
    }
    public void setCollector_number(String collector_number) {
        this.collector_number = collector_number;
    }
    public boolean isContent_warning() {
        return content_warning;
    }
    public void setContent_warning(boolean content_warning) {
        this.content_warning = content_warning;
    }
    public boolean isDigital() {
        return digital;
    }
    public void setDigital(boolean digital) {
        this.digital = digital;
    }
    public ArrayList<String> getFinishes() {
        return finishes;
    }
    public void setFinishes(String finishes) {
        this.finishes.add(finishes);
    }
    public String getFlavor_name() {
        return flavor_name;
    }
    public void setFlavor_name(String flavor_name) {
        this.flavor_name = flavor_name;
    }
    public String getFlavor_text() {
        return flavor_text;
    }
    public void setFlavor_text(String flavor_text) {
        this.flavor_text = flavor_text;
    }
    public ArrayList<String> getFrame_effects() {
        return frame_effects;
    }
    public void setFrame_effects(String frame_effects) {
        this.frame_effects.add(frame_effects);
    }
    public String getFrame() {
        return frame;
    }
    public void setFrame(String frame) {
        this.frame = frame;
    }
    public boolean isFull_art() {
        return full_art;
    }
    public void setFull_art(boolean full_art) {
        this.full_art = full_art;
    }
    public ArrayList<String> getGames() {
        return games;
    }
    public void setGames(String games) {
        this.games.add(games);
    }
    public boolean isHighres_image() {
        return highres_image;
    }
    public void setHighres_image(boolean highres_image) {
        this.highres_image = highres_image;
    }
    public String getIllustration_id() {
        return illustration_id;
    }
    public void setIllustration_id(String illustration_id) {
        this.illustration_id = illustration_id;
    }
    public String getImage_status() {
        return image_status;
    }
    public void setImage_status(String image_status) {
        this.image_status = image_status;
    }
    public ImageUris getImage_uris() {
        return img_uris;
    }
    public boolean isOversized() {
        return oversized;
    }
    public void setOversized(boolean oversized) {
        this.oversized = oversized;
    }
    public Prices getPrices() {
        return prices;
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
    public boolean isPromo() {
        return promo;
    }
    public void setPromo(boolean promo) {
        this.promo = promo;
    }
    public ArrayList<String> getPromo_types() {
        return promo_types;
    }
    public void setPromo_types(String promo_types) {
        this.promo_types.add(promo_types);
    }
    public String getRarity() {
        return rarity;
    }
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
    public String getReleased_at() {
        return released_at;
    }
    public void setReleased_at(String released_at) {
        this.released_at = released_at;
    }
    public boolean isReprint() {
        return reprint;
    }
    public void setReprint(boolean reprint) {
        this.reprint = reprint;
    }
    public String getScryfall_set_uri() {
        return scryfall_set_uri;
    }
    public void setScryfall_set_uri(String scryfall_set_uri) {
        this.scryfall_set_uri = scryfall_set_uri;
    }
    public String getSet_name() {
        return set_name;
    }
    public void setSet_name(String set_name) {
        this.set_name = set_name;
    }
    public String getSet_uri() {
        return set_uri;
    }
    public void setSet_uri(String set_uri) {
        this.set_uri = set_uri;
    }
    public String getSet() {
        return set;
    }
    public void setSet(String set) {
        this.set = set;
    }
    public String getSet_id() {
        return set_id;
    }
    public void setSet_id(String set_id) {
        this.set_id = set_id;
    }
    public boolean isStory_spotlight() {
        return story_spotlight;
    }
    public void setStory_spotlight(boolean story_spotlight) {
        this.story_spotlight = story_spotlight;
    }
    public boolean isTextless() {
        return textless;
    }
    public void setTextless(boolean textless) {
        this.textless = textless;
    }
    public boolean isVariation() {
        return variation;
    }
    public void setVariation(boolean variation) {
        this.variation = variation;
    }
    public String getVariation_of() {
        return variation_of;
    }
    public void setVariation_of(String variation_of) {
        this.variation_of = variation_of;
    }
    public String getWatermark() {
        return watermark;
    }
    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }
    public String getSecurity_stamp() {
        return security_stamp;
    }
    public void setSecurity_stamp(String security_stamp) {
        this.security_stamp = security_stamp;
    }
}