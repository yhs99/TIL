import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDaemon {
	public static void main(String[] args) { 
		// 고정 크기의 스레드 풀 생성 (크기: 5)
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);

        // 작업 제출
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyRunnableTask(i));
        }
        for (int i = 0; i < 1000; i++) {
            executorService2.execute(new MyRunnableTask(i));
        }

        // 스레드 풀 종료
        executorService.shutdown();
    }
}

class MyRunnableTask implements Runnable {
    private final int taskId;

    public MyRunnableTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " is being executed by thread " + Thread.currentThread().getName());
    }
}