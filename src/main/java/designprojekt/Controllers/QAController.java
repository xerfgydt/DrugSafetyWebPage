package designprojekt.Controllers;

import designprojekt.Entities.QA;
import designprojekt.Repositories.QARepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class QAController {

    QARepository qaRepository = new QARepository();

    @RequestMapping("/qa")
    public String QA(Model model) {
        qaRepository.create(new QA("Hej hvad hedder du?", "Jeg hedder Mathias", LocalDate.now()));
        qaRepository.create(new QA("Hvad sker der?", "Ikke så meget :D", LocalDate.now()));
        qaRepository.create(new QA("Hvor kommer du fra?", "Danmark", LocalDate.now()));
        model.addAttribute("qaList", qaRepository.readAll());
        return "qa";
    }
}