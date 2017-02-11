package br.com.incode.regenerari.enums.converter;

import br.com.incode.regenerari.enums.TipoMidia;
import org.apache.commons.lang.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by marcelolimabh on 09/01/17.
 */
@Converter(autoApply = true)
public class TipoMidiaConverter implements AttributeConverter<TipoMidia, String> {

    /**
     *
     * @param tipoMidia
     * @return
     */
    @Override
    public String convertToDatabaseColumn(TipoMidia tipoMidia) {

        if (tipoMidia == null){
            return null;
        }

        switch (tipoMidia) {

            case V:
                return "1";

            case F:
                return "2";

            default: return null;
        }

    }


    /**
     *
     * @param s
     * @return
     */
    @Override
    public TipoMidia convertToEntityAttribute(String s) {

        if (s == null){
            return null;
        }

        switch (s) {

            case "1":
                return TipoMidia.V;

            case "2":
                return TipoMidia.F;

        }

        return null;
    }
}
