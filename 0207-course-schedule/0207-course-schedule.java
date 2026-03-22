class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses] ;
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            res.add(new ArrayList<>());
        }

        for(int[] p : prerequisites){
            int a  = p[0], b=p[1];
            res.get(b).add(a); // adjacency list
            indegree[a]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }

        int count = 0;

        while(!q.isEmpty()){
            int course = q.poll();
            count++;
            for(int neighbor : res.get(course)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) q.add(neighbor);
            }
        }

        return count == numCourses;

    }
}