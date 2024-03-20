import java.util.Arrays;

class Easy_ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isValid(s, t));
    }

    public static boolean isValid(String s, String t) {

        // Two ways: 1 way to build map where key - is letter and value is number of occurrences, if smth not match -- problem
        // Second way to sort and use one pointer to compare
        // before comparing we have to check the length because it could be different thus --> non-valid anagram

        if (s.length() != t.length()) return false;

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        for (int i = 0 ; i < sCharArray.length; i++) {
            if (sCharArray[i] != tCharArray[i]) return false;
        }

        return true;
    }
}