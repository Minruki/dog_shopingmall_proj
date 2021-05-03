package dog_shopingmall_proj.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dog_shopingmall_proj.dto.Cart;

public class DogCartRemoveService {
	
	@SuppressWarnings("unchecked")
	public void cartRemove(HttpServletRequest request, String[] kindArray) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
		
		for(String kind : kindArray) {
			Cart cart = new Cart(kind);
			if (cartList.contains(cart)) {
				cartList.remove(cart);
			}
		}
		
	}
}
