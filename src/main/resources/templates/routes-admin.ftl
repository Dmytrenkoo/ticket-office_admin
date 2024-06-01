<#import "admin_parts_templ/admin_managment.ftl" as p>
<@p.pages>

    <h2 class="title">Сторінка адміністрування маршрутів</h2>

    <h4>Форма для додавання нових маршрутів</h4>

    <form action="/saveNewRoute" method="post">

        <label for="trainId">Станція відбуття</label><br>
        <input type="text" name="departureStation" placeholder="departureStation" id="departureStation"><br>
        <#--        <br>-->
        <label for="seats">Станція прибуття</label><br>
        <input type="text" name="arrivalStation" placeholder="arrivalStation" id="arrivalStation"><br>
        <#--        <br>-->
        <label for="departureTime">Час поїздки</label><br>
        <input type="text" name="travelTime" placeholder="travelTime" id="travelTime"><br>
        <#--        <br>-->
        <br>
        <br>

        <input type="submit" value="Додати новий маршрут">

    </form>
    <hr>
    <br>
    <h4> Перегляд, оновлення та видалення маршрутів </h4>
    <table class="table table-striped">
        <thead>
        <tr>
            <td>id</td>
            <th>Станція посадки</th>
            <th>Станція прибуття</th>
            <th>Час поїздки</th>
            <td>update</td>
            <td>delete</td>
        </tr>
        </thead>
        <tbody>
        <#list routes as route>
            <tr>

                <form action="/updateRoute" method="post">

                    <td>${route.id}</td>
                    <td><input type="text" name="departureStation" value="${route.departureStation}"></td>
                    <td><input type="text" name="arrivalStation" value="${route.arrivalStation}"></td>
                    <td><input type="text" name="travelTime" value="${route.travelTime}"></td>
                    <td>

                        <input type="hidden" name="id" value="${route.id}">
                        <input type="submit" value="update"></td>
                </form>

                <td>
                    <form action="/deleteRoute" method="post">
                        <input type="hidden" name="id" value="${route.id}">
                        <input type="submit" value="delete">
                    </form>
                </td>
            </tr>
        </#list>

        </tbody>
    </table>
    <hr>
    <form method="post" action="deleteAllRoutes">
        <button type="submit"> Видалити всі маршрути</button>
    </form>
</@p.pages>

<style>
    input[type="text"], input[type="number"]{
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