package com.example.demo.service;

import com.example.demo.model.ContatoPrincipalModel;
import com.example.demo.repository.ContatoPricipalRepository;
import com.example.demo.vo.ContatoPrincipalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
