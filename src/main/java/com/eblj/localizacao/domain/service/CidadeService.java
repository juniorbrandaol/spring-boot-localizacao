package com.eblj.localizacao.domain.service;
import com.eblj.localizacao.domain.entity.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CidadeService {
    public Cidade salvar(Cidade cidade);
    List<Cidade> listar();
    List<Cidade> findByNome(String nome);
    List<Cidade> findByNomeStartingWith(String nome);
    List<Cidade> findByNomeEndingWith(String nome);
    List<Cidade> findByNomeContaining(String nome);
    List<Cidade> findByNomeLike(String nome,String orderedFild);
    Page<Cidade> findByNomeLikePage(String nome,Integer page, Integer size);
    List<Cidade> findByNomeIgnoreCase(String nome);
    List<Cidade> findByHabitantes(Long habitantes);
    List<Cidade> findByHabitantesLessThan(Long habitantes);
    List<Cidade> findByHabitantesGreaterThan(Long habitantes);
    List<Cidade> findByHabitantesGreaterThanEqual(Long habitantes);
    List<Cidade> findByHabitantesGreaterThanEqualAndNomeLike(Long habitantes,String nome);
    List<Cidade> findByNameFilter(Cidade cidade);

}
