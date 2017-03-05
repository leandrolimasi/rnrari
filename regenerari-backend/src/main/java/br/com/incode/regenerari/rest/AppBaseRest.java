package br.com.incode.regenerari.rest;

import com.powerlogic.jcompany.core.model.entity.IPlcEntityModel;
import com.powerlogic.jcompany.core.rest.entity.PlcAbstractEntityRest;
import org.hibernate.exception.ConstraintViolationException;

import java.io.Serializable;

/**
 * Created by leandrolimadasilva on 05/03/17.
 */
public abstract class AppBaseRest <PK extends Serializable, E extends IPlcEntityModel<PK>, A> extends PlcAbstractEntityRest<PK, E, A> {

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
}
