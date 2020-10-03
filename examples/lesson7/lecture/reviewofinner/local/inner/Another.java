package lesson7.lecture.reviewofinner.local.inner;

public class Another {
	int z = 4;

	void myMethod(int y, final int x) {
		int w = 3;
		final int u = 4;
		class LocalInner {
			int innerVble = 8;

			private int inner() {
				int newInt = z + innerVble;
//				newInt += y; // compiler error
//				newInt += w; // compiler error
				newInt += u;
				newInt += x;
				return 0;
			}
		}
	}
}
