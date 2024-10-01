import java.util.ArrayList;

public class Professor {

    int id;
    String nome;
    String departamento;

    static ArrayList<Professor> professores = new ArrayList<>();

    public Professor(int id, String nome, String departamento) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;

        professores.add(this);
    }

    static void verificaId(int id) throws Exception {
        for (Professor professor : professores) {
            if (professor.id == id) {
                return;
            }
        }
        throw new Exception("Professor não encontrado");
    }

    static Professor buscaProfessor(int id) {
        for (Professor professor : professores) {
            if (professor.id == id) {
                return professor;
            }
        }
        return null;
    }
    
}
