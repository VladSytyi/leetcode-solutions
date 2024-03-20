class Easy_ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isValidPalindrome(s));
    }

    public static boolean isValidPalindrome(String s) {

        if (s.isEmpty()) return false;

        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = cleanedString.length() - 1;

        while (left < right) {

            if ( cleanedString.charAt(left) != cleanedString.charAt(right) ) return false;

            left++;
            right--;

        }

        return true;
    }
}