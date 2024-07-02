/**
 * This class handles and manages our dog objects
 */
public class Dog {

    // TODO Assign these correct public/private status
    private String name;
    private long microchip;
    private String breed;
    private String sex;
    private boolean deSexed;
    private int age;

    /**
     * Constructor for dog objects
     */
    public Dog() {

    }

    /**
     * Getter for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for microchip
     * @return micropchip
     */
    public long getMicrochip() {
        return microchip;
    }

    /**
     * Getter for breed
     * @return breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Getter for sex
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Getter for deSexed
     * @return deSexed
     */
    public boolean getDeSexed() {
        return deSexed;
    }

    /**
     * Getter for age
     * @return age
     */
    public int getAge() {
        return age;
    }

    public void setDeSexed(boolean deSexed) {
        this.deSexed = deSexed;
    }

}

