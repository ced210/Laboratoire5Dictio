
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class LexiNodeTests {

   @Test
   public void testAdd() {
      LexiNode lexiNode = new LexiNode('a');
      
      lexiNode.addChild('v');
      
      assertEquals(lexiNode.getLetter(), 'a');
      ArrayList<LexiNode> testChildren = new ArrayList<LexiNode>() {{ add(new LexiNode('v')); }};
      assertEquals(lexiNode.getChildren(), testChildren);
   }
   
   @Test
   public void testGetter() {
      LexiNode lexiNode = new LexiNode('a');
      
      assertEquals(lexiNode.getLetter(), 'a');
      assertEquals(lexiNode.getChildren(), new ArrayList<LexiNode>());
   }

   @Test
   public void test_mapWord() {
      LexiNode lexiNode = new LexiNode('m');
      Word word = new Word("ot", "contient des lettres");

      //Act
      lexiNode.mapWord(word);

      LexiNode expected = new LexiNode('m');
      LexiNode oNode = expected.addChild('o');
      LexiNode tNode = oNode.addChild('t');
      tNode.setDefinition("contient des lettres");
      assertEquals(lexiNode.getLetter(), expected.getLetter());
      assertEquals(lexiNode.getChildren(), expected.getChildren());
   }
}
