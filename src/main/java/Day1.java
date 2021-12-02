import java.util.ArrayList;

public class Day1 {
    int getMeasurments(ArrayList<Integer> xx) {
        int no_times = 0;
        for (int i = 1; i < xx.size(); ++ i) {
            if (xx.get(i) > xx.get(i -1)) {
                no_times += 1;
            }
        }
        return no_times;
    }

    int solve(String content) {
        ArrayList<Integer> xx = new ArrayList<>();
        for (String line: content.split(System.lineSeparator())) {
            int x = Integer.parseInt(line);
            xx.add(x);
        }
        return this.getMeasurments(xx);
    }

    int solve2(String content) {
        ArrayList<Integer> xx = new ArrayList<>();
        for (String line: content.split(System.lineSeparator())) {
            int x = Integer.parseInt(line);
            xx.add(x);
        }

        ArrayList<Integer> dd = new ArrayList<>();
        for (int i = 0; i < xx.size() - 2; ++ i) {
            dd.add( xx.get(i) + xx.get(i + 1) + xx.get(i + 2) );
        }

        return this.getMeasurments(dd);
    }
}
