package br.com.incode.regenerari.enums.converter;

import br.com.incode.regenerari.enums.Perfil;

import javax.persistence.AttributeConverter;

/**
 * Created by leandrolima on 10/01/17.
 */
public class PerfilConverter implements AttributeConverter<Perfil, String> {
    /**
     * Converts the value stored in the entity attribute into the
     * data representation to be stored in the database.
     *
     * @param perfil the entity attribute value to be converted
     * @return the converted data to be stored in the database
     * column
     */
    @Override
    public String convertToDatabaseColumn(Perfil perfil) {


        if(perfil ==null){
            return null;
        }

        switch (perfil){
            case ADMIN:
                return "ADMIN";
            case USUARIO:
                return "USUARIO";

            default: return null;
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
    public Perfil convertToEntityAttribute(String dbData) {

        if(dbData ==null){
            return null;
        }

        switch (dbData){
            case "ADMIN":
                return Perfil.ADMIN;
            case "USUARIO":
                return Perfil.USUARIO;
        }
        return null;
    }
}
