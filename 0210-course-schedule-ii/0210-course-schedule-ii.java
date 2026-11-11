class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            graph.get(b).add(a);
        }
        int[] condition = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            condition[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (condition[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        int[] arr = new int[numCourses];
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            arr[count] = curr;
            count++;
            for (int neighbor: graph.get(curr)) {
                condition[neighbor]--;
                if (condition[neighbor] ==0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (count == numCourses) {
            return arr;
        }
        return new int[0];
    }
}