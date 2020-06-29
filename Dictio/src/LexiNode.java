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

	//TODO move in LexiNode, node params => this
	//TODO leurs préconditions/postconditions, leurs paramètres, valeurs de retour et la raison des exceptions qu’ils envoient
	/**
	 * Ajoute une lettre au enfant d'un LexiNode récurcivement
	 * @param word Le reste du Mot à ajouter
	 * @param node le LexiNode à ajouter la prochaine lettre
	 */
	public void mapWord(Word word) {
		char currentLetter = word.getWord().charAt(0);
		if(!this.getChildren().stream().anyMatch(n -> n.getLetter() == currentLetter)) {
			this.addChild(currentLetter);
		}
		for (LexiNode lexiNode : this.getChildren()) {
			if(lexiNode.getLetter() == currentLetter) {
				if(word.getWord().length() > 1) {
					Word nextWord = new Word(word.getWord().substring(1, word.getWord().length()), word.getDefinition());
					lexiNode.mapWord(nextWord);
				}
				else
					lexiNode.setDefinition(word.getDefinition());
			}
		}
	}

	//TODO leurs préconditions/postconditions, leurs paramètres, valeurs de retour et la raison des exceptions qu’ils envoient
	public ArrayList<Word> getAllWordsRecu(String currentWord) {
		ArrayList<Word> nodeWords = new ArrayList<Word>();
		for (LexiNode node : this.getChildren()) {
			if(node.getDefinition() != null)
				nodeWords.add(new Word(currentWord + node.getLetter(), node.getDefinition()));
			else
				nodeWords.addAll(node.getAllWordsRecu(currentWord + node.getLetter()));
		}
		return nodeWords;
	}

	//TODO leurs préconditions/postconditions, leurs paramètres, valeurs de retour et la raison des exceptions qu’ils envoient
	public ArrayList<Word> searchRecu(String currentWord, String criteria) {
		ArrayList<Word> nodeWords = new ArrayList<Word>();
		for (LexiNode node : this.getChildren()) {
			if(criteria.length() > 0 ? Character.toLowerCase(criteria.charAt(0)) == Character.toLowerCase(node.getLetter()) : true)
				if(node.getDefinition() != null)
					nodeWords.add(new Word(currentWord + node.getLetter(), node.getDefinition()));
				else {
					if(criteria.length() > 0)
						nodeWords.addAll(node.searchRecu(currentWord + node.getLetter(), criteria.substring(1, criteria.length())));
					else
					nodeWords.addAll(node.getAllWordsRecu(currentWord + node.getLetter()));
				}
		}
		return nodeWords;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;
	
		LexiNode lexiNode = (LexiNode) o;

		boolean isLetterSame = lexiNode.getLetter() == this.mLetter;
		boolean isDefinitionSame = lexiNode.getDefinition() == this.mDefinition;
		boolean isChildrenSame = lexiNode.getChildren() == this.children;
		return isLetterSame && isDefinitionSame && isChildrenSame;
	}

}
