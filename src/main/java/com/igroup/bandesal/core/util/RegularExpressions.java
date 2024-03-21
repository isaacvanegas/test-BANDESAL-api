package com.igroup.bandesal.core.util;

public class RegularExpressions {
    public static final String regExpNombre = "^[a-zA-Z0-9_ .áéíóúÁÉÍÓÚÑñ-]*$";
    public static final String regExpAlphaNumeric = "^[a-zA-Z0-9]*$";
    public static final String regExpDescripcion = "^[a-zA-Z0-9_ ,.;:\\/ \\n\\r áéíóúÁÉÍÓÚÑñ*/\\(\\)\\{\\}\\<\\>-]*$";
    public static final String regExpSoloLetrasConEspacio = "^[a-zA-Z- \\áéíóúAÉÍÓÚÑñ]*$";
    public static final String regExpSoloNumeros = "^[0-9]*$";
    public static final String regExpSoloLetras = "^[a-zA-Z]*$";
    public static final String regExpEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,3})$";
    public static final String regExpCodigoRecurso = "^[a-zA-Z0-9_\\/áéíóúÁÉÍÓÚÑñ/]*$";
    public static final String regExpUrl = "^[_a-zA-Z0-9_.\\/ áéíóúÁÉÍÓÚÑñ*/-]*$";
    public static final String regExpDecimales = "^[-0-9.]*[0-9]*$";
}
