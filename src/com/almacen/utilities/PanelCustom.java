package com.almacen.utilities;

import javax.swing.JPanel;

public class PanelCustom {

    private JPanel container;
    private JPanel content;

    public PanelCustom(JPanel container, JPanel content) {
        this.container = container;
        this.content = content;
        this.container.removeAll();
        this.container.revalidate();
        this.container.repaint();

        this.container.add(this.content);
        this.container.revalidate();
        this.container.repaint();
    }

}
