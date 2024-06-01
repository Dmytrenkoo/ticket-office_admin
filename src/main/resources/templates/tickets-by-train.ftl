<#import "user_templ/templ.ftl" as p>
<@p.pages>

    <h2 class="title"> Квитки </h2>

    <div class="row row-cols-2 row-cols-md-4 g-4">

        <#if ticketsByTrain??>
            <#list ticketsByTrain as tickets>
                <form action="/addToCart" method="post">
                    <div class="col">
                        <div class="card">
                            <input type="hidden" name="id" value="${tickets.id}">
                            <div class="card-body text-center">
                                <h5 class="card-title">номер квитка №${tickets.id}</h5>
                                <p> Номер потяга №${tickets.trains.id} </p>
                                <p class="card-text">Вагон: ${tickets.wagonNumber} Місце: ${tickets.seatNumber} </p>
                                <p> Тип: ${tickets.seatType}</p>
                                <input type="hidden" name="quantity" value="1">
                                <p> Ціна: ${tickets.price}</p>
                            </div>
                            <button type="submit">Купити</button>

                        </div>
                    </div>
                </form>
            </#list>
        </#if>
    </div>
</@p.pages>