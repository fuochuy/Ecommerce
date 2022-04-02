package cybersoft.javabackend.ecommerce;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {
	@GetMapping("/indexx")
	public String index(Model model) {
		model.addAttribute("model", "hello Huy");
	    return "index";
	}
}
