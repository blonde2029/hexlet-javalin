package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.BuildUserPage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,3,5,5,6,6,7,7,7,8,8,9,9,11,11,17,17,17,17,17,17,17,17,23,23,23,23,23,23,23,23,40};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildUserPage page) {
		jteOutput.writeContent("\n");
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
		jteOutput.writeContent("\n\n<form action=\"/users\" method=\"post\">\n    <div>\n        <label>\n            Name\n            <input type=\"text\" name=\"name\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(page.getName())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(page.getName());
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("/>\n        </label>\n    </div>\n    <div>\n        <label>\n            Email\n            <input type=\"email\" required name=\"email\"");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(page.getEmail())) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(page.getEmail());
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("/>\n        </label>\n    </div>\n    <div>\n        <label>\n            Password\n            <input type=\"password\" required name=\"password\" />\n        </label>\n    </div>\n    <div>\n        <label>\n            Confirm password\n            <input type=\"password\" required name=\"passwordConfirmation\" />\n        </label>\n    </div>\n    <input type=\"submit\" value=\"Register\" />\n</form>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildUserPage page = (BuildUserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
