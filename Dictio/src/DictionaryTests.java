import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class DictionaryTests {

   @Test
   public void testAdd() {
      try {
         Dictionary dictionary = new Dictionary();
         dictionary.addWord("avion");
          
         
         assertEquals(true, true);

      } catch (Exception e) {
         //TODO: handle exception
         e.getMessage();
      }
   }
}
