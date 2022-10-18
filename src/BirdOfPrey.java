/**
 * Bird of Prey class: Inherits from Bird, implements and overrides some functionality.
 */
public final class BirdOfPrey extends Bird {
    /**
     * Constructor: Calls constructor of the Bird class, and performs validation
     * @param birdType creates Bird of Prey class object based on bird type provided. sets facial disk parameter.
     */
    public BirdOfPrey(BirdType birdType) {
        super(birdType);
        _classification = BirdClassification.BIRD_OF_PREY;
    }

    /**
     * Overrides the base validation method.
     * checks whether the bird type corresponds to Bird of Prey class classification
     */
    @Override
    public void validateBirdType(BirdType birdType) {
        if(birdType != BirdType.HAWK && birdType != BirdType.EAGLE && birdType != BirdType.OSPREY)
            throw new IllegalArgumentException("Invalid bird type provided for bird of prey");
    }

    /**
     * Implements beak creation method.
     * Creates beak according to Bird of Prey class specification
     */
    @Override
    protected void generateAndSetBeak() {
       _beak = new Beak(BeakSize.SHORT, BeakType.HOOKED, true, true);
    }

    /**
     * Setter Override: Implements setter for food preferences
     * adds food types specific to the Bird of Prey class to the food preferences parameter of Bird
     */
    @Override
    protected void generateAndSetFoodPreferences() {
        _foodPreferences.add(FoodType.OTHER_BIRDS);
        _foodPreferences.add(FoodType.FISH);
        _foodPreferences.add(FoodType.SMALL_MAMMALS);
    }


}
