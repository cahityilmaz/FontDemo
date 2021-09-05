package com.mucahit.fontdemo;

import java.util.prefs.Preferences;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.openide.modules.ModuleInstall;
import org.openide.util.Exceptions;
import org.openide.util.NbPreferences;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        String laf = "com.formdev.flatlaf.FlatLightLaf";
        try {
            UIManager.setLookAndFeel(laf);
            Preferences prefs = NbPreferences.forModule(FontPanel.class);
            int fontSize = prefs.getInt("fontSize", 12);
            FontUtil.initCustomFontSize(fontSize);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

}
