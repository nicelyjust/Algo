package design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 组合模式
 * @Author lizeng
 * @CreateTime 2019/11/19 14:34
 **/
public abstract class Dir {
    protected List<Dir> dirs = new ArrayList<>();
    // 当前文件或者文件夹名字
    private String name;
    public Dir(String name) {
        this.name= name;
    }

    /**
     * 添加一个文件或者文件夹
     * @param dir 文件或者文件夹
     */
    public abstract void addDir(Dir dir);

    /**
     * 移除一个文件或者文件夹
     * @param dir 文件或者文件夹
     */
    public abstract void rmDir(Dir dir);

    /**
     * 打印出文件层级
     */
    public abstract void print();

    /**
     * 获取文件夹下所有的文件或者文件夹
     * @return 文件夹下所有的文件或者文件夹
     */
    public abstract List<Dir> getFiles();

    public String getName(){
        return this.name;
    }
}
