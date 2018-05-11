package designprojekt.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QAController {

    @RequestMapping
    public String QA(Model model) {
        return "qa";
    }
}
