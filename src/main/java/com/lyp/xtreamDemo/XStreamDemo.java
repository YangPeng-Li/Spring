package com.lyp.xtreamDemo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 
 * 
 *	@author Lyp
 * 2018��12��12��
 * ����10:00:05
 */
public class XStreamDemo {
	
	private XStream  xStream = new XStream(new DomDriver());
	
	{
		xStream.useAttributeFor(FileItem.class,"okFileDelete");
	}
	

}
