package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    List<Integer> findAnagrams(String p, String s)
    {
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        List<Integer> result = new ArrayList<>();

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            if (i >= p.length()) {
                sCount[i - p.length() - 'a']--;
            }
            if (Arrays.equals(sCount, pCount)) {
                result.add(i - p.length()+1);
            }
        }
        return result;
    }
}
