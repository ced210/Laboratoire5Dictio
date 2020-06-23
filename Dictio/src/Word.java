public class Word {
    private String word;
    private String definition;

    public String getWord() { return word; }
    public String getDefinition() { return definition; }
    public void setWord(String value) { this.word = value; }
    public void setDefinition(String value) { this.definition = value; }

    public Word(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }
}