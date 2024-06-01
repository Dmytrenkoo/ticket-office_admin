<#import "user_templ/templ.ftl" as p>
<#assign pageTitle = "Моя сторінка">
<@p.pages>

    <h2> Інформація про пасажира</h2>
    <div class="container">
    <table class="table table table-bordered">

        <thead>
        <tr>
            <th>Ім'я</th>
            <th>Прізвище</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <#if passengers??>
            <#if passengers.id??>
                <tr>
                    <td>${passengers.firstName}</td>
                    <td>${passengers.lastName}</td>
                    <td>${passengers.email}</td>
                </tr>
            </#if>
        </#if>
        </tbody>
    </table>
    </div>

    <h2> Інформація про замовлення </h2>
    <div class="container">
    <table class="table table table-bordered">

        <thead>
            <th>Номер</th>
            <th>Кількість</th>
            <th>Ціна</th>
        </tr>
        </thead>
        <tbody>

        <#if cart??>
            <#list cart as item>
                <#if item.tickets.id??>
                    <tr>
                        <td>${item.tickets.id}</td>
                        <td>${item.quantity}</td>
                        <td>${item.tickets.price}</td>
                    </tr>
                </#if>
            </#list>
        </#if>
        </tbody>
    </table>
    </div>
    <p> Всього : ${total} </p>
    <p> Кількість асотиментних позицій у замовленні: ${el}</p>


    <form action="/buy" method="post">
        <h2> Вибір способу оплати </h2>
        <select name="payment">
            <option value="1">GooglePay</option>
            <option value="2">Банківська карта</option>
        </select>
<br>
<br>
        <button type="submit" class="btn btn-success">Підтведити замовлення</button>
    </form>
</@p.pages>