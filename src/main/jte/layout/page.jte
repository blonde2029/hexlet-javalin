@import gg.jte.Content
@import org.example.hexlet.dto.NamedRoutes
@import org.example.hexlet.dto.BasePage

@param Content content
@param Content footer = null
@param BasePage page = null
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin Example</title>
</head>
<body>
<p>
    <h1><a href="/">Main page</a></h1>
<%--    @if (!page.isVisited())--%>
<%--        <p>This message shows only once. To see it again delete cookies.</p>--%>
<%--    @endif--%>
<%--@if (page.getCurrentUser() != null)--%>
<%--    Добро пожаловать, ${page.getCurrentUser()}.--%>
<%--    Чтобы разлогиниться, удалите куку JSESSIONID из браузера--%>
<%--@endif--%>
@if (page != null && page.getFlash() != null)
    <p>${page.getFlash()}</p>
@endif
<h2><a href="/sessions/build">Login</a></h2>
    <div>
        <a href="${NamedRoutes.UsersPath()}">Users</a>
        <a href="${NamedRoutes.CoursesPath()}">Courses</a>
    </div>
</p>
${content}

<p>
    <div>
    <p>Thanks for visiting, you may also check my GitHub page via link down below</p>
    <a href="https://github.com/blonde2029">My GitHub page</a>
</div>
</p>
${footer}
</body>
</html>
