package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Jersey {

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Jersey().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int jerseyCount = Integer.parseInt(br.readLine());
        int studentCount = Integer.parseInt(br.readLine());
        char[] jerseyArray = new char[jerseyCount + 1];

        // 입력조건상 어차피 0번째 인덱스는 이용 될일이 없다.
        // 그러므로 Z 로 초기화 해두고 방치한다.
        jerseyArray[0] = 'Z';
        for (int i = 1; i < jerseyArray.length; i++) {
            jerseyArray[i] = br.readLine().charAt(0);
        }

        int result = 0;
        for (int i = 0; i < studentCount; i++) {
            String[] input = br.readLine().split(" ");
            char size = input[0].charAt(0);
            int number = Integer.parseInt(input[1]);
            // 학생들이 가지고 있는 저지의 숫자보다 더 큰 값의 등번호를 요구할 수도 있기 때문에
            // 저지 배열의 크기가 학생들이 원하는 등번호 숫자보다 더 큰지부터 확인한다.
            if (number <= jerseyArray.length - 1) {
                // 원하는 등번호가 적힌 저지가 학생이 요구하는 사이즈보다 크거나 같은 경우
                // 아스키 코드상으로 보면 L(76) -> M(77) -> S(83) 으로 S 가 가장 커지기 때문에
                // Z(90) 에서 각 사이즈의 아스키 코드값을 빼주는 것으로 크기를 뒤집는다.
                if ('Z' - jerseyArray[number] >= 'Z' - size) {
                    result++;
                    // Z 로 설정하는 이유 : 사이즈 크기를 비교할 때 이미 분배된 저지의 경우
                    // 아스키 코드 값을 Z - Z = 0 으로 만들어서 저지를 분배받지 못하게 하기 위함
                    jerseyArray[number] = 'Z';
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}