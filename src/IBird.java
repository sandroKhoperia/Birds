import java.util.ArrayList;

/**
 * Provides method signatures for getters of Bird object
 */
public interface IBird {
    /**
     * Getter: Retrieves the food preferences of the bird.
     */
     ArrayList<FoodType> getFoodPreferences();

    /**
     * Getter: Retrieves the number of wings of the bird.
     */
    int getNumberOfWings();

    /**
     * Getter: Retrieves the type of the bird.
     */
    BirdType getBirdType();

    /**
     * Getter: Retrieves the unique identifier of the bird.
     */
    String getId();

    /**
     * Getter: Retrieves the extinction state of the bird.
     */
     boolean checkIfExtinct();

    /**
     * Getter: Retrieves the beak of the bird.
     */
    Beak getBeak();

    /**
     * Getter: Retrieves the classification of the bird.
     */
    BirdClassification getBirdClassification();
}
