package gg.jte.generated.ondemand.sessions;
import org.example.hexlet.dto.NamedRoutes;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "sessions/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,2,2,3,4,4,4,4,4,4,4,4,8};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n<form");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(NamedRoutes.sessionsPath())) {
			jteOutput.writeContent(" action=\"");
			jteOutput.setContext("form", "action");
			jteOutput.writeUserContent(NamedRoutes.sessionsPath());
			jteOutput.setContext("form", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" method=\"post\">\n    <input type=\"text\" placeholder=\"Nickname\" name=\"nickname\" />\n    <input type=\"password\" placeholder=\"Password\" name=\"password\" />\n    <input type=\"submit\" />\n</form>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
