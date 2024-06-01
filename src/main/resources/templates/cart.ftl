<#import "user_templ/templ.ftl" as p>
<@p.pages>
    <h2> Cart </h2>

    <table class="table table-bordered">
        <tbody>
        <tr>
            <th>№</th>
            <th>Потяг №</th>
            <th>Вагон</th>
            <th>Місце</th>
            <th>Тип місця</th>
            <th>К-сть</th>
            <th>Ціна</th>
            <th>delete</th>
        </tr>
        </tbody>
        <tbody>
        <#if cart??>
            <#list cart as item>
                <#if item.tickets.id??>
                    <tr>
                            <input type="hidden" name="id" value="${item.tickets.id}">
                            <td>${item.tickets.id}</td>
                            <td>${item.tickets.trains.trainNumber}</td>
                            <td>${item.tickets.wagonNumber}</td>
                            <td>${item.tickets.seatNumber}</td>
                            <td>${item.tickets.seatType}</td>
                            <td>${item.quantity}</td>
                            <td>${item.tickets.price}</td>
                        <form action="/deleteItemFromCart" method="post">
                            <td>
                                <input type="hidden" name="id" value="${item.tickets.id}">
                                <button type="submit" class="btn btn-success">Delete</button>
                            </td>
                        </form>
                    </tr>
                </#if>
            </#list>
        </#if>
        </tbody>
    </table>

    <h5> Всього: ${total} </h5>
    <h5> К-сть квитків: ${el} </h5>
    <br>
    <form method="post" action="/deleteAllItem">
        <button class="btn btn-success" type="submit">Очистити кошик</button>
    </form>
<br>
    <form method="get" action="/order">
        <button type="submit" class="btn btn-success">Оформити замовлення</button>
    </form>


</@p.pages>