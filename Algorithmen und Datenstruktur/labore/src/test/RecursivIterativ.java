package test;

public class RecursivIterativ {

	public static void main(String[] args) {
		int[] sensorA = { 1, 5, 6, 19, -4 };
		int[] sensorB = { 1, 6, 17, 99, 8 };

		int result = totalDiference(sensorA, sensorB);
		int result2 = totalDiferenceRecursiv(sensorA, sensorB);
		System.out.println(result);
		System.out.println(result2);
	}

	private static int totalDiference(int[] sensorA, int[] sensorB) {
		int lenghtOfArrys = sensorB.length;

		int result = 0;
		for (int i = 0; i < lenghtOfArrys; i++) {
			result += Math.abs(sensorA[i] - sensorB[i]);
		}

		return result;
	}

	private static int totalDiferenceRecursiv(int[] sensorA, int[] sensorB) {
		int result = 0;
		if (sensorA.length == 0)
			return 0;
		result += Math.abs(sensorA[sensorA.length - 1] - sensorB[sensorB.length - 1]);
		return result + totalDiference(sensorA, sensorB);
	}
}
