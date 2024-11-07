import java.util.*;

class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        TreeMap<Integer, List<Integer>> valueToNodes = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            valueToNodes.computeIfAbsent(vals[i], x -> new ArrayList<>()).add(i);
        }

        UnionFind uf = new UnionFind(n);
        int goodPaths = 0;

        for (int value : valueToNodes.keySet()) {
            List<Integer> nodes = valueToNodes.get(value);

            
            for (int node : nodes) {
                for (int neighbor : graph.get(node)) {
                    if (vals[neighbor] <= value) {
                        uf.union(node, neighbor);
                    }
                }
            }

            Map<Integer, Integer> componentCount = new HashMap<>();
            for (int node : nodes) {
                int root = uf.find(node);
                componentCount.put(root, componentCount.getOrDefault(root, 0) + 1);
            }

            
            for (int count : componentCount.values()) {
                goodPaths += count * (count + 1) / 2;
            }
        }

        return goodPaths;
    }

    
    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); 
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}
