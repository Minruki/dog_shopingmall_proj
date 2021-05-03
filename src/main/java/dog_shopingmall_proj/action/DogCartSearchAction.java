package dog_shopingmall_proj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog_shopingmall_proj.dto.Cart;
import dog_shopingmall_proj.service.DogCartSearchService;

public class DogCartSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("DogCartSearchAction");
		try {
			int startMoney = Integer.parseInt(request.getParameter("startMoney"));
			int endMoney = Integer.parseInt(request.getParameter("endMoney"));
		
				
			DogCartSearchService service = new DogCartSearchService();
			
			List<Cart> cartList = service.getCartSearchList(startMoney, endMoney, request);
			
			request.setAttribute("cartList", cartList);
			request.setAttribute("startMoney", startMoney);
			request.setAttribute("endMoney", endMoney);
						
			int totalMoney = 0;
			for(Cart cart : cartList) {
				totalMoney += cart.getPrice() * cart.getQty();
			}
		
			request.setAttribute("totalMoney", totalMoney);
		}catch (NumberFormatException e) {
			
		}
		return new ActionForward("dogCartList.do", false);
	}

}
