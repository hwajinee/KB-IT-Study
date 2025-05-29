package ch15.sec03.exam02;

public class Member {
    public String name;
    public int age;

    public Member(String name, int age){
        this.name = name;
        this.age = age;
    }

    // HashSet에 중복저장되지 않도록 하기 위해
    // hashCode(), equals() 메서드 오버라이딩 해야 함.
    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member target) {
            return target.name.equals(name) && (target.age == age);
        } else {
            return false;
        }
    }
}
