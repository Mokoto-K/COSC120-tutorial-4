import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FindADog {

    public static void main(String[] args) {
        System.out.println("Hello pup");

        FindADog fn = new FindADog();
        AllDogs ad = new AllDogs();

        // Print out and check that all dogs worked.
        System.out.println(fn.loadAllDogs().allDogs);


    }

    public AllDogs loadAllDogs() {
        // Initiating an Alldogs object to add dog objects to from the database
        AllDogs allDogs = new AllDogs();

        // File path
        String filePath = "./allDogs.txt";
        Path path = Path.of(filePath);

        try {
            List<String> dogsFromFile = Files.readAllLines(path);
            // Iterating through every line in the database
            for (String line : dogsFromFile) {
                // Splitting up the string that is read in
                String[] dogDetails = line.split(",");

                // Check for the headings, and skip them
                if (dogDetails[0].equalsIgnoreCase("name")) {continue;}

                // assigning the split line to all the dog attributes
                String name = dogDetails[0];
                long microchip = Long.parseLong(dogDetails[1]);
                String sex = dogDetails[2];

                // Assigning true or false to the yes or no answer
                boolean deSexed = dogDetails[3].equalsIgnoreCase("yes");
                int age = Integer.parseInt(dogDetails[4]);
                String breed = dogDetails[5];

                Dog dog = new Dog(name, microchip, sex, deSexed, age, breed);

                allDogs.addDog(dog);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return allDogs;
    }
}
