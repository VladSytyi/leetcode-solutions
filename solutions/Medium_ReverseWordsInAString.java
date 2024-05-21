public class Medium_ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue")); // blue is sky the
        System.out.println(reverseWords("  hello world  ")); // world hello
    }

    public static String reverseWords(String s) {

        // non-space words e.g we need to trim
        String trimmed = s.replaceAll(" ", "");
        StringBuilder sb = new StringBuilder(trimmed);

        int size = s.length();
        int start = 0;
        int end = 0;

        reverse(sb, 0, size -1 );

        while ( start < size ) {
            while ( end < size && sb.charAt(end) != ' ' ) end++;

            reverse(sb, start, end - 1);

            start = end + 1;
            end++;
        }

        return sb.toString();

    }

    public static void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt( start , sb.charAt(end));
            sb.setCharAt( end , temp);
            start++;
            end--;
        }
    }


}
