
//TODO Javadoc, reponsabilite de classe, collaborateurs, 
public class Word {
    private String letters;
    private String definition;

    //TODO double check
    /**
     * accesseur qui retourne le mot
     */
    public /*@ pure @*/ String getLetters() { return letters; }

    //TODO double check
    /**
     * accesseur qui retourne la définition du mot
     */
    public /*@ pure @*/String getDefinition() { return definition; }

    //TODO double check
    /**
     * mutateur qui affecte une chaîne de caractères à la définition
     * @requires chaîne de caractères pour la definition
     */
    public void setDefinition(String value) { this.definition = value; }

    //TODO double check
    /**
     * le contructeur de word qui reçoit un mot et une définition
     * @requires letters
     * @requires definition
     */
    public Word(String letters, String definition) {
        this.letters = letters;
        this.definition = definition;
    }
}