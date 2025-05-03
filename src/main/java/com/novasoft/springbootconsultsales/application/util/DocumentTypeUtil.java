package com.novasoft.springbootconsultsales.application.util;

import com.novasoft.springbootconsultsales.application.exceptions.BusinessException;

public class  DocumentTypeUtil {

    private DocumentTypeUtil() {}

    public static void validateDocumentType(String numberDocument) {
        int size = numberDocument.length();

        if (size != 8 && size != 11) {
            throw new BusinessException("numberDocument", "Número de documento no valido");
        }
    }
}
