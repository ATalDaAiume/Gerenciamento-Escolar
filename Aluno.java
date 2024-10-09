import java.util.ArrayList;

public class Aluno {
    
    // Atributos do aluno
    int id;
    String nome;
    String nascimento;
    String CPF;
    int idCurso;

    Curso curso; // Referência ao curso do aluno

    // Lista estática que armazena todos os alunos criados
    static ArrayList<Aluno> alunos = new ArrayList<>();
    
    // Construtor que inicializa o aluno com um ID de curso
    public Aluno(int id, String nome, String nascimento, String CPF, int idCurso) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.CPF = CPF;
        this.idCurso = idCurso;

        // Adiciona o aluno à lista de alunos
        alunos.add(this);
    }

    // Construtor alternativo que recebe diretamente um objeto Curso
    public Aluno(int id, String nome, String nascimento, String CPF, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.CPF = CPF;
        this.curso = curso;

        // Adiciona o aluno à lista de alunos
        alunos.add(this);
    }

    // Método estático que conta quantos alunos estão em um determinado curso
    static int contarAlunosPorCurso(int idCurso) {
        int cont = 0;
        for (Aluno aluno : alunos) {
            // Verifica se o ID do curso do aluno corresponde ao ID fornecido
            if (aluno.idCurso == idCurso) {
                cont++;
            }
        }
        return cont;
    }
}
