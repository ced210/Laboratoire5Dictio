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
		// TODO Auto-generated constructor stub
		this.mLetter = letter;
	}
	
	public void addChild(char letter) {
		this.children.add(new LexiNode(letter));
	}
}
