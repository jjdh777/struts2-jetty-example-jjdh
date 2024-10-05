<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
  <title><s:text name="hello.message"/></title>
  <s:head/>
  <sx:head/>
</head>

<body>

    <h1>Resumen de factura: </h1>

    Concepto Facturado: <s:property value="invoiceBean.subject" /><br><br>
    Periodo de Facturación: <s:property value="invoiceBean.dateFrom" /> hasta <s:property value="invoiceBean.dateTo" /><br><br>
    Importe Bruto: <s:property value="invoiceBean.importeBruto" /> Euros. <br><br>
    Tipo de IVA%: <s:property value="invoiceBean.tipoIva" /> % <br><br>
    Importe TOTAL con impuestos: <s:property value="invoiceBean.importeTotal" /> Euros. <br><br>

</body>
</html>