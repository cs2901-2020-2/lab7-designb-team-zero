import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Test
public class FizzBuzzTest {

    public void testCase0() throws IOException {
        generic(0);
    }

    public void testCase1() throws IOException {
        generic(1);
    }
    public void testCase2() throws IOException {
        generic(2);
    }
    public void testCase3() throws IOException {
        generic(3);
    }

    private void generic(int i) throws IOException {
        int n = readInput(i);
        List<String> expectedOutput = readOutput(i);
        List<String> response = FizzBuzz.calculate(n);
        Assert.assertEquals(response, expectedOutput);
    }

    private int readInput(int testNumber){
        List<String> lines = readFile(testNumber, "input");
        int n = Integer.parseInt(lines.get(0));
        return n;
    }

    private List<String> readOutput(int testNumber){
        List<String> lines = readFile(testNumber, "output");
        return lines;
    }

    public List<String> readFile(int testNumber, String type){
        String fileName = "test_case<testNumber>_<type>";
        fileName = fileName.replace("<testNumber>", Integer.toString(testNumber));
        fileName = fileName.replace("<type>", type);
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        Scanner scan = new Scanner(is);
        List<String> lines = new ArrayList<String>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.add(line);
        }
        return lines;
    }
}
