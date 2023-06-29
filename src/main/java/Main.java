import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        List<Callable<String>> list = List.of(
                new MyCallable("поток 1"),
                new MyCallable("поток 2"),
                new MyCallable("поток 3"),
                new MyCallable("поток 4"));
//        Раскомментировать для invokeAll
//        List<Future<String>> callables;
//        try {
//            callables = threadPool.invokeAll(list);
//            System.out.println(callables);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//      Закомментировать для invokeAll
        String callable = threadPool.invokeAny(list);
        System.out.println(callable);
        threadPool.shutdown();
    }
}




