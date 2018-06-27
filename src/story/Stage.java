package story;

/**
 * @Auther: wuyandong
 * @Date: 2018/6/26 20:40
 * @Description:
 */
public class Stage extends Thread {

    @Override
    public void run() {
        ArmyRunnable armyDynasty = new ArmyRunnable();
        ArmyRunnable armyRevolt = new ArmyRunnable();

        // 使用Runnable 接口创建线程
        Thread dynasty = new Thread(armyDynasty, "军队");
        Thread revolt = new Thread(armyRevolt, "农民");
        dynasty.start();
        revolt.start();

        //让他运行，不打扰。
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("半路杀入程咬金");
        KeyPersonThread mrCheng = new KeyPersonThread();
        mrCheng.setName("程咬金");


        //停止作战
        armyDynasty.keepRunning = false;
        armyRevolt.keepRunning = false;

        //让他运行，不打扰。
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mrCheng.start();
        //等待mrCheng 完成任务，在执行后面的语句
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("哈哈");
    }

    public static void main(String[] args) {

        new Stage().start();
    }
}
