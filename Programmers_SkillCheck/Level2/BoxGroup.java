public class BoxGroup {
    public static void main(String[] args) {
        int[] cards = { 8, 6, 3, 7, 2, 5, 1, 4 };
        new BoxGroup().solution(cards);
    }

    public int solution(int[] cards) {

        int answer = Integer.MIN_VALUE;
        // 그룹1 확인
        for (int i = 0; i < cards.length; i++) {
            boolean[] check = new boolean[cards.length];

            int group1Count = 0;
            int group2Count = 0;

            int index = i;
            while (!check[index]) {
                group1Count++;
                check[index] = true;
                index = cards[index] - 1;
            }

            // 그룹1에 모든 상자들이 열린 경우
            if (group1Count == cards.length) {
                answer = Math.max(answer, 0);
            } else {
                // 그룹2 확인
                // check 배열에서 최초로 false 인 상자 탐색
                for (index = 0; index < check.length; index++) {
                    int idx = index;
                    boolean[] check2 = check.clone();

                    if (!check2[idx]) {
                        int count = 0;
                        while (!check2[idx]) {
                            count++;
                            check2[idx] = true;
                            idx = cards[idx] - 1;
                        }
                        group2Count = Math.max(group2Count, count);
                    }
                }
                int score = group1Count * group2Count;
                answer = Math.max(answer, score);
            }
        }
        System.out.println(answer);
        return answer;
    }
}
