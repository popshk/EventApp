<#import "parts/common.ftlh" as common>
<@common.page>
    <form class="rf" method="post" action="/profile">
        <input class="form-control me-2 flex-grow-1" type="text" id="username" name="username" placeholder="Username" value="${user.username}">
        <input class="form-control me-2 flex-grow-1" type="text" id="email" name="email" placeholder="Email" value="<#if user.email??>${user.email}</#if>">
        <input class="form-control me-2 flex-grow-1" type="text" id="firstName" name="firstName" placeholder="First Name" value="<#if user.firstName??>${user.firstName}</#if>">
        <input class="form-control me-2 flex-grow-1" type="text" id="lastName" name="lastName" placeholder="Last Name" value="<#if user.lastName??>${user.lastName}</#if>">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-success custom-btn-width-3" type="submit">Submit</button>
    </form>

    <form class="rf" method="post" action="/profile/changePassword">
        <input class="form-control me-2 flex-grow-1" type="password" id="currentPassword" name="currentPassword"
               placeholder="currentPassword" required>
        <input class="form-control me-2 flex-grow-1" type="password" id="newPassword" name="newPassword"
               placeholder="newPassword" required>
        <input class="form-control me-2 flex-grow-1" type="password" name="confirm-password" id="confirm-password"
               placeholder="Confirm password">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-success custom-btn-width-3" type="submit">Submit</button>
    </form>
</@common.page>