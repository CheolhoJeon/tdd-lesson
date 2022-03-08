public class RefineText {

    public String refineText(String s, String ... bannedWords) {
        s = s.replace("    ", " ")
            .replace("\t", " ")
            .replace("  ", " ")
            .replace("  ", " ")
            .replace("  ", " ")
            .replace("mockist", "*******")
            .replace("purist", "******");

        for (String bannedWord : bannedWords) {
            s = s.replace(bannedWord, "*".repeat(bannedWord.length()));
        }
        return s;
    }

}
