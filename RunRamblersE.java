import java.util.ArrayList;

/**
 * 
 */

/**
 *
 */
public class RunRamblersE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("testBB");
		testEfficiencyBB();
		System.out.println("testAstar euclidean");
		testEfficiencyAStar("euclidean");
		System.out.println("testAstar manhattan");
		testEfficiencyAStar("manhattan");
		System.out.println("testAstar height");
		testEfficiencyAStar("height");
		System.out.println("testAstar euclidean_height");
		testEfficiencyAStar("euclidean_height");
		System.out.println("testAstar manhattan_height");
		testEfficiencyAStar("manhattan_height");
	}
	
	public static void testEfficiencyAStar(String aStarHeuristic) {
	    TerrainMap tm = new TerrainMap("tmc.pgm");
	    RamblersSearch searcher = new RamblersSearch(tm, 5, 8);
	    System.out.println(searcher.runSearchAStarE(7, 0, aStarHeuristic));
	    System.out.println(searcher.runSearchAStarE(10, 15, aStarHeuristic));
	    tm = new TerrainMap("diablo.pgm");
	    searcher = new RamblersSearch(tm, 165, 127);
	    System.out.println(searcher.runSearchAStarE(0, 0, aStarHeuristic));
	    System.out.println(searcher.runSearchAStarE(248, 248, aStarHeuristic));
	}
	
	public static void testEfficiencyBB() {
	    TerrainMap tm = new TerrainMap("tmc.pgm");
	    RamblersSearch searcher = new RamblersSearch(tm, 5, 8);
	    System.out.println(searcher.runSearchBBE(7, 0));
	    System.out.println(searcher.runSearchBBE(10, 15));
	    tm = new TerrainMap("diablo.pgm");
	    searcher = new RamblersSearch(tm, 165, 127);
	    System.out.println(searcher.runSearchBBE(0, 0));
	    System.out.println(searcher.runSearchBBE(248, 248));
	}

}
