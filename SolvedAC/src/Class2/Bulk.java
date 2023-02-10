package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bulk {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		class Person {
			private int weight;
			private int height;
			private int rank;

			public Person(int weight, int height, int rank) {
				this.weight = weight;
				this.height = height;
				this.rank = rank;
			}
		}

		List<Person> resultList = new ArrayList<Person>();

		int count = Integer.parseInt(br.readLine());
		Person[] bulkArray = new Person[count];

		StringTokenizer st = null;
		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());

			Person person = new Person(weight, height, 1);
			bulkArray[i] = person;
		}

		// 배열 내부에서 각 인덱스간 몸무게, 키 비교
		for (int i = 0; i < bulkArray.length; i++) {

			Person person = bulkArray[i];

			for (int index = 0; index < bulkArray.length; index++) {
				if (index == i)
					continue;
				else {
					if (person.height < bulkArray[index].height && person.weight < bulkArray[index].weight)
						person.rank += 1;
				}
			}

			resultList.add(person);
		}

		resultList.stream().forEach(x -> {
			try {
				bw.write(x.rank + " ");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		bw.flush();
		bw.close();

	}
}
