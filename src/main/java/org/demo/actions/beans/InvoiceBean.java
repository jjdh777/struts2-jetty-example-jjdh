package org.demo.actions.beans;

import java.util.Date;

public class InvoiceBean {

    private String subject;
    private Date dateFrom;
    private Date dateTo;
    private Float importeBruto;
    private Float tipoIva;

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Float getImporteBruto() {
        return importeBruto;
    }

    public void setImporteBruto(Float importeBruto) {
        this.importeBruto = importeBruto;
    }

    public Float getTipoIva() {
        return tipoIva;
    }

    public void setTipoIva(Float tipoIva) {
        this.tipoIva = tipoIva;
    }
    // Funciones de Validación
    public boolean isNullImporteBruto(){
        if (this.importeBruto==null) {
            return true;}
        {
            return false;
        }
    }
    public boolean isNullTipoIva(){
        if (this.tipoIva==null) {
            return true;}
        {
            return false;
        }
    }
    public boolean isNullDateTo(){
        if (this.dateTo==null) {
            return true;}
        {
            return false;
        }
    }
    public boolean isNullDateFrom(){
        if (this.dateFrom==null) {
            return true;}
        {
            return false;
        }
    }



}
