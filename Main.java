public class Main {
    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(kmp.KMPsearch("ABABDABACDABABCABAB", "ABABCABAB"));
    }
}
