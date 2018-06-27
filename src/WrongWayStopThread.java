/**
 * @Auther: wuyandong
 * @Date: 2018/6/27 09:50
 * @Description:
 */
public class WrongWayStopThread extends Thread {
    @Override
    public void run() {
//        while (true) {
        while (!this.isInterrupted()) {
            System.out.println("Thread is running...");
            // 下面代码的效果就是等1秒钟。但是为啥不用sleep睡眠1秒呢。
            long time = System.currentTimeMillis();
            while ((System.currentTimeMillis() - time < 1000)) {
                //减少屏幕输出的空循环
            }
        }
    }
    // 测试
    public static void main(String[] args) {
        WrongWayStopThread thread = new WrongWayStopThread();
        System.out.println("Starting thread...");
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Interrupting thread...");
        // 中断线程，然而执行程序，你会发现线程仍然在运行中
        // 所以interrupt方法 并没有将我们的线程停下来。
        // 除非将run方法中while的true改为 !this.isInterrupted() 来作为运行标识。
        // 这个就能正确的停止线程
        thread.interrupt();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping application...");
    }
}
