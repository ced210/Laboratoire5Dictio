
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class AllTests {

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
}
