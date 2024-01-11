package com.example.demo.resources;

import com.example.demo.dto.ContatoMedicoDto;
import com.example.demo.dto.ContatoPrincipalDto;
import com.example.demo.service.ContatoPrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/editarContatoPrincipal")
    public ResponseEntity editarContatoPrincipal(@RequestBody ContatoPrincipalDto dto) throws Exception{
        try {
            return new ResponseEntity(this._contatoPrincipalService.editar(dto), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/criarContatoPrincipal")
    public ResponseEntity criarContatoPrincipal(@RequestBody ContatoPrincipalDto dto) throws Exception{
        try {
            return new ResponseEntity(this._contatoPrincipalService.criar(dto), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
