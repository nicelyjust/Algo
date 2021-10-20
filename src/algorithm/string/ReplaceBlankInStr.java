package algorithm.string;

public class ReplaceBlankInStr {
    public static void main(String[] args) {

    }
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            builder.append(c == ' ' ? "%20" : c);
        }

        return builder.toString();
    }
}
