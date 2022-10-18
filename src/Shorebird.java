/**
 * Class Representation of Shorebirds. Inherits from WaterBird class, implements and overrides some functionality.
 */
public final class Shorebird extends WaterBird {
    /**
     * Constructor: Creates Shorebird object. Calls WaterBird constructor, performs type validation and initializes fields.
     */
    public Shorebird(BirdType birdType)
    {
        super(birdType);
        _classification = BirdClassification.SHOREBIRD;
        _livingHabitats.add(LivingHabitat.OCEAN);
        _livingHabitats.add(LivingHabitat.WETLAND);
    }

    /**
     * Overrides the base validation method.
     * checks whether the bird type corresponds to ShoreBird classification
     */
    @Override
    public void validateBirdType(BirdType birdType){
        if(birdType != BirdType.GREATAUK && birdType != BirdType.AFRICANJACANA && birdType != BirdType.HORNEDPUFFIN)
            throw new IllegalArgumentException("Invalid bird type provided for shorebird");
    }

    /**
     * Setter Override: Implements setter for food preferences
     * adds food types specific to the Shorebirds to the food preferences parameter of Bird
     */
    @Override
    protected void generateAndSetFoodPreferences() {
        super.generateAndSetFoodPreferences();
        _foodPreferences.add(FoodType.FISH);
    }


}
