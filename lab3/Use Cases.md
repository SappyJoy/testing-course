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