package com.example.demo.service;

import com.example.demo.dto.ContatoMedicoDto;
import com.example.demo.model.ContatoMedicoModel;
import com.example.demo.model.ContatoPrincipalModel;
import com.example.demo.repository.ContatoMedicoRepository;
import com.example.demo.repository.ContatoPricipalRepository;
import com.example.demo.vo.ContatoPrincipalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.Date;
import java.util.List;

@Service
public class ContatoMedicoService {

    private static final String REGISTRO_NAO_ENCONTRADO = "Registro não encontrado!";

    @Autowired
    private ContatoMedicoRepository _contatoMedicoRepository;


    public ContatoPrincipalVO retornaContatoPrincipal(Long id) {

        List<ContatoMedicoModel> listModel = this._contatoMedicoRepository.consultaPorId(id);

        ContatoPrincipalVO vo = new ContatoPrincipalVO();
        if (!listModel.isEmpty()) {
            vo.setId(listModel.get(0).getId());
            vo.setNome(listModel.get(0).getNome());
            vo.setTelefone(listModel.get(0).getTelefone());
        } else {
            throw new ValidationException(REGISTRO_NAO_ENCONTRADO);
        }

        return vo;

    }

    public ContatoMedicoModel editar(ContatoMedicoDto dto) {

        ContatoMedicoModel model = new ContatoMedicoModel();

        if (dto.getId() != null) {

            model = this._contatoMedicoRepository.findById(dto.getId()).orElse(criar(dto));

            model.setNome(dto.getNome());
            model.setEmail(dto.getEmail());
            model.setStatus(dto.isStatus());
            model.setTelefone(dto.getTelefone());
            model.setUpdateDate(new Date());

            model = this._contatoMedicoRepository.save(model);

        } else {
            model = criar(dto);
        }

        return model;
    }

    public ContatoMedicoModel criar(ContatoMedicoDto dto) {

        ContatoMedicoModel model = new ContatoMedicoModel();

        if (dto.getId() == null) {
            model.setNome(dto.getNome());
            model.setEmail(dto.getEmail());
            model.setStatus(dto.isStatus());
            model.setTelefone(dto.getTelefone());
            model.setUpdateDate(new Date());

            model = this._contatoMedicoRepository.save(model);
        }
        return model;
    }

}
