<#import "parts/common.ftlh" as common>
<@common.page>
    <h1>Login</h1>
    <br>
    <form class="rf" method="post" action="/login">
        <input class="form-control me-2 flex-grow-1" type="text" id="username" name="username" placeholder="Username"
               required>
        <input class="form-control me-2 flex-grow-1" type="password" id="password" name="password"
               placeholder="Password" required>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-success custom-btn-width-3" type="submit">Submit</button>
    </form>
    <br>
    <p>Don't have an account yet? Rather join!</p>
    <button class="btn btn-outline-success custom-btn-width-3" onclick="location.href='/registration'"
            id="registration-button" style="display: block; margin: auto;">Registration
    </button>
</@common.page>