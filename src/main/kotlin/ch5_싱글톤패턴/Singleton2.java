package ch5_싱글톤패턴;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 싱글톤 객체
class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {}

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2(); // 오직 1개의 객체만 생성
        }
        return instance;
    }
}

public class Main {
    public static void main(String[] args) {
        // 1. 싱글톤 객체를 담을 배열
        Singleton2[] singleton = new Singleton2[10];

        // 2. 스레드 풀 생성
        ExecutorService service = Executors.newCachedThreadPool();

        // 3. 반복문을 통해 10개의 스레드가 동시에 인스턴스 생성
        for (int i = 0; i < 10; i++) {
            final int num = i;
            service.submit(() -> {
                singleton[num] = Singleton2.getInstance();
            });
        }

        // 4. 종료
        service.shutdown();

        // 5. 싱글톤 객체 주소 출력
        for(Singleton2 s : singleton) {
            System.out.println(s.toString());
        }
    }
}