class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return list;
        }

        int lenOfWord = words[0].length();
        int numOfWords = words.length;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }

        for (int i = 0; i < lenOfWord; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> currentCount = new HashMap<>();

            while (right + lenOfWord <= s.length()) {
                String word = s.substring(right, right + lenOfWord);
                right += lenOfWord;

                if (wordCount.containsKey(word)) {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                    count++;

                    while (currentCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + lenOfWord);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        count--;
                        left += lenOfWord;
                    }

                    if (count == numOfWords) {
                        list.add(left);
                    }
                } else {
                    currentCount.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return list;
    }
}