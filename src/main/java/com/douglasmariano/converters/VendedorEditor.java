package com.douglasmariano.converters;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.douglasmariano.dao.VendedorDAO;
import com.douglasmariano.model.Vendedor;

@Component
public class VendedorEditor extends PropertyEditorSupport {

	@Autowired
    private VendedorDAO vendedorDAO;

    // Converts a String to a Country (when submitting form)
    @Override
    public void setAsText(String text) {
        Vendedor vendedor = this.vendedorDAO.buscaPorId(Long.valueOf(text));
        this.setValue(vendedor);
    }

}