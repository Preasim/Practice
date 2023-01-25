//package algorithm;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//class RockPaperScissors {
//    String[] rps = new String[]{"rock", "paper", "scissors"};
//    public static void main(String[] args) {
//        int rounds = 5;
//
//        ArrayList<String[]> outcomes = new ArrayList<>();
//        return permutation(rounds, new String[]{}, outcomes);
//
//    }
//    public ArrayList<String[]> permutation(int roundsToGo, String[] playedSoFar, ArrayList<String[]> outcomes){
//        if(roundsToGo == 0){
//            outcomes.add(playedSoFar);
//            return outcomes;
//        }
//
//        for(int i = 0; i < rps.length; i++) {
//            String currentPlay = rps[i];
//
//            String[] concatArray = Arrays.copyOf(playedSoFar, playedSoFar.length + 1);
//            concatArray[concatArray.length - 1] = currentPlay;
//
//            outcomes = permutation(roundsToGo - 1, concatArray, outcomes);
//        }
//        System.out.println(outcomes);
//        return outcomes;
//    }
//}
