@import org.example.hexlet.dto.courses.BuildCoursePage
@param BuildCoursePage page
@if (page.getErrors() != null)
    <ul>
        @for (var validator : page.getErrors().values())
            @for (var error : validator)
                <li>${error.getMessage()}</li>
            @endfor
        @endfor
    </ul>
@endif
<form action="/courses" method="post">
    <div>
        <label>
            Course name
            <input type="text" name="title" value="${page.getTitle()}"/>
        </label>
    </div>
    <div>
        <label>
            Description
            <input type="text" name="description" value="${page.getDescription()}"/>
        </label>
    </div>
    <input type="submit" value="Create"/>
</form>