/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postoapplication.model;

import java.util.Date;

/**
 *
 * @author mathe
 */
public class Fornecedor {
    private int codigo;
    private String nome;
    private String cpfcnpj;
    private String fone;
    private String endereco;
    private Date dtrecord;
    private Date dtupdate;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDtrecord() {
        return dtrecord;
    }

    public void setDtrecord(Date dtrecord) {
        this.dtrecord = dtrecord;
    }

    public Date getDtupdate() {
        return dtupdate;
    }

    public void setDtupdate(Date dtupdate) {
        this.dtupdate = dtupdate;
    }

    @Override
    public String toString() {
        return codigo +" - "+ nome;
    }
    
}
