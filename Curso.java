import java.util.ArrayList;

public class Curso {
    
    int id;
    String nome;
    int horas;
    int idProfessor;

    Professor professor;

    static ArrayList<Curso> cursos = new ArrayList<>();
    
    public Curso(int id, String nome, int horas, int idProfessor) {
        this.id = id;
        this.nome = nome;
        this.horas = horas;
        this.idProfessor = idProfessor;

        cursos.add(this);
    }

    public Curso(int id, String nome, int horas, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.horas = horas;
        this.professor = professor;

        cursos.add(this);
    }

    static int contarCursosPorProfessor(int idProfessor) {
        int cont = 0;
        for (Curso curso : cursos) {
            if (curso.idProfessor == idProfessor) {
                cont++;
            }
        }
        return cont;
    }
}
