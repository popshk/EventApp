<#import "parts/common.ftlh" as common>
<@common.page>
<#list events as event>
    <p>${event}</p>
</#list>
<#include "parts/navigation.ftlh">
</@common.page>