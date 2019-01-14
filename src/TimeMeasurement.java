import processes.Process;

public class TimeMeasurement {

//    Process process;

//    public TimeMeasurement(Process process){
//        process = process;
//    }

    public static void execute(Process process, String processName){
        long start = System.currentTimeMillis();

        process.run();

        long end = System.currentTimeMillis();

        System.out.println(processName + " の実行時間");
        System.out.println((end - start)  + "ms");

    };

}
