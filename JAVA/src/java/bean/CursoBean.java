package bean;

import entidades.Curso;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import util.JpaUtil;

@ManagedBean
@SessionScoped
public class CursoBean {

    private Curso curso = new Curso();
    private List<Curso> cursos = new ArrayList<>();
    
    public CursoBean() {
    }
    
    @PostConstruct
    public void init(){
        listarTodas();
    }
    
    public void salvar(){
        //validação aqui
        salvar(curso);
        listarTodas();
        novo();
    }
    
    public void selecionar(Curso curso){
        this.curso = curso;
    }
    
    public void apagar(Curso curso){
        remover(curso);
        listarTodas();
    }
    
    public void novo(){
        this.curso = new Curso();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    private void listarTodas() {
        EntityManager manager = JpaUtil.getManager();
        cursos = manager.createQuery("select c from Curso c", Curso.class).getResultList();
        JpaUtil.closeManager(manager);
    }
    
    private void salvar(Curso curso) {
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        this.curso = manager.merge(curso);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
    }
    
    private void remover(Curso curso) {
        EntityManager manager = JpaUtil.getManager();
        manager.getTransaction().begin();
        curso = manager.find(Curso.class, curso.getIdcurso());
        manager.remove(curso);
        manager.getTransaction().commit();
        JpaUtil.closeManager(manager);
    }
    
        
}
