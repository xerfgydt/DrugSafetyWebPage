package designprojekt.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MaterialController {


        @RequestMapping("/Material")
        public String material() {
            return "materials";
        }
}

