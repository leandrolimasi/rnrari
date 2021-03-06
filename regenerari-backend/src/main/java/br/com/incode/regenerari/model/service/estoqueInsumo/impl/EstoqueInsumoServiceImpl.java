package br.com.incode.regenerari.model.service.estoqueInsumo.impl;

import br.com.incode.regenerari.bo.EstoqueInsumoBO;
import br.com.incode.regenerari.dto.EntradaEstoqueInsumoDTO;
import br.com.incode.regenerari.entity.EstoqueInsumoEntity;
import br.com.incode.regenerari.entity.PosicaoEstoqueInsumoEntity;
import br.com.incode.regenerari.enums.EventoEstoque;
import br.com.incode.regenerari.model.repository.estoqueInsumo.EstoqueInsumoRepository;
import br.com.incode.regenerari.model.repository.posicaoEstoqueInsumo.PosicaoEstoqueInsumoRepository;
import br.com.incode.regenerari.model.service.estoqueInsumo.IEstoqueInsumoService;
import com.powerlogic.jcompany.commons.interceptor.validation.PlcValidationInterceptor;
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
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by leandrolimadasilva on 12/04/17.
 */
@Stateless
@Interceptors({PlcValidationInterceptor.class})
public class EstoqueInsumoServiceImpl extends PlcAbstractServiceEntity<Long, EstoqueInsumoEntity> implements IEstoqueInsumoService {

    private static final Logger log = LoggerFactory.getLogger(EstoqueInsumoServiceImpl.class);

    @Inject
    private EstoqueInsumoRepository estoqueInsumoRepository;

    @Inject
    private PosicaoEstoqueInsumoRepository posicaoEstoqueInsumoRepository;

    @Inject
    private EstoqueInsumoBO estoqueInsumoBO;

    @Override
    protected IPlcEntityRepository<Long, EstoqueInsumoEntity> getEntityRepository() {
        return estoqueInsumoRepository;
    }

    /** Entrada de Estoque de insumo
     *
     * @param dto
     * @return
     */
    @Override
    public PosicaoEstoqueInsumoEntity entrada(@Valid EntradaEstoqueInsumoDTO dto) {

        EstoqueInsumoEntity estoqueInsumo = new EstoqueInsumoEntity();

        try {
            BeanUtils.copyProperties(estoqueInsumo, dto);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error(e.getLocalizedMessage(), e);
        }

        estoqueInsumoBO.validaEntradaEstoque(estoqueInsumo);
        estoqueInsumo.setValorCompraUnitario(estoqueInsumo.getValorCompraTotal()
                .divide( estoqueInsumo.getQuantidade(), 3, RoundingMode.DOWN));
        estoqueInsumo = estoqueInsumoRepository.save(estoqueInsumo);

        PosicaoEstoqueInsumoEntity posicaoEstoqueInsumo = posicaoEstoqueInsumoRepository.recuperaPosicaoAtual(estoqueInsumo.getInsumo());
        BigDecimal valorUnitarioAnterior = new BigDecimal(0);
        BigDecimal quantidadeAnterior = new BigDecimal(0);

        if (posicaoEstoqueInsumo == null){
            posicaoEstoqueInsumo = new PosicaoEstoqueInsumoEntity();
            posicaoEstoqueInsumo.setInsumo(estoqueInsumo.getInsumo());
            posicaoEstoqueInsumo.setEventoEstoque(EventoEstoque.ENTRADA);
            posicaoEstoqueInsumo.setQuantidade(estoqueInsumo.getQuantidade());
            posicaoEstoqueInsumo.setValorUnitario(estoqueInsumo.getValorCompraUnitario());

        }else{

            valorUnitarioAnterior = posicaoEstoqueInsumo.getValorUnitario();
            quantidadeAnterior = posicaoEstoqueInsumo.getQuantidade();

           /* Novo Valor Unitario= ((QEA * VUA) + (QNE * VUNE)) / (QEA + QNE)
            Onde: QEA-Quantidade Estoque Atual (antes da nova entrada);

            VUA-Valor Unitario Atual; QNE-Quantidade Nova Entrada;

            VUNE-Valor Unitario Nova Entrada (esse tem que ser calculado a partir da QNE  e do Valor Total da
            Nova Entrada informados pelo usuário) */

            posicaoEstoqueInsumo.setQuantidade(posicaoEstoqueInsumo.getQuantidade().add(estoqueInsumo.getQuantidade()));
            posicaoEstoqueInsumo.setEventoEstoque(EventoEstoque.ENTRADA);


            BigDecimal valorTotalAnterior = quantidadeAnterior.multiply(valorUnitarioAnterior);

            BigDecimal valorUnitarioAtual = valorTotalAnterior.add(estoqueInsumo.getValorCompraTotal())
                    .divide(quantidadeAnterior.add(estoqueInsumo.getQuantidade()),
                            3, RoundingMode.HALF_UP);

            posicaoEstoqueInsumo.setValorUnitario(valorUnitarioAtual);

        }

        posicaoEstoqueInsumo =  posicaoEstoqueInsumoRepository.save(posicaoEstoqueInsumo);
        posicaoEstoqueInsumo.setQuantidadeEstoqueAnterior(quantidadeAnterior);
        posicaoEstoqueInsumo.setValorUnitarioAnterior(valorUnitarioAnterior);
        return posicaoEstoqueInsumo;

    }
}
