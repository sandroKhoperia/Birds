/**
 * FlightlessBird class: Inherits from Bird, implements and overrides some functionalities.
 * Represents Flightless classification birds
 */
public final class FlightlessBird extends Bird {
    /**
     * Constructor: Calls constructor of the Bird class, and performs validation
     * @param birdType creates Flightless bird object based on bird type provided.
     */
    public FlightlessBird(BirdType birdType) {
        super(birdType);
        _classification = BirdClassification.FLIGHTLESS;
    }

    /**
     * Overrides the base validation method.
     * checks whether the bird type corresponds to Flightless bird classification
     */
    @Override
    public void validateBirdType(BirdType birdType){
        if(birdType != BirdType.KIWI && birdType != BirdType.EMU && birdType != BirdType.MOA)
            throw new IllegalArgumentException("Invalid bird type provided for flightless bird");
    }

    @Override
    protected void generateAndSetBeak() {
        _beak = new Beak(BeakSize.LONG, BeakType.CURVED, false, false);
    }


    @Override
    protected void generateAndSetFoodPreferences() {
       _foodPreferences.add(FoodType.LARVAE);
       _foodPreferences.add(FoodType.FRUITS);
    }

    /**
     * Setter Override: Implements setter for extinction state
     * Sets extinction parameter to true if the bird type is anything other than kiwi
     */
    @Override
    protected void generateAndSetExtinctionData(){
        _isExtinct = _birdType != BirdType.KIWI;
    }

    /**
     * Setter Override: Implements setter for number of wings
     * Sets number of wings to 0 as Flightless birds often do not have wings
     */
    @Override
    protected void generateAndSetNumberOfWings() {
        _numberOfWings = 0;
    }

    /**
     * Overrides Bird toString implementation. Adds feature that is unique for Owl
     * returns string representation of the Flightless bird object
     */
    @Override
    public String toString() {
        return super.toString()+"\n"+"Flightless birds live on the ground and have no (or undeveloped) wings";
    }
}
