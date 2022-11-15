package RoSIIT.Project.controllers;

import RoSIIT.Project.model.Company;
import RoSIIT.Project.repo.JpaCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("companies")
public class CompanyController {

    @Autowired
    private JpaCompanyRepository jpaCompanyRepository;

    @GetMapping("/")
    public String listCompanies(Model model){
        model.addAttribute("companies", jpaCompanyRepository.findAll());
        return "companies/list";
    }
    @GetMapping("/add")
    public String addCompanyForm(Model model) {
        return "companies/addForm";
    }

    @PostMapping("/add")
    public RedirectView addCompany(Model model,
                                @RequestParam("company_name") String companyName,
                                @RequestParam("company_codF") String companyCodF,
                                @RequestParam("company_activity") Boolean companyActivity,
                                   @RequestParam("company_adress") String companyAdress) {
        Company addedCompany = new Company(UUID.randomUUID(), companyName, companyCodF, companyActivity, companyAdress);

        jpaCompanyRepository.saveAndFlush(addedCompany);

        return new RedirectView("/companies/");
    }

    @GetMapping(path= "/edit/{id}")
    public String editCompanyForm(Model model, @PathVariable("id") UUID companyId) {
        Optional<Company> optionalCompany = jpaCompanyRepository.findById(companyId);
        Company company = optionalCompany.get();
        model.addAttribute("Company", company);

        return "companies/editForm";
    }
    @PostMapping("/edit/{id}")
    public RedirectView addCompany(Model model,
                                   @PathVariable("id") UUID companyId,
                                   @RequestParam("company_name") String companyName,
                                   @RequestParam("company_codF") String companyCodF,
                                   @RequestParam("company_activity") Boolean companyActivity,
                                   @RequestParam("company_adress") String companyAdress) {
        Optional<Company> company = jpaCompanyRepository.findById(companyId);
        company.get().setName(companyName);
        company.get().setCodF(companyCodF);
        company.get().setActivity(companyActivity);
        company.get().setAdress(companyAdress);
        jpaCompanyRepository.save(company.get());
        return new RedirectView("/companies/");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteCompany(Model model, @PathVariable("id") UUID companyId) {
        jpaCompanyRepository.deleteById(companyId);
        return new RedirectView("/companies/");
    }



}
