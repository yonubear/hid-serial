/*
  Part of the GUI for Processing library 
  	http://www.lagers.org.uk/g4p/index.html
	http://gui4processing.googlecode.com/svn/trunk/

  Copyright (c) 2008-12 Peter Lager

  This library is free software; you can redistribute it and/or
  modify it under the terms of the GNU Lesser General Public
  License as published by the Free Software Foundation; either
  version 2.1 of the License, or (at your option) any later version.

  This library is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
  Lesser General Public License for more details.

  You should have received a copy of the GNU Lesser General
  Public License along with this library; if not, write to the
  Free Software Foundation, Inc., 59 Temple Place, Suite 330,
  Boston, MA  02111-1307  USA
 */

package g4p_controls;

import processing.core.PApplet;

/**
 * A two-state toggle control. <br>
 * 
 * GOption objects (also known as radio buttons) are two-state toggle switches that can either
 * be used independently or if added to a GToggleGroup control part of a single selection 
 * option group.
 * 
 * @author Peter Lager
 *
 */
public class GOption extends GToggleControl{

	/**
	 * Create an option button without text.
	 * 
	 * @param theApplet that will display the control
	 * @param p0
	 * @param p1
	 * @param p2
	 * @param p3
	 */
	public GOption(PApplet theApplet, float p0, float p1, float p2, float p3) {
		this(theApplet, p0, p1, p2, p3, "");
	}

	/**
	 * Create an option button with text.
	 * 
	 * @param theApplet that will display the control
	 * @param p0
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param text text to be displayed
	 */
	public GOption(PApplet theApplet, float p0, float p1, float p2, float p3, String text) {
		super(theApplet, p0, p1, p2, p3);
		opaque = false;
		setText(text);
		setIcon("pinhead.png", 2, GAlign.LEFT, null);
		setTextAlign(GAlign.LEFT, null);
		z = Z_SLIPPY;
		// Now register control with applet
		createEventHandler(G4P.sketchApplet, "handleToggleControlEvents", 
				new Class<?>[]{ GToggleControl.class, GEvent.class }, 
				new String[]{ "option", "event" } 
		);
		registeredMethods = DRAW_METHOD | MOUSE_METHOD;
		cursorOver = HAND;
		G4P.addControl(this);
	}

}
