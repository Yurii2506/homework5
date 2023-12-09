import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Los_Pinguinos5 {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Spliterator<T> firstSpliterator = first.spliterator();
        Spliterator<T> secondSpliterator = second.spliterator();
        long size = Math.min(firstSpliterator.estimateSize(), secondSpliterator.estimateSize());
        Spliterator<T> zipSpliterator = new Spliterator<T>() {
            @Override
            public boolean tryAdvance(Consumer<? super T> action) {
                boolean firstHasNext = firstSpliterator.tryAdvance(action);
                boolean secondHasNext = secondSpliterator.tryAdvance(action);
                return firstHasNext && secondHasNext;
            }
            @Override
            public Spliterator<T> trySplit() {
                return null;
            }
            @Override
            public long estimateSize() {
                return size;
            }
            @Override
            public int characteristics() {
                return firstSpliterator.characteristics() & secondSpliterator.characteristics() &
                        ~(Spliterator.DISTINCT | Spliterator.SORTED | Spliterator.SIZED);
            }
        };

        return StreamSupport.stream(zipSpliterator, false);
    }
    public static void main(String[] args) {
        Stream<String> firstStream = Stream.of("xd", "g", "r");
        Stream<String> secondStream = Stream.of("5", "2", "6", "4");

        Stream<String> zippedStream = zip(firstStream, secondStream);
        zippedStream.forEach(System.out::println);
    }

}