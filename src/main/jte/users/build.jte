@import org.example.hexlet.dto.users.BuildUserPage
@param BuildUserPage page

@if (page.getErrors() != null)
    <ul>
        @for (var validator : page.getErrors().values())
            @for (var error : validator)
                <li>${error.getMessage()}</li>
            @endfor
        @endfor
    </ul>
@endif

@template.layout.page(page = page, content = @`
<form action="/users" method="post">
    <div>
        <label>
            Name
            <input type="text" name="name" value="${page.getName()}"/>
        </label>
    </div>
    <div>
        <label>
            Email
            <input type="email" required name="email" value="${page.getEmail()}"/>
        </label>
    </div>
    <div>
        <label>
            Password
            <input type="password" required name="password" />
        </label>
    </div>
    <div>
        <label>
            Confirm password
            <input type="password" required name="passwordConfirmation" />
        </label>
    </div>
    <input type="submit" value="Register" />
</form>
`)