package br.com.incode.regenerari.model.service.baixaInsumoExcepcional;

import br.com.incode.regenerari.dto.BaixaInsumoExcepcionalDTO;
import br.com.incode.regenerari.entity.BaixaInsumoExcepcionalEntity;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;

import javax.ejb.Local;
import javax.validation.Valid;

/**
 * Created by leandrolimadasilva on 24/04/17.
 */
@Local
public interface IBaixaInsumoExcepcionalService  extends IPlcEntityService<Long, BaixaInsumoExcepcionalEntity> {

    /** baixa de Estoque de insumo por evento excepcional
     *
     * @param dto
     * @return
     */
    BaixaInsumoExcepcionalEntity baixa(@Valid BaixaInsumoExcepcionalDTO dto);

}