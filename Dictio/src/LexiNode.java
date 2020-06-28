import java.util.ArrayList;

//TODO Javadoc, reponsabilite de classe, collaborateurs, 
public class LexiNode {
	
	private char mLetter;
	
	private ArrayList<LexiNode> children;
	
	private String mDefinition;
	
	//TODO double check
	/**
	 * Accesseur de la collection d'enfant du noeud courant
	 * @return une collection de LexiNode
	 */
	public /*@ pure @*/ ArrayList<LexiNode> getChildren() {
		return this.children;
	}

	//TODO double check
	/**
	 * accesseur de la lettre du LexiNode.
	 * @return la lettre.
	 */

	public /*@ pure @*/ char getLetter() {
		return this.mLetter;
	}

	//TODO double check
	/**
	 * Accesseur de la définition du LexiNOde,
	 * @ ensures renvois une définition s'il y en a une.
	 * @return la définition.
	 */
	public /*@ pure @*/ String getDefinition() {
		return this.mDefinition;
	}

	//TODO double check
	/**
	 * Prend une chaîne de caratères et l'ajoute à la définition du lexinode courant 
	 * @ requires une chaîne de caractères 
	 */
	public void setDefinition(String value) { this.mDefinition = value; }

	//TODO double check
	/**
	 * Constructeur de la classe LexiNode
	 * @ requires une lettre
	 * @return le LexiNode
	 */
	public LexiNode(char letter) {
		this.mLetter = letter;
		this.children = new ArrayList<>();
	}
	//TODO double check
	/**
	 * Ajoute une lettre a l'enfant du noeud
	 * @ requires une lettre
	 * @return le LexiNode de la lettre
	 */
	public LexiNode addChild(char letter) {
		LexiNode node = new LexiNode(letter);
		this.children.add(node);
		return node;
	}


}
