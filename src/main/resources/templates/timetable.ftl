<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Розклад</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
<div id="main-page">
    <div id="header">
        <div id="header_line">
            <div id="logo">
                <a href="index.ftl">
                    <img src="/static/images/logo.png" alt="logo" style="width:100px;height:100px;">
                </a>
            </div>
        </div>
    </div>
    <div id="main_section">
        <div id="main_content" style="min-height: 63px; background: lightpink">
            <div id="search">
                <div id="tab" class="tab-content" style="display:block;">
                    <form id="dir" method="post" action="/templates/rozklad.ftl">
                        <div class="clearfix" style="padding: 1%">
                            <div class="form-row">
                                <div class="form-column column-to">
                                    <input type="text" name="dir_where" id="dir_where" value="" class="place ui-autocomplete-input required" autocomplete="off" aria-autocomplete="list" aria-haspopup="true" placeholder="Куди" data-required="Введіть станцію">
                                    <input type="hidden" name="st_where_id" value="0" id="st_where_id">
                                </div>

                                <div class="form-column column-when">
                                    <input type="text" name="dir_date" id="dir_date" value="" class="date datepicker hasDatepicker" placeholder="Коли" autocomplete="off" readonly="readonly">
                                </div>
                            </div>
                        </div>

                        <div class="advanced advanced1 clearfix" style="display: block;">
                            <div class="advanced_column advanced_column1">
                                <p>Час відправлення:</p>
                                <p>З
                                    <input type="text" name="dir_time_from" id="dir_time_from" value="" class="time timepicker hasTimepicker">        До
                                    <input type="text" name="dir_time_to" id="dir_time_to" value="" class="time timepicker hasTimepicker"></p>
                            </div>
                        </div>

                        <div class="tab_bottom clearfix">
                            <div class="submit_container">

                                <input type="submit" name="dir_submit" id="dir_submit" value="Знайти" class="submit_search"> </div>
                        </div>
                    </form>        </div>
            </div>

            <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper no-footer"><table class="schedule_table stacktable desktop dataTable no-footer" id="DataTables_Table_0" role="grid">
                    <thead>
                    <tr role="row"><th class="type_train sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Тип: activate to sort column ascending" style="width: 23px;">Тип</th><th class="number_train sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Номер: activate to sort column ascending" style="width: 44px;">Номер</th><th class="route sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Маршрут: activate to sort column ascending" style="width: 174px;">Маршрут</th><th class="arrival sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Прибытие: activate to sort column ascending" style="width: 66px;">Прибытие</th><th class="time_stay sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Стоянка: activate to sort column ascending" style="width: 70px;">Стоянка</th><th class="dispatch sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Отправление: activate to sort column ascending" style="width: 114px;">Отправление</th><th class="train_graph sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="График: activate to sort column ascending" style="width: 55px;">График</th><th class="sorting_disabled" rowspan="1" colspan="1" aria-label="" style="width: 10px;"></th></tr>
                    </thead>
                    <tbody>
























                    <tr role="row" class="odd">
                        <td><img src="/img/only_electr.png" alt="Пригородный" title="Пригородный"></td>
                        <td><a href="/raspisanie-elektrichki/6902--novozybkov--bryansk-orlovskij/">6902<wbr>/6304</a></td>
                        <td><a href="/raspisanie-po-stancyi/novozybkov/">
                                Новозыбков        </a> →
                            <a href="/raspisanie-po-stancyi/bryansk/">
                                Брянск</a>
                        </td>
                        <td><span class="_time">05.01</span></td>
                        <td>                            1 мин&nbsp;
                        </td>
                        <td><span class="_time">05.02</span></td>
                        <td><a href="/grafik-dvizheniya/6902--novozybkov--bryansk-orlovskij/"><img src="/img/chart2.png" alt="Особый график движения - посмотреть" title="Особый график движения - посмотреть"></a></td>


                        <td></td>

                    </tr><tr style="cursor: pointer; display: none;" id="blabla_tr" class="blbalcar blbalcar1 even" role="row"><td class="tr_type" style=""><img class="tr_icon tr_type_1" src="/img/car_psgr.png" alt=""></td><td><img class="tr_icon tr_type_1" src="/img/new_logo.png" alt=""></td><td id="blabla_row" class="num"><span id="cars_from" class="fs14">Робчик</span> → <span id="cars_where" class="fs14">Брянск</span></td><td colspan="2" style="padding:7px 0;padding-left: 14px;"><span class="slogan_bbc" style="vertical-align: middle;">Поездки через BlaBlaCar на автобусе или машине с водителем, которому по пути!</span></td><td class="responsive_table_fix"></td><td><div id="blabla_price"><span class="title_prise_bbc" style="white-space: nowrap"></span><br><span class="prise_bbc"><b id="min_price"></b></span></div></td><td colspan="2"><div id="blabla_loaded_data"><div id="blabla_button"><span class="btn-2action btn-s" id="blabla_btn_txt" style="white-space: nowrap">Подробнее</span></div></div></td><td class="responsive_table_fix"></td></tr><tr role="row" class="odd">
                        <td><img src="/img/only_electr.png" alt="Пригородный" title="Пригородный"></td>
                        <td><a href="/raspisanie-elektrichki/6301--pochep--novozybkov/">6301<wbr>/6903</a></td>
                        <td><a href="/raspisanie-po-stancyi/pochep/">
                                Почеп        </a> →
                            <a href="/raspisanie-po-stancyi/novozybkov/">
                                Новозыбков</a>
                        </td>
                        <td><span class="_time">08.04</span></td>
                        <td>                            1 мин&nbsp;
                        </td>
                        <td><span class="_time">08.05</span></td>
                        <td><a href="/grafik-dvizheniya/6301--pochep--novozybkov/"><img src="/img/chart1.png" alt="Ежедневный график движения - посмотреть" title="Ежедневный график движения - посмотреть"></a></td>


                        <td></td>

                    </tr><tr role="row" class="even">
                        <td><img src="/img/only_electr.png" alt="Пригородный" title="Пригородный"></td>
                        <td><a href="/raspisanie-elektrichki/6904--novozybkov--bryansk-orlovskij/">6904<wbr>/6306</a></td>
                        <td><a href="/raspisanie-po-stancyi/novozybkov/">
                                Новозыбков        </a> →
                            <a href="/raspisanie-po-stancyi/bryansk/">
                                Брянск</a>
                        </td>
                        <td><span class="_time">11.19</span></td>
                        <td>                            6 мин&nbsp;
                        </td>
                        <td><span class="_time">11.25</span></td>
                        <td><a href="/grafik-dvizheniya/6904--novozybkov--bryansk-orlovskij/"><img src="/img/chart1.png" alt="Ежедневный график движения - посмотреть" title="Ежедневный график движения - посмотреть"></a></td>


                        <td></td>

                    </tr><tr role="row" class="odd">
                        <td><img src="/img/only_electr.png" alt="Пригородный" title="Пригородный"></td>
                        <td><a href="/raspisanie-elektrichki/6303--bryansk-orlovskij--novozybkov/">6303<wbr>/6905</a></td>
                        <td><a href="/raspisanie-po-stancyi/bryansk/">
                                Брянск        </a> →
                            <a href="/raspisanie-po-stancyi/novozybkov/">
                                Новозыбков</a>
                        </td>
                        <td><span class="_time">12.36</span></td>
                        <td>                            1 мин&nbsp;
                        </td>
                        <td><span class="_time">12.37</span></td>
                        <td><a href="/grafik-dvizheniya/6303--bryansk-orlovskij--novozybkov/"><img src="/img/chart1.png" alt="Ежедневный график движения - посмотреть" title="Ежедневный график движения - посмотреть"></a></td>


                        <td></td>

                    </tr><tr role="row" class="even">
                        <td><img src="/img/only_electr.png" alt="Пригородный" title="Пригородный"></td>
                        <td><a href="/raspisanie-elektrichki/6906--novozybkov--bryansk-orlovskij/">6906<wbr>/6308</a></td>
                        <td><a href="/raspisanie-po-stancyi/novozybkov/">
                                Новозыбков        </a> →
                            <a href="/raspisanie-po-stancyi/bryansk/">
                                Брянск</a>
                        </td>
                        <td><span class="_time">15.25</span></td>
                        <td>                            1 мин&nbsp;
                        </td>
                        <td><span class="_time">15.26</span></td>
                        <td><a href="/grafik-dvizheniya/6906--novozybkov--bryansk-orlovskij/"><img src="/img/chart1.png" alt="Ежедневный график движения - посмотреть" title="Ежедневный график движения - посмотреть"></a></td>


                        <td></td>

                    </tr><tr role="row" class="odd">
                        <td><img src="/img/only_electr.png" alt="Пригородный" title="Пригородный"></td>
                        <td><a href="/raspisanie-elektrichki/6305--bryansk-orlovskij--novozybkov/">6305<wbr>/6907</a></td>
                        <td><a href="/raspisanie-po-stancyi/bryansk/">
                                Брянск        </a> →
                            <a href="/raspisanie-po-stancyi/novozybkov/">
                                Новозыбков</a>
                        </td>
                        <td><span class="_time">16.31</span></td>
                        <td>                            1 мин&nbsp;
                        </td>
                        <td><span class="_time">16.32</span></td>
                        <td><a href="/grafik-dvizheniya/6305--bryansk-orlovskij--novozybkov/"><img src="/img/chart1.png" alt="Ежедневный график движения - посмотреть" title="Ежедневный график движения - посмотреть"></a></td>


                        <td></td>

                    </tr><tr role="row" class="even">
                        <td><img src="/img/only_electr.png" alt="Пригородный" title="Пригородный"></td>
                        <td><a href="/raspisanie-elektrichki/6908--novozybkov--unecha/">6908</a></td>
                        <td><a href="/raspisanie-po-stancyi/novozybkov/">
                                Новозыбков        </a> →
                            <a href="/raspisanie-po-stancyi/unecha/">
                                Унеча</a>
                        </td>
                        <td><span class="_time">19.07</span></td>
                        <td>                            5 мин&nbsp;
                        </td>
                        <td><span class="_time">19.12</span></td>
                        <td><a href="/grafik-dvizheniya/6908--novozybkov--unecha/"><img src="/img/chart1.png" alt="Ежедневный график движения - посмотреть" title="Ежедневный график движения - посмотреть"></a></td>


                        <td></td>

                    </tr><tr style="cursor: pointer; display: none;" id="blabla_tr_2" class="blbalcar blbalcar2 odd" role="row"><td class="tr_type" style=""><img class="tr_icon tr_type_1" src="/img/car_psgr.png" alt=""></td><td><img class="tr_icon tr_type_1" src="/img/new_logo.png" alt=""></td><td id="blabla_row" class="num"><span id="cars_from_2" class="fs14">Робчик</span> → <span id="cars_where_2" class="fs14">Новозыбков</span></td><td colspan="2" style="padding:7px 0;padding-left: 14px;"><span class="slogan_bbc" style="vertical-align: middle;"><span style="">Поездки через BlaBlaCar</span> на автобусе или машине с водителем, которому по пути!</span></td><td class="responsive_table_fix"></td><td><div id="blabla_price"><span class="title_prise_bbc_2" style="white-space: nowrap"></span><br><span class="prise_bbc" id="min_price_2" style="font-weight:bold"></span></div></td><td colspan="2"><div id="blabla_loaded_data_2"><div id="blabla_button_2"><span class="btn-2action btn-s" id="blabla_btn_txt_2" style="white-space: nowrap">Подробнее</span></div></div></td><td class="responsive_table_fix"></td></tr><tr role="row" class="even">
                        <td><img src="/img/only_electr.png" alt="Пригородный" title="Пригородный"></td>
                        <td><a href="/raspisanie-elektrichki/6307--bryansk-orlovskij--novozybkov/">6307<wbr>/6909</a></td>
                        <td><a href="/raspisanie-po-stancyi/bryansk/">
                                Брянск        </a> →
                            <a href="/raspisanie-po-stancyi/novozybkov/">
                                Новозыбков</a>
                        </td>
                        <td><span class="_time">21.03</span></td>
                        <td>                            1 мин&nbsp;
                        </td>
                        <td><span class="_time">21.04</span></td>
                        <td><a href="/grafik-dvizheniya/6307--bryansk-orlovskij--novozybkov/"><img src="/img/chart2.png" alt="Особый график движения - посмотреть" title="Особый график движения - посмотреть"></a></td>


                        <td></td>

                    </tr></tbody>
                </table></div>
        </div>

        <div id="footer" class="clearfix">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-sm-4 col-md-3 item">
                        <h3>Services</h3>
                        <ul>
                            <li><a href="#">Web design</a></li>
                            <li><a href="#">Development</a></li>
                            <li><a href="#">Hosting</a></li>
                        </ul>
                    </div>
                    <div class="col-sm-4 col-md-3 item">
                        <h3>About</h3>
                        <ul>
                            <li><a href="#">Company</a></li>
                            <li><a href="#">Team</a></li>
                            <li><a href="#">Legacy</a></li>
                        </ul>
                    </div>
                    <div class="col-sm-4 col-md-3 item">
                        <h3>Careers</h3>
                        <ul>
                            <li><a href="#">Job openings</a></li>
                            <li><a href="#">Employee success</a></li>
                            <li><a href="#">Benefits</a></li>
                        </ul>
                    </div>
                    <div class="col-lg-3 item social"><a href="#"><i class="icon ion-social-facebook"></i></a><a href="#"><i class="icon ion-social-twitter"></i></a><a href="#"><i class="icon ion-social-snapchat"></i></a><a href="#"><i class="icon ion-social-instagram"></i></a>
                        <p class="copyright"> Рейка © 2024</p>
                    </div>
                </div>
            </div>
            <div class="left_side" style="bottom: auto;">
                <div class="div_1 div_white">
                </div>
            </div>
            <div class="right_side" style="bottom: auto;">
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>