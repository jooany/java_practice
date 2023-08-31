package design_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 옵저버 패턴이란, 주체가 객체의 상태 변화를 감지하면, 옵저버 리스트에 있는 옵저버들, 즉, 의존하는 객체들에게 자동으로 알림을 전달하는 디자인 패턴이다.
 *
 * 코드 풀이 : 쿠팡 재고 알림 서비스의 얕은 흐름을 옵저버패턴으로 구현했다.
 *          쿠팡에 재고가 추가된다면, 해당 수량만큼 해당 상품 재입고 알림을 등록한 옵저버들에게 알림이 전달된다.
 */

// 쿠팡 재고 알림
public class ObserverPattern {
    interface Subject {
        void addObserver(Observer observer);
        void removeObserver(Observer observer);
        void notice();
    }

    class CoupangProduct implements Subject {
        private List<Observer> observerList = new ArrayList<>();
        private int total;

        @Override
        public void addObserver(Observer observer) {
            observerList.add(observer);
        }

        @Override
        public void removeObserver(Observer observer) {
            observerList.remove(observer);
        }

        @Override
        public void notice() {
            for(Observer o : observerList){
                System.out.println(o.getName() + "님! 기다리시던 상품이 " + total + " 수량만큼 재입고 되었습니다.");
            }
        }

        public void setTotal(int total){
            this.total = total;
        }
    }

    interface Observer {
        String getName();
    }

    class User implements Observer {
        private String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        ObserverPattern observerPattern = new ObserverPattern();
        User user1 = observerPattern.new User("영희");
        User user2 = observerPattern.new User("철수");

        Subject coupang = observerPattern.new CoupangProduct();
        coupang.addObserver(user1);
        coupang.addObserver(user2);

        // 상품이 수량이 50개 만큼 재입고 되었다면?!
        ((CoupangProduct) coupang).setTotal(50);
        coupang.notice();

    }
}
