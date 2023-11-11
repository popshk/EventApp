<#import "parts/common.ftlh" as common>
<@common.page>
    <h2>Registration form</h2>
    <br>
    <form class="rf" method="post" action="/registration">
        <input class="form-control me-2 flex-grow-1" type="text" name="username" id="username" placeholder="Username">
        <#if errorUsername??>
            <div class="alert alert-danger" role="alert">
                ${errorUsername}
            </div>
        </#if>
        <input class="form-control me-2 flex-grow-1" type="text" name="email" id="email" placeholder="E-mail">
        <#if errorEmail??>
            <div class="alert alert-danger" role="alert">
                ${errorEmail}
            </div>
        </#if>
        <input class="form-control me-2 flex-grow-1" type="password" name="password" id="password"
               placeholder="Password">
        <#if errorPassword??>
            <div class="alert alert-danger" role="alert">
                ${errorPassword}
            </div>
        </#if>
        <input class="form-control me-2 flex-grow-1" type="password" name="confirm-password" id="confirm-password"
               placeholder="Confirm password">
        <#if errorPasswordConfirmation??>
            <div class="alert alert-danger" role="alert">
                ${errorPasswordConfirmation}
            </div>
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-success custom-btn-width-2" type="submit">Submit</button>
    </form>
    <p>Already have an account?</p>
    <button class="btn btn-outline-success custom-btn-width-2" onclick="location.href='/login'" id="registration-button"
            style="display: block; margin: auto;">login
    </button>
</@common.page>