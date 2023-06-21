
class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
    public static boolean isPalindrome(String s) {
        s = s.toUpperCase().replaceAll("[^A-Z0-9]", "");
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}