<div class="mix">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid" style="margin-bottom: 25px">
            <a class="navbar-brand" href="/templates/index-user.ftl">
                <img src="/static/images/logo.png" alt="logo" style="width:100px;height:100px;">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="/">Головна</a></li>
                    <li class="nav-item"><a class="nav-link" href="/timetable">Розклад</a></li>
                </ul>
                <form class="d-flex" method="get" action="/cart">
                    <button class="btn btn-success me-2" type="submit">
                        <i class="bi bi-cart-check-fill"></i> Кошик
                    </button>
                </form>
            </div>
        </div>
    </nav>
</div>
