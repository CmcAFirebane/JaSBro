package jasbro.gui.objects.div;

import jasbro.game.housing.House;
import jasbro.game.interfaces.AreaInterface;
import jasbro.texts.TextUtil;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class HouseInfoPanel extends JPanel {
    private JLabel dirtLabel;
    private JLabel fameLabel;
    public HouseInfoPanel() {
        setLayout(new FormLayout(new ColumnSpec[] {
                ColumnSpec.decode("default:grow"),
                FormFactory.DEFAULT_COLSPEC,
                FormFactory.UNRELATED_GAP_COLSPEC,
                FormFactory.DEFAULT_COLSPEC,
                FormFactory.UNRELATED_GAP_COLSPEC,},
            new RowSpec[] {
                RowSpec.decode("default:grow"),}));
        setOpaque(false);
        
        fameLabel = new JLabel();
        fameLabel.setOpaque(false);
        add(fameLabel, "2, 1");
        
        dirtLabel = new JLabel();
        dirtLabel.setOpaque(false);
        add(dirtLabel, "4, 1");
        
    }
    
    public void refresh(AreaInterface area) {
        if (area instanceof House) {
            House house = (House) area;
            fameLabel.setText(TextUtil.t("fame")+": " + house.getFame().getFameBuilding().getText());
            Object arguments[] = {house.getFame().getFame()};
            fameLabel.setToolTipText(TextUtil.t("formatted", arguments));
            dirtLabel.setText(TextUtil.t("ui.state")+": " + house.getCleanState().getText());
            arguments[0] = house.getDirt();
            dirtLabel.setToolTipText(TextUtil.t("formatted", arguments));
        }
        else {
            fameLabel.setToolTipText("");
            fameLabel.setText("");
            dirtLabel.setText("");
            dirtLabel.setToolTipText("");
        }
    }
}
