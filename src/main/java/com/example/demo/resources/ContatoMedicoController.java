package com.example.demo.resources;

import com.example.demo.dto.ContatoMedicoDto;
import com.example.demo.service.ContatoMedicoService;
import com.example.demo.service.ContatoPrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;

@RestController
@RequestMapping("/contato_medico")
public class ContatoMedicoController {

    @Autowired
    private ContatoMedicoService _contatoMedicoService;

    @GetMapping("/contatoMedico/{id}")
    public ResponseEntity retornaContatoMedico(@PathVariable Long id) throws Exception{
        try {
            return new ResponseEntity(this._contatoMedicoService.retornaContatoPrincipal(id), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/editarContatoMedico")
    public ResponseEntity editarContatoMedico(@RequestBody ContatoMedicoDto dto) throws Exception{
        try {
            return new ResponseEntity(this._contatoMedicoService.editar(dto), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/criarContatoMedico")
    public ResponseEntity criarContatoMedico(@RequestBody ContatoMedicoDto dto) throws Exception{
        try {
            return new ResponseEntity(this._contatoMedicoService.criar(dto), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
