/*
 *	RamblersSearch.java - class specialized to Ramblers
*/
public class RamblersSearch extends Search {
	private String aStarHeuristic;
	int xGoal; 
	int yGoal;
	private RamblersState goalState;
	private TerrainMap tMap;
	
	public RamblersSearch(TerrainMap tMap, int yGoal, int xGoal) {
		this.tMap = tMap;
		this.xGoal = xGoal;
		this.yGoal = yGoal;
		this.goalState = new RamblersState(yGoal, xGoal, 0, 0);
		this.aStarHeuristic = "none";
	}
	
	public String runSearchBB(int y0, int x0) {
		RamblersState initState = new RamblersState(y0, x0, 0, 0);
		return runSearch(initState, "branchAndBound");
	}
	
	public String runSearchAStar(int y0, int x0, String aStarHeuristic) {
		RamblersState initState = new RamblersState(y0, x0, 0, 0);
		this.aStarHeuristic = aStarHeuristic;
		return runSearch(initState, "aStar");
	}

	public RamblersState getGoal() {
		return this.goalState;
	}
	
	public TerrainMap getTerrainMap() {
		return tMap;
	}
	
	public int getEstRemCost(int y, int x) {
		if (aStarHeuristic.equals("manhattan")) {
			return getManhattan(y, x);
		} else if (aStarHeuristic.equals("euclidean")) {
			return getEuclidean(y, x);
		} else if (aStarHeuristic.equals("height")) {
			return getHeightDiff(y, x);
		} else if (aStarHeuristic.equals("manhattan_height")) {
			return getManhattan(y, x) + getHeightDiff(y, x);
		} else if (aStarHeuristic.equals("euclidean_height")) {
			return getEuclidean(y, x) + getHeightDiff(y, x);
		} else {
			return 0;
		}
	}
	
	public int getManhattan(int y, int x) {
		return Math.abs(y - yGoal) + Math.abs(x - xGoal);
	}
	
	public int getEuclidean(int y, int x) {
		return (int) Math.sqrt((x - xGoal) * (x - xGoal) + (y - yGoal) * (y - yGoal));
	}
	
	public int getHeightDiff(int y, int x) {
		int[][] tmap = getTerrainMap().getTmap();
		if (tmap[y][x] > tmap[yGoal][xGoal]) {
			return 0;
		} else {
			return tmap[yGoal][xGoal] - tmap[y][x];
		}
	}
	
}
