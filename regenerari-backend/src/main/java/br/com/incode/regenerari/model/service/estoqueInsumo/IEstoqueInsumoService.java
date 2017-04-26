package br.com.incode.regenerari.model.service.estoqueInsumo;

import br.com.incode.regenerari.dto.EntradaEstoqueInsumoDTO;
import br.com.incode.regenerari.entity.EstoqueInsumoEntity;
import br.com.incode.regenerari.entity.PosicaoEstoqueInsumoEntity;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;

import javax.ejb.Local;
import javax.validation.Valid;

/**
 * Created by leandrolimadasilva on 12/04/17.
 */
@Local
public interface IEstoqueInsumoService extends IPlcEntityService<Long, EstoqueInsumoEntity> {

    /** Entrada de Estoque de insumo
     *
     * @param dto
     * @return
     */
    PosicaoEstoqueInsumoEntity entrada(@Valid EntradaEstoqueInsumoDTO dto);

}
