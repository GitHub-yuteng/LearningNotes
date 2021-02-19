package Review_Java.OOP.Filter;

/**
 * @Auther: YT
 * @Date: 2021/02/19/19:46
 * @Description: 接口实现类：鉴权过滤器
 */
public class AuthencationFilter implements Filter {

    @Override
    public void doFilter(RpcRequest req) throws RpcException {
        //... 鉴权逻辑..
    }
}
