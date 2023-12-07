package gg.jte.generated.ondemand.courses;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {14,14,14,14,14,14};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<form action=\"/courses\" method=\"post\">\n    <div>\n        <label>\n            Course name\n            <input type=\"text\" name=\"name\"/>\n        </label>\n    </div>\n    <div>\n        <label>\n            Description\n            <input type=\"text\" name=\"description\"/>\n        </label>\n    </div>\n    <input type=\"submit\" value=\"Create\"/>\n</form>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
