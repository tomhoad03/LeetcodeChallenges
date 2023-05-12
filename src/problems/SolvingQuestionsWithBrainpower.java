package problems;

import java.util.HashMap;

public class SolvingQuestionsWithBrainpower {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(mostPoints(new int[][]{{72,5},{36,5},{95,5},{50,1},{62,1},{14,3},{72,5},{86,2},{43,3},{51,3},{14,1},{91,5},{47,4},{72,4},{63,5},{40,3},{68,1},{8,3},{84,5},{7,5},{40,1},{35,3},{66,2},{39,5},{40,1},{92,3},{67,5},{34,3},{84,4},{75,5},{6,1},{71,3},{77,3},{25,3},{53,3},{32,3},{88,5},{18,2},{21,3},{78,2},{69,5},{45,4},{94,2},{70,1},{85,2},{7,2},{68,4},{71,4},{57,2},{12,5},{53,5},{51,3},{46,1},{28,3}}));
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    // {{3,2},{4,3},{4,4},{2,5}}

    // {{12,46},{78,19},{63,15},{79,62},{13,10}}

    // {{72,5},{36,5},{95,5},{50,1},{62,1},{14,3},{72,5},{86,2},{43,3},{51,3},{14,1},{91,5},{47,4},{72,4},{63,5},{40,3},{68,1},{8,3},{84,5},{7,5},{40,1},{35,3},{66,2},{39,5},{40,1},{92,3},{67,5},{34,3},{84,4},{75,5},{6,1},{71,3},{77,3},{25,3},{53,3},{32,3},{88,5},{18,2},{21,3},{78,2},{69,5},{45,4},{94,2},{70,1},{85,2},{7,2},{68,4},{71,4},{57,2},{12,5},{53,5},{51,3},{46,1},{28,3}}

    public static int mostPoints(int[][] questions) {
        return mostPointsIndex(questions, 0);
    }

    private static final HashMap<Integer, Integer> savedResults = new HashMap<>();

    public static int mostPointsIndex(int[][] questions, int index) {
        if (index == questions.length) {
            return 0;
        }
        if (index == questions.length - 1) {
            return questions[index][0];
        }

        if (savedResults.containsKey(index)) {
            return savedResults.get(index);
        }

        int scoreA = questions[index][0];
        int scoreB = mostPointsIndex(questions, index + 1);

        if (index + questions[index][1] > questions.length - 1){
            savedResults.put(index, Math.max(scoreA, scoreB));
            return Math.max(questions[index][0], mostPointsIndex(questions, index + 1));
        }

        scoreA += mostPointsIndex(questions, index + questions[index][1] + 1);
        savedResults.put(index, Math.max(scoreA, scoreB));
        return Math.max(scoreA, scoreB);
    }
}