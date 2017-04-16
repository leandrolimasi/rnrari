package br.com.incode.regenerari.model.repository.posicaoEstoqueInsumo;

import br.com.incode.regenerari.entity.InsumoEntity;
import br.com.incode.regenerari.entity.PosicaoEstoqueInsumoEntity;
import com.powerlogic.jcompany.core.model.qbe.OrderBy;
import com.powerlogic.jcompany.core.model.qbe.OrderByDirection;
import com.powerlogic.jcompany.core.model.qbe.SearchParameters;
import com.powerlogic.jcompany.core.model.repository.PlcAbstractRepository;
import org.apache.commons.collections.CollectionUtils;

import javax.persistence.metamodel.ManagedType;
import java.util.List;

/**
 * Created by leandrolimadasilva on 16/04/17.
 */
public class PosicaoEstoqueInsumoRepository extends PlcAbstractRepository<Long, PosicaoEstoqueInsumoEntity> {

    @Override
    public Class<PosicaoEstoqueInsumoEntity> getEntityType() {
        return PosicaoEstoqueInsumoEntity.class;
    }

    /** Retorna registro com a posicao de estoque de insumo atual.
     *
     * @param insumo
     * @return
     */
    public PosicaoEstoqueInsumoEntity recuperaPosicaoAtual(InsumoEntity insumo){
        PosicaoEstoqueInsumoEntity posicaoEstoqueInsumo = new PosicaoEstoqueInsumoEntity();
        posicaoEstoqueInsumo.setInsumo(insumo);
        SearchParameters sp = new SearchParameters();
        ManagedType<PosicaoEstoqueInsumoEntity> mt = getEntityManager().getMetamodel().entity(PosicaoEstoqueInsumoEntity.class);
        sp.addOrderBy(new OrderBy(OrderByDirection.DESC, mt.getAttribute("dataUltimaAlteracao")));
        List<PosicaoEstoqueInsumoEntity> listaEstoque =  findAll(posicaoEstoqueInsumo);

        if (CollectionUtils.isNotEmpty(listaEstoque)){
            return listaEstoque.get(0);
        }

        return null;
    }
}
