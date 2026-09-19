class Solution {
    public int lengthOfLastWord(String s) {
        String[] arr = s.trim().split("\\s+");
        String res = arr[arr.length-1];
        return res.length();
    }
}