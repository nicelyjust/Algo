### Java中equals与"=="运算符拾遗
先上结论 -> equals()的作用是判断两个对象是否相等,“==”运算符的作用是判断引用内存地址值是否相等，Object类定义如下:
    
    public boolean equals(Object obj) {
        return (this == obj);
    }
如果我们自定义的entity没有覆写equals()时,equals等价于==,而==运算符是判断两个对象是不是同一个对象
，即他们的地址是否相等。而覆写equals更多的是追求两个对象在逻辑上的相等，你可以说是值相等。
#### 覆写equals方法的准则
引用Effective Java书的知识点：
1. 自反性：对于任何非空引用值 x，x.equals(x) 都应返回 true。
2. 对称性：对于任何非空引用值 x 和 y，当且仅当 y.equals(x) 返回 true 时，x.equals(y) 才应返回 true。
3. 传递性：对于任何非空引用值 x、y 和 z，如果 x.equals(y) 返回 true，
并且 y.equals(z) 返回 true，那么 x.equals(z) 应返回 true。
4. 一致性：对于任何非空引用值 x 和 y，多次调用 x.equals(y) 始终返回 true 或始终返回 false，
前提是对象上 equals 比较中所用的信息没有被修改。
5. 非空性：对于任何非空引用值 x，x.equals(null) 都应返回 false。

这都是比较学院派的表达，结合我自己在工作中的经验，大概遵守这两个原则即可：
> 同一对象类型才去做比较,不要把猫和狗去比较;尽量简单化equals()方法内的逻辑

#### hashCode函数的作用
为对象产生散列码,相等的对象必须拥有相等的散列码,散列码相同对象不一定相等,可参考HashMap中的找Bucket原理理解