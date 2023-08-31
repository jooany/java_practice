package design_pattern.factory;

/**
 * 팩토리 패턴 --
 * 클라이언트 코드에서는 각각의 공장에서 어떤 우유가 만들어질지 알 수 없다! 우유의 생성을 추상화 했기 때문이다!
 * 만약 공장에서 만드는 우유를 변경하고 싶다면, 클라이언트 코드를 수정하지 않고 만들 우유를 지정하는 역할을 가진 공장 구현체에서만 코드를 수정하면 된다!
 *
 * 전략 패턴 --
 * 또한 이 코드는 Milk 인터페이스가 전략 역할을, ChockMilk 클래스와 BananaMilk 클래스는 구체적인 전략 역할을 하고 있음으로, 전략 패턴 또한 사용하고 있다.
 */
public class Factory {

    interface Milk {
        String getProductName();
    }

    class ChocoMilk implements Milk{
        @Override
        public String getProductName() {
            return "ChocoMilk";
        }
    }

    class BananaMilk implements Milk{
        @Override
        public String getProductName() {
            return "BananaMilk";
        }
    }

    interface MilkFactory {
        Milk createMilk();
    }

    class MilkFactory1 implements MilkFactory{

        @Override
        public Milk createMilk() {
            return new ChocoMilk();
        }
    }
    class MilkFactory2 implements MilkFactory{

        @Override
        public Milk createMilk() {
            return new BananaMilk();
        }
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        MilkFactory milkFactory1 = factory.new MilkFactory1();
        MilkFactory milkFactory2 = factory.new MilkFactory2();
        Milk factory1Milk = milkFactory1.createMilk();
        Milk factory2Milk = milkFactory2.createMilk();
        System.out.println("factory1Milk = " + factory1Milk.getProductName());
        System.out.println("factory2Milk = " + factory2Milk.getProductName());
    }


}
