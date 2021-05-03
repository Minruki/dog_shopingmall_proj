package dog_shopingmall_proj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog_shopingmall_proj.service.DogCartRemoveService;

public class DogCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String[] kindArray = request.getParameterValues("remove");
//		System.out.println("kindArray" + Arrays.toString(kindArray));
		
		if (kindArray == null) {
			return new ActionForward("dogCartList.do", true);
		}
		DogCartRemoveService service = new DogCartRemoveService();
		service.cartRemove(request, kindArray);
		
		return new ActionForward("dogCartList.do", true);
	}

}
