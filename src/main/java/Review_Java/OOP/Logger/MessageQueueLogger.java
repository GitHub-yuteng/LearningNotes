package Review_Java.OOP.Logger;

import java.util.logging.Level;

/**
 * @Auther: YT
 * @Date: 2021/02/19/19:40
 * @Description:
 */
public class MessageQueueLogger extends Logger {

    private MessageQueueClient msgQueueClient;

    public MessageQueueLogger(String name, boolean enabled, Level minPermittedLevel,MessageQueueClient msgQueueClient) {
        super(name, enabled, minPermittedLevel);
        this.msgQueueClient = msgQueueClient;
    }

    @Override
    protected void doLog(Level level, String message) {
        // 格式化 level 和 message, 输出到消息中间件
        // msgQueueClient.send(...);
    }
}
