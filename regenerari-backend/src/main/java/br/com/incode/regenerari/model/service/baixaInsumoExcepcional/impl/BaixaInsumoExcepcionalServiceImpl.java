package br.com.incode.regenerari.model.service.baixaInsumoExcepcional.impl;

import br.com.incode.regenerari.bo.BaixaInsumoExcepcionalBO;
import br.com.incode.regenerari.dto.BaixaInsumoExcepcionalDTO;
import br.com.incode.regenerari.entity.BaixaInsumoExcepcionalEntity;
import br.com.incode.regenerari.entity.PosicaoEstoqueInsumoEntity;
import br.com.incode.regenerari.enums.EventoEstoque;
import br.com.incode.regenerari.messages.AppBeanMessages;
import br.com.incode.regenerari.model.repository.baixaInsumoExcepcional.BaixaInsumoExcepcionalRepository;
import br.com.incode.regenerari.model.repository.posicaoEstoqueInsumo.PosicaoEstoqueInsumoRepository;
import br.com.incode.regenerari.model.service.baixaInsumoExcepcional.IBaixaInsumoExcepcionalService;
import com.powerlogic.jcompany.commons.interceptor.validation.PlcValidationInterceptor;
import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.model.repository.IPlcEntityRepository;
import com.powerlogic.jcompany.core.model.service.PlcAbstractServiceEntity;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Created by leandrolimadasilva on 24/04/17.
 */
@Stateless
@Interceptors({PlcValidationInterceptor.class})
public class BaixaInsumoExcepcionalServiceImpl extends PlcAbstractServiceEntity<Long, BaixaInsumoExcepcionalEntity>
        implements IBaixaInsumoExcepcionalService {

    private static final Logger log = LoggerFactory.getLogger(BaixaInsumoExcepcionalServiceImpl.class);

    @Inject
    private BaixaInsumoExcepcionalRepository baixaInsumoExcepcionalRepository;

    @Inject
    private PosicaoEstoqueInsumoRepository posicaoEstoqueInsumoRepository;

    @Inject
    private BaixaInsumoExcepcionalBO baixaInsumoExcepcionalBO;

    @Override
    protected IPlcEntityRepository<Long, BaixaInsumoExcepcionalEntity> getEntityRepository() {
        return baixaInsumoExcepcionalRepository;
    }

    /**
     * baixa de Estoque de insumo por evento excepcional
     *
     * @param dto
     * @return
     */
    @Override
    public PosicaoEstoqueInsumoEntity baixa(@Valid BaixaInsumoExcepcionalDTO dto) {

        BaixaInsumoExcepcionalEntity baixaInsumoExcepcional = new BaixaInsumoExcepcionalEntity();

        try {
            BeanUtils.copyProperties(baixaInsumoExcepcional, dto);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error(e.getLocalizedMessage(), e);
        }

        baixaInsumoExcepcionalBO.validaBaixaEstoque(baixaInsumoExcepcional);

        baixaInsumoExcepcional.setData(new Date());

        baixaInsumoExcepcional = baixaInsumoExcepcionalRepository.save(baixaInsumoExcepcional);

        PosicaoEstoqueInsumoEntity posicaoEstoqueInsumo = posicaoEstoqueInsumoRepository.recuperaPosicaoAtual(baixaInsumoExcepcional.getInsumo());

        if (posicaoEstoqueInsumo != null){

            posicaoEstoqueInsumo.setQuantidade(posicaoEstoqueInsumo.getQuantidade().subtract(baixaInsumoExcepcional.getQuantidade()));
            posicaoEstoqueInsumo.setEventoEstoque(EventoEstoque.AJUSTE);

        }

        if (posicaoEstoqueInsumo.getQuantidade().doubleValue() < 0){
            throw new PlcException(AppBeanMessages.POSICAO_ESTOQUE_INSUMO_QUANTIDADE_ZERO);
        }

        return posicaoEstoqueInsumoRepository.save(posicaoEstoqueInsumo);
    }
}
