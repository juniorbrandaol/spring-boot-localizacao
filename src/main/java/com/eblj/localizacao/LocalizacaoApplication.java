package com.eblj.localizacao;

import com.eblj.localizacao.domain.entity.Cidade;
import com.eblj.localizacao.domain.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {
	@Autowired
	private CidadeService cidadeService;
	@Override
	public void run(String... args) throws Exception {
//	  salvar();
     // listarCidades();
	 // listarCidadePorNome("patos");
	 // listarCidadePorhabitantes(55000l);
	 // listarCidadeStartingWith("C");
	 // listarCidadeEndingWith("0");
	 // listarCidadeContaining("sé");
	  //listarCidadePorNomeLike("C%","id");
	 // listarCidadePorNomeIgnoreCase("PATOS");
	 // listarCidadePorNumerohabitantesMenor(5000L);
	 // listarCidadePorNumerohabitantesMaior(400000L);
	 // listarCidadePorNumerohabitantesMaiorIgual(850000L);
	 // listarCidadePorNumerohabitantesMaiorIgualENome(400000L,"Ca%");
	//	listarCidadePorNomeLikePage("%%%%",1,3);

		var cidade = new Cidade(null, "ca",null);
		listarCidadeFilter(cidade);

	}
	@Transactional//opcional, pois os repositorios já implementão transactional
	public void salvar(){
		var cidade =  new Cidade(null,"Patos",120000L);
		cidadeService.salvar(cidade);
	}
    public void listarCidadePorhabitantes(Long habitantes){
		cidadeService.findByHabitantes(habitantes).forEach(System.out::println);
	}

	public void listarCidadePorNumerohabitantesMenor(Long habitantes){
		cidadeService.findByHabitantesLessThan(habitantes).forEach(System.out::println);
	}

	public void listarCidadePorNumerohabitantesMaior(Long habitantes){
		cidadeService.findByHabitantesGreaterThan(habitantes).forEach(System.out::println);
	}

	public void listarCidadePorNumerohabitantesMaiorIgual(Long habitantes){
		cidadeService.findByHabitantesGreaterThanEqual(habitantes).forEach(System.out::println);
	}

	public void listarCidadePorNumerohabitantesMaiorIgualENome(Long habitantes,String nome){
		cidadeService.findByHabitantesGreaterThanEqualAndNomeLike(habitantes,nome).forEach(System.out::println);
	}

	public void listarCidadePorNome(String nome){
		cidadeService.findByNome(nome).forEach(System.out::println);
	}

	public void listarCidadeStartingWith(String nome){
		cidadeService.findByNomeStartingWith(nome).forEach(System.out::println);
	}

	public void listarCidadeEndingWith(String nome){
		cidadeService.findByNomeEndingWith(nome).forEach(System.out::println);
	}
	public void listarCidadeContaining(String nome){
		cidadeService.findByNomeContaining(nome).forEach(System.out::println);
	}

	public void listarCidadePorNomeLike(String nome,String orderedFild){
		cidadeService.findByNomeLike(nome,orderedFild).forEach(System.out::println);
	}

	public void listarCidadePorNomeLikePage(String nome,Integer page,Integer size){
		cidadeService.findByNomeLikePage(nome,page,size).forEach(System.out::println);
	}
	public void listarCidades(){
		cidadeService.listar().forEach(System.out::println);
	}

	public void listarCidadePorNomeIgnoreCase(String nome){
		cidadeService.findByNomeIgnoreCase(nome).forEach(System.out::println);
	}

    public void listarCidadeFilter(Cidade cidade){
		 cidadeService.findByNameFilter(cidade).forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}
}
