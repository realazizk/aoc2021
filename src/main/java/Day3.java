import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Day3 {
    public int solve(String input) {
        ArrayList<String> array = new ArrayList<>();
        Collections.addAll(array, input.split(System.lineSeparator()));
        int result = 0;
        int num_bits = array.get(0).length();
        for (int i = 0; i < num_bits; ++ i) {
            int occ_one = 0, occ_zero = 0;
            for (String line: array) {
                if (line.charAt(i) == '0') {
                    occ_zero += 1;
                } else if (line.charAt(i) == '1') {
                    occ_one += 1;
                }
            }
            result <<= 1;
            if (occ_one > occ_zero) {
                result |= 1;
            }

        }
        return result * (~result & ((1 << num_bits) -1 ));
    }

    public int get_rating(List<String> array, BiFunction<Integer, Integer, Character> func) {
        List<String> array1 = new ArrayList<>(array);
        int num_bits = array1.get(0).length();
        for (int i = 0; (i < num_bits) && array1.size() > 1; ++i) {
            int occ_one = 0, occ_zero = 0;
            for (String line: array1) {
                if (line.charAt(i) == '0') {
                    occ_zero += 1;
                } else if (line.charAt(i) == '1') {
                    occ_one += 1;
                }
            }
            char filter_out = func.apply(occ_one, occ_zero);
            final int l = i;
            array1 = array1.stream().filter(x -> x.charAt(l) == filter_out).collect(Collectors.toList());
        }

        return Integer.parseInt(array1.get(0), 2);
    }

    public int solve2(String input) {
        List<String> array = new ArrayList<>();
        Collections.addAll(array, input.split(System.lineSeparator()));

        return this.get_rating(array, (v1, v2) -> v1 >= v2 ? '0' : '1') * this.get_rating(array, (v1, v2) -> v1 >= v2 ? '1' : '0');
    }
}
