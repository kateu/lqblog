package com.lqblog.mybatis.plugins;

import com.lqblog.mybatis.pojo.BaseExample;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * @author xiezm
 */
public class ModelExamplePlugin extends PluginAdapter {

	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		topLevelClass.setSuperClass(BaseExample.class.getName());
//        topLevelClass.addImportedType(BaseExample.class.getName());
		topLevelClass.addImportedType(new FullyQualifiedJavaType("com.lqblog.mybatis.pojo.BaseExample"));
		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}

	/**
	 * This plugin is always valid - no properties are required
	 */
	public boolean validate(List<String> warnings) {
		return true;
	}
}