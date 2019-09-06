/**
 * @Desc 静态代码块,静态变量-->变量,代码块-->构造函数
 * @Author lizeng
 * @CreateTime 2019/9/2 18:15
 **/
public class Main {
    static {
        i = 0;
        //System.out.println(i);
    }

    static int i = 1;
    static int j = 1;
    static {
        j = 2;
    }
    static class Father {
        public static final String TAG = "Father";
        static {
            System.out.println("static Father");
        }

        {
            System.out.println("unStatic Father");
        }

        public Father() {
            System.out.println("constructor Father");
            //method();
        }

        public void method() {
            System.out.println("method Father");
        }

        @Override
        public String toString() {
            return "toString Father";
        }
    }

    static class Son extends Father {
        public static Son instance = new Son();

        static {
            System.out.println("static Son");
        }

        {
            System.out.println("unStatic Son");
        }

        public Son() {
            System.out.println("constructor Son");
            //method();
        }

        public void method() {
            System.out.println("method Son");
        }

        @Override
        public String toString() {
            return "toString Son";
        }
    }

    public static void main(String[] args) {
        /*System.out.println("1.---------------------");
        System.out.println(Son.TAG);
        Son[] sons = new Son[10];
        System.out.println(sons);
        System.out.println("2.---------------------");
        System.out.println(Son.instance);
        System.out.println("3.---------------------");*/
        Son son = new Son();
        /*Father father = son;
        father.method();
        System.out.println(son);*/
        System.out.println(Main.i);
        System.out.println(Main.j);
    }
}
