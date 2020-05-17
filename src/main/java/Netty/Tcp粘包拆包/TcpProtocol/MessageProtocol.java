package Netty.Tcp粘包拆包.TcpProtocol;

import lombok.Data;

/**
 * @author Yu
 * 协议包
 */
@Data
public class MessageProtocol {

    private int length;//关键
    private byte[] content;
}
