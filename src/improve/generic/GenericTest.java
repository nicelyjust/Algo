package improve.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 静态方法和静态变量不可以使用泛型
 * @Author lizeng
 * @CreateTime 2019/11/13 15:18
 **/
public class GenericTest {
    public static void main(String[] args) {
        GenericObject<Student> genericObject = new GenericObject<>(new Student("李四",25,"master"));
        List<Object> objects = new ArrayList<>();
        addNumbers(objects);
        /*List<Double> doubles = new ArrayList<>();
        addNumbers(doubles);//报错
        */
    }

    /**
     *
     * @param list 下边界通配符,是之超类
     */
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
    /**
     * extends 上边界通配符
     * @param <T> 继承了Person类,或者是实现Person接口
     */
    static class GenericObject<T extends Person>{
        private T t;

        public GenericObject(T t) {
            this.t = t;
        }

        public T getGenericObject() {
            return t;
        }

        public void setGenericObject(T t) {
            this.t = t;
        }
    }

}
