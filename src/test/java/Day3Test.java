import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Files;

import static org.junit.jupiter.api.Assertions.*;

class Day3Test {
    Day3 day3;
    @BeforeEach
    void setUp() {
        this.day3 = new Day3();
    }

    @Test
    void solve_sample() {
        String input = "00100\n" +
                "11110\n" +
                "10110\n" +
                "10111\n" +
                "10101\n" +
                "01111\n" +
                "00111\n" +
                "11100\n" +
                "10000\n" +
                "11001\n" +
                "00010\n" +
                "01010";

        int result = this.day3.solve(input);
        assertEquals(198, result);
    }

    @Test
    void solve_problem1() {
        String content = Files.getFileContent("day3_input.txt");
        int result = this.day3.solve(content);
        System.out.println(result);
    }

    @Test
    void solve_sample2() {
        String input = "00100\n" +
                "11110\n" +
                "10110\n" +
                "10111\n" +
                "10101\n" +
                "01111\n" +
                "00111\n" +
                "11100\n" +
                "10000\n" +
                "11001\n" +
                "00010\n" +
                "01010";

        int result = this.day3.solve2(input);
        assertEquals(230, result);
    }

    @Test
    void solve_problem2() {
        String content = Files.getFileContent("day3_input.txt");
        int result = this.day3.solve2(content);
        System.out.println(result);
    }

}