<#import "user_templ/search_menu.ftl" as p>
<@p.pages>
    <style> td{  text-align: center;}</style>
    <h2 class="title" >Розклад</h2>
    <div class="row g-4 justify-content-center">
        <div class="col-10">
            <div class="table-bordered">
                <table role="presentation" class="table table-bordered border-primary tall-row" >
                    <thead>
                    <tr>
                        <th scope="col">№ потяга</th>
                        <th scope="col">Дата</th>
                        <th scope="col">Час посадки-прибуття</th>
                        <th scope="col">Маршрут</th>
                        <th scope="col">Тривалість подорожі</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <#if trainHasRoutes??>
                    <#list trainHasRoutes as thr>
                    <tbody>
                    <tr>
                        <th scope="row"> ${thr.trains.trainNumber} </th>
                        <td> ${thr.arrivalDateTime?string("dd.MM.yyyy")} </td>
                        <td> ${thr.departureTime} - ${thr.arrivalDateTime?string("HH:MM")} </td>
                        <td> ${thr.routes.departureStation} - ${thr.routes.arrivalStation} </td>
                        <td> ${thr.routes.travelTime} </td>
                        <td>
                            <a class="btn btn-primary" href="/timetable/${thr.trains.trainNumber}" role="button">Квитки</a>
                        </td>
                    </tr>
                    </#list>
                    </#if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</@p.pages>

