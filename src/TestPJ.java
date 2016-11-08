import java.io.*;

/**
 * Created by lifengshuang on 08/11/2016.
 */
public class TestPJ {

    /**
     * 运行方法:
     * 1. 修改所有路径变量为你的路径。
     * 2. 设置输入文件和输出文件的路径,编辑输入文件。
     * 3. 运行程序,查看输出。
     *
     * 输入文件:
     *     输入文件中的数据就是运行pj时你会输入的内容,例子见 input 目录下的 sample_input.txt。
     *     同学们可以添加更多输入,来对pj的一些功能点进行测试。
     *
     * 输出文件:
     *     输出文件的数据是pj根据输入文件运行后输出的所有数据。
     *     如 output 目录下 sample_output.txt 的输出对应 sample_input.txt 。
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
        //路径要以\\结尾
        String path = "C:\\Users\\lifengshuang\\Desktop\\Jungle\\";

        //classpath是IntelliJ在你pj编译完后生成的.class文件的文件夹。一般在工程目录的out目录的production目录下
        //路径要以\\结尾
        String classpath = "C:\\Users\\lifengshuang\\Desktop\\Jungle\\out\\production\\Jungle\\";

        //mainClass是包含main方法入口的.class文件的文件名(不包含.class后缀)。
        String mainClass = "Jungle";

        //testPath是这个测试程序的工程的所在目录。
        //路径要以\\结尾
        String testPath = "C:\\Users\\lifengshuang\\Desktop\\ProjectTester\\";

        //上面的变量在第一次调通后一般就不需要再改了
        //下面的变量根据测试输入文件、输出文件而改变

        //inputFilePath是输入文件相对与工程目录的路径
        String inputFilePath = "input\\sample_input.txt";

        //outputFilePath是输出文件相对与工程目录的路径
        String outputFilePath = "output\\sample_output.txt";

        //接下去是正式执行的代码
        //只有7行,同学们可以尝试理解、学习一下。
        ProcessBuilder builder = new ProcessBuilder("java", "-Dfile.encoding=UTF-8", "-classpath", classpath, mainClass);
        builder.directory(new File(path));
        builder.redirectInput(new File(testPath + inputFilePath));
        builder.redirectOutput(new File(testPath + outputFilePath));
        builder.redirectErrorStream(true);
        builder.start();
        System.out.println("测试程序执行完毕,请在" + outputFilePath + "中查看运行结果");
    }
}