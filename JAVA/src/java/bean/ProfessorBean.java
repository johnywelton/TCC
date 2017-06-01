package bean;

import entidades.Professor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import util.JpaUtil;

/**
 *
 * @author Johny
 */
@ManagedBean
@ViewScoped
public class ProfessorBean {

    private Professor professor = new Professor();
    private List<Professor> professores = new ArrayList<>();
    
    public ProfessorBean() {
    }
    
    @PostConstruct
    public void init(){
        listarTodas();
    }
    
    public void salvar(){
        //validação aqui
        salvar(professor);
        listarTodas();
        novo();
    }
    
    public void novo(){
        this.professor = new Professor();
    }
    
    public void selecionar(Professor professor){
        this.professor = professor;
    }
    
    public void apagar(Professor professor){
        remover(professor);
        listarTodas();
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }
    
    private void listarTodas() {
        EntityManager manager = JpaUtil.getManager();
        professores = manager.createQuery("select p from Professor p", Professor.class).getResultList();
        JpaUtil.closeManager(manager);
    }

    private void salvar(Professor professor) {
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        this.professor = manager.merge(professor);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
    }
    
    private void remover(Professor professor) {
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        professor = manager.find(Professor.class, professor.getIdprofessor());
        manager.remove(professor);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
    }
    
}
