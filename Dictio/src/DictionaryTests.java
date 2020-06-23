import static org.junit.Assert.assertEquals;

// import org.assertj.*;
import org.junit.*;

import java.util.ArrayList;

public class DictionaryTests {

   @Test
   public void testAdd() {
      try {
         Dictionary dictionary = new Dictionary();
         dictionary.addWord("av");
          LexiNode node = new LexiNode('a');
          node.addChild('v');
         assertEquals(dictionary.getWords(), new ArrayList<LexiNode>() {{ add(node); }});

      } catch (Exception e) {
         e.getMessage();
      }
   }

   @Test
   public void test_loadFile() {
      try {
         Dictionary dictionary = new Dictionary();
         // dictionary.openFile();
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
         // dictionary.openFile();
         dictionary.loadFile("testFile.txt");
         dictionary.saveFile();
         
         // assertTrue("The files differ!", FileUtils.contentEquals(new File("testFile.txt"), new File("testFile.txt")));

      } catch (Exception e) {
         e.getMessage();
      }
   }
}
