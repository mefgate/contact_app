package com.rizi.contact_app.service;


import java.util.List;

import com.rizi.contact_app.model.Contact;

import org.springframework.stereotype.Service;

@Service
public interface ContactService {
     List<Contact> getAllContact();
     static void saveContact(Contact contact) {
        // TODO Auto-generated method stub
    }
     Contact getContactById(long id);
     
     void deleteContactById(long id);
    
    
    }