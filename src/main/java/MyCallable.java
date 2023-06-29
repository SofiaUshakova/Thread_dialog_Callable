import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class MyCallable implements Callable<String> {
    private String name;
    private AtomicInteger count = new AtomicInteger();

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(2500);
            System.out.printf("Всем привет! Я %s.\n", this.name);
            count.incrementAndGet();
        }
//      Закомментировать для invokeAll
        System.out.printf("%s завершен\n", name);
        return String.format("%s вывел в консоль %d строки", name, count.get());
//        Раскомментировать для invokeAll
//        System.out.printf("%s завершен, вывел %d строк\n", name, count.get());

    }
}
