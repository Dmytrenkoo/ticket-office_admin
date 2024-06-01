<#import "admin_parts_templ/admin_managment.ftl" as p>
<@p.pages>

    <h2>Сторінка адміністрування потягів</h2>

    <h4>Форма для додавання нових потягів</h4>

    <form action="/saveNewTrain" method="post">

        <label for="trainId">Номер потяга</label><br>
        <input type="text" name="trainNumber" placeholder="trainNumber" id="trainNumber"><br>
        <#--        <br>-->
        <label for="seats">Кількість місць</label><br>
        <input type="text" name="seats" placeholder="seats" id="seats"><br>
        <#--        <br>-->
        <label for="type">Тип потяга</label><br>
        <select name="type" class="custom-select-form">
                <option value="швидкісний">швидкісний</option>
                <option value="високошвидкісний">високошвидкісний</option>
        </select>
        <#--        <br>-->
        <br>
        <br>

        <input type="submit" value="Додати новий потяг">

    </form>
    <hr>
    <br>
    <h4> Перегляд, оновлення та видалення потягів </h4>
    <table class="table table-striped">
        <thead>
        <tr>
            <td>id</td>
            <th>№ потяга</th>
            <th>Кількість місць</th>
            <th>Тип потяга</th>
            <td>update</td>
            <td>delete</td>
        </tr>
        </thead>
        <tbody>
        <#list trains as train>
            <tr>

                <form action="/updateTrain" method="post">

                    <td>${train.id}</td>
                    <td><input type="text" name="trainNumber" value="${train.trainNumber}"></td>
                    <td><input type="text" name="seats" value="${train.seats}"></td>
                    <td>
                        <select name="type" class="custom-select">
                            <option value="Швидкісний" <#if train.type == "Швидкісний">selected</#if>>Швидкісний</option>
                            <option value="Високошвидкісний" <#if train.type == "Високошвидкісний">selected</#if>>Високошвидкісний</option>
                        </select>
                    </td>
                    <td>

                        <input type="hidden" name="id" value="${train.id}">
                        <input type="submit" value="update"></td>
                </form>

                <td>
                    <form action="/deleteTrain" method="post">
                        <input type="hidden" name="id" value="${train.id}">
                        <input type="submit" value="delete">
                    </form>
                </td>
            </tr>
        </#list>

        </tbody>
    </table>
    <hr>
    <br>
    <h4>Очистка всіх потягів</h4>
    <form method="post" action="deleteAllTrains">
        <button type="submit"> Видалити всі потяги</button>
    </form>


</@p.pages>

<style>
    .custom-select {
        width: 100%;
        box-sizing: border-box;
        margin-bottom: 10px;
    }

    input[type="text"], input[type="number"], .custom-select-form {
        width: 25%;
        box-sizing: border-box;
        margin-bottom: 10px;
    }

    input[type="submit"], button[type="submit"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
        border-radius: 4px;
    }


    .table {
        width: 100%;
        border-collapse: collapse;
        text-align: center;
    }

    .table th, .table td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: center;
        vertical-align: middle; /* Вирівнювання по вертикалі */
    }

    .table th {
        background-color: #f2f2f2;
        text-align: center;
    }
</style>