import java.io.*;

/**
 * Created by lifengshuang on 08/11/2016.
 */
public class TestPJ {

    /**
     * 运行方法:
     * 1. 修改所有路径变量为你的路径。
     * 2. 运行程序,对比output文件夹和reference文件夹下的文件。
     *
     * 输入文件:
     *     输入文件中的数据就是运行pj时你会输入的内容。input文件夹下的10个文件为pj各功能点的测试。
     *     同学们可以添加更多输入,来对pj的一些功能点进行测试。
     *
     * 输出文件:
     *     输出文件的数据是pj根据输入文件运行后输出的所有数据。
     *     注:输入文件中的每个输入不会出现在输出文件中,可以通过手动修改代码,输出每次的输入的指令来解决
     *          即: 在 String input = scanner.nextLine(); 之后,
     *              添加 System.out.print(input);
     *
     * 注: 每次你修改pj代码后,需要重新编译一次pj。
     *     编译pj可以通过跑一遍pj或者运行菜单栏 Build - Make Project 来完成。
     *     否则测试程序运行的是你之前编译的pj代码。
     */
    public static void main(String[] args) throws IOException {

        //path是你的pj工程的目录,这个目录下一般有src文件夹和XXX.iml文件。
        //路径可以从资源管理器的地址栏复制进来,记得把\改成\\
        String path = "...";

        //classpath是IntelliJ在你pj编译完后生成的.class文件的文件夹。一般在工程目录的out目录的production目录下
        String classpath = "...";

        //mainClass是包含main方法入口的.class文件的文件名(不包含.class后缀)。
        String mainClass = "...";

        //testPath是这个测试程序的工程的所在目录。
        //以\\结尾
        String testPath = "...";

        //现在测试会自动运行input文件夹下的所有txt文件,不需要指定输入输出。
        File inputFolder = new File(testPath + "input");
        File[] listOfFiles = inputFolder.listFiles();

        if (listOfFiles == null) {
            System.out.println(testPath + "input目录下未找到输入文件,请确认路径是否正确!");
            return;
        }

        for (File file : listOfFiles) {
            String name = file.getName();
            if (file.isFile() && name.endsWith(".txt")) {
                ProcessBuilder builder = new ProcessBuilder("java", "-Dfile.encoding=UTF-8", "-classpath", classpath, mainClass);
                builder.directory(new File(path));
                builder.redirectInput(file);
                builder.redirectOutput(new File(testPath + "output" + File.separator + name));
                builder.redirectErrorStream(true);
                builder.start();
                System.out.println(name + "测试完毕,测试结果为output目录下的" + name + "文件,请和reference目录中的样例输出比对");
            }
        }
        System.out.println("\n比对方法: 右键output文件夹,点击\"Compare With...\",然后选择reference文件夹，即可使用IntelliJ的文件比对功能。");



    }


}