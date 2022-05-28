import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindOddEvenNumbers {

	public static void main(String[] args) {
		List<Integer> e = Arrays.asList(2, 4, 5, 6, 7, 8, 9);
		// Finding even numbers
		List<Integer> e1 = e.stream().filter(val -> val % 2 == 0).collect(Collectors.toList());
		// Finding odd numbers
		List<Integer> e2 = e.stream().filter(val -> val % 2 != 0).collect(Collectors.toList());

		e1.forEach(e3 -> System.out.println(e3));
		System.out.println("================================");
		e2.forEach(e4 -> System.out.println(e4));

		// Finding even and odd numbers in single
		Map<Boolean, List<Integer>> map = e.stream().collect(Collectors.partitioningBy(val -> val % 2 == 0));
		System.out.println("================================");
		System.out.println(map);
	}
}
