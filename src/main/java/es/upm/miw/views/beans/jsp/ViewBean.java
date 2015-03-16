package es.upm.miw.views.beans.jsp;

import javax.faces.bean.ManagedProperty;

import es.upm.miw.controllers.*;

public abstract class ViewBean {

    @ManagedProperty(value = "#{controllerFactory}")
    private ControllerFactory controllerFactory;

    public void setControllerFactory(ControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }

    protected ControllerFactory getControllerFactory() {
        return controllerFactory;
    }

}
