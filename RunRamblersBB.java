import java.util.ArrayList;

/**
 * Test RamblersSearch
 */
public class RunRamblersBB {
	
  public static void main(String[] arg) {
    TerrainMap tm = new TerrainMap("tmc.pgm");
    RamblersSearch searcher = new RamblersSearch(tm, 5, 8);
    System.out.println(searcher.runSearchBB(7, 0));
    ArrayList<Coords> path = searcher.getPath();
    tm.showPath(path);
    tm.writeTMap("tmc_bb.pgm");
  }

}
