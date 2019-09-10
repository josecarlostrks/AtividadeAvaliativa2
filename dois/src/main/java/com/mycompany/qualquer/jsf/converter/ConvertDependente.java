package com.mycompany.qualquer.jsf.converter;

import com.mycompany.qualquer.Dependente;
import com.mycompany.qualquer.Dependentes;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 26/04/2019, 08:37:43
 */
@FacesConverter(value = "converter.Dependente")
public class ConvertDependente implements Converter {

    @EJB
    private Dependentes service;

    @Override
    public Object getAsObject(
        FacesContext context,
        UIComponent component,
        String value) {
        if (value == null) {
            return null;
        }

        Dependente dep = this.service.buscaPorUuid(value);
        return dep;

    }

    @Override
    public String getAsString(
        FacesContext context,
        UIComponent component,
        Object value) {

        if (value == null) {
            return null;
        }
        Dependente dep = (Dependente) value;
        return dep.getId();
    }

}
