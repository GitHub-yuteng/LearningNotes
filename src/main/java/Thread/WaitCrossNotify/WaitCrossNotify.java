package Thread.WaitCrossNotify;

/**
 * @author Yu
 */
public class WaitCrossNotify {

    public static void main(String[] args) {
        DBTools dbTools = new DBTools();
        for (int i = 0; i < 10; i++) {
            BackUpB backUpB = new BackUpB(dbTools);
            backUpB.start();

            BackUpA backUpA = new BackUpA(dbTools);
            backUpA.start();
        }
    }
}
