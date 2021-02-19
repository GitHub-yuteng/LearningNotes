package Review_Java.OOP.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: YT
 * @Date: 2021/02/19/19:48
 * @Description: 过滤器使用 demo
 */
public class Application {

    // filters.add(new AuthencationFilter());
    // filters.add(new RateLimitFilter());
    private List<Filter> filters = new ArrayList<>();

    public void handleRpcRequest(RpcRequest req) {

        try {
            for (Filter filter : filters) {
                filter.doFilter(req);
            }
        } catch (RpcException e) {
            // ... 处理过滤结果...
        }
        // ... 省略其他处理逻辑...
    }
}
