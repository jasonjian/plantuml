/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2017, Arnaud Roques
 *
 * Project Info:  http://plantuml.com
 * 
 * If you like this project or if you find it useful, you can support us at:
 * 
 * http://plantuml.com/patreon (only 1$ per month!)
 * http://plantuml.com/paypal
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 *
 * Original Author:  Arnaud Roques
 *
 */
package net.sourceforge.plantuml.ugraphic;

import java.awt.geom.Dimension2D;

public class URectangle extends AbstractShadowable implements Scalable, UShapeSized {

	private final double width;
	private final double height;
	private final double rx;
	private final double ry;
	private final String comment;

	public UShape getScaled(double scale) {
		if (scale == 1) {
			return this;
		}
		final AbstractShadowable result = new URectangle(width * scale, height * scale, rx * scale, ry * scale, comment);
		result.setDeltaShadow(this.getDeltaShadow());
		return result;
	}

	public URectangle(double width, double height) {
		this(width, height, 0, 0, null);
	}

	public URectangle(double width, double height, double rx, double ry) {
		this(width, height, rx, ry, null);
	}

	public URectangle(double width, double height, double rx, double ry, String comment) {
		// if (height == 0) {
		// throw new IllegalArgumentException();
		// }
		if (width == 0) {
			throw new IllegalArgumentException();
		}
		this.comment = comment;
		this.width = width;
		this.height = height;
		this.rx = rx;
		this.ry = ry;
	}

	public URectangle(Dimension2D dim) {
		this(dim.getWidth(), dim.getHeight());
	}

	@Override
	public String toString() {
		return "width=" + width + " height=" + height;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double getRx() {
		return rx;
	}

	public double getRy() {
		return ry;
	}

	public URectangle clip(UClip clip) {
		return this;
	}

	public MinMax getMinMax() {
		return MinMax.fromMax(width, height);
	}

	public final String getComment() {
		return comment;
	}

}
