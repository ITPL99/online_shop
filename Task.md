Техническое задание на консольное приложение "Онлайн-магазин"

Написать консольное приложение на Java-core 8.
Основной функционал приложение и пользователя это ввод команд через консоль приложения.
Приложение должно иметировать работу онлайн магазина и нужный функционал.
Основные команды приложения примедены ниже.
Приложение должно быть написанно по ООП-методологии с соблюдениями принципов SOLID.

пример работы приложения:
В консоль вводится команда register далее происходит регистрация пользователя в системе. Приложение просит ввести
пользователя все нужные для коректной работы данные (Имя, логин, пароль). после чего пользователь сохроняется
в системе и ждет аунтентификации.
При вводе команды login приложение просит ввести логин и пароль пользователя после чего проверяет данные пользователя и его авторезирует.
при проверке система проверяет есть ли зарегестрированный пользователь в системе и проверяет коректность его данных. таких как пароль.

Перед написанием приложения нужно написать алгоритм приложения и нарисовать блок схему по данному алгоритму.
Только после реализации алгоритма приступить к написанию приложения.



    3.3. Команды консоли:
            register - регистрация нового пользователя.
            login - авторизация пользователя.
            logout - выход из учетной записи.
            catalog - просмотр каталога товаров.
            search [запрос]: поиск товара по названию или описанию.
            add_to_cart [ID товара]: добавление товара в корзину.
            cart - просмотр корзины покупок.
            checkout - оформление заказа.
            orders - просмотр истории заказов (для покупателей).
            add_product - добавление нового товара (для продавцов).
            all_new_product - вывод новых товаров которые появились у поставщиков (Для продавца)
            update_product [ID товара] - редактирование товара (для продавцов).
            update_stock [ID товара] [новое количество]: обновление количества товара (для поставщиков).
            leave_review [ID товара] [оценка] [текст отзыва]: оставить отзыв о товаре (для покупателей).
            help - вывод списка команд с описание для каждого пользователя свой список команд

    Дополнительные требования
        Читабельный и документированный код.
        Обработка некорректных входных данных.

    Результат работы
        Исходный код консольного приложения.
        Документация с описанием классов, методов и инструкцией по запуску.


            Команды для пользователей системы:
                    exit - Завершение программы
                    help - вывод списка команд
                    register - регистрация пользователя: Покупатель продавец или поставщик
                    login - логин и пароль пользователя и вход в систему
                    get_all_users - вывод всех пользователей системы
                    info - информация об авторизированном пользователе
                    logout - выход пользователя из системы
                    user_by_param [ login, name, id ] - поиск пользователя по параметрам (Возможен вывод списка)


               Поставщик:
                    add_item - добавление товара в систему (товары могут повторяться если поставщики разные).
                    add_shop - добавление магазина для поставки товаров.
                    info_shops - вывод информации о магазинах на которые оформлена доставка товара.
                    info_items - вывод списка своих товаров и их количества (Товары повторяться не должны).
                    update_item - изменение данных продукта (к примеру изменение цены или изменение количества).
                    add_post - добавление публикации в систему.
                    all_shop - вывод списка магазинов к которым оформлена поставка.
                    shop_by_id - вывод магазина по идентификатору.
                    shops_by_parameter - поиск магазинов по параметра ( которые оформили заявку на товары).

                Продавец:
                     all_items - список своих товаров
                     all_shops - список магазинов (Совбственных фелиалов)
                     add_cotalogs - добавление нового типа товаров. (Тип товара должен быть один общий для всех продавцов)
                     all_orders - вывод списка оформленых заказов
                     info_shop - вывод информации о магазине (имя магазина, общее количество товаров, адрес количество сотрудников, средняя выручка)
                     all_provider - вывод списка поставщиков
                     serch_provider [id, name, login, item .... ] - поиск поставщика по параметрам (Возможно вернет список)
                     all_news_posts - вывод новостей системы ( новые товары от поставщика, публикации от магазина)
                     add_post - добавление публикации в систему
                     posts_by_login - поиск публикации по пользотвателю
                     posts_by_id - вывод публикации по индефикациономму номеру
                     posts_by_tag - вывод публикаций по тэгу
                     update_item - изменение данных продукта ( к примеру изменение цены или изменение количесва)
                     make_request - оформление заявки на провайдера

                Покупатель:
                    all_items - вывод всех товаров в системе
                    all_shops - Список магазинов
                    all_salesman - список продавцов
                    cotalogs - вывод списка типов товаров
                    set_item [ id ] - добавление товара в корзину
                    cart - просмотр карзины
                    check_cart - оформление заказа
                    orders - просмотр списка заказов
                    all_news_posts - вывод новостей системы (публикации от магазина) <Публикации от поставщиков выводиться не должно!!!>


