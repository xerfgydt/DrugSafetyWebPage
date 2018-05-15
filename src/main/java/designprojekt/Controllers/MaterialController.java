package designprojekt.Controllers;

import designprojekt.Entities.Material;
import designprojekt.Repositories.MaterialRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.MalformedURLException;


@Controller
public class MaterialController {

    private MaterialRepository materialRepository = new MaterialRepository();

        @RequestMapping(value="/materials", method=RequestMethod.GET)
        public String materials(Model model) {
            materialRepository.create(new Material("https://google.com"));
            model.addAttribute("materials", materialRepository.readAll());
            System.out.println(materialRepository.readAll());
            return "materials";
        }

        @RequestMapping(value="/createMaterial", method=RequestMethod.GET)
        public String createMaterial(Model model) {
            model.addAttribute("material", new Material());
            return "createMaterial";
        }

        @RequestMapping(value="/createMaterial", method=RequestMethod.POST)
        public String createMaterial(@ModelAttribute Material material) {
            materialRepository.create(material);
            return "redirect:/materials";
        }

        @RequestMapping(value="/readMaterial", method=RequestMethod.GET)
        public String readMaterial(Model model, @RequestParam("link") String link) {
            model.addAttribute("material", materialRepository.read(link));
            return "readMaterial";
        }

        @RequestMapping(value = "/updateMaterial", method = RequestMethod.POST)
        public String updateMaterial(@ModelAttribute Material material) {
            materialRepository.update(material);
            return "redirect:/materials";
        }

        @RequestMapping(value = "deleteMaterial", method = RequestMethod.DELETE)
        public String deleteMaterial(@ModelAttribute Material material) {
            materialRepository.delete(material);
            return "redirect:/materials";
        }
}

