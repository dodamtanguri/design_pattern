package singleton;

public class StaticBlockInitialization {
    // 싱글톤 클래스 객체를 담을 인스턴스 변수
    private static StaticBlockInitialization instance;

    // static 블록을 이용해 예외 처리
    //클래스가 로딩되고 클래스 변수가 준비된 후 자동으로 실행하는 블록.
    static {
        try {
            instance = new StaticBlockInitialization();
        } catch (Exception e) {
            throw new RuntimeException("싱글톤 객체 생성 오류");
        }
    }

    // 생성자를 private로 선언 (외부에서 new 사용 X)
    private StaticBlockInitialization() {}

    public static StaticBlockInitialization getInstance() {
        return instance;
    }

}
