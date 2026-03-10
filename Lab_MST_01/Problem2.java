import java.util.*;

public class Problem2 {

    public static int generate(String word) {
        int mask = 0;
        for(char ch: word.toCharArray()) {
            int val = ch-'a';
            mask |= (1<<val);
        }

        return mask;
    }

    public static int solve(String[] words) {
        int ans = 0;
        for(int i=0; i<words.length; i++) {
            for(int j=0; j<words.length; j++) {
                if(i == j) continue;
    
                int mask1 = generate(words[i]);
                int mask2 = generate(words[j]);
                if((mask1 & mask2) == 0) {
                    ans = Math.max(words[i].length() * words[j].length(), ans);
                }
            }
        }
    
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        String[] words2 = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        String[] words3 = {"a", "aa", "aaa", "aaa"};

        System.out.println(solve(words));
        System.out.println(solve(words2));
        System.out.println(solve(words3));
    }
}
