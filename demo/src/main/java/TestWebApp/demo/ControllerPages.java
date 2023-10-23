package TestWebApp.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerPages {
    @GetMapping("/home")
    public String index() {
        return "home.html"; // Returns the name of the HTML file (without the extension)
    }
    @GetMapping("/login")
    public String loginPage(){return "login.html";}
    @GetMapping("/registo")
    public String RegistPage(){return "registo.html";}
    @GetMapping("/comprar")
    public String buyItem(){
        return "comprar.html";
    }
}
