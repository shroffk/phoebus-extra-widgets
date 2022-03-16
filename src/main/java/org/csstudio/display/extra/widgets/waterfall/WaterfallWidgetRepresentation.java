package org.csstudio.display.extra.widgets.waterfall;

import javafx.scene.image.ImageView;
import org.csstudio.display.builder.representation.javafx.widgets.JFXBaseRepresentation;

public class WaterfallWidgetRepresentation extends JFXBaseRepresentation<ImageView, WaterfallWidget> {


    @Override
    protected ImageView createJFXNode() throws Exception {
        final ImageView iv = new ImageView();
        return iv;
    }
}
