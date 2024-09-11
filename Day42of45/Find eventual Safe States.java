package Day42of45;

class Solution {
    private static final int UNDEFINED_NODE = 0;
    private static final int IS_SAFE_NODE = 1;
    private static final int IS_NOT_SAFE_NODE = 2;

    private int[] safeNodes;
    private int n;
    private int[][] graph;
    private boolean[] visited;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        this.graph = graph;
        n = this.graph.length;
        safeNodes = new int[n];
        visited = new boolean[n];

        for (int node = 0; node < n; node++) {
            if (safeNodes[node] != UNDEFINED_NODE) continue;
            visited[node] = true;
            safeNodes[node] = dfs(node);
            visited[node] = false;
        }

        List<Integer> safeNodeList = new ArrayList<>();;
        for (int node = 0; node < n; node++) {
            if (safeNodes[node] == IS_SAFE_NODE) {
                safeNodeList.add(node);
            }
        }

        return safeNodeList;
    }

    private int dfs(int node) {
        if (safeNodes[node] != UNDEFINED_NODE) return safeNodes[node];

        for (int destNode : graph[node]) {
            if (visited[destNode]) {
                return IS_NOT_SAFE_NODE;
            }
            if (safeNodes[destNode] == IS_NOT_SAFE_NODE) {
                return IS_NOT_SAFE_NODE;
            }

            visited[destNode] = true;
            safeNodes[destNode] = dfs(destNode);
            visited[destNode] = false;

            if (safeNodes[destNode] == IS_NOT_SAFE_NODE) {
                return IS_NOT_SAFE_NODE;
            }
        }

        return IS_SAFE_NODE;
    }
}