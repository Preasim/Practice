package stream.one;

import java.util.Random;
import java.util.stream.IntStream;

public class StreamCreator {
    public static void main(String[] args){
        IntStream intStream = IntStream.rangeClosed(1,10);
        intStream.forEach(System.out::println);
    }
}
