/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jwojs
 */
@Entity
@Table(name = "disciplina")
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d")
    , @NamedQuery(name = "Disciplina.findByIddisciplina", query = "SELECT d FROM Disciplina d WHERE d.iddisciplina = :iddisciplina")
    , @NamedQuery(name = "Disciplina.findByDescricao", query = "SELECT d FROM Disciplina d WHERE d.descricao = :descricao")})
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddisciplina")
    private Integer iddisciplina;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @JoinTable(name = "professor_disciplina", joinColumns = {
        @JoinColumn(name = "iddisciplina", referencedColumnName = "iddisciplina")}, inverseJoinColumns = {
        @JoinColumn(name = "idprofessor", referencedColumnName = "idprofessor")})
    @ManyToMany
    private List<Professor> professorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<AlunoDisciplina> alunoDisciplinaList;
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso")
    @ManyToOne(optional = false)
    private Curso idcurso;

    public Disciplina() {
        if (idcurso == null) {
            idcurso = new Curso();
        }
    }

    public Disciplina(Integer iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public Disciplina(Integer iddisciplina, String descricao) {
        this.iddisciplina = iddisciplina;
        this.descricao = descricao;
    }

    public Integer getIddisciplina() {
        return iddisciplina;
    }

    public void setIddisciplina(Integer iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Professor> getProfessorList() {
        return professorList;
    }

    public void setProfessorList(List<Professor> professorList) {
        this.professorList = professorList;
    }

    public List<AlunoDisciplina> getAlunoDisciplinaList() {
        return alunoDisciplinaList;
    }

    public void setAlunoDisciplinaList(List<AlunoDisciplina> alunoDisciplinaList) {
        this.alunoDisciplinaList = alunoDisciplinaList;
    }

    public Curso getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Curso idcurso) {
        this.idcurso = idcurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddisciplina != null ? iddisciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.iddisciplina == null && other.iddisciplina != null) || (this.iddisciplina != null && !this.iddisciplina.equals(other.iddisciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Disciplina[ iddisciplina=" + iddisciplina + " ]";
    }
    
}
