package org.csstudio.display.extra.widgets.waterfall;

import org.csstudio.display.builder.model.Widget;
import org.csstudio.display.builder.model.WidgetCategory;
import org.csstudio.display.builder.model.WidgetDescriptor;
import org.csstudio.display.builder.model.widgets.VisibleWidget;

import java.util.Collections;

public class WaterfallWidget extends VisibleWidget {

    /** Widget descriptor */
    public static final WidgetDescriptor WIDGET_DESCRIPTOR =
            new WidgetDescriptor("waterfall", WidgetCategory.PLOT,
                    "Waterfall",
                    "/icons/waterfall.png",
                    "Display a waterfall",
                    Collections.emptyList())
            {
                @Override
                public Widget createWidget()
                {
                    return new WaterfallWidget();
                }
            };

    public WaterfallWidget()
    {
        super(WIDGET_DESCRIPTOR.getType(), 150, 100);
    }

}
