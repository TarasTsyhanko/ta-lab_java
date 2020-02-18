package annotationandreflection;

public class MyClass<T> {
    public T someObject;

    public MyClass(T someObject) {
        this.someObject = someObject;
    }

    public T getSomeObject() {
        return this.someObject;
    }

    public void setSomeObject(T someObject) {
        this.someObject = someObject;
    }
}
