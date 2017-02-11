package br.com.incode.regenerari.enums.converter;

import br.com.incode.regenerari.enums.Status;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by leandrolimadasilva on 21/12/16.
 */
@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {
    @Override
    public String convertToDatabaseColumn(Status ativoInativo) {
        if (ativoInativo == null){
            return null;
        }
        switch (ativoInativo) {
            case ATIVO:
                return "A";
            case INATIVO:
                return "I";
        }
        return null;
    }

    @Override
    public Status convertToEntityAttribute(String s) {
        if (s == null){
            return null;
        }
        switch (s) {
            case "A":
                return Status.ATIVO;
            case "I":
                return Status.INATIVO;
        }
        return null;
    }
}