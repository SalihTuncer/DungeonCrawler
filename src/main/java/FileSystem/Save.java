package FileSystem;

import Character.Player;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class Save extends FileSystem {

    public Save(Player player) {
        super(player);
    }

    @Override
    protected void processFile(Player player) {
        //the user is asked what the name of the file should be
        String nameOfFile = getScanner().nextLine().toLowerCase();
        if (!Pattern.matches("[a-z1-9]*", nameOfFile)) {
            System.out.print("This is not a valid filename. Pls give a valid name:");
            processFile(player);
            return;
        }
        try {
            FileWriter csvReader = new FileWriter(System.getProperty("user.dir") +
                    "/src/main/resources/saved_games/" + nameOfFile + ".csv");
            //get all attributes, join them with commas and append them to the csv-file
            csvReader.append(String.join(",", player.getAllAttributes()));
            csvReader.flush();
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
