public class E1Q5 {
	public static void FizzBuzz() {
		for (int i = 1; i < 101 ; i++) {
			if (i%3 == 0 && i%5 == 0) {
				System.out.println(i + ". Fizz Buzz");
			} else if (i%3 == 0) {
				System.out.println(i + ". Fizz");
			} else if (i%5 == 0) {
				System.out.println(i + ". Buzz");
			} else {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		FizzBuzz();
	}
}
