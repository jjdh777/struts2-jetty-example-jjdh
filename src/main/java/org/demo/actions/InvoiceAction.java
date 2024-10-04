package org.demo.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.ObjectUtils;
import org.demo.actions.beans.InvoiceBean;

public class InvoiceAction extends ActionSupport  {

    InvoiceBean invoiceBean;

    @Override
    public String execute() throws Exception {
        System.out.println("execute!!");
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
        if (invoiceBean.getImporteBruto()== 0) {
            addFieldError("invoiceBean.subject", "El importe Bruto no puede ser cero.");
        }
        // Comprobar que el tipo de IVA no es cero, aunque podria ser una opcion valida
        if (invoiceBean.getTipoIva()== 0) {
            addFieldError("invoiceBean.subject", "El tipo del IVA no puede ser cero.");
        }
        // Comprobar integridad de las fechas desde y hasta
        if (invoiceBean.getDateFrom()==null){
            addFieldError("invoiceBean.dateFrom", "Las fechas de inicio debe ser una fecha válida.");
        }
        if (invoiceBean.getDateTo() == null){
            addFieldError("invoiceBean.dateTo", "Las fechas de fin debe ser una fecha válida.");
        }
//        if (invoiceBean.getDateTo().after(invoiceBean.getDateFrom())) {
//            addFieldError("invoiceBean.dateFrom", "La fecha de inicio debe ser anterior a la fecha de fin.");
//        }
    }
}
