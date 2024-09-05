package Day36of45;

import java.util.*;

public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, List<Integer>> gr = new HashMap<>();

        for (int[] p : adjacentPairs) {
            gr.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
            gr.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
        }

        for (Map.Entry<Integer, List<Integer>> entry : gr.entrySet()) {
            if (entry.getValue().size() == 1) {
                ans.add(entry.getKey());
                ans.add(entry.getValue().get(0));
                break;
            }
        }

        while (ans.size() < gr.size()) {
            int lastElement = ans.get(ans.size() - 1);
            int secondLastElement = ans.get(ans.size() - 2);
            List<Integer> ne = gr.get(lastElement);

            if (ne.get(0) != secondLastElement) {
                ans.add(ne.get(0));
            } else {
                ans.add(ne.get(1));
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}