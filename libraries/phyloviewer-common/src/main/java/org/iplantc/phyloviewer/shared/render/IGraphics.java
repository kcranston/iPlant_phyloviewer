/**
 * Copyright (c) 2009, iPlant Collaborative, Texas Advanced Computing Center This software is licensed
 * under the CC-GNU GPL version 2.0 or later. License: http://creativecommons.org/licenses/GPL/2.0/
 */

package org.iplantc.phyloviewer.shared.render;

import org.iplantc.phyloviewer.shared.math.Box2D;
import org.iplantc.phyloviewer.shared.math.Matrix33;
import org.iplantc.phyloviewer.shared.math.Vector2;
import org.iplantc.phyloviewer.shared.render.style.IBranchStyle;
import org.iplantc.phyloviewer.shared.render.style.IGlyphStyle;
import org.iplantc.phyloviewer.shared.render.style.ILabelStyle;
import org.iplantc.phyloviewer.shared.render.style.INodeStyle;
import org.iplantc.phyloviewer.shared.scene.Text;

public interface IGraphics
{
	public abstract int getWidth();
	public abstract int getHeight();

	public abstract void clear();

	public abstract void drawPoint(Vector2 position);

	public abstract void drawLineStrip(Vector2[] vertices);

	public abstract void drawPolygon(Vector2 vertices[]);

	public abstract void drawText(Vector2 position, Vector2 offset, String text, double angle);

	public abstract void drawWedge(Vector2 center, Vector2 peak, double radius, double startAngle,
			double endAngle);
	
	public void setSize(int x, int y);

	public abstract void setViewMatrix(Matrix33 matrix);

	public abstract Matrix33 getViewMatrix();
	
	/**
	 * Get the matrix to convert object coordinates to screen coordinates.
	 * @return
	 */
	public Matrix33 getObjectToScreenMatrix();
	
	/**
	 * Get the matrix to convert screen coordinates to object coordinates.
	 * @return
	 */
	public Matrix33 getScreenToObjectMatrix();

	public abstract Boolean isCulled(Box2D iBox2D);

	public abstract void drawArc(Vector2 center, double radius, double startAngle, double endAngle);

	/**
	 * Sets the drawing style. Any element style fields that are null or NaN will leave the previous
	 * style in place for that field.
	 * 
	 * @param style
	 */
	public abstract void setStyle(IBranchStyle style);

	public abstract void setStyle(IGlyphStyle style);

	public abstract void setStyle(ILabelStyle style);

	public abstract void setStyle(INodeStyle style);
	
	public Box2D calculateBoundingBox(Text text);
}