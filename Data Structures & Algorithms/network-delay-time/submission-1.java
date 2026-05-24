class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        for(int i=1;i<dist.length;i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++) {
            graph.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        Queue<Pair> q = new PriorityQueue<>();
        q.offer(new Pair(k, 0));

        int maxTime = Integer.MIN_VALUE;
    
        while(!q.isEmpty()) {
            Pair currentNode = q.poll();
            maxTime = Math.max(maxTime, dist[currentNode.node]);
            for(Pair nextNode : graph.get(currentNode.node)) {
                int newDist = currentNode.dist + nextNode.dist;
                if(dist[nextNode.node] > newDist) {
                    dist[nextNode.node] = newDist;
                    q.offer(new Pair(nextNode.node, newDist));
                }
            }
        }

        boolean flag = false;
        for(int i=1;i<dist.length;i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                flag = true;
            }
        }

        return flag ? -1 : maxTime;
    }
    private class Pair implements Comparable<Pair>{
        int node;
        int dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
        public int compareTo(Pair pair) {
            return this.dist - pair.dist;
        }
    }
}
