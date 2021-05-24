package labor01;

public class Main {

	public static void main(String[] args) {

		ArrayList<String> arrayList_a = new ArrayList<String>();
		arrayList_a.add(0, "a");
		arrayList_a.add(1, "b");
		arrayList_a.add(2, "c");
		System.out.println(arrayList_a.size());

//		System.out.println("size of the arrayList_a is:"+arrayList_a.size());

		for (int i = 0; i < arrayList_a.size(); i++) {
			System.out.println("element " + i + ":" + arrayList_a.get(i));
		}

	}

}
