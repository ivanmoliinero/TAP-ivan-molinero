package exercisesSolved.map2;

import java.util.Arrays;
import java.util.List;

public class MapSample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("pedro", "lenguajes", "programacion", "Java", "haskell");

		List<Integer> result2 = Map.map(list, x -> x.length());

		for (Integer elem:result2)
			System.out.println(elem);

	}

}
