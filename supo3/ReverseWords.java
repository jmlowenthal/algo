package algo.supo3;

public class ReverseWords {

    /**
     * @param input A string consisting of words separated with spaces. No
     *              punctuation. eg 'Chelsea five Manchester Utd Nill'
     * @return A string with the letters in each word reversed. eg 'aeslehC evif
     *  retsehcnaM dtU liN'
     */
    public static String reverseWords(String input) {
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; ++i) {
            words[i] = (new StringBuilder(words[i])).reverse().toString();
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Chelsea five Manchester Utd Nill"));
    }
}
