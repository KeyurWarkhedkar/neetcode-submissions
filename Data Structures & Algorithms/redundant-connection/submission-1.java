class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length+1);

        for(int i=0;i<edges.length;i++) {
            if(!ds.union(edges[i][0], edges[i][1])) {
                return new int[]{edges[i][0], edges[i][1]};
            }
        }

        return new int[]{};
    }
    private class DisjointSet {
        int[] parent;
        int[] size;
        DisjointSet(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for(int i=0;i<n;i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int getUltimateParent(int node) {
            if(parent[node] == node) {
                return node;
            }
            int par = getUltimateParent(parent[node]);
            parent[node] = par;
            return par;
        }
        public boolean union(int node1, int node2) {
            int parent1 = getUltimateParent(node1);
            int parent2 = getUltimateParent(node2);

            if(parent1 == parent2) {
                return false;
            }

            if(size[parent1] > size[parent2]) {
                parent[parent2] = parent1;
                size[parent1] += size[parent2];
            } else {
                parent[parent1] = parent2;
                size[parent2] += size[parent1];
            }

            return true;
        }
    }
}
