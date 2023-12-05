@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page
@template.layout.page(content = @`
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<main>
    <h1>${page.getCourse().getName()}</h1>
    <p>${page.getCourse().getDescription()}</p>
</main>
</body>
</html>
`)