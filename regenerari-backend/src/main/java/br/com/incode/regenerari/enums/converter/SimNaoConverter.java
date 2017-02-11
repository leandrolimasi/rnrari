package br.com.incode.regenerari.enums.converter;

import br.com.incode.regenerari.enums.SimNao;

import javax.persistence.AttributeConverter;

/**
 * Created by marcelolimabh on 10/01/17.
 */
public class SimNaoConverter implements AttributeConverter<SimNao, String> {
    /**
     * Converts the value stored in the entity attribute into the
     * data representation to be stored in the database.
     *
     * @param simNao the entity attribute value to be converted
     * @return the converted data to be stored in the database
     * column
     */
    @Override
    public String convertToDatabaseColumn(SimNao simNao) {

        if(simNao==null){
            return null;
        }

        switch (simNao){
            case SIM:
                return "S";
            case NAO:
                return "N";
            default:return null;
        }

    }

    /**
     * Converts the data stored in the database column into the
     * value to be stored in the entity attribute.
     * Note that it is the responsibility of the converter writer to
     * specify the correct <code>dbData</code> type for the corresponding
     * column for use by the JDBC driver: i.e., persistence providers are
     * not expected to do such type conversion.
     *
     * @param dbData the data from the database column to be
     *               converted
     * @return the converted value to be stored in the entity
     * attribute
     */
    @Override
    public SimNao convertToEntityAttribute(String dbData) {

        if(dbData == null){
            return null;
        }
        switch (dbData){
            case "S":
                return SimNao.SIM;
            case "N":
                return SimNao.NAO;

        }
        return null;
    }
}
