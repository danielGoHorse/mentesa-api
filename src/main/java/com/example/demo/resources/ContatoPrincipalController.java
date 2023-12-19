package com.example.demo.resources;

import com.example.demo.service.ContatoPrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;

@RestController
@RequestMapping("/contato_principal")
public class ContatoPrincipalController {

    @Autowired
    private ContatoPrincipalService _contatoPrincipalService;

    @GetMapping("/contatoPrincipal/{id}")
    public ResponseEntity retornaContatoPrincipal(@PathVariable Long id) throws Exception{
        try {
            return new ResponseEntity(this._contatoPrincipalService.retornaContatoPrincipal(id), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
