<#import "user_templ/forms_templ.ftl" as p>
<@p.pages>

    <div class="container">
            <div class="d-flex justify-content-center">

            <form action="/login" method="post">
                <label for="username">Імʼя користувача</label>
                <input type="text" name="username" placeholder="user" id="username" class="form-control mb-3">

                <label for="password">Пароль</label>
                <input type="password" name="password" placeholder="password" id="password" class="form-control mb-3">
                <br>
                <input type="submit" value="Вхід" class="btn btn-primary btn-block mb-3">
                <br>
                <a class="nav-link active" href="/registration">Реєстрація</a>
            </form>

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