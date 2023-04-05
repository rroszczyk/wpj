public class ExportingProcess {
    private final long processNo;

    public ExportingProcess(long processNo) {
        this.processNo = processNo;

        // TU MIESZKAJĄ SMOKI

        System.out.println("Object with process no. " + processNo + " was created");
    }

    public long getProcessNo() {
        return processNo;
    }
}
