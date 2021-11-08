### Interview Plan

### 算法

> 目标：剑指offer所有简单题、Leetcode 简单题 +高频率中等题

##### 数组

##### 链表

##### 栈、队列

##### 排序

1. 选择排序：O(n^2)两层遍历找出最大/最小数

2. 冒泡排序：O(n^2)相邻元素比较，交换元素位置

3. 直接插入排序：O(n^2)将数组中的所有元素依次跟前面已经排好的元素相比较，如果选择的元素比已排序的元素小，则交换，直到全部元素都比较过为止。

4. 快速排序:适用数据量再300左右

   - 选择一个排头兵:P,从左向右找比P大的数,从又到左找比P小的数
   - 找到left和right的位置(直到left >= right)，swap两者 
   - swap排头兵和left和right碰面的位置(left) 
   - 分而治之,递归查找左右两个partion

   优化思路: 1.标兵采用随机数;2.小范围用直接插入排序

### 网络编程

#### 常见的网络分层

OSI 七层，TCP/IP协议族 五层，

1. 应用层 （HTTP、FTP、DNS、SMTP 等),此层负责如何包装和解析数据
2. 传运输层有 TCP 和 UDP 两种，分别对应可靠和不可靠的运输。在这一层，一般都是和 Socket 打交道，Socket 是一组封装的编程调用接口，通过它，我们就能操作 TCP、UDP 进行连接的建立等。这一层指定了把数据送到对应的端口号
3.  网络层,这一层IP协议，以及一些路由选择协议等等，所以这一层的指定了数据要传输到哪个IP地址。中间涉及到一些最优线路，路由选择算法等
4. 数据链路层,将IP地址解析为MAC地址,即硬件地址
5. 物理层,真正的传输介质

#### Http报文格式

请求头：**Method Request - URI HTTP - Version CRLF**，例：GET /home/app http/1.1

请求行：key:value

请求体

##### 常见状态码

**2XX 成功**

- 200 OK，表示从客户端发来的请求在服务器端被正确处理
- 204 No content，表示请求成功，但响应报文不含实体的主体部分
- 206 Partial Content，进行范围请求

**3XX 重定向**

- 301 moved permanently，永久性重定向，表示资源已被分配了新的 URL
- 302 found，临时性重定向，表示资源临时被分配了新的 URL
- 303 see other，表示资源存在着另一个 URL，应使用 GET 方法丁香获取资源
- 304 not modified，表示服务器允许访问资源，但因发生请求未满足条件的情况
- 307 temporary redirect，临时重定向，和 302 含义相同

**4XX 客户端错误**

- 400 bad request，请求报文存在语法错误
- 401 unauthorized，表示发送的请求需要有通过 HTTP 认证的认证信息
- 403 forbidden，表示对请求资源的访问被服务器拒绝
- 404 not found，表示在服务器上没有找到请求的资源

**5XX 服务器错误**

- 500 internal sever error，表示服务器端在执行请求时发生了错误
- 503 service unavailable，表明服务器暂时处于超负载或正在停机维护，无法处理请求

#### Https

##### Http存在的缺陷

无法保证数据传输安全,数据可能会被劫持、篡改等

##### Https是什么？

简而言之，Https = http+SSL/TLS，在应用层与传输层之间增加一层安全认证操作

##### 中间人攻击

Https可以防范中间人攻击

##### 数字证书

数字证书包括个人信息、摘要信息（不可逆）、证书链、签名哈希算法（如sha256等）等

##### Https的验证流程

![Https验证流程](C:\Users\zeng2.li\Desktop\work\学习\Https验证流程.png)

##### Android网络安全配置

Android 9.0以后默认不允许cleartext传输，webView也不例外，**另配置network**[官方网络安全配置指南](https://developer.android.com/training/articles/security-config?hl=zh-cn) 

### Java

##### Java基础

##### 异常处理

- Exception、Error 是 Throwable 类的子类
- Error 类对象由 Java 虚拟机生成并抛出，不可捕捉

##### 集合框架

1. HashMap 
2. ArrayList
3. LinkedList
4. ConcurrentHashMap

##### Java线程与并发

###### 线程生命周期

###### 线程池

###### volatile、synchronized

###### Lock

1. ReentrantLock锁大概流程，自旋+park+队列（链表）

###### 动态代理

##### JVM

[参考1](https://nicelyjust.github.io/2018/09/03/%E5%86%85%E5%AD%98%E7%AE%A1%E7%90%86/#more)

[参考2](https://github.com/BlackZhangJX/Android-Notes/blob/master/Docs/Java%E7%9F%A5%E8%AF%86%E7%82%B9%E6%B1%87%E6%80%BB.md#%E7%B1%BB%E5%8A%A0%E8%BD%BD%E5%99%A8)

###### 内存分配

- [x] 虚拟机栈：栈帧，虚拟变量表：基本数据类型、对象引用地址、returnAddress
- [x] Java Heap：所有对象及数组，又分为新生代、老年代空间
- [x] 程序计数器：字节码解释器通过改变这个计数器的值来选取下一条需要执行的字节码指令,分支、循环、跳转、异常处理、线程恢复等，简而言之，这哥们就是负责字节码执行的顺序的。BTW，多线程的实现是通过线程轮流切换并分配时间片的方式来实现的，为了保证线程切换后恢复到正确的执行位置，每条线程都需要有一个独立的程序计数器，我们称这类内存区域为”线程私有”的内存。
- [x] 方法区：已被加载的类信息、常量、静态常量等
- [x] 本地方法栈：native方法相关

###### 类加载器

类加载器有哪几种？

- BootstrapClassLoader
- ExtClassLoader
- AppClassLoader

###### 垃圾回收机制 

1. 对象存活判断：GC root：虚拟机栈（本地变量表）中的栈帧、方法区中类静态属性引用对象、方法区中常量引用的对象、JNI引用对象
2. 垃圾收集算法
   - 标记-清除
   - 复制算法
   - 标记-整理
   - 分代收集算法

###### 垃圾收集器

Hotspot VM将内存划分为不同的物理区，就是“分代”思想的体现。如图所示，JVM内存主要由新生代、老年代、永久代构成

Minor、Major、Full GC

1. GMS收集器
2. G1收集器

###### 类实例化过程

1. 检查常量池是否有加载类信息，否则先执行类加载过程
2. 为即将创建的对象分配内存
3. 线程安全如何保证？
4. 接下来，虚拟机要对对象进行必要的设置，例如这个对象是哪个类的实例、如何才能找到类的元数据信息、对象的哈希码、对象的GC分代年龄等信息，这些都存在于对象头中。
5. 进行＜init＞后，对象字段才初始化

### Android

##### Android基础

###### Activity的启动流程

当从laucher点击icon启动一个应用,经过一系列方法调用，通过IPC，转移到AMS中处理，AMS会先判断该进程是否存在(**IApplicationThread**是否为null)，不存在则会先创建（LocalService的startProcess方法调用了AMS的startProcessLocked方法），通知Zygote孵化进程，最后通过反射获取到了ActivityThread类并执行了main方法，执行attach方法（IPC到AMS），创建绑定Application（IPC操作）

![Activity启动流程](C:\Users\zeng2.li\Desktop\work\学习\Activity启动流程.png)

###### Android系统的启动流程



###### APK编译打包流程

1. aapt打包资源文件生成R文件、arsc资源文件；

​     2.处理AIDL，生成对应的Java接口文件；

3. 编译（compiler）生成.class文件

4. dex阶段, 通过dx工具生成.dex文件

5. apkBuilder阶段,生成未签名的apk文件

   **注:** res/raw和assets的不同点：
    1.res/raw中的文件会被映射到R.java文件中，访问的时候直接使用资源ID即R.id.filename；assets文件夹下的文件不会被映射到R.java中，访问的时候需要AssetManager类。
    2.res/raw不可以有目录结构，而assets则可以有目录结构，也就是assets目录下可以再建立文件夹

![APK编译流程](C:\Users\zeng2.li\Desktop\work\学习\APK编译流程.png)

6. Jarsigner/Apksigner,apksigner 是google 推出的V2签名方式Jarsigner 是之前一直使用的V1签名方式
7. zipalign（对齐），是一个android平台上整理APK文件的工具，它对apk中未压缩的数据进行4字节对齐对齐后就可以使用mmap函数读取文件，可以像读取内存一样对普通文件进行操作。如果没有4字节对齐，就必须显式的读取，这样比较缓慢并且会耗费额外的内存。**如果是Jarsigner，对齐则为最后一个步骤，若是Apksigner，则签名是最后一步**；

###### APK的安装流程

前置知识：虚拟机dalvik（5.0之前用，不包括5.0）、ART

编译模式：JIT 是在运行时进行编译，是动态编译，并且每次运行程序的时候都需要对 odex 重新进行编译；而 AOT 是静态编译，应用在安装的时候会启动 dex2oat 过程把 dex 预编译成 [ELF 文件](https://link.juejin.cn?target=https%3A%2F%2Fzh.wikipedia.org%2Fwiki%2F%E5%8F%AF%E5%9F%B7%E8%A1%8C%E8%88%87%E5%8F%AF%E9%8F%88%E6%8E%A5%E6%A0%BC%E5%BC%8F)，每次运行程序的时候不用重新编译，是真正意义上的本地应用。

Android 5.0 ART（Ahead-of-time），

Android 7.0  JIT回归

1. 应用在安装的时候 dex 不会被编译

2. 应用在运行时 dex 文件先通过解析器（Interpreter）后会被直接执行（这一步骤跟 Android 2.2 - Android 4.4之前的行为一致），与此同时，热点函数（Hot Code）会被识别并被 JIT 编译后存储在 jit code cache 中并生成 profile 文件以记录热点函数的信息。

3. 手机进入 IDLE（空闲） 或者 Charging（充电） 状态的时候，系统会扫描 App 目录下的 profile 文件并执行 AOT 过程进行编译。

涉及三个进程:

- PackageInstaller进程：PackageInstaller事实上是一个应用，它负责APK安装以及卸载过程中与用户的交互流程。
- SystemServer进程：该进程主要运行的是系统服务，APK的安装、卸载和查询都由PackageManagerService负责，它也是Android核心系统服务的一种，在SystemServer里初始化系统服务的时候被启动。
- DefaultContainerService进程：DefaultContainerService也是一个单独的进程，它主要负责检查和复制设备上的文件，APK的复制就是由DefaultContainerService来完成的。

具体步骤:

1. 拷贝APK到/data/app目录下,解压并扫描安装包;
2. 资源管理器解析APK里的资源文件;
3. 解析manifest文件,并在/data/data/目录下创建对应的应用数据目录;
4. DEX的dexopt流程，对dex文件进行优化，Dalvik：将dex文件优化生成odex文件（.dex），保存在dalvik-cache目录下，ART：将dex文件翻译成oat文件;
5. 将清单文件中解析出来的四大组件信息注册到PackageManagerService中;
6. 安装完成后,发送广播;

###### View的渲染流程

WindowManagerService、Window及view关系？



###### 事件传递机制

整体流程：Activity.dispatchTouchEvent -> PhoneWindow.superDispatchTouchEvent -> DecorView.superDispatchTouchEvent(FrameLayout) -> ViewGroup.dispatchTouchEvent  -> ViewGroup.onInterceptTouchEvent -> View.onTouchEvent

down事件流程：（确定事件给谁）判断disallowIntercept标志位,判断是否拦截：1.拦截的话 mFirstTouchTarget为null，直接进入dispatchTransformedTouchEvent()

```java
 // Dispatch to touch targets.
 if (mFirstTouchTarget == null) {
     // No touch targets so treat this as an ordinary view.
     handled = dispatchTransformedTouchEvent(ev, canceled, null,TouchTarget.ALL_POINTER_IDS);
 }
```

```java
private boolean dispatchTransformedTouchEvent(MotionEvent event, boolean cancel,
            View child, int desiredPointerIdBits) {
	// Perform any necessary transformations and dispatch. child为空
	if (child == null) {
        // 直接调父类的dispatchTouchEvent方法，即为View.dispatchTouchEvent即处理事件
    	handled = super.dispatchTouchEvent(transformedEvent);
	} else {
    	final float offsetX = mScrollX - child.mLeft;
    	final float offsetY = mScrollY - child.mTop;
    	transformedEvent.offsetLocation(offsetX, offsetY);
    	if (! child.hasIdentityMatrix()) {
        	transformedEvent.transform(child.getInverseMatrix());
    	}
		/** 这里递归了**/
    	handled = child.dispatchTouchEvent(transformedEvent);
	}
}
```

2：不拦截的话，按照Z轴对子view进行排序，接着遍历子View进行事件派发

```java
final int childrenCount = mChildrenCount;
if (newTouchTarget == null && childrenCount != 0) {
    final float x = ev.getX(actionIndex);
    final float y = ev.getY(actionIndex);
    // Find a child that can receive the event.
    // Scan children from front to back.
    /** 按照Z轴对子view进行排序**/
    final ArrayList<View> preorderedList = buildTouchDispatchChildList();
    final boolean customOrder = preorderedList == null
            && isChildrenDrawingOrderEnabled();
    final View[] children = mChildren;
    
    for (int i = childrenCount - 1; i >= 0; i--) {
        final int childIndex = getAndVerifyPreorderedIndex(
                childrenCount, i, customOrder);
        final View child = getAndVerifyPreorderedView(
                preorderedList, children, childIndex);

       /** 判断是否点击位置是否在子view区域内**/

        if (!child.canReceivePointerEvents()
                || !isTransformedTouchPointInView(x, y, child, null)) {
            ev.setTargetAccessibilityFocus(false);
            continue;
        }

        newTouchTarget = getTouchTarget(child);
        if (newTouchTarget != null) {
            // Child is already receiving touch within its bounds.
            // Give it the new pointer in addition to the ones it is handling.
            newTouchTarget.pointerIdBits |= idBitsToAssign;
            break;
        }

        resetCancelNextUpFlag(child);
        /** 执行子View事件派发**/
        if (dispatchTransformedTouchEvent(ev, false, child, idBitsToAssign)) {
            // Child wants to receive touch within its bounds.
            mLastTouchDownTime = ev.getDownTime();
            if (preorderedList != null) {
                // childIndex points into presorted list, find original index
                for (int j = 0; j < childrenCount; j++) {
                    if (children[childIndex] == mChildren[j]) {
                        mLastTouchDownIndex = j;
                        break;
                    }
                }
            } else {
                mLastTouchDownIndex = childIndex;
            }
            mLastTouchDownX = ev.getX();
            mLastTouchDownY = ev.getY();
            newTouchTarget = addTouchTarget(child, idBitsToAssign);
            alreadyDispatchedToNewTouchTarget = true;
            break;
        }

        // The accessibility focus didn't handle the event, so clear
        // the flag and do a normal dispatch to all children.
        ev.setTargetAccessibilityFocus(false);
    }
    if (preorderedList != null) preorderedList.clear();
}
```

move事件流程（move事件会多次执行）: mFirstTouchTarget不为空，判断是否拦截：

```java
if (actionMasked == MotionEvent.ACTION_DOWN
        || mFirstTouchTarget != null) {
    final boolean disallowIntercept = (mGroupFlags & FLAG_DISALLOW_INTERCEPT) != 0;
    if (!disallowIntercept) {
        intercepted = onInterceptTouchEvent(ev);
        ev.setAction(action); // restore action in case it was changed
    } else {
        intercepted = false;
    }
} else {
    // There are no touch targets and this action is not an initial down
    // so this view group continues to intercept touches.
    intercepted = true;
}
```

拦截的话：

取消子View 处理事件（cancel事件），下一个move事件过来直接自己处理

```Java
cancelChild = true
```

问题：界面有个button，手指放上去慢慢移到Button外的区域，描述下事件分发流程？

ViewGroup.dispatchTouchEvent-> 不拦截继续 -> 判断down事件,button消费down事件,mFirstTouchTarget赋值->继续移动move事件,此时mFirstTouchTarget不为空,执行dispatchTransformedTouchEvent->button.dispatchTouchEvent,view.onTouchEvent,move事件会判断区域是否还在自身,不在自身会重置标志位,继而up事件中不会执行点击事件

##### AAC库原理

###### LifeCycle



###### LiveData

###### ViewModel

##### Android性能优化

###### 启动优化

理解启动过程可以优化的空间？黑白屏怎么来的？

###### UI渲染优化

CPU负责包括Measure，Layout等计算操作，GPU负责Rasterization(栅格化)操作(所谓栅格化就是将矢量图形转换为位图的过程，手机上显示是按照一个个像素来显示的，栅格化再普通一些的说法就是将一个Button,TextView等组件拆分到一个个像素上去显示)。UI渲染优化的目的就是减轻CPU,GPU的压力，除去不必要的操作，保证每帧16ms以内处理完所有的CPU与GPU的计算，绘制，渲染等等操作，使UI顺滑，流畅的展示出来。

	1. 查找overdraw，蓝色，淡绿，淡红，深红代表了4种不同程度的Overdraw情况，1x,2x,3x,4x分别表示同一像素上同一帧的时间内被绘制了多次，1x就表示一次(最理想情况)，4x表示4次(最差的情况)，我们要做的就是尽量减少3x,4x的情况出现。
	2. 嵌套布局优化，嵌套层次不宜太深影响渲染效率
	3. ViewStub、include+merge等

###### 卡顿优化

原理：卡顿根本原因就是主线程有其它耗时操作，导致没有在16ms内及时刷新；Choreographer 的doFrame 方法耗时，绘制太久，下一个 vsync 信号来的时候这一帧还没画完，造成掉帧。

方案：基于Looper的loop方法中Printer分发消息的时间差值来判断是否卡顿；基于 Choreographer 回调函数 postFrameCallback 来监控

###### 内存优化及泄露

内存优化好处？减少OOM，提高程序稳定性；减少卡顿，提高应用流畅度；减少内存占用，提高应用后台存活率；

如何做？1. 监测内存泄漏，再介绍内存泄漏常见场景；2.避免内存抖动短时间内频繁的内存分配和释放，比如view.onDraw等频繁调用的地方,使用对象池；3.减少内存占用: 避免使用装箱类型、使用最优的数据类型、字符串避免直接“+”拼接、根据图片大小进行采样压缩等;4：减少enum类（仅仅是个单值的情况，考虑用注解取代）

###### ANR问题如何定位

1. ANR问题如何产生的？前台服务20s，后台服务是前台服务10倍，200s；BroadcastQueue Timeout：比如前台广播在10s内未执行完成，后台60s；ContentProvider Timeout：内容提供者,在publish过超时10s;InputDispatching Timeout： 输入事件分发超时5s，包括按键和触摸事件；
2. ANR分析方法 **/data/anr/traces.txt** 文件：先查看main线程处于 BLOCK、WAITING、TIMEWAITING（cpp的线程状态）状态，那基本上是函数阻塞导致ANR，如果main线程无异常，则应该排查CPU负载和内存环境。

##### Android组件化

### 开源框架

##### OKHttp

##### Retrofit

##### Glide

##### LeakCanary

### Kotlin

### 项目问题

#### 难题、BUG相关

1. 遇到难定位的线上BUG怎么处理？

   分析堆栈，确认重点；查找共性，如机型、系统、厂商、ABI等；

2. 遇到一个印象深刻的BUG？你如何怎么解决的？

3. 最有成就感的一件事是什么？

