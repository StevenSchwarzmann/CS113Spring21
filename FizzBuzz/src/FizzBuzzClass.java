
public class FizzBuzzClass {
	public void print() {
		String result = "";
		
		for(int i = 1; i <= 100; i++) {
			if(i % 15 == 0) {
				result += "FizzBuzz ";
			}
			else if(i % 5 == 0){
				result += "Buzz ";
			}
			else if(i % 3 == 0) {
				result += "Fizz ";
			}
			else {
				result += i + " ";
			}
		}
		
		System.out.println(result);
	}
}
