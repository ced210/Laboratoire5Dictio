import java.util.ArrayList;

public class LexiNode {
	
	private char mLetter;
	
	private ArrayList<LexiNode> children;
	
	private String mDefinition;
	
	/**
	 * Accesseur de la collection d'enfant du noeud
	 * @return un ecolection de LexiNode
	 */
	public ArrayList<LexiNode> getChildren() {
		return this.children;
	}
	
	/**
	 * accesseur de lattre du LexiNode.
	 * @return la lettre.
	 */
	public char getLetter() {
		return this.mLetter;
	}

	/**
	 * Accesseur del adéfinition du LexiNOde,
	 * Si il y en a une.
	 * @return la définition.
	 */
	public String getDefinition() {
		return this.mDefinition;
	}
	
	public void setDefinition(String value) { this.mDefinition = value; }

	/**
	 * Constructeur de la classe LexiNode
	 * @param letter la lettre du noeud
	 */
	public LexiNode(char letter) {
		this.mLetter = letter;
		this.children = new ArrayList<>();
	}
	
	/**
	 * Ajoute un lettre au enfant du noeud
	 * @param letter le lettre du noeud enfant
	 * @return le noeud ajouter
	 */
	public LexiNode addChild(char letter) {
		LexiNode node = new LexiNode(letter);
		this.children.add(node);
		return node;
	}


}
