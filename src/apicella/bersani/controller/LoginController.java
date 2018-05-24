package apicella.bersani.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.model.Azienda;
import apicella.bersani.model.Responsabile;

@Controller
public class LoginController {

	@RequestMapping("/makeLogin")
	public String processLogin(@ModelAttribute("azienda") Azienda azienda, @ModelAttribute("responsabile") Responsabile responsabile, Model model)
	{
		String next;
		Responsabile result = azienda.makeLogin(responsabile);
		
		if(result!=null)
		{
			model.addAttribute("responsabileLoggato", result);
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
