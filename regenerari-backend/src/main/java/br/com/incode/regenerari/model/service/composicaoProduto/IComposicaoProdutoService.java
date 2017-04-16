package br.com.incode.regenerari.model.service.composicaoProduto;

import br.com.incode.regenerari.entity.ComposicaoProdutoEntity;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;

import javax.ejb.Local;

/**
 * Created by leandrolimadasilva on 19/12/16.
 */
@Local
public  interface IComposicaoProdutoService extends IPlcEntityService<Long, ComposicaoProdutoEntity> {

}
