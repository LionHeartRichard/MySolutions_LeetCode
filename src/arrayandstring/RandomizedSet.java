package arrayandstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */

// применение паттерна ключ-значение, значение-ключ
public class RandomizedSet {

	// напротив индекса храним значения, причем они же хранятся еще как ключи в
	// таблице
	List<Integer> nums;
	// в таблице храним в качестве ключа значение
	// а в качестве значения индекс ЛИСТА
	Map<Integer, Integer> table;
	Random random;

	public RandomizedSet() {
		nums = new ArrayList<>();
		table = new HashMap<>();
		random = new Random();
	}

	// вставка в наши структуры данных в соответствии указаным выше параметрам
	public boolean insert(int value) {
		if (table.containsKey(value))
			return false;
		table.put(value, nums.size());
		nums.add(value);
		return true;
	}

	public boolean remove(int value) {
		if (!table.containsKey(value))
			return false;
		// получаем индекс элемента который хотим удалить
		int idx = table.get(value);

		// если индекс не крайний то нам нужно перезаписать последний элемент на место
		// удаляемого, тогда быстрое удаление из спсика по индексу - будет равносильно
		// удалению последнего элемента что происходит быстро O(1)
		if (idx < nums.size() - 1) {
			int lastItem = nums.get(nums.size() - 1);
			nums.set(idx, lastItem);
			table.put(lastItem, idx);
		}
		table.remove(value);
		nums.remove(nums.size() - 1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return nums.get(random.nextInt(nums.size()));
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */