import java.util.ArrayList;

public class Professor {

    // Atributos do professor
    int id;
    String nome;
    String departamento;

    // Lista estática que armazena todos os professores criados
    static ArrayList<Professor> professores = new ArrayList<>();

    // Construtor que inicializa o professor
    public Professor(int id, String nome, String departamento) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;

        // Adiciona o professor à lista de professores
        professores.add(this);
    }

    // Método estático que verifica se um professor com determinado ID existe
    static void verificaId(int id) throws Exception {
        for (Professor professor : professores) {
            // Se o professor com o ID fornecido for encontrado, a função retorna sem erro
            if (professor.id == id) {
                return;
            }
        }
        // Se não encontrar o professor, lança uma exceção
        throw new Exception("Professor não encontrado");
    }

    // Método estático que busca um professor pelo ID
    static Professor buscaProfessor(int id) {
        for (Professor professor : professores) {
            // Se encontrar o professor com o ID correspondente, retorna o professor
            if (professor.id == id) {
                return professor;
            }
        }
        return null; // Retorna null se o professor não for encontrado
    }
}
