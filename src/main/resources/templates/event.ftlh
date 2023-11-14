<#import "parts/common.ftlh" as common>
<@common.page>
  <h1>${event.name}</h1>
       <h2>${event.getFormattedDate()}</h2>
<#--    <p>${event.eventLocation}</p>-->
    <p>Members:</p>
            <#list event.getMembers() as member>
                <p><a href="/user/${member.id}">${member.username}</p>
            </#list>
</@common.page>