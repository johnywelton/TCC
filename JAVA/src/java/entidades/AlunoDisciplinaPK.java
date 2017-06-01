/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jwojs
 */
@Embeddable
public class AlunoDisciplinaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "iddisciplina")
    private int iddisciplina;
    @Basic(optional = false)
    @Column(name = "idaluno")
    private int idaluno;

    public AlunoDisciplinaPK() {
    }

    public AlunoDisciplinaPK(int iddisciplina, int idaluno) {
        this.iddisciplina = iddisciplina;
        this.idaluno = idaluno;
    }

    public int getIddisciplina() {
        return iddisciplina;
    }

    public void setIddisciplina(int iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public int getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(int idaluno) {
        this.idaluno = idaluno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iddisciplina;
        hash += (int) idaluno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoDisciplinaPK)) {
            return false;
        }
        AlunoDisciplinaPK other = (AlunoDisciplinaPK) object;
        if (this.iddisciplina != other.iddisciplina) {
            return false;
        }
        if (this.idaluno != other.idaluno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AlunoDisciplinaPK[ iddisciplina=" + iddisciplina + ", idaluno=" + idaluno + " ]";
    }
    
}
