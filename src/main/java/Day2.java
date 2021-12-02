import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 {

    public int solve(String input) throws Exception {
        Pattern pat = Pattern.compile("(forward|down|up)\\s+(\\d+)");
        int x = 0, y = 0;
        for (String line: input.split(System.lineSeparator())) {
            Matcher m = pat.matcher(line);
            if (m.matches()) {
                String where = m.group(1);
                int how_far = Integer.parseInt(m.group(2));

                switch (where) {
                    case "forward" -> x += how_far;
                    case "down" -> y += how_far;
                    case "up" -> y -= how_far;
                }
            } else {
                throw new Exception("line is " + line);
            }
        }
        return y * x;
    }

    public int solve2(String input) throws Exception {
        Pattern pat = Pattern.compile("(forward|down|up)\\s+(\\d+)");
        int x = 0, y = 0;
        int aim = 0;
        for (String line: input.split(System.lineSeparator())) {
            Matcher m = pat.matcher(line);
            if (m.matches()) {
                String where = m.group(1);
                int how_far = Integer.parseInt(m.group(2));

                switch (where) {
                    case "forward" -> {
                        x += how_far;
                        y += aim * how_far;
                    }
                    case "down" -> {
                        aim += how_far;
                    }
                    case "up" -> {
                        aim -= how_far;
                    }
                }
            } else {
                throw new Exception("line is " + line);
            }
        }
        return y * x;
    }
}
