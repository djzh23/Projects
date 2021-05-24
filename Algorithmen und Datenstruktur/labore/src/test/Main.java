package test;

public class Main {

	public static void main(String[] args) {

		System.out.println(reduceByOne(5));;

	}

	static int reduceByOne(int number) {
		return reduceByOne(number - 1);
	}
}
