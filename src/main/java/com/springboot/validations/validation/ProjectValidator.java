package com.springboot.validations.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springboot.validations.model.Project;

@Component
public class ProjectValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return Project.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Project project = (Project) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projectdatabasename", "NotEmpty.project.projectdatabasename");
		if (project.getProjectdatabasename().length() < 4 || project.getProjectdatabasename().length() > 40) {
			errors.rejectValue("projectdatabasename", "Size.project.projectdatabasename");
		}
		
	}
}