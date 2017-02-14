package br.com.incode.regenerari.listener;

import br.com.incode.regenerari.util.AppConstants;
import br.com.incode.regenerari.auth.UserInfoBean;
import br.com.incode.regenerari.entity.AppBaseEntity;
import org.apache.commons.beanutils.PropertyUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.CDI;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.logging.Logger;
/**
 * Created by leandrolimadasilva on 30/05/16.
 */
@ApplicationScoped
public class AuditListener {

    private Logger log = Logger.getLogger( AuditListener.class.getName() );

    @PrePersist
    @PreUpdate
    private void auditaEntidade(Object entity){
        UserInfoBean userInfo = CDI.current().select(UserInfoBean.class).get();
        if (entity instanceof AppBaseEntity){
            try {
                PropertyUtils.setProperty(entity, AppConstants.FIELD_DATE_ALT, new Date());
                PropertyUtils.setProperty(entity, AppConstants.FIELD_USU_ALT, userInfo.getUsuario() != null &&
                        userInfo.getUsuario().getEmail() != null ? userInfo.getUsuario().getEmail() : AppConstants.ANONIMO);
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
