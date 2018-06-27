package story;

/**
 * @Auther: wuyandong
 * @Date: 2018/6/26 20:51
 * @Description: 关键先生
 */
public class KeyPersonThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始了战斗");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "左突右杀");
        }
        System.out.println(Thread.currentThread().getName() + "结束了战斗");

    }
}
