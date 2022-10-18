/**
 * Owl class: Inherits from Bird, implements and overrides some functionality and adds facial disk feature.
 */
public final class Owl extends Bird {
    /**
     * Facial disk of the owl which is distinguishable feature
     */
    private final String _facialDisk;

    /**
     * Constructor: Calls constructor of the Bird class, and performs validation
     * @param birdType creates Owl object based on bird type provided. sets facial disk parameter.
     */
    public Owl(BirdType birdType) {
        super(birdType);
        _facialDisk = "facial disks frame the eyes and bill";
        _classification = BirdClassification.OWL;
    }

    /**
     * Getter: Retrieves facial disk feature of the owl
     */
    public String getFacialDisk(){
        return _facialDisk;
    }

    /**
     * Overrides the base validation method.
     * checks whether the bird type corresponds to OWL classification
     */
    @Override
    public void validateBirdType(BirdType birdType){
        if(birdType != BirdType.OWL )
            throw new IllegalArgumentException("Invalid bird type provided for owl");
    }

    /**
     * Implements beak creation method.
     * Creates beak according to Owl specification
     */
    @Override
    protected void generateAndSetBeak() {
        _beak = new Beak(BeakSize.SHORT,BeakType.HOOKED, false, false);
    }

    /**
     * Setter Override: Implements setter for food preferences
     * adds food types specific to the Owl to the food preferences parameter of Bird
     */
    @Override
    protected void generateAndSetFoodPreferences() {
        _foodPreferences.add(FoodType.LEAVES);
        _foodPreferences.add(FoodType.INSECTS);
    }

    /**
     * Overrides Bird toString implementation. Adds feature that is unique for Owl
     * returns string representation of the Owl object
     */
    @Override
    public String toString() {
        return super.toString()+String.format("\nInteresting feature:%s",_facialDisk);
    }
}
