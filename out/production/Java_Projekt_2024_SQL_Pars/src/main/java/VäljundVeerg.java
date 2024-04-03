package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VäljundVeerg {
    public List<String> test(String failinimi) {
        StringBuilder sqlBuilder = new StringBuilder();

        try {
            Scanner scanner = new Scanner(new File(failinimi));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.toUpperCase().contains("FROM")) {
                    sqlBuilder.append(line.substring(0, line.toUpperCase().indexOf("FROM")));
                    break;
                }
                sqlBuilder.append(line).append("\n");
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> väljund = new ArrayList<>();
        String query = String.valueOf(sqlBuilder);
        Pattern pattern = Pattern.compile("AS\\s+(\\w+)");
        Matcher matcher = pattern.matcher(query);
        String selectPart = query.substring(query.indexOf("SELECT") + "SELECT".length(), query.indexOf("CASE"));


        Pattern pattern2 = Pattern.compile("\\.\\w+");
        Matcher matcher2 = pattern2.matcher(selectPart);

        //Pattern pattern3 = pattern.hashCode( "\\b(\\w+)\\.(\\w+)\\b");

        int i = 0;
        while (matcher2.find()) {
            String word2 = matcher2.group().substring(1);
            väljund.add(word2);
        }

        while (matcher.find()) {
            String word = matcher.group(1);
            väljund.add(word);
        }
        return väljund;

    }




}
