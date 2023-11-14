<#import "parts/common.ftlh" as common>
<@common.page>
    <#if user??>
        <#if events??>
            <#list events as event>
                <a href="/event/${event.id}">${event.name} ${event.getFormattedDate()}
            </#list>
        <#else>
            <p>Empty yet.</p>
        </#if>
    </#if>
    <#include "parts/navigation.ftlh">
</@common.page>