<!doctype html>
<html lang="en" data-bs-theme="dark">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${param.title}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../../CSS/add-page.css" />
</head>
<body>
<script>
    (() => {
        'use strict';

        const getStoredTheme = () => localStorage.getItem('theme');
        const setStoredTheme = theme => localStorage.setItem('theme', theme);

        const getPreferredTheme = () => {
            const storedTheme = getStoredTheme();
            if(storedTheme) return storedTheme;

            const mediaQuery = '(prefers-color-scheme: dark)';
            const isDarkMode = window.matchMedia && window.matchMedia(mediaQuery).matches;
            return isDarkMode ? 'dark' : 'light';
        };

        const themeSwitchers = document.querySelectorAll('#loggedInDarkModeBtn, #loggedOutDarkModeBtn'); // Changed ID
        const body = document.querySelector('body');

        const switchTheme = theme => {
            body.setAttribute('data-bs-theme', theme);
            setStoredTheme(theme);
        };

        window.addEventListener('load', () => {
            const theme = getPreferredTheme();
            switchTheme(theme);
        });

        themeSwitchers.forEach((btn) => {
            btn.addEventListener('click', () => {
                const newTheme = getStoredTheme() === 'dark' ? 'light' : 'dark';
                switchTheme(newTheme);
            });
        });
    })();
</script>
</body>
</html>
