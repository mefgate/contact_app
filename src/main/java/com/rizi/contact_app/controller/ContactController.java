package com.rizi.contact_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rizi.contact_app.model.Contact;

import com.rizi.contact_app.service.ContactService;

@Controller
public class ContactController {
	@Autowired
    private ContactService contactService;
	
	// display list of contacts
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listContact", contactService.getAllContact());
        return "index";
    }

    
    @GetMapping("/showNewContactForm")
    public String showNewContactForm(Model model) {
        // create model attribute to bind form data
    	Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "new_contact";
    }
    @PostMapping("/saveContact")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        // save contact to database
        ContactService.saveContact(contact);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
     
     // get contact from the service
     Contact contact = contactService.getContactById(id);
  
     model.addAttribute("contact", contact);
     return "update_contact";
    }
    
    @GetMapping("/deleteContact/{id}")
    public String deleteContact(@PathVariable(value = "id") long id) {

        // call delete contact method 
        this.contactService.deleteContactById(id);
        return "redirect:/";
    }
    
}
