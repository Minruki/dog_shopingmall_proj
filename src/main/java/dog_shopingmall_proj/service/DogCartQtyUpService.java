package dog_shopingmall_proj.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dog_shopingmall_proj.dto.Cart;

public class DogCartQtyUpService {


	@SuppressWarnings("unchecked")
	public void upCartQty(String kind, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
		
		for(Cart cart : cartList) {
			if (cart.getKind().equals(kind)) {
				cart.setQty(cart.getQty() + 1);
				break;
			}
		}
	}
}
