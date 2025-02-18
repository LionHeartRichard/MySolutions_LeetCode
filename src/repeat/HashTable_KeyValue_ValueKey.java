package repeat;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class HashTable_KeyValue_ValueKey {

	/*
	 * Алгоритм когда мы заполняем мапу ключь-значение а потом переворачиваем
	 * значение-ключь
	 */

	/*
	 * Задача: Дан целочисленный масив nums, и целое число k, нужно вернуть k
	 * наиболее частых элементов. Можно вернуть в любом порядке
	 */

	public int[] valueKey_keyValue(int[] arr, int k) {
		// 1) заполняем мапу ключ-значение
		Map<Integer, Integer> map = new HashMap<>();
		for (int key : arr)
			map.put(key, map.getOrDefault(key, 0) + 1);

		// 2) алацируем массив пустых списков
		int len = arr.length;
		List<Integer>[] cache = new List[len + 1];
		for (int i = 1; i <= len; ++i)
			cache[i] = new ArrayList<>();

		// 3) меняем местами ключ значение
		for (int key : map.keySet())
			cache[map.get(key)].add(key);

		// 4) формируем ответ
		List<Integer> ans = new ArrayList<>();
		for (int i = len; i > 0; --i) {
			List<Integer> tmp = cache[i];
			for (int val : tmp) {
				if (k == 0)
					return ans.stream().mapToInt(v -> v).toArray();
				ans.add(val);
				--k;
			}
		}
		return ans.stream().mapToInt(v -> v).toArray();
	}

	@Test
	public void case1() {
		int[] nums = {5, 3, 1, 5, 5, 3, 777};
		int k = 2;
		Set<Integer> expected = new HashSet<>();
		expected.add(3);
		expected.add(5);

		int[] actual = valueKey_keyValue(nums, k);

		for (int item : actual) {
			assertTrue(expected.contains(item));
		}
	}

	@Test
	public void case2() {
		int[] nums = {0, 0, 0, 0, 0, 0, 0};
		int k = 3;
		Set<Integer> expected = new HashSet<>();
		expected.add(0);

		int[] actual = valueKey_keyValue(nums, k);

		for (int item : actual) {
			assertTrue(expected.contains(item));
		}
	}

}
