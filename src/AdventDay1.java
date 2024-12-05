import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Day1 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/input");
        ArrayList<Integer> array1 = new ArrayList<Integer>();
        ArrayList<Integer> array2 = new ArrayList<Integer>();

        for (int i = 0; i < fileData.size(); i++) {
            String[] splitValues = fileData.get(i).split("   ");
            array1.add(Integer.parseInt(splitValues[0]));
            array2.add(Integer.parseInt(splitValues[1]));
        }

        Collections.sort(array1);
        Collections.sort(array2);

        //part 1
        int difference = 0;
        for (int i = 0; i < array1.size(); i++) {
            difference += Math.abs(array1.get(i) - array2.get(i));
        }
        System.out.println(difference);

        //part 2
        int count = 0;
        int simScore = 0;
        for (int i = 0; i < array1.size(); i++) {
            for (int j = 0; j < array1.size(); j++) {
                if (array1.get(i).equals(array2.get(j))) {
                    count++;
                }
            }
            simScore += array1.get(i) * count;
            count = 0;
        }
        System.out.println(simScore);
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}