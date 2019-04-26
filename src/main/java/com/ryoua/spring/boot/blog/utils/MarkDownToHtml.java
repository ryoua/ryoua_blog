package com.ryoua.spring.boot.blog.utils;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.options.MutableDataSet;

import java.util.Arrays;

/**
 * @Author ryoua Created on 2019-04-25
 */
public class MarkDownToHtml {
    /**
     * 直接将markdown语义的文本转为html格式输出
     * @param content markdown语义文本
     * @return
     */
    public static String markDownToHtml(String content) {
        String html = parse(content);
        return html;
    }
    /**
     * markdown to image
     * @param content markdown contents
     * @return parse html contents
     */
    public static String parse(String content) {
        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);
        //enable table parse!
        options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        Node document = parser.parse(content);
        return renderer.render(document);
    }
}
