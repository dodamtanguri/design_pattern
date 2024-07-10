package singleton;

public class EagerInitialization {
    // 싱글톤 클래스 객체를 담을 인스턴스 변수
    // static : 클래스레벨에서 사용, 클래스 로드시 단 한번만 메모리에 할당, 이후 생성되는 모든 인스턴스에서 공유됨. 상수값이나 공유해야할 자원을 관리할 때 유용
    // static method : 인스턴스 변수에 접근 x, 오직 static 변수나 다른 static 메소드에만 접근할 수 있음 (클래스레벨에서 작동하기때문)
    // static final : 클래스 상수, 모든 인스턴스에서 공유되며 변경할 수 없는 값이 됨. >> 프로그램 전체에서 일관된 값을 유지할 때 사용.
    private static final EagerInitialization INSTANCE = new EagerInitialization();

    // 생성자를 private로 선언 (외부에서 new 사용 X)
    private EagerInitialization() {}

    public static EagerInitialization getInstance() {
        return INSTANCE;
    }
}
