package dog_shopingmall_proj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog_shopingmall_proj.dto.Dog;
import dog_shopingmall_proj.service.DogCartAddService;

public class DogCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("DogCartAddAction");
		int id = Integer.parseInt(request.getParameter("id"));
		
		DogCartAddService service = new DogCartAddService();
		Dog cartDog = service.getCartDog(id);
		service.addCart(request, cartDog);
		
		return new ActionForward("dogCartList.do", true);
	}

}
