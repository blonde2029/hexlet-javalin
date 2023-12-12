@import org.example.hexlet.dto.NamedRoutes
@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <a href="${NamedRoutes.BuildUserPath()}">New User</a>
    @for(var user : page.getUsers())
        <div>
            <h2><a href="${NamedRoutes.UserPath(user.getId())}">${user.getName()}</a></h2>
        </div>
    @endfor
`
)
