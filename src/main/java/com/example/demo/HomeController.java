package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    JobRepository jobRepository;

    @RequestMapping("/")
    public String listjobs(Model model) {
        model.addAttribute("jobs", new Job());
        return "list";

    }

    @GetMapping("/add")
    public String jobform(Model model) {
        model.addAttribute("job", new Job());
        return "jobform";
    }

    @PostMapping("/process")
    public String processorForm(@Valid Job job, BindingResult result) {
        if (result.hasErrors()) {
            return "jobform";
        }
        jobRepository.save(job);
        return "redirect:/";
    }
}
