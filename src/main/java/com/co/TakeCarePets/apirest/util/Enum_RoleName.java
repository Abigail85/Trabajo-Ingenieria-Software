package com.co.TakeCarePets.apirest.util;

import java.util.Arrays;

public enum Enum_RoleName {
    PERRO("Perro","1"),
    GATO("Gato","2"),
    HAMSTERES("Hamsteres","3"),
    PAJAROS("Pajaros","4"),
    PECES("Peces","5"),
    CONEJO("Conejo","6"),
    HURÓN("Hurón","7"),
    OTROS("Otros","8"),
    DEFAULT("N/A","N/A");
    private final String tipoMascota;
    private final String NumeroTipoMascota;
    Enum_RoleName(String tipoMascota,String numeroTipoMascota){
        this.tipoMascota=tipoMascota;
        this.NumeroTipoMascota=numeroTipoMascota;
    }
    public String getTipoMascota(){return tipoMascota;}
    public static String getNumeroTipoMascota(String tipoMascota){
        return Arrays.stream(values()).filter(trn ->trn.getTipoMascota().equalsIgnoreCase(tipoMascota)).findFirst().orElse(DEFAULT).NumeroTipoMascota;
    }


}
