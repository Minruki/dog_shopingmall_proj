package dog_shopingmall_proj.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dog_shopingmall_proj.dto.Dog;
import dog_shopingmall_proj.service.DogRegistService;

public class DogRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		DogRegistService service = new DogRegistService();
		String realFolder = "";
		// 파일 업로드될 서버 상의 물리적인 경로
		String saveFolder = "/images";

		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		Dog dog;
		ActionForward forward = null;
		
		try {
			dog = getDog(request, realFolder);
			boolean isRegistSuccess = service.registDog(dog);
			
			if (isRegistSuccess) {
				forward = new ActionForward("dogList.do", true);
			} else {
				sendMessage(response);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return forward;
	}

	private void sendMessage(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('등록실패');");
		out.println("history.back();");
		out.println("</script>");
	}

	private Dog getDog(HttpServletRequest request, String realFolder) throws IOException {
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024;
		// 한번에 업로드 할 수 있는 파일의 크기
		
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType,
				new DefaultFileRenamePolicy());
		//MultiPartRequest
		String image = multi.getFilesystemName("image");
		String kind = multi.getParameter("kind");
		int price = Integer.parseInt(multi.getParameter("price"));
		String country = multi.getParameter("nation");
		int height = Integer.parseInt(multi.getParameter("height"));
		int weight = Integer.parseInt(multi.getParameter("weight"));
		String content = multi.getParameter("content");
		
		return new Dog(0, kind, price, image, country, height, weight, content, 0);
	}

}
