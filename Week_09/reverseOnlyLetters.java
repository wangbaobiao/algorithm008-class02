class Solution {
    public String reverseOnlyLetters(String str) {
        char[] strChars = str.toCharArray();
        StringBuilder ans = new StringBuilder();
        int j = str.length() - 1;
        for (int i = 0; i < str.length(); ++i) {
            if (Character.isLetter(str.charAt(i))) {
                while (!Character.isLetter(str.charAt(j))){
                    j--;
                }
                ans.append(str.charAt(j--));
            } else {
                ans.append(str.charAt(i));
            }
        }

        return ans.toString();
    }
}