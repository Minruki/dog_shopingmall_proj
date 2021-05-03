package dog_shopingmall_proj.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog_shopingmall_proj.dto.Cart;
import dog_shopingmall_proj.service.DogCartListService;

public class DogCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DogCartListAction");
		DogCartListService service = new DogCartListService();
		ArrayList<Cart> cartList = service.getCartList(request);
		
		//총금액 계산
		int totalMoney = 0;
		int money = 0;
		
		for(Cart cart : cartList) {
			money = cart.getPrice() * cart.getQty();
			totalMoney += money;
		}
		
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		return new ActionForward("/dog_shopping/dogCartList.jsp", false);
	}

}
