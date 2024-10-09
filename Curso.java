import java.util.ArrayList;

public class Curso {

    // Atributos do curso
    int id;
    String nome;
    int horas;
    int idProfessor;

    Professor professor; // Referência ao professor responsável pelo curso

    // Lista estática que armazena todos os cursos criados
    static ArrayList<Curso> cursos = new ArrayList<>();
    
    // Construtor que inicializa o curso com um ID de professor
    public Curso(int id, String nome, int horas, int idProfessor) {
        this.id = id;
        this.nome = nome;
        this.horas = horas;
        this.idProfessor = idProfessor;

        // Adiciona o curso à lista de cursos
        cursos.add(this);
    }

    // Construtor alternativo que recebe diretamente um objeto Professor
    public Curso(int id, String nome, int horas, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.horas = horas;
        this.professor = professor;

        // Adiciona o curso à lista de cursos
        cursos.add(this);
    }

    // Método estático para buscar um curso pelo seu ID
    static Curso buscaCurso(int id) {
        for (Curso curso : cursos) {
            // Se encontrar o curso com o ID correspondente, retorna o curso
            if (curso.id == id) {
                return curso;
            }
        }
        return null; // Retorna null se o curso não for encontrado
    }

    // Método estático que conta quantos cursos são ministrados por um professor específico
    static int contarCursosPorProfessor(int idProfessor) {
        int cont = 0;
        for (Curso curso : cursos) {
            // Verifica se o ID do professor do curso corresponde ao ID fornecido
            if (curso.idProfessor == idProfessor) {
                cont++;
            }
        }
        return cont;
    }
}
