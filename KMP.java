import java.util.ArrayList;

public class KMP {
    static int [] prefixFunc(String toFind) {
        int [] values = new int[toFind.length()];
        for (int i = 1; i < toFind.length(); i++) {
            int j = 0;
            while (i + j <toFind.length() && toFind.charAt(j) == toFind.charAt(i + j)) {
                values [i + j] = Math.max(values[i + j], j + i);
                j++;
            }
        }
        return values;
    }

    public static ArrayList<Integer> KMPsearch(String text, String toFind) {
        ArrayList<Integer> found = new ArrayList<>();

        int [] prefixFunc = prefixFunc(toFind);

        int i = 0;
        int j = 0;

        while (i < text.length()) {
            if (toFind.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }

            if (j == toFind.length()) {
                found.add(i - j);
                j = prefixFunc[j -1];
            } else if (i < text.length() && toFind.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = prefixFunc[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        return found;
    }
}
