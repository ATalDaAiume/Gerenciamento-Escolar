import java.util.Scanner;
 
public class MenuEscola {
    public static void main(String[] args) {
        System.out.println("MenuEscola");
        Scanner scanner = new Scanner(System.in);
        int opt = 0;
 
        do {
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Cadastrar Curso");
            System.out.println("3 - Cadastrar Aluno");
            System.out.println("4 - Listar Professores");
            System.out.println("5 - Listar Cursos");
            System.out.println("6 - Listar Alunos");
            System.out.println("7 - Sair");
           
            try {
                opt = scanner.nextInt();
            } catch (Exception e) {
                opt = 0;
            }
 
            switch (opt) {
                case 1:
                    try {
                        System.out.println("Digite Nome");
                        System.out.println("Digite o id do Professor: ");
                        int idProfessor = scanner.nextInt();
                        System.out.println("Digite o Departamento do Professor: ");
                        String departamento = scanner.next();
                        new Professor(idProfessor, departamento);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar o Professor");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Cadastrar Curso");
                        System.out.println("Digite o id do Curso: ");
                        int idCurso = scanner.nextInt();
                        System.out.println("Digite o Nome do Curso: ");
                        String nome = scanner.next();
                        System.out.println("Digite as Horas do Curso: ");
                        String horas = scanner.next();
                        System.out.println("Digite o Professor do Curso: ");
                        String professor = scanner.next();
                        new Curso(idCurso, nome, horas, professor);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar o Curso");
                    }
                   
                    break;
                case 3:
                    try {
                        System.out.println("Cadastrar Aluno");
                        System.out.println("Digite o id do Aluno: ");
                        int idAnimal = scanner.nextInt();
                        System.out.println("Digite o nome do Aluno: ");
                        String nome = scanner.next();
                        System.out.println("Digite a data de nascimento do Aluno: ");
                        String raca = scanner.next();
                        System.out.println("Digite o CPF do Aluno: ");
                        double peso = scanner.nextDouble();
                        System.out.println("Digite o id do Curso: ");
                        int idCurso = scanner.nextInt();
                        Curso.verificaId(idCurso);
                        Curso curso = Curso.buscaCurso(idCurso);
                        System.out.println("Digite o id da categoria: ");
                        int idCategoria = scanner.nextInt();
                        Categoria.verificaId(idCategoria);
                        Categoria categoria = Categoria.buscaCategoria(idCategoria);
                        new Animal(idAnimal, nome, raca, peso, idTutor, idCategoria);
 
                        // new Animal(idAnimal, nome, raca, peso, tutor, categoria);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar o animal. " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Listar Categorias");
                    for (Categoria categoria : Categoria.categorias) {
                        System.out.println("Id: " + categoria.id + " Descrição: " + categoria.descricao + " Animais: " + Animal.contarAnimaisPorCategoria(categoria.id));
                    }
                    break;
                case 5:
                    System.out.println("Listar Tutores");
                    for (Tutor tutor : Tutor.tutores) {
                        System.out.println("Id: " + tutor.id + " Nome: " + tutor.nome + " Telefone: " + tutor.telefone + " Email: " + tutor.email + " Animais: " + Animal.contarAnimaisPorTutor(tutor.id));
                    }
                    break;
                case 6:
                    System.out.println("Listar Animais");
                    for (Animal animal : Animal.animais) {
                        System.out.println("Id: " + animal.id + " Nome: " + animal.nome + " Raça: " + animal.raca + " Peso: " + animal.peso + " Tutor: " + Tutor.buscaTutor(animal.idTutor).nome + " Categoria: " + Categoria.buscaCategoria(animal.idCategoria).descricao);
 
                        // System.out.println("Id: " + animal.id + " Nome: " + animal.nome + " Raça: " + animal.raca + " Peso: " + animal.peso + " Tutor: " + animal.tutor.nome + " Categoria: " + animal.categoria.descricao);
                    }
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opt != 7);
 
        scanner.close();
    }
}