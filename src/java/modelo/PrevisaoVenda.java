/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author EMPRESA
 */
@Entity
@Table(name = "previsao_venda")
@NamedQueries({
    @NamedQuery(name = "PrevisaoVenda.findAll", query = "SELECT p FROM PrevisaoVenda p")})
public class PrevisaoVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprevisao_venda")
    private Integer idprevisaoVenda;
    @Column(name = "total")
    private String total;
    @Column(name = "nome_usuario")
    private String nomeUsuario;
    @Column(name = "nome_produto")
    private String nomeProduto;

    public PrevisaoVenda() {
    }

    public PrevisaoVenda(Integer idprevisaoVenda) {
        this.idprevisaoVenda = idprevisaoVenda;
    }

    public Integer getIdprevisaoVenda() {
        return idprevisaoVenda;
    }

    public void setIdprevisaoVenda(Integer idprevisaoVenda) {
        this.idprevisaoVenda = idprevisaoVenda;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprevisaoVenda != null ? idprevisaoVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrevisaoVenda)) {
            return false;
        }
        PrevisaoVenda other = (PrevisaoVenda) object;
        if ((this.idprevisaoVenda == null && other.idprevisaoVenda != null) || (this.idprevisaoVenda != null && !this.idprevisaoVenda.equals(other.idprevisaoVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PrevisaoVenda[ idprevisaoVenda=" + idprevisaoVenda + " ]";
    }
    
}
