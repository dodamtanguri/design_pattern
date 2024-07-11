package singleton;

public class BillPughSolution_LazyHolder {
    private  BillPughSolution_LazyHolder(){}

    public static BillPughSolution_LazyHolder getInstance(){
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        Runnable task = () -> {
            BillPughSolution_LazyHolder singleton = BillPughSolution_LazyHolder.getInstance();
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

    private static class  SingletonHolder{
        private static final BillPughSolution_LazyHolder instance = new BillPughSolution_LazyHolder();
    }


    }

