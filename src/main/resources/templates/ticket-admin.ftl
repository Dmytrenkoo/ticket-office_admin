<#import "admin_parts_templ/admin_managment.ftl" as p>
<@p.pages>

    <h2 class="title">Сторінка адміністрування квитків</h2>

    <hr>
    <h4>Форма для додавання нових квитків</h4>

    <form action="/saveNewTicket" method="post">

        <label for="wagonNumber">Номер вагону</label><br>
        <input type="text" id="wagonNumber" name="wagonNumber" placeholder="wagonNumber"><br>

        <label for="seatNumber">Номер місця</label><br>
        <input type="text" id="seatNumber" name="seatNumber" placeholder="seatNumber"><br>

        <label for="seatType">Тип місця</label><br>
        <select name="seatType" class="custom-select-form">
            <option value="Купе">Купе</option>
            <option value="Плацкарт">Плацкарт</option>
        </select><br>

        <label for="price">Ціна</label><br>
        <input type="number" id="price" name="price" placeholder="price"><br>

        <label for="trains">Потяг</label><br>
        <select name="trains" class="custom-select-form">
            <#list trains as train>
                <option value="${train.id}">${train.trainNumber}</option>
            </#list>
        </select><br>

        <input type="submit" value="Додати квиток">

    </form>
    <hr>
    <br>
    <h2>Перегляд, оновлення та видалення квитків</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <td>№</td>
            <td>Потяг №</td>
            <td>Вагон</td>
            <td>Місце</td>
            <td>Тип місця</td>
            <td>Ціна</td>
            <td>Оновити</td>
            <td>Видалити</td>
        </tr>
        </thead>
        <tbody>
        <#list tickets as ticket>
            <tr>
                <form action="/updateTicket" method="post">
                    <td>${ticket.id}</td>
                    <td>
                        <select name="trains" class="custom-select">
                            <#if trains??>
                                <#list trains as t>
                                    <#if ticket.trains.id == t.id>
                                        <option value="${t.id}" selected>${t.trainNumber}</option>
                                    <#else>
                                        <option value="${t.id}">${t.trainNumber}</option>
                                    </#if>
                                </#list>
                            </#if>
                        </select>
                    </td>
                    <td><input type="text" name="wagonNumber" value="${ticket.wagonNumber}"></td>
                    <td><input type="text" name="seatNumber" value="${ticket.seatNumber}"></td>
                    <td>
                        <select name="seatType" class="custom-select">
                            <option value="Купе" <#if ticket.seatType == "Купе">selected</#if>>Купе</option>
                            <option value="Плацкарт" <#if ticket.seatType == "Плацкарт">selected</#if>>Плацкарт</option>
                        </select>
                    </td>
                    <td><input type="number" name="price" value="${ticket.price?c}"></td>
                    <td>
                        <input type="hidden" name="id" value="${ticket.id}">
                        <input type="submit" value="Upd">
                    </td>
                </form>
                <td>
                    <form method="post" action="/deleteTicket">
                        <input type="hidden" name="id" value="${ticket.id}">
                        <input type="submit" value="Del">
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
    <hr>
    <br>
    <h4>Видалення усіх квитків</h4>
    <form method="post" action="deleteAllTickets">
        <button type="submit"> Видалити всі квитки</button>
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