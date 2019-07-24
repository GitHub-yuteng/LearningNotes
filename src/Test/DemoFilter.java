//package Test;
//
//import java.io.IOException;
//
//public class DemoFilter implements Filter {
//
//	private int hitCount;
//
//	public void init(FilterConfig config) throws ServletException {
//		hitCount = 0;
//
//	}
//
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		hitCount++;
//
//		HttpServletRequest req = (HttpServletRequest) request;
//
//		String user = (String) req.getSession().getAttribute("USER_ID");
//
//		System.out.println(user + "�����ˣ�" + hitCount + "��");
//		chain.doFilter(request, response);
//	}
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//
//	}
//
//}
