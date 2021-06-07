## 07/06/2021
    - @PreAuthorize("hasAuthority('student:write')")
    - .csrf().disable() -> disable. nếu không disable thì hacker có thể dùng csrf token để call post, put, delete
    - csrf token in cookies
    - .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) -> to see : how to generate csrf token
## 07/06/2021
    - Form Based Auth
        + Username and password
        + Standard in most website
        + Forms (full control)
        + can logout
        + Https recommended (đề nghị)
    - To see session Id : F12 -> application -> cookies ->