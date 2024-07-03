import java.util.HashSet;
import java.util.Set;

public class AllDogs {

    Set<Dog> allDogs = new HashSet<>();

    public void addDog(Dog dog){
        allDogs.add(dog);
    }

    /**
     * This function takes in a dog object which was created by the user and a set of dogs, which is generated via
     * the available dog in the database, and compares the users dog against the database dogs to see if any match
     * the users dpecifications/ If there are anuy then they are added to a new set and returned
     * @param userDog - a dog object created or initialized from the ansewerts asked to our custimer
     * @param dogsInDatabase - the set of dogs from the database
     * @return - a new set of dogs that match all the criteria set out by our customer
     */
    public Set<Dog> compareDogs (Dog userDog, Set<Dog> dogsInDatabase) {
        Set<Dog> matchedDogs = new HashSet<>();

        // TODO Fix this statement up as I dont think it does what i want it to... when shit crashes in half an hour
        // you'll find why right here.
        for (Dog dog : dogsInDatabase) {
            if (dogsInDatabase.contains(dog)) {matchedDogs.add(dog);}
        }
        return matchedDogs;
    }

}
