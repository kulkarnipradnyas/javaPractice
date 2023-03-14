
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    public static long checkPerformanceResult(Supplier<Integer> supplier, int numberOfTimes){

        long startTime = System.currentTimeMillis();
        for(int i=0;i<numberOfTimes;i++){
            supplier.get();
        }
        long endTime = System.currentTimeMillis();
        return endTime-startTime;
    }



    public static int sumSequentialStream(){

        return IntStream.rangeClosed(1,100000)
                .sum();
    }
/// fork / join framework
    public static int sumParallelStream(){

        return IntStream.rangeClosed(1,100000)
                .parallel()
                .sum();
    }

    public static void main(String[] args) {
    		System.out.println(Runtime.getRuntime().availableProcessors() + "processor");

        System.out.println("Sequential Stream Result :" +
                checkPerformanceResult(ParallelStreamExample::sumSequentialStream
                        ,20));
        System.out.println("Parallel Stream Result : " +
                checkPerformanceResult(ParallelStreamExample::sumParallelStream
                ,20));
          String word = "AAABBB";
          Map<Character, Integer> charCount = word.chars().boxed().collect(Collectors.toMap(
                    k -> Character.valueOf((char) k.intValue()),
                    v -> 1,
                    Integer::sum));
    System.out.println(charCount);
    
    Map<String, String> map = new HashMap<>();
    map.put("C", "c");
    map.put("B", "b");
    map.put("Z", "z");
    
    List<Map.Entry<String, String>> sortedByKey = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
        .collect(Collectors.toList());
    sortedByKey.forEach(System.out::println);

    }
}
// parallel stream will not perform when it comes to boxing unboxing
// concurrently mutable variable then dont use paralellel stream , it will give diff result