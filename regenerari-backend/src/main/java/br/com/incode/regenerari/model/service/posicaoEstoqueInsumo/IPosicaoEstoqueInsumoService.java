package br.com.incode.regenerari.model.service.posicaoEstoqueInsumo;

import br.com.incode.regenerari.entity.InsumoEntity;
import br.com.incode.regenerari.entity.PosicaoEstoqueInsumoEntity;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;

import javax.ejb.Local;

/**
 * Created by leandrolimadasilva on 12/04/17.
 */
@Local
public interface IPosicaoEstoqueInsumoService extends IPlcEntityService<Long, PosicaoEstoqueInsumoEntity> {

    /** Recupera posicao estoque de insumo
     *
     * @param insumo
     * @return
     */
    PosicaoEstoqueInsumoEntity recuperaPosicaoEstoqueInsumo(InsumoEntity insumo);

}
