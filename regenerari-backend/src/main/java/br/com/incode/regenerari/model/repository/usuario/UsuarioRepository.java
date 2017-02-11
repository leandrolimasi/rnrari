package br.com.incode.regenerari.model.repository.usuario;

import br.com.incode.regenerari.entity.UsuarioEntity;
import br.com.incode.regenerari.util.AppUtil;
import com.powerlogic.jcompany.core.model.qbe.SearchParameters;
import com.powerlogic.jcompany.core.model.repository.PlcAbstractRepository;
import org.apache.commons.collections.CollectionUtils;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leandrolimadasilva on 21/12/16.
 */
public class UsuarioRepository extends PlcAbstractRepository<Long, UsuarioEntity> {
    @Inject
    private AppUtil appUtil;

    @Override
    public Class<UsuarioEntity> getEntityType() {
        return UsuarioEntity.class;
    }

    /** Recupera usuario por login
     *
     * @param login login de acesso do usuario
     *
     * @return usuario
     */
    public UsuarioEntity findUsuarioByLogin(String login){
        SearchParameters sp = new SearchParameters();
        sp.setNamedQuery("UsuarioEntity.findUsuarioByLogin");
        Map<String,Object> params = new HashMap<>();
        params.put("login", login);
        sp.setNamedQueryParameters(params);
        List<UsuarioEntity> ret = find(sp);
        return CollectionUtils.isNotEmpty(ret) ? ret.get(0) : null;
    }
}
