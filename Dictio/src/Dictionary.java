import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

//TODO Javadoc, reponsabilite de classe, collaborateurs, 
public class Dictionary {

	private ArrayList<LexiNode> mWords;
	private String mSearchCriteria;
	private File file;


	//TODO double check
	/**
	 * Retourne la liste de mots 
	 * @return ArrayList<LexiNode>
	*/
	public /*@ pure @*/ ArrayList<LexiNode> getWords() {
		return this.mWords;
	}
	
	//TODO double check
	/**
	 * Constructeur de Dictionary,
	 * initialise la liste de mots
	*/
	public /*@ pure @*/ Dictionary() {
		mWords = new ArrayList<>();
	}

	//TODO leurs préconditions/postconditions, leurs paramètres, valeurs de retour et la raison des exceptions qu’ils envoient
	/**
	 * Ouvre l'explorateur de fichier, afin de permettre à l'utilisateur de sélectionner le fichier txt à ouvrir dans le dictionnaire,
	 * valide aussi le format des donnée?
	 * Instantie le nouvel arbre de donnee
	 * @param  path chemin du fichier
	 * @throws FileNotFoundException si il y a eu une erreur avec la sélection de fichier
	 * @throws IOException si il n'y a pas de fichier précédement sélectionné
	*/
	public void loadFile(String path) throws FileNotFoundException, IOException {
		try {
			file = new File(path);
			if(!file.exists()) {
				file.createNewFile();
			}
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
				try {
					String[] s = data.split(" & ");
					addWord(new Word(s[0], s[1]));
				} catch (Exception e) {
					//TODO: handle exception
				}
			}
			myReader.close();
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new FileNotFoundException("Fichier non trouvé");
		} catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new IOException("Aucun fichier sélectionné");
		}
	}

	//TODO leurs préconditions/postconditions, leurs paramètres, valeurs de retour et la raison des exceptions qu’ils envoient
	/**
	 * Sauvergarde tout les mots et définitions de l'arbre sous le forat spéficifier 
	 * @throws IOException si il n'y a pas de fichier précédement sélectionné
	*/
	public void saveFile() throws IOException {
		try {
			PrintWriter printWriter = new PrintWriter(this.file);
			for (Word word : getAllWords()) {
				String s = word.getWord() + " & "+ word.getDefinition() + "\n";
				System.out.println(s);
				printWriter.write(s);				
			}
			printWriter.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw new IOException("Aucun fichier sélectionné");
		}
	}
//TODO leurs préconditions/postconditions, leurs paramètres, valeurs de retour et la raison des exceptions qu’ils envoient
	/**
	 * Ajout un mot au Dicitonnaire
	 * @param word le Mot à ajouter
	 */
	public void addWord(Word word) {
		if(word == null)
			throw new InvalidParameterException("Word object should not be null");
		if(word.getWord() == null)
			throw new InvalidParameterException("word should not be null");
		if(word.getDefinition() == null)
			throw new InvalidParameterException("Definition should not be null");
		if(!mWords.stream().anyMatch(n -> n.getLetter() == word.getWord().charAt(0))) {
			mWords.add(new LexiNode(word.getWord().charAt(0)));
		}
		for (LexiNode lexiNode : mWords) {
			if(lexiNode.getLetter() == word.getWord().charAt(0)) {
				Word nextWord = new Word(word.getWord().substring(1, word.getWord().length()), word.getDefinition()); 
				lexiNode.mapWord(nextWord);
			}
		}
	}
	
	//TODO leurs préconditions/postconditions, leurs paramètres, valeurs de retour et la raison des exceptions qu’ils envoient
	/**
	 * Retourn tout les mots de l'arbre sous une instance de la classe Word 
	 * @return une list d'objet de la classe Word
	 * @see Word
	*/
	public ArrayList<Word> getAllWords() {
		ArrayList<Word> words = new ArrayList<Word>();
		for (LexiNode lexiNode : mWords) {
			ArrayList<Word> nodeWords = lexiNode.getAllWordsRecu(Character.toString(lexiNode.getLetter()));
			words.addAll(nodeWords);
		}
		return words;
	}


	//TODO leurs préconditions/postconditions, leurs paramètres, valeurs de retour et la raison des exceptions qu’ils envoient
	public ArrayList<Word> searchWords(String criteria) {
		ArrayList<Word> words = new ArrayList<Word>();
		for (LexiNode lexiNode : mWords) {
			if(Character.toLowerCase(criteria.charAt(0)) == Character.toLowerCase(lexiNode.getLetter())) {
				ArrayList<Word> nodeWords = lexiNode.searchRecu(Character.toString(lexiNode.getLetter()), criteria.substring(1, criteria.length()));
				words.addAll(nodeWords);
			}
		}
		return words;
	}

	
	

}
