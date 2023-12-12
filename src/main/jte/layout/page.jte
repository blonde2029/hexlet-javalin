@import gg.jte.Content
@import org.example.hexlet.dto.NamedRoutes
@param Content content
@param Content footer = null

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
