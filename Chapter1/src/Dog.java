// 자식 클래스: 부모 클래스에 대한 구체적인 구현
class Dog extends Animal {
    public Dog(String name) { super(name); }

    void cry() {   //Dog클래스의 Overriding
        System.out.println(name + ": 멍멍!!");
    }
}