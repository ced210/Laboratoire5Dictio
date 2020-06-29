import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

//TODO Javadoc, reponsabilite de classe, collaborateurs,
/**
 * @collaborateurs: Word, LexiNode, File
 */
public class Dictionary {

	private ArrayList<LexiNode> alphabet;

	//TODO double check
	/**
	 * Constructeur de Dictionary,
	 * initialise la liste de mots
	*/
	public /*@ pure @*/ Dictionary() {
		alphabet = new ArrayList<>();
	}

	//TODO leurs préconditions/postconditions, leurs paramètres, valeurs de retour et la raison des exceptions qu’ils envoient
	/**
	 * Ouvre l'explorateur de fichier, afin de permettre à l'utilisateur de sélectionner le fichier txt à ouvrir dans le dictionnaire,
	 * valide aussi le format des donnée?
	 * Instantie le nouvel arbre de donnee
	 * @requires chaîne de caractères (path) étant le chemin du fichier)
	 * @throws FileNotFoundException s'il y a eu une erreur avec la sélection de fichier
	 * @throws IOException s'il n'y a pas de fichier précédement sélectionné
	*/
	public void loadFile(String path) throws FileNotFoundException, IOException {
		try {
			File loadFile = new File(path);
			if(!loadFile.exists()) {
				loadFile.createNewFile();
			}
			Scanner myReader = new Scanner(loadFile);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
				try {
					String[] s = data.split(" & ");
					addWord(new Word(s[0], s[1]));
				} catch (Exception e) { 
					//N'enregistre pas le nom.
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

	//TODO double check
	/**
	 * Sauvergarde tout les mots et définitions de l'arbre sous le for at spéficifier
	 * @throws IOException s'il n'y a pas de fichier précédement sélectionné
	 * @see Word
	*/
	public void saveFile(String path) throws IOException {
		try {
			File saveFile = new File(path);
			if(!saveFile.exists())
				saveFile.createNewFile();
			PrintWriter printWriter = new PrintWriter(saveFile);
			for (Word word : getAllWords()) {
				String s = word.getLetters() + " & "+ word.getDefinition() + "\n";
				System.out.println(s);
				printWriter.write(s);
			}
			printWriter.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw new IOException("Aucun fichier sélectionné");
		}
	}

	//TODO double check
	/**
	 * Ajoute un mot au Dictionnaire
	 * @ensures le mot ne peut pas être null
	 * @ensures définition ne peut pas être null
	 * @ensures l'object word ne peut pas être null
	 * @throws InvalidParameterException s'il n'y a pas de mot
	 * @throws InvalidParameterException si le mot n'est pas initialisé
	 * @throws InvalidParameterException si la définition du mot est vide
	 * @requires word (le mot à ajouter)
	 * @see Word
	 * @see LexiNode
	 */
	public void addWord(Word word) {
		if(word == null)
			throw new InvalidParameterException("Word object should not be null");
		if(word.getLetters() == null)
			throw new InvalidParameterException("word should not be null");
		if(word.getDefinition() == null)
			throw new InvalidParameterException("Definition should not be null");
		if(!alphabet.stream().anyMatch(n -> n.getLetter() == word.getLetters().charAt(0))) {
			alphabet.add(new LexiNode(word.getLetters().charAt(0)));
		}
		for (LexiNode lexiNode : alphabet) {
			if(lexiNode.getLetter() == word.getLetters().charAt(0)) {
				Word nextWord = new Word(word.getLetters().substring(1, word.getLetters().length()), word.getDefinition());
				lexiNode.mapWord(nextWord);
			}
		}
	}

	//TODO double check
	/**
	 * Retourne tous les mots de l'arbre sous une instance de la classe Word
	 *
	 * @return words (une list d'objet de la classe Word)
	 * @see Word
	 * @see LexiNode
	*/
	public ArrayList<Word> getAllWords() {
		ArrayList<Word> words = new ArrayList<Word>();
		for (LexiNode lexiNode : alphabet) {
			ArrayList<Word> nodeWords = lexiNode.getAllWordsRecu(Character.toString(lexiNode.getLetter()));
			words.addAll(nodeWords);
		}
		return words;
	}


	//TODO double check
	/**
	 * Retourne tous les mots de l'arbre contenant le critère de sélection sous une instance de la classe Word
	 * @return words (une list d'objet de la classe Word)
	 * @see Word
	 * @see LexiNode
	*/
	public ArrayList<Word> searchWords(String criteria) {
		ArrayList<Word> words = new ArrayList<Word>();
		for (LexiNode lexiNode : alphabet) {
			if(Character.toLowerCase(criteria.charAt(0)) == Character.toLowerCase(lexiNode.getLetter())) {
				ArrayList<Word> nodeWords = lexiNode.searchWordRecursive(Character.toString(lexiNode.getLetter()), criteria.substring(1, criteria.length()));
				words.addAll(nodeWords);
			}
		}
		return words;
	}
}
