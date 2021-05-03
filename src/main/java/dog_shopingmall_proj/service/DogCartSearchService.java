package dog_shopingmall_proj.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dog_shopingmall_proj.dto.Cart;

public class DogCartSearchService {

	@SuppressWarnings("unchecked")
	public List<Cart> getCartSearchList(int start_money, int end_money, HttpServletRequest request){
		List<Cart> oldCartList = (List<Cart>) request.getSession().getAttribute("cartList");
		
		List<Cart> cartList = new ArrayList<Cart>();
		
		for(Cart cart : oldCartList) {
			if (cart.getPrice() >= start_money && cart.getPrice() <= end_money) {
				cartList.add(cart);
			}
		}
		return cartList;
	}
}
