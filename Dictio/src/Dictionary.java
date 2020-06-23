import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {

	private ArrayList<LexiNode> mWords;
	private String mSearchCriteria;
	private File file;

	/**
	 * Retourne la liste de mots 
	 * @return ArrayList<LexiNode>
	*/
	public ArrayList<LexiNode> getWords() {
		return this.mWords;
	}

	/**
	 * Constructeur de Dictionary,
	 * initialise la liste de mots
	*/
	public Dictionary() {
		mWords = new ArrayList<>();
	}

	//#region
	// /**
	//  * Initialise la liste de noeud du dicy
	// */
	// private void initialiseDictionary() {
	// 	mWords = new ArrayList<>();
	// 	mWords.add(new LexiNode('a'));
	// 	mWords.add(new LexiNode('b'));
	// 	mWords.add(new LexiNode('c'));
	// 	mWords.add(new LexiNode('d'));
	// 	mWords.add(new LexiNode('e'));
	// 	mWords.add(new LexiNode('f'));
	// 	mWords.add(new LexiNode('g'));
	// 	mWords.add(new LexiNode('h'));
	// 	mWords.add(new LexiNode('i'));
	// 	mWords.add(new LexiNode('j'));
	// 	mWords.add(new LexiNode('k'));
	// 	mWords.add(new LexiNode('l'));
	// 	mWords.add(new LexiNode('m'));
	// 	mWords.add(new LexiNode('n'));
	// 	mWords.add(new LexiNode('o'));
	// 	mWords.add(new LexiNode('p'));
	// 	mWords.add(new LexiNode('q'));
	// 	mWords.add(new LexiNode('r'));
	// 	mWords.add(new LexiNode('s'));
	// 	mWords.add(new LexiNode('t'));
	// 	mWords.add(new LexiNode('u'));
	// 	mWords.add(new LexiNode('v'));
	// 	mWords.add(new LexiNode('w'));
	// 	mWords.add(new LexiNode('x'));
	// 	mWords.add(new LexiNode('y'));
	// 	mWords.add(new LexiNode('z'));
	// }
	//#endregion

	/**
	 * Ouvre l'explorateur de fichier, afin de permettre à l'utilisateur de sélectionner le fichier txt à ouvrir dans le dictionnaire,
	 * valide aussi le format des donnée?
	 * Instantie le nouvel arbre de donnee
	 * @param  path chemin du fichier
	*/
	public void loadFile(String path) {
		try {
			file = new File(path);
			if(!file.exists()) {
				file.createNewFile();
			}
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Sauvergarde tout les mots et définitions de l'arbre sous le forat spéficifier 
	 * @throws IOException si il n'y a pas de fichier précédement sélectionné
	*/
	public void saveFile() throws IOException {
		try {
			PrintWriter printWriter = new PrintWriter(this.file);
			for (Word word : getAllWord()) {
				String s = word.getWord() + " && "+ word.getDefinition();
				System.out.println(s);
				printWriter.write(s);				
			}
			printWriter.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new IOException("Aucun fichier sélectionné");
		}
	}

	public void addWord(String word) {
		for (LexiNode lexiNode : mWords) {
			if(lexiNode.getLetter() == word.charAt(0)) {
				lexiNode.addChild(word.charAt(0));
				mapWord(word.substring(1, word.length()), lexiNode);
			}
		}
	}

	public void mapWord(String word, LexiNode node) {
		//affecter la premiere lettre
		//Si il y a une prochaine lettre
			// Si les enfants du noeud ne contient pas la lettre
				// ajouter la lettre
			// trouver le node du char
			//recurc avec la fin du mot et sur les children du Node
		char letter = word.charAt(0);
		if(word.length() > 1)
			if(node.getChildren().contains(new LexiNode(letter))) {
				node.addChild(letter);
			}
			for (LexiNode lexiNode : node.getChildren()) {
				if(lexiNode.getLetter() == word.charAt(0)) {
					mapWord(word.substring(1, word.length()), lexiNode);
				}
			}
	}

	/**
	 * Retourn tout les mots de l'arbre sous une instance de la classe Word 
	 * @return une list d'objet de la classe Word
	 * @see Word
	*/
	private ArrayList<Word> getAllWord() {
		return new ArrayList<Word>() {
			{
				add(new Word("avion", "un truc qui vole"));
			}
		};
	}

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

}
