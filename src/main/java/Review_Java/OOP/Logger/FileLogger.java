package Review_Java.OOP.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;

/**
 * @Auther: YT
 * @Date: 2021/02/19/19:38
 * @Description:
 */
public class FileLogger extends Logger {
    private Writer fileWriter;

    public FileLogger(String name, boolean enabled, Level minPermittedLevel, String filepath) throws IOException {
        super(name, enabled, minPermittedLevel);
        this.fileWriter = new FileWriter(filepath);
    }

    @Override
    protected void doLog(Level level, String message) {
        // 格式化 level 和 message, 输出到日志文件
        // fileWriter.write(...);
    }
}
