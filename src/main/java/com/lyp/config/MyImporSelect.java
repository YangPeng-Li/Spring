package com.lyp.config;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

import com.lyp.entiry.Blue;


/**
 * 实现类Import 导入类的组件
 * @author lyp
 *
 */
public class MyImporSelect implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		
	
		return new String [] {"com.lyp.entiry.Blue","com.lyp.entiry.Yellow"};
	}

}
