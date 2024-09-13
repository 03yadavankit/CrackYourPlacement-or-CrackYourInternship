package Day43of45;


class solve {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        if (graphColoringUtil(graph, m, color, 0, n)) {
            return true;
        }
        return false;
    }
    private boolean isSafe(boolean[][] graph, int[] color, int v, int c, int n) {
        for (int i = 0; i < n; i++) {
            if (graph[v][i] && color[i] == c) {
                return false;
            }
        }
        return true;
    }
    private boolean graphColoringUtil(boolean[][] graph, int m, int[] color, int v, int n) {
        if (v == n) {
            return true;
        }
        for (int c = 1; c <= m; c++) {
            if (isSafe(graph, color, v, c, n)) {
                color[v] = c;
                if (graphColoringUtil(graph, m, color, v + 1, n)) {
                    return true;
                }
                color[v] = -1;
            }
        }
        
        return false;
    }
}