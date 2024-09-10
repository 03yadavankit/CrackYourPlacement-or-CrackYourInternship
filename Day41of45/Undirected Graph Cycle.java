package Day41of45;

class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];  // To keep track of visited vertices
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {  // Check each unvisited vertex
                if (detectCycleDFS(i, -1, visited, adj)) {  // Start DFS from this vertex
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCycleDFS(int current, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[current] = true;  // Mark the current node as visited
        for (Integer neighbor : adj.get(current)) {
            if (!visited[neighbor]) {  // If the neighbor hasn't been visited
                if (detectCycleDFS(neighbor, current, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {  // If the neighbor is visited and not parent, cycle detected
                return true;
            }
        }
        return false;
    }

}