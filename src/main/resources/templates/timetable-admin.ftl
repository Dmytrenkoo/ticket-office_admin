<#import "admin_parts_templ/admin_managment.ftl" as p>
<@p.pages>

    <h2 class="title">Сторінка адміністрування рейсів</h2>

    <h4>Форма для додавання нових розкладів</h4>

    <form action="/saveNewTimetable" method="post">

        <label for="trains" class="custom-select-form">Номер потяга</label><br>
        <select name="trains">
            <#list trains as train>
                <option value="${train.id}">${train.trainNumber}</option>
            </#list>
        </select><br>
        <#--        <br>-->
        <label for="arrivalDateTime">Дата та час прибуття</label><br>
        <input type="text" name="arrivalDateTime" placeholder="dd.MM.yyyy HH:mm" id="arrivalDateTime"><br>

        <label for="departureTime">Час відправлення</label><br>
        <input type="text" name="departureTime" placeholder="HH:mm" id="departureTime"><br>

        <label for="route">Маршрут</label><br>
        <select name="route" class="custom-select-form">
            <#list routes as rout>
                <option value="${rout.id}">${rout.departureStation}-${rout.arrivalStation},
                    ${rout.travelTime}год</option>
            </#list>
        </select>
        <br>
        <br>

        <input type="submit" value="Додати новий рейс">

    </form>
    <hr>
    <br>
    <h4> Перегляд, оновлення та видалення рейсів </h4>
    <table class="table table-striped">
        <thead>
        <tr>
            <td>id</td>
            <th>№ потяга</th>
            <th>Час відправлення</th>
            <th>Дата та часа прибуття</th>
            <th>Маршрут</th>
            <td>update</td>
            <td>delete</td>
        </tr>
        </thead>
        <tbody>
        <#list trainHasRoutes as thr>
            <tr>

                <form action="/updateTimetable" method="post">

                    <td>${thr.id}</td>
                    <td>
                        <select name="trains" class="custom-select">
                            <#list trains as train>
                                <option value="${train.id}">${train.trainNumber}</option>
                            </#list>
                        </select>
                    </td>
                    <td><input type="text" id="date-input" name="arrivalDateTime" value="${thr.arrivalDateTime?string("dd.MM.yyyy HH:mm")}" placeholder="dd.MM.yyyy HH:mm"></td>
                    <td><input type="text" name="departureTime" value="${thr.departureTime}"></td>
                    <td>
                        <select name="routes" class="custom-select">
                            <#if routes??>
                                <#list routes as r>
                                    <#if thr.routes.id==r.id>
                                        <option value="${r.id}">${r.departureStation}-${r.arrivalStation},
                                            ${r.travelTime}год</option>
                                    <#else>
                                        <option value="${r.id}">${r.departureStation}-${r.arrivalStation},
                                            ${r.travelTime}год</option>
                                    </#if>
                                </#list>
                            </#if>
                        </select>
                    </td>
                    <td>

                        <input type="hidden" name="id" value="${thr.id}">
                        <input type="submit" value="update"></td>
                </form>

                <td>
                    <form action="/deleteTimetable" method="post">
                        <input type="hidden" name="id" value="${thr.id}">
                        <input type="submit" value="delete">
                    </form>
                </td>
            </tr>
        </#list>

        </tbody>
    </table>
    <hr>
    <br>
    <form method="post" action="deleteAllTimetables">
        <button type="submit"> Видалити всі рейси</button>
    </form>


</@p.pages>

<style>

    #date-input{
        width: 50%;
        box-sizing: border-box;
        margin-bottom: 10px;
    }

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