package net.roszczyk.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Program {
    private final AtomicLong processNo = new AtomicLong(0);
    private ObjectPool<ExportingProcess> pool;

    public static void main(String[] args) {
        Program program = new Program();

        program.setUp();
        program.tearDown();
        program.testObjectPool();
    }

    public void setUp() {
        pool = new ObjectPool<ExportingProcess>(4, 10, 5) {
            protected ExportingProcess createObject() {
                return new ExportingProcess(processNo.incrementAndGet());
            }
        };
    }

    public void tearDown() {
        pool.shutdown();
    }

    public void testObjectPool() {

        ExecutorService executor = Executors.newFixedThreadPool(8);
        executor.execute(new ExportingTask(pool, 1));
        executor.execute(new ExportingTask(pool, 2));
        executor.execute(new ExportingTask(pool, 3));
        executor.execute(new ExportingTask(pool, 4));
        executor.execute(new ExportingTask(pool, 5));
        executor.execute(new ExportingTask(pool, 6));
        executor.execute(new ExportingTask(pool, 7));
        executor.execute(new ExportingTask(pool, 8));

        executor.shutdown();
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}