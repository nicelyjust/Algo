package improve.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Desc Runtime1.得到Class对象,class对象中有类的各种信息,然后可以动态创建对象,访问各种
 * @Author lizeng
 * @CreateTime 2019/12/4 18:12
 **/
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 获取Class对象有三种方式: 第一种 使用Class.forName("该类的全路径") Class<?> aClass = Class.forName("improve.reflection.Father");
        // 第二种: 编译之前就知道操作的Class Class<Father> fatherClass = Father.class;
        // 第三种: 使用类对象的getClass()方法,Class<? extends Father> aClass = father.getClass();
        Class<?> aClass = Class.forName("improve.reflection.Father");
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            // 获取Class类的属性,但无法获取私有属性
            System.out.println(field.getName());
        }
        // 类似的获取方法:getDeclaredMethods()
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            // 获取Class类的所有属性
            System.out.println(declaredField.getName());
        }
        // 通过反射创建类对象的方式:
        //第一种采用Class对象的newInstance()方法,只能调用无参构造方法
        //Object newInstance = aClass.newInstance();
        //第二种:通过Constructor对象的newInstance方法,可以调用有参构造方法
        Constructor<?> constructor = aClass.getConstructor(String.class, int.class);
        Object instance = constructor.newInstance("李四", 30);

        // 调用私有方法
        Method getFatherName = aClass.getDeclaredMethod("getFatherName", null);
        getFatherName.setAccessible(true);
        System.out.println(getFatherName.invoke(instance));
        // 调用私有属性
        Field fatherName = aClass.getField("fatherName");
        fatherName.setAccessible(true);
        fatherName.get(instance);

    }
}
