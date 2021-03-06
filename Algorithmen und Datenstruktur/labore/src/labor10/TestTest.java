package labor10;

public class TestTest {

	public static void main(String[] args) {

		System.out.println(knapsack(values.length - 1, W));

	}

	static int[] values = new int[] { 894, 260, 392, 281, 27 };
	static int[] weights = new int[] { 8, 6, 4, 0, 21 };
	static int W = 30;

	private static Integer knapsack(int i, int W) {
		if (i < 0) {
			return null;
		}
		if (weights[i] > W) {
			return knapsack(i - 1, W);
		} else {
			return Math.max(  knapsack(i - 1, W), knapsack(i - 1, W - weights[i])  + values[i] );
		}
	}

}
