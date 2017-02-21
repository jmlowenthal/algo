package algo.supo3;

public class StringCompression {

    /**
     *
     * @param input a string of letters [a-zA-Z], such as abbbccccd
     * @return a string where repeated letters are replaced with the letter once
     * and then the number of repeats. eg ab3c4d.
     */
    public static String compress(String input) throws FormatException {
        String result = "";
        int count = 0;
        char prev = '\0';
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if (c < 'A' || c > 'z' || (c > 'Z' && c < 'A')) 
                throw new FormatException();

            if (c == prev) {
                ++count;
            }
            else {
                if (count > 1) {
                    result += count;
                }
                count = 1;
                prev = c;
                result += c;
            }
        }
        return result;
    }

    public static String decompress(String input) {
        String result = "";
        char prev = '\0';
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if (c <= '9' && c >= '0') {
                for (int count = c - '0'; count > 1; --count) {
                    result += prev;
                }
            }
            else {
                prev = c;
                result += c;
            }
        }
        return result;
    }

    public static void main(String[] args) throws FormatException{
        String inp = "abbbccccd";
        System.out.println(inp);
        String inter = compress(inp);
        System.out.println(inter);
        String out = decompress(inter);
        System.out.println(out);
        System.out.println(inp.equals(out));
    }
}
