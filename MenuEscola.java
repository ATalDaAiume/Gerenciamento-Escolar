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
                        System.out.println("Cadastrar Categoria");
                        System.out.println("Digite o id da categoria: ");
                        int idCategoria = scanner.nextInt();
                        System.out.println("Digite a descrição da categoria: ");
                        String descricao = scanner.next();
                        new Categoria(idCategoria, descricao);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar a categoria");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Cadastrar Tutor");
                        System.out.println("Digite o id do tutor: ");
                        int idTutor = scanner.nextInt();
                        System.out.println("Digite o nome do tutor: ");
                        String nome = scanner.next();
                        System.out.println("Digite o telefone do tutor: ");
                        String telefone = scanner.next();
                        System.out.println("Digite o email do tutor: ");
                        String email = scanner.next();
                        new Tutor(idTutor, nome, telefone, email);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar o tutor");
                    }
                    
                    break;
                case 3:
                    try {
                        System.out.println("Cadastrar Animal");
                        System.out.println("Digite o id do animal: ");
                        int idAnimal = scanner.nextInt();
                        System.out.println("Digite o nome do animal: ");
                        String nome = scanner.next();
                        System.out.println("Digite a raça do animal: ");
                        String raca = scanner.next();
                        System.out.println("Digite o peso do animal: ");
                        double peso = scanner.nextDouble();
                        System.out.println("Digite o id do tutor: ");
                        int idTutor = scanner.nextInt();
                        Tutor.verificaId(idTutor);
                        Tutor tutor = Tutor.buscaTutor(idTutor);
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
