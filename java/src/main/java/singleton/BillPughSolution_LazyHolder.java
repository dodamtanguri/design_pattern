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
    //내부 클래스도 결국은 클래스라 클래스가 로드될때 딱 한 번만 초기화되는 특성을 이용 >> static final 상수에 싱글톤 객체 할당.
    //클래스로딩 및 초기화 과정이 스레드 세이프함을 이용하여 멀티스레드 환경에서도 문제없이 싱글톤 인스턴스를 만들 수 있음.
    private static class  SingletonHolder{
        private static final BillPughSolution_LazyHolder instance = new BillPughSolution_LazyHolder();
    }
    }

