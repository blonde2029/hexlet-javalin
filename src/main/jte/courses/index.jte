@import org.example.hexlet.dto.NamedRoutes
@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(content = @`
        <h1>${page.getHeader()}</h1>
        @if(page.getCourses().isEmpty())
            <p>Пока не добавлено ни одного курса</p>
        @else
            <form action="/courses" method="get">
                <input type="search" name="term" value="${page.getTerm()}" />
                <input type="submit" value="search" />
            </form>
            @for(var course : page.getCourses())
               <div>
                   <h2><a href="${NamedRoutes.CoursePath(course.getId())}">${course.getName()}</a></h2>
                   <p>${course.getDescription()}</p>
               </div>
            @endfor
        @endif
    <a href="${NamedRoutes.BuildCoursePath()}">New course</a>
`)
