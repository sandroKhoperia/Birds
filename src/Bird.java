import java.util.ArrayList;
import java.util.UUID;

/**
 * Base class for all birds.
 * In this class all properties are present that are shared among birds.
 */
public abstract class Bird implements IBird, IBirdTypeValidator {


    /**
     * Unique Identifier of the bird. Type: Random UUID is converted to string
     */
    protected final String _id;

    /**
     * Type of the bird. e.g. eagle, parrot, etc.
     */
    protected final BirdType _birdType;

    /**
     * Food Preferences of the bird. e.g. Insects, Larvae, Leaves, etc.
     */
    protected ArrayList<FoodType> _foodPreferences;

    /**
     * Classification of the Bird. e.g. Bird of Prey, Flightless, Parrot, etc.
     */
    protected BirdClassification _classification;

    /**
     * Highlights if the current species of the bird is extinct.
     */
    protected boolean _isExtinct;

    /**
     * Beak characteristic of the bird. e.g. Short and curved with visible nostrils, etc.
     */
    protected Beak _beak;

    /**
     * Number indicating the number of wings the bird has. e.g. 0, 1, 2, etc.
     */
    protected int _numberOfWings;

    /**
     * Constructor. Validates the type of the bird and creates the bird object setting all required
     * member variables that characterize a single bird.
     */
    public Bird(BirdType birdType){
        validateBirdType(birdType);

        _birdType = birdType;
        generateAndSetBeak();
        generateAndSetExtinctionData();
        _foodPreferences = new ArrayList<>();
        generateAndSetFoodPreferences();
        generateAndSetNumberOfWings();

        _id = UUID.randomUUID().toString();
    }

    /**
     * Getter: Retrieves the food preferences of the bird.
     */
    public ArrayList<FoodType> getFoodPreferences(){
        return _foodPreferences;
    }

    /**
     * Getter: Retrieves the number of wings of the bird.
     */
    public int getNumberOfWings(){
        return _numberOfWings;
    }

    /**
     * Getter: Retrieves the type of the bird.
     */
    public BirdType getBirdType(){
        return _birdType;
    }

    /**
     * Getter: Retrieves the unique identifier of the bird.
     */
    public String getId(){
        return _id;
    }

    /**
     * Getter: Retrieves the extinction state of the bird.
     */
    public boolean checkIfExtinct(){
        return _isExtinct;
    }

    /**
     * Getter: Retrieves the beak of the bird.
     */
    public Beak getBeak(){
        return _beak;
    }

    /**
     * Getter: Retrieves the classification of the bird.
     */
    public BirdClassification getBirdClassification(){
        return _classification;
    }

    public abstract void validateBirdType(BirdType birdType);


    /**
     * Base implementation of the creating and setting extinction state of the bird. Is overridden in some subclasses.
     */
    protected void generateAndSetExtinctionData() {
        _isExtinct = false;
    }

    /**
     * Base implementation of the creating and setting number of wings of the bird. Is overridden in some subclasses.
     */
    protected void generateAndSetNumberOfWings() {
        _numberOfWings = 2;
    }

    /**
     * Provides signature for implementation. Generates and sets beak of the bird. Is overridden in some subclasses.
     */
    protected abstract void generateAndSetBeak();

    /**
     * Provides signature for implementation. Generates and sets food preferences of the bird. Is overridden in some subclasses.
     */
    protected abstract void generateAndSetFoodPreferences();

    /**
     * Base toString method. Represents the current bird by its characteristics.
     * Is overridden in several subclasses to compose complete representation
     */
    @Override
    public String toString() {
        var foodStr = new StringBuilder();
        for(int i = 0; i < _foodPreferences.size(); ++i){
            foodStr.append(_foodPreferences.get(i).toString().toLowerCase());
            if(i < _foodPreferences.size()  - 1)
                foodStr.append(", ");
        }
        return String.format("Name:%s, Bird Classification:%s, Number of Wings:%s, IsExtinct:%s" +
                "\n"+"Beak:%s, Food Preferences:%s",
                _birdType.toString().toLowerCase(), _classification.toString().toLowerCase(), _numberOfWings, _isExtinct, _beak.toString(), foodStr);
    }
}

