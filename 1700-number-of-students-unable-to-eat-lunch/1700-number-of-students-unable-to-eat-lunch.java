class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer>queue = new LinkedList<>();
        Stack<Integer>stack = new Stack<>();
        int countReject = 0;
        for (int i = 0; i < students.length; i++) {
            queue.add(students[i]);
        }
        for (int j = sandwiches.length-1; j >=0;j--) {
            stack.push(sandwiches[j]);
        }

        while (countReject < queue.size()) {
            if (queue.peek() == stack.peek()){
                countReject = 0;
                stack.pop();
                queue.poll();
            }
            else {
                countReject++;
                int firstStudent = queue.peek();
                queue.poll();
                queue.add(firstStudent);
            }
        }
        return queue.size();
    }
}