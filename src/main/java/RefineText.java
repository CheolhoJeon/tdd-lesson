public class RefineText {

    public String refineText(String s) {
        return s.replace("    ", " ")
            .replace("\t", " ")
            .replace("  ", " ")
            .replace("  ", " ")
            .replace("  ", " ")
            .replace("mockist", "*******")
            .replace("purist", "******");
    }

}
