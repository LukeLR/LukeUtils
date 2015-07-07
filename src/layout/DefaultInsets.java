/**
 * This file is part of LukeUtils.
 *
 * LukeUtils is free software: you can redistribute it and/or modify
 * it under the terms of the cc-by-nc-sa (Creative Commons Attribution-
 * NonCommercial-ShareAlike) as released by the Creative Commons
 * organisation, version 3.0.
 *
 * LukeUtils is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY.
 *
 * You should have received a copy of the cc-by-nc-sa-license along
 * with this LukeUtils. If not, see
 * <https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode>.
 *
 * Copyright Lukas Rose 2013 - 2015
 */

package layout;

import java.awt.Insets;

public class DefaultInsets {
	public static Insets firstItemLeft = new Insets(20, 10, 5, 0);
	public static Insets firstItemRight = new Insets (20, 0, 5, 10);
	public static Insets firstItemLeftRight = new Insets(20, 10, 5, 10);
	public static Insets itemLeft = new Insets (0, 10, 5, 0);
	public static Insets itemRight = new Insets (0, 0, 5, 10);
	public static Insets itemLeftRight = new Insets (0, 10, 5, 10);
	public static Insets lastItemLeft = new Insets (0, 10, 20, 0);
	public static Insets lastItemRight = new Insets (0, 0, 20, 10);
	public static Insets firstItemWideRight = new Insets (20, 0, 5, 50);
	public static Insets itemWideRight = new Insets (0, 0, 5, 50);
	public static Insets lastItemWideRight = new Insets (0, 0, 20, 50);
	public static Insets noInsets = new Insets (0, 0, 0, 0);
}