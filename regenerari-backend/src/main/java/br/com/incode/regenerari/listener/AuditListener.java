package br.com.incode.regenerari.listener;

import br.com.incode.regenerari.auth.AppAuthenticatedUserInfo;
import br.com.incode.regenerari.entity.AppBaseEntity;
import br.com.incode.regenerari.util.AppConstants;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticatedUserInfo;
import org.apache.commons.beanutils.PropertyUtils;

import javax.enterprise.inject.spi.CDI;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.logging.Logger;
/**
 * Created by leandrolimadasilva on 30/05/16.
 */
public class AuditListener {

    private Logger log = Logger.getLogger( AuditListener.class.getName() );

    @PrePersist
    @PreUpdate
    private void auditaEntidade(Object entity){

        if (entity instanceof AppBaseEntity){
            HttpServletRequest request = CDI.current().select(HttpServletRequest.class).get();
            AppAuthenticatedUserInfo userInfo = (AppAuthenticatedUserInfo)
                    request.getSession().getAttribute(PlcAuthenticatedUserInfo.PROPERTY);
            try {
                PropertyUtils.setProperty(entity, AppConstants.FIELD_DATE_ALT, new Date());
                PropertyUtils.setProperty(entity, AppConstants.FIELD_USU_ALT, userInfo.getUsuario() != null &&
                        userInfo.getUsuario().getLogin() != null ? userInfo.getUsuario().getLogin() : AppConstants.ANONIMO);
            } catch (IllegalAccessException e) {
                log.severe(e.getMessage());
            } catch (InvocationTargetException e) {
                log.severe(e.getMessage());
            } catch (NoSuchMethodException e) {
                log.severe(e.getMessage());
            }
        }
    }
}
