package com.calmomilla.api.configs;

import com.calmomilla.domain.model.*;
import com.calmomilla.domain.repository.*;
import com.calmomilla.domain.utils.UserRole;
import com.calmomilla.domain.utils.enums.CategoriaRelaxamento;
import com.calmomilla.domain.utils.enums.Especializacoes;
import com.calmomilla.domain.utils.enums.Focos;
import com.calmomilla.domain.utils.enums.Genero;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Var;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final JogoRepository jogoRepository;
    private final PacienteRepository pacienteRepository;
    private final PsicologoRepository psicologoRepository;
    private final TarefaRepository tarefaRepository;
    private final RotinaRepository rotinaRepository;
    private final RelaxamentoRepository relaxamentoRepository;
    private final BlogRepository blogRepository;

    @Override
    public void run(String... args) throws Exception {
        // Criar objetos Jogo

        if (jogoRepository.existsJogoByNome("Jogo da Memória")) {
            System.out.println("Jogo da Memória ja existe");
        } else {
            Jogo jogo1 = new Jogo();
            jogo1.setNome("Jogo da Memória");
            jogo1.setDescricao("Teste sua memória combinando pares de cartas neste divertido desafio!");
            jogo1.setFocos(Arrays.asList(Focos.MEMORIA, Focos.ATENCAO, Focos.RELAXAMENTO));
            jogo1.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/memoria.png");
            jogo1.setAvaliacao(0);
            jogo1.setLink("/jogomemoria");
            jogoRepository.save(jogo1);
        }

        if (jogoRepository.existsJogoByNome("Sudoku")) {
            System.out.println("Sudoku ja existe");
        } else {
            Jogo jogo2 = new Jogo();
            jogo2.setNome("Sudoku");
            jogo2.setDescricao("Preencha a grade com números de 1 a 9 sem repetir em linhas e colunas.");
            jogo2.setFocos(Arrays.asList(Focos.RESOLUCAO_DE_PROBLEMAS, Focos.ATENCAO));
            jogo2.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/sudoku.png");
            jogo2.setAvaliacao(0);
            jogo2.setLink("/sudoku");
            jogoRepository.save(jogo2);
        }

        if (jogoRepository.existsJogoByNome("Quiz")) {
            System.out.println("Quiz ja existe");
        } else {
            Jogo jogo3 = new Jogo();
            jogo3.setNome("Quiz");
            jogo3.setDescricao("Responda a perguntas variadas e veja quantas você acerta!");
            jogo3.setFocos(Arrays.asList(Focos.ATENCAO, Focos.VELOCIDADE));
            jogo3.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/quiz.jpg");
            jogo3.setLink("/quiz");
            jogo3.setAvaliacao(0);
            jogoRepository.save(jogo3);
        }


        if (jogoRepository.existsJogoByNome("CacaPalavras")) {
            System.out.println("CacaPalavras ja existe");
        } else {
            Jogo jogo4 = new Jogo();
            jogo4.setNome("CacaPalavras");
            jogo4.setDescricao("Encontre as palavras escondidas na grade e desafie seu vocabulário!");
            jogo4.setFocos(Arrays.asList(Focos.ATENCAO, Focos.RESOLUCAO_DE_PROBLEMAS));
            jogo4.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/palavrasCruzadas.png");
            jogo4.setLink("/cacapalavras");
            jogo4.setAvaliacao(0);
            jogoRepository.save(jogo4);
        }


        if (psicologoRepository.findByEmail("contato@calmomilla.org").isPresent()) {

            System.out.println("o ADM contato@calmomilla.org ja existe");
        } else {
            Psicologo usuario = new Psicologo();
            usuario.setNome("Calmomilla");
            usuario.setEmail("contato@calmomilla.org");
            usuario.setSenha("010203cd");
            var senhaUsuario = new BCryptPasswordEncoder().encode(usuario.getSenha());
            usuario.setSenha(senhaUsuario);
            usuario.setGenero(Genero.FEMININO);
            usuario.setCpf("24089231825");
            usuario.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/LogoDefinitivaFundo.png");
            usuario.setTelefone("11968210285");
            usuario.setNumeroRegistro("2312323");
            usuario.setRole(UserRole.ADMIN);
            psicologoRepository.save(usuario);
        }

        if (pacienteRepository.findByEmail("dndragonbr@gmail.com").isPresent()) {

            System.out.println("o paciente dndragonbr@gmail.com ja existe");
        } else {

            Paciente vitor = new Paciente();
            vitor.setNome("vitor");
            vitor.setEmail("dndragonbr@gmail.com");
            vitor.setSenha("123456");
            var senhaVitor = new BCryptPasswordEncoder().encode(vitor.getSenha());
            vitor.setSenha(senhaVitor);
            vitor.setGenero(Genero.MASCULINO);
            vitor.setDataNasc(LocalDate.parse("2006-03-28"));
            vitor.setCpf("52439200883");
            vitor.setTelefone("11987492156");
            vitor.setRole(UserRole.PACIENTE);
            vitor.setFoto("https://lh3.googleusercontent.com/a/ACg8ocL9IDPYfcaUn1-5L9VZsxgMVlXffSES0P6PcJPCwQKnRgfSPLjl=s96-c-rg-br100");
            pacienteRepository.save(vitor);
        }

        if (psicologoRepository.findByEmail("gab@gmail.com").isPresent()) {

            System.out.println("o psicologo gbvjb@gmail.com ja existe");
        } else {

            Psicologo psicologo = new Psicologo();
            psicologo.setNome("gabriel");
            psicologo.setEmail("gab@gmail.com");
            psicologo.setGenero(Genero.MASCULINO);
            psicologo.setDataNasc(LocalDate.parse("2005-04-17"));
            psicologo.setCpf("24094280");
            psicologo.setTelefone("119682102859");
            psicologo.setSenha("123456");
            var senhaPsicologo = new BCryptPasswordEncoder().encode(psicologo.getSenha());
            psicologo.setSenha(senhaPsicologo);
            psicologo.setFoto("https://lh3.googleusercontent.com/a/ACg8ocI0WJi3mbL6zITt7V2Ef4Pb4hEXS1mAL_ioJDtuPuDllqkGyQPc2A=s96-c");
            psicologo.setEspecializacoes(List.of(Especializacoes.PSICANALISE));
            psicologo.setNumeroRegistro("4429213");
            psicologo.setRole(UserRole.PSICOLOGO);
            psicologoRepository.save(psicologo);

        }
        if (psicologoRepository.findByNumeroRegistro("06/116044") != null){
            System.out.println("Ana Carolina Barros Silva");
        }else {
            Psicologo anaCarolina = new Psicologo();
            anaCarolina.setNome("Ana Carolina Barros Silva");
            anaCarolina.setDescricao("Psicanalista com doutorado em Psicologia, Linguagem e Educação pela Universidade de São Paulo e pela Université Paris VIII (França). Especialista em psicanálise pelo Instituto SEDES Sapientiae. Pesquisadora e consultora em temáticas relacionadas à saúde mental da população negra. Coordenadora-geral da Casa de Marias.");
            anaCarolina.setEmail("anacasademarias@gmail.com");
            anaCarolina.setNumeroRegistro("06/116044");
            anaCarolina.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/Ana+Carolina.jpg");
            anaCarolina.setEspecializacoes(List.of(Especializacoes.PSICANALISE,Especializacoes.PSICOTERAPIA_ADOLESCENTES,Especializacoes.PSICOTERAPIA_ADULTOS));
            anaCarolina.setGenero(Genero.FEMININO);
            anaCarolina.setServicosOferecidos(List.of("Curso Preparatório para Entrada na Pós Graduação;","Grupo de Escrita Acadêmica Entre Mulheres;","Grupo de estudos em teoria psicanalítica;","Psicoterapia individual para adolescentes;","Psicoterapia individual para adultos;","Supervisão clínica em grupo;","Supervisão clínica individual;","Consultoria e acompanhamento individual para elaboração de projetos (mestrado e doutorado);","Consultoria, cursos, formações e workshops especializados para instituições."));
            anaCarolina.setSenha("123456");
            var senhaPsicologo = new BCryptPasswordEncoder().encode(anaCarolina.getSenha());
            anaCarolina.setSenha(senhaPsicologo);
            anaCarolina.setRole(UserRole.PSICOLOGO);

            psicologoRepository.save(anaCarolina);
        }

        if (psicologoRepository.findByNumeroRegistro("05/55818") != null){
            System.out.println("Débora Bonfim");
        }else {
            Psicologo deboraBonfim = new Psicologo();
            deboraBonfim.setNome("Débora Bonfim");
            deboraBonfim.setDescricao("Psicóloga Clínica, Pedagoga, Palestrante e Modelo Plus Size. Pós graduada em Gestalt terapia, em curso pós graduação em Sexualidade Humana. Idealizadora do Projeto Foco em Mim que une a Psicologia e a fotografia com o intuito de trabalhar a Autoestima, Empoderamento feminino, auto aceitação corporal dentre outras questões relacionadas ao universo feminino." + "Atuo como voluntária na Comissão de Igualdade Racial da OAB/Nilópolis e na Amazaoest que trabalha com questões relacionadas à Violência Doméstica. Autoestima da Mulher Negra. Nas horas de lazer, amo dançar! Embaixadora Musa Plus Size Beleza Negra.");
            deboraBonfim.setEmail("deboracasademarias@gmail.com");
            deboraBonfim.setNumeroRegistro("05/55818");
            deboraBonfim.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/Debora.png");
            deboraBonfim.setEspecializacoes(List.of(Especializacoes.GESTALT_TERAPIA,Especializacoes.PSICOTERAPIA_ADOLESCENTES,Especializacoes.PSICOTERAPIA_ADULTOS,Especializacoes.PSICOTERAPIA_MULHERES_NEGRAS,Especializacoes.PSICOLOGIA_ESCOLAR));
            deboraBonfim.setGenero(Genero.FEMININO);
            deboraBonfim.setServicosOferecidos(List.of("Psicoterapia individual para adolescentes;","Psicoterapia individual para adultos;","Psicoterapia individual para mulheres negras;","Grupo Terapêutico para mulheres;","Grupo Terapêutico para mulheres negras;","Supervisão Clínica Individual ou grupal em Gestalt terapia;","Palestras/ Lives/ Reuniões de Pais e Professores;","Experiência em Psicologia Escolar."));
            deboraBonfim.setSenha("123456");
            var senhaPsicologo = new BCryptPasswordEncoder().encode(deboraBonfim.getSenha());
            deboraBonfim.setSenha(senhaPsicologo);
            deboraBonfim.setRole(UserRole.PSICOLOGO);

            psicologoRepository.save(deboraBonfim);
        }

        if (psicologoRepository.findByNumeroRegistro("06/176623") != null){
                System.out.println("Luana França");
        }else {
                Psicologo luanaFranca = new Psicologo();
                luanaFranca.setNome("Luana França");
                luanaFranca.setDescricao("Olá me chamo Luana, sou uma pessoa que estou sempre me atualizando, graduada em Psicologia pela UNIP, pós-graduada em Psicanálise Clínica pela Faculdade Metropolitana." + "Meus estudos estão direcionando em me aperfeiçoar para oferecer um atendimento de qualidade e resultado para meus pacientes que buscam ajuda para lidar com suas dificuldades." + "Tenho experiência em tratamentos nos transtornos de ansiedade, transtornos de depressão, Luto e entre outras questões emocionais.");
                luanaFranca.setEmail("luanacasademarias@gmail.com");
                luanaFranca.setNumeroRegistro("06/176623");
                luanaFranca.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/Luana.jpg");
                luanaFranca.setEspecializacoes(List.of(Especializacoes.PSICANALISE));
                luanaFranca.setGenero(Genero.FEMININO);
                luanaFranca.setServicosOferecidos(List.of("Psicoterapia Individual;","Roda de conversas;","Palestras."));
                luanaFranca.setSenha("123456");
                var senhaPsicologo = new BCryptPasswordEncoder().encode(luanaFranca.getSenha());
                luanaFranca.setSenha(senhaPsicologo);
                luanaFranca.setRole(UserRole.PSICOLOGO);

                psicologoRepository.save(luanaFranca);
            }

        if (psicologoRepository.findByNumeroRegistro("06/178319") != null){
            System.out.println("Samara Agata de Souza");
        }else{
            Psicologo samaraAgata = new Psicologo();
            samaraAgata.setNome("Samara Agata de Souza");
            samaraAgata.setDescricao("Formada em Psicologia pela Faculdades Metropolitanas Unidas(FMU), especializando em Psicologia Preta Afroperspectivada pela Universidade Federal de Delta de Parnaíba (UFDPA). Atua com a abordagem da psicanálise para os atendimentos e a perspectiva afrocentrada.");
            samaraAgata.setEmail("samaracasademarias@gmail.com");
            samaraAgata.setNumeroRegistro("06/178319");
            samaraAgata.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/Samara.jpg");
            samaraAgata.setEspecializacoes(List.of(Especializacoes.PSICOLOGIA_PRETA_AFROPERSPECTIVADA,Especializacoes.PSICOTERAPIA_ADOLESCENTES,Especializacoes.PSICOTERAPIA_CRIANCAS));
            samaraAgata.setGenero(Genero.FEMININO);
            samaraAgata.setServicosOferecidos((List.of("Atendimento para crianças e adolescentes vítimas de violência doméstica e familiar (violência física, psicológica, sexual, negligência);","Atua com crianças e adolescentes em situação de trabalho infantil e em situação de rua;","Atendimento para adolescentes que estejam em Serviço de Medida Sócio Educativa em Meio Aberto;","Atua com crianças e adolescentes em descumprimento de condicionalidades do PET;","Atendimento para famílias e indivíduos com seus direitos violados com vínculos familiares e comunitários rompidos ou não.")));
            samaraAgata.setSenha("123456");
            var senhaPsicologo = new BCryptPasswordEncoder().encode(samaraAgata.getSenha());
            samaraAgata.setSenha((senhaPsicologo));
            samaraAgata.setRole(UserRole.PSICOLOGO);

            psicologoRepository.save(samaraAgata);
        }

        if (psicologoRepository.findByNumeroRegistro("06/134511") != null){
            System.out.println("Tâmara Teixeira Calheira");
        }else{
            Psicologo tamaraTeixeira = new Psicologo();
            tamaraTeixeira.setNome("Tâmara Teixeira Calheira");
            tamaraTeixeira.setDescricao("Formada em Psicologia pela Universidade Nove de Julho e Pós graduação em Saúde Mental em equipe Multiprofissionais, pela Unip. Experiências: no atendimento clínico há cinco anos priorizando a Psicanálise e abarcando todos os perfis; Psicologia social: às famílias em situação de vulnerabilidade social, trabalho em equipe multidisciplinar, pessoas em situação de rua e grupos com mulheres.");
            tamaraTeixeira.setEmail("tamaracasademarias@gmail.com");
            tamaraTeixeira.setNumeroRegistro("06/134511");
            tamaraTeixeira.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/Tamara.jpeg");
            tamaraTeixeira.setEspecializacoes(List.of(Especializacoes.PSICANALISE,Especializacoes.PSICOLOGIA_SOCIAL));
            tamaraTeixeira.setGenero((Genero.FEMININO));
            tamaraTeixeira.setServicosOferecidos(List.of("Psicoterapia individual para adolescentes;","Psicoterapia individual para adultos;","Psicoterapia individual para idosos;","Psicoterapia individual para casais."));
            tamaraTeixeira.setSenha("123456");
            var senhaPsicologo = new BCryptPasswordEncoder().encode(tamaraTeixeira.getSenha());
            tamaraTeixeira.setSenha((senhaPsicologo));
            tamaraTeixeira.setRole(UserRole.PSICOLOGO);

            psicologoRepository.save(tamaraTeixeira);
        }


        if (tarefaRepository.findTarefaByLink("/jogodamemoria") != null || tarefaRepository.findTarefaByLink("/sudoku") != null || tarefaRepository.findTarefaByLink("/quiz") != null) {
            System.out.println("tarefas ja adicionadas");
        } else {

            Tarefa tarefa = new Tarefa();
            List<Tarefa> tarefas = new ArrayList<>();

            tarefa.setTitulo("Jogar Jogo da Memória por 10 minutos");
            tarefa.setLink("/jogodamemoria");
            tarefa.setStatus(false);
            tarefa.setFocos(List.of(Focos.ATENCAO, Focos.MEMORIA, Focos.VELOCIDADE));

            Tarefa tarefa2 = new Tarefa();

            tarefa2.setTitulo("Jogar Sudoku por 10 minutos");
            tarefa2.setLink("/sudoku");
            tarefa2.setStatus(false);
            tarefa2.setFocos(List.of(Focos.ATENCAO, Focos.RESOLUCAO_DE_PROBLEMAS));

            Tarefa tarefa3 = new Tarefa();

            tarefa3.setTitulo("Jogar Quiz por 5 minutos");
            tarefa3.setLink("/quiz");
            tarefa3.setStatus(false);
            tarefa3.setFocos(List.of(Focos.ATENCAO, Focos.VELOCIDADE));

            tarefas.add(tarefa);
            tarefas.add(tarefa2);
            tarefas.add(tarefa3);

            tarefaRepository.saveAll(tarefas);

        }


        if (!rotinaRepository.findRotinaByDiaRotina(LocalDate.of(1, 1, 1)).isEmpty()) {
            System.out.println("A rotina padrao ja existe");
        } else {
            Rotina rotinaPadrao = new Rotina();

            rotinaPadrao.setDiaRotina(LocalDate.of(1, 1, 1));
            rotinaPadrao.setStatus(false);

            Tarefa tarefamemoria = tarefaRepository.findTarefaByLink("/jogodamemoria");
            Tarefa tarefaquiz = tarefaRepository.findTarefaByLink("/quiz");

            rotinaPadrao.setTarefas(List.of(tarefamemoria, tarefaquiz));
            rotinaRepository.save(rotinaPadrao);
            Paciente vitor = pacienteRepository.findByEmail("dndragonbr@gmail.com").get();
            vitor.setRotinas(List.of(rotinaPadrao));
            pacienteRepository.save(vitor);
        }

        if (!relaxamentoRepository.findRelaxamentoByCategoria(CategoriaRelaxamento.MEDITACAO).isEmpty()) {

            System.out.println("Já foi persistido os relaxamentos");

        } else {

        Relaxamento meditacao01 = new Relaxamento();
        meditacao01.setLink("xrkeHKLBcY4?si=pqBTjexETq6WAJqQ");
        meditacao01.setCategoria(CategoriaRelaxamento.MEDITACAO);
        relaxamentoRepository.save(meditacao01);

        Relaxamento meditacao02 = new Relaxamento();
        meditacao02.setLink("xrkeHKLBcY4?si=pqBTjexETq6WAJqQ");
        meditacao02.setCategoria(CategoriaRelaxamento.MEDITACAO);
        relaxamentoRepository.save(meditacao02);

        Relaxamento meditacao03 = new Relaxamento();
        meditacao03.setLink("xrkeHKLBcY4?si=pqBTjexETq6WAJqQ");
        meditacao03.setCategoria(CategoriaRelaxamento.MEDITACAO);
        relaxamentoRepository.save(meditacao03);

        Relaxamento meditacao04 = new Relaxamento();
        meditacao04.setLink("xrkeHKLBcY4?si=pqBTjexETq6WAJqQ");
        meditacao04.setCategoria(CategoriaRelaxamento.MEDITACAO);
        relaxamentoRepository.save(meditacao04);

        Relaxamento meditacao05 = new Relaxamento();
        meditacao05.setLink("xrkeHKLBcY4?si=pqBTjexETq6WAJqQ");
        meditacao05.setCategoria(CategoriaRelaxamento.MEDITACAO);
        relaxamentoRepository.save(meditacao05);

        Relaxamento meditacao06 = new Relaxamento();
        meditacao06.setLink("xrkeHKLBcY4?si=pqBTjexETq6WAJqQ");
        meditacao06.setCategoria(CategoriaRelaxamento.MEDITACAO);
        relaxamentoRepository.save(meditacao06);

        Relaxamento meditacao07 = new Relaxamento();
        meditacao07.setLink("xrkeHKLBcY4?si=pqBTjexETq6WAJqQ");
        meditacao07.setCategoria(CategoriaRelaxamento.MEDITACAO);
        relaxamentoRepository.save(meditacao07);

        Relaxamento meditacao08 = new Relaxamento();
        meditacao08.setLink("xrkeHKLBcY4?si=pqBTjexETq6WAJqQ");
        meditacao08.setCategoria(CategoriaRelaxamento.MEDITACAO);
        relaxamentoRepository.save(meditacao08);

        Relaxamento meditacao09 = new Relaxamento();
        meditacao09.setLink("xrkeHKLBcY4?si=pqBTjexETq6WAJqQ");
        meditacao09.setCategoria(CategoriaRelaxamento.MEDITACAO);
        relaxamentoRepository.save(meditacao09);

        Relaxamento meditacao10 = new Relaxamento();
        meditacao10.setLink("xrkeHKLBcY4?si=pqBTjexETq6WAJqQ");
        meditacao10.setCategoria(CategoriaRelaxamento.MEDITACAO);
        relaxamentoRepository.save(meditacao10);
    }

        if(!relaxamentoRepository.findRelaxamentoByCategoria(CategoriaRelaxamento.YOGA).isEmpty()){
            System.out.println("Já foi persistido os dados do Yoga");
        }else {

            Relaxamento yoga01 = new Relaxamento();
            yoga01.setLink("Z_ksB-TO5GA?si=PXerSmoLICoICM3r");
            yoga01.setCategoria(CategoriaRelaxamento.YOGA);

            relaxamentoRepository.save(yoga01);


            Relaxamento yoga02 = new Relaxamento();
            yoga02.setLink("Z_ksB-TO5GA?si=PXerSmoLICoICM3r");
            yoga02.setCategoria(CategoriaRelaxamento.YOGA);
            relaxamentoRepository.save(yoga02);


            Relaxamento yoga03 = new Relaxamento();
            yoga03.setLink("Z_ksB-TO5GA?si=PXerSmoLICoICM3r");
            yoga03.setCategoria(CategoriaRelaxamento.YOGA);
            relaxamentoRepository.save(yoga03);

            Relaxamento yoga04 = new Relaxamento();
            yoga04.setLink("Z_ksB-TO5GA?si=PXerSmoLICoICM3r");
            yoga04.setCategoria(CategoriaRelaxamento.YOGA);
            relaxamentoRepository.save(yoga04);

            Relaxamento yoga05 = new Relaxamento();
            yoga05.setLink("Z_ksB-TO5GA?si=PXerSmoLICoICM3r");
            yoga05.setCategoria(CategoriaRelaxamento.YOGA);
            relaxamentoRepository.save(yoga05);

            Relaxamento yoga06 = new Relaxamento();
            yoga06.setLink("Z_ksB-TO5GA?si=PXerSmoLICoICM3r");
            yoga06.setCategoria(CategoriaRelaxamento.YOGA);
            relaxamentoRepository.save(yoga06);

            Relaxamento yoga07 = new Relaxamento();
            yoga07.setLink("Z_ksB-TO5GA?si=PXerSmoLICoICM3r");
            yoga07.setCategoria(CategoriaRelaxamento.YOGA);
            relaxamentoRepository.save(yoga07);

            Relaxamento yoga08 = new Relaxamento();
            yoga08.setLink("Z_ksB-TO5GA?si=PXerSmoLICoICM3r");
            yoga08.setCategoria(CategoriaRelaxamento.YOGA);
            relaxamentoRepository.save(yoga08);


            Relaxamento yoga09 = new Relaxamento();
            yoga09.setLink("Z_ksB-TO5GA?si=PXerSmoLICoICM3r");
            yoga09.setCategoria(CategoriaRelaxamento.YOGA);
            relaxamentoRepository.save(yoga09);

            Relaxamento yoga10 = new Relaxamento();
            yoga10.setLink("Z_ksB-TO5GA?si=PXerSmoLICoICM3r");
            yoga10.setCategoria(CategoriaRelaxamento.YOGA);
            relaxamentoRepository.save(yoga10);
        }

        if (!relaxamentoRepository.findRelaxamentoByCategoria(CategoriaRelaxamento.RESPIRACAO).isEmpty()){
            System.out.println("Já foi persistido os dados de Meditação");
        }else {
            Relaxamento respiracao01 = new Relaxamento();
            respiracao01.setLink("a1i5rgjunpw?si=-ldZIM_bbBmZq6rj");
            respiracao01.setCategoria(CategoriaRelaxamento.RESPIRACAO);

            relaxamentoRepository.save(respiracao01);

            Relaxamento respiracao02 = new Relaxamento();
            respiracao02.setLink("a1i5rgjunpw?si=-ldZIM_bbBmZq6rj");
            respiracao02.setCategoria(CategoriaRelaxamento.RESPIRACAO);

            relaxamentoRepository.save(respiracao02);

            Relaxamento respiracao03 = new Relaxamento();
            respiracao03.setLink("a1i5rgjunpw?si=-ldZIM_bbBmZq6rj");
            respiracao03.setCategoria(CategoriaRelaxamento.RESPIRACAO);

            relaxamentoRepository.save(respiracao03);

            Relaxamento respiracao04 = new Relaxamento();
            respiracao04.setLink("a1i5rgjunpw?si=-ldZIM_bbBmZq6rj");
            respiracao04.setCategoria(CategoriaRelaxamento.RESPIRACAO);

            relaxamentoRepository.save(respiracao04);

            Relaxamento respiracao05 = new Relaxamento();
            respiracao05.setLink("a1i5rgjunpw?si=-ldZIM_bbBmZq6rj");
            respiracao05.setCategoria(CategoriaRelaxamento.RESPIRACAO);

            relaxamentoRepository.save(respiracao05);

            Relaxamento respiracao06 = new Relaxamento();
            respiracao06.setLink("a1i5rgjunpw?si=-ldZIM_bbBmZq6rj");
            respiracao06.setCategoria(CategoriaRelaxamento.RESPIRACAO);

            relaxamentoRepository.save(respiracao06);

            Relaxamento respiracao07 = new Relaxamento();
            respiracao07.setLink("a1i5rgjunpw?si=-ldZIM_bbBmZq6rj");
            respiracao07.setCategoria(CategoriaRelaxamento.RESPIRACAO);

            relaxamentoRepository.save(respiracao07);

            Relaxamento respiracao08 = new Relaxamento();
            respiracao08.setLink("a1i5rgjunpw?si=-ldZIM_bbBmZq6rj");
            respiracao08.setCategoria(CategoriaRelaxamento.RESPIRACAO);

            relaxamentoRepository.save(respiracao08);

            Relaxamento respiracao09 = new Relaxamento();
            respiracao09.setLink("a1i5rgjunpw?si=-ldZIM_bbBmZq6rj");
            respiracao09.setCategoria(CategoriaRelaxamento.RESPIRACAO);

            relaxamentoRepository.save(respiracao09);

            Relaxamento respiracao10 = new Relaxamento();
            respiracao10.setLink("a1i5rgjunpw?si=-ldZIM_bbBmZq6rj");
            respiracao10.setCategoria(CategoriaRelaxamento.RESPIRACAO);

            relaxamentoRepository.save(respiracao10);
        }


        if (blogRepository.findBlogByTituloPostagem("Entenda a relação entre atividade física e saúde mental") != null){
            System.out.println("Postagens ja existem");
        }else {

            Psicologo autorPostagem = psicologoRepository.findByEmail("contato@calmomilla.org").get();

            String desc1 = "Manter uma rotina regular de atividade física é essencial não só para o corpo, mas também para a saúde mental. A Organização Mundial da Saúde (OMS) define saúde mental como parte integral do nosso bem-estar, influenciando nossa capacidade de lidar com os desafios diários."+
            " A ciência comprova que a prática regular de atividades físicas reduz sintomas de ansiedade e depressão. Exercícios aeróbicos e de resistência, feitos por 150 a 300 minutos por semana, são eficazes na melhora desses quadros."+
                    " Além de combater problemas mentais, como estresse e burnout, a atividade física eleva o humor, aumenta a autoconfiança e melhora o sono. Atividades em grupo também contribuem para a socialização e fortalecimento de vínculos."+
                    " Para começar com segurança, consulte um médico e um educador físico. Comece gradualmente, estabelecendo metas realistas e escolhendo atividades que você goste, como caminhadas, natação ou yoga. Varie os exercícios para evitar a monotonia e beneficiar diferentes grupos musculares."+
                    " Adote uma rotina de atividade física para fortalecer não só seu corpo, mas também sua saúde mental. Invista em seu bem-estar: movimente-se e sinta a diferença!"+
                    " Para mais dicas sobre abandonar o sedentarismo e construir um estilo de vida ativo, confira nosso próximo conteúdo. Lembre-se sempre de consultar um profissional de saúde para orientações personalizadas.";


            Blog blog01 = new Blog();
            blog01.setTituloPostagem("Entenda a relação entre atividade física e saúde mental");
            blog01.setDescPostagem(desc1);
            blog01.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/atividadeYoga.avif");
            blog01.setAutor(autorPostagem);
            blog01.setRevisao("Calmomilla");
            blogRepository.save(blog01);

            String desc2 = "No Brasil, onde a ansiedade é prevalente segundo a OMS, é crucial que as pessoas tenham acesso a informações sobre transtornos mentais e técnicas de relaxamento. A ansiedade, natural em situações como entrevistas ou apresentações, torna-se problemática quando persistente e incapacitante. Transtornos como TAG (Transtorno de Ansiedade Generalizada), síndrome do pânico, TOC (Transtorno Obsessivo-Compulsivo) e fobias específicas são comuns, afetando significativamente a qualidade de vida dos indivíduos Para enfrentar esses desafios, diversas técnicas de relaxamento têm se mostrado eficazes. Além das tradicionais como meditação, respiração diafragmática e yoga, o relaxamento muscular progressivo e a automassagem também ajudam a reduzir sintomas ansiosos. Estratégias simples, como mentalizar que a crise é passageira e a prática da técnica 5, 4, 3, 2, 1, que foca em estimular os sentidos para desviar a atenção da ansiedade, são úteis em momentos de agitação. A psicoterapia desempenha um papel fundamental no tratamento da ansiedade. Abordagens como a Terapia Cognitivo-Comportamental (TCC) são especialmente recomendadas por sua eficácia comprovada em ensinar estratégias de enfrentamento e modificar padrões de pensamento que alimentam a ansiedade. Através da psicoterapia, os pacientes podem explorar seus sentimentos e pensamentos de maneira estruturada, o que promove um maior autoconhecimento e capacidade de lidar com os gatilhos de ansiedade de forma consciente. Portanto, além de aprender técnicas de relaxamento para o dia a dia, é essencial buscar apoio profissional quando necessário. A combinação de métodos de autoajuda com orientação especializada pode proporcionar um caminho mais eficaz para gerenciar a ansiedade e melhorar a qualidade de vida de forma significativa. ";


            Blog blog02 = new Blog();
            blog02.setTituloPostagem("Técnicas de relaxamento para ansiedade");            String desc3 = "O autocuidado é uma prática que vai muito além de cuidar das necessidades físicas básicas. Envolve também cuidar da nossa saúde mental, emocional e espiritual. Ao reservarmos um tempo para nós mesmos, estamos reconhecendo a importância de estar bem para poder lidar com os desafios do dia a dia de forma mais eficaz e saudável." +
                    "Além das atividades físicas, como exercícios e alimentação saudável, o autocuidado inclui também o cultivo de relacionamentos positivos, o gerenciamento do estresse, o sono adequado e a busca por momentos de relaxamento e prazer. Meditar, praticar hobbies que nos inspiram, ou simplesmente desconectar das tecnologias por um tempo são maneiras poderosas de recarregar nossas energias e promover um equilíbrio interno."+
                    "Ao implementarmos essas práticas no nosso cotidiano, estamos investindo em nossa própria saúde e felicidade. O autocuidado não é egoísta, mas sim essencial para manter nossa qualidade de vida e bem-estar geral. Quando nos cuidamos, estamos capacitados a ser melhores para nós mesmos e para aqueles ao nosso redor, criando um ciclo positivo de saúde e bem-estar duradouro.";

            Blog blog03 = new Blog();
            blog03.setTituloPostagem("O que é autocuidado? Por que é tão importante?");
            blog03.setDescPostagem(desc3);
            blog03.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/9d27d913-3840-4f36-a366-41de17ee74fa.jpg");
            blog03.setAutor(autorPostagem);
            blog03.setRevisao("Calmomilla");
            blogRepository.save(blog03);



            String desc4 = "A prática regular do yoga oferece inúmeros benefícios, incluindo melhorias no sistema cardíaco e respiratório, controle do estresse e ansiedade, maior equilíbrio e fortalecimento do tônus muscular, contribuindo para a disposição e produtividade nas atividades diárias. Originária da palavra sânscrita Yuji, que significa união, o yoga é uma prática indiana que alinha corpo e mente. Patanjali foi o primeiro a reunir seus princípios na obra Yoga Sutras. As práticas de yoga incluem meditação, exercícios respiratórios e posturas específicas, proporcionando relaxamento e diversos benefícios para a saúde física e mental. No Ocidente, popularizou-se principalmente pelos asanas, posturas corporais realizadas em estabilidade e conforto." +
                    "Existem vários tipos de yoga, adaptáveis às preferências e limitações individuais. O Hatha Yoga é a forma clássica, focada em técnicas de respiração e posturas que estimulam a energia do corpo. O Vinyasa Flow Yoga é mais dinâmico, com uma boa conexão entre movimento e respiração. O Ashtanga Vinyasa Yoga é uma prática disciplinada com séries fixas de posturas e ênfase na respiração. O Hot Yoga é praticado em uma sala aquecida, promovendo grande sudorese. Já o Iyengar Yoga foca no alinhamento da postura, utilizando equipamentos para facilitar a adaptação das posturas." +
                    "Os benefícios do yoga incluem aumento da flexibilidade, melhora da respiração, diminuição do estresse, alívio da ansiedade e auxílio no tratamento da depressão. Para começar a praticar yoga, é importante buscar um profissional qualificado, vestir roupas adequadas, pesquisar sobre técnicas de respiração e posturas para iniciantes, e definir objetivos pessoais, respeitando os próprios limites." +
                    "Consultar um médico antes de iniciar a prática é essencial para garantir que o yoga seja adequado às suas condições físicas. Com o auxílio de um profissional qualificado, é possível alcançar os benefícios desejados. ";
            Blog blog04 = new Blog();
            blog04.setTituloPostagem("Conheça mais sobre a prática do yoga e seus benefícios para a saúde.");
            blog04.setDescPostagem(desc4);
            blog04.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/yoga.png");
            blog04.setAutor(autorPostagem);
            blog04.setRevisao("Calmomilla");

            blogRepository.save(blog04);

            String desc5 = "Você já pensou em como os jogos de estímulos mentais podem beneficiar sua saúde cerebral? Incorporar esses jogos à sua rotina não só oferece diversão, mas também exercita áreas cruciais do cérebro. Desafios que envolvem raciocínio, memória e concentração são essenciais para manter a mente ativa e saudável." +
                    "Primeiramente, esses jogos melhoram a memória ao estimular a memorização de padrões e informações, como quebra-cabeças e jogos de cartas. Além disso, aprimoram o raciocínio ao resolver problemas complexos em jogos de estratégia e quebra-cabeças lógicos, desenvolvendo habilidades críticas e decisórias." +
                    "Concentração também é um benefício claro. Ao focar em objetivos específicos durante o jogo, você treina a capacidade de manter a atenção por períodos mais longos, o que é fundamental em diversos aspectos da vida." +
                    "Outro ponto positivo é a redução do estresse. A atividade mental envolvente dos jogos pode diminuir os níveis de cortisol, o hormônio do estresse, proporcionando um alívio mental bem-vindo e promovendo o bem-estar geral." +
                    "Por fim, jogos de estímulos mentais não são apenas desafiadores, mas também divertidos. A diversão é crucial para o equilíbrio emocional e a saúde mental, além de ser um investimento valioso na saúde cerebral a longo prazo." +
                    "Então, que tal reservar um tempo diário para resolver palavras cruzadas, jogar Sudoku ou explorar quebra-cabeças no Calmomilla? Cuidar da mente é cuidar de si mesmo. Experimente incorporar esses jogos na sua rotina e sinta a diferença na sua capacidade mental e no seu bem-estar geral. ";
            Blog blog05 = new Blog();
            blog05.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/saude_mental.png");
            blog05.setTituloPostagem("Como jogos de estímulos mentais beneficiam sua saúde cerebral");
            blog05.setDescPostagem(desc5);
            blog05.setAutor(autorPostagem);
            blog05.setRevisao("Calmomilla");
            blogRepository.save(blog05);

            Blog blog06 = new Blog();

            String desc6 = "O mundo moderno é caótico e estamos sempre sobrecarregados de tarefas, o que não é saudável a longo prazo. O mindfulness, ou atenção plena, é uma prática que se concentra no presente, ajudando a melhorar a qualidade de vida e a saúde mental. Consiste em focar na nossa mente, sentimentos e sensações, além do ambiente ao nosso redor, e pode ser incorporada em diferentes momentos da rotina." +
                    " O mindfulness é popular atualmente devido ao ritmo frenético da vida moderna, que aumenta a busca por concentração, foco e tranquilidade. Seus benefícios incluem redução do estresse, controle dos sintomas de ansiedade e depressão, aumento da atenção e foco, melhora da produtividade e memória, promoção do autoconhecimento e otimização das relações interpessoais." +
                    " No ambiente de trabalho, o mindfulness é incentivado para melhorar a produtividade, aumentar a atenção dos colaboradores, diminuir conflitos e otimizar o trabalho em equipe. Para aderir ao mindfulness, é importante reduzir distrações, conectar-se com o mundo ao redor, dialogar com suas emoções e pensamentos, desacelerar pela manhã e à noite, e reservar um tempo para meditar. Implementar o mindfulness na rotina pode trazer significativas melhorias para a vida diária. Assine a nossa newsletter para receber mais informações relevantes! ";

            blog06.setTituloPostagem("O que é mindfulness e por que ele beneficia todas as esferas da vida?");
            blog06.setDescPostagem(desc6);
            blog06.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/meditacao.png");
            blog06.setAutor(autorPostagem);
            blog06.setRevisao("Calmomilla");

            blogRepository.save(blog06);

            Blog blog07 = new Blog();

            String desc7 ="Estamos vivenciando um envelhecimento populacional global, e a expectativa de vida aumentou graças aos avanços da medicina. A Organização Mundial da Saúde (OMS) prevê que a proporção de idosos pode dobrar até 2050. Contudo, a saúde mental dos idosos necessita de atenção especial, pois transtornos mentais e neurológicos, como demência e depressão, afetam mais de 20% das pessoas acima de 60 anos." +
                    "O envelhecimento natural leva à perda de habilidades motoras e mentais, aumentando a dependência e a suscetibilidade a transtornos mentais. Fatores de risco incluem doenças físicas, luto, dificuldades socioeconômicas e abuso, além de predisposições genéticas para doenças neurodegenerativas. A depressão, muitas vezes subdiagnosticada, é comum e pode resultar em isolamento e perda de autoestima. A demência, especialmente o Alzheimer, causa declínio cognitivo significativo e é frequentemente confundida com o envelhecimento normal." +
                    "Para identificar problemas, é crucial observar sinais como tristeza persistente, falta de motivação, excesso de preocupações e perda de memória. O diagnóstico é realizado por especialistas baseando-se na história clínica, exames físicos e, se necessário, exames complementares." +
                    "Cuidar da saúde mental na terceira idade envolve cultivar hábitos saudáveis, manter interações sociais e se sentir parte de um grupo. O conceito de envelhecimento ativo da OMS promove a participação contínua dos idosos em questões sociais e culturais, buscando uma maior inclusão social. Políticas públicas são essenciais para criar condições de vida que apoiem o bem-estar dos idosos." +
                    "Compartilhe essas informações com amigos e familiares e assine nossa newsletter para se manter atualizado sobre novidades em nosso blog.";

            blog07.setTituloPostagem("Confira os cuidados essenciais com a saúde mental na melhor idade");
            blog07.setDescPostagem(desc7);
            blog07.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/veios.png");
            blog07.setAutor(autorPostagem);
            blog07.setRevisao("Calmomilla");

            blogRepository.save(blog07);
            Blog blog08 = new Blog();

            String desc8 ="A adolescência é um período de intensas transformações físicas, psicológicas e sociais, situando-se entre a infância e a idade adulta. Esse estágio, que envolve autoconhecimento e interações sociais, é caracterizado por rápido crescimento físico, cognitivo e psicossocial, afetando a forma como os jovens pensam, tomam decisões e interagem com o mundo. Segundo a OMS, 1,2 bilhão de pessoas no mundo são adolescentes, e esse número deve crescer até 2050, especialmente em países de baixa e média renda. Anualmente, mais de 1 milhão de adolescentes morrem por causas evitáveis, como violência, suicídio e acidentes de trânsito." +
                    "A adolescência é dividida em três fases: pré-adolescência (10-14 anos), adolescência (15-17 anos) e juventude (18-24 anos). A pré-adolescência é marcada pelo início da puberdade e maturação sexual, enquanto a adolescência envolve conflitos e dúvidas pela transição para a vida adulta. A juventude marca o desenvolvimento completo e a entrada na vida adulta."+
                    "Esse período pode afetar a saúde mental dos jovens, que frequentemente enfrentam autocrítica exacerbada, baixa autoestima, flutuações de humor e a busca por independência. A interação social pode gerar desafios adicionais, como bullying e risco de envolvimento com drogas e álcool. A depressão e o suicídio são problemas graves nessa faixa etária, tornando crucial o apoio socioemocional familiar e escolar"+
                    "Para apoiar a saúde mental dos adolescentes, pais e responsáveis devem ser bons exemplos, incentivar reflexões sobre decisões, ser empáticos, e manter um diálogo aberto. Além disso, consultas médicas periódicas são recomendadas para monitorar a saúde física e mental, prevenir sobrepeso e obesidade, e promover a educação sobre saúde sexual e reprodutiva."+
                    "A vacinação também é crucial, especialmente contra o HPV, que é recomendada para meninas de 9 a 14 anos e meninos de 11 a 14 anos. A prevenção de ISTs, o incentivo ao uso de preservativos, e a educação sobre os riscos do uso de substâncias são fundamentais para garantir a saúde dos adolescentes. Para mais informações, sempre busque orientação médica.";


            blog08.setTituloPostagem("Como cuidar da saúde de jovens e adolescentes?");
            blog08.setDescPostagem(desc8);
            blog08.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/adolecentes.png");
            blog08.setAutor(autorPostagem);
            blog08.setRevisao("Calmomilla");

            blogRepository.save(blog08);
            blog02.setDescPostagem(desc2);
            blog02.setFoto("https://calmomilla-fotos.s3.sa-east-1.amazonaws.com/fotoRelaxando.avif");
            blog02.setAutor(autorPostagem);
            blog02.setRevisao("Calmomilla");
            blogRepository.save(blog02);




        }

        System.out.println("Dados inseridos nas tabelas com sucesso!");
    }
}
