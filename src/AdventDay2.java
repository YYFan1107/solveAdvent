import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdventDay2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day2_input");
        ArrayList<Integer> readList = new ArrayList<Integer>();
        int reports = 0;

        for (String numStr : fileData) {
            String[] splitValues = numStr.split(" ");
            for (String splitValue : splitValues) {
                readList.add(Integer.parseInt(splitValue));
            }

            boolean isSafe = true;
            for (int i = 0; i < readList.size() - 1; i++) {
                if (readList.get(i) - readList.get(i + 1) <)
            }
        }
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.isEmpty())
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
