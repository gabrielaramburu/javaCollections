package recursion.simplemaze;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;


public class SampleTests {
	@Test
	public void testMaze() {
		for(Object[] testInfo: config()) {
			assertEquals(testInfo[1], new Maze().hasExit((String[])testInfo[0]),(String)testInfo[2]);
		}
	}
    
    
    private static Collection<Object[]> config() {
        return Arrays.asList(
            new Object[] {
                new String[] {"k"}, true, "Simple tests - simplest case", false},
            new Object[] {
                new String[] {"###",
                              "#k#",
                              "###"}, false, "Simple tests - no exit case", false},
            new Object[] {
                new String[] {"###",
                              "#k ",
                              "###"}, true, "Simple tests - single exit case", false},
            new Object[] {
                new String[] {"k ",
                              "kk"}, false, "Simple tests - There should be no multiple Kates", true},
            new Object[] {
                new String[] {"########",
                              "# # ####",
                              "# #k#   ",
                              "# # # ##",
                              "# # # ##",
                              "#      #",
                              "########"}, true, "More difficult cases - single exit big maze", false},
            new Object[] {
                new String[] {"########",
                              "# # ## #",
                              "# #k#  #",
                              "# # # ##",
                              "# # #  #",
                              "#     ##",
                              "########"}, false, "no exit big maze", false}
        );
    }
}