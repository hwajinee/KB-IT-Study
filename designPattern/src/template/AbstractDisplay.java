package template;

// 이 클래스는 '템플릿'이 된다.
public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();

    // 템플릿 메서드
    public final void display() {
        open();
        for(int i=0; i<5; i++){
            print();
        }
        close();
    }
}
