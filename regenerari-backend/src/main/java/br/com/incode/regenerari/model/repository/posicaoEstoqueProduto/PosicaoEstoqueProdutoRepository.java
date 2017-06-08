package br.com.incode.regenerari.model.repository.posicaoEstoqueProduto;

import br.com.incode.regenerari.entity.InsumoEntity;
import br.com.incode.regenerari.entity.PosicaoEstoqueInsumoEntity;
import br.com.incode.regenerari.entity.PosicaoEstoqueProdutoEntity;
import br.com.incode.regenerari.entity.ProdutoEntity;
import com.powerlogic.jcompany.core.model.qbe.OrderBy;
import com.powerlogic.jcompany.core.model.qbe.OrderByDirection;
import com.powerlogic.jcompany.core.model.qbe.SearchParameters;
import com.powerlogic.jcompany.core.model.repository.PlcAbstractRepository;
import org.apache.commons.collections.CollectionUtils;

import javax.persistence.metamodel.ManagedType;
import java.util.List;

/**
 * Created by leandrolimadasilva on 06/06/17.
 */
public class PosicaoEstoqueProdutoRepository extends PlcAbstractRepository<Long, PosicaoEstoqueProdutoEntity> {

    @Override
    public Class<PosicaoEstoqueProdutoEntity> getEntityType() {
        return PosicaoEstoqueProdutoEntity.class;
    }

    /** Retorna registro com a posicao de estoque de produto atual.
     *
     * @param produto
     * @return
     */
    public PosicaoEstoqueProdutoEntity recuperaPosicaoAtual(ProdutoEntity produto){
        PosicaoEstoqueProdutoEntity posicaoEstoqueProduto = new PosicaoEstoqueProdutoEntity();
        posicaoEstoqueProduto.setProduto(produto);
        SearchParameters sp = new SearchParameters();
        ManagedType<PosicaoEstoqueProdutoEntity> mt = getEntityManager().getMetamodel().entity(PosicaoEstoqueProdutoEntity.class);
        sp.addOrderBy(new OrderBy(OrderByDirection.DESC, mt.getAttribute("dataUltimaAlteracao")));
        List<PosicaoEstoqueProdutoEntity> listaEstoque =  findAll(posicaoEstoqueProduto);

        if (CollectionUtils.isNotEmpty(listaEstoque)){
            return listaEstoque.get(0);
        }

        return null;
    }

}
