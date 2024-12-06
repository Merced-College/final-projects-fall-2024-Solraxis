package DeckListBuddy;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static Scanner intInput = new Scanner(System.in);

    public static void main(String[] args){
        HashMap<String[], Card> cards = objectizeCards(); //Creates and populates HashMap with Card objects, hashed by a NameID pair [name, id]
        boolean doLoop = true; //Used in tryAgain() when user is asked if they would like to search another card

        while(doLoop){ //Main function loop
        System.out.println("Welcome to Kevin's Super Mmazing Magic: the Gathering Tool!\nPlease choose a function to start.  Type 'Card' for card analysis or 'Deck' for deck analysis.");
        String r = input.nextLine();
        if(r.equalsIgnoreCase("card")){
            System.out.println("Search a card: ");
            String cardQuery = input.nextLine();
            //System.out.println(cardQuery);
            ArrayList<String[]> cardQueries = searchCard(cardQuery, cards); //Uses method searchCard to populate ArrayList with names containing the string cardQuery

            int queryCount = 1; //Start queryCount at 1 because it will be displayed in a list and starting at 1 is more human-readable.
            for(String[] query : cardQueries){ //Loops through each element in the ArrayList, printing a short preview of relevant info
                System.out.println(queryCount + ": " + cards.get(query).getName() + "  " + cards.get(query).getType_line());
                System.out.println("Mana Cost: [" + cards.get(query).getMana_cost() + "] Set: " + cards.get(query).getSet_name() + "\n");
                queryCount++;
            }

            boolean isCorrectCard = false; //similar to doLoop, to account for the user choosing a card that exists within the list
            int cardToChoose;
            while(!isCorrectCard){
                System.out.print("Enter the number of the correct card:");
                cardToChoose = input.nextInt() - 1; //takes in nextInt()-1 to account for queryCount starting at 1
                if(cardToChoose <= queryCount){
                    isCorrectCard = true;
                    
                    for(int i = 0; i < 5; i++){
                        System.out.println("********************************"); //prints a divider to help with formatting
                    }
                    printCard(cards, cardQueries, cardToChoose); //moved large print block to separate function
                    
                }else{
                    System.out.println("Invalid number chosen.  Try again."); //error checking if the user entered a number outside bounds of CardQueries.size()
                }
            }

        }
        else if(r.equalsIgnoreCase("deck")){
            ArrayList<String[]> deckNameIds = readDeck(cards);
            double averageManaValue = 0.0;
            double averagePriceUSD = 0.0;
            int count = 0;
            
            for(String[] nameId : deckNameIds){
                System.out.println(count++ + ": " + cards.get(nameId).getName() + "  " + cards.get(nameId).getType_line());
                System.out.println("Mana Cost: [" + cards.get(nameId).getMana_cost() + "] Set: " + cards.get(nameId).getSet_name() + "\n");
                averageManaValue += cards.get(nameId).getMana_value();
                //averagePriceUSD += Double.parseDouble(cards.get(nameId).prices.getUsd()); //price data is stored as strings, so I have to parse the string to use the number

            }
            averageManaValue = averageManaValue/deckNameIds.size(); //divide sum by total to get average
            //averagePriceUSD = averagePriceUSD/deckNameIds.size();

            System.out.println("Average Mana Value: " + averageManaValue);
           
        }
        else {
            System.out.print("Input not recognized.  ");
        }

        doLoop = tryAgain();
        }//end doLoop
    }

    public static ArrayList<String[]> readDeck(HashMap<String[], Card> cards){
        ArrayList<String[]> cardNameIds = new ArrayList<String[]>();//Contains 1 nameId per entry per card per quantity (4x Card name -> 4 entries of Card name)
        int t = 0;
        String regex = "(\\d+)x\\s+(.+)"; //delimiter string used to split decklist at card quantities and card names.  ChatGPT Assisted with making this string
        Pattern pattern = Pattern.compile(regex);
        try{
            File deckList = new File("decklist.txt"); //decklist.txt can be any decklist available from websites such as archidekt.com in the format "1 Card Name\n"
            Scanner readDeck = new Scanner(deckList);
            while(readDeck.hasNextLine()){
                String line = readDeck.nextLine();
                Matcher matcher = pattern.matcher(line);//Uses matcher to find instances of the regex delimiter in String line.
                if(matcher.matches()){ //if the delimiter is found (will happen on every line)
                    int quantity = Integer.parseInt(matcher.group(1));
                    String name = matcher.group(2);
                    for(int i = 0; i < quantity; i++){ //for loop to add 1 entry to cardNameIds per copy of card in the deck (4x CardName -> 4 entries in cardNameIds)
                        cardNameIds.add(searchCard(name, cards).get(0));
                    }
                }
                
            }
        }catch(IOException e){}
        return cardNameIds;
    }

    public static void printCard(HashMap<String[], Card> cards, ArrayList<String[]> cardQueries, int cardToChoose){
        System.out.println();
        System.out.println("Card name: " + cards.get(cardQueries.get(cardToChoose)).getName() + "  " + cards.get(cardQueries.get(cardToChoose)).getType_line());
        System.out.println("Mana Cost: [" + cards.get(cardQueries.get(cardToChoose)).getMana_cost() + "] Set: " + cards.get(cardQueries.get(cardToChoose)).getSet_name());
        System.out.println("Artist: " + cards.get(cardQueries.get(cardToChoose)).getArtist() + "  Rarity: " + cards.get(cardQueries.get(cardToChoose)).getRarity());
        if(cards.get(cardQueries.get(cardToChoose)).getType_line().contains("Creature")){
            System.out.println(cards.get(cardQueries.get(cardToChoose)).getPower() + " / " + cards.get(cardQueries.get(cardToChoose)).getToughness());
        }
        if(cards.get(cardQueries.get(cardToChoose)).getType_line().contains("Planeswalker")){
            System.out.println("Starting Loyalty: " + cards.get(cardQueries.get(cardToChoose)).getLoyalty());
        }
        if(cards.get(cardQueries.get(cardToChoose)).getType_line().contains("Battle")){
            System.out.println("Starting Defense: " + cards.get(cardQueries.get(cardToChoose)).getDefense());
        }
        if(cards.get(cardQueries.get(cardToChoose)).getOracle_text() != null){
            System.out.println("Oracle Text:\n" + cards.get(cardQueries.get(cardToChoose)).getOracle_text());
        }
        if(cards.get(cardQueries.get(cardToChoose)).getFlavor_text() != null){
            System.out.println("Flavor Text:\n" + cards.get(cardQueries.get(cardToChoose)).getFlavor_text());
        }
        
        System.out.println("Legalities:\n" + cards.get(cardQueries.get(cardToChoose)).legalities.toString());
        System.out.println("Prices:\n" + cards.get(cardQueries.get(cardToChoose)).prices.toString());

        if(cards.get(cardQueries.get(cardToChoose)).card_faces.getName() != null){
            System.out.println("Other faces: " + cards.get(cardQueries.get(cardToChoose)).card_faces.toString());
        }
    }

    public static ArrayList<String[]> searchCard(String cardQuery, HashMap<String[], Card> cards){
        ArrayList<String[]> cardQueries = new ArrayList<String[]>();
        for(String[] nameIds : cards.keySet()){
            if(nameIds[0].contains(cardQuery)){
                cardQueries.add(nameIds);
            }
        }
        return cardQueries;
    }

    public static boolean tryAgain(){
        while(true){
            System.out.println("Would you like to look at another card?  Y/N");
            String r = input.nextLine();
            if(r.equalsIgnoreCase("n")){
                return false;
            }
            else if(r.equalsIgnoreCase("y")){
                return true;
            }
            else {
                System.out.println("Input not recognized. Input a correct value to continue.");
            }
        } 
    }

    public static HashMap<String[], Card> objectizeCards(){
        HashMap<String[], Card> cards = new HashMap<String[], Card>();
        try (JsonReader reader = new JsonReader(new FileReader("oracle-cards.json"))) {
            reader.beginArray();
            while (reader.hasNext()) {
                reader.beginObject();
                Card card = new Card();

                while (reader.hasNext()) {
                    String name = reader.nextName();
                    switch (name) {
                        case "arena_id":
                            card.setArena_id(reader.nextInt());
                            break;

                        case "id":
                            card.setId(reader.nextString());
                            break;

                        case "lang":
                            card.setLang(reader.nextString());
                            break;

                        case "mtgo_id":
                            card.setMtgo_id(reader.nextInt());
                            break;

                        case "mtgo_foil_id":
                            card.setMtgo_foil_id(reader.nextInt());
                            break;

                        case "multiverse_ids":
                            reader.beginArray();
                            while (reader.hasNext()) {
                                card.setMultiverse_ids(reader.nextInt());
                            }
                            reader.endArray();
                            break;

                        case "tcgplayer_id":
                            card.setTcgplayer_id(reader.nextInt());
                            break;

                        case "tcgplayer_etched_id":
                            card.setTcgplayer_etched_id(reader.nextInt());
                            break;

                        case "cardmarket_id":
                            card.setCardmarket_id(reader.nextInt());
                            break;

                        case "object":
                            card.setObject(reader.nextString());
                            break;

                        case "layout":
                            card.setLayout(reader.nextString());
                            break;

                        case "oracle_id":
                            card.setOracle_id(reader.nextString());
                            break;

                        case "prints_search_uri":
                            card.setPrints_search_uri(reader.nextString());
                            break;

                        case "rulings_uri":
                            card.setRulings_uri(reader.nextString());
                            break;

                        case "scryfall_uri":
                            card.setScryfall_uri(reader.nextString());;
                            break;

                        case "uri":
                            card.setUri(reader.nextString());
                            break;

                        case "all_parts":
                            reader.beginArray();
                            while(reader.hasNext()){
                                reader.beginObject();
                                RelatedCard related_card = new RelatedCard();
                                while(reader.hasNext()){
                                    String r_name = reader.nextName();
                                    switch (r_name) {
                                        case "id":
                                            related_card.setId(reader.nextString());
                                            break;

                                        case "object":
                                            related_card.setObject(reader.nextString());
                                            break;
                                        
                                        case "component":
                                            related_card.setComponent(reader.nextString());
                                            break;
                                        
                                        case "name":
                                            related_card.setName(reader.nextString());
                                            break;

                                        case "type_line":
                                            related_card.setType_line(reader.nextString());
                                            break;

                                        case "uri":
                                            related_card.setUri(reader.nextString());
                                            break;
                                    
                                        default:
                                            reader.skipValue();
                                            break;
                                    }  
                                }
                                reader.endObject();
                            }
                            reader.endArray();
                            break;

                        case "card_faces":
                            reader.beginArray();
                            while(reader.hasNext()){
                                reader.beginObject();
                                while(reader.hasNext()){
                                    String f_name = reader.nextName();
                                    switch(f_name){
                                        case"artist": 
                                            card.card_faces.setArtist(reader.nextString());
                                            break;
                                        
                                        case "artist_id":
                                            card.card_faces.setDefense(reader.nextString());
                                            break;
                                            
                                        case "cmc":
                                            card.card_faces.setMana_value(reader.nextDouble());
                                            break;

                                        case "color_indicator":
                                            reader.beginArray();
                                            while(reader.hasNext()){
                                                card.card_faces.setColor_indicator(reader.nextString());
                                            }
                                            reader.endArray();
                                            break;

                                        case "colors":
                                            reader.beginArray();
                                            while(reader.hasNext()){
                                                card.card_faces.setColors(reader.nextString());
                                            }
                                            reader.endArray();
                                            break;
                                        
                                        case "defense":
                                            card.card_faces.setDefense(reader.nextString());
                                            break;

                                        case "flavor_text":
                                            card.card_faces.setFlavor_text(reader.nextString());
                                            break;

                                        case "illustration_id":
                                            card.card_faces.setIllustration_id(reader.nextString());
                                            break;

                                        case "image_uris":
                                            reader.beginObject();
                                            while(reader.hasNext()){
                                                String i_name = reader.nextName();
                                                switch(i_name){
                                                    case "small":
                                                        card.img_uris.setSmall(reader.nextString());
                                                        break;

                                                    case "normal":
                                                        card.img_uris.setNormal(reader.nextString());
                                                        break;

                                                    case "large":
                                                        card.img_uris.setLarge(reader.nextString());
                                                        break;

                                                    case "png":
                                                        card.img_uris.setPng(reader.nextString());
                                                        break;

                                                    case "art_crop":
                                                        card.img_uris.setArt_crop(reader.nextString());
                                                        break;

                                                    case "border_crop":
                                                        card.img_uris.setBorder_crop(reader.nextString());
                                                        break;
                                                    
                                                    default:
                                                        reader.skipValue();
                                                        break;
                                                }
                                            }
                                            reader.endObject();
                                            break;

                                        case "layout":
                                            card.card_faces.setLayout(reader.nextString());
                                            break;

                                        case "loyalty":
                                            card.card_faces.setLoyalty(reader.nextString());
                                            break;

                                        case "mana_cost":
                                            card.card_faces.setMana_cost(reader.nextString());
                                            break;

                                        case "name":
                                            card.card_faces.setName(reader.nextString());
                                            break;

                                        case "object":
                                            card.card_faces.setObject(reader.nextString());
                                            break;

                                        case "oracle_id":
                                            card.card_faces.setOracle_id(reader.nextString());
                                            break;

                                        case "oracle_text":
                                            card.card_faces.setOracle_text(reader.nextString());
                                            break;

                                        case "power":
                                            card.card_faces.setPower(reader.nextString());
                                            break;

                                        case "printed_name":
                                            card.card_faces.setPrinted_name(reader.nextString());
                                            break;

                                        case "printed_text":
                                            card.card_faces.setPrinted_text(reader.nextString());
                                            break;

                                        case "printed_type_line":
                                            card.card_faces.setPrinted_type_line(reader.nextString());
                                            break;

                                        case "toughness":
                                            card.card_faces.setToughness(reader.nextString());
                                            break;

                                        case "type_line":
                                            card.card_faces.setType_line(reader.nextString());
                                            break;

                                        case "watermark":
                                            card.card_faces.setWatermark(reader.nextString());
                                            break;

                                        default:
                                            reader.skipValue();
                                            break;
                                    }
                                }
                                reader.endObject();
                            }
                            reader.endArray();
                            break;

                        case "cmc":
                            card.setMana_value(reader.nextDouble());
                            break;

                        case "color_identity":
                            reader.beginArray();
                            while(reader.hasNext()){
                                card.setColor_identity(reader.nextString());
                            }
                            reader.endArray();
                            break;

                        case "color_indicator":
                            reader.beginArray();
                            while(reader.hasNext()){
                                card.setColor_indicator(reader.nextString());
                            }
                            reader.endArray();
                            break;

                        case "colors":
                            reader.beginArray();
                            while(reader.hasNext()){
                                card.setColors(reader.nextString());
                            }
                            reader.endArray();
                            break;

                        case "defense":
                            card.setDefense(reader.nextString());
                            break;

                        case "edhrec_rank":
                            card.setDefense(reader.nextString());
                            break;

                        case "hand_modifier":
                            card.setHand_modifier(reader.nextString());
                            break;

                        case "keywords":
                            reader.beginArray();
                            while(reader.hasNext()){
                                card.keywords.add(reader.nextString());
                            }
                            reader.endArray();
                            break;

                        case "legalities":
                            reader.beginObject();
                            while(reader.hasNext()){
                                String l_name = reader.nextName();
                                switch(l_name){
                                    case "standard":
                                        card.legalities.setStandard(card.legalities.isLegal(reader.nextString()));
                                        break;
                                    
                                    case "future":
                                        card.legalities.setFuture(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "historic":
                                        card.legalities.setHistoric(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "timeless":
                                        card.legalities.setTimeless(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "gladiator":
                                        card.legalities.setGladiator(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "pioneer":
                                        card.legalities.setPioneer(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "explorer":
                                        card.legalities.setExplorer(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "modern":
                                        card.legalities.setModern(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "legacy":
                                        card.legalities.setLegacy(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "pauper":
                                        card.legalities.setPauper(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "vintage":
                                        card.legalities.setVintage(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "penny":
                                        card.legalities.setPenny(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "commander":
                                        card.legalities.setCommander(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "oathbreaker":
                                        card.legalities.setOathbreaker(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "standardbrawl":
                                        card.legalities.setStandardbrawl(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "brawl":
                                        card.legalities.setBrawl(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "alchemy":
                                        card.legalities.setAlchemy(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "paupercommander":
                                        card.legalities.setPaupercommander(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "duel":
                                        card.legalities.setDuel(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "oldschool":
                                        card.legalities.setOldschool(card.legalities.isLegal(reader.nextString()));
                                        break;
                                    
                                    case "premodern":
                                        card.legalities.setPremodern(card.legalities.isLegal(reader.nextString()));
                                        break;

                                    case "predh":
                                        card.legalities.setPredh(card.legalities.isLegal(reader.nextString()));
                                        break;
                                    
                                    default:
                                        reader.skipValue();
                                        break;
                                }
                            }
                            reader.endObject();
                            break;

                        case "life_modifier":
                            card.setLife_modifier(reader.nextString());
                            break;

                        case "loyalty":
                            card.setLoyalty(reader.nextString());
                            break; // Can be X, otherwise numbers

                        case "mana_cost":
                            card.setMana_cost(reader.nextString());
                            break; // Missing mana value != {0}

                        case "name":
                            card.setName(reader.nextString());
                            card.setNameId(card.getName(), card.getId());
                            break;

                        case "oracle_text":
                            card.setOracle_text(reader.nextString());
                            break;

                        case "penny_rank":
                            card.setPenny_rank(reader.nextInt());
                            break;

                        case "power":
                            card.setPower(reader.nextString());
                            break;

                        case "produced_mana":
                            reader.beginArray();
                            while(reader.hasNext()){
                                card.setProduced_mana(reader.nextString());
                            }
                            reader.endArray();
                            break;

                        case "reserved":
                            card.setReserved(reader.nextBoolean());
                            break;

                        case "toughness":
                            card.setToughness(reader.nextString());
                            break;

                        case "type_line":
                            card.setType_line(reader.nextString());
                            break;

                        case "artist":
                            card.setArtist(reader.nextString());
                            break;

                        case "artist_ids":
                            reader.beginArray();
                            while(reader.hasNext()){
                                card.setArtist_ids(reader.nextString());
                            }
                            reader.endArray();
                            break;

                        case "attraction_lights":
                            reader.beginArray();
                            while(reader.hasNext()){
                                card.setAttraction_lights(reader.nextInt());
                            }
                            reader.endArray();
                            break;

                        case "booster":
                            card.setBooster(reader.nextBoolean());
                            break;

                        case "card_back_id":
                            card.setCard_back_id(reader.nextString());
                            break;

                        case "collector_number":
                            card.setCollector_number(reader.nextString());
                            break;

                        case "content_warning":
                            card.setContent_warning(reader.nextBoolean());
                            break;

                        case "digital":
                            card.setDigital(reader.nextBoolean());
                            break;

                        case "finishes":
                            reader.beginArray();
                            while(reader.hasNext()){
                                card.setFinishes(reader.nextString());
                            }
                            reader.endArray();
                            break;

                        case "flavor_name":
                            card.setFlavor_name(reader.nextString());
                            break;

                        case "flavor_text":
                            card.setFlavor_text(reader.nextString());
                            break;

                        case "frame_effects":
                            reader.beginArray();
                            while(reader.hasNext()){
                                card.setFrame_effects(reader.nextString());
                            }
                            reader.endArray();
                            break;

                        case "frame":
                            card.setFrame(reader.nextString());
                            break;

                        case "full_art":
                            card.setFull_art(reader.nextBoolean());
                            break;

                        case "games":
                            reader.beginArray();
                            while(reader.hasNext()){
                                card.setGames(reader.nextString());
                            }
                            reader.endArray();
                            break;

                        case "highres_image":
                            card.setHighres_image(reader.nextBoolean());
                            break;

                        case "illustration_id":
                            card.setIllustration_id(reader.nextString());
                            break;

                        case "image_status":
                            card.setImage_status(reader.nextString());
                            break;

                        case "image_uris":
                        reader.beginObject();
                        ImageUris img_uris = new ImageUris();
                        while(reader.hasNext()){
                            String i_name = reader.nextName();
                            switch(i_name){
                                case "small":
                                    img_uris.setSmall(reader.nextString());
                                    break;

                                case "normal":
                                    img_uris.setNormal(reader.nextString());
                                    break;

                                case "large":
                                    img_uris.setLarge(reader.nextString());
                                    break;

                                case "png":
                                    img_uris.setPng(reader.nextString());
                                    break;

                                case "art_crop":
                                    img_uris.setArt_crop(reader.nextString());
                                    break;

                                case "border_crop":
                                    img_uris.setBorder_crop(reader.nextString());
                                    break;
                                    
                                default:
                                    reader.skipValue();
                                    break;
                                }
                            }
                            reader.endObject();
                            break;
                        

                        case "oversized":
                            card.setOversized(reader.nextBoolean());
                            break;

                        case "prices":
                        reader.beginObject();
                        while(reader.hasNext()){
                            String p_name = reader.nextName();
                            switch (p_name){
                                case "usd":
                                    if(reader.peek() == JsonToken.NULL){
                                        card.prices.setUsd("null");
                                        reader.nextNull();
                                    }else{
                                        card.prices.setUsd(reader.nextString());
                                    }
                                    break;
                        
                                case "usd_foil":
                                    if(reader.peek() == JsonToken.NULL){
                                        card.prices.setUsd_foil("null");
                                        reader.nextNull();
                                    }else{
                                        card.prices.setUsd_foil(reader.nextString());
                                    }
                                    break;

                                case "usd_etched":
                                    if(reader.peek() == JsonToken.NULL){
                                        card.prices.setUsd_etched("null");
                                        reader.nextNull();
                                    }else{
                                        card.prices.setUsd_etched(reader.nextString());
                                    }
                                    break;

                                case "eur":
                                    if(reader.peek() == JsonToken.NULL){
                                        card.prices.setEur("null");
                                        reader.nextNull();
                                    }else{
                                        card.prices.setEur(reader.nextString());
                                    }
                                    break;

                                case "eur_foil":
                                    if(reader.peek() == JsonToken.NULL){
                                        card.prices.setEur_foil("null");
                                        reader.nextNull();
                                    }else{
                                        card.prices.setEur_foil(reader.nextString());
                                    }
                                    break;

                                case "eur_etched":
                                    if(reader.peek() == JsonToken.NULL){
                                        card.prices.setEur_etched("null");
                                        reader.nextNull();
                                    }else{
                                        card.prices.setEur_etched(reader.nextString());
                                    }
                                    break;

                                case "tix":
                                    if(reader.peek() == JsonToken.NULL){
                                        card.prices.setTix("null");
                                        reader.nextNull();
                                    }else{
                                        card.prices.setTix(reader.nextString());
                                    }
                                    break;

                                default:
                                    reader.skipValue();
                                    break;
                            }
                        }
                        reader.endObject();
                        break;

                        case "printed_name":
                            card.setPrinted_name(reader.nextString());
                            break;

                        case "printed_text":
                            card.setPrinted_text(reader.nextString());
                            break;

                        case "printed_type_line":
                            card.setPrinted_type_line(reader.nextString());
                            break;

                        case "promo":
                            card.setPromo(reader.nextBoolean());
                            break;

                        case "promo_types":
                            reader.beginArray();
                            while(reader.hasNext()){
                                card.setPromo_types(reader.nextString());
                            }
                            reader.endArray();
                            break;

                        case "purchase_uris":
                            reader.beginObject();
                            while(reader.hasNext()){
                                String p_name = reader.nextName();
                                switch(p_name){
                                    case "tcgplayer":
                                        card.purchase_uris.setTcgplayer(reader.nextString());
                                        break;

                                    case "cardmarket":
                                        card.purchase_uris.setCardmarket(reader.nextString());
                                        break;

                                    case "cardhoarder":
                                        card.purchase_uris.setCardhoarder(reader.nextString());
                                        break;
                                    
                                    default:
                                        reader.skipValue();
                                        break;
                                }
                            }
                            reader.endObject();
                            break;

                        case "rarity":
                            card.setRarity(reader.nextString());
                            break;

                        case "related_uris":
                            reader.beginObject();
                            while(reader.hasNext()){
                                String r_name = reader.nextName();
                                switch(r_name){
                                    case "gatherer":
                                        card.purchase_uris.setGatherer(reader.nextString());
                                        break;
                                    
                                    case "tcgplayer_infinite_articles":
                                        card.purchase_uris.setTcgplayer_infinite_articles(reader.nextString());
                                        break;

                                    case "tcgplayer_infinite_decks":
                                        card.purchase_uris.setTcgplayer_infinite_decks(reader.nextString());
                                        break;

                                    case "edhrec":
                                        card.purchase_uris.setEdhrec(reader.nextString());
                                        break;

                                    default:
                                        reader.skipValue();
                                        break;
                                }
                            }
                            reader.endObject();
                            break;

                        case "released_at":
                            card.setReleased_at(reader.nextString());
                            break;

                        case "reprint":
                            card.setReprint(reader.nextBoolean());
                            break;

                        case "scryfall_set_uri":
                            card.setScryfall_set_uri(reader.nextString());
                            break;

                        case "set_name":
                            card.setSet_name(reader.nextString());
                            break;

                        case "set_uri":
                            card.setSet_uri(reader.nextString());
                            break;

                        case "set":
                            card.setSet(reader.nextString());
                            break;

                        case "set_id":
                            card.setSet_id(reader.nextString());
                            break;

                        case "story_spotlight":
                            card.setStory_spotlight(reader.nextBoolean());
                            break;

                        case "textless":
                            card.setTextless(reader.nextBoolean());
                            break;

                        case "variation":
                            card.setVariation(reader.nextBoolean());
                            break;

                        case "variation_of":
                            card.setVariation_of(reader.nextString());
                            break;

                        case "watermark":
                            card.setWatermark(reader.nextString());
                            break;

                        case "security_stamp":
                            card.setSecurity_stamp(reader.nextString());
                            break;

                        default:
                            reader.skipValue();
                            break;
                        
                    } // end switch
                } // end name While
                cards.put(card.getNameId(), card);
                reader.endObject();
            } // end object while
            
            reader.endArray();

        } catch (IOException e) {
            System.out.println("Error.  Try again");
            throw new RuntimeException(e);
        }
        return cards;
    }
}
