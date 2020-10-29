package com.almacen.utilities;

import java.awt.Color;

public class Tools {

    public Tools() {
    }

    public void buttonSelected(BotonCustom boton1, BotonCustom boton2, BotonCustom boton3,
            BotonCustom boton4, BotonCustom boton5, BotonCustom boton6) {
        if (boton1.isSelected()) {
            boton1.setColorNormal(new Color(0, 32, 96));
            boton1.setColorHover(new Color(0, 32, 96));
            boton1.setColorPressed(new Color(0, 32, 96));

            boton2.setColorNormal(new Color(238, 161, 8));
            boton2.setColorHover(new Color(38, 86, 186));
            boton2.setColorPressed(new Color(0, 32, 96));

            boton3.setColorNormal(new Color(238, 161, 8));
            boton3.setColorHover(new Color(38, 86, 186));
            boton3.setColorPressed(new Color(0, 32, 96));

            boton4.setColorNormal(new Color(238, 161, 8));
            boton4.setColorHover(new Color(38, 86, 186));
            boton4.setColorPressed(new Color(0, 32, 96));

            boton5.setColorNormal(new Color(238, 161, 8));
            boton5.setColorHover(new Color(38, 86, 186));
            boton5.setColorPressed(new Color(0, 32, 96));

            boton6.setColorNormal(new Color(238, 161, 8));
            boton6.setColorHover(new Color(38, 86, 186));
            boton6.setColorPressed(new Color(0, 32, 96));

        } else {
            boton1.setColorNormal(new Color(238, 161, 8));
            boton1.setColorHover(new Color(38, 86, 186));
            boton1.setColorPressed(new Color(0, 32, 96));
        }
    }

    public void buttonPressed(BotonCustom boton1, BotonCustom boton2, BotonCustom boton3,
           BotonCustom boton4, BotonCustom boton5, BotonCustom boton6) {
        boton1.setSelected(true);
        boton2.setSelected(false);
        boton3.setSelected(false);
        boton4.setSelected(false);
        boton5.setSelected(false);
        boton6.setSelected(false);
    }
}
