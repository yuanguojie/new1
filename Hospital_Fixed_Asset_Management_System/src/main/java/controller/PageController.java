package controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

	/**
	 * 页面跳转，用于导航菜单
	 * @param url
	 * @return
	 */
	@RequestMapping("/page/{url}")
	public String gotoUrl(@PathVariable(value="url") String url){
		return url.replace("_", "/");
	}

}
