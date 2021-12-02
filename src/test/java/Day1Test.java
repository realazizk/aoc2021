import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Files;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {
    Day1 day1;
    @BeforeEach
    void setUp() {
        this.day1 = new Day1();
    }

    @Test
    void solve_sample() {
        String input = "199\n" +
                "200\n" +
                "208\n" +
                "210\n" +
                "200\n" +
                "207\n" +
                "240\n" +
                "269\n" +
                "260\n" +
                "263";
        int result = this.day1.solve(input);
        assertEquals(result, 7);
    }

    @Test
    void solve_problem1() {
        String content = Files.getFileContent("day1_input.txt");
        int result = this.day1.solve(content);
        System.out.println(result);
    }

    @Test
    void solve_problem2() {
        String content = Files.getFileContent("day1_input.txt");
        int result = this.day1.solve2(content);
        System.out.println(result);

    }
}