import java.util.ArrayList;

public class Aluno {
    
    int id;
    String nome;
    String nascimento;
    String CPF;
    int idCurso;

    Curso curso;

    static ArrayList<Aluno> Alunos = new ArrayList<>();
    
    public Aluno(int id, String nome, String nascimento, String CPF, int idCurso) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.CPF = CPF;
        this.idCurso = idCurso;

        Alunos.add(this);
    }

    public Aluno(int id, String nome, String nascimento, String CPF, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.CPF = CPF;
        this.curso = curso;

        Alunos.add(this);
    }

    static int contarAlunosPorCurso(int idCurso) {
        int cont = 0;
        for (Aluno aluno : Alunos) {
            if (aluno.idCurso == idCurso) {
                cont++;
            }
        }
        return cont;
    }
}
