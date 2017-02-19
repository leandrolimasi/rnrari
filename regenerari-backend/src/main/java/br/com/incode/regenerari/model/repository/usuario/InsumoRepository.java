package br.com.incode.regenerari.model.repository.usuario;

import br.com.incode.regenerari.entity.InsumoEntity;
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
public class InsumoRepository extends PlcAbstractRepository<Long, InsumoEntity> {

    @Override
    public Class<InsumoEntity> getEntityType() {
        return InsumoEntity.class;
    }

}
