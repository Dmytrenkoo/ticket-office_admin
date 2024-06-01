<#import "/spring.ftl" as spring>
<#import "user_templ/forms_templ.ftl" as p>
<@p.pages>

    <h2 class="title"> Реєстрація </h2>

    <div class="container">
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <form action="/registration" method="post" style="text-align: center;">
                    <@spring.bind "users"/>

                    <label for="username">Імʼя користувача</label><br>
                    <@spring.formInput "users.username" ' placeholder="username"'/><br>
                    <@spring.showErrors "<br>"/>

                    <label for="password">Пароль</label><br>
                    <@spring.formInput "users.password" ' placeholder="password"'/><br>
                    <@spring.showErrors "<br>"/>

                    <@spring.bind "passengers"/>
                    <label for="firstName">Ім'я</label><br>
                    <@spring.formInput "passengers.firstName" ' '/><br>
                    <@spring.showErrors "<br>"/>

                    <label for="lastName">Прізвище</label><br>
                    <@spring.formInput "passengers.lastName" ' '/><br>
                    <@spring.showErrors "<br>"/>

                    <label for="phone">Номер телефону</label><br>
                    <@spring.formInput "passengers.phone" ' '/><br>
                    <@spring.showErrors "<br>"/>

                    <label for="email">Електронна адреса</label><br>
                    <@spring.formInput "passengers.email" ' '/><br>
                    <@spring.showErrors "<br>"/>

                    <input class="btn btn-primary" type="submit" placeholder="Реєстрація" value="Реєстрація
">
                    <#--<button type="submit" value="addNewUser">Реєстрація</button>-->
                </form>
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</@p.pages>

<style>
    input[type=text], select {
        width: 50%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=password], select {
        width: 50%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    label {
        text-align: left;
        display: inline-block;
        width: 50%;
    }
</style>