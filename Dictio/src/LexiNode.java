import java.util.ArrayList;

public class LexiNode {
	
	char mLetter;
	
	ArrayList<LexiNode> children;
	
	public ArrayList<LexiNode> getChildren() {
		return this.children;
	}
	
	public char getLetter() {
		return this.mLetter;
	}

	public LexiNode(char letter) {
		this.mLetter = letter;
		this.children = new ArrayList<>();
	}
	
	public void addChild(char letter) {
		this.children.add(new LexiNode(letter));
	}
}
