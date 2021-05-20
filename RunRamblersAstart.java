import java.util.ArrayList;

/**
 * @author 
 *
 */
public class RunRamblersAstart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    TerrainMap tm = new TerrainMap("tmc.pgm");
	    RamblersSearch searcher = new RamblersSearch(tm, 5, 8);
	    System.out.println(searcher.runSearchAStar(7, 0, "euclidean_height"));
		ArrayList<Coords> path = searcher.getPath();
		tm.showPath(path);
		tm.writeTMap("tmc_astar.pgm");
	}

}
