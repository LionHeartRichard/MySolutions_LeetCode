package printInfoActionByData;

public class PrintMathOperstions {

	public static void main(String[] args) {
		printOperationMath();
	}

	public static void printOperationMath() {
		int num = 100;
		for (int i = 1; i <= 100; ++i) {
			int ans = num % i;
			System.out.println(num + " % " + i + " = " + ans);
		}
	}
}
