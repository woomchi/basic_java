// 추상 클래스 == 미완성 설계도
abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    // 일반 메서드 (공통 기능을 부여)
    void breathe() {
        System.out.println(name + "이(가) 숨을 쉽니다. 습-하!");
    }

    // 추상 메서드 : 자손 클래스에서 반드시 구현해야함
    abstract void cry();
}