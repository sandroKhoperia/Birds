/**
 * Pigeon class: Inherits from Bird, implements and overrides some functionality and adds milk-feeding feature.
 * Represents Pigeon classification birds
 */
public final class Pigeon extends Bird {
    /**
     * Milk-feeding feature which is unique to Pigeons.
     */
    private final String _feedsWithBirdMilk;

    /**
     * Constructor: Calls constructor of the Bird class, and performs validation
     * @param birdType creates Pigeon object based on bird type provided. Sets Milk-feeding feature parameter.
     */
    public Pigeon(BirdType birdType) {
        super(birdType);
        _classification = BirdClassification.PIGEON;
        _feedsWithBirdMilk = "Pigeons(doves) are known for feeding their young with 'bird milk' like milk of mammals.";
    }

    /**
     * Getter: Retrieves milk-feeding feature of the Pigeon
     */
    public String getFeedingInfo(){
        return _feedsWithBirdMilk;
    }

    /**
     * Overrides the base validation method.
     * checks whether the bird type corresponds to Pigeon classification
     */
    @Override
    public void validateBirdType(BirdType birdType){
        if(birdType != BirdType.DOVE && birdType != BirdType.PIGEON)
            throw new IllegalArgumentException("Invalid bird type provided for pigeon or dove");
    }

    /**
     * Implements beak creation method.
     * Creates beak according to Pigeon specification
     */
    @Override
    protected void generateAndSetBeak() {
        _beak = new Beak(BeakSize.SHORT, BeakType.CURVED, false, false);
    }

    /**
     * Setter Override: Implements setter for food preferences
     * adds food types specific to the Pigeon to the food preferences parameter of Bird
     */
    @Override
    protected void generateAndSetFoodPreferences() {
        _foodPreferences.add(FoodType.SEEDS);
        _foodPreferences.add(FoodType.INSECTS);
        _foodPreferences.add(FoodType.LARVAE);
    }

    /**
     * Overrides Bird toString implementation. Adds feature that is unique for Owl
     * returns string representation of the Pigeon object
     */
    @Override
    public String toString() {
        return super.toString()+"\n"+_feedsWithBirdMilk;
    }
}
