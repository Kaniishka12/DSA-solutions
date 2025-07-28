class Solution {
    public boolean checkInclusion(String s1, String s2) {
           if (s1.length() > s2.length()) return false;

        int[] s1map=new int[26];
        int[] s2map=new int[26];

        // Fill the frequency array for s1
        for(char c: s1.toCharArray()){
            s1map[c-'a']++;
        }

        int windowSize = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            // Add current character to s2Map
            s2map[s2.charAt(i) - 'a']++;

            // Remove the character that falls out of the window
            if (i >= windowSize) {
                s2map[s2.charAt(i - windowSize) - 'a']--;
            }

            // Compare s1Map and s2Map
            if (Arrays.equals(s1map, s2map)) {
                return true;
            }
        }

        return false;
    }
}