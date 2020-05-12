package Thread.WaitCrossNotify;

/**
 * @author Yu
 */
public class BackUpA extends Thread {

    private DBTools dbTools;

    public BackUpA(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        super.run();
        dbTools.backupA();
    }
}
