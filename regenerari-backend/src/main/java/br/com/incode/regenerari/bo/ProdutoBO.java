package br.com.incode.regenerari.bo;

import br.com.incode.regenerari.entity.ProdutoEntity;
import br.com.incode.regenerari.entity.UsuarioEntity;
import br.com.incode.regenerari.entity.UsuarioRoleEntity;
import br.com.incode.regenerari.messages.AppBeanMessages;
import br.com.incode.regenerari.model.repository.produto.ProdutoRepository;
import br.com.incode.regenerari.util.AppUtil;
import com.powerlogic.jcompany.core.exception.PlcException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.input.BOMInputStream;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by leandrolimadasilva on 30/01/17.
 */
public class ProdutoBO extends AppBO {

    @Inject
    private AppUtil appUtil;

    @Inject
    private ProdutoRepository produtoRepository;

    /**
     * verifica alteracao de preco
     *
     * @param produto
     */
    public void validaAlteracaoCodigo(ProdutoEntity produto) {

        if (produto != null && produto.getId() != null) {

            ProdutoEntity produtoAnterior = produtoRepository.get(produto.getId());

            if (!produto.getCodigo().equals(produtoAnterior.getCodigo())) {
                throw new PlcException(AppBeanMessages.PRODUTO_ERROR_CODIGO_ALTERADO);
            }

        }
    }

    /**
     * verifica alteracao de codigo
     *
     * @param produto
     */
    public void configuraAlteracaoPreco(ProdutoEntity produto) {

        if (produto != null && produto.getId() != null) {

            ProdutoEntity produtoAnterior = produtoRepository.get(produto.getId());

            if (!produto.getPrecoMinimo().equals(produtoAnterior.getPrecoMinimo())  ||
                    !produto.getPrecoMaximo().equals(produtoAnterior.getPrecoMaximo())){

                produto.setUsuarioUltimoPreco(appUtil.getUsuarioLogado().getUsuario());
                produto.setDataUltimoPreco(new Date());

            }


        }
    }

    /**
     * verifica alteracao de codigo
     *
     * @param produto
     */
    public void validaAlteracaoExperimental(ProdutoEntity produto) {

        if (produto != null && produto.getId() != null) {

            ProdutoEntity produtoAnterior = produtoRepository.get(produto.getId());

            if (produtoAnterior.getProdutoExperimental().equals(Boolean.TRUE) &&
                    produto.getProdutoExperimental().equals(Boolean.FALSE)) {

                produto.setDataHomologacao(new Date());
                produto.setUsuarioHomologacao(appUtil.getUsuarioLogado().getUsuario());

            }


        }
    }

}