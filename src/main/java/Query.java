import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class Query {
    public static void main(String[] args) {
        String fail = "SELECT.sql";
        try (Scanner sc =  new Scanner(new File(fail), "UTF-8")) {
            StringBuilder block = new StringBuilder();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains("FROM")) {
                    processBlock(block.toString());
                    block.setLength(0);
                } else {
                    block.append(line).append('\n');
                }
            }
            if (block.length() > 0) {
                processBlock(block.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void processBlock(String block) {


        System.out.println(block);
    }
}
