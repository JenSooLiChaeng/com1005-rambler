import java.util.ArrayList;

/**
 * 
 */

/**
 * RamblersState, State representation specialized to Ramblers
 */
public class RamblersState extends SearchState {
	
	private int x;
	private int y;

	/**
	 * Constructor, from y and x
	 */
	public RamblersState(int y, int x, int lc, int rc) {
		// TODO Auto-generated constructor stub
		this.y = y;
		this.x = x;
		localCost = lc;
		estRemCost = rc;
	}

	@Override
	boolean goalPredicate(Search searcher) {
		RamblersSearch ramblersSearcher = (RamblersSearch) searcher;
		return this.sameState(ramblersSearcher.getGoal());
	}

	@Override
	ArrayList<SearchState> getSuccessors(Search searcher) {
		RamblersSearch ramblersSearcher = (RamblersSearch) searcher;
		ArrayList<SearchState> successors = new ArrayList<SearchState>();
		int width = ramblersSearcher.getTerrainMap().getWidth();
		int depth = ramblersSearcher.getTerrainMap().getDepth();
		int[][] tmap = ramblersSearcher.getTerrainMap().getTmap();
		if (y > 0) {
			successors.add(getNextState(y-1, x, tmap));
		}
		if (x > 0) {
			successors.add(getNextState(y, x-1, tmap));
		}
		if (y < depth - 1) {
			successors.add(getNextState(y+1, x, tmap));
		}
		if (x < width - 1) {
			successors.add(getNextState(y, x+1, tmap));
		}
		return successors;
	}
	
	private RamblersState getNextState(int y2, int x2, int[][] tmap) {
		int lc = 1;
		if (tmap[y2][x2] > tmap[y][x]) {
			lc += tmap[y2][x2] - tmap[y][x];
		}
		int rc = 0;
		return new RamblersState(y2, x2, lc, rc);
	}

	@Override
	boolean sameState(SearchState n2) {
		RamblersState n = (RamblersState) n2;
		return n.x == x && n.y == y;
	}
	
	@Override
	public String toString() {
		return "("+y+","+x+")";
	}
}
