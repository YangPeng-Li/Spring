package com.lyp.xtreamDemo;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * �������ת����
 * 
 *	@author Lyp
 * 2018��12��12��
 * ����10:51:31
 */


public class SqlItemCoverter implements Converter {
	
	
	
	/*
	 * 
	 *  HierarchicalStreamWriter �������д
	 *  MarshallingContext ���ݱ���������
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
