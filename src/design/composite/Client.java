package design.composite;

/**
 * @Desc
 * @Author lizeng
 * @CreateTime 2019/11/19 18:09
 **/
public class Client {
    public static void main(String[] args) {
        Dir folder = new Folder("C");
        folder.addDir(new File("log.txt"));
        folder.addDir(new File("hello.java"));
        Dir dirWin = new Folder("windows");
        folder.addDir(dirWin);
        dirWin.addDir(new File("windows.exe"));
        folder.print();

    }
}
