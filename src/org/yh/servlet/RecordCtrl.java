package org.yh.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.yh.servlet.dao.QueryResult;
import org.yh.servlet.dao.record.impl.RecordServiceImpl;
import org.yh.servlet.entity.CartItem;
import org.yh.servlet.entity.RecordInfo;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/RecordCtrl")
public class RecordCtrl extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecordCtrl()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");

		RecordServiceImpl service = new RecordServiceImpl();
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		if ("list".equalsIgnoreCase(type))
		{
			QueryResult<RecordInfo> qr = service.getScrollData();
			request.setAttribute("list", qr.getResultlist());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else if ("buy".equalsIgnoreCase(type))
		{
			// 获取购物车
			@SuppressWarnings("unchecked")
			Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");
			if (cart == null)
			{ // 如果没有购物车，实例一个
				cart = new HashMap<String, CartItem>();
			}
			// 从购物车查看当前id的商品
			CartItem cartItem = (CartItem) cart.get(id);
			if (null == cartItem)
			{ // 如果没有
				RecordInfo recordInfo = service.find(id);
				cart.put(id, new CartItem(recordInfo, 1, recordInfo.getPrice()));// 将商品加入购物车，数量为1
			} else
			{ // 如果存在
				cartItem.setCount(cartItem.getCount() + 1); // 数量在原基础上+1
			}
			session.setAttribute("cart", cart);
			response.sendRedirect("cartlist.jsp");
		} else if ("removeCart".equalsIgnoreCase(type))
		{
			// 获取购物车
			Map<?,?> cart = (Map<?,?>) session.getAttribute("cart");
			cart.remove(id);
			response.sendRedirect("cartlist.jsp");
		} else if ("updataCount".equalsIgnoreCase(type))
		{
			int count = Integer.parseInt(request.getParameter("count"));
			// 获取购物车
			Map<?,?> cart = (Map<?,?>) session.getAttribute("cart");
			// 从购物车查看当前id的商品
			if (count <= 0)
			{
				cart.remove(id);
			} else
			{
				CartItem cartItem = (CartItem) cart.get(id);
				if (cartItem != null)
				{
					cartItem.setCount(count);
				}
			}
			response.sendRedirect("cartlist.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
