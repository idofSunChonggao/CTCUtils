import java.util.Scanner;

/**
 * @Author SunChonggao
 * @Date 2021/3/7 17:48
 * @Version 1.0
 * @Description: 卷积与反卷积输出计算
 */
public class ConvCalculator {
    public static void main(String[] args) {
        int type, input, kernel_size, padding, stride;
        System.out.println("  _    _                        \n" +
                " | |  | |                       \n" +
                " | |__| | __ _ _ __ _   _ _ __  \n" +
                " |  __  |/ _` | '__| | | | '_ \\ \n" +
                " | |  | | (_| | |  | |_| | | | |\n" +
                " |_|  |_|\\__,_|_|   \\__,_|_| |_|\n");
        System.out.println("Convolution Calculator");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择网络类型：[1]卷积 [2]反卷积");
        type = scanner.nextInt();
        do {
            double output = 0;
            do {
                if (output == 0) { // 第一层 输入input大小
                    System.out.print("input：");
                    input = scanner.nextInt();
                } else // 非第一层 上一层的输出作为本层的输入
                    input = (int) output;
                System.out.print("kernel_size：");
                kernel_size = scanner.nextInt();
                System.out.print("stride：");
                stride = scanner.nextInt();
                System.out.print("padding：");
                padding = scanner.nextInt();
                switch (type) {
                    case 1:
                        output = Math.floor((input + 2 * padding - kernel_size) / stride + 1);
                        break;
                    case 2:
                        output = (input - 1) * stride - 2 * padding + kernel_size;
                        break;
                    default:
                        System.out.println("输入错误！");
                }
                System.out.println("输出:" + (int)output);
                System.out.println("是否计算下一层? y / n");
            }
            while(scanner.next().equals("y"));
            System.out.println("请选择网络类型：[1]卷积 [2]反卷积 [3]退出");
            type = scanner.nextInt();
        }
        while(type < 3);
    }
}
