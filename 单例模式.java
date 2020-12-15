// 单例模式
// 这里只贴代码
// 详见以下两个高质量参考文献

// https://blog.csdn.net/yeyazhishang/article/details/90445330
// https://www.runoob.com/design-pattern/singleton-pattern.html

// 1. 懒汉式 线程不安全
// 是否 Lazy 初始化：是
// 是否多线程安全：否
// 实现难度：易

public class Singleton {
    private static Singleton instance;
    private Singleton() {}

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}


// 2. 懒汉式 线程安全
// 是否 Lazy 初始化：是
// 是否多线程安全：是
// 实现难度：易

public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static synchronized Singleton getInstance() {
        if(instance == null) {
            isntance = new Singleton();
        }
        return instance;
    }
}

// 3. 饿汉式
// 是否 Lazy 初始化：否
// 是否多线程安全：是
// 实现难度：易

public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return instance;
    }
}

// 4. 双重检验锁 (推荐)
// JDK 版本：JDK1.5 起
// 是否 Lazy 初始化：是
// 是否多线程安全：是
// 实现难度：较复杂

public class Singleton {
    private volatile static Singleton instance; 
    private Singleton() {}
    public static Singleton getInstance() {
        if(instance == null) {
            synchronized(Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

// 5. 静态内部类/登记式 （推荐）
// 是否 Lazy 初始化：是
// 是否多线程安全：是
// 实现难度：一般

public class Singleton {
    private static class SingletonHolder() {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {}
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

// 6. 枚举
// JDK 版本：JDK1.5 起
// 是否 Lazy 初始化：否
// 是否多线程安全：是
// 实现难度：易

public enum Singleton {
    INSTANCE;
}