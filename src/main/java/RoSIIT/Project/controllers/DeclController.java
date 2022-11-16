package RoSIIT.Project.controllers;

import RoSIIT.Project.model.Decl;
import RoSIIT.Project.repo.JpaDeclRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@Controller
@RequestMapping("decl")
public class DeclController {

    @Autowired
    private JpaDeclRepository jpaDeclRepository;


    @GetMapping("/add")
    public String addDeclForm(Model model){
        return "declaratii/addForm";
    }
    @PostMapping("/add")
    public RedirectView adddecl(Model model,
                                @RequestParam("decl_month") String month,
                                @RequestParam("decl_year") String year,
                                @RequestParam("decl_name") String name,
                                @RequestParam("decl_type") String type,
                                @RequestParam("decl_obs") String obs) {
        Decl addedDecl = new Decl(UUID.randomUUID(), year,month ,name, type, obs);

        jpaDeclRepository.saveAndFlush(addedDecl);

        return new RedirectView("/decl/");
    }

    @GetMapping("/")
    public String listDecl(Model model){
        model.addAttribute("declaratii", jpaDeclRepository.findAll());
        return "declaratii/listDecl";
    }
    @GetMapping("/delete/{id}")
    public RedirectView deleteDecl(Model model, @PathVariable("id") UUID declId) {
        jpaDeclRepository.deleteById(declId);
        return new RedirectView("/decl/");
    }



}
