import java.util.ArrayList;
/**
 * Represents the base class for ShoreBird and Waterfowl.
 * Inherits from Bird, implements and overrides some functionality and adds living habitat feature.
 */
public class WaterBird extends Bird {
    /**
     * Stores the preferable living habitats for Shorebirds and Waterfowls.
     */
    protected ArrayList<LivingHabitat> _livingHabitats;

    /**
     * Constructor: Calls constructor of the Bird class, and performs validation
     * @param birdType creates WaterBird object based on bird type provided. sets living habitats for Shorebirds and Waterfowls.
     */
    public WaterBird(BirdType birdType) {
        super(birdType);
        _livingHabitats = new ArrayList<>();
        _livingHabitats.add(LivingHabitat.SALTWATER_SHORELANDS);
        _livingHabitats.add(LivingHabitat.FRESHWATER_SHORELANDS);
    }

    @Override
    public void validateBirdType(BirdType birdType) {
        switch (birdType){
            case GOOSE, SWAN, DUCK, HORNEDPUFFIN, AFRICANJACANA, GREATAUK -> {}
            default -> throw new IllegalArgumentException("Invalid bird type provided for waterbird");
        }
    }

    /**
     * Getter: Retrieves the living habitat preferences for Shorebirds and Waterfowls.
     */
    public ArrayList<LivingHabitat> getLivingHabitats(){
        return _livingHabitats;
    }

    /**
     * Implements beak creation method.
     * Creates beak according to Shorebird and Waterfowl specification
     */
    @Override
    protected void generateAndSetBeak() {
        _beak =  new Beak(BeakSize.LONG, BeakType.CURVED, false,false);
    }

    /**
     * Setter Override: Implements setter for food preferences
     * adds food types shared among Shorebirds and Waterfowls to the food preferences parameter of Bird
     */
    @Override
    protected void generateAndSetFoodPreferences() {
        _foodPreferences.add(FoodType.INSECTS);
    }

    /**
     * Overrides Bird toString implementation. adds features that are shared among Shorebirds and Waterfowls
     * to base representation returns string representation of the Parrot object
     */
    @Override
    public String toString() {
        StringBuilder livingHabitat = new StringBuilder();
        for(int i = 0; i < _livingHabitats.size(); ++i){
            livingHabitat.append(_livingHabitats.get(i));
            if(i < _livingHabitats.size()  - 1)
                livingHabitat.append(", ");
        }
        return super.toString() + "\n"+String.format("Living Habitat:%s", livingHabitat);
    }
}
