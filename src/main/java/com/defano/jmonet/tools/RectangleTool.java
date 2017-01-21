package com.defano.jmonet.tools;

import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.base.AbstractBoundsTool;

import java.awt.*;

/**
 * Draws outlined or filled rectangles/squares on the canvas.
 */
public class RectangleTool extends AbstractBoundsTool {

    public RectangleTool() {
        super(PaintToolType.RECTANGLE);
    }

    @Override
    public void drawBounds(Graphics2D g, Stroke stroke, Paint paint, int x, int y, int width, int height) {
        g.setStroke(stroke);
        g.setPaint(paint);
        g.drawRect(x, y, width, height);
    }

    @Override
    public void drawFill(Graphics2D g, Paint fill, int x, int y, int width, int height) {
        g.setPaint(getFillPaint());
        g.fillRect(x, y, width, height);
    }
}