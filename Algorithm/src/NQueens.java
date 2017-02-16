import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NQueens {

    public static class Position {
        private final int row;
        private final int column;

        private Position(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        @Override
        public String toString() {
            return String.format("(%d,%d)", row, column);
        }
    }

    public static class Solution {
        public final Position[] solution;

        private Solution(Position[] solution) {
            super();
            this.solution = solution;
        }

        public Position[] getPositions() {
            return Arrays.copyOf(solution, solution.length);
        }

        private char[] padChars(char[] chars) {
            char[] ret = new char[chars.length * 2 - 1];
            Arrays.fill(ret, ' ');
            for (int i = 0; i < chars.length; i++) {
                ret[i * 2] = chars[i];
            }
            return ret;
        }

        @Override
        public String toString() {
            int size = solution.length;
            char[][] board = new char[size][size];
            for (int i = 0; i < size; i++) {
                board[i] = new char[size];
                Arrays.fill(board[i], '\u02d1');
            }
            for (Position p : solution) {
                board[p.getRow()][p.getColumn()] = 'Q';
            }
            char[] border = new char[size];
            Arrays.fill(border, '-');

            StringBuilder sb = new StringBuilder((size + 2) * (size + 3));
            sb.append(" ").append(padChars(border)).append(" \n");
            for (int i = 0; i < size; i++) {
                sb.append("|").append(padChars(board[i])).append("|\n");
            }
            sb.append(" ").append(padChars(border)).append(" \n");
            return sb.toString();
        }

    }

    public static Solution[] solve(final int size) {

        final List<Solution> solutions = new ArrayList<>();

        // each candidate is a 1-bit in a different column.
        final int[] candidates = new int[size];
        for (int i = 0; i < size; i++) {
            candidates[i] = 1 << i;
        }

        // recursive call
        search(0, new int[size], candidates, solutions);

        return solutions.toArray(new Solution[solutions.size()]);
    }

    private static void search(final int depth, final int[] queens,
            final int[] candidates, final List<Solution> solutions) {
        if (depth == queens.length) {
            // solved it.
            Position[] locations = new Position[queens.length];
            for (int i = 0; i < queens.length; i++) {
                locations[i] = new Position(i, queens[i]);
            }
            solutions.add(new Solution(locations));
            return;
        }

        int mask = 0;
        for (int i = 0; i < depth; i++) {
            int queen = candidates[queens[i]];
            mask |= queen; // previous queens cover this column....
            mask |= queen >>> (depth - i); // previous queens cover this
                                           // diagonal to the right.
            mask |= queen << (depth - i); // previous queens cover this diagonal
                                          // to the left.
        }

        for (int i = 0; i < candidates.length; i++) {
            if ((candidates[i] & mask) == 0) {
                // then we are not in the same column, row, or diagonal as
                // another queen.
                queens[depth] = i;
                search(depth + 1, queens, candidates, solutions);
            }
        }

    }

    private static final void timeFunction(String name, Runnable task) {
        long start = System.nanoTime();

        task.run();

        long time = System.nanoTime() - start;
        System.out.printf("Ran task: %s in %.3fms%n", name, time / 1000000.0);

    }

    public static void main(String[] args) {
        timeFunction("WarmUp 100x5", () -> {
            for (int i = 0; i < 100; i++) {
                solve(5);
            }
        });
        timeFunction("WarmUp 100x8", () -> {
            for (int i = 0; i < 100; i++) {
                solve(8);
            }
        });

        IntStream.rangeClosed(1, 14).forEach(
                size -> timeFunction("Size " + size,
                        () -> report(size, solve(size))));

        Solution[] solutions = solve(8);
        for (int i = 0; i < solutions.length; i++) {
            System.out.printf("Soltion %d of %d for size %d:%n%s%n", i + 1,
                    solutions.length, 8, solutions[i]);
        }
    }

    private static void report(int size, Solution[] solve) {
        System.out.printf("Solved %d size with %d solutions%n", size,
                solve.length);
    }

}