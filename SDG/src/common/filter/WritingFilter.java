package common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet Filter implementation class WritingFilter
 */
@WebFilter(
		urlPatterns = {
		"/board/boardUpdateEnd"})
public class WritingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public WritingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
		String reqMemberId = httpRequest.getParameter("memberId");
	
		
	String ignoreCheck = MemberService.IgnoreCheckselectOne(reqMemberId);
	boolean l = false;
	
	if(ignoreCheck!=null){
		l=true;
	}
		
		
		
		if(l) {
			request.setAttribute("msg", "글쓰기벤 당하셨습니다 사유="+ignoreCheck);
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
					.forward(httpRequest, response);
			return;
		}
		// pass the request along the filter chain

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
