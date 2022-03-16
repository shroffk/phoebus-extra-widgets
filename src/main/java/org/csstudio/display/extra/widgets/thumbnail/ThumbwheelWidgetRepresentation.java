package org.csstudio.display.extra.widgets.thumbnail;

import javafx.scene.image.ImageView;
import org.csstudio.display.builder.representation.javafx.widgets.JFXBaseRepresentation;

public class ThumbwheelWidgetRepresentation extends JFXBaseRepresentation<ImageView, ThumbwheelWidget> {

    @Override
    protected ImageView createJFXNode() throws Exception {
        final ImageView iv = new ImageView();
        return iv;
    }
}
