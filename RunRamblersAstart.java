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
	    System.out.println(searcher.runSearchAStar(7, 0, "manhattan_height"));
	}

}
