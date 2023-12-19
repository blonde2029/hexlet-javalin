package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import org.example.hexlet.dto.NamedRoutes;
import org.example.hexlet.dto.MainPage;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,17,17,18,19,20,20,21,21,21,23,23,26,26,26,26,26,26,26,26,27,27,27,27,27,27,27,27,30,30,30,38,38,38,41};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, Content footer, MainPage page) {
		jteOutput.writeContent("<!doctype html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"utf-8\" />\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n    <title>Hexlet Javalin Example</title>\n</head>\n<body>\n<p>\n    <h1><a href=\"/\">Main page</a></h1>\n");
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n");
		if (page.getCurrentUser() != null) {
			jteOutput.writeContent("\n    Добро пожаловать, ");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(page.getCurrentUser());
			jteOutput.writeContent(".\n    Чтобы разлогиниться, удалите куку JSESSIONID из браузера\n");
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
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, content, footer, page);
	}
}
