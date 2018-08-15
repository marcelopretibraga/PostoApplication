/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postoapplication.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author marcelo.braga
 */
public class NotaFiscal extends Record{
    private int codigo; 
    private int numeroNota;
    private String serie;
    private Cliente cliente; 
    private Date dataEmissao;
    private Double valorTotal;
    private List<ItemNF> itensNF;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(int numeroNota) {
        this.numeroNota = numeroNota;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemNF> getItensNF() {
        return itensNF;
    }

    public void setItensNF(List<ItemNF> itensNF) {
        this.itensNF = itensNF;
    }
    
    @Override
    public String toString() {
        return codigo + " - " + numeroNota + " - "+serie; 
    }
    
}
