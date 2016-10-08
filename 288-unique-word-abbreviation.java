public class ValidWordAbbr {
    Map<String, String> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        int n = dictionary.length;
        for (String word : dictionary) {
            String abbr = getAbbr(word);
            if (map.containsKey(abbr)) {
                if (!map.get(abbr).equals(word)) {
                    map.put(abbr, "");
                }
            } else {
                map.put(abbr, word);
            }
        }
    }

    private String getAbbr(String word) {
        int len = word.length();
        if (len <= 2) {
            return word;
        } else {
            return word.charAt(0) + String.valueOf(len - 2) + word.charAt(len - 1);
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !map.containsKey(abbr) || map.get(abbr).equals(word);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
