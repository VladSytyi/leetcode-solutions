public class AreNumbersAscending {

    public static void main(String[] args) {
        System.out.println(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }

    // problem here when the number is complex
    public static boolean areNumbersAscending(String s) {

        int number = 0;
        int i = 0;

        while (i < s.length()) {

            if (Character.isDigit(s.charAt(i))) {
                int start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }

                int currentNumber = Integer.parseInt(s.substring(start, i));

                if (currentNumber <= number) return false;

                number = currentNumber;
            } else {
                i++;
            }

        }

        return true;

    }
}
