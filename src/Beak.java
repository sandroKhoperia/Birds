/**
 * Beak class. Represents a beak as a whole object with its properties, getters, setters and toString override.
 */
public final class Beak {

    /**
     * Size of the beak. e.g. SHORT, LONG represented by the enum.
     */
    private final BeakSize _beakSize;

    /**
     * Type of the beak. e.g. HOOKED, CURVED represented by the enum.
     */
    private final BeakType _beakType;

    /**
     * Determines how sharp the beak is.
     */
    private final boolean _isSharp;

    /**
     * Determines if nostrils of the beak are visible.
     */
    private final boolean _hasVisibleNostrils;

    /**
     * Constructor. Creates the beak object and sets parameters to the member variables.
     */
    public Beak(BeakSize beakSize,  BeakType beakType, boolean isSharp,boolean hasVisibleNostrils){
        _beakSize = beakSize;
        _beakType = beakType;
        _isSharp = isSharp;
        _hasVisibleNostrils = hasVisibleNostrils;
    }

    /**
     * Getter: retrieves the type of the beak.
     */
    public BeakType getBeakType(){
        return _beakType;
    }

    /**
     * Getter: retrieves the size of the beak.
     */
    public BeakSize getBeakSize(){
        return _beakSize;
    }

    /**
     * Getter: retrieves the sharpness state of the beak.
     */
    public boolean IsSharp(){
        return _isSharp;
    }

    /**
     * Getter: retrieves the nostril visibility of the beak.
     */
    public boolean HasVisibleNostrils(){
        return _hasVisibleNostrils;
    }

    /**
     * toString override method. String representation of the beak.
     */
    @Override
    public String toString() {
        return String.format("%s,%s,IsSharp:%s,HasVisibleNostrils:%s", _beakSize.toString().toLowerCase(),
                _beakType.toString().toLowerCase(), _isSharp, _hasVisibleNostrils);
    }
}
