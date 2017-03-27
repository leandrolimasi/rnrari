package br.com.incode.regenerari.rest;

import br.com.incode.regenerari.auth.AppAuthenticatedUserInfo;
import br.com.incode.regenerari.entity.UsuarioEntity;
import br.com.incode.regenerari.entity.UsuarioRoleEntity;
import br.com.incode.regenerari.enums.Perfil;
import com.powerlogic.jcompany.core.model.entity.IPlcEntityModel;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticatedUserInfo;
import com.powerlogic.jcompany.core.rest.entity.PlcAbstractEntityRest;
import org.hibernate.exception.ConstraintViolationException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.io.Serializable;

/**
 * Created by leandrolimadasilva on 05/03/17.
 */
public abstract class AppBaseRest <PK extends Serializable, E extends IPlcEntityModel<PK>> extends PlcAbstractEntityRest<PK, E> {

    @Context
    private HttpServletRequest request;

    protected ConstraintViolationException findConstraintViolationException(Throwable throwable){

        if (throwable instanceof ConstraintViolationException){
            return (ConstraintViolationException) throwable;
        }else{

            if (throwable.getCause() != null){
                Throwable superThrowable = throwable.getCause();
                return findConstraintViolationException(superThrowable);
            }

        }

        return null;

    }

    protected boolean isAdmin(){

        AppAuthenticatedUserInfo appAuthenticatedUserInfo = (AppAuthenticatedUserInfo) request.getSession().getAttribute(PlcAuthenticatedUserInfo.PROPERTY);
        for(UsuarioRoleEntity role:  appAuthenticatedUserInfo.getUsuario().getRoles()){
            if (Perfil.ADMIN.equals(role.getPerfil())){
                return true;
            }
        }

        return false;
    }

    protected UsuarioEntity getCurrentUser(){
        AppAuthenticatedUserInfo appAuthenticatedUserInfo = (AppAuthenticatedUserInfo) request.getSession().getAttribute(PlcAuthenticatedUserInfo.PROPERTY);
        return appAuthenticatedUserInfo.getUsuario();
    }

}
