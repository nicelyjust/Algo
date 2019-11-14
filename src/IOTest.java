import java.io.*;

/**
 * @Desc
 * @Author lizeng
 * @CreateTime 2019/11/14 13:47
 **/
public class IOTest {
    public static void main(String[] args) {
        test05();
    }

    private static void test01() {
        try {
            FileWriter writer = new FileWriter(new File("").getAbsolutePath()+"/io/test.txt");
            writer.write("Hello IO! \n欢迎来到Java IO世界\n");
            writer.write("不会覆盖文件原本的内容\n");
            writer.append("并不是追加一行内容，不要被方法名迷惑\n");
            writer.flush();
            System.out.println("文件编码格式为: " + writer.getEncoding());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void test02() {
        try {
            FileWriter writer = new FileWriter(new File("").getAbsolutePath()+"/io/test.txt",false);
            writer.write("Hello IO! \n欢迎来到Java IO世界\n");
            writer.write("我来覆盖文件原本的内容\n");
            writer.append("我是下一行");
            writer.flush();
            System.out.println("文件编码格式为: " + writer.getEncoding());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void test03() {
        try {
            FileReader reader = new FileReader(new File("").getAbsolutePath()+"/io/test.txt");
            int c;
            while ((c=reader.read()) != -1){
                System.out.print((char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void test04() {
        try {
            FileReader reader = new FileReader(new File("").getAbsolutePath()+"/io/test.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line=bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void test05() {
        try {
            FileInputStream in = new FileInputStream("C:\\Users\\lizeng\\Downloads\\ideaIU-2019.2.3.exe");
            FileOutputStream out = new FileOutputStream("copy.exe");
            int len = 0;
            long begin = System.currentTimeMillis();
            while ((len = in.read()) != -1) {
                out.write(len);
            }
            System.out.println("拷贝花费时间: " + (System.currentTimeMillis() - begin));
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void test06() {
        try {
            FileInputStream in = new FileInputStream("C:\\Users\\lizeng\\Downloads\\ideaIU-2019.2.3.exe");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
            FileOutputStream out = new FileOutputStream("copy.exe");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
            //定义一个勺容器
            int len = 0;
            byte[] bs = new byte[1024];
            long begin = System.currentTimeMillis();
            while ((len = bufferedInputStream.read(bs)) != -1) {
                bufferedOutputStream.write(bs,0,len);
            }
            System.out.println("拷贝花费时间: " + (System.currentTimeMillis() - begin));
            bufferedInputStream.close();
            in.close();
            bufferedOutputStream.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
