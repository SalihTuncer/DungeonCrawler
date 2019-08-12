package FileSystem;

import Character.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Load extends FileSystem {

    public Load() {

    }

    @Override
    public void processFile(Player player) {

        File[] listOfFiles = new File(System.getProperty("user.dir") +
                "/src/main/resources/saved_games/").listFiles();
        System.out.println("================================");
        System.out.println("These are your saved games:");
        if (listOfFiles != null) {
            Arrays.stream(listOfFiles).forEach((i) ->
                    System.out.println(i.getName().substring(0, i.getName().length() - 4)));
            System.out.print("Which saved game do you wanna load?:");
            loadWhichOne(new Scanner(System.in).nextLine().toLowerCase(), player);
        } else
            System.out.println("There are no saved games.");
        System.out.println("================================\n");
    }

    private void loadWhichOne(String input, Player player) {
        File csvFile = new File(System.getProperty("user.dir") + "/src/main/resources/saved_games/" +
                input + ".csv");
        if (!csvFile.isFile()) {
            System.out.println("This saved game does not exist.");
            System.out.print("Pls enter a valid option pls:");
            loadWhichOne(new Scanner(System.in).nextLine().toLowerCase(), player);
            return;
        }
        try {
            //the file is being prepared to read
            BufferedReader csv = new BufferedReader(new FileReader(csvFile));
            //the csv-file is separated with commas and needs to be split into each element
            String[] data = csv.readLine().split(",");
            //now the attributes get set
            player.setName(data[0]);
            player.setHp(Integer.parseInt(data[1]));
            player.setAtk(Integer.parseInt(data[2]));
            player.setArmor(Integer.parseInt(data[3]));
            player.setMResistance(Integer.parseInt(data[4]));
            player.setDex(Integer.parseInt(data[5]));
            player.setLvl(Integer.parseInt(data[6]));
            player.setXp(Integer.parseInt(data[7]));
            /*we need to generate an enemy equivalent to the lvl of the current player
            this is less overhead than to import the enemy character too. */
            player.generateEnemy();
            System.out.println("You have successfully loaded the saved game.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

