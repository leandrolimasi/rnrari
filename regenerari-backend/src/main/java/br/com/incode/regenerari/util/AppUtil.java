package br.com.incode.regenerari.util;

import javax.enterprise.context.ApplicationScoped;
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
     * @param hash texto a ser criptografada
     * @return hash criptografada
     */
    public String geraHashEmail(String hash){
        String hashEmail  = encriptaSenha(hash);
        try {
            hashEmail =  URLEncoder.encode(hashEmail, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.warning(e.getMessage());
        }
        return hashEmail;
    }

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
     * .{8,}             # pelo menos 8 caracteres
     *
     * @param senha senha a ser validada
     * @return resultado
     */
    public boolean validaSenha(String senha){
        String pattern =  "^(?=\\S+$).{8,}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(senha);
        return m.find();
    }
}
