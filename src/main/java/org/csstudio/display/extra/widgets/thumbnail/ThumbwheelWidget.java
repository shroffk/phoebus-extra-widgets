package org.csstudio.display.extra.widgets.thumbnail;

import org.csstudio.display.builder.model.Widget;
import org.csstudio.display.builder.model.WidgetCategory;
import org.csstudio.display.builder.model.WidgetDescriptor;
import org.csstudio.display.builder.model.widgets.VisibleWidget;

import java.util.Collections;

public class ThumbwheelWidget extends VisibleWidget {

    /** Widget descriptor */
    public static final WidgetDescriptor WIDGET_DESCRIPTOR =
            new WidgetDescriptor("thumbwheel", WidgetCategory.MONITOR,
                    "Thumbwheel",
                    "/icons/thumbwheel.gif",
                    "Display a thumbwheel",
                    Collections.emptyList())
            {
                @Override
                public Widget createWidget()
                {
                    return new ThumbwheelWidget();
                }
            };

    public ThumbwheelWidget()
    {
        super(WIDGET_DESCRIPTOR.getType(), 150, 100);
    }

}
