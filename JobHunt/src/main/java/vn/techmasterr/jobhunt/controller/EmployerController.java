package vn.techmasterr.jobhunt.controller;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.techmasterr.jobhunt.model.Employer;

@Controller
@RequestMapping("/employer")
public class EmployerController {
    private ConcurrentHashMap<String, Employer> listEmployer;

    public EmployerController() {
        listEmployer = new ConcurrentHashMap<>();
        listEmployer.put("1", new Employer("Việc làm 24h ", "vieclam24h.vn", "vieclam24h@gmail.com", "Hà Nội"));
        listEmployer.put("2", new Employer("Topcv", "topcv.vn", "topcv@gmail.com", "Hà Nội"));
        listEmployer.put("3", new Employer("Careerbuilder", "careerbuilder.vn", "careerbuilder@gmail.com", "Bắc Ninh"));
    }

    @GetMapping("/list")
    public String getEmployer(Model model) {
         List<Employer> lists = listEmployer.values().stream().toList();
         model.addAttribute("employers", lists);
         return "list";
    }


}
