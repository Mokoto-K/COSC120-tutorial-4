import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FindADog {

    public static void main(String[] args) {
        System.out.println("Hello pup");

        // Creating an instance of this class to call its methods
        FindADog fn = new FindADog();
        // Creating an instance of the alldogs class to access its methods
        AllDogs ad = new AllDogs();
        // Assigning a dog call sog from the matchedDog method, passing in the users
        // requested dog and the set of dogs from the database
        Dog sog = ad.matchedDog(fn.userDreamDog(), fn.loadAllDogs().allDogs);

        // If the users dog matches a fog in the database, then they can choose to adopt
        // If they choose to adopt, they enter their details and it is output to a file
        // else I curse them.
        if (sog != null) {
            String choice = JOptionPane.showInputDialog("Would you like to adopt " +sog.getName() +"  "
                    + sog.getMicrochip());
            if (choice.equalsIgnoreCase("yes")) {
                Person customer = fn.userInfo();
                fn.addContactInfo(customer, sog);
            }
            else {
                JOptionPane.showMessageDialog(null, "You're heartless, I curse you and your" +
                        "family for 6 generations");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "No pup matched you request");
        }
        // Print out and check that all dogs worked.
//        System.out.println(fn.loadAllDogs().allDogs);

    }

    /**
     * Reads a database of dog information, takes each line from the database and splits up
     *  the relevant dog information and sends it to the dog class to turn the information
     *  into dog objects, then appends those objects to a set and returns an AllDogs object
     *  of that set.
     * @return AllDogs object containing a set of dog objects converted from a database using
     * the dogs class.
     */
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

    /**
     * Asks the user a series of questions about a dog to find out what there dream dog looks like and creates a
     * dog object from all the user inputs to later use to compare against the database
     * @return a dog object of all the users dream traits
     */
    public Dog userDreamDog(){
        JOptionPane.showMessageDialog(null,"Welcome to adopt a pup, may I please take your order");
        String breed = JOptionPane.showInputDialog("Wat breed of pup you lookin` for?");

        String sex = JOptionPane.showInputDialog("Male of female?");

        boolean deSexed = Boolean.parseBoolean(JOptionPane.showInputDialog("Desexed? true or false"));

        int age = Integer.parseInt(JOptionPane.showInputDialog("How old?"));

        return new Dog(breed, sex, deSexed, age);

    }

    /**
     * Gathers all the neccessary information on the user if they choose to adopt a puppy from the database.
     * @return a person object that contains the users name, email, phone number.
     */
    public Person userInfo() {
        String name = JOptionPane.showInputDialog("Pleas enter your first and last name");
        String email = JOptionPane.showInputDialog("Please enter your email address");
        String number = JOptionPane.showInputDialog("Please enter your phone number");

        return new Person(name, email, number);
    }

    /**
     * If the user request to adopt a dog, they are required to fill in information about themselve
     * this method taks that information as well as the dof they wish to adopt and it saves that
     * information ato a dile to be contacted later on about the dog
     * @param p - A Person object containing the name, email and number of the customer
     * @param d - A dog object that matches one of the dogs in our database
     */
    public void addContactInfo(Person p, Dog d) {
        List<String> names = List.of(p.name.split(" "));
        String pupDetails = d.getName() + " ("+d.getMicrochip()+"). ";
        String message = names.get(0) + " " + names.get(1) + " wishes to adopt " + pupDetails +
                "Their phune number is " + p.number + " and their email address is: " + p.email;

        File newFile = new File(names.get(0) + "_" + names.get(1) + "_adoption_request.txt");

        try {
            FileWriter write = new FileWriter(newFile);
            write.write(message);
            write.close();
        }
        catch (IOException e) {
            System.out.println("SystemERROR. SystemERROR. SystemERROR. SystemERROR. SystemERROR. " +
                    "SELF DESTRUCT IN 5...4...3...2...");
        }

    }

}
