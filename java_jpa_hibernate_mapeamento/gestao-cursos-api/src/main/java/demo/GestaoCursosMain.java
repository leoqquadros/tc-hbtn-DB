package demo;

import entities.*;
import models.*;

import java.time.LocalDate;
import java.util.List;

public class GestaoCursosMain {
    public static void main(String[] args) {
        // Persistindo dados de Aluno
        Aluno aluno = new Aluno();

        aluno.setEmail("leo");
        aluno.setMatricula("2002");
        aluno.setNomeCompleto("Ola");
        aluno.setNascimento(LocalDate.of(1998, 01, 01));
        aluno.setEnderecos(null);
        aluno.setTelefones(null);
        AlunoModel alunoModel = new AlunoModel();

        alunoModel.create(aluno);

        // Persistindo dados de Endereco

        Endereco endereco = new Endereco();
        endereco.setEndereco("RUa a ");
        endereco.setBairro("Casass");
        endereco.setCidade("ssa");
        endereco.setBairro("ba");
        endereco.setLogradouro("casa");
        endereco.setNumero("15");

        EnderecoModel enderecoModel = new EnderecoModel();

        enderecoModel.create(endereco);

        aluno.setEnderecos(List.of(endereco));
        alunoModel.update(aluno);

        // Persistindo dados de MaterialCurso

        MaterialCurso materialC = new MaterialCurso();
        materialC.setUrl("www.tech.com.br");

        MaterialModel materiaM = new MaterialModel();
        materiaM.create(materialC);

        // Professor
        Professor professor = new Professor();
        professor.setEmail("aa");
        professor.setMatricula("bb");
        professor.setNomeCompleto("cc");

        ProfessorModel professorModel = new ProfessorModel();
        professorModel.create(professor);

        // Persistindo dados de Curso

        Curso curso = new Curso();
        curso.setNome("Matematica");
        curso.setSigla("MAT");
        curso.setMaterialCurso(materialC);
        curso.setProfessor(professor);

        CursoModel cursoModel = new CursoModel();
        cursoModel.create(curso);





    }
}
