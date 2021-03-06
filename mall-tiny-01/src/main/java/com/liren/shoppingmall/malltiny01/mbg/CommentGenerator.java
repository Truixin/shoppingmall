package com.liren.shoppingmall.malltiny01.mbg;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;

/**
 * @description:自定义注释生成器
 * @author: tianruixin
 * @date: 2020/4/16 0:17
 */
public class CommentGenerator extends DefaultCommentGenerator {
    private boolean addRemarkComments = false;

    /**
     * @param properties
     * @return
     * @Description: 设置用户配置的参数
     * @Author tianruixin
     * @Date 2020/4/16 0:38
     **/
    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
        this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
    }

    /**
     * @param field
     * @param introspectedTable
     * @param introspectedColumn
     * @return
     * @Description: 给字段添加注释
     * @Author tianruixin
     * @Date 2020/4/16 0:38
     **/
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks();
        //根据参数和备注信息判断是否添加备注信息
        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            addFieldJavaDoc(field, remarks);
        }
    }

    /**
     * @param field
     * @param remarks
     * @return
     * @Description: 给model的字段添加注释
     * @Author tianruixin
     * @Date 2020/4/16 0:37
     **/
    private void addFieldJavaDoc(Field field, String remarks) {
        //文档注释开始
        field.addJavaDocLine("/**");
        //获取数据库字段的备注信息
        String[] remarkLines = remarks.split(System.getProperty("line.separator"));
        for (String remarkLine : remarkLines) {
            field.addJavaDocLine(" * " + remarkLine);
        }
        addJavadocTag(field, false);
        field.addJavaDocLine(" */");
    }
}
