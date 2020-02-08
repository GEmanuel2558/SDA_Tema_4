package sda.tema.SDA_Tema_4.controller.auth.payload.extra;

import java.io.Serializable;

public class UserIdentityAvailability implements Serializable {

    private Boolean available;

    public UserIdentityAvailability(Boolean available) {
        this.available = available;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

}
