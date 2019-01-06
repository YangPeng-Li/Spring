package com.lyp.xtreamDemo;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * 分流层的转换器
 * 
 *	@author Lyp
 * 2018年12月12日
 * 上午10:51:31
 */


public class SqlItemCoverter implements Converter {
	
	
	
	/*
	 * 
	 *  HierarchicalStreamWriter 分流层的写
	 *  MarshallingContext 数据编组上下文
	 */
	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		

	}
	
	/**
	 * 
	 */
	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean canConvert(Class type) {
		// TODO Auto-generated method stub
		return false;
	}

}
