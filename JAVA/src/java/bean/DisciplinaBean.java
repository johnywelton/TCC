package bean;

import entidades.Disciplina;
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
public class DisciplinaBean {

    /**
     * Creates a new instance of DisciplinaBean
     */
    private Disciplina disciplina = new Disciplina();
    private List<Disciplina> disciplinas = new ArrayList<>();
    
    public DisciplinaBean() {
    }
    
    @PostConstruct
    public void init(){
        listarTodas();
    }
    
    public void salvar(){
        //validação aqui
        salvar(disciplina);
        listarTodas();
        novo();
    }
    
    public void novo(){
        this.disciplina = new Disciplina();
    }
    
    public void selecionar(Disciplina disciplina){
        this.disciplina = disciplina;
    }
    
    public void apagar(Disciplina disciplina){
        remover(disciplina);
        listarTodas();
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    private void listarTodas() {
        EntityManager manager = JpaUtil.getManager();
        disciplinas = manager.createQuery("select d from Disciplina d", Disciplina.class).getResultList();
        JpaUtil.closeManager(manager);
    }

    private void salvar(Disciplina disciplina) {
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        this.disciplina = manager.merge(disciplina);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
    }
    
    private void remover(Disciplina disciplina) {
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        disciplina = manager.find(Disciplina.class, disciplina.getIddisciplina());
        manager.remove(disciplina);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
    }
    
}
