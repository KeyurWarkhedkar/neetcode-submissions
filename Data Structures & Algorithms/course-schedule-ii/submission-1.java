class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        boolean[] vis = new boolean[numCourses];
        Stack<Integer> topo = new Stack<>();

        for(int i=0;i<numCourses;i++) {
            if(!vis[i]) {
                if(!dfs(graph, i, vis, new boolean[numCourses], topo)) {
                    return new int[]{};
                }
            }
        }

        int[] ans = new int[numCourses];
        System.out.println(topo);
        int ctr = 0;
        while(!topo.isEmpty()) {
            ans[ctr++] = topo.pop();
        }

        return ans;
    }
    public boolean dfs(List<List<Integer>> graph, int node, boolean[] vis, boolean[] pathVis, Stack<Integer> topo) {
        if(pathVis[node]) {
            return false;
        }
        vis[node] = true;
        pathVis[node] = true;

        for(int nextNode : graph.get(node)) {
            if(vis[nextNode] && !pathVis[nextNode]) {
                continue;
            }
            if(!dfs(graph, nextNode, vis, pathVis, topo)) {
                return false;
            }
        }

        pathVis[node] = false;
        topo.push(node);
        return true;
    }
}