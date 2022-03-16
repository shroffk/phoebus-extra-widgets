package org.csstudio.display.extra.widgets;

import org.csstudio.display.builder.model.WidgetDescriptor;
import org.csstudio.display.builder.model.spi.WidgetsService;
import org.csstudio.display.extra.widgets.thumbnail.ThumbwheelWidget;
import org.csstudio.display.extra.widgets.waterfall.WaterfallWidget;

import java.util.Collection;
import java.util.List;

/**
 * A widget service for which provided additional widgets
 */
public class ExtraWidgetService implements WidgetsService
{
    @Override
    public Collection<WidgetDescriptor> getWidgetDescriptors()
    {
        return List.of(
                WaterfallWidget.WIDGET_DESCRIPTOR,
                ThumbwheelWidget.WIDGET_DESCRIPTOR );
    }
}
