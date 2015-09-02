package com.douglasmariano.converters;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.douglasmariano.dao.SeparadorDAO;
import com.douglasmariano.model.Separador;

@Component
public class SeparadorEditor extends PropertyEditorSupport {

	@Autowired
    private SeparadorDAO separadorDAO;

    // Converts a String to a Country (when submitting form)
    @Override
    public void setAsText(String text) {
        Separador separador = this.separadorDAO.buscaPorId(Long.valueOf(text));
        this.setValue(separador);
    }

}