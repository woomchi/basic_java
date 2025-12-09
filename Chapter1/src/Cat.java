class Cat extends Animal {
    public Cat(String name) { super(name); }

    void cry() {   //Cat 클래스에서의 Overriding
        System.out.println(name + ": 야옹~");
    }
    public static void main(String[] args) {
    	// 추상 클래스는 직접 객체 생성 불가하므로 자식 클래스로 객체 생성
    	// Animal a = new Animal("동물"); (X)
    	Dog dog = new Dog("바둑이");
    	Cat cat = new Cat("나비");
    	
    	// 부모 클래스로부터 상속받은 공통 기능
    	dog.breathe();
    	cat.breathe();
    	System.out.println("---");
    	dog.cry(); // 멍멍!!
    	cat.cry(); // 야옹~
    }   
}

