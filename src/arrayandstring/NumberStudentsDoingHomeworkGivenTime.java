package arrayandstring;

public class NumberStudentsDoingHomeworkGivenTime {

	/*
	 * Даны два целочисленных массива startTime и endTime и дано целочисленное
	 * queryTime. Студент i начал делать домашнее задание в момент времени
	 * startTime[i] и закончил его в момент времени endTime[i]. Верните количество
	 * студентов, выполняющих домашнее задание в момент времени queryTime. Более
	 * формально, верните количество студентов, где queryTime лежит в интервале
	 * [startTime[i], endTime[i]] включительно.
	 */

	public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
		int ans = 0;
		for (int i = 0; i < startTime.length; ++i) {
			if (queryTime >= startTime[i] && queryTime <= endTime[i])
				++ans;
		}
		return ans;
	}

}
