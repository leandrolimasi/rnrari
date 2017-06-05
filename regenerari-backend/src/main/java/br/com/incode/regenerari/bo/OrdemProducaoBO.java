package br.com.incode.regenerari.bo;

import br.com.incode.regenerari.dto.InsumosOrdemProducaoDTO;
import br.com.incode.regenerari.entity.ComposicaoProdutoEntity;
import br.com.incode.regenerari.entity.ItemComposicaoProdutoEntity;
import br.com.incode.regenerari.entity.OrdemProducaoEntity;
import br.com.incode.regenerari.entity.PosicaoEstoqueInsumoEntity;
import br.com.incode.regenerari.messages.AppBeanMessages;
import br.com.incode.regenerari.model.repository.composicaoProduto.ComposicaoProdutoRepository;
import br.com.incode.regenerari.model.repository.posicaoEstoqueInsumo.PosicaoEstoqueInsumoRepository;
import br.com.incode.regenerari.model.repository.produto.ProdutoRepository;
import br.com.incode.regenerari.util.AppUtil;
import com.powerlogic.jcompany.core.exception.PlcException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandrolimadasilva on 29/05/17.
 */
public class OrdemProducaoBO extends AppBO {

    @Inject
    private AppUtil appUtil;

    @Inject
    private ProdutoRepository produtoRepository;

    @Inject
    private ComposicaoProdutoRepository composicaoProdutoRepository;

    @Inject
    private PosicaoEstoqueInsumoRepository posicaoEstoqueInsumoRepository;

    /**
     * verifica campos validos
     *
     * @param entity
     */
    public void validaGeracaoOrdemProducao(OrdemProducaoEntity entity) {

        if (entity.getQuantidade().doubleValue() <= 0){
            throw new PlcException(AppBeanMessages.ESTOQUE_INSUMO_QUANTIDADE_ZERO);
        }

    }

    /** valida quantidade de insumo para producao
     *
     * @param entity
     * @return
     */
    public boolean validaQuantidadeInsumo(OrdemProducaoEntity entity){

        ComposicaoProdutoEntity composicaoProdutoEntity =
                composicaoProdutoRepository.get(entity.getComposicaoProduto().getId());

        for (ItemComposicaoProdutoEntity item : composicaoProdutoEntity.getItemComposicaoProduto()){

            PosicaoEstoqueInsumoEntity posicaoEstoqueInsumo =
                    posicaoEstoqueInsumoRepository.recuperaPosicaoAtual(item.getInsumo());

            if (posicaoEstoqueInsumo.getQuantidade().doubleValue() < (entity.getQuantidade().doubleValue() * item.getQuantidadeInsumo().doubleValue())){
                return false;
            }

        }

        return true;

    }

    /** valida quantidade de insumo para producao
     *
     * @param entity
     * @return
     */
    public List<InsumosOrdemProducaoDTO> montaListaInsumos(OrdemProducaoEntity entity){

        ComposicaoProdutoEntity composicaoProdutoEntity =
                composicaoProdutoRepository.get(entity.getComposicaoProduto().getId());

        List<InsumosOrdemProducaoDTO> listaInsumos =  new ArrayList<>();

        for (ItemComposicaoProdutoEntity item : composicaoProdutoEntity.getItemComposicaoProduto()){

            PosicaoEstoqueInsumoEntity posicaoEstoqueInsumo =
                    posicaoEstoqueInsumoRepository.recuperaPosicaoAtual(item.getInsumo());

            InsumosOrdemProducaoDTO insumosOrdemProducaoDTO = new InsumosOrdemProducaoDTO();
            insumosOrdemProducaoDTO.setInsumo(item.getInsumo());
            insumosOrdemProducaoDTO.setQuantidadeEstoque(posicaoEstoqueInsumo.getQuantidade());
            insumosOrdemProducaoDTO.setQuantidadeSolicitada(entity.getQuantidade().multiply(item.getQuantidadeInsumo()));
            listaInsumos.add(insumosOrdemProducaoDTO);
        }

        return listaInsumos;

    }


}