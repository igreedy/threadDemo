/**
 * @Auther: wuyandong
 * @Date: 2018/6/26 19:38
 * @Description:
 */
public class VolatileDemo {

    private volatile int number = 0;

    public int getNumber() {
        return this.number;
    }

    public void increase() {
        this.number++;
    }

    public static void main(String[] args) {
        final VolatileDemo volDemo = new VolatileDemo();
        for (int i = 0; i < 500; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    volDemo.increase();
                }
            }).start();
        }
        // 如果还有子线程在运行，主线程就让出CPU资源，
        // 知道所有的子线程都运行完了,主线程再继续往下执行
        while (Thread.activeCount() > 1) {
//            System.out.println(Thread.activeCount());
            Thread.yield();
        }
        System.out.println("number:" + volDemo.getNumber());
    }
}
