package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/","/listOwners", "/index", "/index.html"})
    public String listOwners(Model model) {
        model.addAttribute("owners", this.ownerService.findAll());
        return "/owners/listOwners";
    }

    @RequestMapping("/find")
    public String findOwners() {
        return "notimplemented";
    }
}
