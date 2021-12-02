import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Files;


class Day2Test {
    Day2 day2;
    @BeforeEach
    void setUp() {
        this.day2 = new Day2();
    }

    @Test
    void solve_sample() {
        String input = "forward 5\n" +
                "down 5\n" +
                "forward 8\n" +
                "up 3\n" +
                "down 8\n" +
                "forward 2\n";
        try {
            int result = this.day2.solve(input);
            assert result == 150;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void solve_problem1() {
        String content = Files.getFileContent("day2_input.txt");
        int result = 0;
        try {
            result = this.day2.solve(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    @Test
    void solve_problem2() {
        String content = Files.getFileContent("day2_input.txt");
        int result = 0;
        try {
            result = this.day2.solve2(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);


    }
}