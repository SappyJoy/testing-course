# Use-cases
## 1. Вход
1. Переход на https://www.fiverr.com/
2. Нажатие на кнопку входа `xpath = "//a[text() = 'Sign in']"` -> Всплывает поле для ввода данных пользователя
3. Ввод имени пользователя в поле `xpath = "//input[@id=\"login\"]"
4. Ввод пароля в поле `xpath = "//input[@type=\"password\"]"`
5. Нажатие на кнопку продолжить `xpath = "//button[@type=\"submit\"]"` -> Переносит обратно на главную страницу
6. Переходим в профиль 
	1. Нажимаем на выпадающее меню `xpath = "//button[@class = 'nav-popover-items-toggler']"`
	2. Нажимаем на меню Профиль `xpath = "//a[text() = 'Profile']"`
7. Проверяем, что имя пользователя совпадает с текстом в поле `xpath = "//div[@class = 'username-line']"` 

## 2. Создание заказа
Предусловие - необходимо быть авторизованным

1. Нажимаем на выпадающее меню `xpath = "//button[@class = 'nav-popover-items-toggler']"`
2. Выбираем *Post a Request* `xpath = //*[@id="Header"]/header/div/div/nav/ul/li[5]/div/aside/ul/li[4]/a` -> Оказываемся на странице с заполнением информации о заказе
3. Заполняем поля
	1. Заполняем textarea описания себя `xpath = //*[@id="__ZONE__main"]/div/div/div/div[2]/div/div[2]/section/section[1]/div/textarea`
	2. Заполняем то, что нас интересует `xpath = //*[@id="__ZONE__main"]/div/div/div/div[2]/div/div[2]/section/section[2]/div/textarea`
	3. Выбираем категорию запроса
		1. Нажимаем на выпадающий список `xpath = //*[@id="__ZONE__main"]/div/div/div/div[2]/div/div[2]/section/section[3]/div/span/div`
		2. Выбираем самую первую категорию в списке `xpath = /html/body/div[5]/aside/div/aside/section[1]/ul/li`
	4. Нажимаем кнопку продолжить `xpath = //*[@id="__ZONE__main"]/div/div/div/footer/button`
	5. Выбираем запрос без дедлайна `xpath = //*[@id="__ZONE__main"]/div/div/div/div[2]/div/div[2]/section/section[1]/section[1]/button[2]`
	6. Заполняем поле бюджет значением 250 `xpath = //*[@id="__ZONE__main"]/div/div/div/div[2]/div/div[2]/section/section[2]/section[2]/div/div/div/input`
	7. Нажимаем кнопку Review Your Brief `xpath = //*[@id="__ZONE__main"]/div/div/div/footer/button[2]`
	8. Нажимаем кнопку Send Brief `xpath = //*[@id="__ZONE__main"]/div/div/div/footer/button[2]`
4. Нажимаем Got it `xpath = //*[@id="__ZONE__main"]/div/div/section/a`
5. Нажимаем на кнопку Notifications `xpath = //*[@id="Header"]/header/div/div/nav/ul/li[2]/div/div[2]/span/div/span/button`
6. Переходим по последнему уведомлению `xpath = //*[@id="62814386a8dc0c0010a90dd4"]`
7. Проверяем значение в поле Budget `xpath = //*[@id="__ZONE__main"]/div/div/div/div[2]/ul[1]/li[1]/div/p` == 250
8. Проверяем описание запроса `xpath = //*[@id="__ZONE__main"]/div/div/div/div[2]/ul[2]/li/div/p`