import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FindADog {

    public static void main(String[] args) {
        System.out.println("Hello pup");

        FindADog fn = new FindADog();
        for (String pup : fn.loadAllDogs()) {
            System.out.println(pup);
        }
//        System.out.println(fn.loadAllDogs());
    }

    public List<String> loadAllDogs() {
        // File path
        String filePath = "./allDogs.txt";
        Path path = Path.of(filePath);

        List<String> allPups = null;
        try {
            allPups = Files.readAllLines(path);
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return allPups;
    }

}
