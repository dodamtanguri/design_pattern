package singleton;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//객체 생성에 대한 관리를 내부적으로 처리.
public class LazyInitialization {
    // 싱글톤 클래스 객체를 담을 인스턴스 변수
    private static LazyInitialization instance;

    // 생성자를 private로 선언 (외부에서 new 사용 X)
    private LazyInitialization() {}

    // 외부에서 정적 메서드를 호출하면 그제서야 초기화 진행 (lazy)
    // 메소드를 호출했을 때 인스턴스 변수의 null 유무에 따라 초기화 하거나 있는 걸 반환.
    // 미사용 고정 메모리 차지의 한계점을 극복
    //Thread Safe 하지 않는 단점을 가지고 있음.
    public static LazyInitialization getInstance() {
        if (instance == null) {
            instance = new LazyInitialization(); // 오직 1개의 객체만 생성
        }
        return instance;
    }

    public static void main(String[] args) {
        // 1. 싱글톤 객체를 담을 배열
        LazyInitialization[] singleton = new LazyInitialization[10];

        // 2. 스레드 풀 생성
        ExecutorService service = Executors.newCachedThreadPool();

        // 3. 반복문을 통해 10개의 스레드가 동시에 인스턴스 생성
        for (int i = 0; i < 10; i++) {
            final int num = i;
            service.submit(() -> {
                singleton[num] = LazyInitialization.getInstance();
            });
        }

        // 4. 종료
        service.shutdown();

        // 5. 싱글톤 객체 주소 출력
        for(LazyInitialization s : singleton) {
            System.out.println(s.toString());
        }

        /**
         * singleton.LazyInitialization@28d93b30
         * singleton.LazyInitialization@1b6d3586
         * singleton.LazyInitialization@4554617c
         * singleton.LazyInitialization@1b6d3586
         * singleton.LazyInitialization@1b6d3586
         * singleton.LazyInitialization@1b6d3586
         * singleton.LazyInitialization@1b6d3586
         */
    }

}
