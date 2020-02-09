package sda.tema.SDA_Tema_4.controller.web.payload;

import sda.tema.SDA_Tema_4.repository.entitys.Continent;

public class ContinentDtoRequest extends ContinentDtoResponse {



    public ContinentDtoRequest(Continent continent) {
        super(continent);
    }
}
