<#import "admin_parts_templ/admin_tools.ftl" as p>
<@p.pages>

    <h2> Адміністування користувачів </h2>


    <table>
        <thead>
        <tr>
            <th class="col-1">id</th>
            <th class="col-1">Логін</th>
            <th class="col-6 me-2">Пароль</th>
            <th class="col-4">Ролі</th>
        </tr>
        </thead>
        <tbody>
        <#if users??>
            <#list users as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td><#if user.rolesset??>
                            <#list user.rolesset as role>
                                ${role.name},
                            </#list>

                        </#if></td>
                </tr>
            </#list>
        </#if>

        </tbody>


    </table>



</@p.pages>