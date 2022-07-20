package src.com.yang.kmp;

public class KMPTest {
    public static void main(String[] args) {
        KMP kmp = new KMP();
        String str = "abcabcababacccggdgergevdfafgabbfefetabaferfefabbaabarfef";
        String match = "ababa";
        System.out.println(kmp.indexOf(str, match));
    }
}
