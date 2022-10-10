package org.csstudio.display.extra.widgets.thumbnail;

import org.csstudio.display.builder.model.DirtyFlag;
import org.csstudio.display.builder.model.UntypedWidgetPropertyListener;
import org.csstudio.display.builder.model.WidgetProperty;
import org.csstudio.display.builder.representation.javafx.JFXUtil;
import org.csstudio.display.builder.representation.javafx.widgets.JFXBaseRepresentation;
import org.phoebus.ui.javafx.Styles;
import se.europeanspallationsource.javafx.control.thumbwheel.ThumbWheel;

public class ThumbwheelWidgetRepresentation extends JFXBaseRepresentation<ThumbWheel, ThumbwheelWidget> {

    private final DirtyFlag dirty_style = new DirtyFlag();
    private final UntypedWidgetPropertyListener styleListener = this::styleChanged;

    @Override
    protected ThumbWheel createJFXNode() throws Exception {
        final ThumbWheel thumbWheel = new ThumbWheel();
        return thumbWheel;
    }

    @Override
    protected void registerListeners() {
        super.registerListeners();
        model_widget.propWidth().addUntypedPropertyListener(styleListener);
        model_widget.propHeight().addUntypedPropertyListener(styleListener);

        model_widget.propForegroundColor().addUntypedPropertyListener(styleListener);
        model_widget.propBackgroundColor().addUntypedPropertyListener(styleListener);
        model_widget.propIncrementColor().addUntypedPropertyListener(styleListener);
        model_widget.propDecrementColor().addUntypedPropertyListener(styleListener);
        model_widget.propInvalidColor().addUntypedPropertyListener(styleListener);

        model_widget.propFont().addUntypedPropertyListener(styleListener);
        model_widget.propDecimalDigits().addUntypedPropertyListener(styleListener);
        model_widget.propIntegerDigits().addUntypedPropertyListener(styleListener);
        model_widget.propMinimum().addUntypedPropertyListener(styleListener);
        model_widget.propMaximum().addUntypedPropertyListener(styleListener);

        model_widget.propEnabled().addUntypedPropertyListener(styleListener);
        model_widget.propGraphicVisible().addUntypedPropertyListener(styleListener);
        model_widget.propScrollEnabled().addUntypedPropertyListener(styleListener);
        model_widget.propSpinnerShaped().addUntypedPropertyListener(styleListener);
        model_widget.runtimePropPVWritable().addUntypedPropertyListener(styleListener);


    }

    @Override
    protected void unregisterListeners() {
        super.unregisterListeners();
        model_widget.propWidth().removePropertyListener(styleListener);
        model_widget.propHeight().removePropertyListener(styleListener);

        model_widget.propForegroundColor().removePropertyListener(styleListener);
        model_widget.propBackgroundColor().removePropertyListener(styleListener);
        model_widget.propIncrementColor().removePropertyListener(styleListener);
        model_widget.propDecrementColor().removePropertyListener(styleListener);
        model_widget.propInvalidColor().removePropertyListener(styleListener);

        model_widget.propFont().removePropertyListener(styleListener);
        model_widget.propDecimalDigits().removePropertyListener(styleListener);
        model_widget.propIntegerDigits().removePropertyListener(styleListener);
        model_widget.propMinimum().removePropertyListener(styleListener);
        model_widget.propMaximum().removePropertyListener(styleListener);

        model_widget.propEnabled().removePropertyListener(styleListener);
        model_widget.propGraphicVisible().removePropertyListener(styleListener);
        model_widget.propScrollEnabled().removePropertyListener(styleListener);
        model_widget.propSpinnerShaped().removePropertyListener(styleListener);
        model_widget.runtimePropPVWritable().removePropertyListener(styleListener);
    }

    @Override
    public void updateChanges() {
        super.updateChanges();
        if (dirty_style.checkAndClear()) {

            jfx_node.setBackgroundColor(JFXUtil.convert(model_widget.propBackgroundColor().getValue()));
            jfx_node.setForegroundColor(JFXUtil.convert(model_widget.propForegroundColor().getValue()));
            jfx_node.setPrefWidth(model_widget.propWidth().getValue());
            jfx_node.setPrefHeight(model_widget.propHeight().getValue());

            jfx_node.setIncrementButtonsColor(JFXUtil.convert(model_widget.propIncrementColor().getValue()));
            jfx_node.setDecrementButtonsColor(JFXUtil.convert(model_widget.propDecrementColor().getValue()));
            jfx_node.setInvalidColor(JFXUtil.convert(model_widget.propInvalidColor().getValue()));

            jfx_node.setFont(JFXUtil.convert(model_widget.propFont().getValue()));
            jfx_node.setDecimalDigits(model_widget.propDecimalDigits().getValue());
            jfx_node.setIntegerDigits(model_widget.propIntegerDigits().getValue());
            jfx_node.setMinValue(model_widget.propMinimum().getValue());
            jfx_node.setMaxValue(model_widget.propMaximum().getValue());

            // Enable if enabled by user and there's write access
            final boolean enabled = model_widget.propEnabled().getValue()  &&
                    model_widget.runtimePropPVWritable().getValue();
            Styles.update(jfx_node, Styles.NOT_ENABLED, !enabled);
//            jfx_node.setEditable(!toolkit.isEditMode() && enabled);
//            jfx_node.getEditor().setCursor(enabled ? Cursor.DEFAULT : Cursors.NO_WRITE);

            jfx_node.setGraphicVisible(model_widget.propGraphicVisible().getValue());
            jfx_node.setScrollEnabled(model_widget.propScrollEnabled().getValue());
            jfx_node.setSpinnerShaped(model_widget.propSpinnerShaped().getValue());


        }
        jfx_node.layout();
    }

    private void styleChanged(final WidgetProperty<?> property, final Object old_value, final Object new_value)
    {
        dirty_style.mark();
        toolkit.scheduleUpdate(this);
    }

}
