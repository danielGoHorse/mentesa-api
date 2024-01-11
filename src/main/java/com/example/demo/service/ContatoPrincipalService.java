package com.example.demo.service;

import com.example.demo.dto.ContatoPrincipalDto;
import com.example.demo.model.ContatoPrincipalModel;
import com.example.demo.repository.ContatoPricipalRepository;
import com.example.demo.vo.ContatoPrincipalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContatoPrincipalService {

    @Autowired
    private ContatoPricipalRepository _contatoPricipalRepository;


    public ContatoPrincipalVO retornaContatoPrincipal(Long id) {

        List<ContatoPrincipalModel> listModel = this._contatoPricipalRepository.consultaPorId(id);

        ContatoPrincipalVO vo = new ContatoPrincipalVO();
        if (!listModel.isEmpty()){
            vo.setId(listModel.get(0).getId());
            vo.setNome(listModel.get(0).getNome());
            vo.setTelefone(listModel.get(0).getTelefone());
        }

        return vo;

    }

    public ContatoPrincipalModel editar(ContatoPrincipalDto dto) {

        ContatoPrincipalModel model = new ContatoPrincipalModel();

        if (dto.getId() != null) {

            model = this._contatoPricipalRepository.findById(dto.getId()).orElse(criar(dto));

            model.setNome(dto.getNome());
            model.setEmail(dto.getEmail());
            model.setTelefone(dto.getTelefone());
            model.setUpdateDate(new Date());

            model = this._contatoPricipalRepository.save(model);

        } else {
            model = criar(dto);
        }

        return model;
    }

    public ContatoPrincipalModel criar(ContatoPrincipalDto dto) {

        ContatoPrincipalModel model = new ContatoPrincipalModel();

        if (dto.getId() == null) {
            model.setNome(dto.getNome());
            model.setEmail(dto.getEmail());
            model.setTelefone(dto.getTelefone());
            model.setUpdateDate(new Date());

            model = this._contatoPricipalRepository.save(model);
        }
        return model;
    }
}
