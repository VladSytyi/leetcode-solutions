import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Medium_Encode_And_Decode_Strings {

    // 659. Encode and Decode Strings

    //Design an algorithm to encode a list of strings to a string.
    // The encoded string is then sent over the network
    // and is decoded back to the original list of strings.

    public static void main(String[] args) {
        System.out.println(encode(List.of("neet", "code", "love", "you")));
        System.out.println(decode(encode(List.of("neet","code","love","you"))));
    }

    // The mos trickiest part is how to distinguish the words after encoding
    // for encoding format is: 4#neet, where is 4 -> number of chars in the original word
    // # is delimiter between the number and the original word
    // if # is mentioned in original word, we don't care

    public static String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();
        char delimiter = '#';
        for (String word : strs) {
            int length = word.length();
            sb.append(length);
            sb.append(delimiter);
            sb.append(word);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        // by default we know that first symbol is number
        // than we need to find delimeter
        // at the end pick all characters to from first symbol and restore the word
        int start = 0; // by default

        List<String> words = new LinkedList<>();

        while (start < str.length()) {
            int delimiter = start;

            while ( str.charAt(delimiter) != '#' ) {
                delimiter++;
            }
            String length = str.substring(start, delimiter); // this is our length e.g. number of symbols
            int number = Integer.parseInt(length);

            // changer the point to the start point --  for the next iterations
            start = delimiter + 1 + number;

            // extract the word between delimiter and the next word
            words.add(str.substring(delimiter + 1, start ));

        }

        return words;
    }
}
