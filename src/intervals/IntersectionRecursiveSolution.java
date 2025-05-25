package intervals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/*
 * Вам даны два списка закрытых интервалов, firstList и secondList, 
 * где firstList[i] = [starti, endi] и secondList[j] = [startj, endj]. 
 * Каждый список интервалов попарно не пересекается и отсортирован.
 * 
 * Пересечение двух закрытых интервалов — это множество действительных чисел, 
 * которые либо пусты, либо представлены в виде закрытого интервала. 
 * Например, пересечение [1, 3] и [2, 4] равно [2, 3].
 */

public class IntersectionRecursiveSolution {

	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		List<int[]> ans = new ArrayList<>();
		getIntervel(firstList, secondList, 0, 0, ans);
		return ans.toArray(new int[ans.size()][2]);
	}

	private List<int[]> getIntervel(int[][] firstList, int[][] secondList, int i, int j, List<int[]> ans) {
		if (i == firstList.length || j == secondList.length)
			return ans;
		int begin = Math.max(firstList[i][0], secondList[j][0]);
		int end = Math.min(firstList[i][1], secondList[j][1]);

		if (begin <= end)
			ans.add(new int[] {begin, end});
		if (end == firstList[i][1])
			return getIntervel(firstList, secondList, i + 1, j, ans);
		return getIntervel(firstList, secondList, i, j + 1, ans);
	}

	@Test
	void case1() {
		int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
		int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

		int[][] expected = {{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}};
		int[][] actual = intervalIntersection(firstList, secondList);

		for (int i = 0; i < actual.length; ++i) {
			for (int j = 0; j < actual[0].length; ++j) {
				assertEquals(expected[i][j], actual[i][j]);
			}
		}
	}
}
