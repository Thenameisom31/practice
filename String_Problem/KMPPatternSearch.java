import java.util.ArrayList;

class KMPPatternSearch {

    static void constructLps(String pat, int[] lps) {
        int len = 0;
        lps[0] = 0;

        int i = 1;
        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "abababcababc";
        String pattern = "ababc";
        ArrayList<Integer> res = new ArrayList<>();

        int[] lps = new int[pattern.length()];
        constructLps(pattern, lps);

        int i = 0, j = 0;
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;

                if (j == pattern.length()) {
                    res.add(i - j);
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        if (res.isEmpty()) {
            System.out.println("Pattern not found");
        } else {
            for (int k = 0; k < res.size(); k++) {
                System.out.print(res.get(k) + " ");
            }
        }
    }
}
