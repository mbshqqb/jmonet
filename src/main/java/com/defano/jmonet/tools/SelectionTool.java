package com.defano.jmonet.tools;

import com.defano.jmonet.model.PaintToolType;
import com.defano.jmonet.tools.base.AbstractSelectionTool;
import com.defano.jmonet.tools.util.Geometry;

import java.awt.*;

/**
 * A tool for drawing a rectangular selection on the canvas.
 */
public class SelectionTool extends AbstractSelectionTool {

    private Rectangle selectionBounds;

    public SelectionTool() {
        super(PaintToolType.SELECTION);
    }

    @Override
    public void addSelectionPoint(Point initialPoint, Point newPoint, boolean isShiftKeyDown) {
        selectionBounds = new Rectangle(initialPoint);
        selectionBounds.add(newPoint);

        selectionBounds = isShiftKeyDown ?
                Geometry.squareAtAnchor(initialPoint, newPoint) :
                Geometry.rectangleFromPoints(initialPoint, newPoint);
    }

    @Override
    public void completeSelection(Point finalPoint) {
        // Nothing to do
    }

    @Override
    public void resetSelection() {
        selectionBounds = null;
    }

    @Override
    public void setSelectionBounds(Rectangle bounds) {
        selectionBounds = bounds;
    }

    @Override
    public Shape getSelectionOutline() {
        return selectionBounds;
    }

    @Override
    public void adjustSelectionBounds(int xDelta, int yDelta) {
        selectionBounds.setLocation(selectionBounds.x + xDelta, selectionBounds.y + yDelta);
    }

}