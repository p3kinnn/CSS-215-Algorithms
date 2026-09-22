class Solution {
    public List<String> letterCombinations(String digits) {
       if (digits.isEmpty()==true || digits.length()==0) {
            return new ArrayList<>();
       }
       HashMap<Character, String>map = new HashMap<>();
       Queue<String>queue = new LinkedList<>();
       map.put('2', "abc");
       map.put('3', "def");
       map.put('4', "ghi");
       map.put('5', "jkl");
       map.put('6', "mno");
       map.put('7', "pqrs");
       map.put('8', "tuv");
       map.put('9', "wxyz");
       queue.add("");
       
       for (int i = 0; i < digits.length(); i++) {
            char ch = digits.charAt(i);
            String words = map.get(ch);
            while (queue.peek().length()==i){
                String curr = queue.remove();
                for (char letter: words.toCharArray()) {
                    queue.add(curr + letter);
                }
            }
       }
        return new ArrayList<>(queue);
    }
}