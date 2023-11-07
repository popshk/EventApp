<#assign known = Session.SPRING_SECURITY_CONTEXT??>
<#if known>
    <#assign
    customer = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name =  customer.getUsername()
    isAdmin = customer.isAdmin()
    >
<#else>
    <#assign
    name = "Guest"
    isAdmin = false
    >
</#if>