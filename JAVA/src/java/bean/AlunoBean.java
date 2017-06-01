package bean;

import entidades.Aluno;
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
public class AlunoBean {

    private Aluno aluno = new Aluno();
    private List<Aluno> alunos = new ArrayList<>();
    
    
    public AlunoBean() {
    }
    
    @PostConstruct
    public void init(){
        listarTodas();
    }

    public void salvar(){
        //validação aqui
        salvar(aluno);
        listarTodas();
        novo();
    }
    
    public void novo(){
        this.aluno = new Aluno();
    }
    
    public void selecionar(Aluno aluno){
        this.aluno = aluno;
    }
    
    public void apagar(Aluno aluno){
        remover(aluno);
        listarTodas();
    }
       
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    private void listarTodas() {
        EntityManager manager = JpaUtil.getManager();
        alunos = manager.createQuery("select a from Aluno a", Aluno.class).getResultList();
        JpaUtil.closeManager(manager);
    }
    
    private void salvar(Aluno aluno) {
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        this.aluno = manager.merge(aluno);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
    }
    
    private void remover(Aluno aluno) {
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        aluno = manager.find(Aluno.class, aluno.getIdaluno());
        manager.remove(aluno);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
    }
    
}
