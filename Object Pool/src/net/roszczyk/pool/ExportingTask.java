package net.roszczyk.pool;

public class ExportingTask implements Runnable {
    private final ObjectPool<ExportingProcess> pool;
    private final int threadNo;

    public ExportingTask(ObjectPool<ExportingProcess> pool, int threadNo) {
        this.pool = pool;
        this.threadNo = threadNo;
    }

    public void run() {
        ExportingProcess exportingProcess = pool.borrowObject();

        System.out.println("Thread " + threadNo + ": Object with process no. " + exportingProcess.getProcessNo() + " was borrowed");
        pool.returnObject(exportingProcess);
        System.out.println("Thread " + threadNo + ": Object with process no. " + exportingProcess.getProcessNo() + " was returned");
    }

}
