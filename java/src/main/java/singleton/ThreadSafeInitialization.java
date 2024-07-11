package singleton;

public class ThreadSafeInitialization {
    private static ThreadSafeInitialization instance;

    private ThreadSafeInitialization() {}
    //synchronized : 멀티스레드 환경에서 두개 이상의 쓰레드가 하난의 변수에 동시에 접근을 할때 경쟁상태가 발생하지 않도록함. (lock)
    public static synchronized ThreadSafeInitialization getInstance() {
        if(instance == null) {
            instance = new ThreadSafeInitialization();
        }
        return instance;
    }
    public static void main(String[] args) {
        Runnable task = () -> {
            ThreadSafeInitialization singleton = ThreadSafeInitialization.getInstance();
            System.out.println(singleton);
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
