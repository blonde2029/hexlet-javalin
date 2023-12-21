package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.NamedRoutes;
import org.example.hexlet.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,6,6,7,7,7,7,7,7,7,7,8,8,10,10,10,10,10,10,10,10,10,10,10,12,12,13,13,13,14};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <a");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(NamedRoutes.BuildUserPath())) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(NamedRoutes.BuildUserPath());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">New User</a>\n    ");
				for (var user : page.getUsers()) {
					jteOutput.writeContent("\n        <div>\n            <h2><a");
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(NamedRoutes.UserPath(user.getId()))) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(NamedRoutes.UserPath(user.getId()));
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(user.getName());
					jteOutput.writeContent("</a></h2>\n        </div>\n    ");
				}
				jteOutput.writeContent("\n");
			}
		}, null, page);
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
