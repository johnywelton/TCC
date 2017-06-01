/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jwojs
 */
@Entity
@Table(name = "aluno_disciplina")
@NamedQueries({
    @NamedQuery(name = "AlunoDisciplina.findAll", query = "SELECT a FROM AlunoDisciplina a")
    , @NamedQuery(name = "AlunoDisciplina.findByIddisciplina", query = "SELECT a FROM AlunoDisciplina a WHERE a.alunoDisciplinaPK.iddisciplina = :iddisciplina")
    , @NamedQuery(name = "AlunoDisciplina.findByIdaluno", query = "SELECT a FROM AlunoDisciplina a WHERE a.alunoDisciplinaPK.idaluno = :idaluno")
    , @NamedQuery(name = "AlunoDisciplina.findByNota1", query = "SELECT a FROM AlunoDisciplina a WHERE a.nota1 = :nota1")
    , @NamedQuery(name = "AlunoDisciplina.findByNota2", query = "SELECT a FROM AlunoDisciplina a WHERE a.nota2 = :nota2")})
public class AlunoDisciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlunoDisciplinaPK alunoDisciplinaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota1")
    private Double nota1;
    @Column(name = "nota2")
    private Double nota2;
    @JoinColumn(name = "idaluno", referencedColumnName = "idaluno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aluno aluno;
    @JoinColumn(name = "iddisciplina", referencedColumnName = "iddisciplina", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;

    public AlunoDisciplina() {
    }

    public AlunoDisciplina(AlunoDisciplinaPK alunoDisciplinaPK) {
        this.alunoDisciplinaPK = alunoDisciplinaPK;
    }

    public AlunoDisciplina(int iddisciplina, int idaluno) {
        this.alunoDisciplinaPK = new AlunoDisciplinaPK(iddisciplina, idaluno);
    }

    public AlunoDisciplinaPK getAlunoDisciplinaPK() {
        return alunoDisciplinaPK;
    }

    public void setAlunoDisciplinaPK(AlunoDisciplinaPK alunoDisciplinaPK) {
        this.alunoDisciplinaPK = alunoDisciplinaPK;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alunoDisciplinaPK != null ? alunoDisciplinaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoDisciplina)) {
            return false;
        }
        AlunoDisciplina other = (AlunoDisciplina) object;
        if ((this.alunoDisciplinaPK == null && other.alunoDisciplinaPK != null) || (this.alunoDisciplinaPK != null && !this.alunoDisciplinaPK.equals(other.alunoDisciplinaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AlunoDisciplina[ alunoDisciplinaPK=" + alunoDisciplinaPK + " ]";
    }
    
}
