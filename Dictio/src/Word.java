
//TODO Javadoc, reponsabilite de classe, collaborateurs, 
public class Word {
    private String word;
    private String definition;

    //TODO double check
    /**
     * accesseur qui retourne le mot
     */
    public /*@ pure @*/ String getWord() { return word; }

    //TODO double check
    /**
     * accesseur qui retourne la définition du mot
     */
    public /*@ pure @*/String getDefinition() { return definition; }

    //TODO double check
    /**
     * mutateur qui affecte une chaîne de caractères au mot
     * @requires chaîne de caractères pour le mot
     */
    public void setWord(String value) { this.word = value; }

    //TODO double check
    /**
     * mutateur qui affecte une chaîne de caractères à la définition
     * @requires chaîne de caractères pour la definition
     */
    public void setDefinition(String value) { this.definition = value; }

    //TODO double check
    /**
     * le contructeur de word qui reçoit un mot et une définition
     * @requires word
     * @requires definition
     */
    public Word(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }
}