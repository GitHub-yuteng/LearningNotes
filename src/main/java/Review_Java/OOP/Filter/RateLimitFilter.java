package Review_Java.OOP.Filter;

/**
 * @Auther: YT
 * @Date: 2021/02/19/19:47
 * @Description: 接口实现类：限流过滤器
 */
public class RateLimitFilter implements Filter {


    @Override
    public void doFilter(RpcRequest req) throws RpcException {
        //... 限流逻辑...
    }
}
