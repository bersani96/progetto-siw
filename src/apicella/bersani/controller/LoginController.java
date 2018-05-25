package apicella.bersani.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.model.Azienda;
import apicella.bersani.model.Responsabile;

@Controller
public class LoginController {

	@RequestMapping("/makeLogin")
	public String processLogin(HttpSession session, @ModelAttribute("responsabile") Responsabile responsabile, Model model)
	{
		String next;
		Azienda azienda = (Azienda) session.getAttribute("azienda");
		Responsabile result = azienda.makeLogin(responsabile);
		
		if(result!=null)
		{
			session.setAttribute("responsabileLoggato", result);
			next = "index";
		}
		else
		{
			next="login";
			model.addAttribute("error", "Email o password errati");
		}
		
		System.out.println("LoginController: vado a " + next);
			
		return next;
		
	}
	
	
}
