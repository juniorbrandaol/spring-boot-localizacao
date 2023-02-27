package com.eblj.localizacao.domain.service.impl;

import com.eblj.localizacao.domain.entity.Cidade;
import com.eblj.localizacao.domain.repository.CidadeRepository;
import com.eblj.localizacao.domain.service.CidadeService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CidadeServiceImpl implements CidadeService {

    private CidadeRepository repository;

    public  CidadeServiceImpl(CidadeRepository repository){
        this.repository = repository;
    }
    @Override
    public Cidade salvar(Cidade cidade) {
        return repository.save(cidade);
    }
    @Override
    public List<Cidade> listar() {
        return repository.findAll();
    }

    @Override
    public List<Cidade> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    @Override
    public List<Cidade> findByNomeStartingWith(String nome) {
        return repository.findByNomeStartingWith(nome);
    }

    @Override
    public List<Cidade> findByNomeEndingWith(String nome) {
        return repository.findByNomeEndingWith(nome);
    }

    @Override
    public List<Cidade> findByNomeContaining(String nome) {
        return repository.findByNomeContaining(nome);
    }

    @Override
    public List<Cidade> findByNomeLike(String nome,String orderedFild ) {
        return repository.findByNomeLike(nome,Sort.by(orderedFild));
    }

    @Override
    public Page<Cidade> findByNomeLikePage(String nome,Integer page,Integer size) {
        Pageable pageable  = PageRequest.of(page,size);
        return repository.findByNomeLikePage(nome,pageable);
    }

    @Override
   public List<Cidade> findByNomeIgnoreCase(String nome) {
       return repository.findByNomeIgnoreCase(nome);
    }
    @Override
    public List<Cidade> findByHabitantes(Long habitantes) {
        return repository.findByHabitantes(habitantes);
    }

    @Override
    public List<Cidade> findByHabitantesLessThan(Long habitantes) {
        return repository.findByHabitantesLessThan(habitantes);
    }

    @Override
    public List<Cidade> findByHabitantesGreaterThan(Long habitantes) {
        return repository.findByHabitantesGreaterThan(habitantes);
    }

    @Override
    public List<Cidade> findByHabitantesGreaterThanEqual(Long habitantes) {
        return repository.findByHabitantesGreaterThanEqual(habitantes);
    }

    @Override
    public List<Cidade> findByHabitantesGreaterThanEqualAndNomeLike(Long habitantes, String nome) {
        return repository.findByHabitantesGreaterThanEqualAndNomeLike(habitantes,nome);
    }

    /*
    *
    * Método que usa query example para fazer pesquisa com filtros
    * Essa função retornará conforme o filtro passado
    *
     */
    @Override
    public List<Cidade> findByNameFilter(Cidade cidade) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()   //ignora se está em caixa baixa ou não
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);//funciona como o like.
        Example<Cidade> example = Example.of(cidade,matcher);
        return repository.findAll(example);
    }


}
