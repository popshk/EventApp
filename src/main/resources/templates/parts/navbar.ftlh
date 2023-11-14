<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid d-flex justify-content-center">
        <div class="collapse navbar-collapse justify-content-center" id="navbarSupportedContent">
            <ul class="navbar-nav mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link fs-5" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item dropdown fs-5">
                    <a class="nav-link dropdown-toggle" href="/profile" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">Profile</a>
                    <ul class="dropdown-menu">
                        <#if user??>
                            <li><a class="dropdown-item" href="/profile" id="profileLink">${user.username}</a></li>
                            <li><a class="dropdown-item" href="/logout" id="logoutLink">Logout</a></li>
                        <#else>
                            <li><a class="dropdown-item" href="/login" id="loginLink">Login</a></li>
                            <li><button id="openModalButton" class="dropdown-item" >Registration</button></li>
                        </#if>
                    </ul>
                </li>
<#--                <#if isAdmin>-->
<#--                    <li class="nav-item">-->
<#--                        <a class="nav-link fs-5" aria-current="page" href="/admin-panel">Admin Panel</a>-->
<#--                    </li>-->
<#--                </#if>-->
            </ul>
        </div>
    </div>
</nav>
<#include "registration-form.ftlh">