package br.com.incode.regenerari.model.repository.composicaoProduto;

import br.com.incode.regenerari.entity.ComposicaoProdutoEntity;
import com.powerlogic.jcompany.core.model.qbe.SearchParameters;
import com.powerlogic.jcompany.core.model.repository.PlcAbstractRepository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by leandrolimadasilva on 21/12/16.
 */
public class ComposicaoProdutoRepository extends PlcAbstractRepository<Long, ComposicaoProdutoEntity> {

    @Override
    public Class<ComposicaoProdutoEntity> getEntityType() {
        return ComposicaoProdutoEntity.class;
    }

    /** Find  ComposicaoProdutoEntity list by Insumo id.
     *
     * @param idInsumo
     * @return
     */
    public List<ComposicaoProdutoEntity> findComposicaoByInsumo(Long idInsumo){
        SearchParameters sp = new SearchParameters();
        sp.setNamedQuery("ComposicaoProdutoEntity.findComposicaoByInsumo");
        HashMap parameters = new HashMap();
        parameters.put("idInsumo", idInsumo);
        sp.setNamedQueryParameters(parameters);
        return find(sp);
    }

}
