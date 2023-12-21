package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import org.example.hexlet.dto.NamedRoutes;
import org.example.hexlet.dto.BasePage;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,17,17,18,19,20,21,22,23,24,24,25,25,25,26,26,29,29,29,29,29,29,29,29,30,30,30,30,30,30,30,30,33,33,33,41,41,41,44};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, Content footer, BasePage page) {
		jteOutput.writeContent("<!doctype html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"utf-8\" />\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n    <title>Hexlet Javalin Example</title>\n</head>\n<body>\n<p>\n    <h1><a href=\"/\">Main page</a></h1>\n");
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n");
		if (page != null && page.getFlash() != null) {
			jteOutput.writeContent("\n    <p>");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(page.getFlash());
			jteOutput.writeContent("</p>\n");
		}
		jteOutput.writeContent("\n<h2><a href=\"/sessions/build\">Login</a></h2>\n    <div>\n        <a");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(NamedRoutes.UsersPath())) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(NamedRoutes.UsersPath());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Users</a>\n        <a");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(NamedRoutes.CoursesPath())) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(NamedRoutes.CoursesPath());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Courses</a>\n    </div>\n</p>\n");
		jteOutput.setContext("body", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n\n<p>\n    <div>\n    <p>Thanks for visiting, you may also check my GitHub page via link down below</p>\n    <a href=\"https://github.com/blonde2029\">My GitHub page</a>\n</div>\n</p>\n");
		jteOutput.setContext("body", null);
		jteOutput.writeUserContent(footer);
		jteOutput.writeContent("\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		Content footer = (Content)params.getOrDefault("footer", null);
		BasePage page = (BasePage)params.getOrDefault("page", null);
		render(jteOutput, jteHtmlInterceptor, content, footer, page);
	}
}
