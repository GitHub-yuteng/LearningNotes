package Test;

//import java.io.IOException;
//
///**
// * Servlet implementation class DemoServlet
// */
//public class DemoServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		// ��ȡ����
//		String username = request.getParameter("USER_ID");
//
//		// ��ȡ session ����
//		HttpSession session = request.getSession();
//		// ��������
//		session.setAttribute("USER_ID", username);
//		// ��ӡ SessionID
//		System.out.println(session.getId());
//	}
//
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//}
