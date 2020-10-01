package ms;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFileTest {
    public static List<String> readFile(int testNumber, String type){
        String fileName = "test_case<testNumber>_<type>";
        fileName = fileName.replace("<testNumber>", Integer.toString(testNumber));
        fileName = fileName.replace("<type>", type);
        InputStream is = ReadFileTest.class.getClassLoader().getResourceAsStream(fileName);
        Scanner scan = new Scanner(is);
        List<String> lines = new ArrayList<String>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.add(line);
        }
        return lines;
    }

    static int readInput(int testNumber){
        List<String> lines = readFile(testNumber, "input");
        int n = Integer.parseInt(lines.get(0));
        return n;
    }

    List<String> readOutput(int testNumber){
        List<String> lines = readFile(testNumber, "output");
        return lines;
    }

}
