package annotationandreflaction.myclasses;

public class MyClass<T> {
    public T someObject;

    public MyClass(T someObject) {
        this.someObject = someObject;
    }

    public MyClass() {
    }

    public T getSomeObject() {
        return someObject;
    }

    public void setSomeObject(T someObject) {
        this.someObject = someObject;
    }
}
