import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class AdventDay3 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day3_input");
        ArrayList<String> matchedStr = new ArrayList<String>();
        ArrayList<String> matchedStr2 =  new ArrayList<String>();

        StringBuilder str = new StringBuilder();
        for (String data : fileData) {
            str.append(data);
        }

        String regex = "mul\\([0-9]{1,3},[0-9]{1,3}\\)";
        String regexTwo = "mul\\([0-9]{1,3},[0-9]{1,3}\\)|do\\(\\)|don't\\(\\)";
        Matcher m = Pattern.compile(regex).matcher(str);
        Matcher n = Pattern.compile(regexTwo).matcher(str);
        while (m.find()) {
            matchedStr.add(m.group(0));
        }
        while (n.find()) {
            matchedStr2.add(n.group(0));
        }

        int sum = 0;
        for (String mul : matchedStr) {
            int num1 = Integer.parseInt(mul.substring(4, mul.indexOf(",")));
            int num2 = Integer.parseInt(mul.substring(mul.indexOf(",") + 1, mul.indexOf(")")));
            sum += num1 * num2;
        }
        System.out.println(sum);

        int sum2 = 0;
        boolean check = true;
        for (String mul : matchedStr2) {
            if (mul.equals("do()")) {
                check = true;
            } else if (mul.equals("don't()")) {
                check = false;
            } else if (check) {
                int num1 = Integer.parseInt(mul.substring(4, mul.indexOf(",")));
                int num2 = Integer.parseInt(mul.substring(mul.indexOf(",") + 1, mul.indexOf(")")));
                sum2 += num1 * num2;
            }
        }
        System.out.println(sum2);
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
