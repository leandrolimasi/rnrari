package br.com.incode.regenerari.auth;

import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.messages.PlcBeanMessages;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticatedUserInfo;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticationService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Created by leandrolimadasilva on 11/01/17.
 */
@Specializes
@ApplicationScoped
public class AppAuthenticationService extends PlcAuthenticationService {

    @Override
    public PlcAuthenticatedUserInfo login(@Context HttpServletRequest request, Map<String, String> data) throws PlcException {
        String username = data.get("username");
        String password = data.get("password");

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        // authenticate!
        try {
            if (request.getUserPrincipal()==null) {
                request.login(username, password);
            }
        } catch (ServletException e) {

            throw PlcBeanMessages.FALHA_LOGIN_001.create();

        }
        return userLogin(request);
    }
}
