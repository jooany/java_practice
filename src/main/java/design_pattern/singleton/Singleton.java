package design_pattern.singleton;

/**
 * Singleton 클래스를 하나의 인스턴스만 생성하여 하나의 인스턴스만 사용하고 싶을 때, 싱글톤 패턴을 사용한다.
 * 코드 풀이 : final을 통해 생성한 객체를 변경할 수 없도록 설정하고, 해당 인스턴스를 직접 얻어올 수 없기 때문에,
 *          해당 인스턴스를 얻어오는 메소드를 생성하여, 외부에서 인스턴스를 얻고 싶을 때는 해당 메소드를 사용하면 된다.
 *
 */
class Singleton {
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);
    }

}
