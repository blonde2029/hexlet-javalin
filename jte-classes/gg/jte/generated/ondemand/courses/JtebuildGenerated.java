package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.BuildCoursePage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,2,2,4,4,5,5,6,6,6,7,7,8,8,10,10,15,15,15,15,15,15,15,15,21,21,21,21,21,21,21,21,25};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildCoursePage page) {
		if (page.getErrors() != null) {
			jteOutput.writeContent("\n    <ul>\n        ");
			for (var validator : page.getErrors().values()) {
				jteOutput.writeContent("\n            ");
				for (var error : validator) {
					jteOutput.writeContent("\n                <li>");
					jteOutput.setContext("li", null);
					jteOutput.writeUserContent(error.getMessage());
					jteOutput.writeContent("</li>\n            ");
				}
				jteOutput.writeContent("\n        ");
			}
			jteOutput.writeContent("\n    </ul>\n");
		}
		jteOutput.writeContent("\n<form action=\"/courses\" method=\"post\">\n    <div>\n        <label>\n            Course name\n            <input type=\"text\" name=\"name\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(page.getName())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(page.getName());
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("/>\n        </label>\n    </div>\n    <div>\n        <label>\n            Description\n            <input type=\"text\" name=\"description\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(page.getDescription())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(page.getDescription());
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("/>\n        </label>\n    </div>\n    <input type=\"submit\" value=\"Create\"/>\n</form>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildCoursePage page = (BuildCoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
