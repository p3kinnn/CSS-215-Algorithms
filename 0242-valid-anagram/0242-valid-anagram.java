import java.util.*;
class Solution {
    public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
        return false;
      }
      char[] ch1 = s.toCharArray();
      char[] ch2 = t.toCharArray();
      Arrays.sort(ch1);
      Arrays.sort(ch2);
      String sort1 = new String(ch1);
      String sort2 = new String(ch2);
      if(sort1.equals(sort2)) {
        return true;
      }
      return false;
    }
}