package lesson7.lecture.singletoninherit.usual;

public class AntiqueHome extends House {
	private int numAntiqueWindows;
	private int numOldMirrors;
	
	public AntiqueHome(int numBeds, int age, int numAntiqueWindows, int numOldMirrors) {
		super(numBeds, age);
		this.numAntiqueWindows = numAntiqueWindows;
		this.numOldMirrors = numOldMirrors;
	}

	@Override
	public int computePopularityIndex() {
		return 2 * numAntiqueWindows + 3 * numOldMirrors;
	}
}
