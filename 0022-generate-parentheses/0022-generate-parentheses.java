class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;

    }
    public void backtrack(List<String>res, String current, int open, int closed, int n){
       if (open == n && closed == n) {
        res.add(current);
        return;
       }
       if (open < n) {
        backtrack(res,  current+ "(" , open+1, closed, n);
       }
       if (closed < open) {
            backtrack(res, current + ")", open, closed+1, n);
        
       }
    }
}