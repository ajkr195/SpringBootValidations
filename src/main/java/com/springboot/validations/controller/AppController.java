package com.springboot.validations.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.validations.model.Project;
import com.springboot.validations.service.ProjectService;
import com.springboot.validations.validation.ProjectValidator;

@Controller
public class AppController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	ProjectValidator projValidator;
	
	@GetMapping("/")
	public String getForm(Model model) {
		Project project = new Project();
		projectService.populateDefaults(project);
		model.addAttribute("technologyList", projectService.technologyList());
		model.addAttribute("project", project);
		model.addAttribute("dbtypeList", projectService.databaseList());
		return "home";
	}

	@PostMapping("/")
	public String formSubmit(@Valid Project project, BindingResult bindingResult,
			@RequestParam("projectpath") String projectpath, Model model) {
		
		projValidator.validate(project, bindingResult);
		
		
		String invalidProjectpathmsg = "Controller Message - Another additional Message.";

		if (projectService.validatePath(projectpath)) {
			System.out.println("Controller Message - Valid directory path..!! >>>>>>>>>>>>> " + projectpath);
		} else {
			System.err
					.println("Controller Message - INVALID directory path..!! >>>>>>>>>>>>> " + invalidProjectpathmsg);
			model.addAttribute("technologyList", projectService.technologyList());
			model.addAttribute("dbtypeList", projectService.databaseList());
			model.addAttribute("invalidProjectpathmsg", invalidProjectpathmsg);
			bindingResult.rejectValue("projectpath", "invalid.project.projectpath");
			return "home";
		}

		if (bindingResult.hasErrors()) {
			model.addAttribute("technologyList", projectService.technologyList());
			model.addAttribute("dbtypeList", projectService.databaseList());
			return "home";
		}
		projectService.testPathForWriteDelete(projectpath);
		projectService.writeConfigfile(project);
		return "verify";
	}
}
