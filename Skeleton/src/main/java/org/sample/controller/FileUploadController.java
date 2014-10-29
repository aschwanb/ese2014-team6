package org.sample.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.FileUploadForm;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {
	@Value("${path.adimg}")
	private String imgPath;
	
	@RequestMapping(value = "/fileupload", method = RequestMethod.GET)
		public ModelAndView fileUpload() {
			ModelAndView model = new ModelAndView("fileupload");
			model.addObject("fileUploadForm", new FileUploadForm());
			return model;
	}
	
	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
		public ModelAndView  saveFile(@Valid FileUploadForm uploadForm, BindingResult result, RedirectAttributes redirectAttributes) {
			
			ModelAndView model;
			
			if (!result.hasErrors()) {
				try {
					String name = imgPath + uploadForm.getName();
					MultipartFile file = uploadForm.getFile();
					byte[] bytes = file.getBytes();
					BufferedOutputStream stream = 
							new BufferedOutputStream(
									new FileOutputStream(new File(name)));
					stream.write(bytes);
					stream.close();
					model = new ModelAndView("savefile");
					model.addObject("msg", "File has been saved.");
				} catch (Exception e) {
					model = new ModelAndView("fileupload");
	            	model.addObject("page_error", e.getMessage());
				}
			} else {
				model = new ModelAndView("fileupload");
				model.addObject("error", "File was empty");
			}		
			return model;
	}
	
}


