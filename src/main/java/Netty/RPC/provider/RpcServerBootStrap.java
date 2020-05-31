package Netty.RPC.provider;

import Netty.RPC.netty.RpcNettyServer;

/**
 * @author Yu
 */
public class RpcServerBootStrap {
    public static void main(String[] args) throws Exception {
        RpcNettyServer.startServer("127.0.0.1", 7000);
    }
}
