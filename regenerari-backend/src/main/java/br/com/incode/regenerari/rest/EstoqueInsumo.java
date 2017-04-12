package br.com.incode.regenerari.rest;

import br.com.incode.regenerari.dto.AlterarSenhaDTO;
import br.com.incode.regenerari.dto.EntradaEstoqueInsumoDTO;
import br.com.incode.regenerari.entity.EstoqueInsumoEntity;
import br.com.incode.regenerari.entity.UsuarioEntity;
import br.com.incode.regenerari.messages.AppBeanMessages;
import br.com.incode.regenerari.model.service.estoqueInsumo.IEstoqueInsumoService;
import com.powerlogic.jcompany.core.exception.PlcException;
import com.powerlogic.jcompany.core.messages.PlcMessageType;
import com.powerlogic.jcompany.core.rest.PlcAbstractRest;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticated;
import com.powerlogic.jcompany.core.rest.messages.PlcMessageIntercept;
import org.apache.commons.beanutils.BeanUtils;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by leandrolimadasilva on 12/04/17.
 */
@PlcAuthenticated
@Path("/estoque-Insumo")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@PlcMessageIntercept
public class EstoqueInsumo extends PlcAbstractRest {

    @Inject
    private IEstoqueInsumoService estoqueInsumoService;

    /** Entrada de estoque de Insumos
     *
     * @param dto
     * @return
     * @throws PlcException
     */
    @POST
    @Path("/entrada")
    public EstoqueInsumoEntity entrada(EntradaEstoqueInsumoDTO dto) throws PlcException {
        return  estoqueInsumoService.entrada(dto);
    }

}
