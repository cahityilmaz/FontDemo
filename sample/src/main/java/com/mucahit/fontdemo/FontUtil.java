package com.mucahit.fontdemo;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author mucah
 */
public class FontUtil {

    public static void initCustomFontSize(int uiFontSize) {
        Font nbDialogPlain = new FontUIResource("Dialog", Font.PLAIN, uiFontSize); // NOI18N
        Font nbDialogBold = new FontUIResource("Dialog", Font.BOLD, uiFontSize); // NOI18N
        Font nbSerifPlain = new FontUIResource("Serif", Font.PLAIN, uiFontSize); // NOI18N
        Font nbSansSerifPlain = new FontUIResource("SansSerif", Font.PLAIN, uiFontSize); // NOI18N
        Font nbMonospacedPlain = new FontUIResource("Monospaced", Font.PLAIN, uiFontSize); // NOI18N

        Map<Font, Font> fontTranslation = new HashMap<>(5);

        if ("Nimbus".equals(UIManager.getLookAndFeel().getID())) { //NOI18N
            switchFont("defaultFont", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        }
        switchFont("controlFont", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("Button.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("ToggleButton.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("RadioButton.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("CheckBox.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("ColorChooser.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("ComboBox.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("Label.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("List.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("FileChooser.listFont", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("MenuBar.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("MenuItem.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("MenuItem.acceleratorFont", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("RadioButtonMenuItem.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("CheckBoxMenuItem.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("Menu.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("PopupMenu.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("OptionPane.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("OptionPane.messageFont", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("Panel.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("ProgressBar.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("ScrollPane.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("Viewport.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("TabbedPane.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("Table.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("TableHeader.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("TextField.font", fontTranslation, uiFontSize, nbSansSerifPlain); // NOI18N
        switchFont("PasswordField.font", fontTranslation, uiFontSize, nbMonospacedPlain); // NOI18N
        switchFont("TextArea.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("TextPane.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("EditorPane.font", fontTranslation, uiFontSize, nbSerifPlain); // NOI18N
        switchFont("TitledBorder.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("ToolBar.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("ToolTip.font", fontTranslation, uiFontSize, nbSansSerifPlain); // NOI18N
        switchFont("Tree.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("InternalFrame.titleFont", fontTranslation, uiFontSize, nbDialogBold); // NOI18N
        switchFont("windowTitleFont", fontTranslation, uiFontSize, nbDialogBold); // NOI18N
        switchFont("Spinner.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("FormattedTextField.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
        switchFont("Slider.font", fontTranslation, uiFontSize, nbDialogPlain); // NOI18N
    }

    private static final boolean isWindows = null != UIManager.getLookAndFeel()
            && "Windows".equals(UIManager.getLookAndFeel().getID());

    private static void switchFont(String uiKey, Map<Font, Font> fontTranslation, int uiFontSize, Font defaultFont) {
        Font oldFont = UIManager.getFont(uiKey);
        Font newFont = null == oldFont ? defaultFont : fontTranslation.get(oldFont);
        if (null == newFont) {
            if (isWindows) {
                newFont = oldFont.deriveFont((float) uiFontSize);
            } else {
                newFont = new FontUIResource(oldFont.getFontName(), oldFont.getStyle(), uiFontSize);
            }
            fontTranslation.put(oldFont, newFont);
        }
//        UIManager.getLookAndFeelDefaults().replace(uiKey, newFont);
        UIManager.put(uiKey, newFont);
    }
}
