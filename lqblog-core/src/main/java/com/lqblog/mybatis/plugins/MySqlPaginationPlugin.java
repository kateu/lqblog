package com.lqblog.mybatis.plugins;

import com.lqblog.mybatis.pojo.Page;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;


public class MySqlPaginationPlugin extends PluginAdapter {

    /**
     * maper.xml里的MySql 分页前部分声明命名
     */
    private static final String MySql_PAGINATION_PREFIX = "MySqlPaginationPrefix";

    /**
     * maper.xml里的MySql 分页后部分声明命名
     */
    private static final String MySql_PAGINATION_SUFFIX = "MySqlPaginationSuffix";

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // add field, getter, setter for limit clause
        // addPage(topLevelClass, introspectedTable, "page");
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        XmlElement parentElement = document.getRootElement();
        // 产生分页语句前半部分
        XmlElement paginationPrefixElement = new XmlElement("sql");
        paginationPrefixElement.addAttribute(new Attribute("id", MySql_PAGINATION_PREFIX));
        XmlElement pageStart = new XmlElement("if");
        pageStart.addAttribute(new Attribute("test", "page != null"));
        pageStart.addElement(new TextElement("SELECT MYSQLPAGE.* FROM ( "));
        paginationPrefixElement.addElement(pageStart);
        parentElement.addElement(paginationPrefixElement);
        // 产生分页语句后半部分
        XmlElement paginationSuffixElement = new XmlElement("sql");
        paginationSuffixElement.addAttribute(new Attribute("id", MySql_PAGINATION_SUFFIX));
        XmlElement pageEnd = new XmlElement("if");
        pageEnd.addAttribute(new Attribute("test", "page != null"));
        pageEnd.addElement(new TextElement("<![CDATA[ ) AS MYSQLPAGE ORDER BY ${orderByClause} LIMIT #{page."
                + Page.FieldDomain.RECORD_INDEX + "}, #{page." + Page.FieldDomain.PAGE_SIZE + "} ]]>"));
        paginationSuffixElement.addElement(pageEnd);
        parentElement.addElement(paginationSuffixElement);
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
                                                                     IntrospectedTable introspectedTable) {
        XmlElement pageStart = new XmlElement("include"); //$NON-NLS-1$
        pageStart.addAttribute(new Attribute("refid", MySql_PAGINATION_PREFIX));
        element.getElements().add(0, pageStart);
        XmlElement isNotNullElement = new XmlElement("include"); //$NON-NLS-1$
        isNotNullElement.addAttribute(new Attribute("refid", MySql_PAGINATION_SUFFIX));
        element.getElements().add(isNotNullElement);
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    // /**
    // * 增加page属性，并生产get,set方法
    // * @param topLevelClass
    // * @param introspectedTable
    // * @param name
    // */
    // private void addPage(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {
    // topLevelClass.addImportedType(new FullyQualifiedJavaType(PAGE_CLASS_NAME));
    // CommentGenerator commentGenerator = context.getCommentGenerator();
    // Field field = new Field();
    // field.setVisibility(JavaVisibility.PROTECTED);
    // field.setType(new FullyQualifiedJavaType(PAGE_CLASS_NAME));
    // field.setName(name);
    // commentGenerator.addFieldComment(field, introspectedTable);
    // topLevelClass.addField(field);
    // char c = name.charAt(0);
    // String camel = Character.toUpperCase(c) + name.substring(1);
    // Method method = new Method();
    // method.setVisibility(JavaVisibility.PUBLIC);
    // method.setName("set" + camel);
    // method.addParameter(new Parameter(new FullyQualifiedJavaType(PAGE_CLASS_NAME), name));
    // method.addBodyLine("this." + name + "=" + name + ";");
    // commentGenerator.addGeneralMethodComment(method, introspectedTable);
    // topLevelClass.addMethod(method);
    // method = new Method();
    // method.setVisibility(JavaVisibility.PUBLIC);
    // method.setReturnType(new FullyQualifiedJavaType(PAGE_CLASS_NAME));
    // method.setName("get" + camel);
    // method.addBodyLine("return " + name + ";");
    // commentGenerator.addGeneralMethodComment(method, introspectedTable);
    // topLevelClass.addMethod(method);
    // }

    /**
     * This plugin is always valid - no properties are required
     */
    public boolean validate(List<String> warnings) {
        return true;
    }
}