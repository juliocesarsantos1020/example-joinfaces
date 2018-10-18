package com.joinfaces.project.example.controller.converter;

import com.joinfaces.project.example.model.State;
import com.joinfaces.project.example.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.Optional;

@Component
public class StateConverter implements Converter {

    @Autowired
    private StateService stateService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return stateService.findByIdState(new Long(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o != null) {
            Long codigo = ((State) o).getIdState();
            String IdState = (codigo == null ? null : codigo.toString());

            return IdState;
        }
        return "";
    }
}