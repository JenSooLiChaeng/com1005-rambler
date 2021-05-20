/*
 *	RamblersSearch.java - class specialized to Ramblers
*/
public class RamblersSearch extends Search {
	private String aStarHeuristic;
	private RamblersState goalState;
	private TerrainMap tMap;
	
	public RamblersSearch(TerrainMap tMap, int yGoal, int xGoal) {
		// TODO Auto-generated constructor stub
		this.tMap = tMap;
		this.goalState = new RamblersState(yGoal, xGoal, 0, 0);
	}
	
	public String runSearchBB(int y0, int x0) {
		RamblersState initState = new RamblersState(y0, x0, 0, 0);
		return runSearch(initState, "branchAndBound");
	}

	public RamblersState getGoal() {
		return this.goalState;
	}
	
	public TerrainMap getTerrainMap() {
		return tMap;
	}
	
}
