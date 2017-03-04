package br.com.incode.regenerari.util;

import br.com.incode.regenerari.auth.AppAuthenticatedUserInfo;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticatedUserInfo;
import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.CDI;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by leandrolimadasilva on 21/12/16.
 */
@ApplicationScoped
public class AppUtil {

    private Logger log = Logger.getLogger( AppUtil.class.getName() );

    /** Encripta senha do cadastro de usuario.
     *
     * @param senha senha a ser criptografada
     * @return senha criptografada
     */
    public String encriptaSenha(String senha){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (md != null) {
            md.update(senha.getBytes());
            return new sun.misc.BASE64Encoder().encode(md.digest());
        }
        return senha;
    }

    /** Metodo que valida a seguranca de uma senha.
     *
     * (?=.*[0-9])       # pelo menos um digito numerico
     * (?=.*[a-z])       # pelo menos uma letra minuscula
     * (?=.*[A-Z])       # pelo menos uma letra maiuscula
     * (?=\S+$)          # sem espacos vazios
     * .{6,}             # pelo menos 6 caracteres
     *
     * @param senha senha a ser validada
     * @return resultado
     */
    public boolean validaSenha(String senha){
        if (StringUtils.isNotBlank(senha)){
            String pattern =  "^(?=\\S+$).{6,}$";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(senha);
            return m.find();
        }

        return true;

    }

    /** Recupera usuario logado
     *
     * @return
     */
    public AppAuthenticatedUserInfo getUsuarioLogado(){
        HttpServletRequest request = CDI.current().select(HttpServletRequest.class).get();
        return (AppAuthenticatedUserInfo)
                request.getSession().getAttribute(PlcAuthenticatedUserInfo.PROPERTY);
    }
}
