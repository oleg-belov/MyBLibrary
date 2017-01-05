package md.blibrary.app.filters;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import md.blibrary.app.dao.CaregoryMenuDAO;
import md.blibrary.app.dao.exceptions.NoSuchEntityException;
import md.blibrary.app.dao.exceptions.SystemException;
import md.blibrary.app.dao.impl.CategoryMenuDAOImpl;

public class CaregoryMenuFilter implements Filter {
	private static final int PAGE_NOT_FOUND_ERROR = 404;
	private static final int PAGE_GONE_ERROR = 410;
	
    public CaregoryMenuFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		CaregoryMenuDAO<Integer, String> categoryMenuDao = new CategoryMenuDAOImpl();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		try {
			Map<Integer, String> categoryMap = categoryMenuDao.selectAll();
			httpRequest.setAttribute("bookCaregoryMap", categoryMap);
			
			if( httpRequest.getParameter("category_id") != null) {
				httpRequest.setAttribute("title", 
						categoryMap.get(Integer.parseInt(httpRequest.getParameter("category_id"))));
			}
			chain.doFilter(httpRequest, httpResponse);
			
		} catch (NoSuchEntityException | NumberFormatException e) {
			httpResponse.sendError(PAGE_NOT_FOUND_ERROR);
		} catch (SystemException e) {
			httpResponse.sendError(PAGE_GONE_ERROR);
		}	
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
