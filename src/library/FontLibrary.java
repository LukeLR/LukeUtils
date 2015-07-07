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

package library;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import logging.Logger;

public class FontLibrary {
	public FontLibrary(){
		
	}
	
	public static Font sevenSegment(int size){
		Font sevenSegment;
		try{
			sevenSegment = Font.createFont(Font.TRUETYPE_FONT, new FontLibrary().getClass().getClassLoader().getResource("res/digital7mono.ttf").openStream()).deriveFont(Font.PLAIN, size);
		} catch (IOException ex){
			ex.printStackTrace();
			sevenSegment = new javax.swing.JLabel().getFont();
			Logger.logException(new FontLibrary(), "Error when creating SevenSegment-Object", ex);
			System.exit(0);
		} catch (FontFormatException e) {
			e.printStackTrace();
			sevenSegment = new javax.swing.JLabel().getFont();
			System.exit(0);
		}
		return sevenSegment;
	}
	
	public static Font sevenSegment(){
		return sevenSegment(20);
	}
}
