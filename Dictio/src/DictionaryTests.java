import static org.junit.Assert.assertEquals;

import org.junit.*;

import java.util.ArrayList;

public class DictionaryTests {

   @Test
   public void test_addWord_shouldAddWordIntoDictionaryWords() {
      try {
         //Arrange
         Dictionary dictionary = new Dictionary();
         Word newWord = new Word("avion", "un truc qui vole");
         
         //Act
         dictionary.addWord(newWord);

         //Assert
         ArrayList<Word> words = dictionary.getAllWords();
         assertEquals(words.get(0).getLetters(), newWord.getLetters());
         assertEquals(words.get(0).getDefinition(), newWord.getDefinition());
      } catch (Exception e) {
         e.getMessage();
      }
   }

   @Test
   public void test_addWord2_shouldAddAviateurIntoTheSameTreeAsAvion() {
      try {
         //Arrange
         Dictionary dictionary = new Dictionary();
         Word word1 = new Word("avion", "un truc qui vole");
         Word word2 = new Word("aviateur", "le dude qui vole");
         
         //Act
         dictionary.addWord(word1);
         dictionary.addWord(word2);

         //Assert
         ArrayList<Word> words = dictionary.getAllWords();
         ArrayList<Word> expected = new ArrayList<Word>();
         expected.add(word1);
         expected.add(word2);
         assertEquals(words.get(0).getLetters(), expected.get(0).getLetters());
         assertEquals(words.get(0).getDefinition(), expected.get(0).getDefinition());
         assertEquals(words.get(1).getLetters(), expected.get(1).getLetters());
         assertEquals(words.get(1).getDefinition(), expected.get(1).getDefinition());
      } catch (Exception e) {
         e.getMessage();
      }
   }

   @Test
   public void test_addWord3_shouldAddElephantIntoNewTree() {
      try {
         //Arrange
         Dictionary dictionary = new Dictionary();
         Word word1 = new Word("avion", "un truc qui vole");
         Word word2 = new Word("aviation", "le dude qui vole");
         Word word3 = new Word("elephant", "gros truc gris");
         
         //Act
         dictionary.addWord(word1);
         dictionary.addWord(word2);
         dictionary.addWord(word3);

         //Assert
         ArrayList<Word> words = dictionary.getAllWords();
         ArrayList<Word> expected = new ArrayList<Word>();
         expected.add(word1);
         expected.add(word2);
         expected.add(word3);
         assertEquals(words.get(0).getLetters(), expected.get(0).getLetters());
         assertEquals(words.get(0).getDefinition(), expected.get(0).getDefinition());
         assertEquals(words.get(1).getLetters(), expected.get(1).getLetters());
         assertEquals(words.get(1).getDefinition(), expected.get(1).getDefinition());
         assertEquals(words.get(2).getLetters(), expected.get(2).getLetters());
         assertEquals(words.get(2).getDefinition(), expected.get(2).getDefinition());
      } catch (Exception e) {
         e.getMessage();
      }
   }

   @Test
   public void test_getAllWords_shouldReturnAllExistingWordsFromDictionary() {
      try {
         //Arrange
         Dictionary dictionary = new Dictionary();
         Word word1 = new Word("avion", "un truc qui vole");
         Word word2 = new Word("aviation", "le dude qui vole");
         Word word3 = new Word("elephant", "gros truc gris");
         dictionary.addWord(word1);
         dictionary.addWord(word2);
         dictionary.addWord(word3);

         //Act
         ArrayList<Word> words = dictionary.getAllWords();

         //Assert
         ArrayList<Word> expected = new ArrayList<Word>();
         expected.add(word1);
         expected.add(word2);
         expected.add(word3);
         assertEquals(words.get(0).getLetters(), expected.get(0).getLetters());
         assertEquals(words.get(0).getDefinition(), expected.get(0).getDefinition());
         assertEquals(words.get(1).getLetters(), expected.get(1).getLetters());
         assertEquals(words.get(1).getDefinition(), expected.get(1).getDefinition());
         assertEquals(words.get(2).getLetters(), expected.get(2).getLetters());
         assertEquals(words.get(2).getDefinition(), expected.get(2).getDefinition());
      } catch (Exception e) {
         e.getMessage();
      }
   }

   @Test
   public void test_searchWords_shouldReturnAllWordsContainingTheSearchCriteria() {
      try {
         //Arrange
         Dictionary dictionary = new Dictionary();
         Word word1 = new Word("avion", "un truc qui vole");
         Word word2 = new Word("aviation", "le dude qui vole");
         Word word3 = new Word("elephant", "gros truc gris");
         dictionary.addWord(word1);
         dictionary.addWord(word2);
         dictionary.addWord(word3);

         //Act
         ArrayList<Word> words = dictionary.searchWords("avi");

         //Assert
         ArrayList<Word> expected = new ArrayList<Word>();
         expected.add(word1);
         expected.add(word2);

         assertEquals(words.get(0).getLetters(), expected.get(0).getLetters());
         assertEquals(words.get(0).getDefinition(), expected.get(0).getDefinition());
         assertEquals(words.get(1).getLetters(), expected.get(1).getLetters());
         assertEquals(words.get(1).getDefinition(), expected.get(1).getDefinition());
      } catch (Exception e) {
         e.getMessage();
      }
   }

   @Test
   public void test_loadFile_shouldLoadSelectedFile() {
      try {
         Dictionary dictionary = new Dictionary();
         dictionary.loadFile("testFile.txt");
         
         // assertTrue("The files differ!", FileUtils.contentEquals(new File("testFile.txt"), new File("testFile.txt")));
      } catch (Exception e) {
         e.getMessage();
      }
   }

   @Test
   public void test_saveFile_shouldSaveUpadatedFile() {
      try {
         Dictionary dictionary = new Dictionary();
         dictionary.loadFile("testFile.txt");
         dictionary.saveFile("testFile.txt");
         
         // assertTrue("The files differ!", FileUtils.contentEquals(new File("testFile.txt"), new File("testFile.txt")));
      } catch (Exception e) {
         e.getMessage();
      }
   }
}
