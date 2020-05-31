package Netty.RPC.provider;

import Netty.RPC.PublicInterface;

public class RpcProvider implements PublicInterface {

    private static int count = 0;

    @Override
    public String rpc(String msg) {
        String happy = "不开心 ";
        System.out.println(happy + (count++));
        return happy;
    }
}