import java.util.ArrayList;

public class LexiNode {
	
	private char mLetter;
	
	private ArrayList<LexiNode> children;
	
	private String mDefinition;
	
	public ArrayList<LexiNode> getChildren() {
		return this.children;
	}
	
	public char getLetter() {
		return this.mLetter;
	}
	
	public void setDefinition(String value) { this.mDefinition = value; }

	public LexiNode(char letter) {
		this.mLetter = letter;
		this.children = new ArrayList<>();
	}
	
	public LexiNode addChild(char letter) {
		LexiNode node = new LexiNode(letter);
		this.children.add(node);
		return node;
	}
}
