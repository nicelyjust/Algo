package tree;

import java.util.Comparator;

/**
 * @Desc
 * @Author lizeng
 * @CreateTime 2019/9/9 16:41
 **/
public interface Tree<T extends Comparable> {
    /**
     *  判空
     * @return
     */
    boolean isEmpty();

    /**
     * 结点个数
     * @return
     */
    int size();


}
