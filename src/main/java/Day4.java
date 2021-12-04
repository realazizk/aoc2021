import java.util.*;

public class Day4 {
    final Integer SIZE = 5;

    class Board {
        class MyKey {
            int idx_x;
            int idx_y;

            public MyKey(int idx_x, int idx_y) {
                this.idx_x = idx_x;
                this.idx_y = idx_y;
            }

            @Override
            public boolean equals(Object o) {
                if (getClass() != o.getClass())
                    return false;
                return (((MyKey) o).idx_x == this.idx_x) && (((MyKey) o).idx_y == this.idx_y);
            }

            @Override
            public int hashCode() {
                return Objects.hash(idx_x, idx_y);
            }

        }


        List<List<Integer>> board;
        int board_idx;
        private HashMap<MyKey, Boolean> hash_map;

        public Board(List<List<Integer>> board, int board_idx) {
            this.board = board;
            this.board_idx = board_idx;
            this.hash_map = new HashMap<>();
        }

        public void mark_board(int idx_x, int idx_y) {
            this.hash_map.put(new MyKey(idx_x, idx_y), true);
        }

        public int elem_at_indices(int idx_x, int idx_y) {
            return this.board.get(idx_x).get(idx_y);
        }

        public boolean is_winning_board() {
            for (int i = 0; i < SIZE; ++ i) {
                boolean found = true;
                for (int j = 0; j < SIZE; ++j) {
                    if (!this.hash_map.getOrDefault(new MyKey(i, j), false)) {
                        found = false;
                    }
                }
                if (found) {
                    return true;
                }
            }
            for (int i = 0; i < SIZE; ++ i) {
                boolean found = true;
                for (int j = 0; j < SIZE; ++j) {
                    if (!this.hash_map.getOrDefault(new MyKey(j, i), false)) {
                        found = false;
                    }
                }
                if (found) {
                    return true;
                }
            }
            return false;
        }

        public int get_some_of_dim_cells() {
            int s = 0;
            for (int i = 0; i < SIZE; ++ i) {
                for (int j = 0; j < SIZE; ++j) {
                    if (!this.hash_map.getOrDefault(new MyKey(i, j), false)) {
                        s += board.get(i).get(j);
                    }
                }
            }

            return s;
        }

        public void print_board() {
            for (int i = 0; i < SIZE; ++ i) {
                for (int j = 0; j < SIZE; ++j) {
                    if (this.hash_map.getOrDefault(new MyKey(i, j), false)) {
                        System.out.print(" X ");
                    } else {
                        System.out.print(String.format("%02d", board.get(i).get(j)) + " ");
                    }
                }
                System.out.println();
            }

        }


    }


    public int solve(String input) {
        int i = 0;
        int j = 0;
        int k = 0;
        List<Integer> numbers = new ArrayList<>();
        List<Board> ll = new ArrayList<>();
        List<List<Integer>> temp = new ArrayList<>(SIZE);

        for (int f = 0; f < SIZE; ++ f) {
            temp.add(new ArrayList<>());
        }
        for (String line: input.split(System.lineSeparator())) {
            if (i == 0) {
                numbers = Arrays.stream(line.split(",")).map(String::strip).map(Integer::parseInt).toList();
                ++ i;
                continue;
            }
            if (!line.isEmpty()) {
                temp.set(j, Arrays.stream(line.split(" ")).filter(x -> !x.isEmpty()).map(String::strip).map(Integer::parseInt).toList());
                ++ j;
            } else if (j != 0) {
                j = 0;
                ll.add(new Board(new ArrayList<>(temp), k));
                ++ k;
            }
            ++i ;
        }
        ll.add(new Board(new ArrayList<>(temp), k));

        for (Integer number: numbers) {
            for (int board_idx = 0; board_idx <= k; ++board_idx) {
                Board board = ll.get(board_idx);
                for (int i1 = 0; i1 < SIZE; ++ i1) {
                    for (int j1 = 0; j1 < SIZE; ++ j1) {
                        if (Objects.equals(board.elem_at_indices(i1, j1), number)) {
                            board.mark_board(i1, j1);
                            if (board.is_winning_board()) {
                                return board.get_some_of_dim_cells() * number;
                            }
                        }
                    }
                }

            }
        }
        return 0;
    }

    public int solve2(String input) {
        int i = 0;
        int j = 0;
        int k = 0;
        List<Integer> numbers = new ArrayList<>();
        List<Board> ll = new ArrayList<>(100);
        List<List<Integer>> temp = new ArrayList<>(SIZE);
        for (int f = 0; f < SIZE; ++ f) {
            temp.add(new ArrayList<>());
        }

        for (String line: input.split(System.lineSeparator())) {
            if (i == 0) {
                numbers = Arrays.stream(line.split(",")).map(String::strip).map(Integer::parseInt).toList();
                ++ i;
                continue;
            }
            if (!line.isEmpty()) {
                temp.set(j, Arrays.stream(line.split(" ")).filter(x -> !x.isEmpty()).map(String::strip).map(Integer::parseInt).toList());
                ++ j;
            } else if (j != 0) {
                j = 0;
                ll.add(new Board(new ArrayList<>(temp), k));
                ++ k;
            }
            ++i ;
        }
        ll.add(new Board(new ArrayList<>(temp), k));

        int sol;
        Set<Integer> winning_boards = new HashSet<>();
        for (Integer number: numbers) {
            for (int board_idx = 0; board_idx <= k; ++board_idx) {
                Board board = ll.get(board_idx);
                for (int i1 = 0; i1 < SIZE; ++ i1) {
                    for (int j1 = 0; j1 < SIZE; ++ j1) {
                        if (Objects.equals(board.elem_at_indices(i1, j1), number)) {
                            board.mark_board(i1, j1);
                            if (!winning_boards.contains(board_idx) && board.is_winning_board()) {
                                sol = board.get_some_of_dim_cells() * number;
                                winning_boards.add(board_idx);
                                boolean found =  true;
                                for (int cc =0; cc <= k; ++cc) {
                                    if (!winning_boards.contains(cc)) {
                                        found = false;
                                        break;
                                    }
                                }
                                if (found) {
                                    return sol;
                                }
                            }
                        }
                    }
                }

            }
        }

        return 0;
    }
}