package labor10;

import java.util.ArrayList;

public class LösRuckSackProBackTrack {

	public static void main(String[] args) {

		ArrayList<Item> items = new ArrayList<Item>();

		//-------------------- Item(value, weight(g))
		Item watterBottle = new Item(600, 100);
		Item food = new Item(500,500);
		Item schlafsack = new Item(500,2000);
		Item klopappier = new Item(300, 30);
		Item kleidung = new Item(400,2000);
		Item parfum = new Item(200,25);
		Item gamebords = new Item(250, 200);
		Item haschT = new Item(1000,10);
		Item alkohol = new Item(800,250);
		
		
		items.add(watterBottle);
		items.add(food);
		items.add(schlafsack);
		items.add(klopappier);
		items.add(kleidung);
		items.add(parfum);
		items.add(gamebords);
		items.add(haschT);
		items.add(alkohol);
		System.out.println(items.size());
		
		System.out.println(backtrack(items, 70000));

	}

	static Integer backtrackHelper(ArrayList<Item> items, int maxWeight, int i) {
		if (maxWeight < 0) {
			return null;
		} else if (i < 0) {
			return 0;
		} else {
			Integer ohne = backtrackHelper(items, maxWeight, i - 1);
			Integer mit = backtrackHelper(items, maxWeight - items.get(i).weight, i - 1);
			if (mit == null) {
				return ohne;
			} else if (ohne == null) {
				return mit + items.get(i).value;
			} else {
				return Math.max(mit + items.get(i).value, ohne);
			}
		}

	}

	static Integer backtrackHelper2(ArrayList<Item> items, int maxWeight, int i) {

		if (maxWeight < 0) {
			return null;
		} else if (i < 0) {
			return 0;
		} else if (maxWeight >= items.get(i).weight) {
			Integer ohne = backtrackHelper(items, maxWeight, i - 1);
			Integer mit = backtrackHelper(items, maxWeight - items.get(i).weight, i - 1);
			if (mit == null) {
				return ohne;
			} else if (ohne == null) {
				return mit + items.get(i).value;
			} else {
				return Math.max(mit + items.get(i).value, ohne);
			}
		} else {
			return backtrackHelper(items, maxWeight, i - 1);
		}

	}

	static Integer backtrack(ArrayList<Item> items, int maxWeight) {
		return backtrackHelper2(items, maxWeight, items.size() - 1);
	}

}
