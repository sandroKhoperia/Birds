/**
 * Class Representation of Waterfowls. Inherits from WaterBird class, implements and overrides some functionality.
 */
public final class Waterfowl extends WaterBird {

    /**
     * Constructor: Creates Waterfowls object. Calls WaterBird constructor, performs type validation and initializes fields.
     */
    public Waterfowl(BirdType birdType) {
        super(birdType);
        _classification = BirdClassification.WATERFOWL;
    }

    /**
     * Overrides the base validation method.
     * checks whether the bird type corresponds to Waterfowls classification
     */
    @Override
    public void validateBirdType(BirdType birdType) {
        if(birdType != BirdType.DUCK && birdType != BirdType.GOOSE && birdType != BirdType.SWAN)
            throw new IllegalArgumentException("Invalid bird type provided for waterfowl");
    }

    /**
     * Setter Override: Implements setter for food preferences
     * adds food types specific to the Waterfowls to the food preferences parameter of Bird
     */
    @Override
    protected void generateAndSetFoodPreferences() {
        super.generateAndSetFoodPreferences();
        _foodPreferences.add(FoodType.SEEDS);
        _foodPreferences.add(FoodType.LEAVES);
    }
}
