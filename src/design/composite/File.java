package design.composite;

import java.util.List;

/**
 * @Desc
 * @Author lizeng
 * @CreateTime 2019/11/19 15:02
 **/
public class File extends Dir{
    public File(String name) {
        super(name);
    }

    @Override
    public void addDir(Dir dir) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void rmDir(Dir dir) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void print() {
        System.out.println(getName());
    }

    @Override
    public List<Dir> getFiles() {
        throw new UnsupportedOperationException();
    }
}
