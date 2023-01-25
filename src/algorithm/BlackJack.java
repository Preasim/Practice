package algorithm;

import java.util.ArrayList;

class BlackJack {
    public static void main(String[] args) {
        int[] cards = {1, 2, 3, 4};
        int count = 0;

        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    int number = cards[i] + cards[j] + cards[k];
                    if(isPrime(number)) count++;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean isPrime(int number) {
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}
