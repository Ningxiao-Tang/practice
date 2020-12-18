package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) return triangle;
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int row = 1; row < numRows; row++) {
            List<Integer> cur = new ArrayList<>();
            List<Integer> prev = triangle.get(row - 1);

            cur.add(1);

            for (int j = 1; j < row; j++) {
                cur.add(prev.get(j-1) + prev.get(j));
            }
            cur.add(1);
            triangle.add(cur);
        }

        return triangle;
    }
}
