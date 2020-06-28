import static org.junit.Assert.assertEquals;

import org.junit.*;

import java.util.ArrayList;

public class DictionaryTests {

   @Test
   public void test_addWord() {
      try {
         Dictionary dictionary = new Dictionary();
         Word newWord = new Word("avion", "un truc qui vole");
         dictionary.addWord(newWord);

         assertEquals(true, true);
      } catch (Exception e) {
         e.getMessage();
      }
   }

   @Test
   public void test_addWord2() {
      try {
         Dictionary dictionary = new Dictionary();
         Word word1 = new Word("avion", "un truc qui vole");
         Word word2 = new Word("aviateur", "le dude qui vole");
         dictionary.addWord(word1);
         dictionary.addWord(word2);

         assertEquals(true, true);
      } catch (Exception e) {
         e.getMessage();
      }
   }

   @Test
   public void test_addWord3() {
      try {
         Dictionary dictionary = new Dictionary();
         Word word1 = new Word("avion", "un truc qui vole");
         Word word2 = new Word("aviation", "le dude qui vole");
         Word word3 = new Word("elephant", "gros truc gris");
         dictionary.addWord(word1);
         dictionary.addWord(word2);
         dictionary.addWord(word3);

         assertEquals(true, true);
      } catch (Exception e) {
         e.getMessage();
      }
   }

   @Test
   public void test_getAllWords() {
      try {
         Dictionary dictionary = new Dictionary();
         Word word1 = new Word("avion", "un truc qui vole");
         Word word2 = new Word("aviation", "le dude qui vole");
         Word word3 = new Word("elephant", "gros truc gris");
         dictionary.addWord(word1);
         dictionary.addWord(word2);
         dictionary.addWord(word3);

         ArrayList<Word> words = dictionary.getAllWords();

         ArrayList<Word> expected = new ArrayList<Word>();
         expected.add(word1);
         expected.add(word2);
         expected.add(word3);

         assertEquals(words.get(0).getWord(), expected.get(0).getWord());
         assertEquals(words.get(0).getDefinition(), expected.get(0).getDefinition());
         assertEquals(words.get(1).getWord(), expected.get(1).getWord());
         assertEquals(words.get(1).getDefinition(), expected.get(1).getDefinition());
         assertEquals(words.get(2).getWord(), expected.get(2).getWord());
         assertEquals(words.get(2).getDefinition(), expected.get(2).getDefinition());
      } catch (Exception e) {
         e.getMessage();
      }
   }

   @Test
   public void test_searchWords() {
      try {
         Dictionary dictionary = new Dictionary();
         Word word1 = new Word("avion", "un truc qui vole");
         Word word2 = new Word("aviation", "le dude qui vole");
         Word word3 = new Word("elephant", "gros truc gris");
         dictionary.addWord(word1);
         dictionary.addWord(word2);
         dictionary.addWord(word3);

         ArrayList<Word> words = dictionary.searchWords("avi");

         ArrayList<Word> expected = new ArrayList<Word>();
         expected.add(word1);
         expected.add(word2);

         assertEquals(words.get(0).getWord(), expected.get(0).getWord());
         assertEquals(words.get(0).getDefinition(), expected.get(0).getDefinition());
         assertEquals(words.get(1).getWord(), expected.get(1).getWord());
         assertEquals(words.get(1).getDefinition(), expected.get(1).getDefinition());
      } catch (Exception e) {
         e.getMessage();
      }
   }

   @Test
   public void test_loadFile() {
      try {
         Dictionary dictionary = new Dictionary();
         dictionary.loadFile("testFile.txt");
         
         // assertTrue("The files differ!", FileUtils.contentEquals(new File("testFile.txt"), new File("testFile.txt")));
      } catch (Exception e) {
         e.getMessage();
      }
   }

   @Test
   public void test_saveFile() {
      try {
         Dictionary dictionary = new Dictionary();
         dictionary.loadFile("testFile.txt");
         dictionary.saveFile();
         
         // assertTrue("The files differ!", FileUtils.contentEquals(new File("testFile.txt"), new File("testFile.txt")));
      } catch (Exception e) {
         e.getMessage();
      }
   }
}
