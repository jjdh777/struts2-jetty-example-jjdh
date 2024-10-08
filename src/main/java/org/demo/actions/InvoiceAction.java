package org.demo.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.ObjectUtils;
import org.demo.actions.beans.InvoiceBean;

public class InvoiceAction extends ActionSupport  {

    InvoiceBean invoiceBean;

    @Override
    public String execute() throws Exception {
        System.out.println("execute!!");
        float importe = invoiceBean.getImporteBruto();
        float iva = invoiceBean.getTipoIva();
        float total = importe + (importe * iva / 100);
        invoiceBean.setImporteTotal(total);
        return SUCCESS;
    }

    public InvoiceBean getInvoiceBean() {
        return invoiceBean;
    }

    public void setInvoiceBean(InvoiceBean invoiceBean) {
        this.invoiceBean = invoiceBean;
    }
    @Override
    public void validate() {
        if (invoiceBean.getSubject().isEmpty()) {
            addFieldError("invoiceBean.subject", "El concepto es obligatorio.");
        }
        // Comprobar que le importe bruto no es cero.
        if (invoiceBean.isNullImporteBruto()) {
            addFieldError("invoiceBean.importeBruto", "El importe Bruto no puede ser cero.");
        }
        // Comprobar que el tipo de IVA no es cero, aunque podria ser una opcion valida
        if (invoiceBean.isNullTipoIva()) {
            addFieldError("invoiceBean.tipoIva", "El tipo del IVA no puede ser cero.");
        }
        // Comprobar integridad de las fechas desde y hasta
        if (invoiceBean.isNullDateFrom()){
            addFieldError("invoiceBean.dateFrom", "Las fecha 'Desde' debe ser una fecha válida.");
        }
        if (invoiceBean.isNullDateTo()){
            addFieldError("invoiceBean.dateTo", "Las fecha 'Hasta' debe ser una fecha válida.");
        }

//        if (invoiceBean.isNotCorrectDates()){
//            addFieldError("invoiceBean.dateFrom", "La fecha de inicio debe ser anterior a la fecha de fin.");
//        }
        //2024.10.08 Mejora de la comprobacion de fechas, ver si antes no son nulas
        if (!invoiceBean.isNullDateTo() && !invoiceBean.isNullDateFrom()){
            if (invoiceBean.isNotCorrectDates()){
                addFieldError("invoiceBean.dateFrom", "La fecha 'Desde' debe ser anterior a la fecha 'Hasta'.");
            }
        }
    }
}
