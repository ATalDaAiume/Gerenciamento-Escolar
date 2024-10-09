import java.util.Scanner;

public class MenuEscola {
    public static void main(String[] args) {
        System.out.println("Menu Escola");
        Scanner scanner = new Scanner(System.in);  // Criando um Scanner para entrada de dados
        int opt = 0;  // Variável que guarda a opção selecionada pelo usuário

        do {
            // Exibição das opções do menu
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Cadastrar Curso");
            System.out.println("3 - Cadastrar Aluno");
            System.out.println("4 - Listar Professores");
            System.out.println("5 - Listar Cursos");
            System.out.println("6 - Listar Alunos");
            System.out.println("7 - Sair");

            try {
                // Tentando capturar a opção escolhida pelo usuário
                opt = scanner.nextInt();
            } catch (Exception e) {
                opt = 0;  // Se o usuário digitar um valor inválido, a opção será 0
            }

            // Switch para tratar cada opção do menu
            switch (opt) {
                case 1:
                    try {
                        // Cadastro de professor
                        System.out.println("Cadastre Professor");
                        System.out.println("Digite o Id do Professor: ");
                        int idProfessor = scanner.nextInt();
                        System.out.println("Digite o Nome do Professor: ");
                        String nome = scanner.next();
                        System.out.println("Digite o Departamento do Professor: ");
                        String departamento = scanner.next();
                        // Criação de um novo objeto Professor
                        new Professor(idProfessor, nome, departamento);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar o Professor");
                    }
                    break;
                case 2:
                    try {
                        // Cadastro de curso
                        System.out.println("Cadastrar Curso");
                        System.out.println("Digite o Id do Curso: ");
                        int idCurso = scanner.nextInt();
                        System.out.println("Digite o Nome do Curso: ");
                        String nome = scanner.next();
                        System.out.println("Digite as Horas do Curso: ");
                        int horas = scanner.nextInt();
                        System.out.println("Digite o Id do Professor do Curso: ");
                        int idProfessor = scanner.nextInt();
                        // Criação de um novo objeto Curso
                        new Curso(idCurso, nome, horas, idProfessor);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar o Curso");
                    }
                    break;
                case 3:
                    try {
                        // Cadastro de aluno
                        System.out.println("Cadastrar Aluno");
                        System.out.println("Digite o Id do Aluno: ");
                        int idAluno = scanner.nextInt();
                        System.out.println("Digite o Nome do Aluno: ");
                        String nome = scanner.next();
                        System.out.println("Digite a Data de Nascimento do Aluno: ");
                        String nascimento = scanner.next();
                        System.out.println("Digite o CPF do Aluno: ");
                        String CPF = scanner.next();
                        System.out.println("Digite o Id do Curso: ");
                        int idCurso = scanner.nextInt();
                        // Verifica se o curso existe
                        Curso curso = Curso.buscaCurso(idCurso);
                        if (curso == null) {
                            throw new Exception("Curso não encontrado");
                        }
                        // Criação de um novo objeto Aluno
                        new Aluno(idAluno, nome, nascimento, CPF, idCurso);

                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar o Aluno. " + e.getMessage());
                    }
                    break;
                case 4:
                    // Listar todos os professores
                    System.out.println("Listar Professores");
                    for (Professor professor : Professor.professores) {
                        // Contando cursos e alunos por professor
                        int cursosPorProfessor = Curso.contarCursosPorProfessor(professor.id);
                        int alunosPorCurso = Aluno.contarAlunosPorCurso(professor.id);
                        // Exibição das informações dos professores
                        System.out.println("Nome: " + professor.nome + " Departamento: " + professor.departamento +
                                           " Cursos: " + cursosPorProfessor + " Alunos: " + alunosPorCurso);
                    }
                    break;
                case 5:
                    // Listar todos os cursos
                    System.out.println("Listar Cursos");
                    for (Curso curso : Curso.cursos) {
                        // Buscando o professor responsável pelo curso
                        Professor professor = Professor.buscaProfessor(curso.idProfessor);
                        String nomeProfessor = professor != null ? professor.nome : "Professor não encontrado";
                        // Exibição das informações dos cursos
                        System.out.println("Nome: " + curso.nome + " Carga Horária: " + curso.horas + " Nome do Professor: " + nomeProfessor);
                    }
                    break;
                case 6:
                    // Listar todos os alunos
                    System.out.println("Listar Alunos");
                    for (Aluno aluno : Aluno.alunos) {
                        // Buscar o curso pelo ID do aluno
                        Curso curso = Curso.buscaCurso(aluno.idCurso);
                        String nomeCurso = (curso != null) ? curso.nome : "Curso não encontrado";
                        // Exibição dos dados do aluno e o nome do curso
                        System.out.println("Nome: " + aluno.nome + " Data de Nascimento: " + aluno.nascimento + " CPF: " + aluno.CPF + " Curso: " + nomeCurso);
                    }
                    break;                
                case 7:
                    // Finalizando o programa
                    System.out.println("Saindo...");
                    break;
                default:
                    // Tratamento de opção inválida
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opt != 7);  // O loop continua até que o usuário escolha a opção de sair (7)

        scanner.close();  // Fechando o scanner para liberar os recursos
    }
}