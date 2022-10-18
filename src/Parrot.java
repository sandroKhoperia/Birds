import java.util.ArrayList;
import java.util.HashSet;
/**
 * Parrot class: Inherits from Bird, implements and overrides some functionality and favorite word and vocabulary features.
 */
public final class Parrot extends Bird {
    /**
     * Favorite word the parrot.
     */
    private String _favoriteWord;

    /**
     * Stores the current vocabulary of the parrot up to 100 words.
     */
    private final HashSet<String> _vocabulary;

    /**
     * Constructor: Calls constructor of the Bird class, and performs validation
     * @param birdType creates Parrot object based on bird type provided. sets favorite word and vocabulary.
     */
    public Parrot(BirdType birdType, String favoriteWord, HashSet<String> vocabulary) {
        super(birdType);

        if(vocabulary != null && vocabulary.size() > 100){
                throw new IllegalArgumentException("Parrot vocabulary exceeds the maximum amount words.");
        }

        _classification = BirdClassification.PARROT;
        _favoriteWord = favoriteWord;
        _vocabulary = vocabulary != null ? vocabulary : new HashSet<>();

        if(_favoriteWord != null)
            _vocabulary.add(_favoriteWord);
    }

    /**
     * Teaches parrot a new word. If parrot does not know this word and the number of words
     *  parrot knows is less than 100, adds the word to the vocabulary
     */
    public void teachParrotAWord(String word){
        if(_vocabulary.size() < 100){
            if(!_vocabulary.contains(word)){
                _vocabulary.add(word);
            }
        }
        else{
            throw new IllegalArgumentException("Parrot has exceeded its capacity for learning new words");
        }
    }

    /**
     * Setter: Sets the favorite word for parrot
     */
    public void setFavoriteWord(String word){
        if(!_vocabulary.contains(word))
            _vocabulary.add(word);
        _favoriteWord = word;
    }

    /**
     * Getter: Retrieves the current vocabulary of the parrot.
     */
    public ArrayList<String> getVocabulary(){

        return new ArrayList<>(_vocabulary);
    }

    /**
     * Getter: Retrieves the favorite word of the parrot
     */
    public String getFavoriteWord(){
        return  _favoriteWord;
    }

    /**
     * Overrides the base validation method.
     * checks whether the bird type corresponds to Parrot classification
     */
    @Override
    public void validateBirdType(BirdType birdType){
        if(birdType != BirdType.GRAYPARROT && birdType != BirdType.SULFURCRESTEDCOCKATOO
                && birdType != BirdType.ROSERINGPARAKEET) {
            throw new IllegalArgumentException("Invalid bird type provided for parrot");
        }
    }

    /**
     * Implements beak creation method.
     * Creates beak according to Parrot specification
     */
    @Override
    protected void generateAndSetBeak() {
        _beak  = new Beak(BeakSize.SHORT,BeakType.CURVED,false,false);
    }

    /**
     * Setter Override: Implements setter for food preferences
     * adds food types specific to the Parrot to the food preferences parameter of Bird
     */
    @Override
    protected void generateAndSetFoodPreferences() {
        _foodPreferences.add(FoodType.SEEDS);
        _foodPreferences.add(FoodType.NUTS);
    }

    /**
     * Overrides Bird toString implementation. adds features that are unique for Parrot to base representation
     * returns string representation of the Parrot object
     */
    @Override
    public String toString() {
        return super.toString() + "\n"+String.format("Parrots are known for their intelligence and ability to mimic sounds"+
                " Favorite Word:%s, Total Words Known:%s/100",_favoriteWord,_vocabulary.size());
    }
}
