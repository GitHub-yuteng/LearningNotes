package Netty.RPC.consumer;

import Netty.RPC.PublicInterface;
import Netty.RPC.netty.RpcNettyClient;

/**
 * @author Yu
 */
public class RpcClientBootStrap {

    public static final String protocolName = "rpc#";

    public static void main(String[] args) throws Exception {
        RpcNettyClient consumer = new RpcNettyClient();
        PublicInterface service = (PublicInterface) consumer.getBean(PublicInterface.class, protocolName);
        while (true) {
            Thread.sleep(5 * 1000);
            String result = service.rpc("你开心吗?");
            System.out.println("服务端: " + result + "\n");
        }
    }
}
